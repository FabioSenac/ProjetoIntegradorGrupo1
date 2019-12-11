package com.bd.source;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bd.model.Abastecimento;
import com.bd.model.Posto;
import com.bd.model.SaidaAbast;
import com.bd.model.Veiculo;
import com.bd.repository.AbastecimentoRepository;

@RestController
@RequestMapping("/abastecimento")
public class AbastecimentoResource {

	@Autowired
	private AbastecimentoRepository abastecimentoRepository;
	private SaidaAbast saida;

	@GetMapping
	public List<Abastecimento> list() {
		return abastecimentoRepository.findAll();
	}

	@GetMapping("/veiculo/{Vei_id}")
	public List<Abastecimento> list(@PathVariable Long Vei_id) {
		return abastecimentoRepository.findAll().stream().filter(a -> a.getVeiculo().getId() == Vei_id)
				.collect(Collectors.toList());
	}
	
//	@GetMapping("/media/{Vei_id}")
//	public SaidaAbast findById1(@PathVariable long vei_id) {
//		List<Abastecimento> lista = abastecimentoRepository.findAll().stream()
//				.filter(a -> a.getVeiculo().getId() == vei_id).collect(Collectors.toList());
//
//		SaidaAbast saida = null;
//		Veiculo veiculo = null;
//		Posto post_caro = null;
//		double vl_unit_caro = 0;
//		Posto post_barato = null;
//		double vl_unit_barato = 0;
//		double media_Km = 0;
//		double totlitros = 0;
//		int odometro_ini = 0;
//		int odometro_fim = 0;
//		int odometro = 0;
//
//		for (Abastecimento list_a : lista) {
//
//			if (vl_unit_barato == 0) {
//				veiculo = list_a.getVeiculo();
//				vl_unit_barato = list_a.getValor_unit();
//				post_barato = list_a.getPosto();
//			} else {
//				if (list_a.getValor_unit() <= vl_unit_barato) {
//					vl_unit_barato = list_a.getValor_unit();
//					post_barato = list_a.getPosto();
//				}
//			}
//
//			if (list_a.getValor_unit() > vl_unit_caro) {
//				vl_unit_caro = list_a.getValor_unit();
//				post_caro = list_a.getPosto();
//			}
//
//			if (odometro_ini == 0) {
//				odometro_ini = list_a.getOdometro();
//			} else {
//				if (list_a.getOdometro() <= odometro_ini) {
//					odometro_ini = list_a.getOdometro();
//				}
//			}
//			if (list_a.getOdometro() > odometro_fim) {
//				odometro_fim = list_a.getOdometro();
//			}
//			totlitros = totlitros + list_a.getTotLitros();
//		}
//		if (odometro != 0) {
//			odometro = odometro_fim - odometro_ini;
//			media_Km = totlitros / odometro;
//		}
//		saida.setPlaca(veiculo.getPlaca());
//		saida.setPost_barato(post_barato.getNome());
//		saida.setPost_caro(post_caro.getNome());
//		saida.setVl_unit_barato(vl_unit_barato);
//		saida.setVl_unit_caro(vl_unit_caro);
//		saida.setMedia_Km(media_Km);
//
//		return saida;
////		return abastecimentoRepository.findAll().stream().filter(a -> a.getVeiculo().getId() == Vei_id)
////				.collect(Collectors.toList());
//	}
	
	@GetMapping("{id}")
	public Optional<Abastecimento> findById(@PathVariable long id) {
		return abastecimentoRepository.findById(id);
	}

	@PostMapping
	public ResponseEntity<Abastecimento> create(@RequestBody Abastecimento abastecimento,
			HttpServletResponse response) {
		Abastecimento save = abastecimentoRepository.save(abastecimento);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId())
				.toUri();
		return ResponseEntity.created(uri).body(save);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable long id) {
		abastecimentoRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Abastecimento> update(@PathVariable long id, @RequestBody Abastecimento abastecimento) {
		Optional<Abastecimento> abastecimentoBanco = abastecimentoRepository.findById(id);
		BeanUtils.copyProperties(abastecimento, abastecimentoBanco.get(), "id");
		abastecimentoRepository.save(abastecimentoBanco.get());
		return ResponseEntity.ok(abastecimento);
	}
}
