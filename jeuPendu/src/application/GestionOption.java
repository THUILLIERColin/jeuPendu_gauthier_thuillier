package application;

import java.io.IOException;

import application.Main.Theme;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GestionOption{
	
	private String difficulty;
	private GestionJeu jeu;
	private Theme theme;
	private int MultPolice;
	private Pane root;
	
	public GestionOption(GestionJeu jeu) {this.jeu=jeu;}

	public void setDifficulty(String difficulty) {
		this.difficulty=difficulty;
	}
	public void setMultPolice(int MultPolice) {
		this.MultPolice = MultPolice;
	}
	public int getMultPolice() {
		return MultPolice;
	}
	public void changeDifficulty() throws IOException {
		if(difficulty=="Facile")jeu.ChangerDico("Dictionnaires/DicoFacile.txt");
		else if(difficulty=="Moyen")jeu.ChangerDico("Dictionnaires/DicoMoyen.txt");
		else if(difficulty=="Difficile")jeu.ChangerDico("Dictionnaires/DicoDifficile.txt"); 
	}
	
	public void setTheme(Theme theme) {
		this.theme=theme;
	}
	
	public Theme getTheme() {
		return theme;
	}
	
	public void setRoot(Pane root) {
		this.root=root;
	}
	
	public Background MAJAccueilWestern() {
		// mettre les backgrounds a jour en western
		
		BackgroundImage backWestern= new BackgroundImage(new Image("images/IntroWestern.jpg",1300,700,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		return new Background(backWestern);
	}
	
	public Background MAJAccueilFuturiste() {
		// mettre les backgrounds a jour en futuriste
		
		BackgroundImage backFutur= new BackgroundImage(new Image("images/IntroFutur.png",1300,700,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		return new Background(backFutur);
	}
	
	public Background MAJOptionFuturiste() {
		// mettre les backgrounds a jour en futuriste
		
		BackgroundImage backFutur= new BackgroundImage(new Image("images/option_aideFutur.png",1000,614.5,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		return new Background(backFutur);
	}
	
	public Background MAJOptionWestern() {
		// mettre les backgrounds a jour en futuriste
		
		BackgroundImage backFutur= new BackgroundImage(new Image("images/optionWestern.png",1000,614.5,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		return new Background(backFutur);
	}
	
	public Background MAJSupportFuturiste() {
		// mettre les backgrounds a jour en futuriste
		
		BackgroundImage backFutur= new BackgroundImage(new Image("images/option_aideFutur.png",1000,614.5,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		return new Background(backFutur);
	}
	
	public Background MAJSupportWestern() {
		// mettre les backgrounds a jour en futuriste
		
		BackgroundImage backFutur= new BackgroundImage(new Image("images/supportWestern.png",600,614.5,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		return new Background(backFutur);
	}
	
	public Background MAJEnJeuFuturiste() {
		// mettre les backgrounds a jour en futuriste
		
		BackgroundImage backFutur= new BackgroundImage(new Image("images/EnJeuFutur.png",1300,700,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		return new Background(backFutur);
	}
	
	public Background MAJEnJeuWestern() {
		// mettre les backgrounds a jour en futuriste
		
		BackgroundImage backFutur= new BackgroundImage(new Image("images/EnJeuWestern.jpg",1300,700,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		return new Background(backFutur);
	}
	
	public Background MAJFinFuturiste() {
		// mettre les backgrounds a jour en futuriste
		
		BackgroundImage backFutur= new BackgroundImage(new Image("images/FinFutur.png",1300,700,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		return new Background(backFutur);
	}
	
	public Background MAJFinWestern() {
		// mettre les backgrounds a jour en futuriste
		
		BackgroundImage backFutur= new BackgroundImage(new Image("images/FinWestern.jpg",1300,700,false,true),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
		return new Background(backFutur);
	}
	
	
	public void MAJIntro(Theme theme, Label labelIntro1,Label labelIntro2) {
		if(theme==Theme.WESTERN) {
			root.setBackground(MAJAccueilWestern());
			labelIntro1.setTextFill(Color.BLACK);
			labelIntro2.setTextFill(Color.BLACK);

			
		}
		else {
			root.setBackground(MAJAccueilFuturiste());
			labelIntro1.setTextFill(Color.WHITE);
			labelIntro2.setTextFill(Color.WHITE);

		}
			
		
		
	}
}
