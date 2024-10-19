package co.edu.uniquindio.clinica.modelo;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@Builder
public class Factura {

    private LocalDateTime fecha;
    private String id;
    private double total;
    private double subtotal;


}
