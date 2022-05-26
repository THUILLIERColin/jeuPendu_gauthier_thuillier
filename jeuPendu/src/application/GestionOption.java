package application;

import java.io.IOException;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class GestionOption{
	
	private String difficulty;
	private GestionJeu jeu;
	private String theme;
	
	public GestionOption(GestionJeu jeu) {this.jeu=jeu;}

	public void setDifficulty(String difficulty) {
		this.difficulty=difficulty;
	}
	
	public void changeDifficulty() throws IOException {
		if(difficulty=="Facile")jeu.ChangerDico("Dictionnaires/DicoFacile.txt");
		else if(difficulty=="Moyen")jeu.ChangerDico("Dictionnaires/DicoMoyen.txt");
		else if(difficulty=="Difficile")jeu.ChangerDico("Dictionnaires/DicoDifficile.txt");
	}
	
	public void setTheme(String theme) {
		this.theme=theme;
	}
	
	public String getTheme() {
		return theme;
		
	}
	
	public Background MAJIntroWestern() {
		// mettre les backgrounds a jour en western
		
		BackgroundImage backWestern= new BackgroundImage(new Image("images/IntroWestern.jpg",1300,700,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		return new Background(backWestern);
	}
	
	public Background MAJIntroFuturiste() {
		// mettre les backgrounds a jour en futuriste
		
		BackgroundImage backFutur= new BackgroundImage(new Image("images/IntroFutur.png",1300,700,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		return new Background(backFutur);
	}
}
