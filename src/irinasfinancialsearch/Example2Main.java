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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mertcaliskan
 */
public class Example2Main {
    String evz;

    public static List EVZmain(String evz) throws IOException {
        List<String> list = new ArrayList<String>();
        Document document = Jsoup.connect(evz).timeout(0).get();
        Elements allElements = document.getElementsByTag("title");
        for (Element element : allElements) {
            //if ("New!".equals(element.nextElementSibling() != null ? element.nextElementSibling().ownText() : "")) {
                System.out.println(element.ownText());
            //}
                list.add(element.ownText());
        }
        
        return list;
    }
}