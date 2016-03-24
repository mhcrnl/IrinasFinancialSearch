/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irinasfinancialsearch;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author mhcrnl
 */
public class JsoupTest02 {
    
    public static void main(String ... args){
       System.out.println(HowTDIJ("http://howtodoinjava.com"));
    } 
    
    static String HowTDIJ(String url){
        String title = "";
        try {
        Document doc = Jsoup.connect(url).get();
        title = doc.title()+"\nLink: "+ doc.location()+
                "\n"+doc.getElementsByTag("h4");
        } catch (IOException e){
            e.printStackTrace();
        }
        return title;
    }
    
}
