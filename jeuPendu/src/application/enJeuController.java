package application;

import java.io.IOException;
import java.util.Vector;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


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

	@FXML ImageView coeur1;
	@FXML ImageView coeur2;
	@FXML ImageView coeur3;
	@FXML ImageView coeur4;
	@FXML ImageView coeur5;
	@FXML ImageView coeur6;
	@FXML ImageView coeur7;

	


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

	private GestionJeu jeu = getGestionJeu();
	private Vector <Integer> pos = new Vector <Integer>();
	
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
		ancienMot = ancienMot.replace(" ","");
		char cara = car.charAt(0); 
		pos.removeAllElements();
		
		int nb = jeu.ChercherLettreDansMot(cara, pos);
		
		for(int i = 0;i<jeu.getMotMystere().length();i++) {
			
			if(pos.indexOf(i)!=-1) {
				newMot = newMot + car;

			}
			else {
				newMot = newMot + ancienMot.charAt(i); 
			}
		}
		
		
		
		
		return newMot;
		
	}
	@FXML public String addSpace(String s) {
		String plusSpace = "";
		for(int i = 0;i<s.length();i++) {
			plusSpace = plusSpace + s.charAt(i) + " ";
		}
		return plusSpace;
	}
	
	@FXML public void initialize() {
		jeu.setNbMaxErreurs(6);
		info.setText("Salut Cowboy, prêt à jouer? Appuie sur une lettre pour commencer!");
		mot.setText(addSpace(toUnderScore(jeu.getMotMystere())));
		corde.setVisible(false);
		jambe1.setVisible(false);
		jambe2.setVisible(false);
		bras1.setVisible(false);
		bras2.setVisible(false);
		tete.setVisible(false);
		corp.setVisible(false);
		coeur1.setVisible(true);
		coeur2.setVisible(true);
		coeur3.setVisible(true);
		coeur4.setVisible(true);
		coeur5.setVisible(true);
		
	}
	
	public void erreur() {
		switch(jeu.getNbErreurs()) {
			case 1: corde.setVisible(true);coeur1.setVisible(false); break;
			case 2: tete.setVisible(true);coeur2.setVisible(false); break;
			case 3: corp.setVisible(true);coeur3.setVisible(false); break;
			case 4: jambe1.setVisible(true);coeur4.setVisible(false); break;
			case 5 : jambe2.setVisible(true); coeur5.setVisible(false);break;
			case 6 : bras1.setVisible(true);coeur6.setVisible(false); break;
			case 7 : bras2.setVisible(true); coeur7.setVisible(false);break;
		}
	}
	
	public enJeuController(GestionJeu jeu, GestionOption option) {
		super(jeu, option);
	}
	
	public void handleButtonKeybord(ActionEvent event) {
		
	    String lettre =((Button) event.getSource()).getId().toUpperCase();
	        	
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
		                	 mot.setText( addSpace(addLettreUnderscore(lettre)));
		                 }
	        	 }
	       
		        if(jeu.MaxErreursDepasse()||jeu.ToutTrouve()){
		        	try {
						fin(event);
					} catch (IOException e) {
				
						e.printStackTrace();
					}
		        }
	       
	}
}

