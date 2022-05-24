package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class optionController {
	
	@FXML private CheckBox westernTheme = new CheckBox("western");
	@FXML private CheckBox futuristeTheme = new CheckBox("futur");
	
	@FXML public void initialize() {}
	
	public optionController() {	
		westernTheme.setSelected(true);
		futuristeTheme.setSelected(false);
	}
	
	public void setWesternTheme(ActionEvent event) throws IOException {
		westernTheme.setSelected(true);
		futuristeTheme.setSelected(false);
	}
	
	public void setFuturisteTheme(ActionEvent event) throws IOException {
		westernTheme.setSelected(false);
		futuristeTheme.setSelected(true);
	}

	
	
	
}
