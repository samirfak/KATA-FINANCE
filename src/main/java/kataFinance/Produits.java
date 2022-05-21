package kataFinance;

import java.util.ArrayList;

/**
 * Classe représentant la liste des produits
 * Elle sera associée aux portefeuilles
 * @author samirfak
 */

public class Produits {
	/* Liste des produits */
	private ArrayList<Produit> produits;
	
	/* Constructeur pour initialiser la liste de produits*/
	public Produits() {
		produits = new ArrayList<Produit>();
	}
	
	/**
	 * Retourne la liste des produits
	 * @return produits
	 */
	public ArrayList<Produit> getProduits() {
		return produits;
	}
	
	/**
	 * Ajoute un produit à la liste
	 * @param p le produit à ajouter
	 */
	public void add(Produit p) {
		 this.produits.add(p);
	}
	
	/**
	 * Ajoute un underlying à un produit
	 * @param idProduit
	 * @param u
	 */
	public void addUnderlying(String idProduit, Underlying u) {
		for (Produit p : produits) {
			if (p.getId().equals(idProduit)) {
				p.add(u);
			}
		}
	}
	
	/**
	 * Retourne une description de la liste des produits
	 */
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("");
		for(Produit p : produits) {
			res.append(p.toString() + "\n");
		}
		return res.toString();
	}
	
	/**
	 * Dis si un produit appartient à la liste
	 * @param id
	 * @return true si le produit ayant pour id id appartient à la liste
	 * 			false sinon
	 */
	public boolean contains(String id) {
		for (Produit p : produits) {
			if (p.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Retourne le produit ayant pour identifiant id 
	 * @param id identifiant du produit
	 * @return produit
	 */
	public Produit getProduit(String id) {
		for (Produit p : produits) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		//le produit n'a pas été trouvé dans la liste
		return null;
	}
}
