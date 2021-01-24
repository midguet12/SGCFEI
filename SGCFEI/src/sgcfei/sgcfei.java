package sgcfei;

import accesodatos.AcademiaDAO;
import accesodatos.ProgramaEducativoDAO;
import accesodatos.UsuarioDAO;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pojos.Academia;
import pojos.ProgramaEducativo;
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
        
        ProgramaEducativoDAO programaEducativoDAO = new ProgramaEducativoDAO();
        
        programaEducativoDAO.eliminar(3);
        
        /*List<ProgramaEducativo> programasEducativos = programaEducativoDAO.obtenerTodosProgramas();
        for (int i = 0; i < 10; i++) {
            System.out.println(programasEducativos.get(i).getNombre());
        }*/
        
        
        
    }
    
    
    
}