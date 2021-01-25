/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcfei.menus.Administrador.ConsultarUsuario;

import accesodatos.AcademicoDAO;
import accesodatos.UsuarioDAO;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pojos.Academico;
import sgcfei.menus.Administrador.ConsultarUsuario.EditarUsuario.EditarUsuarioController;
import util.ControladorVentanas;

/**
 * FXML Controller class
 *
 * @author Luis
 */
public class ConsultarUsuarioController implements Initializable {

    @FXML
    private TableView<Academico> tbAcademico;
    @FXML
    private TableColumn<Academico, String> cNumeroPersonal;
    @FXML
    private TableColumn<Academico, String> cNombre;
    @FXML
    private TableColumn<Academico, String> cCorreo;
    @FXML
    private TableColumn<Academico, String> cRol;
    @FXML
    private TextField tfBuscar;
    private ObservableList<Academico> listaAcademicos;
    private Alert alerta;
    private Stage stageActual;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        asosiarComponentes();
        agregarListener();
    }    

    @FXML
    private void clicBotonModificar(ActionEvent event) {
        if(esUsuarioSeleccionado()) {
            Academico academicoEditar = tbAcademico.getSelectionModel().getSelectedItem();
            EditarUsuarioController editarUsuarioController = new EditarUsuarioController(academicoEditar.getNumeroPersonal());
            stageActual = (Stage) tfBuscar.getScene().getWindow();
            ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Administrador/ConsultarUsuario/EditarUsuario/EditarUsuario.FXML", "Editar Usuario",editarUsuarioController, stageActual);
        }else{
            alerta = ControladorVentanas.crearAlerta("Sin seleccion", "Para editar un registro debes de seleccionarlo de la tabla", Alert.AlertType.WARNING);
            alerta.showAndWait();
        }
    }


    @FXML
    private void clicBotonEliminar(ActionEvent event) {
        if(esUsuarioSeleccionado()){
            Academico academicoEliminar = tbAcademico.getSelectionModel().getSelectedItem();
            alerta = ControladorVentanas.crearAlerta("Confirmacion de Eliminacion", "¿Estas seguro de eliminar a al Usuario " + academicoEliminar.getNombre() + " ?", Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> resultadoDialog = alerta.showAndWait();
            if(resultadoDialog.get() == ButtonType.OK){
                boolean esAcademicoEliminado = new AcademicoDAO().eliminar(academicoEliminar.getNumeroPersonal());
                if (esAcademicoEliminado) {
                    boolean esUsuarioEliminado = new UsuarioDAO().eliminar(academicoEliminar.getNumeroPersonal());
                    if (esUsuarioEliminado) {
                        recuperarAcademicos();
                        alerta = ControladorVentanas.crearAlerta("Eliminacion exitosa", "El Usuario ha sido eliminado", Alert.AlertType.INFORMATION);
                        alerta.showAndWait();
                    }
                }
            }
        }else{
            alerta = ControladorVentanas.crearAlerta("Sin seleccion", "Para eliminar un registro debes de seleccionarlo de la tabla", Alert.AlertType.WARNING);
            alerta.showAndWait();
        }
    }

    private void cargarAcademicos(List<Academico> academicos) {
        listaAcademicos = FXCollections.observableArrayList();
        listaAcademicos.addAll(academicos);
        tbAcademico.setItems(listaAcademicos);
        tbAcademico.getSortOrder().setAll(cRol);
    }

    private void recuperarAcademicos() {
        List<Academico> academicos = new AcademicoDAO().obtenerTodosAcademicosConCuenta();
        if (academicos.size() > 0) {
            cargarAcademicos(academicos);
        }else{
            alerta = ControladorVentanas.crearAlerta("Sin usuario registrador", "No hay usuarios guardados en el sistema", Alert.AlertType.INFORMATION);
            alerta.showAndWait();
        }
    }

    private void asosiarComponentes() {
        cNumeroPersonal.setCellValueFactory( new PropertyValueFactory<>("numeroPersonal") );
        cNombre.setCellValueFactory( new PropertyValueFactory<>("nombre") );
        cCorreo.setCellValueFactory( new PropertyValueFactory<>("correo") );
        cRol.setCellValueFactory( new PropertyValueFactory<>("rol") );
        recuperarAcademicos();
    }

    @FXML
    private void clicBotonCerrar(ActionEvent event) {
        stageActual = (Stage) tfBuscar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Menu.fxml","Menu principal Administrador",stageActual);
    }

    private void agregarListener() {
        if(listaAcademicos.size() > 0){
            FilteredList<Academico> filtroDatos = new FilteredList<>(listaAcademicos, p -> true);
            
            tfBuscar.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    filtroDatos.setPredicate((busqueda) -> {
                        
                        if(newValue == null || newValue.isEmpty()){
                            return true;
                        }
                        
                        String lowerCaseFilter = newValue.toLowerCase();
                        if(busqueda.getNombre().toLowerCase().contains(lowerCaseFilter)){
                            return true;
                        }else{
                            if(busqueda.getNumeroPersonal().toLowerCase().contains(lowerCaseFilter)){
                                return true;
                            }
                        }
                        return false;
                    });
                }
            });
            
            SortedList<Academico> sortedData = new SortedList<>(filtroDatos);
            sortedData.comparatorProperty().bind(tbAcademico.comparatorProperty());
            tbAcademico.setItems(sortedData);
        }
    }

    private boolean esUsuarioSeleccionado() {
        if (tbAcademico.getSelectionModel().getSelectedItem() != null) {
            return true;
        }else{
            return false;
        }
    }
}
