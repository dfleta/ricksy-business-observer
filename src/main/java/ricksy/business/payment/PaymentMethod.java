package ricksy.business.payment;

public interface PaymentMethod {

    boolean pay(double charge);

    String number();

    String cardOwner();

    double credit();

}