/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import kataFinance.Underlying;

/**
 * @author samirfak
 *
 */
class UnderlyingTest {
	Underlying u1, u2;
	
	@BeforeEach
	void setUp() {
		u1 = new Underlying("U1", 20, "USD");
		u2 = new Underlying("U2", 10, "JPY");
	}

	@Test
	void test() {
		assertEquals(u1.getId(), "U1");
		assertEquals(u2.getId(), "U2");
		assertEquals(u1.getPrice(), 20);
		assertEquals(u2.getPrice(), 10);
		assertEquals(u1.getCurrency(), "USD");
		assertEquals(u2.getCurrency(), "JPY");
		assertEquals(u1.toString(), "U1: 20 USD\n");
		assertEquals(u2.toString(), "U2: 10 JPY\n");
	}

}
