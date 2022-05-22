package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kataFinance.Forex;
import kataFinance.PaireDevises;

class ForexTest {

	Forex frx;
	@BeforeEach
	void setUp()  {
		frx = new Forex();
		PaireDevises pD1 = new PaireDevises ("EUR", "JPY");
		PaireDevises pD2 = new PaireDevises ("GBP", "EUR");
		frx.add(pD1, 5);
		frx.add(pD2, 0.5);
	}

	@Test
	void test() {
		assertEquals(frx.taux("EUR"), 1);
		assertEquals(frx.taux("JPY"), 0.2);
		assertEquals(frx.taux("GBP"), 0.5);
		assertEquals(frx.taux("CHF"), 0);
	}

}
