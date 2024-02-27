package xmlprocessing;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.PrintWriter;

public class XMLDeletion {
    public static void main(String[] args) {
        try {
            File inputFile = new File("res/temp_data.xml");
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = docBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputFile);

            document.getDocumentElement().normalize();
            NodeList nodes = document.getElementsByTagName("student");
            for (int i = 0; i < nodes.getLength(); i++) {
                Node stud = nodes.item(i);
                Node parent = stud.getParentNode();
                parent.removeChild(stud);
                i--;
            }
            document.normalize();

            cleanXMLDocument(document);
            writeDOMToFile(document, "res/temp_updated.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void cleanXMLDocument(Document doc)
            throws XPathExpressionException {
    /* SOURCE on the code to clean the xml document:
        https://stackoverflow.com/questions/978810/how-to-strip-whitespace-only-text-nodes-from-a-dom-before-serialization
    */
        XPathFactory xpathFactory = XPathFactory.newInstance();
        // XPath to find empty text nodes
        XPathExpression xpathExp = xpathFactory
                .newXPath()
                .compile("//text()[normalize-space(.) = '']");
        NodeList emptyTextNodes = (NodeList) xpathExp
                .evaluate(doc, XPathConstants.NODESET);

        // Remove each empty text node from document.
        for (int i = 0; i < emptyTextNodes.getLength(); i++) {
            Node emptyTextNode = emptyTextNodes.item(i);
            emptyTextNode.getParentNode().removeChild(emptyTextNode);
        }
    }

    private static void writeDOMToFile(Node node, String fileName) {
        try {
            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(node);

            PrintWriter fileWriter = new PrintWriter(fileName);
            StreamResult result = new StreamResult(fileWriter);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
