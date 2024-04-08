package ricksy.business.receptivo;

import java.util.LinkedHashSet;
import java.util.Set;

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((observers == null) ? 0 : observers.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Receptivo other = (Receptivo) obj;
        if (observers == null) {
            if (other.observers != null)
                return false;
        } else if (!observers.equals(other.observers))
            return false;
        return true;
    }
    
}