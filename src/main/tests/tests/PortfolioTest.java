/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kataFinance.Forex;
import kataFinance.PaireDevises;
import kataFinance.Portfolio;
import kataFinance.Produit;
import kataFinance.Underlying;
import kataFinance.ProduitQteTotale;

/**
 * @author samirfak
 *
 */
class PortfolioTest {
	Portfolio ptfs;
	Produit p1, p11, p2, p3;
	Forex frx;
	ProduitQteTotale pQT;
	
	@BeforeEach
	void setUp() {
		ptfs = new Portfolio();
		Underlying u1 = new Underlying("U1", 20, "USD");
		Underlying u2 = new Underlying("U2", 10, "JPY");
		Underlying u3 = new Underlying("U3", 30, "EUR");
		
		p1 = new Produit("P1", u1);
		p11 = new Produit("P1", u2); //p2 a même id que p1 donc u2 sera juste ajouté à l'objet p1
		p2 = new Produit("P2", u3);
		p3 = new Produit("P3", u2);
		
		pQT = new ProduitQteTotale();
		pQT.add("P1", 10);
		pQT.add("P2", 5);
		pQT.add("P3", 20);
		
		ptfs.add("PTF1", p1);		
		ptfs.add("PTF1", p11);
		ptfs.add("PTF2", p2);
		ptfs.add("PTF2", p3);
		
		frx = new Forex();
		PaireDevises pD1 = new PaireDevises ("EUR", "JPY");
		PaireDevises pD2 = new PaireDevises ("USD", "EUR");
		
		frx.add(pD1, 5);
		frx.add(pD2, 0.75);
	}

	@Test
	void test1() {
		assertEquals(ptfs.getProduit("P1"), p1);
		assertEquals(ptfs.getProduit("P4"), null);
		assertTrue(ptfs.getPortfolio().size() == 2);	
	}
	
	@Test
	void test2() {
		assertTrue(ptfs.get("PTF1").getProduits().size() == 1);
		assertTrue(ptfs.get("PTF2").getProduits().size() == 2);
	}
	
	@Test
	void test3() {
		assertEquals(ptfs.prix("PTF1", frx, pQT), 170);
		assertEquals(ptfs.prix("PTF2", frx, pQT), 190);
	}

}
