/**
 * 
 */
package controller;

import java.io.IOException;

import boundary.LoadGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * @author shalev
 *
 */
public class LibrarianMenu {

	@FXML
	private Button createSubscriberButton;
	
	@FXML
	private Button reviewSubscriberButton;
	
	@FXML
	/** listener for the button press of createSubscriber 
	 * @throws IOException */
	public void createSubscriber() throws IOException {
		LoadGUI.loadFXML("Create.fxml",createSubscriberButton);
	}
	@FXML
	/** listener for the button press of createSubscriber 
	 * @throws IOException */
	void reviewSubscriber(ActionEvent event) throws IOException {
		LoadGUI.loadFXML("ReviewSubscriber.fxml", reviewSubscriberButton);
	}
}