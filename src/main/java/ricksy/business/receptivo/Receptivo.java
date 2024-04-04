package ricksy.business.receptivo;

import java.util.LinkedHashSet;
import java.util.Set;

import ricksy.business.GuestDispatcher;
import ricksy.business.payment.PaymentMethod;

public class Receptivo {
    
    private final Set<GuestDispatcher> observers = new LinkedHashSet<>();

    public void registra(GuestDispatcher observer) {
        observers.add(observer);
    }

    public void dispatch(PaymentMethod card) {
        for (GuestDispatcher observer: observers) {
            observer.dispatch(card);
        }
    }
}