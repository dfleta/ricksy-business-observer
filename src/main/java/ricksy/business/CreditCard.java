package ricksy.business;

public class CreditCard {

    private final String owner;
    private final String number;
    private double credit = 3000d;
    private final String SYMBOL = "EZI";

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    @Override
    public String toString() {
        return "owner: " + this.owner 
                + "\nnumber: " + this.number
                + "\ncredit: " + this.credit + this.SYMBOL;
    }
}