package EditPart;

import Main.MainWindowController;
import Main.Part_Registry;
import Parts.ConsumablePart;
import Parts.ExpendablePart;
import Parts.Part;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class for editing window spawned the main window's view tab. 
 * Receives the data for a selected part in the list view on the main window, 
 * fills the edit part window's text fields with said data, and allows the user 
 * to change the data as they see fit. Entering the new data or canceling both 
 * close the editing window.
 *
 * @author Dawson C. Branch
 * @version 2.0.0
 * @since 2.0.0
 * */
public class EditPartWindowController implements Initializable  {

    @FXML
    private Label lbl_NewEntry_InvText;

    @FXML
    private HBox hbx_Name;

    @FXML
    private Label lbl_NewEntry_Name;

    @FXML
    private TextField txt_NewEntry_Name;

    @FXML
    private Label lbl_NewEntry_InvName;

    @FXML
    private HBox hbx_Number;

    @FXML
    private Label lbl_NewEntry_Number;

    @FXML
    private TextField txt_NewEntry_Number;

    @FXML
    private Label lbl_NewEntry_InvNum;

    @FXML
    private HBox hbx_Ncage;

    @FXML
    private Label lbl_NewEntry_Ncage;

    @FXML
    private TextField txt_NewEntry_Ncage;

    @FXML
    private Label lbl_NewEntry_InvNcage;

    @FXML
    private HBox hbx_Id;

    @FXML
    private Label lbl_NewEntry_Id;

    @FXML
    private TextField txt_NewEntry_Id;

    @FXML
    private Label lbl_NewEntry_InvNiin;

    @FXML
    private HBox hbx_FailureRate;

    @FXML
    private Label lbl_NewEntry_FailureRate;

    @FXML
    private TextField txt_NewEntry_FailureRate;

    @FXML
    private Label lbl_NewEntry_InvRate;

    @FXML
    private HBox hbx_LeadTime;

    @FXML
    private Label lbl_NewEntry_LeadTime;

    @FXML
    private TextField txt_NewEntry_LeadTime;

    @FXML
    private Label lbl_NewEntry_InvLead;

    @FXML
    private HBox hbx_ToolsRequired;

    @FXML
    private Label lbl_NewEntry_ToolsRequired;

    @FXML
    private TextField txt_NewEntry_ToolsRequired;

    @FXML
    private Label lbl_NewEntry_InvTools;

    @FXML
    private HBox hbx_ReplacementCost;

    @FXML
    private Label lbl_NewEntry_ReplacementCost;

    @FXML
    private TextField txt_NewEntry_ReplacementCost;

    @FXML
    private Label lbl_NewEntry_InvCost;

    @FXML
    private HBox hbx_UsesLeft;

    @FXML
    private Label lbl_NewEntry_UsesLeft;

    @FXML
    private TextField txt_NewEntry_UsesLeft;

    @FXML
    private Label lbl_NewEntry_InvUses;

    @FXML
    public Button btn_Enter;

    @FXML
    public Button btn_Cancel;

    @FXML
    private RadioButton rad_NewEntry_Expendable;

    @FXML
    private RadioButton rad_NewEntry_Consumable;

    @FXML
    void enterPart(ActionEvent event) {

    }

    /**
     * exit - Closes the stage of the event's source
     * 
     * @param event - ActionEvent that is asking for its window to be closed
     */
    @FXML
    void exit(ActionEvent event) {
        Node scene = (Node)event.getSource();
        Stage stage = (Stage)scene.getScene().getWindow();
        stage.close();
    }
    
    /**
     * setName - Sets the name that appears in its respective text box
     * 
     * @param s - String passed to fill in text box
     */
    public void setName(String s)
    {
        this.txt_NewEntry_Name.setText(s);
    }
    
    /**
     * setNumber - Sets the number that appears in its respective text box
     * 
     * @param s - String passed to fill in text box
     */
    public void setNumber(String s)
    {
        this.txt_NewEntry_Number.setText(s);
    }
    
    /**
     * setNcage - Sets the ncage that appears in its respective text box
     * 
     * @param s - String passed to fill in text box
     */
    public void setNcage(String s)
    {
        this.txt_NewEntry_Ncage.setText(s);
    }
    
    /**
     * setNiin - Sets the niin that appears in its respective text box
     * 
     * @param s - String passed to fill in text box
     */
    public void setNiin(String s)
    {
        this.txt_NewEntry_Id.setText(s);
    }
    /**
     * setFailure - Sets the failure rate that appears in its respective text box
     *
     * @param s - String passed to fill in text box
     */
    public void setFailure(String s)
    {
        this.txt_NewEntry_FailureRate.setText(s);
    }
    
    /**
     * setlead - Sets the lead time that appears in its respective text box
     *
     * @param s - String passed to fill in text box
     */
    public void setLead(String s)
    {
        this.txt_NewEntry_LeadTime.setText(s);
    }
    
    /**
     * setTools - Sets the tools that appears in its respective text box
     *
     * @param s - String passed to fill in text box
     */
    public void setTools(String s)
    {
        this.txt_NewEntry_ToolsRequired.setText(s);
    }
    
    /**
     * setCost - Sets the replacement cost that appears in its respective text 
     * box
     *
     * @param s - String passed to fill in text box
     */
    public void setCost(String s)
    {
        this.txt_NewEntry_ReplacementCost.setText(s);
    }
    
    /**
     * setUses - Sets the uses left that appears in its respective text box
     *
     * @param s - String passed to fill in text box
     */
    public void setUses(String s)
    {
        this.txt_NewEntry_UsesLeft.setText(s);
    }
    
    /**
     * getPart - Provides a Part object created from the data of the edit 
     * window's text boxes
     * 
     * @return An expendable or consumable part object depending on which radio
     * button is selected
     */
    public Part getPart() {
        if (rad_NewEntry_Expendable.isSelected())
            return new ExpendablePart();
        else
            return new ConsumablePart();
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup partTypeGroup = new ToggleGroup();
        rad_NewEntry_Consumable.setToggleGroup(partTypeGroup);
        rad_NewEntry_Expendable.setToggleGroup(partTypeGroup);
        entryTab_ConsumableDeselected();
        entryTab_ExpendableDeselected();
        partTypeGroup.selectedToggleProperty().addListener((observable, t, t1) -> entryTab_TypeToggle());
    }
    
    /**
     * entryTab_ConsumableSelected - Enables consumable part GUI sections
     */
    private void entryTab_ConsumableSelected() 
    {
        //Enabling consumable part controls
        Part_Registry.turnOnNode(hbx_ReplacementCost);
        Part_Registry.turnOnNode(hbx_UsesLeft);
    }
    
    /**
     * entryTab_ExpendableSelected - Enables expendable part GUI sections
     */
    private void entryTab_ExpendableSelected() 
    {
        //Enabling expendable part controls
        Part_Registry.turnOnNode(hbx_FailureRate);
        Part_Registry.turnOnNode(hbx_LeadTime);
        Part_Registry.turnOnNode(hbx_ToolsRequired);
    }

    /**
     * entryTab_ConsumableSelected - Disabling expendable part GUI sections
     */
    private void entryTab_ExpendableDeselected() 
    {
        //Disabling expendable part controls
        Part_Registry.turnOffNode(hbx_FailureRate);
        Part_Registry.turnOffNode(hbx_LeadTime);
        Part_Registry.turnOffNode(hbx_ToolsRequired);
    }
    
    /**
     * entryTab_ExpendableSelected - Disabling expendable part GUI sections
     */
    private void entryTab_ConsumableDeselected() 
    {
        //Disabling consumable part controls
        Part_Registry.turnOffNode(hbx_ReplacementCost);
        Part_Registry.turnOffNode(hbx_UsesLeft);
    }
    
    /**
     * entryTab_TypeToggle - Enables expendable parts' UI elements and disables 
     * consumable parts' UI elements when the expendable parts radio button is 
     * selected and visa versa when the consumable parts radio button is 
     * selected
     */
    private void entryTab_TypeToggle()
    {
        if(rad_NewEntry_Consumable.isSelected())
        {
            entryTab_ConsumableSelected();
            entryTab_ExpendableDeselected();
        }
        else
        {
            entryTab_ExpendableSelected();
            entryTab_ConsumableDeselected();
        }
    }
}