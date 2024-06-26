package ricksy.business.dispatchers;

import java.util.ArrayList;
import java.util.List;

import ricksy.business.payment.PaymentMethod;
import ricksy.business.receptivo.GuestDispatcher;

public class RickMenuDispatcher implements GuestDispatcher {

    private int stock = 100;
    private double menuCost = 10d;

    private final List<String> orders = new ArrayList<String>();   

    public RickMenuDispatcher() {};

    @Override
    public void dispatch(PaymentMethod card) {
        
        if (this.stock > 0 && card.pay(menuCost)) {
            this.stock -= 1;
            this.orders.add(card.cardOwner());
        }
    }

    @Override
    public String toString() {
        return "stock: " + this.stock +
                "\n" + this.orders.toString();
    }
}