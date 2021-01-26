package sgcfei.menus.Administrador.Catalogos.LGCA;

import accesodatos.LGCADAO;
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
import pojos.LGCA;
import util.ControladorVentanas;

public class RegistrosController implements Initializable {

    @FXML
    private TableView<LGCA> tabla;
    @FXML
    private TableColumn<LGCA, String> cClave;
    @FXML
    private TableColumn<LGCA, String> cDescripcion;
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
    private ObservableList<LGCA> listaLGCA;

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
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/LGCA/Agregar.fxml",
                    "Agregar Experiencia Educativa", stageActual);
    }

    @FXML
    private void clickConsultar(MouseEvent event) {
        consultar();
    }

    @FXML
    private void clickEditar(MouseEvent event) {
        if(validarSeleccion()){
            LGCA lgca = tabla.getSelectionModel().getSelectedItem();
            Stage stageActual = (Stage) btnAgregar.getScene().getWindow();
            EditarController controlador = new EditarController(lgca);
            ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Administrador/Catalogos/LGCA/Editar.fxml",
                    "Editar Experiencia Educativa", controlador, stageActual);
        }
    }

    @FXML
    private void clickEliminar(MouseEvent event) {
        if(validarSeleccion()){
            Alert alerta = ControladorVentanas.crearAlerta("Confirmación",
                    "¿Está seguro que desea eliminar esta LGCA?", Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> respuesta = alerta.showAndWait();

            if(respuesta.get() == ButtonType.OK){
                int idLGCA = tabla.getSelectionModel().getSelectedItem().getIdLGCA();

                LGCADAO dao = new LGCADAO();
                dao.eliminar(idLGCA);

                alerta = ControladorVentanas.crearAlerta("Operación exitosa",
                            "Se ha eliminado la LGCA correctamente", Alert.AlertType.INFORMATION);
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

    private void cargarTabla() {        
        LGCADAO dao = new LGCADAO();
        listaLGCA = FXCollections.observableArrayList();
        
        cClave.setCellValueFactory(new PropertyValueFactory<>("clave"));
        cDescripcion.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));

        listaLGCA.addAll(dao.obtenerTodasLGCA());
        tabla.setItems(listaLGCA);
    }
        
    private void consultar(){
        if(validarSeleccion()){
            LGCA lgca = tabla.getSelectionModel().getSelectedItem();
            Stage stageActual = (Stage) btnAgregar.getScene().getWindow();
            ConsultarController controlador = new ConsultarController(lgca);
            ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Administrador/Catalogos/LGCA/Consultar.fxml",
                    "Consultar LGCA", controlador, stageActual);
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
