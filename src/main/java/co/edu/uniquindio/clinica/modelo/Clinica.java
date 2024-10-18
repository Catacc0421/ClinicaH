package co.edu.uniquindio.clinica.modelo;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Clinica {

    private final List<Paciente> pacientes;
    private final List<Cita> citas;
    private final List<Servicio> servicios;
    private static Clinica INSTANCIA;


    private Clinica() {
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.servicios =new ArrayList<>();
    }

    //Singleton
    public static Clinica getInstance() {
        if(INSTANCIA == null) {
            return new Clinica();
        }else{
            return INSTANCIA;
        }
    }
}
