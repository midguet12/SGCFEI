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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojos.Academico;
import util.ControladorVentanas;
import util.Validador;

public class EditarController implements Initializable {
    @FXML
    private TextField lblNumeroPersonal;
    @FXML
    private TextField lblNombre;
    @FXML
    private TextField lblCorreo;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    @FXML
    private ComboBox<String> cboxRol;
    private ObservableList<String> roles = FXCollections.observableArrayList();
    private boolean datosCorrectos = true;
    private Academico academico;

    public EditarController(Academico academico) {
        this.academico = academico;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        roles.addAll("Administrador", "Coordinador", "Profesor");
        cboxRol.setItems(roles);
        cboxRol.getSelectionModel().select(0);
        
        lblNumeroPersonal.setText(academico.getNumeroPersonal());
        lblNombre.setText(academico.getNombre());
        lblCorreo.setText(academico.getCorreo());
        cboxRol.getSelectionModel().select(academico.getRol());
    }    

    @FXML
    private void aceptar(MouseEvent event) {
        String numeroPersonal = lblNumeroPersonal.getText();
        String nombre = lblNombre.getText();
        String correo = lblCorreo.getText();
        String rol = cboxRol.getValue();
        
        if(!Validador.validarNombre(nombre)){
            datosCorrectos = false;
        }
        if(nombre.length() > 254){
            datosCorrectos = false;
        }
        if(numeroPersonal.length() > 10){
            datosCorrectos = false;
        }
        if(!Validador.validarCorreo(correo)){
            datosCorrectos = false;
        }
        if(correo.length() > 254){
            datosCorrectos = false;
        }
        
        if(numeroPersonal.isEmpty() || nombre.isEmpty() || correo.isEmpty()){
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        else{
            if(datosCorrectos){
                Academico academico = new Academico(numeroPersonal, nombre, correo, rol);            
                AcademicoDAO dao = new AcademicoDAO();
                dao.actualizar(academico);
                
                Alert alerta = ControladorVentanas.crearAlerta("Operación exitosa",
                        "Se ha actualizado un academico correctamente", Alert.AlertType.INFORMATION);
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
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/Academico/Registros.fxml",
                    "Catálogo de Academia", stageActual);
    }
}
