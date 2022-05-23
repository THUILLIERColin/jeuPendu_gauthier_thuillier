package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class IntroductionController extends ButtonController {
	
	 
	 @FXML public void initialize() {}
	 
	public IntroductionController() {
		
	}
	 
	public IntroductionController(GestionJeu jeu, GestionOption option) {
		super(jeu, option);
	}
	
	public void ouvrirSupport(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("support.fxml"));
        Parent parent = loader.load();
        optionController optionController = new optionController();
        loader.setController(optionController);
	
        Scene scene = new Scene(parent, 300, 200);
        Stage stage = new Stage();
        stage.setTitle("Support");
        
        stage.setScene(scene);
        stage.showAndWait();
		
	}
		

}