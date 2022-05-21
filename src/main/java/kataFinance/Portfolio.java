package kataFinance;

import java.util.*;

/**
 * Classe représentant la Map des portefeuilles
 * @author samirfak
 *
 */

public class Portfolio {
	/* Map stockant l'id des portefeuilles comme clés avec la liste des Produits associés comme valeurs*/
	private HashMap<String, Produits> portfolio;
	
	/**
	 * Contructeur initialisant la Map des portefeuilles
	 */
	public Portfolio() {
		this.portfolio = new HashMap<>();
	}
	
	/**
	 * Retourne la map des portefeuilles
	 * @return portfolio
	 */
	public HashMap<String, Produits> getPortfolio() {
		return portfolio;
	}
	
	/**
	 * Ajoute un portefeuille ainsi qu'un produit associé à la map 
	 * ou si le portefeuille est déjà présent, ajoute un produit à sa liste de produits
	 * ou si le portefeuille et le produit existent déjà, ajoute l'underlying de produit 
	 * à la liste des Underlyings du produit
	 * @param id l'id du portefeuille
	 * @param produit appartenant au portefeuille
	 */
	public void add (String id, Produit produit) {
		//Si le portefeuille existe déjà
		if (portfolio.containsKey(id)) {
			//Si le portefeuille ne contient pas le produit
			if(!portfolio.get(id).contains(produit.getId())) {
				//ajouter le produit au portefeuille
				portfolio.get(id).add(produit);
			} else { //sinon (si le portefeuille contient déjà le produit)
				//Ajouter l'underlying de produit à la liste des Underlyings du Produit
				portfolio.get(id).addUnderlying(produit.getId(), produit.getUnderlyings().getFirstUnderlying());
			}
		//Sinon si le portefeuille n'existe pas dans la map
		} else {
			//Instancier la liste des produits
			Produits produits = new Produits();
			if (produit != null) {
				//ajouter le produit à la liste
				produits.add(produit);
			}
			//Ajouter le portefeuille et sa liste de produits à la map
			portfolio.put(id, produits);
		}
	}
	
	/**
	 * Parcoure les valeurs de la map et retourne le produit associé à idProduit
	 * @param idProduit
	 * @return Produit
	 */
	public Produit getProduit(String idProduit) {
		for (Map.Entry<String, Produits> ptf : portfolio.entrySet()) {
			//si le portefeuille courant contient le produit dans sa liste de produits
			if (ptf.getValue().contains(idProduit)) {
				//retourne le produit ayant pour id idProduit
				return ptf.getValue().getProduit(idProduit);
			}
		}
		//return null si le produit n'a pas été trouvé dans la map
		return null;
	}
	
	/**
	 * Retourne une String décrivant la liste des portefeuilles avec leurs produits ainsi que les underlyings associés
	 * @return
	 */
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("");
		for (Map.Entry<String, Produits> ptf : portfolio.entrySet()) {
			res.append(ptf.getKey()).append(": \n").append(ptf.getValue().toString());
		}	
		return res.toString();					
	}
	
	/**
	 * Retourne le prix d'un portefeuille
	 * @param ptf l'id du portefeuille
	 * @param forex la map des <paire de devises, taux> 
	 * @param pQT la map des produits avec la quantité totale associée 
	 * @return un nombre réel représentant le prix de ptf
	 */
	public double prix(String ptf, Forex forex, ProduitQteTotale pQT) {
		double sum = 0;
		//récupération de la liste de produits du portefeuille
		Produits pd = portfolio.get(ptf);
		//pour chaque produit de la liste
		for (Produit p : pd.getProduits()) {
			//sum += prix du produit * quantité du produit
			sum += p.prixProduit(forex) * pQT.get(p.getId());
		}
		return sum;
	}

}
