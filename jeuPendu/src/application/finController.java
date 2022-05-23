package application;

import javafx.fxml.FXML;

public class finController extends ButtonController {
	
	@FXML public void initialize() {}
	public finController() {
		
	}
	
	public finController(GestionJeu jeu, GestionOption option) {
		super(jeu,option);
	}
	
}
