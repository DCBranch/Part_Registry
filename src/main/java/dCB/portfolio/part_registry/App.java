package dCB.portfolio.part_registry;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

/**
 * App - Launches the standalone application Part Registry using the 
 * FXMLLoader to load the Main Window FXML document. Application allows for the 
 * entry, searching, and deletion of Part items, including expendables 
 * and consumables. Based upon James Noyes(professor)' PartTest class.
 * 
 * @author Dawson C. Branch
 * @version 2.0.2
 * @since 1.0.0
 */
public class App extends Application {
    
    /**
     * Start - Entry point for JavaFX applications
     * 
     * @param stage - Main stage scene
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Part Registry");
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();
        
    }
    
    /**
     * main - Launches the standalone application App. Returns upon 
     * app's closure.
     * 
     * @param args - inputted arguments from command line
     */
    public static void main(String [] args)
    {
        launch(args);
    }
    
    /**
     * turnOffGUI - Disables and turns off the visibility of select part of a 
     * GUI, a control
     * 
     * @param gui_Name - Control, piece of GUI, to be turned off
     */
    public static void turnOffNode(Node gui_Name) {
        gui_Name.setDisable(true);
        gui_Name.setVisible(false);
    }
    
    /**
     * turnOffGUI - Enables and turns on the visibility of select part of a GUI, 
     * a control
     * 
     * @param gui_Name - Control, piece of GUI, to be turned on
     */
    public static void turnOnNode(Node gui_Name) {
        gui_Name.setDisable(false);
        gui_Name.setVisible(true);
    }
}

//
//package dCB.portfolio.part_registry;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
///
//  JavaFX App
// 
//public class App extends Application {
//
//    private static Scene scene;
//
//    @Override
//    public void start(Stage stage) throws IOException {
//        scene = new Scene(loadFXML("primary"), 640, 480);
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }
//
//    private static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
//        return fxmlLoader.load();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//
//}
//
