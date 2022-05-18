/**
 * 
 */
package kataFinance;

/**
 * @author samirfak
 *
 */
public class PaireDevises {
	String dev1;
	String dev2;
	public PaireDevises(String dev1, String dev2) {
		this.dev1 = dev1;
		this.dev2 = dev2;
	}
	
	public int index (String dev) {
		if (dev.equals(dev1)) {
			return 0;
		} else if (dev.equals(dev2)) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public String getDev1() {
		return dev1;
	}
	
	public String getDev2() {
		return dev2;
	}
	
	@Override
	public boolean equals(Object p) {
		return this.dev1.equals(((PaireDevises) p).getDev1()) && this.dev2.equals(((PaireDevises) p).getDev2());
	}
}
