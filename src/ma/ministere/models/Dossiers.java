package ma.ministere.models;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
public class Dossiers extends AbstractModel{
	private String idDossier,statusDelegue,commentaireDelegue,statusMinistere,commentaireMinistere;

	/**
	 * @param id
	 * @param idDossier
	 * @param statusDelegue
	 * @param commentaireDelegue
	 * @param statusMinistere
	 * @param commentaireMinistere
	 */
	public Dossiers(int id, String idDossier, String statusDelegue, String commentaireDelegue, String statusMinistere,
			String commentaireMinistere) {
		super(id);
		this.idDossier = idDossier;
		this.statusDelegue = statusDelegue;
		this.commentaireDelegue = commentaireDelegue;
		this.statusMinistere = statusMinistere;
		this.commentaireMinistere = commentaireMinistere;
	}

	/**
	 * @param id
	 * @param idDossier 
	 */
	public Dossiers(int id, String idDossier) {
		super(id);
		this.idDossier = idDossier; 
	}
	public Dossiers() { 
	}
	public String getIdDossier() {
		return idDossier;
	}

	public void setIdDossier(String idDossier) {
		this.idDossier = idDossier;
	}

	public String getStatusDelegue() {
		return statusDelegue;
	}

	public void setStatusDelegue(String statusDelegue) {
		this.statusDelegue = statusDelegue;
	}

	public String getCommentaireDelegue() {
		return commentaireDelegue;
	}

	public void setCommentaireDelegue(String commentaireDelegue) {
		this.commentaireDelegue = commentaireDelegue;
	}

	public String getStatusMinistere() {
		return statusMinistere;
	}

	public void setStatusMinistere(String statusMinistere) {
		this.statusMinistere = statusMinistere;
	}

	public String getCommentaireMinistere() {
		return commentaireMinistere;
	}

	public void setCommentaireMinistere(String commentaireMinistere) {
		this.commentaireMinistere = commentaireMinistere;
	}
 
	
}
