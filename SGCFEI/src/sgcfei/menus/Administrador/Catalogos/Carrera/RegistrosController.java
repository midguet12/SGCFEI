package sgcfei.menus.Administrador.Catalogos.Carrera;

import accesodatos.CarreraDAO;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojos.Carrera;
import util.ControladorVentanas;

public class RegistrosController implements Initializable {

    @FXML
    private TableView<Carrera> tabla;
    @FXML
    private TableColumn<Carrera, String> cNombre;
    @FXML
    private TableColumn<Carrera, String> cFacultad;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnEliminar;
    @FXML
    private Button btnCancelar;
    private ObservableList<Carrera> listaCarrera;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarTabla();
    }    

    @FXML
    private void clickAgregar(MouseEvent event) {
        TextInputDialog dialogo = new TextInputDialog("");
        dialogo.setTitle("Agregar carrera");
        dialogo.setHeaderText("Agregar carrera");
        dialogo.setContentText("Ingrese el nombre de la carrera");

        
        Optional<String> respuesta = dialogo.showAndWait();
        if (respuesta.isPresent() && !respuesta.get().equals("")){
            if(respuesta.get().length() < 255){
                CarreraDAO dao = new CarreraDAO();
                dao.insertar(new Carrera(respuesta.get(), 1));
            
                cargarTabla();
                
                Alert alerta = ControladorVentanas.crearAlerta("Carrera agregada",
                            "La carrera se ha agregado correctamente", Alert.AlertType.INFORMATION);
                alerta.showAndWait();
            }
            else{
                Alert alerta = ControladorVentanas.crearAlerta("Error",
                            "El nombre es demasiado largo", Alert.AlertType.ERROR);
                alerta.showAndWait();
            }
        }
        else{
                Alert alerta = ControladorVentanas.crearAlerta("Error",
                            "El nombre de la carrera no puede estar vacio", Alert.AlertType.ERROR);
                alerta.showAndWait();
        }
    }

    @FXML
    private void clickEliminar(MouseEvent event) {
//        if(validarSeleccion()){
//            Alert alerta = ControladorVentanas.crearAlerta("Confirmación",
//                    "¿Está seguro que desea eliminar esta LGCA?", Alert.AlertType.CONFIRMATION);
//            Optional<ButtonType> respuesta = alerta.showAndWait();
//
//            if(respuesta.get() == ButtonType.OK){
//                int idLGCA = tabla.getSelectionModel().getSelectedItem().getIdLGCA();
//
//                LGCADAO dao = new LGCADAO();
//                dao.eliminar(idLGCA);
//
//                alerta = ControladorVentanas.crearAlerta("Operación exitosa",
//                            "Se ha eliminado la LGCA correctamente", Alert.AlertType.INFORMATION);
//                alerta.showAndWait();
//                cargarTabla();
//            }
//        }
    }

    @FXML
    private void clickCancelar(MouseEvent event) {
        Stage stageActual = (Stage) btnCancelar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/SeleccionarCatalogo.fxml",
                    "Seleccionar catálogo", stageActual);
    }

    private void cargarTabla() {
        List<Carrera> carreras;
        CarreraDAO dao = new CarreraDAO();
        listaCarrera = FXCollections.observableArrayList();
        carreras = dao.obtenerTodasCarreras();
        
        for(Carrera car:carreras){
            car.cargarFacultad();
        }
        
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cFacultad.setCellValueFactory(new PropertyValueFactory<>("facultad"));

        listaCarrera.addAll(carreras);
        tabla.setItems(listaCarrera);
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
