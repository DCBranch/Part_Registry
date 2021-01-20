package DeleteConfirmation;

import Main.MainWindowController;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

/**
 * FXML Controller class for the deletion pop-up window for the main window's 
 * deletion functionality.
 *
 * @author Dawson C. Branch
 * @version 2.0.0
 * @since 2.0.0
 * */
public class DeleteConfirmationWindowController extends Application implements Initializable {

    @FXML
    public Button btn_Yes;

    @FXML
    private Button btn_No;

    @FXML
    private Label lbl_Confirmation;
            
    
    public void start(Stage primary)
    {
        
    }
    
    @FXML
    void confirm(ActionEvent event) {
        //deletion(event);
        //exit(event);
    }

    @FXML
    void deny(ActionEvent event) {
        exit(event);
    }
    
    /**
     * exit - Closes the stage of the event's source
     * 
     * @param event - ActionEvent that is asking for its window to be closed
     */
    private void exit(ActionEvent event) {
        Node scene = (Node)event.getSource();
        Stage stage = (Stage)scene.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

}