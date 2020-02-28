package ricksy.business;

class CrystalExpender implements GuestDispatcher {

    private int stock = 0;
    private double itemCost = 0d;

    CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    @Override
    public void dispatch(CreditCard card) {
        if (this.stock > 0 && card.pay(itemCost)) {
            this.stock -= 1;
        }
    }

    @Override
    public String toString() {
        return "stock: " + this.stock +
                "\ncost: " + this.itemCost;
    }

    int stock() {
        return this.stock;
    }
}