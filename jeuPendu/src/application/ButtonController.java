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
	private GestionOption option;
	
	@FXML Button lancer;
	@FXML Button quitter;
	@FXML Button acceuille;
	
 @FXML public void initialize() {}
	 
	 public ButtonController() {}
	 
	public ButtonController(GestionJeu jeu, GestionOption option) {
		this.jeu=jeu;
		this.option= option;
	}
	
	public GestionJeu getGestionJeu() { return jeu;}
	

	public void lancerPartie(ActionEvent event) throws IOException {
		jeu.InitialiserPartie();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("enJeu.fxml"));
		enJeuController enJeu = new enJeuController(jeu,option);
		loader.setController(enJeu);
		
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
	}
	
	public void quitterPartie(ActionEvent event) throws IOException {
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
		System.exit(0);
	}
	
	public void acceuil(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("introduction.fxml"));
		IntroductionController intro = new IntroductionController(jeu,option);
		loader.setController(intro);
		
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
	}

}
