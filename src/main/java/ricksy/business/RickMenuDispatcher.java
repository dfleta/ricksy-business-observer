package ricksy.business;

import java.util.ArrayList;
import java.util.List;

class RickMenuDispatcher implements GuestDispatcher {

    private int stock = 100;
    private double menuCost = 10d;

    private final List<String> orders = new ArrayList<String>();   

    RickMenuDispatcher() {};

    @Override
    public void dispatch(CreditCard card) {
        
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