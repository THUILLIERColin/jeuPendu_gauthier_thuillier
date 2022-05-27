package application;

import java.io.IOException;

import application.Main.Theme;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class optionController extends ButtonController{
	
	@FXML Slider slider;
	@FXML Button test;
	@FXML Label labelPolice;
	@FXML Label labelOption1;
	@FXML Label labelOption2;
	@FXML Label labelOption3;
	private int lastPoliceMult;

	private int policeMult;
	
	@FXML private CheckBox westernChoice = new CheckBox("Western");
	@FXML private CheckBox futuristeChoice = new CheckBox("Futur");
	
	ObservableList<String> difficulty = FXCollections.observableArrayList("Facile", "Moyen", "Difficile");
    @FXML private Spinner<String> spinneurDifficulty;

	
	@FXML public void initialize() {
		// Theme box
		
		slider.setValue(super.getGestionOption().getMultPolice());
		labelOption3.setStyle("-fx-font-size :"+Integer.toString(21+super.getGestionOption().getMultPolice()) + " Arial;");
		labelOption2.setStyle("-fx-font-size :"+Integer.toString(21+super.getGestionOption().getMultPolice()) + " Arial;");
		labelOption1.setStyle("-fx-font-size :"+Integer.toString(21+super.getGestionOption().getMultPolice()) + " Arial;");
		if(super.getGestionOption().getTheme()==Theme.WESTERN) {
			westernChoice.setSelected(true);
			futuristeChoice.setSelected(false);
		} 
		
		else {
			westernChoice.setSelected(false);
			futuristeChoice.setSelected(true);
		}
		
		
		// Spinner (Difficulte)
		SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<String>(difficulty);
	    valueFactory.setValue("Moyen");
	    spinneurDifficulty.setValueFactory(valueFactory);
		//slider.setValue(policeMult);
	    // Slider (taille police)
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) {
				policeMult = (int)slider.getValue();
				labelPolice.setStyle("-fx-font: " +  Integer.toString(policeMult +10) +" arial;" );
				
			}
		});		
	}
	@FXML public void setOptionLabel(int multPolice) {
		labelOption1.setStyle("-fx-font-size :"+Integer.toString(21+multPolice) + " Arial;");
		labelOption2.setStyle("-fx-font-size :"+Integer.toString(21+multPolice) + " Arial;");
		labelOption3.setStyle("-fx-font-size :"+Integer.toString(21+multPolice) + " Arial;");

	}
	
	public int getPoliceMult() {return policeMult;}
	
	public optionController(GestionJeu jeu, GestionOption option) {
		super(jeu,option);
	}
	
	public void setWesternChoice(ActionEvent event) throws IOException {
		westernChoice.setSelected(true);
		futuristeChoice.setSelected(false);
	}
	
	public boolean getWesternChoice(){
		return westernChoice.isSelected();
	}
	
	 
	public void setFuturisteChoice(ActionEvent event) throws IOException {
		westernChoice.setSelected(false);
		futuristeChoice.setSelected(true);
	}

	public boolean getFuturisteChoice(){
		return futuristeChoice.isSelected();
	}
	
	public Theme getThemeChoisi() {
		if (westernChoice.isSelected()) return Theme.WESTERN;
		return Theme.FUTURISTE;
	}
	
	public String getDifficulty() {
		return spinneurDifficulty.getValue();
	}
	
	
	
}
