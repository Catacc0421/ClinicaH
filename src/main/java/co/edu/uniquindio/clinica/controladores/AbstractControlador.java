package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.modelo.Clinica;
import lombok.*;

@Getter
@Setter
public abstract class AbstractControlador {

    private Clinica clinica;

    public void inicializarClinica(Clinica clinica){
        this.clinica = clinica;
    }

}
