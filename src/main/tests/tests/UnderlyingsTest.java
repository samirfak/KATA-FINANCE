/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kataFinance.Forex;
import kataFinance.PaireDevises;
import kataFinance.Underlying;
import kataFinance.Underlyings;

/**
 * @author samirfak
 *
 */
class UnderlyingsTest {

	Underlying u1, u2, u3;
	Underlyings uS1, uS2;
	Forex frx;
	
	@BeforeEach
	void setUp() {
		u1 = new Underlying("U1", 20, "USD");
		u2 = new Underlying("U2", 10, "JPY");
		u3 = new Underlying("U3", 15, "EUR");
		
		uS1 = new Underlyings();
		uS2 = new Underlyings();
		
		uS1.add(u1);
		uS1.add(u2);
		
		uS2.add(u2);
		uS2.add(u3);
		
		frx = new Forex();
		PaireDevises pD1 = new PaireDevises ("EUR", "JPY");
		PaireDevises pD2 = new PaireDevises ("USD", "EUR");
		frx.add(pD1, 5);
		frx.add(pD2, 0.5);
	}

	@Test
	void test1() {
		assertEquals(uS1.getFirstUnderlying(), u1);
		assertEquals(uS2.getFirstUnderlying(), u2);
	}

	@Test
	void test2() {
		assertEquals(uS1.getListe().size(), 2);
		uS1.add(u3);
		assertEquals(uS1.getListe().size(), 3);
	}
	
	@Test
	void test3() {
		assertTrue(uS1.prix(frx) == 12);
		assertTrue(uS2.prix(frx) == 17);
		uS2.add(u1);
		assertTrue(uS2.prix(frx) == 27);
	}
}
