package ricksy.business.dispatchers;

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
