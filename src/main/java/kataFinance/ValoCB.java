/**
 * 
 */
package kataFinance;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author samirfak
 *
 */
public class ValoCB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Porfolio
		Portfolio ptfs = new Portfolio();
		Client clients = new Client();
		Forex forex = new Forex();
		// TODO Auto-generated method stub
		try(BufferedReader forexs = new BufferedReader(new FileReader("src/main/resources/Forex.csv"))) {
			String ligne;
			String[] infos = new String[3];
			for (int i = 0; (ligne = forexs.readLine()) != null; i++) {
				if (i > 4) {
					infos = ligne.split(",");
					//System.out.println(ligne);
					PaireDevises p = new PaireDevises(infos[0], infos[1]);
					forex.add(p, Double.parseDouble(infos[2]));
				}				
			}
			//forex.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(BufferedReader prices = new BufferedReader(new FileReader("src/main/resources/Product.csv"))) {
			String ligne;
			String[] infos = new String[3];
			for (int i = 0; (ligne = prices.readLine()) != null; i++) {
				if (i > 4) {
					infos = ligne.split(",");
					//System.out.println(ligne);				
					Produit p = new Produit(infos[0], null);
					ProduitQte pQ = new ProduitQte(p, Integer.parseInt(infos[2]));
					clients.add(infos[1], pQ);					
				}				
			}
			//clients.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(BufferedReader prices = new BufferedReader(new FileReader("src/main/resources/Prices.csv"))) {
			String ligne;
			String[] infos = new String[5];
			for (int i = 0; (ligne = prices.readLine()) != null; i++) {
				if (i > 3) {
					infos = ligne.split(",");
					//System.out.println(ligne);
					Underlying u = new Underlying(infos[2], Integer.parseInt(infos[4]), infos[3]);
					Produit p = new Produit(infos[1], u);
					ProduitQte pQ = new ProduitQte(p, 0);
					ptfs.add(infos[0], pQ);					System.out.println();
					//Produit p = new Produit(infos[1], );
					//Portfolio pf = new Portfolio();
				}
				
			}
			ptfs.toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
