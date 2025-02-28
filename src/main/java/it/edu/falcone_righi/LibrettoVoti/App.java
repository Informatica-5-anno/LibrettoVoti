package it.edu.falcone_righi.LibrettoVoti;

import java.io.IOException;
import java.time.LocalDate;

import it.edu.falcone_righi.LibrettoVoti.model.Libretto;
import it.edu.falcone_righi.LibrettoVoti.model.Voto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	private static BaseController controller;
	private static Scene scenePrimary;
//	private static Scene sceneSecondary;
    private static Stage stage;
    private static Libretto model;

    public void start(Stage stage) throws Exception {
    	
        // Build Model
    	model=new Libretto();   
    	model.add(new Voto("informatica", 28, LocalDate.of(2024, 1, 22)));
    	model.add(new Voto("statistica", 22, LocalDate.of(2024, 3, 17)));
    	model.add(new Voto("calcolo", 20, LocalDate.of(2024, 5, 30)));
    	model.add(new Voto("linguaggi", 27, LocalDate.of(2024, 7, 25)));
    	model.add(new Voto("fisica 1", 18, LocalDate.of(2024, 1, 22)));
    	model.add(new Voto("analisi 1", 25, LocalDate.of(2024, 1, 21)));
    	model.add(new Voto("fisica 2", 20, LocalDate.of(2024, 2, 12)));
    	model.add(new Voto("analisi 2", 21, LocalDate.of(2025, 1, 12)));
    	model.add(new Voto("inglese", 28, LocalDate.of(2024, 11, 14)));

        scenePrimary = new Scene(loadFXML(1));
//        sceneSecondary = new Scene(loadFXML(2));
        App.stage=stage;    
        showPrimary();
        stage.setTitle("Libretto voti");
        stage.setScene(scenePrimary);
        stage.show();
    }

	public static void showPrimary() {
		stage.setTitle("Libretto voti");
        stage.setScene(scenePrimary);
        stage.show();
    }
	
//	public static void showSecondary() {
//		//stage.setTitle("Libretto voti");
//        stage.setScene(sceneSecondary);
//        stage.show();
//    }
//    
    

    private static Parent loadFXML(int form) throws IOException {
    	String fxml;
    	switch(form) {
    	case 1:
    		fxml="/fxml/Scene.fxml";
    	    break;
    	case 2:
    		fxml="/fxml/NewVote.fxml";
    		break;
    	default: fxml=null;
    	}
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        Parent root= fxmlLoader.load();
        controller=fxmlLoader.getController();
        controller.setModel(model); 
        root.getStylesheets().add(App.class.getResource("/styles/Styles.css").toString());
        return root;
    }

    public static void main(String[] args) {
        launch();
    }

}

