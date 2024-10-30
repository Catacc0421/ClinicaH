package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.modelo.Clinica;
import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.enums.TipoSuscripcion;
import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.ToString;

import java.net.URL;
import java.util.ResourceBundle;

@ToString

public class RegistroPacienteControlador implements Initializable {

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

    public RegistroPacienteControlador(){
        clinica = Clinica.getInstance();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        suscripcionBox.setItems( FXCollections.observableList(clinica.listarOpciones()) );
    }

    public void registrarPaciente(ActionEvent actionEvent) {

        try {
            String identificacion = cedulaField.getText();
            String nombre = nombreField.getText();
            String telefono = telefonoField.getText();
            String correo = emailField.getText();
            TipoSuscripcion suscripcion = TipoSuscripcion.valueOf(suscripcionBox.getValue().replace(" ", ""));

            clinica.registrarPaciente(identificacion, nombre, telefono, correo, suscripcion);
            limpiarCampos();
            mostrarAlerta("Paciente registrado correctamente", Alert.AlertType.INFORMATION);
        }catch (Exception e){
            mostrarAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void cancelarRegistro (ActionEvent actionEvent){
        }

    public void cerrarVentana (Node node){
    }


    private void mostrarAlerta (String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.show();
    }

    /**
     * Limpia los campos de texto del formulario
     */
    private void limpiarCampos () {
        nombreField.clear();
        cedulaField.clear();
        telefonoField.clear();
        emailField.clear();
    }
}
