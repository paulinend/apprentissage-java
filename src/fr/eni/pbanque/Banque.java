package fr.eni.pbanque;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.eni.pclient.Personne;

public class Banque {
	
	/************ attributs private ***********/
	
//	private Compte [] listeComptes = new Compte[100];
	private HashMap<String, Compte> listeComptes = new HashMap<>();
	
	private int numeroCompte = 100;
	private int duree = 7;
	private double taux = 0.05;  
	
	static Logger logger = LogManager.getLogger(Banque.class);
	
		
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
		logger.debug("Compte courant crée " + cpt.getNumeroCompte());
	}
	
	public void creerCompteEpargne( Personne pers) {
		CompteEpargne cpt;
		cpt = new CompteEpargne(pers, String.valueOf(numeroCompte), duree, taux) ;
		numeroCompte++;
		listeComptes.put(cpt.getNumeroCompte(), cpt);
		logger.debug("Compte courant crée " + cpt.getNumeroCompte());
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
	
	public Compte rechercherCompteParNom(String nom) {
		return listeComptes.values()
					.stream() // crée un stream avec les valeur du hashmap
					.filter(cpt -> cpt.getProprietaire().getNom().equals(nom)) 
					.findFirst()
					.orElse(null);
	}
	
	public double getTotalSolde() {
		return listeComptes.values()
				.stream()
				.mapToDouble(cpt -> cpt.getSoldeCompte())
				.sum();
	}
	
	public void calculInteret() {
		for (Compte cpt : listeComptes.values())
			if (cpt instanceof CompteEpargne)
				((CompteEpargne)cpt).calculInteret();
	}
	
}
