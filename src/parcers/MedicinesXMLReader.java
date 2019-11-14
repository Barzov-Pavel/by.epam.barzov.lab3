package parcers;

import domain.*;

import javax.xml.stream.*;
import java.io.*;
import java.util.*;

public class MedicinesXMLReader {
    public List<Medicine> read(String fileName) throws FileNotFoundException {
        XMLStreamReader reader = null;
        List<Medicine> medicines = new ArrayList<>();

        try {
            Medicine medicine = null;
            Certificate certificate = null;
            MedicinePackage pack = null;
            Dosage dosage = null;
            MedicineProducer producer = null;

            XMLInputFactory factory = XMLInputFactory.newFactory();
            reader = factory.createXMLStreamReader(new FileInputStream(fileName));

            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("medicine".equals(tagName)) {
                            medicine = new Medicine();
                            medicine.setName(reader.getAttributeValue(null, "name"));
                        } else if ("group".equals(tagName)) {
                            medicine.setGroup(reader.getElementText());
                        } else if ("analogs".equals(tagName)) {
                            medicine.setAnalogs(reader.getElementText());
                        } else if ("versions".equals(tagName)) {
                            medicine.setVersions(reader.getAttributeValue(null, "version"));
                        } else if ("pharm".equals(tagName)) {
                            producer = new MedicineProducer();
                            producer.setName(reader.getAttributeValue(null, "name"));
                            medicine.setListProducers(producer);
                        } else if ("certificate".equals(tagName)) {
                            certificate = new Certificate();
                            certificate.setId(Integer.parseInt(reader.getAttributeValue(null, "id")));
                        } else if ("startDate".equals(tagName)) {
                            certificate.setStartDate(reader.getElementText());
                        } else if ("expirationDate".equals(tagName)) {
                            certificate.setExpirationDate(reader.getElementText());
                        } else if ("registrationOrganization".equals(tagName)) {
                            certificate.setRegistrationOrganization(reader.getElementText());
                        } else if ("package".equals(tagName)) {
                            pack = new MedicinePackage();
                        } else if ("type".equals(tagName)) {
                            pack.setPackageType(reader.getElementText());
                        } else if ("amount".equals(tagName)) {
                            pack.setAmount(Integer.parseInt(reader.getElementText()));
                        } else if ("price".equals(tagName)) {
                            pack.setPrice(Long.parseLong(reader.getElementText()));
                        } else if ("dosage".equals(tagName)) {
                            dosage = new Dosage();
                        } else if ("number".equals(tagName)) {
                            dosage.setAmount(Byte.parseByte(reader.getElementText()));
                        } else if ("periodicity".equals(tagName)) {
                            dosage.setPeriodicity(Byte.parseByte(reader.getElementText()));
                        }
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        String tagName = reader.getLocalName();
                        if ("certificate".equals(tagName)) {
                            producer.setCertificate(certificate);
                        } else if ("package".equals(tagName)) {
                            producer.setPack(pack);
                        } else if ("dosage".equals(tagName)) {
                            producer.setDosage(dosage);
                        } else if ("pharm".equals(tagName)) {
                            medicine.setProducers(medicine.getListProducers());
                        } else if ("versions".equals(tagName)) {
                            medicine.setListProducers(new ArrayList<>());
                        } else if ("medicine".equals(tagName)) {
                            medicines.add(medicine);
                        }
                        break;
                    }
                }
            }
        } catch (XMLStreamException e) {
            return null;
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return medicines;
    }
}

