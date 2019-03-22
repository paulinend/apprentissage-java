package fr.eni.pbanque;

import java.util.HashMap;

import fr.eni.pclient.Personne;

public class Banque {
	
	/************ attributs private ***********/
	
//	private Compte [] listeComptes = new Compte[100];
	private HashMap<String, Compte> listeComptes = new HashMap<>();
	
	private int numeroCompte = 100;
	private int duree = 7;
	private double taux = 0.05;  
	
		
	/************ constructeurs ***********/
	
	public Banque ( int duree, double taux ) {
		this.duree = duree;
		this.taux = taux;
	}
	public Banque () {}
	
	
	/************ méthodes ***********/
	
	
	public void creerCompteCourant( Personne pers ) {
		//creer le compte
		CompteCourant cpt;
		cpt = new CompteCourant(pers, String.valueOf(numeroCompte));
		numeroCompte++;
		// stocker dans le tableau
		listeComptes.put(cpt.getNumeroCompte(), cpt);
	}
	
	public void creerCompteEpargne( Personne pers) {
		CompteEpargne cpt;
		cpt = new CompteEpargne(pers, String.valueOf(numeroCompte), duree, taux) ;
		numeroCompte++;
		listeComptes.put(cpt.getNumeroCompte(), cpt);
	}
	
	public String getComptes() {
		StringBuilder res = new StringBuilder("Liste des comptes \n");
		for (Compte cpt : listeComptes.values())
			res.append(cpt.toString() + "\n");
		return res.toString();
	}
	
	public Compte rechercherCompte( String numeroCompte) {
		return listeComptes.get(numeroCompte);
	}
	
	public void calculInteret() {
		for (Compte cpt : listeComptes.values())
			if (cpt instanceof CompteEpargne)
				((CompteEpargne)cpt).calculInteret();
	}
	
}
