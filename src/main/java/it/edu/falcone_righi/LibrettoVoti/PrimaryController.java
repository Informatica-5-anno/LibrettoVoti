package it.edu.falcone_righi.LibrettoVoti;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;

import it.edu.falcone_righi.LibrettoVoti.model.Libretto;
import it.edu.falcone_righi.LibrettoVoti.model.Voto;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PrimaryController extends BaseController {
	private String id="rbVotiAll"; 

	@FXML
	private TableColumn<Voto, String> colMateria;

	@FXML
	private TableColumn<Voto, Integer> colVoto;

	@FXML
	private TableColumn<Voto, LocalDate> colDataEsame;

	@FXML
	private TableView<Voto> tblVoti;

	@FXML
	private RadioButton rbVotiAll;

	@FXML
	private RadioButton rbVotiLess;

	@FXML
	private RadioButton rbVotiMore;

	@FXML
	private Button btAdd;

	ToggleGroup rbVotiGroup = new ToggleGroup();

	
	@FXML
	void rbAllSelected(ActionEvent event) {
		id =((RadioButton) event.getSource()).getId();
        setFiltering();
	}
		
	public void setFiltering() {	
		if (id.equalsIgnoreCase("rbVotiMore")) {
			tblVoti.setItems(FXCollections.observableArrayList(
					model.getListaVoti().stream().filter(voto -> voto.getVotoOttenuto() >= 24).collect(Collectors.toList())));
		} else if (id.equalsIgnoreCase("rbVotiLess")) {
			tblVoti.setItems(FXCollections.observableArrayList(
					model.getListaVoti().stream().filter(voto -> voto.getVotoOttenuto() <= 24).collect(Collectors.toList())));
		} else
			tblVoti.setItems(FXCollections.observableArrayList(model.getListaVoti()));
	}

	@FXML
	void onbtAdd(ActionEvent event) {
//		System.out.println("add vote");
//		try {
//			App.setRoot(2);
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		App.showSecondary();
		 try {
		        // Load the fxml file and create a new stage for the popup dialog.
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(App.class.getResource("/fxml/NewVote.fxml"));
		        Parent page = loader.load();

		        // Create the dialog Stage.
		        Stage dialogStage = new Stage();
		        dialogStage.setTitle("Edit Person");
		        dialogStage.initModality(Modality.WINDOW_MODAL);
		        dialogStage.initOwner(this.myStage);
		        Scene scene = new Scene(page);
		        dialogStage.setScene(scene);
		        NewVoteController controller = loader.getController();
		        controller.setModel(model);
                controller.setStage(dialogStage);
		        // Show the dialog and wait until the user closes it
		        btAdd.setDisable(true);
		        dialogStage.showAndWait();
		        btAdd.setDisable(false);
		        setFiltering(); 
		    } catch (IOException e) {
		        e.printStackTrace();

		    }
		}
	


	@Override
	public void setModel(Libretto model) {
		super.setModel(model);
		tblVoti.setItems(FXCollections.observableArrayList(model.getListaVoti()));
	}
	
	@FXML
	void initialize() {
		assert colMateria != null : "fx:id=\"colMateria\" was not injected: check your FXML file 'primary.fxml'.";
		assert colVoto != null : "fx:id=\"colVoto\" was not injected: check your FXML file 'primary.fxml'.";
		assert rbVotiAll != null : "fx:id=\"rbVotiAll\" was not injected: check your FXML file 'primary.fxml'.";
		assert rbVotiLess != null : "fx:id=\"rbVotiLess\" was not injected: check your FXML file 'primary.fxml'.";
		assert rbVotiMore != null : "fx:id=\"rbVotiMore\" was not injected: check your FXML file 'primary.fxml'.";
		assert tblVoti != null : "fx:id=\"tblVoti\" was not injected: check your FXML file 'primary.fxml'.";
		
		rbVotiAll.setToggleGroup(rbVotiGroup);
		rbVotiLess.setToggleGroup(rbVotiGroup);
		rbVotiMore.setToggleGroup(rbVotiGroup);
		rbVotiAll.setSelected(true);
		rbVotiAll.requestFocus();
		this.colMateria.setCellValueFactory(new PropertyValueFactory<Voto, String>("nomeCorso"));
		this.colVoto.setCellValueFactory(new PropertyValueFactory<Voto, Integer>("votoOttenuto"));
		this.colDataEsame.setCellValueFactory(new PropertyValueFactory<Voto, LocalDate>("dataEsame"));
	}

}

//
//public class PrimaryController {
//
//    @FXML
//    private void switchToSecondary() throws IOException {
//        App.setRoot("secondary");
//    }
//}
