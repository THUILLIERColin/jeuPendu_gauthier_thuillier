package application;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;

public class IntroductionController extends ButtonController {
	
	@FXML public void initialize() {}
	 
	public IntroductionController() {}
	 
	public IntroductionController(GestionJeu jeu, GestionOption option) {
		super(jeu, option);
	}
	
	@FXML
	public void ouvrirSupport(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("support.fxml"));
        supportController supportController = new supportController();
        loader.setController(supportController);
        AnchorPane support = loader.load(); 
        
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Support");
        dialog.getDialogPane().setContent(support);
        
        ButtonType buttonFermer = new ButtonType("Fermer", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().addAll(buttonFermer);
		
		dialog.show();
		
	}
	
	
	@FXML
	public void ouvrirOption(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("option.fxml"));
        optionController optionController = new optionController(super.getGestionJeu(), super.getGestionOption());
        loader.setController(optionController);
        AnchorPane support = loader.load(); 
        Dialog<ButtonType> dialog = new Dialog<ButtonType>();
        dialog.setTitle("Support");
        dialog.getDialogPane().setContent(support);
        
        ButtonType buttonApply = new ButtonType("Appliquer", ButtonData.APPLY);
        ButtonType buttonCancel = new ButtonType("Retour", ButtonData.CANCEL_CLOSE);
		dialog.getDialogPane().getButtonTypes().addAll(buttonApply, buttonCancel);
		
		Optional<ButtonType> choice = dialog.showAndWait();
				
		if(choice.get() == buttonApply){
			GestionOption option =super.getGestionOption();
						
			//Choix du theme 
			if(!(optionController.getThemeChoisi()==option.getTheme())){
				option.setTheme(optionController.getThemeChoisi());
				option.MAJIntro(optionController.getThemeChoisi());
			}			
			
			// Choix du dico
			option.setDifficulty((optionController.getDifficulty()));
			option.changeDifficulty();
		}
		else{
			dialog.close();
		}
	}
}