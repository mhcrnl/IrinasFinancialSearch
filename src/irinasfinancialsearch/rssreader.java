/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package irinasfinancialsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
/**
 *
 * @author mhcrnl
 */
public class rssreader {
    

/**
 *
 * @author mhcrnl
 */


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        // TODO code application logic here
        System.out.println(readRSS("http://www.romaniatv.net/rss/actualitate.xml"));
    }

    static String readRSS(String urlAddress){
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
        try{
            URL rssUrl = new URL(urlAddress);
            BufferedReader in = new BufferedReader(new 
            InputStreamReader(rssUrl.openStream()));
            String sourceCode = "";
            String line;
            while((line= in.readLine())!= null){
                if(line.contains("<title>")){
                    int firstPos = line.indexOf("<title>");
                    String temp = line.substring(firstPos);
                    temp= temp.replace("<title>", "");
                    int lastPos = temp.indexOf("</title>");
                    temp = temp.substring(0,lastPos);
                    sourceCode += temp+ "\n";
                }
            }
            in.close();
            return sourceCode;
        } catch (MalformedURLException ue) {
            System.out.println("Malformed URL!");
    
        } catch (IOException ioe) {
            System.out.println("Continutul nu a fost citit!");
        }
    return null;
    }
    
}
