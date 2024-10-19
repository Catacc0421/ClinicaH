package co.edu.uniquindio.clinica.modelo;

import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Paciente {

    private String cedula;
    private String nombre;
    private String telefono;
    private String email;
    private Suscripcion suscripcion;

}
