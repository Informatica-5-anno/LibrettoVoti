package it.edu.falcone_righi.LibrettoVoti;

import it.edu.falcone_righi.LibrettoVoti.model.Libretto;
import javafx.stage.Stage;

public abstract class BaseController {
	protected Libretto model;
	protected Stage myStage;
	public void setStage(Stage myStage) {
		this.myStage = myStage;
	}

	public void setModel(Libretto model) {
		this.model = model;
		// ListaVoti.setItems(doList);
		// colVoto=new TableColumn<>("Nome Corso");
		// TableColumn<Voto, Integer>col2=new TableColumn<>("Voto");
//		doList = FXCollections.observableArrayList(model.getListaVoti());
//		tblVoti.setItems(FXCollections.observableArrayList(model.getListaVoti()));
	}
}
