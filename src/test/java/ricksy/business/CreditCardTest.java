package ricksy.business;

import org.junit.Test;
import static org.junit.Assert.*;

public class CreditCardTest {
    @Test public void constructortest() {
        
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        assertNotNull("CreditCard creada", card);
        assertEquals("4916119711304546", card.number());
    }
}
