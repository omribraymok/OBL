package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.MainClient;
import common.MessageCS;
import common.MessageCS.MessageType;
import entity.ActivityLog;
import entity.Subscriber;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ActivityLogController implements Initializable
{


	@FXML private TableView<ActivityLog> activityLogTable;
	@FXML private TableColumn<ActivityLog, String> columnDate;
	@FXML private TableColumn<ActivityLog, String> columnAction;

	public static ArrayList<ActivityLog> finalSubscriberActivity;
	private ObservableList<ActivityLog> listOfActivities;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{
		Subscriber subscriberA = new Subscriber(LoginController.subscriberResult.getSubscriberDetails());
		MessageCS message = new MessageCS(MessageType.ACTIVITY_LOG,subscriberA);
		MainClient.client.accept(message);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//if the subscriber dont have any activity/////////////////////////////
		if(finalSubscriberActivity.size()==0)
		{
			Alert alert1=new Alert(Alert.AlertType.INFORMATION);
			alert1.setTitle("Activities");
			alert1.setContentText("You dont have any activity.");
			alert1.showAndWait();
			return;
		}
		///////////////////////////////////////////////////////////////////////
		else 
		{
			for(int i = 0; i < finalSubscriberActivity.size(); i++)
			{   
				System.out.print(finalSubscriberActivity.get(i).getDate());
				System.out.println(" ");
				System.out.print(finalSubscriberActivity.get(i).getActivity());
				System.out.println(" ");
			}
			listOfActivities = FXCollections.observableArrayList(finalSubscriberActivity);
			columnAction.setCellValueFactory(new PropertyValueFactory<ActivityLog,String>("Action"));
			columnDate.setCellValueFactory(new PropertyValueFactory<ActivityLog,String>("Date"));
			activityLogTable.setItems(listOfActivities);
		}

	}

}
