/**
 * 
 */
package kataFinance;

import java.util.ArrayList;

/**
 * @author samirfak
 *
 */
public class Underlyings {
	private ArrayList<Underlying> underlyings = new ArrayList<Underlying>();
	
	@Override
	public String toString() {
		StringBuilder res = new StringBuilder("");
		
		for(Underlying u : underlyings) {
			res.append(u.getId()).append("  ");
		}
		return res.toString();
	}
	
	public double prix(){
		return 0;
	}
}
