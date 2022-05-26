package application;

import application.Main.Theme;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class finController extends ButtonController{
	
	GestionJeu jeu = getGestionJeu();
	private String motMystere = jeu.getMotMystere();
	@FXML Label labelMotMystere;
	@FXML Label labelMessageFin;
	
	
	@FXML public void initialize() {
	
		labelMotMystere.setText(motMystere);
		if(jeu.MaxErreursDepasse())
			if( getGestionOption().getTheme() == Theme.FUTURISTE)
     			labelMessageFin.setText("Amiral vous avez perdu les aliens nous ont attrapés...");
     		else
			labelMessageFin.setText("Aie aie cowboy tu as perdu.."); 
		else
			if( getGestionOption().getTheme() == Theme.FUTURISTE)
     			labelMessageFin.setText("Blip Bloup Amiral vous avez gagné et conquis l'univers");
     		else
			labelMessageFin.setText("Bravo cowboy tu as gagné YIHAAAA");

	}
	public finController() {
		
	}
	
	public finController(GestionJeu jeu, GestionOption option) {
		super(jeu,option);
	}
	
}
