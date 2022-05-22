/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kataFinance.ProduitQteTotale;

/**
 * @author samirfak
 *
 */
class ProduitQteTotaleTest {
	ProduitQteTotale pQT;
	
	@BeforeEach
	void setUp() {
		pQT = new ProduitQteTotale();
		pQT.add("P1", 20);
		pQT.add("P2", 30);
		
	}

	@Test
	void test1() {
		assertEquals(pQT.get("P1"), 20);
		assertEquals(pQT.getPQT().size(), 2);
	}
	
	@Test
	void test2() {
		pQT.add("P1", 6);
		
		assertNotEquals(pQT.get("P1"), 20);
		assertEquals(pQT.get("P1"), 26);
		assertEquals(pQT.getPQT().size(), 2);
	}

}
