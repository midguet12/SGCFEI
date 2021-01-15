package main;

import accesodatos.AcademiaDAO;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pojos.Academia;

public class pruebas extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Click");
        btn.setOnAction((ActionEvent event) -> {
            AcademiaDAO dao = new AcademiaDAO();
            
//            Academia acad = new Academia("Matematicas", "Academia a cargo de las EE del area de matematicas.", 23165);            
//            dao.insertar(acad);

//            Academia acad = (Academia)dao.obtener(1);
//            System.out.println(acad);

//            Academia acad = new Academia(1, "Matematicas", "anosewe XD", 23547);            
//            dao.actualizar(acad);

//            dao.eliminar(3);

        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 400, 350);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
