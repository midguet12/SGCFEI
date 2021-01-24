package sgcfei.menus.Administrador.Catalogos.LGCA;

import accesodatos.LGCADAO;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojos.LGCA;
import util.ControladorVentanas;
import util.Validador;

public class AgregarController implements Initializable {

    @FXML
    private TextField tfClave;
    @FXML
    private TextField tfDescripcion;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    private boolean datosCorrectos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void aceptar(MouseEvent event) {
        datosCorrectos = true;
        String clave = tfClave.getText();
        String descripcion = tfDescripcion.getText();
        
        if(!Validador.numero(clave)){
            datosCorrectos = false;
        }
        if(clave.length() != 7){
            datosCorrectos = false;
        }
        if(descripcion.length() > 254){
            datosCorrectos = false;
        }
        
        if(clave.isEmpty() || descripcion.isEmpty()){
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        else{
            if(datosCorrectos){
                LGCA lgca = new LGCA(Integer.parseInt(clave), descripcion);            
                LGCADAO dao = new LGCADAO();
                dao.insertar(lgca);
                
                Alert alerta = ControladorVentanas.crearAlerta("Operación exitosa",
                        "Se ha agregado una LGCA correctamente", Alert.AlertType.INFORMATION);
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
                        "¿Está seguro que desea cancelar el registro?", Alert.AlertType.CONFIRMATION);
        Optional<ButtonType> respuesta = alerta.showAndWait();
        
        if(respuesta.get() == ButtonType.OK){
            cerrar();
        }
    }
        
    private void cerrar(){
        Stage stageActual = (Stage) btnCancelar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/LGCA/Registros.fxml",
                    "Catálogo de Experiencia Educativa", stageActual);
    }
}
