package fr.eni.pbanque;

import java.time.LocalDate;

import fr.eni.pclient.Personne;

public class CompteCourant extends Compte {
	
	/************ attributs private ***********/
	
	private int montantDecouvert;

	
	/************ Accesseurs ***********/
	
	
	public int getMontantDecouvert() { return montantDecouvert; }
	
	public void setMontantDecouvert(int montantDecouvert) {
		this.montantDecouvert = montantDecouvert;
	}
	
	/************ constructeurs ***********/
	
	public CompteCourant(String numeroCompte, double soldeCompte, LocalDate dateCreationCompte, Personne proprietaire, int montantDecouvert) {
		super(numeroCompte, soldeCompte, dateCreationCompte, proprietaire);
		this.montantDecouvert = montantDecouvert;
	}
	
	public CompteCourant(Personne proprietaire, String numeroCompte) {
		super(proprietaire, numeroCompte);
		this.montantDecouvert = 0;
	}
	
	public CompteCourant() {
	}
	
	
	/************ méthodes ***********/
	
	
	public void debiter(double montant) throws InvalidSoldeException {
		if (montant <= soldeCompte + montantDecouvert) {
			soldeCompte -= montant;
			ajouterOperation(TypeOperation.Debit, montant);
		} else {
			throw new InvalidSoldeException("Débit de " + montant + " impossible sur le compte: " + getNumeroCompte());
		}
	}
	
	public String toString() {
		return "COMPTE COURANT: numeroCompte: " + numeroCompte + ", solde: " + soldeCompte + ", dateCreationCompte: " + dateCreationCompte + ", montantDecouvert " + montantDecouvert;
	}
	
}
