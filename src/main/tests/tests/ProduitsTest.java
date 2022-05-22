/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kataFinance.Produit;
import kataFinance.Produits;
import kataFinance.Underlying;

/**
 * @author samirfak
 *
 */
class ProduitsTest {
	Produits p;
	Produit p1, p2;
	Underlying u1, u2;
	
	@BeforeEach
	void setUp() {
		p = new Produits();
		
		u1 = new Underlying("U1", 20, "USD");
		u2 = new Underlying("U2", 10, "JPY");
		
		p1 = new Produit("P1", u1);
		p2 = new Produit("P2", u2);
		
		p.add(p1);
		p.add(p2);
	}

	@Test
	void test1() {
		assertTrue(p.getProduits().size() == 2);
		assertEquals(p.getProduits().get(0), p1);
		assertEquals(p.getProduits().get(1), p2);
	}
	
	@Test
	void test2() {
		assertEquals(p.getProduit("P1"), p1);
		assertEquals(p.getProduit("P2"), p2);
		assertEquals(p.getProduit("P3"), null);
	}

	@Test
	void test3() {
		assertTrue(p.contains("P2"));
		assertFalse(p.contains("P4"));
	}
	
	@Test
	void test4() {
		p.addUnderlying("P1", u2);
		assertTrue(p.getProduit("P1").getUnderlyings().getListe().size() == 2);
	}
}
