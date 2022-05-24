package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;

public class IntroductionController extends ButtonController {
	
	 
	@FXML public void initialize() {}
	 
	public IntroductionController() {
		
	}
	 
	public IntroductionController(GestionJeu jeu, GestionOption option) {
		super(jeu, option);
	}
	
	@FXML
	public void ouvrirSupport(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("support.fxml"));
        optionController optionController = new optionController();
        loader.setController(optionController);
        AnchorPane support = loader.load();
	
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Support");
        dialog.getDialogPane().setContent(support);
        
        ButtonType buttonFermer = new ButtonType("Fermer", ButtonData.FINISH);
		dialog.getDialogPane().getButtonTypes().addAll(buttonFermer);
		
		dialog.show();
		
	}
	
	@FXML
	public void ouvrirOption(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("support.fxml"));
        optionController optionController = new optionController();
        loader.setController(optionController);
        AnchorPane support = loader.load();
	
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Support");
        dialog.getDialogPane().setContent(support);
        
        ButtonType buttonFermer = new ButtonType("Fermer", ButtonData.FINISH);
		dialog.getDialogPane().getButtonTypes().addAll(buttonFermer);
		
		dialog.show();
		
	}
		

}