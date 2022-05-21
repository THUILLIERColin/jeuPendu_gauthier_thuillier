package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ButtonController {
	
	
	private Stage stage;
	private Scene scene;
	private Pane root;
	
	private GestionJeu jeu;
	
	@FXML Button lancer;
	@FXML Button quitter;
	
 @FXML public void initialize() {}
	 
	 public ButtonController() {
		 
	 }
	 
	public ButtonController(GestionJeu jeu) {
		this.jeu=jeu;
	}
	
	public GestionJeu getGestionJeu() { return jeu;}
	

	public void lancerPartie(ActionEvent event) throws IOException {
		System.out.println(""+getGestionJeu());
		jeu.InitialiserPartie();
		
		root = FXMLLoader.load(getClass().getResource("enJeu.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void quitterPartie(ActionEvent event) throws IOException {
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}

}
