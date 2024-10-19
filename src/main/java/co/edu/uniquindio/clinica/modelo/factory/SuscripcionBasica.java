package co.edu.uniquindio.clinica.modelo.factory;

import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Servicio;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SuscripcionBasica implements Suscripcion {


    @Override
    public List<Servicio> getServiciosDisponibles() {
       return null;
    }

    @Override
    public Factura generarFacturaCobro(Servicio servicio) {
        return null;
    }
}
