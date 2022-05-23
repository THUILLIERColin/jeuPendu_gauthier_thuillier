package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class IntroductionController extends ButtonController {
	
	 
	 @FXML public void initialize() {}
	 
	public IntroductionController() {
		
	}
	 
	public IntroductionController(GestionJeu jeu, GestionOption option) {
		super(jeu, option);
	}
	
	public void ouvrirSupport(ActionEvent event) throws IOException {
		Alert dialogueSupport = new Alert(Alert.AlertType.INFORMATION);
		dialogueSupport.show();
	}
		

}