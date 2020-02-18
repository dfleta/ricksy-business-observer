package ricksy.business;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;

public class UfosParkTest {

    UfosPark ufos = null;
    String[] ovnis = { "unx", "dox", "trex" };

    @Before
    public void setupUfosPark() {
        ufos = new UfosPark();
        assertNotNull("Parque de UFOS creados", ufos);
        for (String ovni : ovnis) {
			ufos.add(ovni);
        }
    }

    @Test
    public void addUFOtest() {
        Arrays.sort(ovnis);
        assertEquals(List.of(ovnis).toString(), ufos.toString());
    }

    @Test
    public void dispatchTest() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(card);
        assertTrue(ufos.containsCard(card.number()));
        List<String> cards = ufos.cardNumbers()
                                    .stream()
                                    .filter(n -> n == card.number())
                                    .collect(Collectors.toList());

        assertEquals(1, cards.size(), 0);

    }

    @Test
    public void dispatchNoCreditTest() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        card.pay(3000);
        assertEquals(0, card.credit(), 0);
        ufos.dispatch(card);
        assertFalse(ufos.containsCard(card.number()));
    }

    @Test
    public void dispatchUfoAlreadyReservedTest() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(card);
        ufos.dispatch(card);
        List<String> cards = ufos.cardNumbers()
                                    .stream()
                                    .filter(n -> n == card.number())
                                    .collect(Collectors.toList());

        assertEquals(1, cards.size(), 0);
    }

    @Test
    public void getUfoOfTest() {
        CreditCard card = new CreditCard("Abradolf Lincler", "4916119711304546");
        ufos.dispatch(card);
        assertTrue(ufos.toString().contains(ufos.getUfoOf(card.number())));
    }
}
