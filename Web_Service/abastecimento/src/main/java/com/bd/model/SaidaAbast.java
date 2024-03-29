package com.bd.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name = "criarRelatorio", query = "select * from Abastecimento where id = ?1")
public class SaidaAbast {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vei_id")
	private long vei_id;	
	
	private String Placa;
	private String tipo;
	private String Post_caro;
	private double Vl_unit_caro;	
	private String Post_barato;
	private double Vl_unit_barato;	
	private double media_Km;
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public long getVei_id() {
		return vei_id;
	}
	public void setVei_id(long vei_id) {
		this.vei_id = vei_id;
	}
	public String getPlaca() {
		return Placa;
	}
	public void setPlaca(String placa) {
		Placa = placa;
	}
	public String getPost_caro() {
		return Post_caro;
	}
	public void setPost_caro(String post_caro) {
		Post_caro = post_caro;
	}
	public double getVl_unit_caro() {
		return Vl_unit_caro;
	}
	public void setVl_unit_caro(double vl_unit_caro) {
		Vl_unit_caro = vl_unit_caro;
	}
	public String getPost_barato() {
		return Post_barato;
	}
	public void setPost_barato(String post_barato) {
		Post_barato = post_barato;
	}
	public double getVl_unit_barato() {
		return Vl_unit_barato;
	}
	public void setVl_unit_barato(double vl_unit_barato) {
		Vl_unit_barato = vl_unit_barato;
	}
	public double getMedia_Km() {
		return media_Km;
	}
	public void setMedia_Km(double media_Km) {
		this.media_Km = media_Km;
	}
	
}
