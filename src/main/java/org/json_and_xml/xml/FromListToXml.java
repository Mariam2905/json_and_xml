package org.json_and_xml.xml;


import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;

public class FromListToXml {


    /**
     * This method unmarshalling from .xml file.
     * @param path
     * @return
     */
    public void xmlFromObjectList(String path) throws JAXBException {
        StudentList studentList=new StudentList();
        ArrayList<Student> studentArrayList=new ArrayList<>(FromXmlToList.xmlToObjectList(path));
        studentList.setStudentList(studentArrayList);
        JAXBContext context = JAXBContext.newInstance(StudentList.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(studentList, new File("StudentList.xml"));

    }
}
