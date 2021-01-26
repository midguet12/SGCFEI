package sgcfei.menus.Coordinador.Programa.RegistrarPrograma;

import accesodatos.AcademiaDAO;
import accesodatos.CampusDAO;
import accesodatos.DependenciaDAO;
import accesodatos.ExperienciaEducativaDAO;
import accesodatos.ProgramaEducativoDAO;
import accesodatos.ProgramaExperienciaDAO;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojos.ExperienciaEducativa;
import pojos.ProgramaExperiencia;
import util.ControladorVentanas;
import util.Validador;

public class RegistrarProgramaController implements Initializable {
    
    

    @FXML
    private ComboBox<String> areaAcademica;
    private ObservableList<String> areasAcademicas;
    @FXML
    private ComboBox<String> programaEducativo;
    private ObservableList<String> programasEducativos;
    @FXML
    private ComboBox<String> campus;
    private ObservableList<String> campuses;
    @FXML
    private ComboBox<String> dependencia;
    private ObservableList<String> dependencias;
    @FXML
    private TextField codigo;
    @FXML
    private ComboBox<String> experienciaEducativa;
    private ObservableList<String> experienciasEducativas;
    
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
    private TextArea evidenciaEntrada;
    @FXML
    private TextArea criterioEntrada;
    @FXML
    private Button agregarEvaluacion;
    @FXML
    private Button cancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
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
        dependencias = FXCollections.observableArrayList(dependenciaDAO.obtenerNombres());
        dependencia.setItems(dependencias);
        
        
        
        ExperienciaEducativaDAO experienciaEducativaDAO = new ExperienciaEducativaDAO();
        experienciasEducativas = FXCollections.observableArrayList(experienciaEducativaDAO.obtenerNombres());
        experienciaEducativa.setItems(experienciasEducativas);
        
        individualGrupal.setItems(FXCollections.observableArrayList("Individual", "Grupal"));
    }    

  

    @FXML
    private void guardar(ActionEvent event) {
        String academiaEntrada = areaAcademica.getValue();
        String programaEntrada = programaEducativo.getValue();
        String campusEntrada = campus.getValue();
        String dependenciaEntrada = dependencia.getValue();
        String codigoEntrada = codigo.getText();
        String nombreExperienciaEntrada = experienciaEducativa.getValue();
        String areaFormacionPrincipalEntrada = principal.getText();
        String areaFormacionSecundariaEntrada = secundaria.getText();
        
        String creditosEntrada = creditos.getText();
        String teoriaEntrada = teoria.getText();
        String practicaEntrada = practica.getText();  //Validar que sean enteros
        String totalHorasEntrada = totalHoras.getText();
        
        String equivalenciasEntrada = equivalencias.getText();
        String modalidadEntrada = modalidad.getText();
        String oportunidadesEvaluacionEntrada = oportunidadesEvaluacion.getText();
        String requisitosEntrada = prerequisitos.getText();
        String coRequisitosEntrada = corequisitos.getText();
        String individualGrupalEntrada = individualGrupal.getValue();

        String maximoEntrada = maximo.getText();
        String minimoEntrada = minimo.getText(); //Validar que sean enteros

        String agrupacionEntrada = agrupacion.getText();
        String proyectoEntrada = proyecto.getText();
        String academicosEntrada = academicos.getText();
        String perfilEntrada = perfil.getText();
        String espacioEntrada = espacio.getText();
        String relacionEntrada = relacionDisciplinaria.getText();
        String descripcionEntrada = descripcion.getText();
        String justificacionEntrada = justificacion.getText();

        String unidadCompetenciaEntrada = unidadCompetencia.getText();
        String articulacionEntrada = articulacion.getText();
        String teoricoEntrada = teorico.getText();
        String heuristicoEntrada = heuristico.getText();
        String axiologicosEntrada = axiologico.getText();
        String estrategiasAprendizajeEntrada = estrategiaAprendizaje.getText();
        String estrategiasEnsenanzaEntrada = estrategiaEnsenanza.getText();
        String materialesDidacticosEntrada = materialesDidacticos.getText();
        String recursosDidacticosEntrada = recursosDidacticos.getText();
        String acreditacionEntrada = acreditacion.getText();
        String bibliografiaBasicaEntrada = bibliografiaBasica.getText();
        String bibliografiaComplementariaEntrada = bibliografiaComplementaria.getText();
        
        boolean datosCorrectos = true;
        
        if (!Validador.numero(creditosEntrada) && !Validador.numero(teoriaEntrada) && !Validador.numero(practicaEntrada) && !Validador.numero(totalHorasEntrada) && !Validador.numero(maximoEntrada) && !Validador.numero(minimoEntrada)) {
            datosCorrectos = false;
            
        }
        
        if(espacioEntrada.length() > 30 || relacionEntrada.length() > 30){
            datosCorrectos = false;
        }
        
        if (academiaEntrada.isEmpty() || programaEntrada.isEmpty() || campusEntrada.isEmpty() || dependenciaEntrada.isEmpty()) {
            datosCorrectos = false;
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if (codigoEntrada.isEmpty() || nombreExperienciaEntrada.isEmpty() || areaFormacionPrincipalEntrada.isEmpty() || areaFormacionSecundariaEntrada.isEmpty()) {
            datosCorrectos = false;
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if (creditosEntrada.isEmpty() || teoriaEntrada.isEmpty() || practicaEntrada.isEmpty() || totalHorasEntrada.isEmpty()) {
            datosCorrectos = false;
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if (equivalenciasEntrada.isEmpty() || modalidadEntrada.isEmpty() || oportunidadesEvaluacionEntrada.isEmpty() || requisitosEntrada.isEmpty()) {
            datosCorrectos = false;
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if (coRequisitosEntrada.isEmpty() || individualGrupalEntrada.isEmpty() || maximoEntrada.isEmpty() || minimoEntrada.isEmpty()) {
            datosCorrectos = false;
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if (agrupacionEntrada.isEmpty() || proyectoEntrada.isEmpty() || academicosEntrada.isEmpty() || perfilEntrada.isEmpty()) {
            datosCorrectos = false;
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if ( espacioEntrada.isEmpty() || relacionEntrada.isEmpty() || descripcionEntrada.isEmpty() || justificacionEntrada.isEmpty()) {
            datosCorrectos = false;
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if (unidadCompetenciaEntrada.isEmpty() || articulacionEntrada.isEmpty() || teoricoEntrada.isEmpty() || heuristicoEntrada.isEmpty()) {
            datosCorrectos = false;
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        if (axiologicosEntrada.isEmpty() || estrategiasAprendizajeEntrada.isEmpty() || estrategiasEnsenanzaEntrada.isEmpty() || materialesDidacticosEntrada.isEmpty()) {
            datosCorrectos = false;
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        if (recursosDidacticosEntrada.isEmpty() || acreditacionEntrada.isEmpty() || bibliografiaBasicaEntrada.isEmpty() || bibliografiaComplementariaEntrada.isEmpty()) {
            datosCorrectos = false;
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        if (datosCorrectos) {

            ProgramaExperiencia programaExperiencia = new ProgramaExperiencia(
                    academiaEntrada,
                    programaEntrada,
                    campusEntrada,
                    dependenciaEntrada,
                    codigoEntrada,
                    nombreExperienciaEntrada,
                    areaFormacionPrincipalEntrada,
                    areaFormacionSecundariaEntrada,

                    Integer.parseInt(creditosEntrada),
                    Integer.parseInt(teoriaEntrada),
                    Integer.parseInt(practicaEntrada),  //Validar que sean enteros
                    Integer.parseInt(totalHorasEntrada),

                    equivalenciasEntrada,
                    modalidadEntrada,
                    oportunidadesEvaluacionEntrada,
                    requisitosEntrada,
                    coRequisitosEntrada,
                    individualGrupalEntrada,

                    Integer.parseInt(maximoEntrada),
                    Integer.parseInt(minimoEntrada), //Validar que sean enteros

                    agrupacionEntrada,
                    proyectoEntrada,
                    academicosEntrada,
                    perfilEntrada,
                    espacioEntrada,
                    relacionEntrada,
                    descripcionEntrada,
                    justificacionEntrada,

                    unidadCompetenciaEntrada,
                    articulacionEntrada,
                    teoricoEntrada,
                    heuristicoEntrada,
                    axiologicosEntrada,
                    estrategiasAprendizajeEntrada,
                    estrategiasEnsenanzaEntrada,
                    materialesDidacticosEntrada,
                    recursosDidacticosEntrada,
                    acreditacionEntrada,
                    bibliografiaBasicaEntrada,
                    bibliografiaComplementariaEntrada);

            ProgramaExperienciaDAO programaExperienciaDAO = new ProgramaExperienciaDAO();
            programaExperienciaDAO.insertar(programaExperiencia);

            Alert alerta = ControladorVentanas.crearAlerta("Operación exitosa",
                    "Se ha agregado una Experiencia Educativa correctamente", Alert.AlertType.INFORMATION);
            alerta.showAndWait();

            cerrar();
        }
        else {
            Alert alerta = ControladorVentanas.crearAlerta("Datos incorrectos",
                    "Los datos ingresados no son del tipo adecuado, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
    }
    
    

    @FXML
    private void agregarEvaluacion(ActionEvent event) {
        
    }
    
    @FXML
    private void cancelar(ActionEvent event){
        Alert alerta = ControladorVentanas.crearAlerta("Confirmación",
                        "¿Está seguro que desea cancelar el registro?", Alert.AlertType.CONFIRMATION);
        Optional<ButtonType> respuesta = alerta.showAndWait();
        
        if(respuesta.get() == ButtonType.OK){
            cerrar();
        }
    }
    
    
    private void cerrar(){
        Stage stageActual = (Stage) cancelar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Coordinador/Programa/ConsultarPrograma.fxml",
                    "Consultar programa", stageActual);
    }
}
