package fr.eni.pclient;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Personne {
	private String nom;
	private String prenom;
	private LocalDate dateNaissance;
	private String email;
	
	
	public String getNom() { return nom; }
	public String getprenom() { return prenom; }
	public LocalDate getdateNaissance() { return dateNaissance; }
	public String getEmail() { return email; }
	
	public void setNom( String nom ) {
		this.nom = nom;
	}
	public void setPrenom( String prenom ) {
		this.prenom = prenom;
	}

	public void email( String email ) {
		this.email = email;
	}
	
	public Personne(
			String nom,
			String prenom,
			LocalDate dateNaissance,
			String email
			) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		
	}
	
	public Personne() {
		nom = "Dunand";
		prenom = "Pierre";
		dateNaissance = LocalDate.now();
		email = "dpierre@orange.fr";
		
	}
	
	public String toString() {
		return "nom: " + nom + ", prénom: " + prenom + ", date de naissance: " + dateNaissance + ", adresse email: " + email;
	} 
	
	public int getAge() {
		LocalDate dateCourante = LocalDate.now();
		int age = (int) ChronoUnit.YEARS.between(dateNaissance, dateCourante);
		return age;
	}
	


}
