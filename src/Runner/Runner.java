package Runner;

import Comparators.MedicineComparator;
import domain.Medicine;
import parcers.*;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.util.*;

public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        MedicinesXMLValidator medicinesXMLValidator = new MedicinesXMLValidator();
        MedicinesXMLReader medicinesXMLReader = new MedicinesXMLReader();
        MedicinesXMLWriter medicinesXMLWriter = new MedicinesXMLWriter();

        if (medicinesXMLValidator.valid("src\\xml\\medicines.xsd", "src\\xml\\medicines.xml")) {
            List<Medicine> medicines = medicinesXMLReader.read("src\\xml\\medicines.xml");
            System.out.println(medicines);
            Collections.sort(medicines, new MedicineComparator());
            System.out.println(medicines);

            try {
                medicinesXMLWriter.write(medicines, "src\\xml\\medicinesWriter.xml");
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("XML document not valid");
        }
    }
}
