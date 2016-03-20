/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irinasfinancialsearch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author mhcrnl
 */
public class IrinasFinancialSearch extends Application {
    
    BorderPane root;
    VBox vbox;
    TextArea ta;
    TextField tfJFS;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        root = new BorderPane();
        vbox = addVBox();
        root.setLeft(vbox);
        ta = new TextArea();
        root.setCenter(ta);
        
        Scene scene = new Scene(root, 1000, 650);
        
        primaryStage.setTitle("Irina's Financial Search");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private VBox addVBox() {
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        vbox= new VBox();
        vbox.setPadding(new Insets(10,10,3,3));
        vbox.setSpacing(8);
        
        Label text = new Label("Search for: ");
        text.setFont(Font.font("Arriel", FontWeight.BOLD, 14));
        vbox.getChildren().add(text);
        
        tfJFS = new TextField();
        vbox.getChildren().add(tfJFS);
        
        Text in = new Text("In: ");
        in.setFont(Font.font("Arriel", FontWeight.BOLD, 14));
        vbox.getChildren().add(in);
        
        Button btJFS = new Button("Journal of Fin Stab.");
        btJFS.setOnAction(new EventHandler<ActionEvent>(){
            @Override 
            public void handle(ActionEvent event){
               ta.setText(rssreader.readRSS
                    ("http://www.romaniatv.net/rss/actualitate.xml"));
               
            }
        });
        vbox.getChildren().add(btJFS);
        
        return vbox;
    }
    
}
