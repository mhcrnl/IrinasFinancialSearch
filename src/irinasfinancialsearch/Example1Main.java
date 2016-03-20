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


    public static void main(String... args) {
        Document document = Jsoup.parse(htmlText);
        Elements allElements = document.getAllElements();
        for (Element element : allElements) {
            System.out.println(element.nodeName() + " " + element.ownText());
        }
    }
}