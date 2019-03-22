package fr.eni.pbanque;
import java.time.LocalDate;

public class Operation implements Comparable<Operation> {
	private TypeOperation type;
	private double montant;
	private LocalDate date;
	
	public TypeOperation getType() { return type; }
	public double getMontant() { return montant; }
	public LocalDate getDate() { return date; }
	
	public void setType( TypeOperation type ) { this.type = type; }
	public void setMontant( double montant ) { this.montant = montant; }
	public void setDate( LocalDate date ) { this.date = date; }
	
	public  Operation( TypeOperation type, double montant, LocalDate date) {
		this.type = type;
		this.montant = montant;
		this.date = date;
	}
	
	public Operation() {
	}
	
	public String toString() {
		return "type: " + type + ", montant: " + montant + ", date: " + date;
	}
	
	@Override
	public int compareTo(Operation o) {
		// comparaison sur le solde
		return Double.compare(montant, o.getMontant());
		// comparaison sur la date
		
		
	}
}
