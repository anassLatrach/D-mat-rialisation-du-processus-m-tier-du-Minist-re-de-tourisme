package ma.ministere.models;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
public class Directeurs extends AbstractModel{
	private String nom, prenom, email, tel, cin, nationalite,formation,NiveauInstruction, QualificationProfessionnelle,ExperienceProfessionnelle;

	
	
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param tel
	 * @param cin
	 * @param nationalite
	 * @param formation
	 * @param niveauInstruction
	 * @param qualificationProfessionnelle
	 */
	public Directeurs(int id, String nom, String prenom, String email, String tel, String cin, String nationalite,
			String formation, String niveauInstruction, String qualificationProfessionnelle, String experienceProfessionnelle) {
		super(id);
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
		this.cin = cin;
		this.nationalite = nationalite;
		this.formation = formation;
		this.NiveauInstruction = niveauInstruction;
		this.QualificationProfessionnelle = qualificationProfessionnelle;
		this.ExperienceProfessionnelle = experienceProfessionnelle;
	}
	
		public Directeurs() {}

	public String getExperienceProfessionnelle() {
		return ExperienceProfessionnelle;
	}

	public void setExperienceProfessionnelle(String experienceProfessionnelle) {
		ExperienceProfessionnelle = experienceProfessionnelle;
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

	public String getFormation() {
		return formation;
	}

	public void setFormation(String formation) {
		this.formation = formation;
	}

	public String getNiveauInstruction() {
		return NiveauInstruction;
	}

	public void setNiveauInstruction(String niveauInstruction) {
		NiveauInstruction = niveauInstruction;
	}

	public String getQualificationProfessionnelle() {
		return QualificationProfessionnelle;
	}

	public void setQualificationProfessionnelle(String qualificationProfessionnelle) {
		QualificationProfessionnelle = qualificationProfessionnelle;
	} 
	 

	
}
