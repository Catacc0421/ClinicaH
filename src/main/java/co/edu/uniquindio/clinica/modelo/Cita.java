package co.edu.uniquindio.clinica.modelo;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Cita {

    private int id;
    private LocalDateTime fecha;
    private Paciente paciente;
    private Servicio servicio;
    private double total;
}
