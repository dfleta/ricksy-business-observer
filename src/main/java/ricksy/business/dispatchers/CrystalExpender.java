package ricksy.business.dispatchers;

import ricksy.business.payment.PaymentMethod;
import ricksy.business.receptivo.GuestDispatcher;

public class CrystalExpender implements GuestDispatcher {

    private int stock = 0;
    private double itemCost = 0d;

    public CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    @Override
    public void dispatch(PaymentMethod card) {
        if (this.stock > 0 && card.pay(itemCost)) {
            this.stock -= 1;
        }
    }

    @Override
    public String toString() {
        return "stock: " + this.stock +
                "\ncost: " + this.itemCost;
    }

    public int stock() {
        return this.stock;
    }
}