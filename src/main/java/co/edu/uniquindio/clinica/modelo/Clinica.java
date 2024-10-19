package co.edu.uniquindio.clinica.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import lombok.*;

@Getter
@Setter
@ToString
public class Clinica {

    private final List<Paciente> pacientes;
    private final List<Cita> citas;
    private final List<Servicio> servicios;
    private static Clinica INSTANCIA;


    private Clinica() {
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.servicios =new ArrayList<>();
    }

    //Singleton
    public static Clinica getInstance() {
        if(INSTANCIA == null) {
            return new Clinica();
        }else{
            return INSTANCIA;
        }
    }

    //Registrar un nuevo paciente
    public boolean registrarPaciente(String cedula, String nombre, String telefono, String email, String tipoSuscripcion) throws Exception {
        if (buscarPacientePorCedula(cedula) != null) {
            throw new Exception("Ya existe un paciente con esta cédula.");
        }
        Suscripcion suscripcion = SuscripcionFactory.crearSuscripcion(tipoSuscripcion);
        if (suscripcion == null) {
            throw new Exception("Tipo de suscripción no válido.");
        }
        Paciente paciente = new Paciente(cedula, nombre, telefono, email, suscripcion);
        pacientes.add(paciente);
        return true;
    }

    //Buscar un paciente por cédula
    public Paciente buscarPacientePorCedula(String cedula) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCedula().equals(cedula)) {
                return paciente;
            }
        }
        return null;
        }

    // 3. Listar todos los pacientes
    public List<Paciente> listarPacientes() {
        return pacientes;
    }

    //Registrar un servicio en la clínica
    public boolean registrarServicio(String id, String nombre, double precio) throws Exception {
        if (buscarServicioPorId(id) != null) {
            throw new Exception("Ya existe un servicio con este ID.");
        }
        Servicio servicio = new Servicio(id, nombre, precio);
        servicios.add(servicio);
        return true;
    }

    //Buscar un servicio por ID
    public Servicio buscarServicioPorId(String id) {
        for (Servicio servicio : servicios) {
            if (servicio.getId().equals(id)) {
                return servicio;
            }
        }
        return null;
    }

    //Listar servicios disponibles
    public List<Servicio> getServiciosDisponibles() {
        return servicios;
    }

    //Agendar una cita
    public boolean registrarCita(String idCita, Paciente paciente, Servicio servicio, LocalDateTime fecha) throws Exception {
        for (Cita cita : citas) {
            if (cita.getFecha().equals(fecha)) {
                throw new Exception("Ya existe una cita en este horario.");
            }
        }

        // Crear la cita
        Cita cita = new Cita(id, fecha, paciente, servicio);

        // Generar la factura con base en la suscripción del paciente
        Factura factura = paciente.getSuscripcion().generarFacturaCobro(servicio);
        cita.setFactura(factura);

        // Agregar la cita a la lista
        citas.add(cita);

        // Simulación del envío de correo (puedes reemplazarlo con la lógica real)
        enviarEmailConfirmacionCita(paciente, cita);

        return true; // Cita registrada con éxito
    }

    //Cancelar una cita
    public boolean cancelarCita(String idCita) throws Exception {
        Cita citaAEliminar = null;
        for (Cita cita : citas) {
            if (cita.getId().equals(idCita)) {
                citaAEliminar = cita;
                break;
            }
        }
        if (citaAEliminar == null) {
            throw new Exception("No se encontró la cita con el ID especificado.");
        }
        citas.remove(citaAEliminar);
        return true; // Cita cancelada con éxito
    }

    //Listar citas programadas
    public List<Cita> listarCitas() {
        return citas;
    }

    //Simulación del envío de email de confirmación de cita (esto puedes integrarlo con un servicio real)
    private void enviarEmailConfirmacionCita(Paciente paciente, Cita cita) {

    }

}
