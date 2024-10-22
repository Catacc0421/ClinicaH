package co.edu.uniquindio.clinica.modelo;

import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder

public class Paciente {

    private String cedula;
    private String nombre;
    private String numeroTelefono;
    private String correo;
    private Suscripcion suscripcion;

}
