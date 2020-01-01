package ma.ministere.models;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
public class Gerants  extends AbstractModel {
	private String nom, prenom, email, tel, cin, nationalite;
	private String niveauInstruction,qualificationProfessionnelle;
	
	
	
	public Gerants(int id,String nom, String prenom, String email, String tel, String cin, String nationalite,
			String niveauInstruction, String qualificationProfessionnelle) {
		super(id);
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.cin = cin;
		this.nationalite = nationalite;
		this.niveauInstruction = niveauInstruction;
		this.qualificationProfessionnelle = qualificationProfessionnelle;
	}
	
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getNiveauInstruction() {
		return niveauInstruction;
	}
	public void setNiveauInstruction(String niveauInstruction) {
		this.niveauInstruction = niveauInstruction;
	}
	public String getQualificationProfessionnelle() {
		return qualificationProfessionnelle;
	}
	public void setQualificationProfessionnelle(String qualificationProfessionnelle) {
		this.qualificationProfessionnelle = qualificationProfessionnelle;
	}

	
}
