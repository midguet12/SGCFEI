package sgcfei.menus.Administrador.Catalogos.LGCA;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojos.LGCA;
import util.ControladorVentanas;

public class ConsultarController implements Initializable {

    @FXML
    private Label lblClave;
    @FXML
    private Label lblDescripcion;
    @FXML
    private Button btnAceptar;
    private LGCA lgca;

    public ConsultarController(LGCA lgca) {
        this.lgca = lgca;
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblClave.setText(Integer.toString(lgca.getClave()));
        lblDescripcion.setText(lgca.getDescripcion());
    }    

    @FXML
    private void aceptar(MouseEvent event) {
        Stage stageActual = (Stage) btnAceptar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/LGCA/Registros.fxml",
                    "Catálogo de Experiencia Educativa", stageActual);
    }
    
}
