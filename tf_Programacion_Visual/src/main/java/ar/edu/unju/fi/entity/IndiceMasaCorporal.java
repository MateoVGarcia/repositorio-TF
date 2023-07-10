package ar.edu.unju.fi.entity;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="imc")
public class IndiceMasaCorporal {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="imc_id")
	private Long id;
	
	@Column(name="imc_fecha")
	private LocalDate fecha;
	
	@Column(name="imc_num_imc")
	private String imc;
	
	@Column(name="imc_usuario")
	private String usuario;
	
	@Column(name="imc_estado")
	private boolean estado;

	@ManyToOne(cascade = CascadeType.ALL,
    		fetch = FetchType.EAGER)
    @JoinColumn(name = "registro_id")
    private Registro registro;
	
	public IndiceMasaCorporal() {
	}

	public IndiceMasaCorporal(Long id, LocalDate fecha, String imc, String usuario) {
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



	public String getImc() {
		return imc;
	}



	public void setImc(String imc) {
		this.imc = imc;
	}





	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}


}
