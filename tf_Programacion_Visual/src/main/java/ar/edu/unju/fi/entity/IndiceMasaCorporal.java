package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class IndiceMasaCorporal {
	
	private Long id;
	private LocalDate fecha;
	private double peso;
	private double altura;
	private double imc;
	private String usuario;
	private String estado;

	public IndiceMasaCorporal() {
	}

	public IndiceMasaCorporal(Long id, LocalDate fecha, double peso, double altura, String usuario) {
		this.id = id;
		this.fecha = fecha;
		this.peso = peso;
		this.altura = altura;
		this.usuario = usuario;
		calcularIMC();
		obtenerEstado();
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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getImc() {
		return imc;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEstado() {
		return estado;
	}

	private void calcularIMC() {
		imc = peso / (altura * altura);
	}

	private void obtenerEstado() {
		if (imc < 18.5) {
			estado = "Está por debajo de su peso ideal";
		} else if (imc >= 18.5 && imc <= 25) {
			estado = "Está en su peso normal";
		} else {
			estado = "Tiene sobrepeso";
		}
	}
}
