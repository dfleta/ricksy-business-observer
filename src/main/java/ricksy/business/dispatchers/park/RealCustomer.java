package ricksy.business.dispatchers.park;

public class RealCustomer extends AbstractCustomer {

    RealCustomer(String customerID) {
        this.customerID = customerID;
    }

    @Override
    boolean isNull() {
        return false;
    }

    @Override
    String getCustomerID() {
        return this.customerID;
    }
    
}
