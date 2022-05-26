package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class finController extends ButtonController{
	
	GestionJeu jeu = getGestionJeu();
	private String motMystere = jeu.getMotMystere();
	@FXML Label labelMotMystere;
	@FXML Label labelMessageFin;
	
	
	@FXML public void initialize() {
	
		labelMotMystere.setText(motMystere);
		if(jeu.MaxErreursDepasse())
			labelMessageFin.setText("Aie aie cowboy tu as perdu..");
		else
			labelMessageFin.setText("Bravo cowboy tu as gagné");

	}
	public finController() {
		
	}
	
	public finController(GestionJeu jeu, GestionOption option) {
		super(jeu,option);
	}
	
}
