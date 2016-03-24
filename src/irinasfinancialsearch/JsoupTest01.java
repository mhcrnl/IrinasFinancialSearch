/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irinasfinancialsearch;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author mhcrnl
 */
public class JsoupTest01 {
    
    public static void main (String... args){
        System.out.println(EvzRss("http://www.evz.ro/rss.xml"));
    }
    
    static String EvzRss (String url) {
        String html = "";
        try{
            Response res = Jsoup.connect(url).execute();
            //afiseaza continutul intregului res
            html = res.body();
            Document doc2 = Jsoup.parseBodyFragment(html);
            Element body = doc2.body();
            Elements tables = body.getElementsByTag("item");
            for(Element table : tables){
                if(table.className().contains("title")== true){
                    html=(table.getElementById("description").text());
                    break;
                }
                
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
        return html;
    }
    
}
