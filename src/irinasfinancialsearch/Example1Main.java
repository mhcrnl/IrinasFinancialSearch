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
import org.jsoup.select.Elements;
import java.io.IOException;

/**
 * Created by mertcaliskan
 */
public class Example1Main {

    static String htmlText = "<!DOCTYPE html>" +
            "    <html>" +
            "    <head>" +
            "        <title>Java Magazine</title>" +
            "    </head>" +
            "    <body>" +
            "        <h1>Hello World!</h1>" +
            "    </body>" +
            "</html>";


    public static void main(String... args) throws IOException {
        Document document = Jsoup.connect
        ("http://www.evz.ro/tag/RSS")
                .timeout(0).get();
        Elements allElements = document.select("a [href* =#]");
        for (Element element : allElements) {
            System.out.println(element.ownText());
        }
    }
}