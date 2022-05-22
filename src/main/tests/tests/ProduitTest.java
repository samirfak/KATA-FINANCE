/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kataFinance.Forex;
import kataFinance.PaireDevises;
import kataFinance.Produit;
import kataFinance.Underlying;
import kataFinance.Underlyings;

/**
 * @author samirfak
 *
 */
class ProduitTest {

	Produit p1, p2, p3, p4;
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
		
		uS2.add(u1);
		uS2.add(u3);
		
		p1 = new Produit("P1", u1);
		p2 = new Produit("P2", u2);
		p3 = new Produit("P3", uS1);
		p4 = new Produit("P4", uS2);
		
		frx = new Forex();
		PaireDevises pD1 = new PaireDevises ("EUR", "JPY");
		PaireDevises pD2 = new PaireDevises ("USD", "EUR");
		frx.add(pD1, 5);
		frx.add(pD2, 0.5);
		
	}

	@Test
	void test1() {
		assertEquals(p1.getId(), "P1");
		assertEquals(p3.getUnderlyings(), uS1);
		p3.setUnderlyings(uS2);
		assertEquals(p3.getUnderlyings(), uS2);
	}
	
	@Test
	void test2() {
		p2.add(u3);
		assertEquals(p2.getUnderlyings().getListe().get(1), u3);
	}
	
	@Test
	void test3() {
		assertEquals(p3.prixProduit(frx), 12);
		assertEquals(p4.prixProduit(frx), 25);
		assertEquals(p1.prixProduit(frx), 10);
		assertEquals(p2.prixProduit(frx), 2);
		p2.add(u1);
		assertEquals(p2.prixProduit(frx), 12);
	}

}
