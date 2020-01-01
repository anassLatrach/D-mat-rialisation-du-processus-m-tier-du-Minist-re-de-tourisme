package ma.ministere.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import ma.ministere.models.AbstractModel;
import ma.ministere.models.Agences;
import ma.ministere.models.Dossiers;
import ma.ministere.models.Utilisateurs;



/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
public class DossierDao extends AbstractDAO{

	public DossierDao(String tableName) {
		this.tableName = tableName;
	}

	@Override
	protected ArrayList<AbstractModel> getAll() throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AbstractModel getByID(int id) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(AbstractModel m) throws SQLException, ClassNotFoundException, IOException {
		Dossiers dossier = (Dossiers) m;
		sql = "INSERT INTO " + tableName + " (id, idDossier)  VALUES (?, ?)";
		Connection cnt = DAOUtil.getConnection();
		PreparedStatement stm = DAOUtil.getStatement(cnt, sql);
		//stm.setInt(1, Types.NULL);
		stm.setInt(1, Types.NULL);
		stm.setString(2,dossier.getIdDossier());    
		int rs = stm.executeUpdate();
		if (rs == 1) {
			if (listeModel != null)
				listeModel.add(dossier);
		}
		stm.close();
		stm = null;
		cnt.close();
		cnt = null;
		return rs;
	}

	@Override
	protected int update(AbstractModel m) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int delete(AbstractModel m) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
 
	public int validateDelegue(AbstractModel m) throws SQLException, ClassNotFoundException, IOException {
        Dossiers dossier = (Dossiers) m;
        sql = "UPDATE " + tableName + " SET statusDelegue = ?, commentaireDelegue = ?  WHERE iddossier = ?";
        Connection cnt = DAOUtil.getConnection();
        PreparedStatement stm = DAOUtil.getStatement(cnt, sql);

		stm.setString(1, dossier.getStatusDelegue());
		stm.setString(2, dossier.getCommentaireDelegue());
		stm.setString(3, dossier.getIdDossier());
        int rs = stm.executeUpdate();
        if(rs == 1) {
            if(listeModel != null) {
                int i = 0;
                for (AbstractModel abstractModel : listeModel) {
                    if (abstractModel.getId() == dossier.getId()) {
                        listeModel.set(i, dossier);
                        break;
                    }
                    i++;
                }
            }
        }
        stm.close();
        stm = null;
        cnt.close();
        cnt = null;
        return rs; 
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		 
	}

}
