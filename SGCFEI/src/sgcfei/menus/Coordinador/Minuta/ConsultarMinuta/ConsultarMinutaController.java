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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pojos.Academia;
import pojos.Academico;
import pojos.Minuta;
import sgcfei.menus.Coordinador.MenuController;
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
    private Alert alerta;

    public ConsultarMinutaController(Academico academicoLogeado) {
        this.academicoLogeado = academicoLogeado;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        asociarComponentes();
    }    

    private void asociarComponentes() {
        cObejtivos.setCellValueFactory( new PropertyValueFactory<>("objetivo") );
        cTemas.setCellValueFactory( new PropertyValueFactory<>("temas") );
        recuperarMinutas();
    }

    @FXML
    private void clicBotonCerrar(ActionEvent event) {
        Stage stageActual = (Stage) tbMinuta.getScene().getWindow();
        MenuController menuController = new MenuController(academicoLogeado);
        ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Coordinador/Menu.fxml", "Menu principal",menuController, stageActual);
    }

    @FXML
    private void clicModificar(ActionEvent event) {
        if (esUsuarioSeleccionado()) {
            EditarMinutaController editarMinutaController = new EditarMinutaController(academicoLogeado, tbMinuta.getSelectionModel().getSelectedItem());
            Stage stageActual = (Stage) tbMinuta.getScene().getWindow();
            ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Coordinador/Minuta/ConsultarMinuta/EditarMinuta/EditarMinuta.fxml", "Editar minuta",editarMinutaController, stageActual);
        }else{
            mostrarSinSeleccioon();
        }
    }

    @FXML
    private void clicBotonModificar(MouseEvent event) {
    }

    @FXML
    private void clicBotonEliminar(ActionEvent event) {
        if(esUsuarioSeleccionado()){
            Minuta minutaEliminar = tbMinuta.getSelectionModel().getSelectedItem();
            alerta = ControladorVentanas.crearAlerta("Confirmacion de Eliminacion", "¿Estas seguro de eliminar esta minuta?", Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> resultadoDialog = alerta.showAndWait();
            if(resultadoDialog.get() == ButtonType.OK){
                boolean esMinutaEliminada = new MinutaDAO().eliminar(minutaEliminar.getIdMinuta());
                if (esMinutaEliminada) {
                    recuperarMinutas();
                    alerta = ControladorVentanas.crearAlerta("Eliminacion exitosa", "La minuta se ha eliminado del sistema", Alert.AlertType.INFORMATION);
                    alerta.showAndWait();
                }
            }
        }else{
            mostrarSinSeleccioon();
        }
    }

    private boolean esUsuarioSeleccionado() {
        if (tbMinuta.getSelectionModel().getSelectedItem() != null) {
            return true;
        }else{
            return false;
        }
    }
    
    private void mostrarSinSeleccioon(){
        alerta = ControladorVentanas.crearAlerta("Sin seleccion", "Para eliminar un registro debes de seleccionarlo de la tabla", Alert.AlertType.WARNING);
        alerta.showAndWait();
    }

    private void recuperarMinutas() {
        Academia academia = new AcademiaDAO().obtenerAcademiaPorCoordinador(academicoLogeado.getNumeroPersonal());
        List<Minuta> minutas = new MinutaDAO().obtenerMinutasPorAcademia(academia.getIdAcademia());
        if (minutas.size() > 0) {
            cargarMinutas(minutas);
        }else{
            alerta = ControladorVentanas.crearAlerta("Sin minutas", "No hay minutas guardadas en el sistema", Alert.AlertType.WARNING);
            alerta.showAndWait();
        }
        
    }

    private void cargarMinutas(List<Minuta> minutas) {
        listaMinutas = FXCollections.observableArrayList();
        listaMinutas.addAll(minutas);
        tbMinuta.setItems(listaMinutas);
    }
    
}
