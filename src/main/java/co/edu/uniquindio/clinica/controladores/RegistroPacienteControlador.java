package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.modelo.Clinica;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegistroPacienteControlador extends AbstractControlador {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField cedulaField;

    @FXML
    private TextField telefonoField;

    @FXML
    private TextField emailField;

    @FXML
    private ComboBox<String> suscripcionBox;

    private Clinica clinica;

    @FXML
    private void registrarPaciente() {
        try {
            String nombre = nombreField.getText();
            String cedula = cedulaField.getText();
            String telefono = telefonoField.getText();
            String email = emailField.getText();
            String tipoSuscripcion = suscripcionBox.getValue();

            if (nombre.isEmpty() || cedula.isEmpty() || telefono.isEmpty() || email.isEmpty() || tipoSuscripcion == null) {

                throw new Exception("Todos los campos son obligatorios.");
            }

            // Registrar el paciente en la clínica
            clinica.registrarPaciente(cedula, nombre, telefono, email, tipoSuscripcion);



        } catch (Exception e) {

        }
    }

    @FXML
    private void cancelarRegistro() {

    }

}
