package co.edu.uniquindio.clinica.modelo.factory;

import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Servicio;

import java.time.LocalDateTime;
import java.util.List;

public interface Suscripcion {

    Suscripcion crearSuscripcion(Servicio factura);

    Factura crearFactura(String id, double total, double subtotal, LocalDateTime fecha);

    List<Servicio> getServiciosDisponibles();

    Factura generarFacturaCobro(Servicio servicio);
}
