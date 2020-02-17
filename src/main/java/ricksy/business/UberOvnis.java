package ricksy.business;

import java.util.HashMap;
import java.util.Map;

public class UberOvnis {

    private double fee = 500d;

    Map<String, String> flota = new HashMap<String, String>();
    
    public UberOvnis() {};

    public void add(String ovniID) {
        flota.putIfAbsent(ovniID, null);
    }

    public void dispatch(CreditCard card) {
        if (card.pay(fee)) {
            for (Map.Entry<String, String> entry : this.flota.entrySet()) {
                if (entry.getValue() == null) {
                    this.flota.put(entry.getKey(), card.number());
                }
            }
        }
    }

    public String getOvniOf(String cardNumber) {
        String ovniID = null;
        if (this.flota.containsValue(cardNumber)) {
            for (Map.Entry<String, String> entry: this.flota.entrySet()) {
                if (entry.getValue() == cardNumber) {
                    ovniID = entry.getKey();
                    break;
                }
            }
        }
        return ovniID;
    }
}