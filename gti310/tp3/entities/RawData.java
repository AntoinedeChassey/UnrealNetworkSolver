package gti310.tp3.entities;

import java.util.List;

public class RawData {

	private Integer nbrSommets;
	private Integer valPourInfinie;
	private Integer sommetDepart;
	private List<Node<Integer, Integer, Integer>> noeuds;

	public RawData(Integer nbrSommets, Integer valPourInfinie, Integer sommetDepart,
			List<Node<Integer, Integer, Integer>> noeuds) {
		super();
		this.nbrSommets = nbrSommets;
		this.valPourInfinie = valPourInfinie;
		this.sommetDepart = sommetDepart;
		this.noeuds = noeuds;
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

	public List<Node<Integer, Integer, Integer>> getNoeuds() {
		return noeuds;
	}

	public void setNoeuds(List<Node<Integer, Integer, Integer>> noeuds) {
		this.noeuds = noeuds;
	}
}