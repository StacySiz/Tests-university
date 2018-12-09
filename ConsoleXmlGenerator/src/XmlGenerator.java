import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

class XmlGenerator {
    private static DocumentBuilderFactory documentFactory;
    private static DocumentBuilder documentBuilder;
    private static Document document;
    private static Element root;
    private String path = "C:\\Users\\Stacy\\Desktop\\Projects\\MyOwn\\TestAuthTask5\\src\\test\\java\\ru\\itis\\settingsFiles\\PostData.xml";

    static {
        try {
            documentFactory = DocumentBuilderFactory.newInstance();

            documentBuilder = documentFactory.newDocumentBuilder();

            document = documentBuilder.newDocument();

            root = document.createElement("Settings");
            document.appendChild(root);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    void createElement(String tagName, String elementBody) {
        Element element = document.createElement(tagName);
        element.appendChild(document.createTextNode(elementBody));
        root.appendChild(element);
    }

    void createXmlDoc() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");

        DOMSource domSource = new DOMSource(document);

        StreamResult streamResult = new StreamResult(new File(path));

        transformer.transform(domSource, streamResult);

    }
}
