package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaRegistrarseSexo {
	
private List<String> sexo;
	
	public ListaRegistrarseSexo() {
		sexo= new ArrayList<String>();
		sexo.add("Elija un sexo");
		sexo.add("Masculino");
		sexo.add("Femenino");
		sexo.add("Otros");
	}
	
	public List<String> getRegistroSexo(){
		return sexo;
	}
	
	public void setRegistroSexo(List<String> sexo) {
		this.sexo = sexo;
	}
}
