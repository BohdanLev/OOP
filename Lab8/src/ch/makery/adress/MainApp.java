package ch.makery.adress;

import java.io.IOException;

import ch.makery.adress.model.Event;
import ch.makery.adress.view.EventEditDialogController;
import ch.makery.adress.view.EventOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application 
{

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Event> eventData = FXCollections.observableArrayList();

    public ObservableList<Event> getEventData() 
    {
        return eventData;
    }    
    
    @Override
    public void start(Stage primaryStage) 
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Lab8");
        initRootLayout();
        showEventOverview();
    }
    
    public boolean showEventEditDialog(Event event) {
        try 
        {            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EventEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Event");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);
           
            EventEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setEvent(event);

            dialogStage.showAndWait();
            
            return controller.isOkClicked();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            return false;
        }
    }
  
    public void initRootLayout() {
        try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public void showEventOverview() {
        try 
        {       
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EventOverview.fxml"));
            AnchorPane eventOverview = (AnchorPane) loader.load();
         
            rootLayout.setCenter(eventOverview);

            EventOverviewController controller = loader.getController();
            controller.setMainApp(this);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() 
    {
        return primaryStage;
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}