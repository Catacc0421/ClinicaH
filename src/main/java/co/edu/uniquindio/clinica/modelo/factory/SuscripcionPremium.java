package co.edu.uniquindio.clinica.modelo.factory;

import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Servicio;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SuscripcionPremium implements Suscripcion {

    @Override
    public Suscripcion crearSuscripcion(Servicio factura) {
        return null;
    }

    @Override
    public Factura crearFactura(String id, double total, double subtotal, LocalDateTime fecha) {
        return null;
    }

    @Override
    public List<Servicio> getServiciosDisponibles() {
        return new ArrayList<>(); // Ejemplo vacío
    }

    @Override
    public Factura generarFacturaCobro(Servicio servicio) {
        Factura factura = new Factura();
        return factura;
    }
}
