package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "testimonio")
public class Testimonio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "tes_Id")
	private Long id;
	@Column(name = "tes_fecha" , nullable = false)
	private LocalDate fecha;
	@Column(name = "tes_comentario" , columnDefinition = "text",nullable = false)
	private String comentario;
	@Column(name = "tes_estado" , nullable = false)
	private boolean estado;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reg_id")
    @JsonBackReference
    private Registro usuario;
	
	
	public Registro getUsuario() {
		return usuario;
	}

	public void setUsuario(Registro usuario) {
		this.usuario = usuario;
	}

	public Testimonio(Long id, LocalDate fecha, String comentario) {
		super();
		
		this.id = id;
		this.fecha = fecha;
		this.comentario = comentario;
	}

	public Testimonio() {
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
