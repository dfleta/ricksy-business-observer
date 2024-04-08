package ricksy.business.payment;

import org.apache.commons.lang3.BooleanUtils;

public class CreditCard implements PaymentMethod {

    private final String owner;
    private final String number;
    private double credit = 3000d;
    private final String SYMBOL = "EZI";

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    @Override
    public boolean pay(double charge) {
        return charge <= this.credit - 1 ? 
                            BooleanUtils.toBoolean((int) (this.credit -= charge)) 
                            : false;
    }

    @Override
    public String number() {
        return this.number;
    }

    @Override
    public String cardOwner() {
        return this.owner;
    }

    @Override
    public double credit() {
        return this.credit;
    }

    @Override
    public String toString() {
        return "owner: " + this.owner 
                + "\nnumber: " + this.number
                + "\ncredit: " + this.credit + this.SYMBOL;
    }
}