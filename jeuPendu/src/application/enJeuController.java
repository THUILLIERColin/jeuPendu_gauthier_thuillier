package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;



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

		   //r�ponse du joueur 
		   String reponse;
    		   
		   //positions o� se trouve le caract�re propos� par le joueur dans le mot � deviner
		   Vector<Integer> pos; 
	
		   //pour g�rer le jeu
		   GestionJeu jeu = new GestionJeu(Jeu.class.getResource("Dico.txt").getFile());
	   //  GestionJeu jeu = new GestionJeu(getClass().getResource("/Dico.txt").getFile();... si on avait �t� dans une m�thode d'instance
		   
		   
		   quitterJeu = false;
		   do
		   { //la partie commence
			   jeu.InitialiserPartie();
               finJeu = false;
		       do
		       {
		    	   do
		           {//on saisit la lettre propos�e par le joueur
		    		   System.out.println("Votre lettre : ");
		               BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		               reponse = in.readLine().toUpperCase();
		           } while (!(jeu.CaractereAutorise(reponse) && (jeu.getLettresDejaDonnees().indexOf(reponse.charAt(0))==-1)));
						
		    	   //la lettre choisie est m�moris�e pour �viter que le joueur ne la redonne par la suite
		    	   jeu.MemoriserLettreChoisie(reponse.charAt(0));
	                
		    	   pos = new Vector<Integer>();
		           if (jeu.ChercherLettreDansMot(reponse.charAt(0), pos) == 0)
		           {	//la lettre n'est pas dans le mot, une erreur de plus
		                jeu.MAJNbErreurs();
		                if (jeu.MaxErreursDepasse())
		                {//le joueur a d�pass� le nombre masimum d'erreurs autoris�...il perd
		                	finJeu = true;
		                    System.out.println("Vous perdez. Il fallait trouver "+jeu.getMotMystere()+" !!!");
		                }
		                else
		                	System.out.println("Nb d'erreurs: " + jeu.getNbErreurs());
		           }
		           else
		           {	//la lettre est dans le mot � toutes les positions indiqu�es dans pos
		        	   	if (jeu.ToutTrouve()) 
		                {	//toutes les lettres ont �t� trouv�es
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
	
	
	
	
	public enJeuController(GestionJeu jeu) {
		super(jeu);
	}
	
	public void handleButtonKeybord(ActionEvent event) {
		
	}

}
