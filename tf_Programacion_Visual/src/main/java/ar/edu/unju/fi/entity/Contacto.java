package ar.edu.unju.fi.entity;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Contacto {
	
	@NotEmpty(message="El nombre no puede permanecer vacío")
	@Size(min=5, max=40, message="El nombre debe contener entre 5 y 40 caracteres")
	private String nombre;

	
	@NotEmpty(message="El email no puede estar vacío")
	@Email(message = "El email debe tener un formato válido")
	private String email;

	@NotEmpty(message="La ciudad no puede estar vacía")
	@Size(min=5, max=40, message="El límite permitido para una ciudad es de 5 a 40 caracteres")
	private String ciudad;
	
	@NotEmpty(message="Necesita poner un mensaje")
	@Size(min=30, max=100, message="El máximo permitido para una mensaje son 30 a 100 caracteres")
	private String mensaje;

	public Contacto() {
	        // Constructor vacío
	 }

	public Contacto(String nombre, String email, String ciudad, String mensaje) {
	        this.nombre = nombre;
	        this.email = email;
	        this.ciudad = ciudad;
	        this.mensaje = mensaje;
	    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
