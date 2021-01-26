/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcfei.menus.Coordinador.Programa;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sgcfei.menus.Coordinador.Programa.RegistrarPrograma.RegistrarProgramaController;
import util.ControladorVentanas;

/**
 * FXML Controller class
 *
 * @author midgu
 */
public class ConsultarProgramaController implements Initializable {
    
    public ConsultarProgramaController(){
        
    }
    
    @FXML
    private Button agregar;
    @FXML
    private Button consultar;
    @FXML
    private Button actualizar;
    @FXML
    private Button eliminar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void agregar(ActionEvent event) {
        RegistrarProgramaController registrarProgramaController = new RegistrarProgramaController();
        Stage stageActual = (Stage) agregar.getScene().getWindow();
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Coordinador/Programa/RegistrarPrograma/RegistrarPrograma.fxml", "Registrar Programa", stageActual);
        
        
    }

    

    @FXML
    private void consultar(ActionEvent event) {
    }

    @FXML
    private void actualizar(ActionEvent event) {
    }

    @FXML
    private void eliminar(ActionEvent event) {
    }
    
}
