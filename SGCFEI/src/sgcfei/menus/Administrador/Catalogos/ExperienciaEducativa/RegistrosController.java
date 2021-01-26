package sgcfei.menus.Administrador.Catalogos.ExperienciaEducativa;

import accesodatos.ExperienciaEducativaDAO;
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
import pojos.ExperienciaEducativa;
import util.ControladorVentanas;

public class RegistrosController implements Initializable {

    @FXML
    private TableView<ExperienciaEducativa> tabla;
    @FXML
    private TableColumn<ExperienciaEducativa, String> cNRC;
    @FXML
    private TableColumn<ExperienciaEducativa, String> cNombre;
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
    private ObservableList<ExperienciaEducativa> listaExperiencias;

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
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/ExperienciaEducativa/Agregar.fxml",
                    "Agregar Experiencia Educativa", stageActual);
    }

    @FXML
    private void clickConsultar(MouseEvent event) {
        consultar();
    }

    @FXML
    private void clickEditar(MouseEvent event) {
        if(validarSeleccion()){
            ExperienciaEducativa experienciaEducativa = tabla.getSelectionModel().getSelectedItem();
            Stage stageActual = (Stage) btnAgregar.getScene().getWindow();
            EditarController controlador = new EditarController(experienciaEducativa);
            ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Administrador/Catalogos/ExperienciaEducativa/Editar.fxml",
                    "Editar Experiencia Educativa", controlador, stageActual);
        }
    }

    @FXML
    private void clickEliminar(MouseEvent event) {
        if(validarSeleccion()){
            Alert alerta = ControladorVentanas.crearAlerta("Confirmación",
                    "¿Está seguro que desea eliminar esta Experiencia Educativa?", Alert.AlertType.CONFIRMATION);
            Optional<ButtonType> respuesta = alerta.showAndWait();

            if(respuesta.get() == ButtonType.OK){
                int nrc = tabla.getSelectionModel().getSelectedItem().getNrc();

                ExperienciaEducativaDAO dao = new ExperienciaEducativaDAO();
                dao.eliminar(nrc);

                alerta = ControladorVentanas.crearAlerta("Operación exitosa",
                            "Se ha eliminado la Experiencia Educativa correctamente", Alert.AlertType.INFORMATION);
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
        ExperienciaEducativaDAO dao = new ExperienciaEducativaDAO();
        listaExperiencias = FXCollections.observableArrayList();
        
        cNRC.setCellValueFactory(new PropertyValueFactory<>("nrc"));
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        listaExperiencias.addAll(dao.obtenerTodasExperiencias());
        tabla.setItems(listaExperiencias);
    }
    
    private void consultar(){
        if(validarSeleccion()){
            ExperienciaEducativa experienciaEducativa = tabla.getSelectionModel().getSelectedItem();
            Stage stageActual = (Stage) btnAgregar.getScene().getWindow();
            ConsultarController controlador = new ConsultarController(experienciaEducativa);
            ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Administrador/Catalogos/ExperienciaEducativa/Consultar.fxml",
                    "Consultar Experiencia Educativa", controlador, stageActual);
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
