package com.company;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            String tittle, price, year, company, country, artist;
            int choice;
            boolean option = true;
            Scanner input = new Scanner(System.in);
            Xml_operations p1 = new Xml_operations();
            File file = new File("C:\\Users\\moazm\\IdeaProjects\\trial\\src\\com\\company\\data.xml");
            //an instance of factory that gives a document builder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //an instance of builder to parse the specified xml file
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            while (option) {
                System.out.println("Choose one of the following options");
                System.out.println("1-display all content");
                System.out.println("2-add new CD");
                System.out.println("3-search using tittle");
                System.out.println("4-search using artist");
                System.out.println("5-Exit");
                choice = input.nextInt();
                if (choice > 5 || choice < 1)
                    continue;

                else {
                    if (choice == 1)
                        p1.display_all_content(doc);
                    else if (choice == 2) {
                        System.out.println("Enter Tittle");
                        tittle = input.next();
                        System.out.println("Enter ARTIST");
                        artist = input.next();
                        System.out.println("Enter COUNTRY");
                        country = input.next();
                        System.out.println("Enter COMPANY");
                        company = input.next();
                        System.out.println("Enter PRICE");
                        price = input.next();
                        System.out.println("Enter YEAR");
                        year = input.next();
                        p1.write(doc, tittle, artist, price, year, country, company, file);
                    }
                    else if(choice==3)
                    {
                        String art;
                        Element search;
                        System.out.println("enter tittle name");
                        art=input.nextLine();
                        art=input.nextLine();
                        search=p1.search_by_tittle(art,doc);
                        if (search!= null)
                        {
                            System.out.println("TITLE: " + search.getElementsByTagName("TITLE"));
                            System.out.println("ARTIST: " + search.getElementsByTagName("ARTIST"));
                            System.out.println("COUNTRY: " + search.getElementsByTagName("COUNTRY"));
                            System.out.println("COMPANY: " + search.getElementsByTagName("COMPANY"));
                            System.out.println("PRICE: " + search.getElementsByTagName("PRICE"));
                            System.out.println("YEAR: " + search.getElementsByTagName("YEAR"));
                        }
                        else
                            System.out.println("Not exist");
                    }
                    else if(choice==4)
                    {
                        String art;
                        Element search;
                        System.out.println("enter artist name");
                        art=input.nextLine();
                        art=input.nextLine();
                        search=p1.search_by_artist(art,doc);
                        if (search!= null)
                        {
                            System.out.println("TITLE: " + search.getElementsByTagName("TITLE"));
                            System.out.println("ARTIST: " + search.getElementsByTagName("ARTIST"));
                            System.out.println("COUNTRY: " + search.getElementsByTagName("COUNTRY"));
                            System.out.println("COMPANY: " + search.getElementsByTagName("COMPANY"));
                            System.out.println("PRICE: " + search.getElementsByTagName("PRICE"));
                            System.out.println("YEAR: " + search.getElementsByTagName("YEAR"));
                        }
                        else
                            System.out.println("Not exist");
                    }
                    else
                        return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
    }
}
