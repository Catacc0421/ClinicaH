package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.modelo.Clinica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CrearCitaControlador extends AbstractControlador {

    @FXML
    private DatePicker fechaCita;

    @FXML
    private ComboBox<?> comboServicio;

    @FXML
    private TextField horatxt;

    @FXML
    private TextField pacientetxt;

    private Clinica clinica;

    public CrearCitaControlador() {
        clinica = Clinica.getInstance();
    }


    public void cancelarRegistro (javafx.event.ActionEvent actionEvent){
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

    public void confirmarCita(ActionEvent actionEvent) {
    }
}


