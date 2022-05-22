package kataFinance;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe représentant le forex : (paireDevises, taux)
 * @author samirfak
 */
public class Forex {
	/* Map pour stocker les paires de devises ainsi que le taux de conversion de la 1ère à la 2ème */
	HashMap<PaireDevises, Double> forex;
	
	/*
	 * Constructeur pour initialiser la map
	 */
	public Forex () {
		forex = new HashMap<>();
	}
	
	/**
	 * Ajoute une paire de devises et le taux de conversion associé à la map
	 * @param paire la paire de devises
	 * @param taux le taux de conversion de la 1ere devise à la 2ème
	 */
	public void add (PaireDevises paire, double taux) {
		if (!forex.containsKey(paire)) {
			forex.put(paire, taux);
		}
	}
	
	/**
	 * Retourne la map des paires de devises avec le taux de conversion de chaque paire
	 * @return forex
	 */
	public HashMap<PaireDevises, Double> getForex() {
		return forex;
	}
	
	/**
	 * Calcule le taux de conversion d'une devise vers l'euro "EUR"
	 * @param currency la devise
	 * @return un nombre réel représentant le taux de conversion vers l'euro
	 */
	public double taux(String currency) {
		//si la devise est de l'euro
		if (currency.equals("EUR")) {
			return 1;
		}
		//Parcours de la map du forex
		for (Map.Entry<PaireDevises, Double> frx : forex.entrySet()) {			
			PaireDevises p = (PaireDevises) frx.getKey();
			//Si la devise est à la 1ère position de la paire
			if (p.index(currency) == 0 && p.getDev2().equals("EUR")) {
				//retourner le taux de conversion vers la 2eme devise ("euro")
				return (double) frx.getValue();
			//sinon si la devise est à la 2ème position de la paire
			} else if (p.index(currency) == 1 && p.getDev1().equals("EUR")) {
				//retourner le taux de conversion vers la 1ere devise ("euro")
				return  1/(double)frx.getValue();
			}			
		}
		//Si la devise n'est pas dans le forex
		return 0;
	}
}
