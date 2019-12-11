package com.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abastecimento")
public class Abastecimento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "abas_id")
	private long id;
	@Column(name = "abas_data")
	private Date data;
	@Column(name = "abas_totlitros")
	private double totLitros;
	@Column(name = "abas_odometro")
	private int odometro;
//	@Column(name = "abas_valor_tot")
//	private double valor_tot;
	@Column(name = "abas_vlr_unit")
	private double valor_unit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public double getTotLitros() {
		return totLitros;
	}

	public void setTotLitros(double totLitros) {
		this.totLitros = totLitros;
	}

	public int getOdometro() {
		return odometro;
	}

	public void setOdometro(int odometro) {
		this.odometro = odometro;
	}

//	public double getValor_tot() {
//		return valor_tot;
//	}
//
//	public void setValor_tot(double valor_tot) {
//		this.valor_tot = valor_tot;
//	}

	public double getValor_unit() {
		return valor_unit;
	}

	public void setValor_unit(double valor_unit) {
		this.valor_unit = valor_unit;
	}

	@ManyToOne
	@JoinColumn(name = "Vei_id")

	private Veiculo veiculo;

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	@ManyToOne
	@JoinColumn(name = "pos_id")

	private Posto posto;

	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

}
