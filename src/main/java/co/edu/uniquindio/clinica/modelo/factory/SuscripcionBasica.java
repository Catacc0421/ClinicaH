package co.edu.uniquindio.clinica.modelo.factory;

import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Servicio;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SuscripcionBasica implements Suscripcion {
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
        // Implementación para obtener los servicios disponibles en la suscripción básica
        return new ArrayList<>(); // Ejemplo vacío
    }

    @Override
    public Factura generarFacturaCobro(Servicio servicio) {
        // Implementación de la factura para una suscripción básica
        Factura factura = new Factura();
        // Lógica de cobro para suscripción básica
        return factura;
    }
}
