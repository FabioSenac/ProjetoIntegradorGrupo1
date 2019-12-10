package com.bd.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bd.model.Abastecimento;
import com.bd.model.Posto;
import com.bd.model.SaidaAbast;
import com.bd.model.Veiculo;
import com.bd.repository.SaidaRepository;

import java.util.List;

@RestController
@RequestMapping("/saida")
public class SaidaAbasResource {
	
	@Autowired
	private SaidaRepository saidaRepository;	
	
	@RequestMapping(path = "/{vei_id}")
	ResponseEntity<?> getAbastByUserId(@PathVariable Long vei_id){
		  List<Abastecimento> ListAbas = saidaRepository.findAllBy(vei_id);

		SaidaAbast saida = new SaidaAbast();
		Veiculo veiculo = null;
		Posto post_caro = null;
		double vl_unit_caro = 0;
		Posto post_barato = null;
		double vl_unit_barato = 0;
		double media_Km = 0;
		double totlitros = 0;
		int odometro_ini = 0;
		int odometro_fim = 0;
		int odometro = 0;

		for (Abastecimento list_a : ListAbas) {

			
			if (vl_unit_barato == 0) {
				veiculo = list_a.getVeiculo();
				vl_unit_barato = list_a.getValor_unit();
				post_barato = list_a.getPosto();
			} else {
				if (list_a.getValor_unit() <= vl_unit_barato) {
					vl_unit_barato = list_a.getValor_unit();
					post_barato = list_a.getPosto();
				}
			}

			if (list_a.getValor_unit() > vl_unit_caro) {
				vl_unit_caro = list_a.getValor_unit();
				post_caro = list_a.getPosto();
			}

			if (odometro_ini == 0) {
				odometro_ini = list_a.getOdometro();
			} else {
				totlitros = totlitros + list_a.getTotLitros();
				
				if (list_a.getOdometro() <= odometro_ini) {
					odometro_ini = list_a.getOdometro();
				}
			}
			if (list_a.getOdometro() > odometro_fim) {
				odometro_fim = list_a.getOdometro();
			}
		}
		if (odometro_ini != 0) {
			odometro = odometro_fim - odometro_ini;
			media_Km = odometro / totlitros;
		}
	
	
		saida.setVei_id(vei_id);
		saida.setPlaca(veiculo.getPlaca());
		saida.setTipo(veiculo.getTipo());
		saida.setPost_barato(post_barato.getNome());
		saida.setPost_caro(post_caro.getNome());
		saida.setVl_unit_barato(vl_unit_barato);
		saida.setVl_unit_caro(vl_unit_caro);
		saida.setMedia_Km(media_Km);
		saida.setPlaca(veiculo.getPlaca());

		return new ResponseEntity<>(saida, HttpStatus.OK);
//		return abastecimentoRepository.findAll().stream().filter(a -> a.getVeiculo().getId() == Vei_id)
//				.collect(Collectors.toList());
	}
}
