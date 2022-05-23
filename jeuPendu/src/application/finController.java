package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class finController extends ButtonController{
	GestionJeu jeu = getJeu();
	private String MM = jeu.getMotMystere();
	@FXML Label L1;
	@FXML Label L2;
	@FXML public void initialize() {
	
		L1.setText(MM);
		if(jeu.MaxErreursDepasse())
			L2.setText("Aie aie cowboy tu as perdu..");
		else
			L2.setText("Bravo cowboy tu as gagné");

	}
	public finController() {
		
	}
	
	public finController(GestionJeu jeu) {
		super(jeu);
	}
	
}
