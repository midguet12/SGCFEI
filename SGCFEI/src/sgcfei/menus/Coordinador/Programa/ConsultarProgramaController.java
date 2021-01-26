package sgcfei.menus.Coordinador.Programa;

import accesodatos.ProgramaExperienciaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pojos.ProgramaExperiencia;
import sgcfei.menus.Coordinador.MenuController;
import sgcfei.menus.Coordinador.Programa.ActualizarPrograma.ActualizarProgramaController;
import util.ControladorVentanas;

public class ConsultarProgramaController implements Initializable {

    @FXML
    private TableView<ProgramaExperiencia> tabla;
    @FXML
    private TableColumn<ProgramaExperiencia, String> cExperiencia;
    @FXML
    private TableColumn<ProgramaExperiencia, String> cCodigo;
    @FXML
    private Button agregar;
    @FXML
    private Button consultar;
    @FXML
    private Button regresar;

    private ObservableList<ProgramaExperiencia> listaExperiencias;
        
    public ConsultarProgramaController(){
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTabla();
    }    

    @FXML
    private void agregar(ActionEvent event) {
        Stage stageActual = (Stage) agregar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Coordinador/Programa/RegistrarPrograma/RegistrarPrograma.fxml", "Registrar Programa", stageActual);

    }

    @FXML
    private void actualizar(ActionEvent event) {
        if(validarSeleccion()){
            ProgramaExperiencia pExp = tabla.getSelectionModel().getSelectedItem();
            Stage stageActual = (Stage) agregar.getScene().getWindow();
            ActualizarProgramaController controlador = new ActualizarProgramaController(pExp);
            System.out.println(pExp.getIdProgramaEE());
            ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Coordinador/Programa/ActualizarPrograma/ActualizarPrograma.fxml",
                    "Editar Academia", controlador, stageActual);
        }
    }
    
    @FXML
    private void regresar(ActionEvent event) {
        Stage stageActual = (Stage) agregar.getScene().getWindow();
        MenuController menuController = new MenuController();
        ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Coordinador/Menu.fxml", "Menu principal",menuController, stageActual);

    }

    private void cargarTabla() {
        ProgramaExperienciaDAO dao = new ProgramaExperienciaDAO();
        listaExperiencias = FXCollections.observableArrayList();
        
        cExperiencia.setCellValueFactory(new PropertyValueFactory<>("nombreExperiencia"));
        cCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        listaExperiencias.addAll(dao.obtenerTodosProgramasEE());
        tabla.setItems(listaExperiencias);
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
