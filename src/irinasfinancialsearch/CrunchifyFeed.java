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
public class CrunchifyFeed {
    
    public static void main(String ... args){
        System.out.println(Cruncify("http://feeds.feedburner.com/Crunchify?format=xml"));
    }
    
    static String Cruncify(String url){
        String rss = null;
        try {
            Document doc = Jsoup.connect(url).get();
            String title = doc.getElementsByTag("title").text();
            rss = doc.title()+"\n"
                    + doc.location() +"\n"
                    +title+"\n"
                    +doc.getElementsByTag("link");
            return doc.getElementsByTag("title").text();
            
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    
}
