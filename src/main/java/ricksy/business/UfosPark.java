package ricksy.business;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UfosPark implements GuestDispatcher {

    private double fee = 500d;
    private final Map<String, String> flota = new HashMap<String, String>();
    
    UfosPark() {};

    void add(String ufoID) {
        flota.putIfAbsent(ufoID, null);
    }

    @Override
    public void dispatch(CreditCard card) {

        Map.Entry<String, String> ufo = null;

        if (!flota.containsValue(card.number())) {
            for (Map.Entry<String, String> entry : this.flota.entrySet()) {
                if (entry.getValue() == null) {
                    ufo = entry;
                    break;
                }
            }
        }
        if (ufo != null  && card.pay(fee)) {
            this.flota.put(ufo.getKey(), card.number());
        }
    }                    


    String getUfoOf(String cardNumber) {
        String ufoID = null;
        if (this.flota.containsValue(cardNumber)) {
            for (Map.Entry<String, String> entry: this.flota.entrySet()) {
                if (entry.getValue() == cardNumber) {
                    ufoID = entry.getKey();
                    break;
                }
            }
        }
        return ufoID;
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

    boolean containsCard(String cardNumber) {
        return this.flota.containsValue(cardNumber);
    }

    Collection<String> cardNumbers() {
        return this.flota.values();
    }
} 