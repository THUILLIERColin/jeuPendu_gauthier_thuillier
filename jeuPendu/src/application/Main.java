package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	private GestionJeu jeu;
	private GestionOption option;
	
	@Override 
	public void init(){
		try {
			this.jeu = new GestionJeu("Dictionnaires/DicoMoyen.txt");
			this.option = new GestionOption(jeu);
			
		}
		catch(Exception e) {
			System.err.print(e);
		}
	}
	
	@Override
	 public void start(Stage stage) {
	  try {
		  FXMLLoader loader = new FXMLLoader(getClass().getResource("introduction.fxml"));
		  IntroductionController intro= new IntroductionController(jeu,option);
		  loader.setController(intro);
		  stage.show();
		  Pane root = loader.load();
		  
		  // Background
		  root.setBackground(option.MAJIntroWestern());
		  
		  Scene scene = new Scene(root,1300,700);
		  stage.setTitle("Intoduction");
		  stage.setScene(scene);
	  } catch(Exception e) {
	   e.printStackTrace();
	  }
	 } 
	
	public static void main(String[] args) {
		launch(args);
	}
}
