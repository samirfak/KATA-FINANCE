package kataFinance;

import java.util.ArrayList;

/**
 * Classe représentant la liste des underlyings
 * Elle servira à la classe Produit
 * @author samirfak
 */

public class Underlyings {
	/* Liste des underlyings */
	private ArrayList<Underlying> underlyings = new ArrayList<Underlying>();
	
	/**
	 * Ajoute un underlying à la liste
	 * @param u underlying
	 */
	public void add(Underlying u) {
		this.underlyings.add(u);
	}
	
	/**
	 * Retourne le 1er underlying de la liste
	 * @return
	 */
	public Underlying getFirstUnderlying() {
		return underlyings.get(0);
	}
	
	/**
	 * Retourne le prix total de la liste des underlyings
	 * @param forex map de conversion de devises
	 * @return un nombre réel
	 */
	public double prix(Forex forex) {
		double sum = 0;
		for (Underlying u : underlyings) {
			//sum += prix underlying * forex (devise underlying)
			sum += u.getPrice() * forex.taux(u.getCurrency());
		}
		return sum;
	}
	
	/**
	 * Retourne une description de la liste des underlyings
	 * @return 
	 */
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("");
		
		for(Underlying u : underlyings) {
			res.append(u.toString());
		}
		return res.toString();
	}
}
