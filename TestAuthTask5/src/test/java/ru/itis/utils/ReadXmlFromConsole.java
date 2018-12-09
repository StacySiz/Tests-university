package ru.itis.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXmlFromConsole {
    private static File fXmlFile;
    private static DocumentBuilderFactory dbFactory;
    private static DocumentBuilder dBuilder;
    private static Document doc;
    private static NodeList nList;
    private static Node nNode;

    static {
        try {
            fXmlFile = new File("src/test/java/ru/itis/settingsFiles/PostData.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
    }

    public String getPost() {
        return doc.getDocumentElement().getElementsByTagName("Post").item(0).getTextContent();
    }

}
