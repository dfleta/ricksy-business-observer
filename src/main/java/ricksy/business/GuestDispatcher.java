package ricksy.business;

import ricksy.business.payment.PaymentMethod;

interface GuestDispatcher {

    void dispatch(PaymentMethod card);

}