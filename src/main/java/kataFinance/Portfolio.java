package kataFinance;

import java.util.*;
//import java.util.HashMap;

public class Portfolio {
	//private String id;
	//private Produits produits;
	//ArrayList<Produit> produits = new ArrayList<Produit>();
	private HashMap<String, ProduitsQtes> portfolio;

	public Portfolio() {
		this.portfolio = new HashMap<>();
	}
	
	public HashMap<String, ProduitsQtes> getPortfolio() {
		return portfolio;
	}
	
	public void add (String id, ProduitQte produit) {
		if (portfolio.containsKey(id)) {
			portfolio.get(id).add(produit);
		} else {
			ProduitsQtes produits = new ProduitsQtes();
			if (produit != null) {
				produits.add(produit);
			}
			portfolio.put(id, produits);
		}
	}
	
	@Override
	public String toString() {
		for (Map.Entry ptf : portfolio.entrySet()) {
			System.out.println("Id: " + ptf.getKey() + " \nProduits:  \n" + ptf.getValue().toString());
			/*ArrayList a = new ArrayList(ptf.getValue());
			for(Produit p: (ArrayList)ptf.getValue()) {
				
			}*/
		}
		return null;
		
	}
	
	public double prix(String ptf, Forex forex) {
		double sum = 0;
		ProduitsQtes pQ = portfolio.get(ptf);
		for (ProduitQte p : pQ.getProduits()) {
			sum += p.getProduit().prixProduit(forex) * p.getQte();
		}
		return sum;
	}

}
