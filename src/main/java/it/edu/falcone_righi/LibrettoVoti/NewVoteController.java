/**
 * Sample Skeleton for 'NewVote.fxml' Controller Class
 */

package it.edu.falcone_righi.LibrettoVoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.edu.falcone_righi.LibrettoVoti.model.Voto;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class NewVoteController extends BaseController {

	private static final String REGEX_VALID_INTEGER = "([1-9]|[1-2][0-9]|3[0])";
	
	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="btnCancel"
    private Button btnCancel; // Value injected by FXMLLoader

    @FXML // fx:id="btnOK"
    private Button btnOK; // Value injected by FXMLLoader

    @FXML // fx:id="dtpData"
    private DatePicker dtpData; // Value injected by FXMLLoader

    @FXML // fx:id="txtEsame"
    private TextField txtEsame; // Value injected by FXMLLoader

    @FXML // fx:id="txtVoto"
    private TextField txtVoto; // Value injected by FXMLLoader

    @FXML
    void onbtnCancel(ActionEvent event) {
    	this.myStage.close();
    }

    @FXML
    void onbtnOK(ActionEvent event) {
    	int voto=Integer.parseInt(txtVoto.getText());
    	String materia=txtEsame.getText();
    	LocalDate mydate=dtpData.getValue();
    	model.add(new Voto(materia,voto,mydate));
    	this.myStage.close();
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'NewVote.fxml'.";
        assert btnOK != null : "fx:id=\"btnOK\" was not injected: check your FXML file 'NewVote.fxml'.";
        assert dtpData != null : "fx:id=\"dtpData\" was not injected: check your FXML file 'NewVote.fxml'.";
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'NewVote.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'NewVote.fxml'.";
        //btnOK.setDisable(true);
        dtpData.setValue(LocalDate.now());
        btnOK.disableProperty().bind(Bindings.or(txtEsame.textProperty().isEmpty(),txtVoto.textProperty().isEmpty()));
        txtVoto.setTextFormatter(new TextFormatter<>(this::filter));
    }

    private TextFormatter.Change filter(TextFormatter.Change change) {
        if (!change.getControlNewText().matches(REGEX_VALID_INTEGER)) {
            change.setText("");
        }
        return change;
    }
}
