/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcfei.menus.Coordinador.RegistrarPrograma;

import accesodatos.AcademiaDAO;
import accesodatos.CampusDAO;
import accesodatos.DependenciaDAO;
import accesodatos.ExperienciaEducativaDAO;
import accesodatos.ProgramaEducativoDAO;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import pojos.ProgramaExperiencia;
import accesodatos.ProgramaExperienciaDAO;

/**
 * FXML Controller class
 *
 * @author midgu
 */
public class RegistrarProgramaController implements Initializable {

    @FXML
    private ComboBox<String> areaAcademica;
    @FXML
    private ObservableList<String> areasAcademicas;
    @FXML
    private ComboBox<String> programaEducativo;
    @FXML
    private ObservableList<String> programasEducativos;
    @FXML
    private ComboBox<String> campus;
    @FXML
    private ObservableList<String> campuses;
    @FXML
    private ComboBox<String> academia;
    @FXML 
    private ObservableList<String> academias;
    @FXML
    private TextField codigo;
    @FXML
    private ComboBox<String> experienciaEducativa;
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
    private ComboBox<String> individualGrupal;
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
    private TextArea teoricos;
    @FXML
    private TextArea heuristicos;
    @FXML
    private TextArea axiologicos;
    @FXML
    private TextArea estrategiasAprendizaje;
    @FXML
    private TextArea estrategiasEnsenanza;
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
    @FXML 
    private ObservableList<String> experiencias = null;
    @FXML
    private Button guardar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AcademiaDAO academiaDAO = new AcademiaDAO();
        areasAcademicas = FXCollections.observableArrayList(academiaDAO.obtenerNombres());
        areaAcademica.setItems(areasAcademicas);
        
        
        
        ProgramaEducativoDAO programaEducativoDAO = new ProgramaEducativoDAO();
        programasEducativos = FXCollections.observableArrayList(programaEducativoDAO.obtenerNombres());
        programaEducativo.setItems(programasEducativos);
        
        CampusDAO campusDAO = new CampusDAO();
        campuses = FXCollections.observableArrayList(campusDAO.obtenerNombres());
        campus.setItems(campuses);
        
        DependenciaDAO dependenciaDAO = new DependenciaDAO();
        academias = FXCollections.observableArrayList(dependenciaDAO.obtenerNombres());
        academia.setItems(academias);
         
        ExperienciaEducativaDAO experienciaEducativaDAO = new ExperienciaEducativaDAO();
        experiencias = FXCollections.observableArrayList(experienciaEducativaDAO.obtenerNombres());
        experienciaEducativa.setItems(experiencias);
        
        
        //ObservableList
        individualGrupal.setItems(FXCollections.observableArrayList("Individual", "Grupal"));
        
        
    }    

    @FXML
    private void areaAcademica(ActionEvent event) {
    }

    @FXML
    private void programaEducativo(ActionEvent event) {
    }

    @FXML
    private void campus(ActionEvent event) {
    }

    @FXML
    private void academia(ActionEvent event) {
    }

    @FXML
    private void codigo(ActionEvent event) {
    }

    @FXML
    private void experienciaEducativa(ActionEvent event) {
    }

    @FXML
    private void principal(ActionEvent event) {
    }

    @FXML
    private void secundaria(ActionEvent event) {
    }

    @FXML
    private void creditos(ActionEvent event) {
    }

    @FXML
    private void teoria(ActionEvent event) {
    }

    @FXML
    private void practica(ActionEvent event) {
    }

    @FXML
    private void totalHoras(ActionEvent event) {
    }

    @FXML
    private void equivalencias(ActionEvent event) {
    }

    @FXML
    private void modalidad(ActionEvent event) {
    }

    @FXML
    private void oportunidadesEvaluacion(ActionEvent event) {
    }

    @FXML
    private void individualGrupal(ActionEvent event) {
    }

    @FXML
    private void maximo(ActionEvent event) {
    }

    @FXML
    private void minimo(ActionEvent event) {
    }

    @FXML
    private void agrupacion(ActionEvent event) {
    }

    @FXML
    private void proyecto(ActionEvent event) {
    }

    @FXML
    private void espacio(ActionEvent event) {
    }

    @FXML
    private void relacionDisciplinaria(ActionEvent event) {
    }

    @FXML
    private void guardar(ActionEvent event) {
        
      
        ProgramaExperiencia programaExperiencia = new ProgramaExperiencia(
                areaAcademica.getValue().toString(),
                programaEducativo.getValue().toString(),
                campus.getValue().toString(),
                academia.getValue().toString(),
                Integer.parseInt(codigo.getText()),
                individualGrupal.getValue().toString(),
                Integer.parseInt(maximo.getText()),
                Integer.parseInt(minimo.getText()),
                proyecto.getText(),
                academicos.getText(),
                perfil.getText(),
                espacio.getText(),
                relacionDisciplinaria.getText(),
                descripcion.getText(),
                justificacion.getText(),
                unidadCompetencia.getText(),
                articulacion.getText(),
                teoricos.getText(),
                heuristicos.getText(),
                axiologicos.getText(),
                estrategiasAprendizaje.getText(),
                estrategiasEnsenanza.getText(),
                materialesDidacticos.getText(),
                recursosDidacticos.getText(),
                evaluacion.getText(),
                acreditacion.getText(),
                bibliografiaBasica.getText(),
                bibliografiaComplementaria.getText()
        );
        
        ProgramaExperienciaDAO programaExperienciaDAO = new ProgramaExperienciaDAO();
        programaExperienciaDAO.insertar(programaExperiencia);
        
    }
    
    
    
}
