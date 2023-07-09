package ar.edu.unju.fi.entity;
import java.time.LocalDate;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
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
    @Column(name = "regis_id")
    private Long id;

    @Size(max=30, message="El nombre puede contener solo hasta 30 caracteres.")
    @NotEmpty(message="El nombre no puede estar vacío.")
    @Column(name = "regis_nombre" ,nullable = false,length = 30)
    private String nombre;

    @Size(max=10, message="El apellido puede contener hasta 10 caracteres.")
    @NotEmpty(message="El apellido no puede estar vacío.")
    @Column(name = "regis_apellido", nullable = false, length = 10)
    private String apellido;

    @NotEmpty(message="El email no puede quedar vacío.")
    @Column(name = "regis_email", nullable = false)
    private String email;

    @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual.")
    @Column(name = "regis_nacimiento", nullable = false)
    private LocalDate nacimiento;

    @Min(value=100000000L, message="El número de teléfono debe tener al menos 9 dígitos.")
    @Column(name = "regis_telefono", nullable = false)
    private int telefono;

    @NotEmpty
    @Column(name = "regis_sexo", nullable = false)
    private String sexo;

    @DecimalMin(value="1.0", inclusive = false, message="La estatura debe ser mayor que 1.")
    @Column(name = "regis_estatura", nullable = false)
    private Double estatura;
    
    @Column(name="regis_estado")
	private boolean estado;

    // Constructor, getters y setters

    public Registro() {
    }
    
    public Registro(String nombre, String apellido, String email, LocalDate nacimiento,
            int telefono, String sexo, Double estatura, Long id) {
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
                    int telefono, String sexo, Double estatura) {
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

	public Double getEstatura() {
		return estatura;
	}

	public void setEstatura(Double estatura) {
		this.estatura = estatura;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
    
}