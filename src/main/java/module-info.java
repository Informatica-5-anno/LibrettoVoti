module it.edu.falcone_righi.LibrettoVoti {
	 requires transitive javafx.controls;
	 requires javafx.fxml;
	   
	 opens it.edu.falcone_righi.LibrettoVoti to javafx.fxml;
	    opens it.edu.falcone_righi.LibrettoVoti.model to javafx.fxml;
	    exports it.edu.falcone_righi.LibrettoVoti;
	    exports it.edu.falcone_righi.LibrettoVoti.model;
}