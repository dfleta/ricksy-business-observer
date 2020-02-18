package ricksy.business;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UfosPark implements GuestDispatcher {

    private double fee = 500d;
    private Map<String, String> flota = new HashMap<String, String>();
    
    public UfosPark() {};

    public void add(String ovniID) {
        flota.putIfAbsent(ovniID, null);
    }

    @Override
    public void dispatch(CreditCard card) {
        if (card.pay(fee)) {
            for (Map.Entry<String, String> entry : this.flota.entrySet()) {
                if (entry.getValue() == null) {
                    this.flota.put(entry.getKey(), card.number());
                }
            }
        }
    }

    public String getUfoOf(String cardNumber) {
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

    public boolean containsCard(String cardNumber) {
        return this.flota.containsValue(cardNumber);
    }
}