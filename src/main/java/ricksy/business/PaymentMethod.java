package ricksy.business;

interface PaymentMethod {

    boolean pay(double charge);

    String number();

    String cardOwner();

    double credit();

}