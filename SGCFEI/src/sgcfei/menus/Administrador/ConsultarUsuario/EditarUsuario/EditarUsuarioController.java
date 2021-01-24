/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgcfei.menus.Administrador.ConsultarUsuario.EditarUsuario;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import pojos.Academico;

/**
 * FXML Controller class
 *
 * @author Luis
 */

public class EditarUsuarioController implements Initializable {

    @FXML
    private TextField tfNumeroPersonal;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfCorreo;
    @FXML
    private ComboBox<Academico> cbTipoUsuario;
    @FXML
    private Button btnRegistrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicModificar(ActionEvent event) {
    }
    
}
