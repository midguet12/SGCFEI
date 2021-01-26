/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcfei.menus.Coordinador.Minuta.ConsultarMinuta.EditarMinuta;

import accesodatos.AcademiaDAO;
import accesodatos.AcademicoDAO;
import accesodatos.AspectoMinutaDAO;
import accesodatos.CarreraDAO;
import java.net.URL;
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
import sgcfei.menus.Coordinador.Minuta.ConsultarMinuta.ConsultarMinutaController;
import util.ControladorVentanas;

/**
 * FXML Controller class
 *
 * @author Luis
 */
public class EditarMinutaController implements Initializable {

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
    private ComboBox<AspectoMinuta> cbAcademicoAspecto;
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
    private ObservableList<Academico> academicosParticipantes;
    private ObservableList<AspectoMinuta> aspectosMinuta;
    private ObservableList<Carrera> listaCarreras;
    private Academico academicoLogeado;
    private Minuta minutaEdicion;
    private boolean esInformacionValida = true;
    private Alert alerta;

    public EditarMinutaController(Academico academicoLogeado, Minuta minutaEdicion) {
        this.academicoLogeado = academicoLogeado;
        this.minutaEdicion = minutaEdicion;
    }

    /**
     * Initializes the controller class.
     */
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        academicosParticipantes = FXCollections.observableArrayList();
        aspectosMinuta = FXCollections.observableArrayList();
        listaCarreras = FXCollections.observableArrayList();
        cargarInformacion();
        agregarListeners();
        asociarTablas();
        recuperarCarreras();
    }

    private void agregarListeners() {
        tfPeriodo.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue.isEmpty()){
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

    private void asociarComponentes() {
        cNombreParticipante.setCellValueFactory( new PropertyValueFactory<>("nombreParticipante") );
        cAsunto.setCellValueFactory( new PropertyValueFactory<>("asunto") );
        
        cNombre.setCellValueFactory( new PropertyValueFactory<>("nombre") );
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

    @FXML
    private void clicBotonModificar(ActionEvent event) {
        sonCamposVacios();
        if (esInformacionValida) {
            Stage stageActual = (Stage) btnAgregarAspecto.getScene().getWindow();
            MenuController menuController = new MenuController(academicoLogeado);
                        ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/" + academicoLogeado.getRol()
                            +"/Menu.fxml", "Menu principal",menuController, stageActual);
            alerta = ControladorVentanas.crearAlerta("Registro exitoso", "Los cambios se han guardado", Alert.AlertType.INFORMATION);
            alerta.showAndWait();
        }else{
            alerta = ControladorVentanas.crearAlerta("Verificar informacion", "Existe un conflicto con la informacion, favor de verificar", Alert.AlertType.ERROR);
            alerta.showAndWait();
        }
    }

    private void cargarInformacion() {
        tfCoordinador.setText(academicoLogeado.getNombre());
        Academia academia = new AcademiaDAO().obtenerAcademiaPorCoordinador(academicoLogeado.getNumeroPersonal());
        tfAcademia.setText(academia.getNombre());
        tfPeriodo.setText(minutaEdicion.getPeriodo());
        tfLugar.setText(minutaEdicion.getLugar());
        taObjetivo.setText(minutaEdicion.getObjetivo());
        taTemas.setText(minutaEdicion.getTemas());
        taConclusion.setText(minutaEdicion.getConclusiones());
    }

    private void asociarTablas() {
        cNombreParticipante.setCellValueFactory( new PropertyValueFactory<>("nombreParticipante") );
        cAsunto.setCellValueFactory( new PropertyValueFactory<>("asunto") );
        
        cNombre.setCellValueFactory( new PropertyValueFactory<>("nombre") );
        
        List<AspectoMinuta> aaspectosMinuta = new AspectoMinutaDAO().obtenerAspectosPorMinuta(minutaEdicion.getIdMinuta());
        List<Academico> academicos = new AcademicoDAO().obtenerAcademicosParticipantes(minutaEdicion.getIdMinuta());
        academicosParticipantes.setAll(academicos);
        aspectosMinuta.setAll(aaspectosMinuta);
        tbAspectoAdicional.setItems(aspectosMinuta);
        tbParticipantes.setItems(academicosParticipantes);
    }
    
    private void recuperarCarreras() {
        List<Carrera> carreras = new CarreraDAO().obtenerTodasCarreras();
        cargarCarreras(carreras);
    }

    private void cargarCarreras(List<Carrera> carreras) {
        listaCarreras.addAll(carreras);
        cbCarrera.setItems(listaCarreras);
    }

    @FXML
    private void clicBotonCerrar(ActionEvent event) {
        Stage stageActual = (Stage) btnAgregarAspecto.getScene().getWindow();
        ConsultarMinutaController consultarMinutaController = new ConsultarMinutaController(academicoLogeado);
        ControladorVentanas.abrirYCerrarConControlador("/sgcfei/menus/Coordinador/Minuta/ConsultarMinuta/ConsultarMinuta.fxml", "Consultar minuta",consultarMinutaController, stageActual);
    }

    
    
}
