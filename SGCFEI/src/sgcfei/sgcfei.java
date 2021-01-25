package sgcfei;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import accesodatos.ExperienciaEducativaDAO;
import java.util.List;
import pojos.ExperienciaEducativa;

public class sgcfei extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sgcfei/menus/Administrador/Catalogos/LGCA/Registros.fxml"));
        
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 1391, 1010));
        stage.show();
        
    }
    
}