package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class finController extends ButtonController {
	
	@FXML public void initialize() {}
	public finController() {
		
	}
	
	public finController(GestionJeu jeu) {
		super(jeu);
	}
	
}
