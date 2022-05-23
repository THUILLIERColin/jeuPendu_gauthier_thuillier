package application;

import java.awt.Color;
import java.awt.Paint;
import java.io.IOException;
import java.util.Vector;

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
	Vector <Integer> pos = new Vector <Integer>();
	
	public String toUnderScore(String mot) {
		String under = "";
		for(int i = 0;i<mot.length();i++)
			under = under + "_";
		return under;
		
	}
	
	@FXML
	public String addLettreUnderscore(String car) {
		String newMot = "";
		String ancienMot = mot.getText();
		System.out.print(ancienMot);
		char cara = car.charAt(0); 
		pos.removeAllElements();
		
		int nb = jeu.ChercherLettreDansMot(cara, pos);
		for(int j = 0;j<nb;j++) {
		for(int i = 0;i<jeu.getMotMystere().length();i++) {
			if(pos.indexOf(i)==0)
				newMot = newMot + car ;
			else 
				newMot = newMot + ancienMot.charAt(i); 
		}}
		return newMot;
		
	}
	@FXML public void initialize() {
		jeu.setNbMaxErreurs(7);
		info.setText("Salut Cowboy, prêt à jouer? Appuie sur une lettre pour commencer!");
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
	                 	info.setText("Tu as déjà essayé pied tendre!");
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
	        				                 	info.setText("Tu as déjà essayé pied tendre!");
	        		 }
		                 else {
		                 	jeu.setLettresDejaDonnees(lettre+ jeu.getLettresDejaDonnees());
		                	 ((Node) event.getSource()).setStyle("-fx-base: #00FF00;");
		                	 info.setText("Bonne lettre Cowboy!");
		                	 mot.setText( addLettreUnderscore(lettre));
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

