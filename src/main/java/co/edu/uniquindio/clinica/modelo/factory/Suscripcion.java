package co.edu.uniquindio.clinica.modelo.factory;

import co.edu.uniquindio.clinica.modelo.Cita;
import co.edu.uniquindio.clinica.modelo.Factura;
import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.Servicio;
import co.edu.uniquindio.clinica.modelo.enums.TipoSuscripcion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface Suscripcion {

    TipoSuscripcion getNombreSuscripcion();

    public List<Servicio> getServiciosDisponibles();

    public  Factura generarFacturaCobro(Servicio servicio);

}
