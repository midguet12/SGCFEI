package sgcfei.menus.Administrador.Catalogos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.ControladorVentanas;

public class SeleccionarCatalogoController implements Initializable {
    @FXML
    private ComboBox<String> cbox;
    @FXML
    private Button btnAceptar = new Button ();
    @FXML
    private Button btnCancelar = new Button ();
    private ObservableList<String> elementos = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        elementos.addAll("Academia", "Academico", "Carrera", "Experiencia Educativa", "LGCA");
        cbox.setItems(elementos);
        cbox.getSelectionModel().select(0);
    }    

    @FXML
    private void consultar(MouseEvent event) {
        String seleccion = (String) cbox.getValue();
        Stage stageActual = (Stage) btnAceptar.getScene().getWindow();

        if(seleccion.equals("Academia")){
            ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/Academia/Registros.fxml",
                    "Catálogo de Academia", stageActual);
        }
        if(seleccion.equals("Academico")){
            ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/Academico/Registros.fxml",
                    "Consultar Academico", stageActual);
        }
        if(seleccion.equals("Carrera")){
            ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/Carrera/Registros.fxml",
                    "Consultar Carrera", stageActual);
        }
        if(seleccion.equals("Experiencia Educativa")){
            ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/ExperienciaEducativa/Registros.fxml",
                    "Consultar Experiencia Educativa", stageActual);
        }
        if(seleccion.equals("LGCA")){
            ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Catalogos/LGCA/Registros.fxml",
                    "Consultar LGCA", stageActual);
        }
    }

    @FXML
    private void cancelar(MouseEvent event) {
        Stage stageActual = (Stage) btnCancelar.getScene().getWindow();
        //Regresar a la ventana anterior
        ControladorVentanas.abrirYCerrar("/sgcfei/menus/Administrador/Menu.fxml",
                    "Consultar registro", stageActual);
    }
    
}
