package fr.eni.pbanque;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import fr.eni.pbanque.TypeOperation;
import fr.eni.pclient.Personne;

public abstract class Compte {
	/************ attributs private ***********/
	protected String numeroCompte;
	protected double soldeCompte;
	protected LocalDate dateCreationCompte;
	protected Personne proprietaire;
	
//	private Operation [] listeOperations = new Operation [10];
	private ArrayList<Operation> listeOperations = new ArrayList<Operation>();	
	//private int nbrOp = 0;
	
	/************ Accesseurs ***********/
	public String getNumeroCompte() {
		return numeroCompte;
	}
	
	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}
	
	public double getSoldeCompte() {
		return soldeCompte;
	}
	
	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}
	
	public LocalDate getDateCreationCompte() {
		return dateCreationCompte;
	}
	
	public void setDateCreationCompte(LocalDate dateCreationCompte) {
		this.dateCreationCompte = dateCreationCompte;
	}
	
	public Personne getProprietaire() { return proprietaire; }
		
	/************ constructeurs ***********/
	
	public Compte(String numero, double solde, LocalDate dateCreation, Personne proprietaire) {
		numeroCompte = numero;
		soldeCompte = solde;
		dateCreationCompte = dateCreation;
		this.proprietaire = proprietaire;
	}
	// il faut faire un constructeur par défaut
	
	public Compte(Personne proprietaire, String numeroCompte ) {
		soldeCompte = 100;
		dateCreationCompte = LocalDate.now();
		this.proprietaire = proprietaire;
		this.numeroCompte = numeroCompte;
	}
	
	public Compte() {
	}
		
	
	/************ méthodes ***********/
	
//	protected void ajouterOperation( TypeOperation type, double montant ) {
//		Operation op;
//		// créer une nouvelle opération
//		op = new Operation(type, montant, LocalDate.now());
//		// stocker opération dans le tableau
//		if ( nbrOp < 10) {
//			listeOperations[nbrOp] = op;
//			nbrOp++;
//		} else {
//			for (int i = 0 ; i < nbrOp -1 ; i++)
//				listeOperations [i] = listeOperations [i + 1];
//			listeOperations[9] = op;
//		}
//
//	}
	
	
	protected void ajouterOperation( TypeOperation type, double montant ) {
		Operation op;
		op = new Operation(type, montant, LocalDate.now());
		
		listeOperations.add(op);
	}
	
	
	
	public void crediter (double montant) {
		soldeCompte += montant; 
		// soldeCompte = soldeCompte + montant;
		ajouterOperation(TypeOperation.Credit, montant);
	}
	
	public abstract void debiter (double montant) throws InvalidSoldeException ;
	
	public String toString() {
		return "nom proprietaire: " + proprietaire.toString() + " numeroCompte: " + numeroCompte + " soldeCompte: " + soldeCompte + " dateCréationCompte: " + dateCreationCompte; 
	}
	
	public String getHistorique() {
		
		StringBuilder res = new StringBuilder("Liste des opérations \n");
		for (Operation op : listeOperations)
			res.append(op.toString() + "\n");
			return res.toString();
	}
	
	public String getHistorique(Critere critere) {
		// Faire le tri selon le critére 
		if ( critere == critere.montant)
			// tri sur le montant
			Collections.sort(listeOperations);
		else if ( critere == Critere.date);
			// tri sur la date
			Collections.sort(listeOperations, new ComparateurDate());
		
		StringBuilder res = new StringBuilder("Liste des opérations \n");
		for (Operation op : listeOperations)
			res.append(op.toString() + "\n");
			return res.toString();
	}
	
	
}
