/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irinasfinancialsearch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author mhcrnl
 */
public class JsoupTest03 {
    public static void main(String[] args) {
        System.out.println(JFS("http://www.evz.ro/rss.xml"));
    }
    
    static String JFS(String url){
        String temp;
        String text1= "";
        try {
            Document doc = Jsoup.connect(url).get();
            Element title = doc.getElementById("title");
            Elements elements = doc.getElementsByTag("title");
            for(Element element: elements){
               temp = element.text();
               text1 += temp +"\n\n";
                System.out.println(element.text());
                
            }
            return text1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
