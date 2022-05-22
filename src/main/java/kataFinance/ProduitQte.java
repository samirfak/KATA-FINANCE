package kataFinance;


/**
 * Classe représentant un produit et sa quantité
 * @author samirfak
 *
 */
public class ProduitQte {
	
	private Produit produit;
	private int qte;
	
	/**
	 * Constructeur
	 * @param produit 
	 * @param qte quantité du produit
	 */
	public ProduitQte(Produit produit, int qte) {
		this.produit = produit;
		this.qte = qte;
	}
	
	/**
	 * Retourne la quantité du produit
	 * @return
	 */
	public int getQte() {
		return qte;
	}
	
	/**
	 * Modifie la quantité du produit
	 * @param qte nouvelle quantité du produit
	 */
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	/**
	 * Modifie le produit
	 * @param p nouveau produit
	 */
	public void setProduit(Produit p) {
		this.produit = p;
	}
	
	/**
	 * Renvoie le produit
	 * @return
	 */
	public Produit getProduit() {
		return produit;
	}
}
