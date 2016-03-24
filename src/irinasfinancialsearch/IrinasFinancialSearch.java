/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irinasfinancialsearch;

import static irinasfinancialsearch.JsoupTest02.HowTDIJ;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
        
        Button how = new Button("JournalOfF.S.");
        how.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                ta.setText(JsoupTest03.JFS("http://rss.sciencedirect.com/publication/science/15723089"));
                //throw new UnsupportedOperationException("Not supported yet.");
                //To change body of generated methods, choose Tools | Templates.
//                try {
//                    Document document = Jsoup.connect("http://howtodoinjava.com").get();
//                    Elements links = document.select("a[href]");
//                    ta.appendText(document.title());
//                    Element sa = document.getElementById("title");
//                    
//                    for (Element link : links){
//                        System.out.println("link : "+link.attr("href"));
//                        System.out.println("text : "+link.text());
//                        String asd = link.text();
//                        
//                        //while(link.text() != null){
//                           
//                        
//                        
//                       //}
//                    }
//                    
//                    
//                    ta.setText(document.title());
//                    System.out.println(document.title());
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
            }
        
        });
        vbox.getChildren().add(how);
        
        Button scienceD = new Button("ScienceDaily");
        scienceD.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                ta.setText(ScienceDaily.
                        scienceDaily("https://rss.sciencedaily.com/all.xml"));
            }
            
            
        });
        vbox.getChildren().add(scienceD);
        
        Button evzRead = new Button("Evenimentul");
        evzRead.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //throw new UnsupportedOperationException("Not supported yet.");
                ta.setText(JsoupTest03.JFS("http://www.evz.ro/rss.xml"));
                //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        vbox.getChildren().add(evzRead);
        
        Button btLibertatea = new Button("Libertatea");
        btLibertatea.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Document doc = null;
                try {
                    doc = Jsoup.connect("http://www.evz.ro/rss.xml")
                            .get();
                    ta.setText(doc.title());
                    String s = doc.text();
                    ta.setText(s);
                    Elements allElements = doc.select("title");
                    for(Element element: allElements){
                    //if(element.tagName().equals("title")){
                        
                        List rssCit = element.textNodes();
                        
                        ta.setText(rssCit.toString());
                    //}
                        System.out.println(element.text());
                    
                }
                } catch (IOException ex) {
                    Logger.getLogger(IrinasFinancialSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
               
//                Iterator<Element> it = allElements.iterator();
//                while(it.hasNext()){
//                    Element element = it.next();
//                    ta.setText(element.ownText());
//                }
                
                
            }
          
        });
        vbox.getChildren().add(btLibertatea);
        
        Button btJFS = new Button("RomaniaTV");
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
