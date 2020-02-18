package ricksy.business;

import java.util.LinkedHashSet;
import java.util.Set;

public class Receptivo {
    
    private Set<GuestDispatcher> observers = new LinkedHashSet<>();

    public void registra(GuestDispatcher observer) {
        observers.add(observer);
    }

    public void dispatch(CreditCard card) {
        for (GuestDispatcher observer: observers) {
            observer.dispatch(card);
        }
    }
}