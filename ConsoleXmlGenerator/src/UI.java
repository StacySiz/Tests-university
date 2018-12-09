import javax.xml.transform.TransformerException;
import java.util.Scanner;

public class UI {
    public static void main(String[] args) throws TransformerException {
        XmlGenerator xmlGenerator = new XmlGenerator();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to xml generator!");
        Boolean answerFlag = true;
        do{
        System.out.println("Would you like to create element? y/n");
        String answer = scanner.nextLine();
        if (!answer.equals("y")){
            answerFlag = false;
            xmlGenerator.createXmlDoc();
            System.out.println("Xml file created!");
        }else {
            System.out.println("Write tag name!");
            String tagName = scanner.nextLine();

            System.out.println("Enter a body of tag " + tagName);
            String body = scanner.nextLine();

            xmlGenerator.createElement(tagName,body);
        }
        }while (answerFlag);


    }
}
