package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ButtonController {
	
	
	private Stage stage;
	private Scene scene;
	private Pane root;
	private GestionOption option;
	private GestionJeu jeu;
	
	@FXML Label rep;
	@FXML Button fin;
	@FXML Button reco;
	@FXML Button lancer;
	@FXML Button quitter;
	@FXML Button quitter2;
	@FXML Button test;
	@FXML Button acceuille2;
	@FXML Button acceuille;
	
 @FXML public void initialize() {}
	 
	 public ButtonController() {}
	 
	
	public ButtonController(GestionJeu jeu,GestionOption option) {
			 this.jeu = jeu;
			 this.option = option;
	 }
	
	 public GestionOption getGestionOption() {return option;}
		 
	public GestionJeu getGestionJeu() { return jeu;}
	

	public void lancerPartie(ActionEvent event) throws IOException {
		jeu.InitialiserPartie();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("enJeu.fxml"));
		enJeuController enJeu = new enJeuController(jeu,option);
		loader.setController(enJeu);
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root,1300,700);
		stage.setTitle("Voici le jeu du pendu");
		stage.setScene(scene);
	}
	
	public void recommencerPartie(ActionEvent event) throws IOException {
		lancerPartie(event);
	}
	
	public void quitterPartie(ActionEvent event) throws IOException {
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
	
	public void acceuil(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("introduction.fxml"));
		IntroductionController intro = new IntroductionController(jeu,option);
		loader.setController(intro);
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root,1300,700);
		stage.setTitle("Introduction");
		stage.setScene(scene);
	}
	
	public void applyChanges(ActionEvent event) {
		System.out.println("applyyyyyy");
	}
	
	public void fin(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fin.fxml"));
		finController fin = new finController(jeu,option);
		loader.setController(fin);
		root = loader.load();
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root,1300,700);
		stage.setTitle("Fin du jeu");
		stage.setScene(scene);
	}
	
	public Stage getStage() {
		return stage;
	}
	
	public Pane getRoot() {
		return root;
	}
	
	public void setStage() {
		
	}

	public void setRoot() {
		
	}
}
