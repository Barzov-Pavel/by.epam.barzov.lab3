package parcers;

import domain.*;

import javax.xml.stream.*;
import java.io.*;
import java.util.*;

public class MedicinesXMLWriter {
    public void write(List<Medicine> medicines, String fileName) throws FileNotFoundException, XMLStreamException {
        XMLStreamWriter writer = null;
        try {
            XMLOutputFactory factory = XMLOutputFactory.newFactory();
            writer = factory.createXMLStreamWriter(new FileOutputStream(fileName), "UTF-8");
            writer.writeStartDocument("UTF-8", "1.0");
            writer.writeStartElement("medicines");
            writer.writeAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
            writer.writeAttribute("xsi:schemaLocation", "./medicines.xsd");

            for (Medicine medicine : medicines) {
                writer.writeStartElement("medicine");
                writer.writeAttribute("name", medicine.getName());
                writer.writeStartElement("group");
                writer.writeCData(medicine.getGroup());
                writer.writeEndElement();

                for (String analog : medicine.getAnalogs()) {
                    writer.writeStartElement("analogs");
                    writer.writeCData(analog);
                    writer.writeEndElement();
                }
                for (Map.Entry<String, List<MedicineProducer>> entry : medicine.getProducers().entrySet()) {
                    writer.writeStartElement("versions");
                    writer.writeAttribute("version", entry.getKey().toUpperCase());
                    for (MedicineProducer producer : entry.getValue()) {
                        writer.writeStartElement("pharm");
                        writer.writeAttribute("name", producer.getName());
                        writer.writeStartElement("certificate");
                        writer.writeAttribute("id", String.valueOf(producer.getCertificate().getId()));
                        writer.writeStartElement("startDate");
                        writer.writeCData(producer.getCertificate().getStartDate());
                        writer.writeEndElement();
                        writer.writeStartElement("expirationDate");
                        writer.writeCData(producer.getCertificate().getExpirationDate());
                        writer.writeEndElement();
                        writer.writeStartElement("registrationOrganization");
                        writer.writeCData(producer.getCertificate().getRegistrationOrganization());
                        writer.writeEndElement();
                        writer.writeEndElement();
                        writer.writeStartElement("package");
                        writer.writeStartElement("type");
                        writer.writeCData(producer.getPack().getPackageType().getName().toUpperCase());
                        writer.writeEndElement();
                        writer.writeStartElement("amount");
                        writer.writeCData(String.valueOf(producer.getPack().getAmount()));
                        writer.writeEndElement();
                        writer.writeStartElement("price");
                        writer.writeCData(String.valueOf(producer.getPack().getPrice()));
                        writer.writeEndElement();
                        writer.writeEndElement();
                        writer.writeStartElement("dosage");
                        writer.writeStartElement("number");
                        writer.writeCData(String.valueOf(producer.getDosage().getAmount()));
                        writer.writeEndElement();
                        writer.writeStartElement("periodicity");
                        writer.writeCData(String.valueOf(producer.getDosage().getPeriodicity()));
                        writer.writeEndElement();
                        writer.writeEndElement();
                        writer.writeEndElement();
                    }
                    writer.writeEndElement();
                }
                writer.writeEndElement();
            }
            writer.writeEndDocument();
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }
}
