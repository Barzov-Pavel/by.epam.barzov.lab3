package domain;

import java.util.*;

public class Medicine {
    private String name;
    private String group;
    private VersionType versionType;
    private List<VersionType> versions = new ArrayList<>();
    private List<String> analogs = new ArrayList<>();
    private Map<String, List<MedicineProducer>> producers = new HashMap<>();
    private List<MedicineProducer> listProducers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getAnalogs() {
        return analogs;
    }

    public void setAnalogs(String analog) {
        this.analogs.add(analog);
    }

    public void setAnalogs(List<String> analogs) {
        this.analogs = analogs;
    }

    public Map<String, List<MedicineProducer>> getProducers() {
        return producers;
    }

    public List<MedicineProducer> getListProducers() {
        return listProducers;
    }

    public void setListProducers(ArrayList<MedicineProducer> producers) {
        this.listProducers = producers;
    }

    public void setListProducers(MedicineProducer producer) {
        this.listProducers.add(producer);
    }

    public void setProducers(Map<String, List<MedicineProducer>> producers) {
        this.producers = producers;
    }

    public void setProducers(List<MedicineProducer> listProducers) {
        this.producers.put(versions.get(versions.size() - 1).getName(), listProducers);
    }

    public List<VersionType> getVersions() {
        return versions;
    }

    public void setVersions(List<VersionType> versions) {
        this.versions = versions;
    }

    public void setVersions(String version) {
        this.versionType = VersionType.valueOf(version);
        this.versions.add(this.versionType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nMedicine name: " + name + "\n");
        sb.append("Medicine group: " + group + "\n");
        sb.append("Analogs: ");
        for (String analog : analogs) {
            sb.append(analog + " ");
        }
        sb.append("\n");
        for (Map.Entry<String, List<MedicineProducer>> entry : this.producers.entrySet()) {
            sb.append("\nVersion: " + entry.getKey());
            for (MedicineProducer producer : entry.getValue()) {
                sb.append("\nProducer: " + producer.getName() + "\nCertificate id: " + producer.getCertificate().getId() +
                        "\nExpiration date of certificate: " + producer.getCertificate().getExpirationDate() +
                        "\nRegistration organization: " + producer.getCertificate().getRegistrationOrganization() +
                        "\nAmount pillows in package: " + producer.getPack().getAmount() +
                        "\nPrice for one package(dollars): " + (producer.getPack().getPrice() / 100) +
                        "\nfrequency of medication " + producer.getDosage().getPeriodicity() + "\n" +
                        producer.getDosage().getAmount() + " times a day\n");
            }
        }
        return sb.toString();
    }
}
