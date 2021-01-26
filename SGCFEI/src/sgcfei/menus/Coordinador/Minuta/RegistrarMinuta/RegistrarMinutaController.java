/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcfei.menus.Coordinador.Minuta.RegistrarMinuta;

import accesodatos.AcademiaDAO;
import accesodatos.AcademicoDAO;
import accesodatos.AspectoMinutaDAO;
import accesodatos.CarreraDAO;
import accesodatos.MinutaDAO;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pojos.Academia;
import pojos.Academico;
import pojos.AspectoMinuta;
import pojos.Carrera;
import pojos.Minuta;
import sgcfei.menus.Coordinador.MenuController;
import util.ControladorVentanas;
import util.Validador;

/**
 * FXML Controller class
 *
 * @author Luis
 */
public class RegistrarMinutaController implements Initializable {
    @FXML
    private TextField tfCoordinador;
    @FXML
    private TextField tfAcademia;
    @FXML
    private TextField tfPeriodo;
    @FXML
    private TextField tfLugar;
    @FXML
    private ComboBox<Carrera> cbCarrera;
    @FXML
    private TextArea taObjetivo;
    @FXML
    private TableView<AspectoMinuta> tbAspectoAdicional;
    @FXML
    private TableColumn<AspectoMinuta, String> cNombreParticipante;
    @FXML
    private TableColumn<AspectoMinuta, String> cAsunto;
    @FXML
    private Button btnAgregarAspecto;
    @FXML
    private ComboBox<Academico> cbAcademicoAspecto;
    @FXML
    private TextField tfAsunto;
    @FXML
    private TextArea taTemas;
    @FXML
    private TextArea taConclusion;
    @FXML
    private TableView<Academico> tbParticipantes;
    @FXML
    private TableColumn<Academico, String> cNombre;
    @FXML
    private ComboBox<Academico> cbAcademicoParticipante;
    @FXML
    private Label lbNombreCoordinador;
    @FXML
    private DatePicker dpFecha;
    private Academico academicoLogeado;
    private ObservableList<Academico> listaParticipantesVaciar;
    private ObservableList<Academico> listaParticipantes;
    private ObservableList<Academico> listaAcademicos;
    private ObservableList<AspectoMinuta> listaAspectos;
    private ObservableList<Carrera> listaCarreras;
    private Carrera carreraSeleccionada;
    private List<AspectoMinuta> aspectos;
    private List<Academico> academiscosParticipantes;
    private List<Academico> academicosVaciar;
    private List<Academico> academicos;
    private List<Carrera> carreras;
    private Academia academia;
    private int idMinuta;
    private boolean esInformacionValida = false;
    private Alert alerta;
   
    

    public RegistrarMinutaController(Academico academicoLogeado) {
        this.academicoLogeado = academicoLogeado;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaParticipantesVaciar = FXCollections.observableArrayList();
        listaParticipantes = FXCollections.observableArrayList();
        listaAcademicos = FXCollections.observableArrayList();
        listaAspectos = FXCollections.observableArrayList();
        listaCarreras = FXCollections.observableArrayList();
        aspectos = new ArrayList<>();
        academiscosParticipantes = new ArrayList<>();
        academicosVaciar = new ArrayList<>();
        academicos = new ArrayList<>();
        carreras = new ArrayList<>();
        asociarComponentes();
        cargarTablas();
        recuperarCarreras();
        agregarListeners();
    }    

    @FXML
    private void clicBotonAgregarAspecto(ActionEvent event) {
        if (cbAcademicoAspecto.getSelectionModel().getSelectedItem() != null && !tfAsunto.getText().isEmpty()) {
            Academico academico = cbAcademicoAspecto.getSelectionModel().getSelectedItem();
            AspectoMinuta aspectoMinuta = new AspectoMinuta(tfAsunto.getText(), academico.getNumeroPersonal(), academico.getNombre());
            aspectos.add(aspectoMinuta);
            cargarAspectos();
            tfAsunto.setText("");
        }else{
            alerta = ControladorVentanas.crearAlerta("Ingrese datos necesarios", "Favor de ingresar/seleccionar los datos necesarios para generar un aspecto adicional", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
    }

    @FXML
    private void clicBotonAgregarParticipante(ActionEvent event) {
        if (cbAcademicoParticipante.getSelectionModel().getSelectedItem() != null) {
            Academico academico = cbAcademicoParticipante.getSelectionModel().getSelectedItem();
            listaParticipantesVaciar.remove(academico);
            academiscosParticipantes.add(academico);
            cargarParticipantes();
        }else{
            alerta = ControladorVentanas.crearAlerta("Participante no seleccionado", "favor de seleccionar un participante", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
    }

    @FXML
    private void clicBotonRegistrar(ActionEvent event) throws ParseException {
        validarListas();
        sonCamposVacios();
        if (esInformacionValida && cbCarrera.getSelectionModel().getSelectedItem() != null) {
            Minuta minuta = new Minuta();
            minuta.setIdAcademia(academia.getIdAcademia());
            minuta.setIdCarrera(cbCarrera.getSelectionModel().getSelectedItem().getIdCarrera());
            Date fecha = null;
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            fecha = formato.parse(dpFecha.getEditor().getText());
            java.sql.Date fechaSql = new java.sql.Date(fecha.getDate());
            minuta.setFecha(fechaSql);
            //Date fecha2 = new Date(fechaSql.getTime());
            minuta.setPeriodo(tfPeriodo.getText());
            minuta.setLugar(tfLugar.getText());
            minuta.setObjetivo(taObjetivo.getText());
            minuta.setTemas(taTemas.getText());
            minuta.setConclusiones(taConclusion.getText());
            idMinuta = new MinutaDAO().insertar(minuta);
            for(AspectoMinuta aspectoMinuta: aspectos){
                aspectoMinuta.setIdMinuta(idMinuta);
                new AspectoMinutaDAO().insertar(aspectoMinuta);
            }
            for(Academico academico: academiscosParticipantes){
                new AcademicoDAO().insertarParticipacion(academico.getNumeroPersonal(), idMinuta);
            }
            Stage stageActual = (Stage) btnAgregarAspecto.getScene().getWindow();
            MenuController menuController = new MenuController(academicoLogeado);
                        ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/" + academicoLogeado.getRol()
                            +"/Menu.fxml", "Menu principal",menuController, stageActual);
            alerta = ControladorVentanas.crearAlerta("Registro exitoso", "La minuta se ha guardado en el sistema", Alert.AlertType.INFORMATION);
            alerta.showAndWait();
        }else{
            alerta = ControladorVentanas.crearAlerta("Verificar informacion", "Existe un conflicto con la informacion, favor de verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
    }

    private void asociarComponentes() {
        cNombreParticipante.setCellValueFactory( new PropertyValueFactory<>("nombreParticipante") );
        cAsunto.setCellValueFactory( new PropertyValueFactory<>("asunto") );
        
        cNombre.setCellValueFactory( new PropertyValueFactory<>("nombre") );
    }

    private void recuperarCarreras() {
        carreras = new CarreraDAO().obtenerTodasCarreras();
        cargarCarreras();
    }

    private void cargarCarreras() {
        listaCarreras.addAll(carreras);
        cbCarrera.setItems(listaCarreras);
        recuperarAcademia();
    }

    private void recuperarAcademia() {
        academia = new AcademiaDAO().obtenerAcademiaPorCoordinador(academicoLogeado.getNumeroPersonal());
        cargarInformacionAcademia();
    }

    private void cargarInformacionAcademia() {
        tfAcademia.setText(academia.getNombre());
        cargarInformacionCoordinador();
    }

    private void cargarInformacionCoordinador() {
        tfCoordinador.setText(academicoLogeado.getNombre());
        sgregarElementosComboBox();
    }

    private void sgregarElementosComboBox() {
        academicos = new AcademicoDAO().obtenerAcademicosPorRol("Docente");
        academicosVaciar = academicos;
        listaAcademicos.addAll(academicos);
        listaParticipantesVaciar.addAll(academicosVaciar);
        cbAcademicoAspecto.setItems(listaAcademicos);
        cbAcademicoParticipante.setItems(listaParticipantesVaciar);
    }

    private void agregarListeners() {
        tfPeriodo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.isEmpty() && Validador.validarPeriodo(newValue)){
                    tfPeriodo.setStyle("-fx-background-color: red;");
                    esInformacionValida = false;
                }else{
                    tfPeriodo.setStyle("-fx-background-color: white;");
                    esInformacionValida = true;
                }
            }
        });
        
        tfLugar.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.isEmpty()){
                    tfLugar.setStyle("-fx-background-color: red;");
                    esInformacionValida = false;
                }else{
                    tfLugar.setStyle("-fx-background-color: white;");
                    esInformacionValida = true;
                }
            }
        });
        
        taObjetivo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.isEmpty()){
                    taObjetivo.setStyle("-fx-background-color: red;");
                    esInformacionValida = false;
                }else{
                    taObjetivo.setStyle("-fx-background-color: white;");
                    esInformacionValida = true;
                }
            }
        });
        
        taTemas.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.isEmpty()){
                    taTemas.setStyle("-fx-background-color: red;");
                    esInformacionValida = false;
                }else{
                    taTemas.setStyle("-fx-background-color: white;");
                    esInformacionValida = true;
                }
            }
        });
        
        taConclusion.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.isEmpty()){
                    taConclusion.setStyle("-fx-background-color: red;");
                    esInformacionValida = false;
                }else{
                    taConclusion.setStyle("-fx-background-color: white;");
                    esInformacionValida = true;
                }
            }
        });
    }

    private void validarListas() {
        if (academiscosParticipantes.size() > 0) {
            esInformacionValida = true;
        }
    }
    
    private void sonCamposVacios(){
        if (tfPeriodo.getText().isEmpty()) {
            esInformacionValida = false;
        }
        
        if (tfLugar.getText().isEmpty()) {
            esInformacionValida = false;
        }
        
        if (taObjetivo.getText().isEmpty()) {
            esInformacionValida = false;
        }
        
        if (taTemas.getText().isEmpty()) {
            esInformacionValida = false;
        }
        
        if (taConclusion.getText().isEmpty()) {
            esInformacionValida = false;
        }
    }

    private void cargarTablas() {
        listaAspectos.addAll(aspectos);
        tbAspectoAdicional.setItems(listaAspectos);
        
        listaParticipantes.addAll(academiscosParticipantes);
        tbParticipantes.setItems(listaParticipantes);
    }

    private void cargarAspectos() {
        listaAspectos.removeAll(aspectos);
        listaAspectos.addAll(aspectos);
    }
    
    private void cargarParticipantes(){
        listaParticipantes.removeAll(academiscosParticipantes);
        listaParticipantes.addAll(academiscosParticipantes);
    }

    @FXML
    private void clicBotonCerrar(ActionEvent event) {
        Stage stageActual = (Stage) btnAgregarAspecto.getScene().getWindow();
        MenuController menuController = new MenuController(academicoLogeado);
        ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Coordinador/Menu.fxml", "Menu principal",menuController, stageActual);
    }
}
