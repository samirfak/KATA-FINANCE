/**
 * 
 */
package kataFinance;

import java.util.ArrayList;

/**
 * @author samirfak
 *
 */
public class ProduitsQtes {
	private ArrayList<ProduitQte> produits;
	
	public ProduitsQtes() {
		produits = new ArrayList<ProduitQte>();
	}
	
	public ArrayList<ProduitQte> getProduits() {
		return produits;
	}
	
	public boolean add(ProduitQte p) {
		return this.produits.add(p);
	}
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("");
		for(ProduitQte p : produits) {
			res.append(p.getProduit().getId()).append("  ").append("\n").append(p.getProduit().getUnderlyings().toString());
		}
		return res.toString();
	}
}
