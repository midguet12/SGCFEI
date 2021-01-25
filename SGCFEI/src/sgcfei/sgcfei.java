package sgcfei;

import accesodatos.AcademiaDAO;
import accesodatos.CampusDAO;
import accesodatos.ProgramaEducativoDAO;
import accesodatos.UsuarioDAO;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pojos.Academia;
import pojos.Campus;
import pojos.ProgramaEducativo;
import pojos.Usuario;

public class sgcfei extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sgcfei/menus/Coordinador/RegistrarPrograma/RegistrarPrograma.fxml"));
        stage.setTitle("pruebas");
        stage.setScene(new Scene(root, 1280, 720));
        stage.show();
        
       
        
        
        
    }
    
    
    
}