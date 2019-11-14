package domain;

public enum VersionType {
    TABLET("tablet"),
    CAPSULE("capsule"),
    LIQUID("liquid"),
    POWDERS("powders"),
    GRANULES("granules"),
    GEL("gel"),
    GAS("gas");

    private String name;

    VersionType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
