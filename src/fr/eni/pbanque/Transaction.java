package fr.eni.pbanque;
public class Transaction {
	
	public static void virement ( Compte compte1, Compte compte2, double montant) throws InvalidSoldeException {
		compte1.debiter(montant);
		compte2.crediter(montant);

	}
}
