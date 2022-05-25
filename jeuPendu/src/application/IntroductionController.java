package application;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;

public class IntroductionController extends ButtonController {
private int police ;
	
	public int getPolice() {
		return police;
	}
	@FXML Label LABELTEST;
	@FXML Slider slider;
	@FXML Button applyButton;
	 
	@FXML public void initialize() {}
	 
	public IntroductionController() {
		
	}
	 
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
	
	/*public void applyChanges(ActionEvent event) {
		//System.out.println("applyyyyyy");
	}*/
	@FXML
	public void ouvrirOption(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("option.fxml"));
        optionController optionController = new optionController();
        loader.setController(optionController);
        AnchorPane support = loader.load();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Support");
        dialog.getDialogPane().setContent(support);
        
        dialog.show();
		
		
	}
		

}