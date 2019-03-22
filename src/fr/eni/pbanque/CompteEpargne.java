package fr.eni.pbanque;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import fr.eni.pclient.Personne;

public class CompteEpargne extends Compte {
	
	/************ attributs private ***********/
	
	private double interet;
	private double taux;
	private int duree;
	
	
	/************ Accesseurs ***********/
	
	
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public double getTaux() {
		return taux;
	}
	public void setTaux(double taux) {
		this.taux = taux;
	}
	public double getInteret() {
		return interet;
	}
	public void setInteret(double interet) {
		this.interet = interet;
	}
	
	
	/************ constructeurs ***********/
	
	
	
	public CompteEpargne( String numeroCompte, double soldeCompte, LocalDate dateCreationCompte, Personne proprietaire, double taux, int duree) {
		super(numeroCompte, soldeCompte, dateCreationCompte, proprietaire);
		this.duree = duree;
	}
	
	public CompteEpargne(Personne proprietaire, String numeroCompte) {
		super(proprietaire, numeroCompte);
		this.taux = 0.5;
		this.duree = 7;	
	}
	
	public CompteEpargne(Personne proprietaire, String numeroCompte, int duree, double taux ) {
		super(proprietaire, numeroCompte);
		this.taux = 0.5;
		this.duree = 7;	
	}
	
	public void compteEpargne() {}
	
	/************ méthodes ***********/
	
	@Override
	public void debiter (double montant) throws InvalidSoldeException {
		int dureeEcoulee = 0;
		dureeEcoulee = (int) ChronoUnit.YEARS.between(getDateCreationCompte(), LocalDate.now());
		if(montant <= soldeCompte && duree <= dureeEcoulee ) {
			soldeCompte -= montant;
			ajouterOperation(TypeOperation.Debit, montant);
		} else {
			throw new InvalidSoldeException("Débit de " + montant + " impossible sur le compte: " + getNumeroCompte());
		}
	}
	
	public void calculInteret() {
		interet = soldeCompte * taux;
		soldeCompte += interet;
	}
	
	public String toString() {
		return super.toString() + " duree: " + duree + ", Taux: " + taux + ", Interet: " + interet;
	}
	
	
}
