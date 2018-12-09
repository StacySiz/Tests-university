package ru.itis.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadXmlFile {
    private static File fXmlFile;
    private static DocumentBuilderFactory dbFactory;
    private static DocumentBuilder dBuilder;
    private static Document doc;
    private static NodeList nList;
    private static Node nNode;

    static {
        try {
            fXmlFile = new File("src/test/java/ru/itis/settingsFiles/AccountData.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
        doc.getDocumentElement().normalize();
    }

    public String getLoginUrl() {
        return doc.getDocumentElement().getElementsByTagName("LoginUrl").item(0).getTextContent();
    }

    public String getLogoutUrl() {
        return doc.getDocumentElement().getElementsByTagName("LogoutUrl").item(0).getTextContent();
    }
    public String getProfileUrl() {
        return doc.getDocumentElement().getElementsByTagName("ProfileUrl").item(0).getTextContent();
    }

    public String getUserEmail() {
        return doc.getDocumentElement().getElementsByTagName("Email").item(0).getTextContent();
    }
    public String getUserPassword() {
        return doc.getDocumentElement().getElementsByTagName("Password").item(0).getTextContent();
    }
}