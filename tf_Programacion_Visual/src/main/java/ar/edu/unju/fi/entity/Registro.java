package ar.edu.unju.fi.entity;
import java.time.LocalDate;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Component
@Entity
@Table(name = "registro")
public class Registro {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
	@Column(name = "id")
    private Long id;

	@Column(name = "regis_nombre" ,nullable = false,length = 30)
	@Size(min=5, max=12 , message = "El nombre debe contener entre 5 y 12 caracteres.")
    @NotEmpty(message="El nombre no puede estar vacío.")
    private String nombre;

	@Column(name = "regis_apellido", nullable = false, length = 10)
	@Size(min=5, max=12 , message = "El apellido debe contener entre 5 y 12 caracteres.")
    @NotEmpty(message="El apellido no puede estar vacío.")
    private String apellido;

	@Column(name = "regis_email", nullable = false)
	@NotEmpty(message="El email no puede quedar vacío.")    
    private String email;

	@Column(name = "regis_nacimiento", nullable = false)
	@Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual.")    
	@NotNull(message = "Ingrese su fecha de nacimiento")
	private LocalDate nacimiento;

	@Column(name = "regis_telefono", nullable = false)
	@Min(value=1000000000, message="El número de teléfono debe tener al menos 9 dígitos.")
	@NotNull(message = "El numero de telefono no puede estar vacío.")
    private int telefono;

	@Column(name = "regis_sexo", nullable = false)
	@NotEmpty
    private String sexo;

	@Column(name = "regis_estatura", nullable = false)
	@DecimalMin(value="1.0", inclusive = false, message="La estatura debe ser mayor que 1.")    
	@NotNull(message="La estatura no puede estar vacía.")
	private Float estatura;
    
    @Column(name="regis_estado")
	private boolean estado;

    // Constructor, getters y setters

    public Registro() {
    }
    
    public Registro(String nombre, String apellido, String email, LocalDate nacimiento,
            int telefono, String sexo, Float estatura, Long id) {
    	super();
    	this.id = id;
    	this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;		
		this.nacimiento = nacimiento;
		this.telefono = telefono;
		this.sexo = sexo;
		this.estatura = estatura;
		}

    public Registro(String nombre, String apellido, String email, LocalDate nacimiento,
                    int telefono, String sexo, Float estatura) {
    	super();
    	this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;       
        this.nacimiento = nacimiento;
        this.telefono = telefono;
        this.sexo = sexo;
        this.estatura = estatura;
    }

    // Getters y setters
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }	

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Float getEstatura() {
		return estatura;
	}

	public void setEstatura(Float estatura) {
		this.estatura = estatura;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
    
}