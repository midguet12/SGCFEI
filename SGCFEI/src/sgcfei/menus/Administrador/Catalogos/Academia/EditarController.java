package sgcfei.menus.Administrador.Catalogos.Academia;

import accesodatos.AcademiaDAO;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojos.Academia;
import pojos.Academico;
import util.ControladorVentanas;
import util.Validador;

public class EditarController implements Initializable {

    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfDescripcion;
    @FXML
    private ComboBox<Academico> cboxCoordinador;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    private Academia academia;
    private ObservableList<Academico> coordinadores = FXCollections.observableArrayList();
    private boolean datosCorrectos;

    public EditarController(Academia academia) {
        this.academia = academia;
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        tfNombre.setText(academia.getNombre());
        tfDescripcion.setText(academia.getDescripcion());

        AcademicoDAO dao =  new AcademicoDAO();
        Academico coordinador = dao.obtener(academia.getIdCoordinador());
        
        coordinadores.setAll(dao.obtenerAcademicosPorRol("Coordinador"));
        cboxCoordinador.setItems(coordinadores);
        cboxCoordinador.getSelectionModel().select(coordinador);
    }    

    @FXML
    private void aceptar(MouseEvent event) {
        datosCorrectos = true;
        String nombre = tfNombre.getText();
        String descripcion = tfDescripcion.getText();
        String idCoordinador = cboxCoordinador.getValue().getNumeroPersonal();
        
        if(!Validador.validarNombre(nombre)){
            datosCorrectos = false;
        }
        else if(nombre.length() >= 255){
            datosCorrectos = false;
        }
        else if(descripcion.length() >= 255){
            datosCorrectos = false;
        }
        
        if(nombre.isEmpty() || descripcion.isEmpty()){
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        else{
            if(datosCorrectos){
                academia.setNombre(nombre);
                academia.setDescripcion(descripcion);
                academia.setIdCoordinador(idCoordinador);
                
                AcademiaDAO dao = new AcademiaDAO();
                dao.actualizar(academia);
                
                Alert alerta = ControladorVentanas.crearAlerta("Operación exitosa",
                        "Se ha actualizado una academia correctamente", Alert.AlertType.INFORMATION);
                alerta.showAndWait();
                
                cerrar();
            }
            else{
                Alert alerta = ControladorVentanas.crearAlerta("Datos incorrectos",
                        "Los datos ingresados no son del tipo adecuado, por favor verificar", Alert.AlertType.ERROR);
                alerta.showAndWait();
            }
        }
    }
    
    @FXML
    private void cancelar(MouseEvent event) {
        Alert alerta = ControladorVentanas.crearAlerta("Confirmación",
                        "¿Está seguro que desea cancelar los cambios?", Alert.AlertType.CONFIRMATION);
        Optional<ButtonType> respuesta = alerta.showAndWait();
        
        if(respuesta.get() == ButtonType.OK){
            cerrar();
        }
    }
    
    private void cerrar(){
        Stage stageActual = (Stage) btnCancelar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/Academia/Registros.fxml",
                    "Catálogo de Academia", stageActual);
    }
    
}
