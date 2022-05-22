/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kataFinance.Produit;
import kataFinance.ProduitQte;
import kataFinance.Underlying;

/**
 * @author samirfak
 *
 */
class ProduitQteTest {
	ProduitQte pQ1, pQ2;
	Produit p1, p2;
	
	@BeforeEach
	void setUp() {		
		Underlying u1 = new Underlying("U1", 20, "USD");
		Underlying u2 = new Underlying("U2", 10, "JPY");
		
		p1 = new Produit("P1", u1);
		p2 = new Produit("P2", u2);
		
		pQ1 = new ProduitQte(p1, 15);
		pQ2 = new ProduitQte(p2, 5);
	}

	@Test
	void test1() {
		assertEquals(pQ1.getProduit(), p1);
		assertEquals(pQ2.getProduit(), p2);
	}
	
	@Test
	void test2() {
		assertTrue(pQ1.getQte() == 15);
		assertTrue(pQ2.getQte() == 5);
	}
	
	@Test
	void test3() {
		pQ2.setQte(20);
		assertFalse(pQ2.getQte() == 5);
		assertTrue(pQ2.getQte() == 20);	
	}
	
	@Test
	void test4() {
		pQ2.setProduit(p1);
		assertNotEquals(pQ2.getProduit(), p2);
		assertEquals(pQ2.getProduit(), p1);	
	}

}
