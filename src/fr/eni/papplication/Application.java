package fr.eni.papplication;
import java.time.LocalDate;

import fr.eni.pbanque.Banque;
import fr.eni.pbanque.Compte;
import fr.eni.pbanque.CompteCourant;
import fr.eni.pbanque.CompteEpargne;
import fr.eni.pbanque.Critere;
import fr.eni.pbanque.InvalidSoldeException;
import fr.eni.pbanque.Transaction;
import fr.eni.pclient.Personne;

public class Application {
	
	public static void main ( String args []) {
//		testPersonne();
//		testCompte();
//		testCompteCourant();
//		testCompteEpargne();
		testBanque();
	}
	
	public static void testBanque() {
		Personne pers1, pers2;
		pers1 = new Personne("Dunand", "Patrick", LocalDate.of(1991, 04, 02), "dpatrick@orange.fr");
		pers2 = new Personne("Chu", "Xinru", LocalDate.of(1991, 04, 02), "cx@orange.fr");
		Banque b;
		b = new Banque();
		b.creerCompteCourant(pers1);
		b.creerCompteEpargne(pers2);
		b.rechercherCompte("100").crediter(500);
		b.rechercherCompte("100").crediter(40);
		b.rechercherCompte("100").crediter(1500);
		try {
			b.rechercherCompte("100").debiter(3500);
		} catch (InvalidSoldeException e) {
			System.out.println(e.getMessage());
		}
		
		b.calculInteret();
		

		
		System.out.println(b.rechercherCompte("100").getHistorique(Critere.montant));
		System.out.println(b.getComptes());
		
	}
	
	public static void testCompteEpargne() {
		Personne pers1, pers2;
		pers1 = new Personne("Dunand", "Patrick", LocalDate.of(1991, 04, 02), "dpatrick@orange.fr");
		pers2 = new Personne("Chu", "Xinru", LocalDate.of(1991, 04, 02), "cx@orange.fr");
				
		CompteEpargne compte1, compte2;
		compte1 = new CompteEpargne(pers2, "515646511");
		compte2 = new CompteEpargne("515646511", 100, LocalDate.now() , pers1,  0.03 ,7);
		
		compte1.crediter(100);
		try {
			compte1.debiter(80);
		} catch (InvalidSoldeException e) {
			System.out.println(e.getMessage());
		}
		compte1.calculInteret();

		
		System.out.println(compte1.toString());
		System.out.println(compte1.getHistorique());
	}
	
	public static void testCompteCourant() {
		Personne pers1, pers2;
		pers1 = new Personne("Dunand", "Patrick", LocalDate.of(1991, 04, 02), "dpatrick@orange.fr");
		pers2 = new Personne("Chu", "Xinru", LocalDate.of(1991, 04, 02), "cx@orange.fr");
				
		CompteCourant compte1, compte2;
		compte1 = new CompteCourant(pers2, "515646511");
		compte2 = new CompteCourant("515646511", 100, LocalDate.now(), pers1, 600);
		
		compte1.crediter(100);
		try {
			compte1.debiter(80);
		} catch (InvalidSoldeException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(compte1.toString());
		System.out.println(compte1.getHistorique());
		
	}
	/*public static void testCompte() {
		
		Personne pers1, pers2;
		pers1 = new Personne("Dunand", "Patrick", LocalDate.of(1991, 04, 02), "dpatrick@orange.fr");
		pers2 = new Personne("Chu", "Xinru", LocalDate.of(1991, 04, 02), "cx@orange.fr");
				
		Compte compte1, compte2;
		compte1 = new Compte(pers2, "515646511");
		compte2 = new Compte("515646511", 100, LocalDate.now(), pers1);
		
		for (int i = 0; i < 15; i++)
			compte1.crediter(100 + i);
		
		compte1.crediter(100);
		compte1.debiter(80);
		
		if ( Transaction.virement(compte1, compte2, 100) == true ) {
			System.out.println("Transaction ok");
		} else {
			System.out.println("Transaction impossible");
		}
		
		
			System.out.println(compte1.toString());
			System.out.println(compte1.getHistorique());
			System.out.println(compte2.toString());
	}*/
	public static void testPersonne() {
		
		Personne pers1;
		pers1 = new Personne("Dunand", "Patrick", LocalDate.of(1991, 04, 02), "dpatrick@orange.fr");
		System.out.println("age: " + pers1.getAge());
		System.out.println(pers1.toString());
		
	}
}
