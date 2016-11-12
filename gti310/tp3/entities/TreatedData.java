package gti310.tp3.entities;

import java.util.List;

public class TreatedData {

	private Integer sommetDepart;
	private List<Path<Integer, Integer>> noeuds;

	public TreatedData(Integer sommetDepart, List<Path<Integer, Integer>> noeuds) {
		super();
		this.sommetDepart = sommetDepart;
		this.noeuds = noeuds;
	}

	// Custom methods

	public Integer getCheminParent(Integer[] chemin) {
		return chemin[0];
	}

	public Integer getCheminPoids(Integer[] chemin) {
		return chemin[1];
	}

	public Integer getSommetDepart() {
		return sommetDepart;
	}

	public void setSommetDepart(Integer sommetDepart) {
		this.sommetDepart = sommetDepart;
	}

	public List<Path<Integer, Integer>> getNoeuds() {
		return noeuds;
	}

	public void setNoeuds(List<Path<Integer, Integer>> noeuds) {
		this.noeuds = noeuds;
	}
}
