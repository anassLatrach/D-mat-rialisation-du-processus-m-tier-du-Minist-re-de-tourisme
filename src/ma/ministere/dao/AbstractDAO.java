package ma.ministere.dao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import ma.ministere.models.AbstractModel;


/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */

public abstract class AbstractDAO {
	 protected ArrayList<AbstractModel> listeModel;
	 protected String tableName, sql;
	 protected abstract ArrayList<AbstractModel> getAll() throws SQLException, ClassNotFoundException, IOException;
	 protected abstract AbstractModel getByID(int id) throws SQLException, ClassNotFoundException, IOException ;
	 protected abstract int insert(AbstractModel m) throws SQLException, ClassNotFoundException, IOException;
	 protected abstract int update(AbstractModel m) throws SQLException, ClassNotFoundException, IOException;
	 protected abstract int delete(AbstractModel m) throws SQLException, ClassNotFoundException, IOException;

}
