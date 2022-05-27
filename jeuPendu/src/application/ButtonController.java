package application;

import java.io.IOException;

import application.Main.Theme;
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
	protected Pane root;
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
		
		// Background
		if(option.getTheme()==Theme.FUTURISTE) {
			root.setBackground(option.MAJEnJeuFuturiste());
		}
		else {
			root.setBackground(option.MAJEnJeuWestern());
		}
				
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
		
		// Background
		if(option.getTheme()==Theme.FUTURISTE) root.setBackground(option.MAJAccueilFuturiste());
		else root.setBackground(option.MAJAccueilWestern());
		
		option.setRoot(root);
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root,1300,700);
		stage.setTitle("Introduction");
		stage.setScene(scene);
	}
	
	public void fin(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("fin.fxml"));
		finController fin = new finController(jeu,option);
		loader.setController(fin);
		root = loader.load();
		
		// Background 
		if(option.getTheme()==Theme.FUTURISTE) root.setBackground(option.MAJFinFuturiste());
		else root.setBackground(option.MAJFinWestern());
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root,1300,700);
		stage.setTitle("Fin du jeu");
		stage.setScene(scene);
	}

}
