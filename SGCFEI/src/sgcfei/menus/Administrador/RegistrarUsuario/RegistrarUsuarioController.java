/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcfei.menus.Administrador.RegistrarUsuario;

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
public class RegistrarUsuarioController implements Initializable {

    @FXML
    private TextField tfNumeroPersonal;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfCorreo;
    @FXML
    private ComboBox<String> cbTipoUsuario;
    @FXML
    private Button btnRegistrar;
    private ObservableList<String> roles;
    private boolean datosValidos = false;
    Alert alerta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        roles = FXCollections.observableArrayList();
        cargarRoles();
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
        
        tfNumeroPersonal.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(validador.numeroPersonal(newValue)){
                    tfNumeroPersonal.setStyle("-fx-background-color: white;");
                    datosValidos = true;
                }else{
                    tfNumeroPersonal.setStyle("-fx-background-color: red;");
                    datosValidos = false;
                }
            }
        
        });
        
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
    }

    private void comprobarDatos() {
        if(datosValidos && cbTipoUsuario.getSelectionModel().getSelectedItem() != null && !camposVacios()){
            validarNumeroPersonal();
        }else{
            alerta = ControladorVentanas.crearAlerta("Informacion invalida", "Favor de verificar su informacion", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
    }

    private void validarNumeroPersonal() {
        boolean numeroPersonalRegistrado = new AcademicoDAO().esNumeroPersonalRegistrado(tfNumeroPersonal.getText());  
        if(numeroPersonalRegistrado){
            alerta = ControladorVentanas.crearAlerta("Numero personal registrado", "El numero personal ingresado ya se encuentra registrado", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }else{
            validarCorreo();
        }
    }

    private void validarCorreo() {
        boolean esCorreoRegistrado = new UsuarioDAO().esCorreoRegistrado(tfCorreo.getText().toLowerCase());
        if(esCorreoRegistrado){
            alerta = ControladorVentanas.crearAlerta("Correo registrado", "El correo ingresado ya se encuentra registrado", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }else{
            guardarUsuario();
        }
    }

    private void guardarUsuario() {
        Academico academico = new Academico(tfNumeroPersonal.getText(), tfNombre.getText(), tfCorreo.getText().toLowerCase(), cbTipoUsuario.getSelectionModel().getSelectedItem());
        Boolean seInsertoAcademico = new AcademicoDAO().insertar(academico);
        if (seInsertoAcademico) {
            String password = Encriptacion.generarContraseñaAleatoria();
            Usuario usuario = new Usuario(tfCorreo.getText().toLowerCase(), Encriptacion.encriptarSHA2(password), tfNumeroPersonal.getText());
            boolean seInsertoUsuario = new UsuarioDAO().insertar(usuario);
            if (seInsertoUsuario) {
                Portapapeles.CopiarAlPortapapeles(tfCorreo.getText(), password);
                Stage stageActual = (Stage) btnRegistrar.getScene().getWindow();
                ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Menu.fxml","Menu principal Administrador",stageActual);
                alerta = ControladorVentanas.crearAlerta("Usuario registrado", "El usuario se ha registrado en el sistama, su contraseña se ha copiado al portapapeles", Alert.AlertType.INFORMATION);
                alerta.showAndWait();
            }
        }
    }

    @FXML
    private void clicBotonRegistrar(ActionEvent event) {
        comprobarDatos();
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
        Stage stageActual = (Stage) tfCorreo.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Menu.fxml","Menu principal Administrador",stageActual);
    }
}
