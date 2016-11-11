package gti310.tp3.entities;

import java.util.List;

public class RawData {

	private Integer nbrSommets;
	private Integer valPourInfinie;
	private Integer sommetDepart;
	private List<Integer[]> livraisons;

	public RawData(Integer nbrSommets, Integer valPourInfinie, Integer sommetDepart, List<Integer[]> livraisons) {
		super();
		this.nbrSommets = nbrSommets;
		this.valPourInfinie = valPourInfinie;
		this.sommetDepart = sommetDepart;
		this.livraisons = livraisons;
	}

	public Integer getNbrSommets() {
		return nbrSommets;
	}

	public void setNbrSommets(Integer nbrSommets) {
		this.nbrSommets = nbrSommets;
	}

	public Integer getValPourInfinie() {
		return valPourInfinie;
	}

	public void setValPourInfinie(Integer valPourInfinie) {
		this.valPourInfinie = valPourInfinie;
	}

	public Integer getSommetDepart() {
		return sommetDepart;
	}

	public void setSommetDepart(Integer sommetDepart) {
		this.sommetDepart = sommetDepart;
	}

	public List<Integer[]> getLivraisons() {
		return livraisons;
	}

	public void setLivraisons(List<Integer[]> livraisons) {
		this.livraisons = livraisons;
	}
	
	// Custom methods
	
	public Integer getLivraisonSource(Integer[] livraison) {
		return livraison[0];
	}

	public Integer getLivraisonDestination(Integer[] livraison) {
		return livraison[1];
	}

	public Integer getLivraisonPoids(Integer[] livraison) {
		return livraison[2];
	}
}