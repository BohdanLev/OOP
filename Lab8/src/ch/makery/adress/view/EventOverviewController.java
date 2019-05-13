package ch.makery.adress.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ch.makery.adress.MainApp;
import ch.makery.adress.model.Event;
import ch.makery.adress.util.DateUtil;

public class EventOverviewController {
    @FXML
    private TableView<Event> eventTable;
    @FXML
    private TableColumn<Event, String> nameColumn;

    @FXML
    private Label dateLabel;
    @FXML
    private Label timeStartLabel;
    @FXML
    private Label durationLabel;
    @FXML
    private Label placeLabel;
    @FXML
    private Label descriptionLabel;
    
    private MainApp mainApp;

    public EventOverviewController() 
    {
    
    }

    @FXML
    private void initialize() 
    {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());

        showEventDetails(null);

        eventTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showEventDetails(newValue));
    }

    public void setMainApp(MainApp mainApp) 
    {
        this.mainApp = mainApp;      
        eventTable.setItems(mainApp.getEventData());
    }
    
    private void showEventDetails(Event event)
    {
        if (event != null) 
        {
            dateLabel.setText(DateUtil.format(event.getDate()));   // ??????????????
            timeStartLabel.setText(event.getTimeStart());
            durationLabel.setText(event.getDuration());
            placeLabel.setText(event.getPlace());
            descriptionLabel.setText(event.getDescription());
        } 
        else 
        {       
        	 dateLabel.setText(""); 
             timeStartLabel.setText("");
             durationLabel.setText("");
             placeLabel.setText("");
             descriptionLabel.setText("");
        }
    }
    
    @FXML
    private void handleDeleteEvent() 
    {
        int selectedIndex = eventTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) 
        {
            eventTable.getItems().remove(selectedIndex);
        } 
        else 
        {        
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Event Selected");
            alert.setContentText("Please select an Event in the table.");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleNewEvent() 
    {
        Event tempEvent = new Event();
        boolean okClicked = mainApp.showEventEditDialog(tempEvent);
        if (okClicked) 
            mainApp.getEventData().add(tempEvent);
    }
    
    @FXML
    private void handleEditEvent() 
    {
        Event selectedEvent = eventTable.getSelectionModel().getSelectedItem();
        if (selectedEvent != null) 
        {
            boolean okClicked = mainApp.showEventEditDialog(selectedEvent);
            if (okClicked) 
                showEventDetails(selectedEvent);            
        } 
        else 
        {         
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Event Selected");
            alert.setContentText("Please select an event in the table.");
            alert.showAndWait();
        }
    }
}