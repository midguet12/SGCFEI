package sgcfei.menus;
import accesodatos.AcademicoDAO;
import accesodatos.UsuarioDAO;
import util.ControladorVentanas;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojos.Academico;
import pojos.Usuario;
import util.Encriptacion;


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
            UsuarioDAO dao = new UsuarioDAO();
            if(dao.esCorreoRegistrado(username)){
                Usuario user = dao.obtener(username);
                password = Encriptacion.encriptarSHA2(password);
            
                if(user.getPassword().equals(password)){
                    AcademicoDAO daoAcad = new AcademicoDAO();
                    Academico academico = daoAcad.obtener(user.getIdAcademico());
                    
                    ControladorVentanas.abrirYCerrar("/sgcfei/menus/" + academico.getRol()
                            +"/Menu.fxml", "Menu principal", stageActual);
                }
                else{
                    Alert alerta = ControladorVentanas.crearAlerta("Correo o contraseña incorrectos",
                            "El usuario o contraseña son incorrectos.", Alert.AlertType.ERROR);
                    alerta.showAndWait();  
                    tfPassword.setText("");
                }
            }
            else{
                Alert alerta = ControladorVentanas.crearAlerta("Correo o contraseña incorrectos",
                        "El usuario o contraseña son incorrectos.", Alert.AlertType.ERROR);
                alerta.showAndWait(); 
                tfPassword.setText("");
            }
        }
    }
}
