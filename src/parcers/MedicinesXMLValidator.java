package parcers;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import java.io.*;

public class MedicinesXMLValidator {
    public boolean valid(String xsdSchema, String xmlFile) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(
                    XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File(xsdSchema));
            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(new File(xmlFile)));
        } catch (SAXException e) {
            System.out.println("File " + xmlFile + " is not valid!\n" + e.getMessage());
            return false;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
