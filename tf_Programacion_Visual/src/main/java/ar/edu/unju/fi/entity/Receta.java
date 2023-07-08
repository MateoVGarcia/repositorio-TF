package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
@Entity
@Table(name="recetas")
public class Receta {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="rec_id")
	private Long id;
	@Column(name="rec_nombre", nullable=false)
	@NotBlank(message="El nombre no debe quedar en blanco")
	@Size(max=30, message="El nombre puede tener hasta 30 caracteres como máximo")
	private String nombre;
	@Column(name="rec_categoria", nullable=false)
	private String categoria;
	@Column(name="rec_ingrediente", nullable=false)
	private String ingrediente;
	@Column(name="rec_preparacion",columnDefinition = "text" ,nullable=false)
	@NotBlank(message="Debe ingresar como realizó su receta")
	private String preparacion;
	@Column(name="rec_imagen", nullable=false)
	//@NotNull(message="Debe subir una imagen")
	private String imagen;
	@Column(name="rec_descripcion", nullable=false)
	@NotBlank(message="Debe ingresar una descripción corta para la receta")
	@Size(max=80, min=10, message="Ingrese una descripción corta que se encuentre entre los 10 y los 80 caracteres")
	private String descripcion;
	@Column(name="rec_estado", nullable=false)
	private boolean estado;
	
	public Receta() {
		
	}
	
	public Receta(Long id,String nombre,String categoria, String ingrediente, String preparacion, String imagen, String descripcion) {
		this.nombre = nombre;
		this.categoria = categoria;
		this.ingrediente = ingrediente;
		this.preparacion = preparacion;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.id = id;
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
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}
	public String getPreparacion() {
		return preparacion;
	}
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}

