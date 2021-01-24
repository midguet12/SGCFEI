package util;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
        catch (IOException ex) {
            RegistroExcepciones.escribirExcepcion(ex, "ControladorVentanas");
        }
    }

    public static void abrirYCerrar(String nombreFXML, String titulo, Stage stageActual){
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
        catch (IOException ex) {
            RegistroExcepciones.escribirExcepcion(ex, "ControladorVentanas");
        }
    }

    public static void abrirConControlador(String nombreFXML, String titulo, Object controller){
        FXMLLoader fxmlLoader;
        Parent raiz;

        try {
            fxmlLoader = new FXMLLoader(ControladorVentanas.class.getResource(nombreFXML));
            fxmlLoader.setController(controller);
            raiz = (Parent) fxmlLoader.load();

            Stage nuevaStage = new Stage();
            nuevaStage.setScene(new Scene(raiz));
            nuevaStage.setTitle(titulo);
            nuevaStage.initModality(Modality.APPLICATION_MODAL);

            nuevaStage.showAndWait();
        }
        catch (IOException ex) {
            RegistroExcepciones.escribirExcepcion(ex, "ControladorVentanas");
        }
    }
    
    public static void abrirYCerrarConControlador(String nombreFXML, String titulo, Object controller, Stage stageActual){
        abrirConControlador(nombreFXML, titulo, controller);
        stageActual.close();
    }
    
    public static Alert crearAlerta(String titulo, String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        return alert;
    }
}
