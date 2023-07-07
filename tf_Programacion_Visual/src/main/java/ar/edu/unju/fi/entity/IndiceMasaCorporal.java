package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Component
/*@Entity*/
//@Table(name="imc")
public class IndiceMasaCorporal {
	
	private Long id;
	private LocalDate fecha;
	private Double imc;
	private String usuario;
	private boolean estado;

	public IndiceMasaCorporal() {
	}

	public IndiceMasaCorporal(Long id, LocalDate fecha, Double imc, String usuario) {
		this.id = id;
		this.fecha = fecha;
		this.imc = imc;
		this.usuario = usuario;
	}


	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public LocalDate getFecha() {
		return fecha;
	}



	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}



	public Double getImc() {
		return imc;
	}



	public void setImc(Double imc) {
		this.imc = imc;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}


}
