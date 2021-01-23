package sgcfei.menus.Administrador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import util.ControladorVentanas;

public class MenuController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void registrarUsuario(MouseEvent event) {
        ControladorVentanas.abrirYEsperar("/sgcfei/menus/Administrador/RegistrarUsuario/RegistrarUsuario.FXML", "Registrar Usuario");
    }

    @FXML
    private void consultarUsuario(MouseEvent event) {
        ControladorVentanas.abrirYEsperar("/sgcfei/menus/Administrador/ConsultarUsuario/ConsultarUsuario.FXML", "Registrar Usuario");
    }

    @FXML
    private void registrarCatalogo(MouseEvent event) {
    }

    @FXML
    private void consultarDetallesCatalogo(MouseEvent event) {
    }

    @FXML
    private void consultarCatalogo(MouseEvent event) {
    }
}
