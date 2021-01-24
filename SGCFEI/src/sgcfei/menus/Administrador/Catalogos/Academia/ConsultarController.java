package sgcfei.menus.Administrador.Catalogos.Academia;

import accesodatos.AcademicoDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojos.Academia;
import pojos.Academico;
import util.ControladorVentanas;

public class ConsultarController implements Initializable {
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblDescripcion;
    @FXML
    private Label lblCoordinador;
    @FXML
    private Button btnAceptar;
    private Academia academia;

    public ConsultarController(Academia academia) {
        this.academia = academia;
    }
          
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AcademicoDAO dao = new AcademicoDAO();
        Academico academico = dao.obtener(academia.getIdCoordinador());
                        
        lblNombre.setText("Academia de " + academia.getNombre());
        lblDescripcion.setText(academia.getDescripcion());
        lblCoordinador.setText(academico.getNombre());
    }    

    @FXML
    private void aceptar(MouseEvent event) {
        Stage stageActual = (Stage) btnAceptar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/Academia/Registros.fxml",
                    "Catálogo de Academia", stageActual);
    }
    
}
