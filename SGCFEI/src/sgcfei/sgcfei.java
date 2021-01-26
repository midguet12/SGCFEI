package sgcfei;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class sgcfei extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/sgcfei/menus/Administrador/Catalogos/SeleccionarCatalogo.fxml"));
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }
    
}