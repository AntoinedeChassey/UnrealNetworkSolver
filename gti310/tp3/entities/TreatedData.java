package gti310.tp3.entities;

import java.util.List;

public class TreatedData {
	
	private Integer sommetDepart;
	private List<Integer[]> chemins;
	
	public TreatedData(Integer sommetDepart, List<Integer[]> chemins) {
		super();
		this.sommetDepart = sommetDepart;
		this.chemins = chemins;
	}

	public Integer getSommetDepart() {
		return sommetDepart;
	}

	public void setSommetDepart(Integer sommetDepart) {
		this.sommetDepart = sommetDepart;
	}

	public List<Integer[]> getchemins() {
		return chemins;
	}

	public void setchemins(List<Integer[]> chemins) {
		this.chemins = chemins;
	}
}
