package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;



/*
 * import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class Jeu {

	public static void main(String[] args) throws IOException {
		   //pour indiquer la fin d'une partie
		   boolean finJeu;

		   //pour indiquer la fin du jeu
		   boolean quitterJeu;

		   //réponse du joueur 
		   String reponse;
    		   
		   //positions où se trouve le caractère proposé par le joueur dans le mot à deviner
		   Vector<Integer> pos; 
	
		   //pour gérer le jeu
		   GestionJeu jeu = new GestionJeu(Jeu.class.getResource("Dico.txt").getFile());
	   //  GestionJeu jeu = new GestionJeu(getClass().getResource("/Dico.txt").getFile();... si on avait été dans une méthode d'instance
		   
		   
		   quitterJeu = false;
		   do
		   { //la partie commence
			   jeu.InitialiserPartie();
               finJeu = false;
		       do
		       {
		    	   do
		           {//on saisit la lettre proposée par le joueur
		    		   System.out.println("Votre lettre : ");
		               BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		               reponse = in.readLine().toUpperCase();
		           } while (!(jeu.CaractereAutorise(reponse) && (jeu.getLettresDejaDonnees().indexOf(reponse.charAt(0))==-1)));
						
		    	   //la lettre choisie est mémorisée pour éviter que le joueur ne la redonne par la suite
		    	   jeu.MemoriserLettreChoisie(reponse.charAt(0));
	                
		    	   pos = new Vector<Integer>();
		           if (jeu.ChercherLettreDansMot(reponse.charAt(0), pos) == 0)
		           {	//la lettre n'est pas dans le mot, une erreur de plus
		                jeu.MAJNbErreurs();
		                if (jeu.MaxErreursDepasse())
		                {//le joueur a dépassé le nombre masimum d'erreurs autorisé...il perd
		                	finJeu = true;
		                    System.out.println("Vous perdez. Il fallait trouver "+jeu.getMotMystere()+" !!!");
		                }
		                else
		                	System.out.println("Nb d'erreurs: " + jeu.getNbErreurs());
		           }
		           else
		           {	//la lettre est dans le mot à toutes les positions indiquées dans pos
		        	   	if (jeu.ToutTrouve()) 
		                {	//toutes les lettres ont été trouvées
		                    finJeu = true;
		                    System.out.println("Vous gagnez!!!");
		                }
		                else
		                	System.out.println(reponse.charAt(0) + " est en position " + pos);		        
		           }
		       } while (!finJeu);
		           
		       //on demande au joueur s'il veut faire une autre partie
		       System.out.println("Voulez-vous rejouer (o pour oui)?");
		       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		       reponse = in.readLine();
		       quitterJeu = (reponse.compareTo("o") != 0);		          
		     } while (!quitterJeu);
	}
}
 */

public class enJeuController extends ButtonController{
	@FXML Label info;
	@FXML Label mot;

	@FXML ImageView corde;
	@FXML Button A;
	@FXML Button b;
	@FXML Button c;
	@FXML Button d;
	@FXML Button e;
	@FXML Button f;
	@FXML Button g;
	@FXML Button h;
	@FXML Button i;
	@FXML Button j;
	@FXML Button l;
	@FXML Button m;
	@FXML Button n;
	@FXML Button o;
	@FXML Button p;
	@FXML Button q;
	@FXML Button r;
	@FXML Button s;
	@FXML Button t;
	@FXML Button u;
	@FXML Button v;
	@FXML Button w;
	@FXML Button x;
	@FXML Button y;
	@FXML Button z;

	GestionJeu jeu = getJeu();
	
	public String toUnderScore(String mot) {
		String under = "";
		for(int i = 0;i<mot.length();i++)
			under = under + "_ ";
		System.out.println(under + mot);
		return under;
		
	}
	public String addLettre() {
	return "";	
	}
	@FXML public void initialize() {
		info.setText("Salut Cowboy, prêt à jouer? Appuie sur une lettre pour commencer!");
		mot.setText(toUnderScore(jeu.getMotMystere()));
		
		
	}
	
	public enJeuController(GestionJeu jeu, GestionOption option) {
		super(jeu, option);
	}
	
	public void handleButtonKeybord(ActionEvent event) {
		
	}

}
