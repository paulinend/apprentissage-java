package fr.eni.pbanque;

import java.util.Comparator;

public class ComparateurDate implements Comparator<Operation> {

	@Override
	public int compare(Operation op1, Operation op2) {
		// comparaison sur la date
		return op1.getDate().compareTo(op2.getDate());
	}
	
}
