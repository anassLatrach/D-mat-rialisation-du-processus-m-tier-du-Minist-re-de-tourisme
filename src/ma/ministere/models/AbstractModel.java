package ma.ministere.models;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
public abstract class AbstractModel {
	  	protected int id;

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public AbstractModel(int id) {
	        this.id = id;
	    }
	    public AbstractModel() {
	    }
}
