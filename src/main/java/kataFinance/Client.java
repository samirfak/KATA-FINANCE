package kataFinance;

import java.util.ArrayList;
import java.util.HashMap;

public class Client {
	//private String id;
	//private Produits produits;
	private HashMap<String, ProduitsQtes> clients;
	
	public Client() {
		clients = new HashMap<>() ;
		
		//produits.add(produit);
	}
	
	public void add(String id, ProduitQte produitQte) {
		//produits.add(produit);
		if (clients.containsKey(id)) {
			clients.get(id).add(produitQte);
		} else {
			ProduitsQtes pQ = new ProduitsQtes();
			pQ.add(produitQte);
			clients.put(id, pQ);
		}
	}
	
	public double calculer (String idClient, Forex forex) {
		double sum = 0;
		ProduitsQtes pQ = clients.get(idClient);
		for (ProduitQte p : pQ.getProduits()) {
			sum += p.getProduit().prixProduit(forex) * p.getQte();
		}
		return sum;	
	} 
}
