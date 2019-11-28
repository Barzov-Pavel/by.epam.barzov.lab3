package domain;

public class MedicineProducer {
    private String name;
    private Certificate certificate;
    private MedicinePackage pack;
    private Dosage dosage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public MedicinePackage getPack() {
        return pack;
    }

    public void setPack(MedicinePackage pack) {
        this.pack = pack;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }
}
