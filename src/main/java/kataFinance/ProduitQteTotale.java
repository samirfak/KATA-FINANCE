/**
 * 
 */
package kataFinance;

import java.util.HashMap;

/**
 * Classe représentant une map <idProduit, quantité Totale produit>
 * Elle servira pour le calcul du prix d'un portefeuille
 * @author samirfak
 */

public class ProduitQteTotale {
	/* Map stockant les idProduit avec la quantité toale associée */
	private HashMap<String, Integer> pQT;
	
	/**
	 * Constructeur pour l'instanciation de la map
	 */
	public ProduitQteTotale() {
		pQT = new HashMap<>();
	}
	
	/**
	 * Ajoute une quantité à un produit 
	 * @param id identifiant du produit
	 * @param qte quantité du produit
	 */
	public void add (String id, int qte) {
		assert (qte > 0);
		//Si le produit existe déjà dans la map
		if (pQT.containsKey(id)) {
			//récupérer sa qauantité courante
			int q = pQT.get(id);
			//ajouter qte à la quantité courante du produit et remplacer la valeur dans la map 
			pQT.replace(id, q+qte);
		//sinon si le produit n'existe pas dans la map
		} else {
			//ajouter le produit et la qte associée à la map
			pQT.put(id, qte);
		}
	}
	
	/**
	 * Retourne la quantité totale associée à un idProduit
	 * @param id
	 * @return
	 */
	public int get(String id) {
		return pQT.get(id);
	}
	
	/**
	 * Retourne la map
	 * @return
	 */
	public HashMap<String, Integer> getPQT() {
		return pQT;
	}
}
