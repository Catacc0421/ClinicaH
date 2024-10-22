package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.modelo.Clinica;
import co.edu.uniquindio.clinica.modelo.Paciente;
import co.edu.uniquindio.clinica.modelo.factory.Suscripcion;
import javafx.collections.FXCollections;
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

public class RegistroPacienteControlador extends AbstractControlador implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        suscripcionBox.setItems( FXCollections.observableList(clinica.listarOpciones()) );
    }

    public void registrarPaciente(ActionEvent actionEvent) {
        try {
            clinica.registrarPaciente(
                    nombreField.getText(),
                    cedulaField.getText(),
                    telefonoField.getText(),
                    emailField.getText()
            );
            limpiarCampos();
            mostrarAlerta("Paciente creado con éxito", Alert.AlertType.INFORMATION);
            limpiarCampos();
            
        }catch (Exception ex){
            mostrarAlerta(ex.getMessage(), Alert.AlertType.ERROR);
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
