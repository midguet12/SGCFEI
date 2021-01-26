/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcfei.menus.Administrador.ConsultarUsuario.EditarUsuario;

import accesodatos.AcademicoDAO;
import accesodatos.UsuarioDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pojos.Academico;
import pojos.Usuario;
import util.ControladorVentanas;
import util.Encriptacion;
import util.Portapapeles;
import util.Validador;

/**
 * FXML Controller class
 *
 * @author Luis
 */

public class EditarUsuarioController implements Initializable {

    @FXML
    private TextField tfNumeroPersonal;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfCorreo;
    @FXML
    private ComboBox<String> cbTipoUsuario;
    @FXML
    private Button btnModificar;
    private ObservableList<String> roles = FXCollections.observableArrayList();
    private boolean datosValidos = true;
    Alert alerta;
    private String numeroPersonalAcademico;
    @FXML
    private TextField pfContraseña;

    public EditarUsuarioController(String numeroPersonalAcademico) {
        this.numeroPersonalAcademico = numeroPersonalAcademico;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        recuperarAcademico();
        cargarRoles();
        tfNumeroPersonal.setEditable(false);
        agregarListenerTextFields();
    }    
    
    private void cargarRoles(){
        roles.add("Director");
        roles.add("Coordinador");
        roles.add("Docente");
        cbTipoUsuario.setItems(roles);
    }

    private void agregarListenerTextFields() {
        Validador validador = new Validador();
        
        tfNombre.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(validador.validarNombre(newValue)){
                    tfNombre.setStyle("-fx-background-color: white;");
                    datosValidos = true;
                }else{
                    tfNombre.setStyle("-fx-background-color: red;");
                    datosValidos = false;
                }
            }
        
        });
        
        tfCorreo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(validador.validarCorreo(newValue)){
                    tfCorreo.setStyle("-fx-background-color: white;");
                    datosValidos = true;
                }else{
                    tfCorreo.setStyle("-fx-background-color: red;");
                    datosValidos = false;
                }
            }
        
        });
        
        pfContraseña.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(validador.validarContraseña(newValue)){
                    pfContraseña.setStyle("-fx-background-color: white;");
                    datosValidos = true;
                }else{
                    pfContraseña.setStyle("-fx-background-color: red;");
                    datosValidos = false;
                }
            }
        
        });
    }

    private void comprobarDatos() {
        if(datosValidos && cbTipoUsuario.getSelectionModel().getSelectedItem() != null && !camposVacios()){
            validarCorreo();
        }else{
            alerta = ControladorVentanas.crearAlerta("Informacion invalida", "Favor de verificar su informacion", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
    }

    private void validarCorreo() {
        boolean esCorreoRegistrado = new UsuarioDAO().esCorreoRegistradoModificar(tfCorreo.getText().toLowerCase(), numeroPersonalAcademico);
        if(esCorreoRegistrado){
            alerta = ControladorVentanas.crearAlerta("Correo registrado", "El correo ingresado ya se encuentra registrado", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }else{
            guardarCambios();
        }
    }

    private void guardarCambios() {
        Academico academico = new Academico(numeroPersonalAcademico, tfNombre.getText(), tfCorreo.getText().toLowerCase(), cbTipoUsuario.getSelectionModel().getSelectedItem());
        Boolean esAcademicoActualizado = new AcademicoDAO().actualizar(academico);
        if (esAcademicoActualizado) {
            Usuario usuario = new Usuario();
            usuario.setIdAcademico(numeroPersonalAcademico);
            usuario.setUsername(tfCorreo.getText());
            boolean esUsuarioActualizado = false;
            if (pfContraseña.getText().isEmpty()) {
                esUsuarioActualizado = new UsuarioDAO().actualizarCorreoUsuario(usuario);
            }else{
                String contraseña = Encriptacion.encriptarSHA2(pfContraseña.getText());
                usuario.setPassword(contraseña);
                esUsuarioActualizado = new UsuarioDAO().actualizarUsuarioContraseña(usuario);
            }
            if (esUsuarioActualizado) {
                Portapapeles.CopiarAlPortapapeles(tfCorreo.getText(), pfContraseña.getText());
                Stage stageActual = (Stage) btnModificar.getScene().getWindow();
                ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/ConsultarUsuario/ConsultarUsuario.fxml",
                    "Consultar usuarios", stageActual);
                alerta = ControladorVentanas.crearAlerta("Usuario modificado", "La informacion del usuario se ha actualizado en el sistema y se ha copiado al portapapeles", Alert.AlertType.INFORMATION);
                alerta.showAndWait();
            }
        }
    }

    @FXML
    private void clicModificar(ActionEvent event) {
        comprobarDatos();
    }

    private void recuperarAcademico() {
        Academico academico = new AcademicoDAO().obtener(numeroPersonalAcademico);
        cargarInformacion(academico);
    }

    private void cargarInformacion(Academico academico) {
        tfNumeroPersonal.setText(academico.getNumeroPersonal());
        tfNombre.setText(academico.getNombre());
        tfCorreo.setText(academico.getCorreo());
        cbTipoUsuario.getSelectionModel().select(academico.getRol());
    }
    
    private boolean camposVacios() {
        boolean esVacio = false;
        if (tfNumeroPersonal.getText().isEmpty()) {
            esVacio = true;
        }
        
        if (tfNombre.getText().isEmpty()) {
            esVacio = true;
        }
        
        if (tfCorreo.getText().isEmpty()) {
            esVacio = true;
        }
        return esVacio;
    }

    @FXML
    private void clicBotonCerrar(ActionEvent event) {
        Stage stageActual = (Stage) btnModificar.getScene().getWindow();
                ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/ConsultarUsuario/ConsultarUsuario.fxml",
                    "Consultar usuarios", stageActual);
    }
}
