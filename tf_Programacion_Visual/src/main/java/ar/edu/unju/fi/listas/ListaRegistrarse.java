package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


import ar.edu.unju.fi.entity.Registro;

@Component
public class ListaRegistrarse {
    private List<Registro> registrarse;

    public ListaRegistrarse() {
        registrarse = new ArrayList<Registro>();
    }

    public List<Registro> getRegistrarse() {
        return registrarse;
    }

    public void setRegistrarse(List<Registro> registrarse) {
        this.registrarse = registrarse;
    }
}