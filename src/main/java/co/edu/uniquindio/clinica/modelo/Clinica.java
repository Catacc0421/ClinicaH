package co.edu.uniquindio.clinica.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import co.edu.uniquindio.clinica.modelo.factory.SuscripcionBasica;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
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
    public List<Paciente> listarPacientes() {
        return pacientes;
    }
    public void registrarPaciente(String nombre, String cedula, String numeroTelefono, String correo, Suscripcion suscripcion) throws Exception {

        Paciente paciente = Paciente.builder()
                .nombre(nombre)
                .cedula(cedula)
                .numeroTelefono(numeroTelefono)
                .correo(correo)
                .suscripcion(suscripcion)
                .build();

        pacientes.add(paciente);
    }
    public Paciente buscarPaciente(String cedula) {
        for (Paciente paciente : pacientes) {
            if (paciente.getCedula().equals(cedula)) {
                return paciente;
            }
        }
        return null;
    }
    public ArrayList<String> listarOpciones() {
        ArrayList<String> suscripciones = new ArrayList<>();
        suscripciones.add("SUSCRIPCIÓN BÁSICA");
        suscripciones.add("SUSCRIPCIÓN PREMIUM");


        return suscripciones;
    }
    //Citas
    public boolean agendarCita(Cita nuevaCita) {
        if (validarCita(nuevaCita)) {
            citas.add(nuevaCita);
            enviarEmail(nuevaCita);
            return true;
        } else {
            return false; // La cita no se pudo agendar
        }
    }

    // Método para validar que la cita no se cruce con otras
    private boolean validarCita(Cita nuevaCita) {
        for (Cita cita : citas) {
            if (cita.getFecha().equals(nuevaCita.getFecha())) {
                return false; // Cita ya agendada en ese horario
            }
        }
        return true; // No hay conflicto de horarios
    }

    // Método para enviar un email (simulado)
    private void enviarEmail(Cita cita) {
        String email = "correo_del_paciente@example.com"; // Aquí deberías obtener el correo del paciente
        String mensaje = String.format("Hola %s,\n\nSu cita ha sido agendada para el %s.\nTotal a pagar: %.2f\n\nGracias.",
                cita.getPaciente(), cita.getFecha(), cita.getTotal());
        System.out.println("Enviando email a " + email + ":\n" + mensaje);
        // Aquí puedes integrar una librería para enviar correos como JavaMail
    }

    // Método para visualizar citas
    public List<Cita> visualizarCitas() {
        return new ArrayList<>(citas);
    }
}


