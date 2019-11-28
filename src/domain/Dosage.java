package domain;

public class Dosage {
    private byte amount;
    private byte periodicity;

    public byte getAmount() {
        return amount;
    }

    public void setAmount(byte amount) {
        this.amount = amount;
    }

    public byte getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(byte periodicity) {
        this.periodicity = periodicity;
    }
}
