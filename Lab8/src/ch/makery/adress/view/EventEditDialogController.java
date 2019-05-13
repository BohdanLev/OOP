package ch.makery.adress.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ch.makery.adress.model.Event;
import ch.makery.adress.util.DateUtil;

public class EventEditDialogController {

    @FXML
    private TextField nameField;
	@FXML
    private TextField dateField;
    @FXML
    private TextField timeStartField;
    @FXML
    private TextField durationField;
    @FXML
    private TextField placeField;
    @FXML
    private TextField descriptionField;


    private Stage dialogStage;
    private Event event;
    private boolean okClicked = false;

    @FXML
    private void initialize() 
    {
    
    }

    public void setDialogStage(Stage dialogStage) 
    {
        this.dialogStage = dialogStage;
    }
    
    public void setEvent(Event event) {
        this.event = event;
        nameField.setText(event.getName());
        dateField.setText(DateUtil.format(event.getDate()));
        dateField.setPromptText("dd.mm.yyyy");
        timeStartField.setText(event.getTimeStart());
        durationField.setText(event.getDuration());
        placeField.setText(event.getPlace());
        descriptionField.setText(event.getDescription());
    }

    public boolean isOkClicked() 
    {
        return okClicked;
    }

    @FXML
    private void handleOk() 
    {
        if (isInputValid()) 
        {
        	event.setName(nameField.getText());
        	event.setDate(DateUtil.parse(dateField.getText()));
        	event.setTimeStart(timeStartField.getText());
            event.setDuration(durationField.getText());
            event.setPlace(placeField.getText());           
            event.setDescription(descriptionField.getText());          
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    private void handleCancel() 
    {
        dialogStage.close();
    }

    private boolean isInputValid() 
    {
        String errorMessage = "";

        if (dateField.getText() == null || dateField.getText().length() == 0) 
            errorMessage += "No valid birthday!\n";
        else 
            if (!DateUtil.validDate(dateField.getText())) 
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
      
        if (timeStartField.getText() == null || timeStartField.getText().length() == 0)         
            errorMessage += "No valid time start!\n"; 
        
        if (durationField.getText() == null || durationField.getText().length() == 0) 
            errorMessage += "No valid duration!\n"; 
        
        if (placeField.getText() == null || placeField.getText().length() == 0)         
            errorMessage += "No valid place!\n"; 
        
        if (descriptionField.getText() == null || descriptionField.getText().length() == 0)        
            errorMessage += "No valid description!\n"; 

        if (errorMessage.length() == 0)         
            return true;        
        else 
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please enter correct fields");
            alert.setContentText(errorMessage);            
            alert.showAndWait();            
            return false;
        }
    }
}