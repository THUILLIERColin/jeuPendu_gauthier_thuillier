package application;

import java.io.IOException;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;
import javafx.stage.Window;

public class optionController {
	
	@FXML Slider slider;
	@FXML Button test;
	@FXML Label labelPolice;
	private String police;
	
	@FXML private CheckBox westernTheme = new CheckBox("western");
	@FXML private CheckBox futuristeTheme = new CheckBox("futur");
	
	@FXML public void initialize() {
		westernTheme.setSelected(true);
		futuristeTheme.setSelected(false);
		
		slider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldNumber, Number newNumber) {
				police = Integer.toString((int)slider.getValue()+10);
				labelPolice.setStyle("-fx-font: " +  police +" arial;" );
				
			}			
		});		
	}
	
	public optionController() {	}
	
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
	
	
	
}
