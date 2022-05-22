/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kataFinance.Produit;
import kataFinance.ProduitQte;
import kataFinance.ProduitsQtes;
import kataFinance.Underlying;

/**
 * @author samirfak
 *
 */
class ProduitsQtesTest {
	ProduitsQtes pQs ;
	Produit p1, p2;
	ProduitQte pQ1, pQ2;
	
	@BeforeEach
	void setUp() {
		pQs = new ProduitsQtes();
		
		Underlying u1 = new Underlying("U1", 20, "USD");
		Underlying u2 = new Underlying("U2", 10, "JPY");
		
		p1 = new Produit("P1", u1);
		p2 = new Produit("P2", u2);
		
		pQ1 = new ProduitQte(p1, 15);
		pQ2 = new ProduitQte(p2, 5);
		
		pQs.add(pQ1);
		pQs.add(pQ2);
	}

	@Test
	void test() {
		assertTrue(pQs.getProduits().size() == 2);
		assertEquals(pQs.getProduits().get(0), pQ1);
		assertEquals(pQs.getProduits().get(1), pQ2);
	}

}
