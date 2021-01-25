/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcfei.menus.Coordinador.Minuta.ConsultarMinuta;

import accesodatos.AcademiaDAO;
import accesodatos.MinutaDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pojos.Academia;
import pojos.Academico;
import pojos.Minuta;
import sgcfei.menus.Coordinador.Minuta.ConsultarMinuta.EditarMinuta.EditarMinutaController;
import util.ControladorVentanas;

/**
 * FXML Controller class
 *
 * @author Luis
 */
public class ConsultarMinutaController implements Initializable {

    @FXML
    private AnchorPane btnModificar;
    @FXML
    private TableView<Minuta> tbMinuta;
    @FXML
    private TableColumn<Minuta, String> cObejtivos;
    @FXML
    private TableColumn<Minuta, String> cTemas;
    private ObservableList<Minuta> listaMinutas;
    private Academico academicoLogeado;

    public ConsultarMinutaController(Academico academicoLogeado) {
        this.academicoLogeado = academicoLogeado;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaMinutas = FXCollections.observableArrayList();
        cargarTabla();
    }    

    private void cargarTabla() {
        cObejtivos.setCellValueFactory( new PropertyValueFactory<>("objetivo") );
        cTemas.setCellValueFactory( new PropertyValueFactory<>("temas") );
        
        Academia academia = new AcademiaDAO().obtenerAcademiaPorCoordinador(academicoLogeado.getNumeroPersonal());
        List<Minuta> minutas = new MinutaDAO().obtenerMinutasPorAcademia(academia.getIdAcademia());
        listaMinutas.addAll(minutas);
        tbMinuta.setItems(listaMinutas);
    }

    @FXML
    private void clicBotonModificar(ActionEvent event) {
        if (tbMinuta.getSelectionModel().getSelectedItem() != null) {
            EditarMinutaController editarMinutaController = new EditarMinutaController(academicoLogeado, tbMinuta.getSelectionModel().getSelectedItem());
            Stage stageActual = (Stage) tbMinuta.getScene().getWindow();
            ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Coordinador/Minuta/RegistrarMinuta/RegistrarMinuta.fxml", "Menu principal",editarMinutaController, stageActual);
        }
    }
    
}
