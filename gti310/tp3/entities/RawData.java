package gti310.tp3.entities;

import java.util.HashMap;

public class RawData {

	private Integer nbrSommets;
	private Integer valPourInfinie;
	private Integer sommetDepart;
	private HashMap<Integer, Integer[]> noeuds;

	public RawData(Integer nbrSommets, Integer valPourInfinie, Integer sommetDepart,
			HashMap<Integer, Integer[]> noeuds) {
		super();
		this.nbrSommets = nbrSommets;
		this.valPourInfinie = valPourInfinie;
		this.sommetDepart = sommetDepart;
		this.noeuds = noeuds;
	}

	// Custom methods

	public Integer getNoeudSource(Integer[] noeud) {
		return noeud[0];
	}

	public Integer getNoeudDestination(Integer[] noeud) {
		return noeud[1];
	}

	public Integer getNoeudPoids(Integer[] noeud) {
		return noeud[2];
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

	public HashMap<Integer, Integer[]> getNoeuds() {
		return noeuds;
	}

	public void setNoeuds(HashMap<Integer, Integer[]> noeuds) {
		this.noeuds = noeuds;
	}
}