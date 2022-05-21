package kataFinance;

import java.util.ArrayList;

/**
 * Classe représentant la liste de couples (Produit, Quantité)
 * Elle servira à la classe Client
 * @author samirfak
 */
public class ProduitsQtes {
	/* Liste de ProduitQte */
	private ArrayList<ProduitQte> produits;
	
	/**
	 * Constructeur initialisant la liste
	 */
	public ProduitsQtes() {
		produits = new ArrayList<ProduitQte>();
	}
	
	/**
	 * Retourne la liste des ProduitQte
	 * @return
	 */
	public ArrayList<ProduitQte> getProduits() {
		return produits;
	}
	
	/**
	 * Ajoute un ProduitQte à la liste
	 * @param p
	 */
	public void add(ProduitQte p) {
		this.produits.add(p);
	}
	
	/**
	 * Retourne une string décrivant la liste
	 */
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("");
		for(ProduitQte p : produits) {
			res.append(p.getProduit().getId()).append("  ").append("\n").append(p.getProduit().getUnderlyings().toString());
		}
		return res.toString();
	}
}
