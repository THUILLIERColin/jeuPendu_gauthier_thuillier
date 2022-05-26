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
	private String police;
	
	@FXML private CheckBox westernChoice = new CheckBox("Western");
	@FXML private CheckBox futuristeChoice = new CheckBox("Futur");
	
	ObservableList<String> difficulty = FXCollections.observableArrayList("Facile", "Moyen", "Difficile");
    @FXML private Spinner<String> spinneurDifficulty;

	
	@FXML public void initialize() {
		// Theme box
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
		
	    // Slider (taille police)
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) {
				police = Integer.toString((int)slider.getValue()+10);
				labelPolice.setStyle("-fx-font: " +  police +" arial;" );
				
			}
		});		
	}
	
	 	
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
