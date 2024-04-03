package ricksy.business;

import java.util.LinkedHashSet;
import java.util.Set;

import ricksy.business.payment.PaymentMethod;

class Receptivo {
    
    private final Set<GuestDispatcher> observers = new LinkedHashSet<>();

    void registra(GuestDispatcher observer) {
        observers.add(observer);
    }

    void dispatch(PaymentMethod card) {
        for (GuestDispatcher observer: observers) {
            observer.dispatch(card);
        }
    }
}