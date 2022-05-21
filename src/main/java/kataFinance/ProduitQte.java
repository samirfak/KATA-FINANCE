/**
 * 
 */
package kataFinance;

//import java.util.HashMap;

/**
 * @author samirfak
 *
 */
public class ProduitQte {
	/* private HashMap<Produit, Integer> pdQte;
	public ProduitQte() {
		pdQte = new HashMap<>();
	}
	
	public boolean add(Produit p, int qte) {
		if (pdQte.containsKey(p)) {
			return false;
		}
		return pdQte.put(p, qte) == -1;
	}*/
	private Produit produit;
	private int qte;
	
	/**
	 * 
	 * @param produit
	 * @param qte
	 */
	public ProduitQte(Produit produit, int qte) {
		this.produit = produit;
		this.qte = qte;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getQte() {
		return qte;
	}
	
	/**
	 * 
	 * @param qte
	 */
	public void setQte(int qte) {
		this.qte = qte;
	}
	
	/**
	 * 
	 * @return
	 */
	public Produit getProduit() {
		return produit;
	}
}
