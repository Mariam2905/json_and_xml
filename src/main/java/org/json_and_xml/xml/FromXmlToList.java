package org.json_and_xml.xml;

import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class FromXmlToList {

    /**
     * This method unmarshalling from .xml file.
     *
     * @param path;
     * @return studentList;
     */
    public static ArrayList<Student> xmlToObjectList(String path) {
        ArrayList<Student> studentList = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document doc = documentBuilder.parse(path);
            NodeList list = doc.getElementsByTagName("student");

            for (int i = 0; i < list.getLength(); i++) {
                Node n = list.item(i);
                Student student = new Student();
                Element e = (Element) n;
                student.setFirstName(e.getElementsByTagName("firstName").item(0).getTextContent());
                student.setLastName(e.getElementsByTagName("lastName").item(0).getTextContent());
                student.setNickName(e.getElementsByTagName("nickName").item(0).getTextContent());
                int marks = Integer.parseInt(e.getElementsByTagName("marks").item(0).getTextContent());
                student.setMarks(marks);
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }
}