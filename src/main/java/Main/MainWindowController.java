
package Main;

import Main.Part_Registry;

import Parts.Part;
import Parts.ConsumablePart;
import Parts.ExpendablePart;

import DeleteConfirmation.DeleteConfirmationWindowController;
import EditPart.EditPartWindowController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.StageStyle;


/**
 * FXML Controller class for main window. Allows users to write out and append 
 * new part listings, delete listings, cancel out the whole program, and search 
 * through listing by type, name, number, ncage, and niin id. Deletion opens up 
 * a delete confirmation window.
 *
 * @author Dawson C. Branch
 * @version 2.0.3
 * @since 1.2.0
 */
public class MainWindowController implements Initializable/*, WindowListener, ActionListener*/ {

    File listing = new File("PartListing.txt");
    
    @FXML
    private DeleteConfirmationWindowController deleteController;
    
    @FXML
    private EditPartWindowController editController;
    
    @FXML
    private Tab tab_View;

    @FXML
    private Pane pne_View;

    @FXML
    private Label lbl_View_Name;

    @FXML
    private TextField txt_View_Name;

    @FXML
    private Label lbl_View_Number;

    @FXML
    private TextField txt_View_Number;

    @FXML
    private Label lbl_View_Ncage;

    @FXML
    private TextField txt_View_Ncage;

    @FXML
    private Label lbl_View_Id;

    @FXML
    private TextField txt_View_Id;

    @FXML
    private Button btn_View_Search;

    @FXML
    private Button btn_View_Enter;

    @FXML
    private Button btn_View_Delete;

    @FXML
    private Button btn_View_Cancel;

    @FXML
    private ComboBox<String> cmb_View_PartType;

    @FXML
    private ListView<String> ltv_View_Results;

    @FXML
    private Tab tab_NewEntry;

    @FXML
    private Pane pne_NewEntry;

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
    private Button btn_NewEntry_Enter;

    @FXML
    private Button btn_NewEntry_Cancel;

    @FXML
    private RadioButton rad_NewEntry_Expendable;

    @FXML
    private RadioButton rad_NewEntry_Consumable;

    @FXML
    private Label lbl_NewEntry_InvText;

    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb)
    {
        //=====View Tab Initialization=====//
        //Part Type Combobox Setup
        ObservableList<String> cmbTypeList = cmb_View_PartType.getItems();
        cmbTypeList.add("All");
        cmbTypeList.add("Expendable");
        cmbTypeList.add("Consumable");
        
        Part_Registry.turnOffNode(btn_View_Enter); //Disabled until editPart method and part edit window are fully implemented
        //NOTE: Edit and delete buttons should be made to disable if no item is selected on the list
        
        
        
        //=====Entry Tab Initialization=====//
        //Part Type Radio Button Group Setup
        ToggleGroup partTypeGroup = new ToggleGroup();
        rad_NewEntry_Consumable.setToggleGroup(partTypeGroup);
        rad_NewEntry_Expendable.setToggleGroup(partTypeGroup);
        entryTab_ConsumableDeselected();
        entryTab_ExpendableDeselected();
        partTypeGroup.selectedToggleProperty().addListener((observable, t, t1) -> entryTab_TypeToggle());
        
        System.out.println("Initialization complete.");
    }    
    
    /**
     * confirmDelete - Opens a new window to confirm deletion of the selected 
     * listview item. If yes is clicked on the confirmation window, then the 
     * window closes and the item is deleted. If no is clicked, then the new 
     * window is closed and nothing more.
     * 
     * @param event - View tab's delete button is clicked
     * @throws Exception - File does not exist
     */
    @FXML
    void confirmDelete(ActionEvent event) throws Exception {
        String selectedLine = ltv_View_Results.getSelectionModel().getSelectedItem();
        if(selectedLine == null)
            return;
        Stage delStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../DeleteConfirmation/DeleteConfirmationWindow.fxml"));
        Parent root = loader.load();
        deleteController = loader.getController();
        
        Scene scene = new Scene(root);
            
        delStage.initModality(Modality.APPLICATION_MODAL);
        
        delStage.setTitle("Delete Part");
        delStage.setScene(scene);
        delStage.resizableProperty().setValue(Boolean.FALSE);
        delStage.show();
        
        
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>(){
            /**
             * handle - Removes the selected line from the part listing
             * 
             * @param confirm - Delete confirmation window's "Yes" button is 
             * clicked
             * @throws IOException - Cannot find the file
             */
            @Override
            public void handle(MouseEvent confirm)
            {
                System.out.println("deletion handler test");
                try(Stream<String> partStream = Files.lines(Paths.get(listing.getPath())))
                {
                    File tempFile = new File("TEMP.txt");
                    tempFile.delete();
                    Path tempPath = Paths.get(tempFile.getName());
                    
                    BufferedWriter listWriter = new BufferedWriter( new FileWriter(tempFile.getName(), true));

                    List<String> list = (List<String>) partStream
                            .filter(line -> !(line.contentEquals( selectedLine )))
                            .filter(line -> !(line.isBlank()))
                            .collect(Collectors.toList());
                    
                    for(String line : list) { listWriter.append("\n" + line.trim()); }
                    
                    listWriter.close();
                    
                    listing.delete();
                    Files.move(tempPath, tempPath.resolveSibling("PartListing.txt"));
                    
                    exit(new ActionEvent(confirm.getSource(), confirm.getTarget()));
                }
                catch(IOException e)
                {
                    System.err.println("Invalid File. " + e.getMessage());
                }
            }
        };
        deleteController.btn_Yes.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        searchListing(event);
    }
        
    /**
     * editPart - Opens a new window with text field filled in with the selected
     * listview item's data and allowing the user to edit each. Upon hitting the
     * edit window's enter button, the data is changed, and the window is 
     * closed. 
     * 
     * @param event - View tab's edit button is clicked
     * @throws IOException - file can't be found
     */
    @FXML
    void editPart(ActionEvent event) throws IOException {
        String selectedLine = ltv_View_Results.getSelectionModel().getSelectedItem();
        String currElement;
        int startIndex = 0;
        int endIndex = 0;
        ArrayList<String> splitLine = new ArrayList<String>();
        Stage editStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../EditPartWindow/EditPartWindow.fxml"));
        Parent root = loader.load();
        editController = loader.getController();
        
        Scene scene = new Scene(root);
            
        editStage.initModality(Modality.APPLICATION_MODAL);
        editStage.setTitle("Edit Part");
        editStage.setScene(scene);
        editStage.resizableProperty().setValue(Boolean.FALSE);
        editStage.show();
        
        endIndex = selectedLine.indexOf("| P/N: ");
        editController.setName(selectedLine.substring(startIndex, endIndex));
        startIndex = endIndex + "| P/N: ".length() - 1;
        endIndex = selectedLine.indexOf("| CAGE: ");
        editController.setNumber(selectedLine.substring(startIndex, endIndex));
            
        
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>(){
            /**
             * handle - Removes the selected line from the part listing, uses  
             * any old input and new user inputs and edits to create a new part 
             * listing, appends the new listing to the part list file, and 
             * closes the edit window.
             * 
             * @param enterEdit - Edit Part Window's "Enter" button is clicked
             * @throws IOException - Cannot find the file
             */
            @Override
            public void handle(MouseEvent enterEdit)
            {
                System.out.println("edit handler test");
                try(Stream<String> partStream = Files.lines(Paths.get(listing.getPath())))
                {
                    Part editedEntry;
                    File tempFile = new File("TEMP.txt");
                    tempFile.delete();
                    Path tempPath = Paths.get(tempFile.getName());
                    BufferedWriter listWriter = new BufferedWriter( new FileWriter(tempFile.getName(), true));
                    
                    
                    
                    editedEntry = editController.getPart();
                    
                    
                    
                    
                    
                    
                    List<String> list = (List<String>) partStream
                            //.filter(line -> !(line.contentEquals( selectedLine )))
                            .collect(Collectors.toList());
                    for(int i = 0; i < list.size(); i++)
                    {
                        if(list.get(i).equalsIgnoreCase(selectedLine))
                            list.add(i, editedEntry.toString());
                    }
                    
                    
                    for(String line : list) { listWriter.append("\n" + line.trim()); }
                    
                    listWriter.close();
                    
                    listing.delete();
                    Files.move(tempPath, tempPath.resolveSibling("PartListing.txt"));
                    
                    exit(new ActionEvent(enterEdit.getSource(), enterEdit.getTarget()));
                }
                catch(IOException e)
                {
                    System.err.println("Invalid File. " + e.getMessage());
                }
            }
        };
        editController.btn_Enter.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
        searchListing(event);
    }
    
    /**
     * searchListing - Filters through the saved list of parts and displays them
     * in the list view for on the View tab of the application. Filtering 
     * functionality seperated out into another method, query, to make the 
     * filtering process modular and only have the list itself be specific.
     * 
     * @param event - Enter button of View tab is clicked
     */
    @FXML
    void searchListing(ActionEvent event)
    {
        ltv_View_Results.getItems().clear();
        try(Stream<String> partStream = Files.lines(Paths.get(listing.getPath())))
        {
            System.out.println("Search start");
            List<String> searchTerms = new ArrayList();
            searchTerms.add(txt_View_Name.getText());
            searchTerms.add(txt_View_Number.getText());
            searchTerms.add(txt_View_Ncage.getText());
            searchTerms.add(txt_View_Id.getText());
            
            List<String> partObsList = query(partStream, searchTerms);
            
            if(cmb_View_PartType.getValue() == "Expendable")
            {
                partObsList = (List<String>) partObsList.stream()
                        .filter(s -> s.matches(".+#EXPENDABLE$"))
                        //.map(c -> c.substring(0, c.lastIndexOf("#") - 1))
                        .collect(Collectors.toList());
            }
            if(cmb_View_PartType.getValue() == "Consumable")
            {
                partObsList = (List<String>) partObsList.stream()
                        .filter(s -> s.matches(".+#CONSUMABLE$"))
                        //.map(c -> c.substring(0, c.lastIndexOf("#") - 1))
                        .collect(Collectors.toList());
            }
            
            ltv_View_Results.getItems().addAll(partObsList);
            System.out.println("Search end");
        } catch (IOException e)
        {
            System.err.println("Invalid File.");
        }
    }
    
    /**
     * query - Loops through each search term provided, uses each to filter 
     * the raw stream of date, and returns a filtered observable list
     * 
     * @param dataStream - The stream of objects to be filtered through
     * @param searchTerms - The list of terms being searched for in the raw list
     * @return results - A filtered version of the raw list
     */
    List<String> query (Stream dataStream, List<String> searchTerms)
    {
        List<String> results = (List<String>) dataStream
                .filter(s -> s.toString().contains("|"))
                .sorted()
                .collect(Collectors.toList());
        
        /*Converts the results list to a stream, filters for the iteration's 
        focal search term, casts the stream back into a list, and iterates with 
        the next search term and the filtered list*/
        for(String term : searchTerms)
        {
            results = (List<String>) results.stream()
                    .filter(s -> s.toLowerCase().contains(term.toLowerCase())||term==null)
                    .collect(Collectors.toList());
        }
        return results;
    }
    
    
    
    
    /**
     * enterPart - If the data input fits their respective formats, then the 
     * data is used to make another part entry into the part listing file.
     * 
     * @param event - Enter button on Entry tab is clicked
     * @throws IOException 
     */
    @FXML
    void enterPart(ActionEvent event) throws IOException
    {
        BufferedWriter listingWriter = new BufferedWriter( new FileWriter("PartListing.txt", true));
        boolean flagged = false;
        
        /*Checks for correct formatting or empty strings in text boxes. If 
        flagged, the method returns after all checks*/
        if((!(Parts.Part.intCheck(txt_NewEntry_Number.getText()))) 
                && (!"".equals(txt_NewEntry_Number.getText())))
        {
            lbl_NewEntry_InvNum.setText("Invalid. Must be a whole number.");
            Part_Registry.turnOnNode(lbl_NewEntry_InvNum);
            flagged = true;
        } else
            Part_Registry.turnOffNode(lbl_NewEntry_InvNum);
        if((!(Parts.Part.ncageCheck(txt_NewEntry_Ncage.getText())))
            && (!"".equals(txt_NewEntry_Ncage.getText())))
        {
            lbl_NewEntry_InvNcage.setText("Invalid. Must be 5 letters or numbers.");
            Part_Registry.turnOnNode(lbl_NewEntry_InvNcage);
            flagged = true;
        } else
            Part_Registry.turnOffNode(lbl_NewEntry_InvNcage);
        if((!Parts.Part.niinCheck(txt_NewEntry_Id.getText()))
            && (!"".equals(txt_NewEntry_Id.getText())))
        {
            lbl_NewEntry_InvNiin.setText("Invalid. Must be ####-##-###-####.");
            Part_Registry.turnOnNode(lbl_NewEntry_InvNiin);
            flagged = true;
        } else
            Part_Registry.turnOffNode(lbl_NewEntry_InvNiin);
        
        if(rad_NewEntry_Consumable.isSelected())
        {
            if((!(Parts.Part.doubleCheck(txt_NewEntry_ReplacementCost.getText()))) 
                && (!"".equals(txt_NewEntry_ReplacementCost.getText())))
            {
                lbl_NewEntry_InvCost.setText("Invalid. Must be numeric.");
                Part_Registry.turnOnNode(lbl_NewEntry_InvCost);
                flagged = true;
            } else
                Part_Registry.turnOffNode(lbl_NewEntry_InvCost);
            if((!(Parts.Part.intCheck(txt_NewEntry_UsesLeft.getText()))) 
                && (!"".equals(txt_NewEntry_UsesLeft.getText())))
            {
                lbl_NewEntry_InvUses.setText("Invalid. Must be a whole number.");
                Part_Registry.turnOnNode(lbl_NewEntry_InvUses);
                flagged = true;
            } else
                Part_Registry.turnOffNode(lbl_NewEntry_InvUses);
        }
        if(rad_NewEntry_Expendable.isSelected())
        {
            //Fail Rate check
            if((!(Parts.Part.intCheck(txt_NewEntry_FailureRate.getText()))) 
                && (!"".equals(txt_NewEntry_FailureRate.getText())))
            {
                lbl_NewEntry_InvRate.setText("Invalid. Must be a whole number.");
                Part_Registry.turnOnNode(lbl_NewEntry_InvRate);
                flagged = true;
            } else
                Part_Registry.turnOffNode(lbl_NewEntry_InvRate);
            //Lead time check
            if((!(Parts.Part.intCheck(txt_NewEntry_LeadTime.getText()))) 
                && (!"".equals(txt_NewEntry_LeadTime.getText())))
            {
                lbl_NewEntry_InvLead.setText("Invalid. Must be a whole number.");
                Part_Registry.turnOnNode(lbl_NewEntry_InvLead);
                flagged = true;
            } else
                Part_Registry.turnOffNode(lbl_NewEntry_InvLead);
            //Tools check
            /*if((     )) 
                && (!"".equals(txt_NewEntry_ToolsRequired.getText())))
            {
                lbl_NewEntry_InvTools.setText("Invalid. Must be a whole number.");
                Part_Registry.turnOnNode(lbl_NewEntry_InvTools);
                flagged = true;
            } else
                Part_Registry.turnOffNode(lbl_NewEntry_InvTools);*/
        }
        
        if(flagged)
            return;
        
        
        //Writing to file
        listingWriter.append("\n" + txt_NewEntry_Name.getText() +
                "| P/N: " + txt_NewEntry_Number.getText() +
                "| CAGE: " + txt_NewEntry_Ncage.getText().toUpperCase() +
                "| NIIN: " + txt_NewEntry_Id.getText());
        if(rad_NewEntry_Consumable.isSelected())
        {
            listingWriter.append("| COST: " + txt_NewEntry_ReplacementCost.getText() +
                "| USES LEFT: " + txt_NewEntry_UsesLeft.getText()
                + " #CONSUMABLE");
        }
        if(rad_NewEntry_Expendable.isSelected())
        {
            listingWriter.append("| FAIL RATE: " + txt_NewEntry_FailureRate.getText() +
                "| LEAD TIME: " + txt_NewEntry_LeadTime.getText() +
                "| TOOL LIST: " + txt_NewEntry_ToolsRequired.getText()
                + " #EXPENDABLE");
        }
        
        listingWriter.flush();
        listingWriter.close();
        System.out.println("Entry complete.");
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
    
    
    /**
     * exit - Closes the stage of the event's source
     * 
     * @param event - ActionEvent that is asking for its window to be closed
     */
    @FXML
    public void exit(ActionEvent event) {
        Node scene = (Node)event.getSource();
        Stage stage = (Stage)scene.getScene().getWindow();
        stage.close();
    }
}