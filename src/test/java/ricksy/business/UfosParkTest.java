package ricksy.business;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;

public class UfosParkTest {

    private UfosPark ufos = null;

    @Before
    public void constructorTest() {
        ufos = new UfosPark();
        assertNotNull("Parque de UFOS creados", ufos);
    }

    @Test
    public void addUFOtest() {

        String[] ovnis = { "unx", "dox", "trex" };
		for (String ovni : ovnis) {
			ufos.add(ovni);
        }
        Arrays.sort(ovnis);
        assertEquals(List.of(ovnis).toString(), ufos.toString());
    }

}
