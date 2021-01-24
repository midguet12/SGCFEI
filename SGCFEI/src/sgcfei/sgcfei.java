package sgcfei;

import accesodatos.UsuarioDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pojos.Usuario;

public class sgcfei extends Application{

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        /*Parent root = FXMLLoader.load(getClass().getResource("/sgcfei/menus/Login.fxml"));
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 300, 300));
        stage.show();*/
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        Usuario usuario = usuarioDAO.obtener(1);
        
        String x = usuario.getUsername();
        
        System.out.println(x);
        
        
        
    }
    
}