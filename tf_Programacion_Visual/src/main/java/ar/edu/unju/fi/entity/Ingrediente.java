package ar.edu.unju.fi.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="ingredientes")
public class Ingrediente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ingr_id")
	private Long id;
	@Column(name="ingr_nombre", nullable=false)
	@NotBlank(message="El nombre no puede quedar vacío")
	@Size(max=30,message="El nombre puede contener solo hasta 30 caracteres")
	private String nombre;
	@Column(name="ingr_estado")
	private boolean estado;
	@ManyToMany(mappedBy = "ingredientes")
	private List<Receta> recetas;
	
	
	public Ingrediente() {
		
	}
	
	public Ingrediente(Long id,String nombre) {
		this.nombre = nombre;
		this.id=id;
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
