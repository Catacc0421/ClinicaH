package co.edu.uniquindio.clinica.modelo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Servicio {

    private int id;
    private String nombre;
    private double precio;
}
