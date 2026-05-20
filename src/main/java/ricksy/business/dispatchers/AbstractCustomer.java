package ricksy.business.dispatchers;

abstract class AbstractCustomer {
    
    String customerID;

    abstract boolean isNull();
    
    abstract String getCustomerID();

}
