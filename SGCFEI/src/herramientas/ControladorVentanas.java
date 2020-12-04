package herramientas;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorVentanas {
    
    private static void abrir(String nombreFXML, String titulo){
        FXMLLoader fxmlLoader;
        Parent raiz;

        try {
            fxmlLoader = new FXMLLoader(ControladorVentanas.class.getResource(nombreFXML));
            raiz = (Parent) fxmlLoader.load();
            Stage nuevaStage = new Stage();
            nuevaStage.setScene(new Scene(raiz));
            nuevaStage.setTitle(titulo);

            nuevaStage.show();
        }
        catch (IOException e) {
            System.out.println(e);
            //TODO Tratar excepcion correctamente
        }
    }

    public static void abrir(String nombreFXML, String titulo, Stage stageActual){
        abrir(nombreFXML, titulo);
        stageActual.close();
    }

    public static void abrirYEsperar(String nombreFXML, String titulo){
        FXMLLoader fxmlLoader;
        Parent raiz;

        try {
            fxmlLoader = new FXMLLoader(ControladorVentanas.class.getResource(nombreFXML));
            raiz = (Parent) fxmlLoader.load();
            Stage nuevaStage = new Stage();
            nuevaStage.setScene(new Scene(raiz));
            nuevaStage.setTitle(titulo);
            nuevaStage.initModality(Modality.APPLICATION_MODAL);

            nuevaStage.showAndWait();
        }
        catch (IOException e) {
            System.out.println(e);
            ///TODO Tratar excepcion correctamente
        }
    }

//    public static void abrirWithController(String nombreFXML, String titulo, ControllerInterface controller){
//        FXMLLoader fxmlLoader;
//        Parent raiz;
//
//        try {
//            fxmlLoader = new FXMLLoader(ViewUtilities.class.getResource(nombreFXML));
//            fxmlLoader.setController(controller);
//            raiz = (Parent) fxmlLoader.load();
//
//            Stage nuevaStage = new Stage();
//            nuevaStage.setScene(new Scene(raiz));
//            nuevaStage.setTitle(titulo);
//            nuevaStage.initModality(Modality.APPLICATION_MODAL);
//
//            nuevaStage.showAndWait();
//        }
//        catch (IOException e) {
//            System.out.println(e);
//            //TODO Tratar excepcion correctamente
//        }
//    }
}
