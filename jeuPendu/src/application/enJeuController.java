package application;

import java.awt.Color;
import java.awt.Paint;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;



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
	@FXML Label info;
	@FXML Label mot;

	@FXML ImageView corde;
	@FXML ImageView tete;
	@FXML ImageView corp;
	@FXML ImageView bras1;
	@FXML ImageView bras2;
	@FXML ImageView jambe1;
	@FXML ImageView jambe2;



	@FXML Button a;
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
		return under;
		
	}
	public String addLettre() {
	return "";	
	}
	@FXML public void initialize() {
		info.setText("Salut Cowboy, pr�t � jouer? Appuie sur une lettre pour commencer!");
		mot.setText(toUnderScore(jeu.getMotMystere()));
		corde.setVisible(false);
		jambe1.setVisible(false);
		jambe2.setVisible(false);
		bras1.setVisible(false);
		bras2.setVisible(false);
		tete.setVisible(false);
		corp.setVisible(false);
	}
	
	public void erreur() {
		switch(jeu.getNbErreurs()) {
		case 1: corde.setVisible(true); 
		break;
		case 2: tete.setVisible(true);
		break;
		case 3: corp.setVisible(true);
		break;
		case 4: jambe1.setVisible(true);
		}
	}
	
	public enJeuController(GestionJeu jeu, GestionOption option) {
		super(jeu, option);
	}
	
	public void handleButtonKeybord(ActionEvent event) {
		
	    String lettre =    ((Button) event.getSource()).getId().toUpperCase();
	       System.out.print(lettre);
	        	
	        	 if(!jeu.getMotMystere().contains(lettre)) {
	                 if(jeu.getLettresDejaDonnees().contains(lettre))
	                 	info.setText("Tu as d�j� essay� pied tendre!");
	                 else {
	                 	jeu.setLettresDejaDonnees(lettre+ jeu.getLettresDejaDonnees());
	                 	jeu.MAJNbErreurs();
	                	 ((Node) event.getSource()).setStyle("-fx-base: #FF0000;");
	                	 info.setText("Mauvaise lettre Cowboy!");

	                	 erreur();
	                 }
	        	 }
	        	 else {
	        		 if(jeu.getLettresDejaDonnees().contains(lettre)) {
	        				                 	info.setText("Tu as d�j� essay� pied tendre!");
	        		 }
		                 else {
		                 	jeu.setLettresDejaDonnees(lettre+ jeu.getLettresDejaDonnees());
		                	 ((Node) event.getSource()).setStyle("-fx-base: #00FF00;");
		                	 info.setText("Bonne lettre Cowboy!");
		                	 jeu.setNbLettresTrouvees(jeu.getNbLettresTrouvees()+1);
	        	 }
	        	 }
	        if(jeu.MaxErreursDepasse()||jeu.ToutTrouve()){
	        	try {
					troisEcran(event);
				} catch (IOException e) {
			
					e.printStackTrace();
				}
	        }
	       
	}
}

