package co.edu.uniquindio.clinica.controladores;
import co.edu.uniquindio.clinica.modelo.Clinica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class PanelControlador {
    @FXML
    private StackPane panelPrincipal;

    private final Clinica clinica;

    public PanelControlador() {
        this.clinica = Clinica.getInstance();
    } // Se crea una única instancia de la clase Clinica


    @FXML
    private void mostrarRegistroPaciente() {
        cargarContenido("/registroPaciente.fxml");
    }

    // Método que carga la lista de pacientes
    @FXML
    private void mostrarListaPacientes() {
        cargarContenido("/listaPacientes.fxml");
    }

    // Método que carga la creación de citas
    @FXML
    private void mostrarRegistroCita() {
        cargarContenido("/crearCita.fxml");
    }

    // Método que carga la lista de citas
    @FXML
    private void mostrarListaCitas() {
        cargarContenido("/listarCitas.fxml");
    }

    // Método general para cargar cualquier archivo FXML dentro del StackPane
    private void cargarContenido(String fxmlFile) {
        try {
            // Cargar el contenido FXML
            Pane nuevoContenido = FXMLLoader.load(getClass().getResource(fxmlFile));
            // Reemplazar el contenido del panel principal
            panelPrincipal.getChildren().setAll(nuevoContenido);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
