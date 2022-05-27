package application;

import application.Main.Theme;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class finController extends ButtonController{
	
	GestionJeu jeu = getGestionJeu();
	private String motMystere = jeu.getMotMystere();
	@FXML Label labelMotMystere;
	@FXML Label labelMessageFin;
	@FXML Label labelFin1;
	@FXML Label labelFin2;


	
	
	@FXML public void initialize() {
		labelMessageFin.setStyle("-fx-font-size :"+Integer.toString(34+super.getGestionOption().getMultPolice()) + " Arial;");
		labelFin1.setStyle("-fx-font-size :"+Integer.toString(37+super.getGestionOption().getMultPolice()) + " Arial;");
		labelFin2.setStyle("-fx-font-size :"+Integer.toString(23+super.getGestionOption().getMultPolice()) + " Arial;");
		labelMotMystere.setStyle("-fx-font-size :"+Integer.toString(36+super.getGestionOption().getMultPolice()) + " Arial;");
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
