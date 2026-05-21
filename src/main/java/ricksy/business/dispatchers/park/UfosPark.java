package ricksy.business.dispatchers.park;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ricksy.business.payment.PaymentMethod;
import ricksy.business.receptivo.GuestDispatcher;

public class UfosPark implements GuestDispatcher {

    private double fee = 500d;
    private final Map<String, AbstractCustomer> flota = new HashMap<String, AbstractCustomer>();
    
    public UfosPark() {}

    public void add(String ufoID) {
        flota.putIfAbsent(ufoID, new NullCustomer());
    }

    @Override
    public void dispatch(PaymentMethod card) {

        boolean alreadyParked = flota.values().stream()
                .anyMatch(customer -> !customer.isNull() 
                            && customer.getCustomerID().equals(card.number()));
        
        if (alreadyParked) return;

        this.flota.entrySet().stream()
                .filter(entry -> entry.getValue().isNull())
                .findFirst()
                .filter(entry -> card.pay(fee)) // devuelve Optional u OptionalEmpty
                .ifPresent(entry -> this.flota.put(entry.getKey(), 
                                                    new RealCustomer(card.number())));
    }                    


    public String getUfoOf(String cardNumber) {
        return this.flota.entrySet().stream()
                .filter(entry -> !entry.getValue().isNull()
                        && entry.getValue().getCustomerID().equals(cardNumber))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    @Override
    public String toString() {
        String[] ufosID = this.flota.keySet().toArray(new String[flota.size()]);
        Arrays.sort(ufosID);
        return List.of(ufosID).toString();
    }

    /**
     * Testing
     */

    public boolean containsCard(String cardNumber) {
        return this.flota.values()
                            .stream()
                            .anyMatch(customer -> customer instanceof RealCustomer rc 
                                        && rc.getCustomerID().equals(cardNumber));
    }

    Collection<String> cardNumbers() {
        // pattern in instance of => requiere record
        return this.flota.values()
                .stream()
                .filter(customer -> !customer.isNull())
                .map(AbstractCustomer::getCustomerID)
                .toList(); // requiere Java 16+
    }
} 