package Comparators;

import domain.Medicine;

import java.util.Comparator;

public class MedicineComparator implements Comparator<Medicine> {
    @Override
    public int compare(Medicine o1, Medicine o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
