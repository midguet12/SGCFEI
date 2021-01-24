package sgcfei.menus.Administrador.Catalogos.Academico;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojos.Academico;
import util.ControladorVentanas;

public class ConsultarController implements Initializable {

    @FXML
    private Label lblNumeroPersonal;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblCorreo;
    @FXML
    private Label lblRol;
    @FXML
    private Button btnAceptar;
    private Academico academico;    

    public ConsultarController(Academico academico) {
        this.academico = academico;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(academico);
        
        lblNumeroPersonal.setText(academico.getNumeroPersonal());
        lblNombre.setText(academico.getNombre());
        lblCorreo.setText(academico.getCorreo());
        lblRol.setText(academico.getRol());
    }    

    @FXML
    private void aceptar(MouseEvent event) {
        Stage stageActual = (Stage) btnAceptar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/Academico/Registros.fxml",
                    "Catálogo de Academia", stageActual);
    }
    
}
