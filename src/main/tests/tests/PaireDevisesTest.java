/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kataFinance.PaireDevises;

/**
 * @author samirfak
 *
 */
class PaireDevisesTest {
	private PaireDevises pD1, pD2, pD3;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		pD1 = new PaireDevises ("EUR", "USD");
		pD2 = new PaireDevises ("CHF", "EUR");
		pD3 = new PaireDevises ("CHF", "EUR");
	}

	@Test
	void test() {
		assertEquals(pD1.getDev2(), "USD");
		assertEquals(pD2.getDev1(), "CHF");
		assertTrue(pD1.index("EUR") == 0);
		assertFalse(pD2.index("EUR") == 0);
		assertTrue(pD1.index("JPY") == -1);
		assertTrue(pD2.equals(pD3));
	}

}
