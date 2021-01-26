package sgcfei.menus.Administrador.Catalogos.Academia;

import accesodatos.AcademiaDAO;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojos.Academia;
import util.ControladorVentanas;

public class RegistrosController implements Initializable {
    @FXML
    private TableView<Academia> tabla;
    @FXML
    private TableColumn<Academia, String> cNombre;
    @FXML
    private Button btnAgregar = new Button();
    @FXML
    private Button btnConsultar = new Button();
    @FXML
    private Button btnEditar = new Button();
    @FXML
    private Button btnEliminar = new Button();
    @FXML
    private Button btnCancelar = new Button();
    private ObservableList<Academia> listaAcademias;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTabla();
    } 
    
    @FXML
    private void clickTabla(MouseEvent event) {
        if(event.getClickCount() == 2){
            consultar();
        }
    }
    
    @FXML
    private void clickAgregar(MouseEvent event) {
        Stage stageActual = (Stage) btnAgregar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/Academia/Agregar.fxml",
                    "Agregar Academia", stageActual);
    }
    
    @FXML
    private void clickConsultar(MouseEvent event) {
        consultar();
    }

    @FXML
    private void clickEditar(MouseEvent event) {
        if(validarSeleccion()){
            Academia academia = tabla.getSelectionModel().getSelectedItem();
            Stage stageActual = (Stage) btnAgregar.getScene().getWindow();
            EditarController controlador = new EditarController(academia);
            ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Administrador/Catalogos/Academia/Editar.fxml",
                    "Editar Academia", controlador, stageActual);
        }
    }

    @FXML
    private void clickEliminar(MouseEvent event) {
        if(validarSeleccion()){
            Alert alerta = ControladorVentanas.crearAlerta("Confirmación",
                            "¿Está seguro que desea eliminar esta academia?", Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> respuesta = alerta.showAndWait();

            if(respuesta.get() == ButtonType.OK){
                int idAcademia = tabla.getSelectionModel().getSelectedItem().getIdAcademia();

                AcademiaDAO dao = new AcademiaDAO();
                dao.eliminar(idAcademia);

                alerta = ControladorVentanas.crearAlerta("Operación exitosa",
                            "Se ha eliminado la academia correctamente", Alert.AlertType.INFORMATION);
                alerta.showAndWait();
                cargarTabla();
            }
        }
    }

    @FXML
    private void clickCancelar(MouseEvent event) {
        Stage stageActual = (Stage) btnCancelar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/SeleccionarCatalogo.fxml",
                    "Seleccionar catálogo", stageActual);
    }
    
    private void cargarTabla(){
        AcademiaDAO dao = new AcademiaDAO();
        listaAcademias = FXCollections.observableArrayList();
        
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        listaAcademias.addAll(dao.obtenerTodasAcademias());
        tabla.setItems(listaAcademias);
    }
    
    private void consultar(){
        if(validarSeleccion()){
            Academia academia = tabla.getSelectionModel().getSelectedItem();
            Stage stageActual = (Stage) btnAgregar.getScene().getWindow();
            ConsultarController controlador = new ConsultarController(academia);
            ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Administrador/Catalogos/Academia/Consultar.fxml",
                    "Consultar Academia", controlador, stageActual);
        }
    }
    
    private boolean validarSeleccion(){
        if(tabla.getSelectionModel().isEmpty()){
            Alert alerta = ControladorVentanas.crearAlerta("Elemento no seleccionado",
                       "Debe seleccionar un elemento de la tabla", Alert.AlertType.ERROR);
            alerta.showAndWait();
            return false;
        }
        return true;
    }
}
