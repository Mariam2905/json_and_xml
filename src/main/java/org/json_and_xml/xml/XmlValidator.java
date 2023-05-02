package org.json_and_xml.xml;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {


    /**
     * This method validate .xml and .xsd using JAXB lib.
     *
     * @param xml;
     * @param xsd;
     */
    public void xmlValidatorUsingJAXB(String xml, String xsd) {

        try {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsd));
            Validator validator = schema.newValidator();
            Source xmlSource = new StreamSource(new File(xml));
            validator.validate(xmlSource);
            System.out.println("Validation successful.");
        } catch (Exception e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }

    /**
     * This method validate  .xml  and .xsd  using  javax.xml.validation lib.
     *
     * @throws IOException;
     * @throws SAXException;
     * @throws ParserConfigurationException;
     */

    public void xmlValidationJavaX() throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = parser.parse(new File("src/main/resources/students.xml"));
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(new File("src/main/resources/students.xsd"));
        Schema schema = factory.newSchema(schemaFile);
        Validator validator = schema.newValidator();
        try {
            validator.validate(new DOMSource(document));
            System.out.println("Validation succeeded");
        } catch (SAXException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}