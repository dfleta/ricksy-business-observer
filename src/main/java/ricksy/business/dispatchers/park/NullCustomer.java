package ricksy.business.dispatchers.park;

public class NullCustomer extends AbstractCustomer {
    
    NullCustomer() {
        this.customerID = "no existe cliente";
    }

    @Override
    boolean isNull() {
        return true;
    }

    @Override
    String getCustomerID() {
        return this.customerID;
    }
}
