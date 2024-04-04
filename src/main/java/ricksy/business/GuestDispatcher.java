package ricksy.business;

import ricksy.business.payment.PaymentMethod;

public interface GuestDispatcher {

    void dispatch(PaymentMethod card);

}