package ricksy.business.dispatchers;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import ricksy.business.payment.PaymentMethod;
import ricksy.business.receptivo.GuestDispatcher;

public class UfosPark implements GuestDispatcher {

    private double fee = 500d;
    private final Map<String, String> flota = new HashMap<String, String>();
    
    public UfosPark() {};

    public void add(String ufoID) {
        flota.putIfAbsent(ufoID, null);
    }

    @Override
    public void dispatch(PaymentMethod card) {

        Optional<Map.Entry<String, String>> ufoEntry = Optional.empty();
        
        if (!flota.containsValue(card.number())) {
            ufoEntry = this.flota.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() == null)
                    .findFirst();
        }
        if (ufoEntry.isPresent() && card.pay(fee)) {
            this.flota.put(ufoEntry.get().getKey(), card.number());
        }
    }                    


    public String getUfoOf(String cardNumber) {

        Optional<Map.Entry<String, String>> ufoEntry = this.flota.entrySet()
                                                            .stream()
                                                            .filter(entry -> entry.getValue() != null 
                                                                    && entry.getValue().equals(cardNumber))
                                                            .findFirst();
        return ufoEntry.isPresent() ? ufoEntry.get().getKey() : null;
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
        return this.flota.containsValue(cardNumber);
    }

    Collection<String> cardNumbers() {
        return this.flota.values();
    }
} 