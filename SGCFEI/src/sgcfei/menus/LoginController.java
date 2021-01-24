package sgcfei.menus;
import util.ControladorVentanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class LoginController implements Initializable {
    @FXML
    private TextField tfUsername = new TextField();
    @FXML
    private PasswordField tfPassword = new PasswordField();
    @FXML
    private Button button = new Button ();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }
    
    @FXML
    public void loginPorIntro(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){
            login();
        }
    }
    
    @FXML
    public void loginPorClick(MouseEvent e) {
        login();
    }
    
    private void login(){
        String username = tfUsername.getCharacters().toString();
        String password = tfPassword.getCharacters().toString();
        Stage stageActual = (Stage) button.getScene().getWindow();
        
        if(username.isEmpty() || password.isEmpty()){
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                        "El usuario o contraseña no puede estar vacio.", Alert.AlertType.ERROR);
                alerta.showAndWait();
        }
        else{

        }
        
//        if(userLogin.equals("admin")){
//            System.out.println("Entrando como " + userLogin);
//            ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Menu.fxml", "Menu principal", stageActual);
//        }
//        else if(userLogin.equals("coord")){
//            System.out.println("Entrando como " + userLogin);
//            ControladorVentanas.abrirYCerrar("/sgcfei/menus/Coordinador/Menu.fxml", "Menu principal", stageActual);
//        }
//        else if(userLogin.equals("dir")){
//            System.out.println("Entrando como " + userLogin);
//            ControladorVentanas.abrirYCerrar("/sgcfei/menus/Director/Menu.fxml", "Menu principal", stageActual);
//        }
//        else if(userLogin.equals("doc")){
//            System.out.println("Entrando como " + userLogin);
//            ControladorVentanas.abrirYCerrar("/sgcfei/menus/Docente/Menu.fxml", "Menu principal", stageActual);
//        }
    }
}
