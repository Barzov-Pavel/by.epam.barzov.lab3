package domain;

public class MedicinePackage {
    private PackageType packageType;
    private int amount;
    private long price;

    public PackageType getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = PackageType.valueOf(packageType);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
