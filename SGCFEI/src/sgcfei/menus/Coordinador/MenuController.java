package sgcfei.menus.Coordinador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pojos.Academico;
import sgcfei.menus.Coordinador.Minuta.RegistrarMinuta.RegistrarMinutaController;
import sgcfei.menus.Coordinador.Programa.ConsultarProgramaController;
import util.ControladorVentanas;

public class MenuController implements Initializable {
    private Academico academicoLogeado;
    @FXML
    private Font x1;
    @FXML
    private Button btnRegistrarMinuta;
    
    @FXML 
    private Button consultarProgramaExperiencia;

    public MenuController(Academico academicoLogeado) {
        this.academicoLogeado = academicoLogeado;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void registrarPlanAcademia(MouseEvent event) {
    }

    @FXML
    private void consultarPlanAcademia(MouseEvent event) {
    }

    @FXML
    private void registrarPlanCurso(MouseEvent event) {
    }

    @FXML
    private void consultarPlanCurso(MouseEvent event) {
    }

    @FXML
    private void registrarMinuta(MouseEvent event) {
        RegistrarMinutaController registrarMinutaController = new RegistrarMinutaController(academicoLogeado);
        Stage stageActual = (Stage) btnRegistrarMinuta.getScene().getWindow();
        ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Coordinador/Minuta/RegistrarMinuta/RegistrarMinuta.fxml", "Menu principal",registrarMinutaController, stageActual);
    }

    @FXML
    private void consultarMinuta(MouseEvent event) {
    }

    @FXML
    private void registrarPlanEstudios(MouseEvent event) {
    }

    @FXML
    private void consultarPlanEstudios(MouseEvent event) {
        ConsultarProgramaController consultarProgramaController = new ConsultarProgramaController();
        Stage stageActual = (Stage)  consultarProgramaExperiencia.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Coordinador/Programa/ConsultarPrograma.fxml", "Consultar programa", stageActual);
        
    }
}
