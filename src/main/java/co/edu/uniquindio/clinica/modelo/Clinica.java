package co.edu.uniquindio.clinica.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public List<Paciente> listarPacientes() {
        return pacientes;
    }
    public void registrarPaciente(String nombre, String cedula, String numeroTelefono,
                                  String correo) throws Exception {

        if(nombre.isEmpty() || nombre.isEmpty() || cedula.isEmpty() || numeroTelefono.isEmpty() || correo.isEmpty()) {
            throw new Exception("Todos los campos son obligatorios");
        }
        if (!esCorreoValido(correo)) {
            throw new Exception("El formato del correo no es válido");
        }
        if (!esNumeroValido(numeroTelefono)) {
            throw new Exception("El formato del teléfono no es válido, solo puede contener números");
        }

        Paciente paciente = Paciente.builder()
                .nombre(nombre)
                .cedula(cedula)
                .numeroTelefono(numeroTelefono)
                .correo(correo)
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

    //Método para validar que la cita no se cruce con otras
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

    /**
     * Verifica que el correo que se ingresó esté en el formato válido
     * @param correo el correo que se ingresa al formulario
     * @return retorno
     */
    private boolean esCorreoValido(String correo) {
        // Patrón de regex para correos electrónicos
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    private boolean esNumeroValido(String numeroTelefono) {
        // Verifica si el número tiene exactamente 10 caracteres
        if (numeroTelefono.length() != 10) {
            return false;
        }

        // Verifica si todos los caracteres son dígitos (del 0 al 9)
        for (int i = 0; i < numeroTelefono.length(); i++) {
            char c = numeroTelefono.charAt(i);
            if (c < '0' || c > '9') {
                return false; // Si encuentra algún carácter que no es dígito, retorna falso
            }
        }

        // Si pasa todas las verificaciones, es un número válido
        return true;
    }
}


