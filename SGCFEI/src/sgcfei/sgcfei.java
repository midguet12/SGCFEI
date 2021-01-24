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
        /*Parent root = FXMLLoader.load(getClass().getResource("/sgcfei/menus/Login.fxml"));
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 300, 300));
        stage.show();*/
        
        Campus campus = new CampusDAO().obtener(2);
        campus.setNombre("Minatitlan");
        
        
        
        //System.out.println(campus.getNombre());
        
        
        
        CampusDAO campusDAO = new CampusDAO();
        campusDAO.eliminar(1);
        
        //campusDAO.insertar(campus);
        
        
        
        /*List<ProgramaEducativo> programasEducativos = programaEducativoDAO.obtenerTodosProgramas();
        for (int i = 0; i < 10; i++) {
            System.out.println(programasEducativos.get(i).getNombre());
        }*/
        
        
        
    }
    
    
    
}