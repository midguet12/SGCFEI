/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcfei.menus.Coordinador.EditarPrograma;

import accesodatos.ProgramaExperienciaDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pojos.LGCA;
import pojos.ProgramaExperiencia;

/**
 * FXML Controller class
 *
 * @author midgu
 */
public class EditarProgramaController implements Initializable {

    @FXML
    private ComboBox<?> areaAcademica;
    @FXML
    private ComboBox<?> programaEducativo;
    @FXML
    private ComboBox<?> campus;
    @FXML
    private ComboBox<?> academia;
    @FXML
    private TextField codigo;
    @FXML
    private ComboBox<?> experienciaEducativo;
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
    private TextArea academico;
    @FXML
    private TextArea perfilDocente;
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
    private TextArea teoricos;
    @FXML
    private TextArea heuristicos;
    @FXML
    private TextArea axiologicos;
    @FXML
    private TextArea aprendizaje;
    @FXML
    private TextArea ensenanza;
    @FXML
    private TextArea materialesDidacticos;
    @FXML
    private TextArea recursosDidacticos;
    @FXML
    private TextArea evaluacion;
    @FXML
    private TextArea acreditacion;
    @FXML
    private TextArea bibliografiaBasica;
    @FXML
    private TextArea bibliografiaComplementaria;

    /**
     * Initializes the controller class.
     */
    LGCA lgca = null;
    public EditarProgramaController(LGCA lgca){
        this.lgca = lgca;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ProgramaExperienciaDAO programaExperienciaDAO = new ProgramaExperienciaDAO();
        ProgramaExperiencia programaExperiencia = programaExperienciaDAO.obtener(1);
        
        
        
        codigo.setText(String.valueOf(programaExperiencia.getNcr()));
        maximo.setText(String.valueOf(programaExperiencia.getMaximo()));
        minimo.setText(String.valueOf(programaExperiencia.getMinimo()));
        proyecto.setText(String.valueOf(programaExperiencia.getProyecto()));
        academico.setText(String.valueOf(programaExperiencia.getAcademicos()));
        perfilDocente.setText(String.valueOf(programaExperiencia.getPerfil()));
        espacio.setText(String.valueOf(programaExperiencia.getEspacio()));
        relacionDisciplinaria.setText(String.valueOf(programaExperiencia.getRelacionDisciplinaria()));
        descripcion.setText(String.valueOf(programaExperiencia.getDescripcion()));
        justificacion.setText(String.valueOf(programaExperiencia.getJustificacion()));
        unidadCompetencia.setText(String.valueOf(programaExperiencia.getUnidadCompetencia()));
        articulacion.setText(String.valueOf(programaExperiencia.getArticulacion()));
        teoricos.setText(String.valueOf(programaExperiencia.getSaberTeorico()));
        axiologicos.setText(String.valueOf(programaExperiencia.getAxiologicos()));
        heuristicos.setText(String.valueOf(programaExperiencia.getHeuristico()));
        aprendizaje.setText(String.valueOf(programaExperiencia.getEstrategiasAprendizaje()));
        ensenanza.setText(String.valueOf(programaExperiencia.getEstrategiasEnsenanza()));
        
        //principal.
        
        
    }    

    @FXML
    private void guardar(ActionEvent event) {
    }
    
}
