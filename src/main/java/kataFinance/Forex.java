/**
 * 
 */
package kataFinance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author samirfak
 *
 */
public class Forex {
	//PaireDevises paire;
	HashMap<PaireDevises, Double> forex;
	public Forex () {
		//this.paire = paire;
		//this.cout = cout;
		forex = new HashMap<>();
	}
	
	public boolean add (PaireDevises paire, double cout) {
		if (forex.containsKey(paire)) {
			return false;
		} else {
			return forex.put(paire, cout) == -1;
		}
	}
	
	public HashMap<PaireDevises, Double> getForex() {
		return forex;
	}
	
	public double taux(String currency) {
		if (currency.equals("EUR")) {
			return 1;
		}
		
		for (Map.Entry<PaireDevises, Double> frx : forex.entrySet()) {			
			PaireDevises p = (PaireDevises) frx.getKey();
			if (p.index(currency) == 0) {
				return (double) frx.getValue();
			} else if (p.index(currency) == 1) {
				return  1/(double)frx.getValue();
			}
			
		}
		return 0;
	}
}
