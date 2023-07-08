package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="ingredientes")
public class Ingrediente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	@Column(name="ingr_nombre")
	@NotBlank(message="El nombre no puede quedar vacío")
	@Size(max=30,message="El nombre puede contener solo hasta 30 caracteres")
	private String nombre;
	@Column(name="ingr_estado")
	private boolean estado;
	
	public Ingrediente() {
		
	}
	
	public Ingrediente(Long id,String nombre) {
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}


}
