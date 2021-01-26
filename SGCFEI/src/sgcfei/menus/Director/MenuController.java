package sgcfei.menus.Director;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.ControladorVentanas;

public class MenuController implements Initializable {

    @FXML
    private Button btnCerrarSesion;
    private Stage stageActual;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void consultarIndicadores(MouseEvent event) {
    }

    @FXML
    private void consultarReportes(MouseEvent event) {
    }

    @FXML
    private void consultarCatalogos(MouseEvent event) {
    }

    @FXML
    private void clicBotonCerrarSesion(ActionEvent event) {
        recuperarStage();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Login.fxml", "Login", stageActual);
    }
    
    private void recuperarStage(){
        stageActual = (Stage) btnCerrarSesion.getScene().getWindow();
    }
}
