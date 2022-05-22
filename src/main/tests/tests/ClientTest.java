/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kataFinance.Client;
import kataFinance.Produit;
import kataFinance.ProduitQte;
import kataFinance.Underlying;
import kataFinance.Underlyings;

/**
 * @author samirfak
 *
 */
class ClientTest {
	private Client c;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() {
		c = new Client();
		Underlying u1 = new Underlying("U1", 10, "EUR");
		Underlying u2 = new Underlying("U2", 20, "JPY");
		Underlyings uS1 = new Underlyings();
		Underlyings uS2 = new Underlyings();
		uS1.add(u1);
		uS1.add(u2);
		Produit p1 = new Produit("P1", uS1);
		Produit p2 = new Produit("P2", uS2);
		ProduitQte pQ1 = new ProduitQte(p1, 3);
		ProduitQte pQ2 = new ProduitQte(p2, 6);
		c.add("C1", pQ1);
		c.add("C2", pQ2);
		c.add("C1", pQ2);
	}

	@Test
	void test() {
		assertTrue(c.contains("C1"));
		assertFalse(c.contains("C3"));
		assertTrue(c.contains("C2"));
		assertEquals(c.getClients().size(), 2);
		assertEquals(c.get("C1").getProduits().size(), 2);
		assertEquals(c.get("C3"), null);
	}
}
