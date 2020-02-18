package ricksy.business;

public class PackExpender implements GuestDispatcher {

    private int stock = 0;
    private double itemCost = 0d;

    public PackExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    @Override
    public void dispatch(CreditCard card) {
        if (card.pay(itemCost) & this.stock > 0) {
            this.stock -= 1;
        }
    }

    @Override
    public String toString() {
        return "stock: " + this.stock +
                "\ncost: " + this.itemCost;
    }

    /**
     * Testing
     */

    public int stock() {
        return this.stock;
    }
}