package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;


public class Main extends Application {
	
	private GestionJeu jeu;
	private GestionOption option;
	
	@Override 
	public void init(){
		try {
			this.jeu = new GestionJeu("Dictionnaires/Dico.txt");
			this.option = new GestionOption();
			
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
		  Pane root = loader.load();
		  Scene scene = new Scene(root,1300,700);
		  stage.setTitle("Intoduction");
		  stage.setScene(scene);
		  stage.show();
	  } catch(Exception e) {
	   e.printStackTrace();
	  }
	 } 
	
	public static void main(String[] args) {
		launch(args);
	}
}
