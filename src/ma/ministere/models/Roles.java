package ma.ministere.models;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
public class Roles extends AbstractModel {
	private String nom;
	
	

	public Roles(int id, String nom) {
		super(id);
		this.nom = nom;
		// TODO Auto-generated constructor stub
	}

	public Roles(int id) {
		super(id);
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
}
