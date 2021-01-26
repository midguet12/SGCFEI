package sgcfei.menus.Administrador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.ControladorVentanas;

public class MenuController implements Initializable {

    @FXML
    private Button btnConsultar;
    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnCatalogo;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void abrirConsultarUsuarios(MouseEvent event) {
        Stage stageActual = (Stage) btnCatalogo.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/ConsultarUsuario/ConsultarUsuario.fxml",
                    "Catálogo de Academia", stageActual);
    }

    @FXML
    private void abrirAgregarUsuarios(MouseEvent event) {
        Stage stageActual = (Stage) btnCatalogo.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/RegistrarUsuario/RegistrarUsuario.fxml",
                    "Catálogo de Academia", stageActual);
    }

    @FXML
    private void abrirCatalogo(MouseEvent event) {
        Stage stageActual = (Stage) btnCatalogo.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/SeleccionarCatalogo.fxml",
                    "Seleccionar Catalogo", stageActual);
    }
    
}
