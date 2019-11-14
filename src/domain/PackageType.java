package domain;

public enum PackageType {
    BLISTER("blister"),
    AMPULE("ampule"),
    BOTTLE("bottle"),
    BOX("box"),
    VIAL("vial"),
    TUBE("tube");

    private String name;

    PackageType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
