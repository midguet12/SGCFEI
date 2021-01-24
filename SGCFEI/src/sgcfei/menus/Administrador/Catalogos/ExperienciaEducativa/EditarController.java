package sgcfei.menus.Administrador.Catalogos.ExperienciaEducativa;

import accesodatos.AcademiaDAO;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojos.Academia;
import pojos.ExperienciaEducativa;
import util.ControladorVentanas;
import util.Validador;

public class EditarController implements Initializable {

    @FXML
    private TextField tfNrc;
    @FXML
    private TextField tfNombre;
    @FXML
    private ComboBox<Academia> cboxAcademia;
    @FXML
    private Button btnAceptar;
    @FXML
    private Button btnCancelar;
    private ObservableList<Academia> listaAcademias;
    private ExperienciaEducativa experiencia;
    private boolean datosCorrectos;

    public EditarController(ExperienciaEducativa experiencia) {
        this.experiencia = experiencia;
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AcademiaDAO dao = new AcademiaDAO();
        listaAcademias = FXCollections.observableArrayList();
        listaAcademias.addAll(dao.obtenerTodasAcademias());
        cboxAcademia.setItems(listaAcademias);      
        
        tfNrc.setText(Integer.toString(experiencia.getNrc()));
        tfNombre.setText(experiencia.getNombre());
        cboxAcademia.getSelectionModel().select(dao.obtener(experiencia.getIdAcademia()));
        tfNrc.setDisable(true);
    }    

    @FXML
    private void aceptar(MouseEvent event) {
        datosCorrectos = true;
        String nrc = tfNrc.getText();
        String nombre = tfNombre.getText();
        Academia academia = cboxAcademia.getValue();
        
        if(!Validador.numero(nrc)){
            datosCorrectos = false;
        }
        if(nrc.length() != 5){
            datosCorrectos = false;
        }
        if(nombre.length() > 254){
            datosCorrectos = false;
        }
        
        if(nrc.isEmpty() || nombre.isEmpty()){
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        else{
            if(datosCorrectos){
                ExperienciaEducativa experiencia = new ExperienciaEducativa(Integer.parseInt(nrc), nombre, academia.getIdAcademia());            
                ExperienciaEducativaDAO dao = new ExperienciaEducativaDAO();
                dao.actualizar(experiencia);
                
                Alert alerta = ControladorVentanas.crearAlerta("Operación exitosa",
                        "Se ha actualizado una Experiencia Educativa correctamente", Alert.AlertType.INFORMATION);
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
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/ExperienciaEducativa/Registros.fxml",
                    "Catálogo de Academia", stageActual);
    }
    
}
