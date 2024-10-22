package co.edu.uniquindio.clinica.controladores;

import co.edu.uniquindio.clinica.modelo.Clinica;
import co.edu.uniquindio.clinica.modelo.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListarCitasControlador extends AbstractControlador {

    @FXML
    private TableView<Paciente> tablaCitas;

    @FXML
    private TableColumn<Paciente, String> colFecha;

    @FXML
    private TableColumn<Paciente, String> colId;

    @FXML
    private TableColumn<Paciente, String> colNombrePaciente;

    @FXML
    private TableColumn<Paciente, String> colServicio;

    @FXML
    private TableColumn<Paciente, String> colTotal;

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
            tablaCitas.setItems(listaObservable);
        }

    }
}
