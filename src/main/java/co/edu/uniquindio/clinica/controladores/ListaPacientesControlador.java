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

public class ListaPacientesControlador implements  Initializable {
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


    public ListaPacientesControlador(){
        this.clinica = Clinica.getInstance();
    }

    public void cargarPacientes() {
        System.out.println(clinica.getPacientes());
        ObservableList<Paciente> listaObservable = FXCollections.observableArrayList(clinica.listarPacientes());
        tablaPacientes.setItems(listaObservable);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        colNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNumeroTelefono()));
        colEmail.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCorreo()));
        colSuscripcion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSuscripcion().getNombreSuscripcion().getNombre()));

        cargarPacientes();

    }
}
