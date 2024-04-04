package ricksy.business.receptivo;

import java.util.LinkedHashSet;
import java.util.Set;

import ricksy.business.GuestDispatcher;
import ricksy.business.payment.PaymentMethod;

public class Receptivo {

    private static Receptivo instance = null;
    
    private final Set<GuestDispatcher> observers = new LinkedHashSet<>();

    private Receptivo() {};

    public static Receptivo getReceptivo() {
        return instance = instance == null ? new Receptivo() : instance;
    }

    public void registra(GuestDispatcher observer) {
        this.observers.add(observer);
    }

    public void dispatch(PaymentMethod card) {
        for (GuestDispatcher observer: observers) {
            observer.dispatch(card);
        }
    }
}