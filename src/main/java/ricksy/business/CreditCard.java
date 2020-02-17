package ricksy.business;

public class CreditCard {

    private final String owner;
    private final String number;

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    @Override
    public String toString() {
        return "owner: " + this.owner + "\nnumber: " + this.number; 
    }
}