/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcfei.menus.Administrador.ConsultarUsuario;

import accesodatos.AcademicoDAO;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import pojos.Academico;
import util.ControladorVentanas;

/**
 * FXML Controller class
 *
 * @author Luis
 */
public class ConsultarUsuarioController implements Initializable {

    @FXML
    private TableView<Academico> tbAcademico;
    @FXML
    private TableColumn<Academico, String> cNumeroPersonal;
    @FXML
    private TableColumn<Academico, String> cNombre;
    @FXML
    private TableColumn<Academico, String> cCorreo;
    @FXML
    private TableColumn<Academico, String> cRol;
    @FXML
    private TextField tfBuscar;
    
    private ObservableList<Academico> listaAcademicos;
    
    private Alert alerta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        asosiarComponentes();
    }    

    @FXML
    private void clicBotonModificar(ActionEvent event) {
    }

    @FXML
    private void clicBotonRegistrar(ActionEvent event) {
    }

    @FXML
    private void clicBotonEliminar(ActionEvent event) {
    }

    private void cargarAcademicos(List academicos) {
        listaAcademicos = FXCollections.observableArrayList();
        listaAcademicos.addAll(academicos);
        tbAcademico.setItems(listaAcademicos);
    }

    private void recuperarAcademicos() {
        List<Academico> academicos = new AcademicoDAO().obtenerTodosAcademicos();
        if (academicos.size() > 0) {
            cargarAcademicos(academicos);
        }else{
            alerta = ControladorVentanas.crearAlerta("Sin usuario registrador", "No hay usuarios guardados en el sistema", Alert.AlertType.INFORMATION);
            alerta.showAndWait();
        }
    }

    private void asosiarComponentes() {
        cNumeroPersonal.setCellValueFactory( new PropertyValueFactory<>("numeroPersonal") );
        cNombre.setCellValueFactory( new PropertyValueFactory<>("nombre") );
        cCorreo.setCellValueFactory( new PropertyValueFactory<>("correo") );
        cRol.setCellValueFactory( new PropertyValueFactory<>("rol") );
        recuperarAcademicos();
    }
    
}
