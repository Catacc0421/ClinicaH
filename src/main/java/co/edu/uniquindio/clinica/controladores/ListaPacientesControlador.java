package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.modelo.Clinica;
import co.edu.uniquindio.clinica.modelo.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaPacientesControlador extends AbstractControlador {
    @FXML
    private TableView<Paciente> tablaPacientes;

    @FXML
    private TableColumn<Paciente, String> colCedula;

    @FXML
    private TableColumn<Paciente, String> colNombre;

    @FXML
    private TableColumn<Paciente, String> colTelefono;

    @FXML
    private TableColumn<Paciente, String> colEmail;

    @FXML
    private TableColumn<Paciente, String> colSuscripcion;

    private Clinica clinica;
    private ObservableList<Paciente> pacientesObservable;

    // Constructor o método de inicialización donde se pasa la instancia de la clínica
    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
        cargarPacientes();
    }
        // Vinculamos las columnas de la tabla con los atributos de Paciente


    public void cargarPacientes() {
        if (clinica != null) {
            ObservableList<Paciente> listaObservable = FXCollections.observableArrayList(clinica.listarPacientes());
            tablaPacientes.setItems(listaObservable);
        }
    }


}
