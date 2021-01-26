package sgcfei.menus.Coordinador.Programa.ActualizarPrograma;

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
import javafx.stage.Stage;
import pojos.ProgramaExperiencia;
import util.ControladorVentanas;
import util.Validador;

public class ActualizarProgramaController implements Initializable {

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
    private TableColumn<?, ?> porcentaje;
    @FXML
    private Button agregarEvaluacion;
    @FXML
    private Button cancelar;
    @FXML
    private TextArea criterioEntrada;
    @FXML
    private TextArea porcentajeEntrada;
    ProgramaExperiencia programaExperiencia;
    int idProgramaExperiencia;

    public ActualizarProgramaController(ProgramaExperiencia programaExperiencia) {
        this.programaExperiencia = programaExperiencia;
    }

    public ActualizarProgramaController() {
    }
       
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
        dependencias = FXCollections.observableArrayList(dependenciaDAO.obtenerNombres());
        dependencia.setItems(dependencias);
        
        
        
        ExperienciaEducativaDAO experienciaEducativaDAO = new ExperienciaEducativaDAO();
        experienciasEducativas = FXCollections.observableArrayList(experienciaEducativaDAO.obtenerNombres());
        experienciaEducativa.setItems(experienciasEducativas);
        idProgramaExperiencia = programaExperiencia.getIdProgramaEE();
        areaAcademica.getSelectionModel().select(programaExperiencia.getAcademia());
        programaEducativo.getSelectionModel().select(programaExperiencia.getPrograma());
        campus.getSelectionModel().select(programaExperiencia.getCampus());
        dependencia.getSelectionModel().select(programaExperiencia.getDependencia());
        experienciaEducativa.getSelectionModel().select(programaExperiencia.getNombreExperiencia());
        codigo.setText(programaExperiencia.getCodigo());
        principal.setText(programaExperiencia.getAreaFormacionPrincipal());
        secundaria.setText(programaExperiencia.getAreaFormacionSecundaria());
        creditos.setText(String.valueOf(programaExperiencia.getCreditos()));
        teoria.setText(String.valueOf(programaExperiencia.getTeoria()));
        practica.setText(String.valueOf(programaExperiencia.getPractica()));
        totalHoras.setText(String.valueOf(programaExperiencia.getTotalHoras()));
        equivalencias.setText(programaExperiencia.getEquivalencias());
        modalidad.setText(programaExperiencia.getModalidad());
        oportunidadesEvaluacion.setText(programaExperiencia.getOportunidadesEvaluacion());
        prerequisitos.setText(programaExperiencia.getRequisitos());
        corequisitos.setText(programaExperiencia.getCoRequisitos());
        
        individualGrupal.getSelectionModel().select(programaExperiencia.getIndividualGrupal());
        
        maximo.setText(String.valueOf(programaExperiencia.getMaximo()));
        minimo.setText(String.valueOf(programaExperiencia.getMinimo()));
        agrupacion.setText(programaExperiencia.getAgrupacion());
        proyecto.setText(programaExperiencia.getProyecto());
        academicos.setText(programaExperiencia.getAcademicos());
        perfil.setText(programaExperiencia.getPerfil());
        espacio.setText(programaExperiencia.getEspacio());
        relacionDisciplinaria.setText(programaExperiencia.getRelacionDisciplinaria());
        descripcion.setText(programaExperiencia.getDescripcion());
        justificacion.setText(programaExperiencia.getJustificacion());
        unidadCompetencia.setText(programaExperiencia.getUnidadCompetencia());
        articulacion.setText(programaExperiencia.getArticulacion());
        teorico.setText(programaExperiencia.getTeorico());
        heuristico.setText(programaExperiencia.getHeuristico());
        axiologico.setText(programaExperiencia.getAxiologicos());
        estrategiaAprendizaje.setText(programaExperiencia.getEstrategiasAprendizaje());
        estrategiaEnsenanza.setText(programaExperiencia.getEstrategiasEnsenanza());
        materialesDidacticos.setText(programaExperiencia.getMaterialesDidacticos());
        recursosDidacticos.setText(programaExperiencia.getRecursosDidacticos());
        acreditacion.setText(programaExperiencia.getAcreditacion());
        bibliografiaBasica.setText(programaExperiencia.getBibliografiaBasica());
        bibliografiaComplementaria.setText(programaExperiencia.getBibliografiaComplementaria());
        
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
        
        
        
        /*if (!Validador.numero(creditosEntrada) && !Validador.numero(teoriaEntrada) && !Validador.numero(practicaEntrada) && !Validador.numero(totalHorasEntrada) && !Validador.numero(maximoEntrada) && !Validador.numero(minimoEntrada)) {
            datosCorrectos = false;
            
        }
        
        if(espacioEntrada.length() > 30 || relacionEntrada.length() > 30){
            datosCorrectos = false;
        }
        
        if (academiaEntrada.isEmpty() || programaEntrada.isEmpty() || campusEntrada.isEmpty() || dependenciaEntrada.isEmpty()) {
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if (codigoEntrada.isEmpty() || nombreExperienciaEntrada.isEmpty() || areaFormacionPrincipalEntrada.isEmpty() || areaFormacionSecundariaEntrada.isEmpty()) {
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if (creditosEntrada.isEmpty() || teoriaEntrada.isEmpty() || practicaEntrada.isEmpty() || totalHorasEntrada.isEmpty()) {
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if (equivalenciasEntrada.isEmpty() || modalidadEntrada.isEmpty() || oportunidadesEvaluacionEntrada.isEmpty() || requisitosEntrada.isEmpty()) {
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if (coRequisitosEntrada.isEmpty() || individualGrupalEntrada.isEmpty() || maximoEntrada.isEmpty() || minimoEntrada.isEmpty()) {
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if (agrupacionEntrada.isEmpty() || proyectoEntrada.isEmpty() || academicosEntrada.isEmpty() || perfilEntrada.isEmpty()) {
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if ( espacioEntrada.isEmpty() || relacionEntrada.isEmpty() || descripcionEntrada.isEmpty() || justificacionEntrada.isEmpty()) {
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        
        if (unidadCompetenciaEntrada.isEmpty() || articulacionEntrada.isEmpty() || teoricoEntrada.isEmpty() || heuristicoEntrada.isEmpty()) {
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        if (axiologicosEntrada.isEmpty() || estrategiasAprendizajeEntrada.isEmpty() || estrategiasEnsenanzaEntrada.isEmpty() || materialesDidacticosEntrada.isEmpty()) {
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        if (recursosDidacticosEntrada.isEmpty() || acreditacionEntrada.isEmpty() || bibliografiaBasicaEntrada.isEmpty() || bibliografiaComplementariaEntrada.isEmpty()) {
            Alert alerta = ControladorVentanas.crearAlerta("Campos vacios",
                    "No se han llenado todos los campos, por favor verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
        */
        if (datosCorrectos) {
            
            programaExperiencia.setIdProgramaEE(idProgramaExperiencia);
            programaExperiencia.setAcademia(academiaEntrada);
            programaExperiencia.setPrograma(programaEntrada);
            programaExperiencia.setCampus(campusEntrada);
            programaExperiencia.setDependencia(dependenciaEntrada);
            programaExperiencia.setCodigo(codigoEntrada);
            programaExperiencia.setNombreExperiencia(nombreExperienciaEntrada);
            programaExperiencia.setAreaFormacionPrincipal(areaFormacionPrincipalEntrada);
            programaExperiencia.setAreaFormacionSecundaria(areaFormacionSecundariaEntrada);
            
            programaExperiencia.setCreditos(Integer.parseInt(creditosEntrada));
            programaExperiencia.setTeoria(Integer.parseInt(teoriaEntrada));
            programaExperiencia.setPractica(Integer.parseInt(practicaEntrada));
            programaExperiencia.setTotalHoras(Integer.parseInt(totalHorasEntrada));
            
            programaExperiencia.setEquivalencias(equivalenciasEntrada);
            programaExperiencia.setModalidad(modalidadEntrada);
            programaExperiencia.setOportunidadesEvaluacion(oportunidadesEvaluacionEntrada);
            programaExperiencia.setRequisitos(requisitosEntrada);
            programaExperiencia.setCoRequisitos(coRequisitosEntrada);
            programaExperiencia.setIndividualGrupal(individualGrupalEntrada);
            
            programaExperiencia.setMaximo(Integer.parseInt(maximoEntrada));
            programaExperiencia.setMinimo(Integer.parseInt(minimoEntrada));
            
            programaExperiencia.setAgrupacion(agrupacionEntrada);
            programaExperiencia.setProyecto(proyectoEntrada);
            programaExperiencia.setAcademicos(academicosEntrada);
            programaExperiencia.setPerfil(perfilEntrada);
            programaExperiencia.setEspacio(espacioEntrada);
            programaExperiencia.setRelacionDisciplinaria(relacionEntrada);
            programaExperiencia.setDescripcion(descripcionEntrada);
            programaExperiencia.setJustificacion(justificacionEntrada);
            
            programaExperiencia.setUnidadCompetencia(unidadCompetenciaEntrada);
            programaExperiencia.setArticulacion(articulacionEntrada);
            programaExperiencia.setTeorico(teoricoEntrada);
            programaExperiencia.setHeuristico(heuristicoEntrada);
            programaExperiencia.setAxiologicos(axiologicosEntrada);
            programaExperiencia.setEstrategiasAprendizaje(estrategiasAprendizajeEntrada);
            programaExperiencia.setEstrategiasEnsenanza(estrategiasEnsenanzaEntrada);
            programaExperiencia.setMaterialesDidacticos(materialesDidacticosEntrada);
            programaExperiencia.setRecursosDidacticos(recursosDidacticosEntrada);
            programaExperiencia.setAcreditacion(acreditacionEntrada);
            programaExperiencia.setBibliografiaBasica(bibliografiaBasicaEntrada);
            programaExperiencia.setBibliografiaComplementaria(bibliografiaComplementariaEntrada);
    

            ProgramaExperienciaDAO programaExperienciaDAO = new ProgramaExperienciaDAO();
            programaExperienciaDAO.actualizar(programaExperiencia);

            Alert alerta = ControladorVentanas.crearAlerta("Operación exitosa",
                    "Se ha guardado una Experiencia Educativa correctamente", Alert.AlertType.INFORMATION);
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
    private void cancelar(ActionEvent event) {
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
    //
}
