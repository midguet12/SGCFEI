/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcfei.menus.Coordinador.Programa.RegistrarPrograma;

import accesodatos.ExperienciaEducativaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pojos.ExperienciaEducativa;

/**
 * FXML Controller class
 *
 * @author midgu
 */
public class RegistrarProgramaController implements Initializable {

    @FXML
    private ComboBox<?> areaAcademica;
    @FXML
    private ComboBox<?> programaEducativo;
    @FXML
    private ComboBox<?> campus;
    @FXML
    private ComboBox<?> dependencia;
    @FXML
    private TextField nrc;
    @FXML
    private ComboBox<String> experienciaEducativa;
    private ObservableList<ExperienciaEducativa> experienciasEducativas;
    
    @FXML
    private TextField principal;
    @FXML
    private TextField secundaria;
    @FXML
    private TextField creditos;
    @FXML
    private TextField teoria;
    @FXML
    private TextField practica;
    @FXML
    private TextField totalHoras;
    @FXML
    private TextField equivalencias;
    @FXML
    private TextField modalidad;
    @FXML
    private TextField oportunidadesEvaluacion;
    @FXML
    private TextArea prerequisitos;
    @FXML
    private TextArea corequisitos;
    @FXML
    private ComboBox<?> individualGrupal;
    @FXML
    private TextField maximo;
    @FXML
    private TextField minimo;
    @FXML
    private TextField agrupacion;
    @FXML
    private TextField proyecto;
    @FXML
    private TextArea academicos;
    @FXML
    private TextArea perfil;
    @FXML
    private TextField espacio;
    @FXML
    private TextField relacionDisciplinaria;
    @FXML
    private TextArea descripcion;
    @FXML
    private TextArea justificacion;
    @FXML
    private TextArea unidadCompetencia;
    @FXML
    private TextArea articulacion;
    @FXML
    private TextArea teorico;
    @FXML
    private TextArea heuristico;
    @FXML
    private TextArea axiologico;
    @FXML
    private TextArea estrategiaAprendizaje;
    @FXML
    private TextArea estrategiaEnsenanza;
    @FXML
    private TextArea materialesDidacticos;
    @FXML
    private TextArea recursosDidacticos;
    @FXML
    private TextArea acreditacion;
    @FXML
    private TextArea bibliografiaBasica;
    @FXML
    private TextArea bibliografiaComplementaria;
    @FXML
    private Button guardar;
    @FXML
    private TableColumn<?, ?> evidencia;
    @FXML
    private TableColumn<?, ?> criterio;
    @FXML
    private TableColumn<?, ?> ambito;
    @FXML
    private TableColumn<?, ?> porcentaje;
    @FXML
    private TextArea evidenciaEntrada;
    @FXML
    private TextArea criterioEntrada;
    @FXML
    private TextArea ambitoEntrada;
    @FXML
    private TextArea porcentajeEntrada;
    @FXML
    private Button agregarEvaluacion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void experienciaEducativa(ActionEvent event) {
        /*ExperienciaEducativaDAO experienciaEducativaDAO = new ExperienciaEducativaDAO();
        experienciasEducativas = FXCollections.observableArrayList()*/
    }
    

    @FXML
    private void guardar(ActionEvent event) {
    }

    @FXML
    private void agregarEvaluacion(ActionEvent event) {
    }
    
}
