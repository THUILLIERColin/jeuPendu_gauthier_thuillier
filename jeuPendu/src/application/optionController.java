package application;

import java.io.IOException;

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
	
	@FXML private CheckBox westernTheme = new CheckBox("western");
	@FXML private CheckBox futuristeTheme = new CheckBox("futur");
	
	ObservableList<String> difficulty = FXCollections.observableArrayList("Facile", "Moyen", "Difficile");
    @FXML private Spinner<String> spinneurDifficulty;

	
	@FXML public void initialize() {
		// Theme box
		westernTheme.setSelected(true);
		futuristeTheme.setSelected(false);
		
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
	
	public void setWesternTheme(ActionEvent event) throws IOException {
		westernTheme.setSelected(true);
		futuristeTheme.setSelected(false);
	}
	
	public boolean getWesternTheme(){
		return westernTheme.isSelected();
	}
	
	 
	public void setFuturisteTheme(ActionEvent event) throws IOException {
		westernTheme.setSelected(false);
		futuristeTheme.setSelected(true);
	}

	public boolean getFutirusteTheme(){
		return futuristeTheme.isSelected();
	}
	
	public String getDifficulty() {
		return spinneurDifficulty.getValue();
	}
	
	
	
}
