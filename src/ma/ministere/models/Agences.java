package ma.ministere.models;

import java.sql.Types;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
public class Agences  extends AbstractModel{
	private String nomAgence,formeJuridique, raisonSocial, siegeSociale, registreCommerce;
	private int numPatent;
	private String  nomGerant, prenomGerant;
	private String nomDirecteur, prenomDirecteur;
	private String telFix;
	private String fax;
	private String email,siteWeb;
	private int idGerant,idDirecteur;
	private String capitalSouscrit, capitalLibere,type;
	private String formulairedelav,actNaissance,casierjudiciare,cdertinscription,attestationbancaire,copieCertifieeContratAssurance,rapportPrevisionnel,PiecesRelativeOrganisation,exempCertifSocieté,listePersonnelRecruter,certifNegatif,cautionBancaire,exempAuthentifie;
	private String comment;
	private String iddossier;
	
	public Agences(int id, String nomAgence, String formeJuridique, String raisonSocial, String siegeSociale,
			String registreCommerce, int numPatent, String nomGerant, String prenomGerant, String nomDirecteur,
			String prenomDirecteur, String telFix, String fax, String email, String siteWeb,String capitalSouscrit, String capitalLibere, String type,String iddossier) {
		super(id);
		this.nomAgence = nomAgence;
		this.formeJuridique = formeJuridique;
		this.raisonSocial = raisonSocial;
		this.siegeSociale = siegeSociale;
		this.registreCommerce = registreCommerce;
		this.numPatent = numPatent;
		this.nomGerant = nomGerant;
		this.prenomGerant = prenomGerant;
		this.nomDirecteur = nomDirecteur;
		this.prenomDirecteur = prenomDirecteur;
		this.telFix = telFix;
		this.fax = fax;
		this.email = email;
		this.siteWeb = siteWeb;
		this.capitalSouscrit = capitalSouscrit;
		this.capitalLibere = capitalLibere;
		this.type = type;
		this.iddossier = iddossier;
	}
	
	
	
	
	// 
/*	public Agences(int id, String nomAgence, String formeJuridique, String raisonSocial, String siegeSociale,
			String registreCommerce, int numPatent, int idGerant, int idDirecteur, String telFix, String fax, String email, 
			String siteWeb, String capitalLibere, String capitalSouscrit, String type, String formulairedelav,String actNaissance,
			String casierjudiciare,String cdertinscription,String attestationbancaire,String copieCertifieeContratAssurance,
			String rapportPrevisionnel,String PiecesRelativeOrganisation, String exempCertifSocieté, 
			String listePersonnelRecruter, String certifNegatif, String cautionBancaire,String exempAuthentifie  ,String comment, String iddossier ) {
		super(id);
		this.nomAgence = nomAgence;
		this.formeJuridique = formeJuridique;
		this.raisonSocial = raisonSocial;
		this.siegeSociale = siegeSociale;
		this.registreCommerce = registreCommerce;
		this.numPatent = numPatent;
		this.telFix = telFix;
		this.fax = fax;
		this.email = email;
		this.siteWeb = siteWeb;
		this.idGerant = idGerant;
		this.idDirecteur = idDirecteur;
		this.capitalSouscrit = capitalSouscrit;
		this.capitalLibere = capitalLibere;
		this.type = type;
		this.actNaissance = actNaissance;
		this.formeJuridique = formeJuridique;
		this.actNaissance = actNaissance;
		this.casierjudiciare = casierjudiciare;
		this.cdertinscription = cdertinscription;
		this.attestationbancaire = attestationbancaire;
		this.copieCertifieeContratAssurance = copieCertifieeContratAssurance;
		this.rapportPrevisionnel = rapportPrevisionnel; 
		this.PiecesRelativeOrganisation = PiecesRelativeOrganisation;
		this.exempCertifSocieté = exempCertifSocieté;
		this.listePersonnelRecruter = listePersonnelRecruter;
		this.certifNegatif = certifNegatif;
		this.cautionBancaire = cautionBancaire;
		this.exempAuthentifie = exempAuthentifie;  
		this.comment = comment;
		this.iddossier = iddossier;
	}

*/

	/**
	 * @param id
	 * @param nomAgence
	 * @param formeJuridique
	 * @param raisonSocial
	 * @param siegeSociale
	 * @param registreCommerce
	 * @param numPatent
	 * @param nomGerant
	 * @param prenomGerant
	 * @param nomDirecteur
	 * @param prenomDirecteur
	 * @param telFix
	 * @param fax
	 * @param email
	 * @param siteWeb
	 * @param idGerant
	 * @param capitalLibere
	 * @param type
	 * @param formulairedelav
	 * @param actNaissance
	 * @param casierjudiciare
	 * @param cdertinscription
	 * @param attestationbancaire
	 * @param copieCertifieeContratAssurance
	 * @param rapportPrevisionnel
	 * @param piecesRelativeOrganisation
	 * @param exempCertifSocieté
	 * @param listePersonnelRecruter
	 * @param certifNegatif
	 * @param cautionBancaire
	 * @param exempAuthentifie
	 * @param comment
	 * @param iddossier
	 */
	public Agences(int id, String nomAgence, String formeJuridique, String raisonSocial, String siegeSociale,
			String registreCommerce, int numPatent, String nomGerant, String prenomGerant, String nomDirecteur,
			String prenomDirecteur, String telFix, String fax, String email, String siteWeb, String capitalSouscrit,
			String capitalLibere, String type, String formulairedelav, String actNaissance, String casierjudiciare,
			String cdertinscription, String attestationbancaire, String copieCertifieeContratAssurance,
			String rapportPrevisionnel, String piecesRelativeOrganisation, String exempCertifSocieté,
			String listePersonnelRecruter, String certifNegatif, String cautionBancaire, String exempAuthentifie,
			String comment, String iddossier) {
		super(id);
		this.nomAgence = nomAgence;
		this.formeJuridique = formeJuridique;
		this.raisonSocial = raisonSocial;
		this.siegeSociale = siegeSociale;
		this.registreCommerce = registreCommerce;
		this.numPatent = numPatent;
		this.nomGerant = nomGerant;
		this.prenomGerant = prenomGerant;
		this.nomDirecteur = nomDirecteur;
		this.prenomDirecteur = prenomDirecteur;
		this.telFix = telFix;
		this.fax = fax;
		this.email = email;
		this.siteWeb = siteWeb;
		this.idGerant = idGerant;
		this.capitalLibere = capitalLibere;
		this.type = type;
		this.formulairedelav = formulairedelav;
		this.actNaissance = actNaissance;
		this.casierjudiciare = casierjudiciare;
		this.cdertinscription = cdertinscription;
		this.attestationbancaire = attestationbancaire;
		this.copieCertifieeContratAssurance = copieCertifieeContratAssurance;
		this.rapportPrevisionnel = rapportPrevisionnel;
		this.PiecesRelativeOrganisation = piecesRelativeOrganisation;
		this.exempCertifSocieté = exempCertifSocieté;
		this.listePersonnelRecruter = listePersonnelRecruter;
		this.certifNegatif = certifNegatif;
		this.cautionBancaire = cautionBancaire;
		this.exempAuthentifie = exempAuthentifie;
		this.comment = comment;
		this.iddossier = iddossier;
	}




	/**
	 * @param id
	 * @param nomAgence
	 * @param formeJuridique
	 * @param raisonSocial
	 * @param siegeSociale
	 * @param registreCommerce
	 * @param numPatent
	 * @param telFix
	 * @param fax
	 * @param email
	 * @param siteWeb
	 * @param idGerant
	 * @param idDirecteur
	 * @param capitalSouscrit
	 * @param capitalLibere
	 * @param type
	 * @param formulairedelav
	 * @param actNaissance
	 * @param casierjudiciare
	 * @param cdertinscription
	 * @param attestationbancaire
	 * @param copieCertifieeContratAssurance
	 * @param rapportPrevisionnel
	 * @param piecesRelativeOrganisation
	 * @param exempCertifSocieté
	 * @param listePersonnelRecruter
	 * @param certifNegatif
	 * @param cautionBancaire
	 * @param exempAuthentifie
	 * @param comment
	 * @param iddossier
	 */
	public Agences(int id, String nomAgence, String formeJuridique, String raisonSocial, String siegeSociale,
			String registreCommerce, int numPatent, int idGerant, int idDirecteur, String telFix, String fax, String email, String siteWeb,
			String capitalLibere,String capitalSouscrit, String type,
			String formulairedelav, String actNaissance, String casierjudiciare, String cdertinscription,
			String attestationbancaire, String copieCertifieeContratAssurance, String rapportPrevisionnel,
			String piecesRelativeOrganisation, String exempCertifSocieté, String listePersonnelRecruter,
			String certifNegatif, String cautionBancaire, String exempAuthentifie, String comment, String iddossier) {
		
		super(id);
		this.nomAgence = nomAgence;
		this.formeJuridique = formeJuridique;
		this.raisonSocial = raisonSocial;
		this.siegeSociale = siegeSociale;
		this.registreCommerce = registreCommerce;
		this.numPatent = numPatent;
		this.telFix = telFix;
		this.fax = fax;
		this.email = email;
		this.siteWeb = siteWeb;
		this.idGerant = idGerant;
		this.idDirecteur = idDirecteur;
		this.capitalSouscrit = capitalSouscrit;
		this.capitalLibere = capitalLibere;
		this.type = type;
		this.formulairedelav = formulairedelav;
		this.actNaissance = actNaissance;
		this.casierjudiciare = casierjudiciare;
		this.cdertinscription = cdertinscription;
		this.attestationbancaire = attestationbancaire;
		this.copieCertifieeContratAssurance = copieCertifieeContratAssurance;
		this.rapportPrevisionnel = rapportPrevisionnel;
		this.PiecesRelativeOrganisation = piecesRelativeOrganisation;
		this.exempCertifSocieté = exempCertifSocieté;
		this.listePersonnelRecruter = listePersonnelRecruter;
		this.certifNegatif = certifNegatif;
		this.cautionBancaire = cautionBancaire;
		this.exempAuthentifie = exempAuthentifie;
		this.comment = comment;
		this.iddossier = iddossier;
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getNomAgence() {
		return nomAgence;
	}

	public void setNomAgence(String nomAgence) {
		this.nomAgence = nomAgence;
	}

	public String getFormeJuridique() {
		return formeJuridique;
	}

	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial;
	}

	public String getSiegeSociale() {
		return siegeSociale;
	}

	public void setSiegeSociale(String siegeSociale) {
		this.siegeSociale = siegeSociale;
	}

	public String getRegistreCommerce() {
		return registreCommerce;
	}

	public void setRegistreCommerce(String registreCommerce) {
		this.registreCommerce = registreCommerce;
	}

	public int getNumPatent() {
		return numPatent;
	}

	public void setNumPatent(int numPatent) {
		this.numPatent = numPatent;
	}

	public String getNomGerant() {
		return nomGerant;
	}

	public void setNomGerant(String nomGerant) {
		this.nomGerant = nomGerant;
	}

	public String getPrenomGerant() {
		return prenomGerant;
	}

	public void setPrenomGerant(String prenomGerant) {
		this.prenomGerant = prenomGerant;
	}

	public String getNomDirecteur() {
		return nomDirecteur;
	}

	public void setNomDirecteur(String nomDirecteur) {
		this.nomDirecteur = nomDirecteur;
	}

	public String getPrenomDirecteur() {
		return prenomDirecteur;
	}

	public void setPrenomDirecteur(String prenomDirecteur) {
		this.prenomDirecteur = prenomDirecteur;
	}

	public String getTelFix() {
		return telFix;
	}

	public void setTelFix(String telFix) {
		this.telFix = telFix;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSiteWeb() {
		return siteWeb;
	}

	public void setSiteWeb(String siteWeb) {
		this.siteWeb = siteWeb;
	}

	public int getIdGerant() {
		return idGerant;
	}

	public void setIdGerant(int idGerant) {
		this.idGerant = idGerant;
	}

	public int getIdDirecteur() {
		return idDirecteur;
	}

	public void setIdDirecteur(int idDirecteur) {
		this.idDirecteur = idDirecteur;
	}

	public String getCapitalSouscrit() {
		return capitalSouscrit;
	}

	public void setCapitalSouscrit(String capitalSouscrit) {
		this.capitalSouscrit = capitalSouscrit;
	}

	public String getCapitalLibere() {
		return capitalLibere;
	}

	public void setCapitalLibere(String capitalLibere) {
		this.capitalLibere = capitalLibere;
	}
 
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFormulairedelav() {
		return formulairedelav;
	}

	public void setFormulairedelav(String formulairedelav) {
		this.formulairedelav = formulairedelav;
	}

	public String getActNaissance() {
		return actNaissance;
	}

	public void setActNaissance(String actNaissance) {
		this.actNaissance = actNaissance;
	}

	public String getCasierjudiciare() {
		return casierjudiciare;
	}

	public void setCasierjudiciare(String casierjudiciare) {
		this.casierjudiciare = casierjudiciare;
	}

	public String getCdertinscription() {
		return cdertinscription;
	}

	public void setCdertinscription(String cdertinscription) {
		this.cdertinscription = cdertinscription;
	}

	public String getAttestationbancaire() {
		return attestationbancaire;
	}

	public void setAttestationbancaire(String attestationbancaire) {
		this.attestationbancaire = attestationbancaire;
	}

	public String getCopieCertifieeContratAssurance() {
		return copieCertifieeContratAssurance;
	}

	public void setCopieCertifieeContratAssurance(String copieCertifieeContratAssurance) {
		this.copieCertifieeContratAssurance = copieCertifieeContratAssurance;
	}

	public String getRapportPrevisionnel() {
		return rapportPrevisionnel;
	}

	public void setRapportPrevisionnel(String rapportPrevisionnel) {
		this.rapportPrevisionnel = rapportPrevisionnel;
	}

	public String getPiecesRelativeOrganisation() {
		return PiecesRelativeOrganisation;
	}

	public void setPiecesRelativeOrganisation(String piecesRelativeOrganisation) {
		PiecesRelativeOrganisation = piecesRelativeOrganisation;
	}

	public String getExempCertifSocieté() {
		return exempCertifSocieté;
	}

	public void setExempCertifSocieté(String exempCertifSocieté) {
		this.exempCertifSocieté = exempCertifSocieté;
	}

	public String getListePersonnelRecruter() {
		return listePersonnelRecruter;
	}

	public void setListePersonnelRecruter(String listePersonnelRecruter) {
		this.listePersonnelRecruter = listePersonnelRecruter;
	}

	public String getCertifNegatif() {
		return certifNegatif;
	}

	public void setCertifNegatif(String certifNegatif) {
		this.certifNegatif = certifNegatif;
	}

	public String getCautionBancaire() {
		return cautionBancaire;
	}

	public void setCautionBancaire(String cautionBancaire) {
		this.cautionBancaire = cautionBancaire;
	}

	public String getExempAuthentifie() {
		return exempAuthentifie;
	}

	public void setExempAuthentifie(String exempAuthentifie) {
		this.exempAuthentifie = exempAuthentifie;
	}
	public String getIddossier() {
		return iddossier;
	}
	public void setIddossier(String iddossier) {
		this.iddossier = iddossier;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
