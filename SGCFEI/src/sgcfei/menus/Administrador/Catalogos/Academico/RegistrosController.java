package sgcfei.menus.Administrador.Catalogos.Academico;

import accesodatos.AcademicoDAO;
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
import pojos.Academico;
import util.ControladorVentanas;

public class RegistrosController implements Initializable {

    @FXML
    private TableView<Academico> tabla;
    @FXML
    private TableColumn<Academico, String> cNumeroPersonal;
    @FXML
    private TableColumn<Academico, String> cNombre;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnConsultar;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnCancelar;
    private ObservableList<Academico> listaAcademicos;
    
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
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/Academico/Agregar.fxml",
                    "Agregar Academico", stageActual);
    }

    @FXML
    private void clickConsultar(MouseEvent event) {
        consultar();
    }

    @FXML
    private void clickEditar(MouseEvent event) {
        if(validarSeleccion()){
            Academico academico = tabla.getSelectionModel().getSelectedItem();
            Stage stageActual = (Stage) btnAgregar.getScene().getWindow();
            EditarController controlador = new EditarController(academico);
            ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Administrador/Catalogos/Academico/Editar.fxml",
                    "Editar Academico", controlador, stageActual);
        }
    }

    @FXML
    private void clickEliminar(MouseEvent event) {
        Alert alerta = ControladorVentanas.crearAlerta("Confirmación",
                "¿Está seguro que desea eliminar este academico?", Alert.AlertType.CONFIRMATION);
        Optional<ButtonType> respuesta = alerta.showAndWait();
        
        if(respuesta.get() == ButtonType.OK){
            String idAcademico = tabla.getSelectionModel().getSelectedItem().getNumeroPersonal();
            
            AcademicoDAO dao = new AcademicoDAO();
            dao.eliminar(idAcademico);
            
            alerta = ControladorVentanas.crearAlerta("Operación exitosa",
                        "Se ha eliminado el academico correctamente", Alert.AlertType.INFORMATION);
            alerta.showAndWait();
            cargarTabla();
        }
    }

    @FXML
    private void clickCancelar(MouseEvent event) {
        Stage stageActual = (Stage) btnCancelar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/SeleccionarCatalogo.fxml",
                    "Seleccionar Catalogo", stageActual);
    }

    private void cargarTabla() {
        AcademicoDAO dao = new AcademicoDAO();
        listaAcademicos = FXCollections.observableArrayList();
        
        cNumeroPersonal.setCellValueFactory(new PropertyValueFactory<>("numeroPersonal"));
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        listaAcademicos.addAll(dao.obtenerTodosAcademicos());
        tabla.setItems(listaAcademicos);
    }
    
    private void consultar(){
        if(validarSeleccion()){
            Academico academico = tabla.getSelectionModel().getSelectedItem();
            Stage stageActual = (Stage) btnAgregar.getScene().getWindow();
            ConsultarController controlador = new ConsultarController(academico);
            ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Administrador/Catalogos/Academico/Consultar.fxml",
                    "Consultar Academico", controlador, stageActual);
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
