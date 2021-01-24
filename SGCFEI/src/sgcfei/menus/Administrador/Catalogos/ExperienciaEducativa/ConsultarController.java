package sgcfei.menus.Administrador.Catalogos.ExperienciaEducativa;

import accesodatos.AcademiaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojos.Academia;
import pojos.ExperienciaEducativa;
import util.ControladorVentanas;

public class ConsultarController implements Initializable {

    @FXML
    private Label lblNrc;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblAcademia;
    @FXML
    private Button btnAceptar;
    private ExperienciaEducativa experienciaEducativa;

    public ConsultarController(ExperienciaEducativa experienciaEducativa) {
        this.experienciaEducativa = experienciaEducativa;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AcademiaDAO dao = new AcademiaDAO();
        Academia academia = dao.obtener(experienciaEducativa.getIdAcademia());
        
        lblNrc.setText(Integer.toString(experienciaEducativa.getNrc()));
        lblNombre.setText(experienciaEducativa.getNombre());
        lblAcademia.setText(academia.toString());
    }    

    @FXML
    private void aceptar(MouseEvent event) {
        Stage stageActual = (Stage) btnAceptar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/ExperienciaEducativa/Registros.fxml",
                    "Catálogo de Experiencia Educativa", stageActual);
    }
}
