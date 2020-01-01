package ma.ministere.dao;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import ma.ministere.models.AbstractModel;
import ma.ministere.models.Roles;
import ma.ministere.models.Utilisateurs; 


/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */

public class UtilisateurDao extends AbstractDAO {
	public UtilisateurDao(String tableName) {
		this.tableName = tableName;
	}


	@Override
	public ArrayList<AbstractModel> getAll() throws SQLException, ClassNotFoundException, IOException {
		 if (listeModel == null) {
	            listeModel = new ArrayList<>();
	            sql = "SELECT "+tableName+".*, roles.name FROM " + tableName + ", roles where "+tableName+".roleId = roles.id and status = 1";
	            Connection cnt = DAOUtil.getConnection();
	            Statement stm = DAOUtil.getStatement(cnt);
	            ResultSet rs = stm.executeQuery(sql);
	            Utilisateurs user;
	            while (rs.next()) {
	            	user = new Utilisateurs(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("tel"), 
	            			rs.getString("email"), rs.getString("password"),  rs.getString("name") ,rs.getInt("status"));
	                listeModel.add(user);
	            }
	            rs.close();
	            rs = null;
	            stm.close();
	            stm = null;
	            cnt.close();
	            cnt = null;
	        }
	        return listeModel;
	}

	@Override
	public AbstractModel getByID(int id) throws SQLException, ClassNotFoundException, IOException {
		getAll();
        for (AbstractModel abstractModel : listeModel) {
            if (abstractModel.getId() == id) {
                return abstractModel;
            }
        }
		return null;
	}

	@Override
	public int insert(AbstractModel m) throws SQLException, ClassNotFoundException, IOException {
		Utilisateurs user = (Utilisateurs) m;
		sql = "INSERT INTO " + tableName + "(id, nom, prenom, tel, email, password, roleId,status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		Connection cnt = DAOUtil.getConnection();
		PreparedStatement stm = DAOUtil.getStatement(cnt, sql);
		//stm.setInt(1, Types.NULL);
		stm.setInt(1, Types.NULL);
		stm.setString(2, user.getNom());
		stm.setString(3, user.getPrenom());
		stm.setString(4, user.getTel());
		stm.setString(5, user.getEmail());
		stm.setString(6, user.getMdp());
		stm.setString(7, user.getRole());
		stm.setInt(8, user.getStatus());
		int rs = stm.executeUpdate();
		if (rs == 1) {
			if (listeModel != null)
				listeModel.add(user);
		}
		stm.close();
		stm = null;
		cnt.close();
		cnt = null;
		return rs;
	}

	@Override
	public int update(AbstractModel m) throws SQLException, ClassNotFoundException, IOException {
        Utilisateurs user = (Utilisateurs) m;
        sql = "UPDATE " + tableName + " SET nom = ?, prenom = ?, tel = ?, email = ?, password = ? WHERE ID = ?";
        Connection cnt = DAOUtil.getConnection();
        PreparedStatement stm = DAOUtil.getStatement(cnt, sql);

		stm.setString(1, user.getNom());
		stm.setString(2, user.getPrenom());
		stm.setString(3, user.getTel());
		stm.setString(4, user.getEmail());
		stm.setString(5, user.getMdp());
		stm.setInt(6, user.getId());
        int rs = stm.executeUpdate();
        if(rs == 1) {
            if(listeModel != null) {
                int i = 0;
                for (AbstractModel abstractModel : listeModel) {
                    if (abstractModel.getId() == user.getId()) {
                        listeModel.set(i, user);
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
	
	@Override
	public int delete(AbstractModel m) throws SQLException, ClassNotFoundException, IOException {
        Utilisateurs user = (Utilisateurs) m;
        sql = "UPDATE " + tableName + " SET status = 0 WHERE ID = ?";
        Connection cnt = DAOUtil.getConnection();
        PreparedStatement stm = DAOUtil.getStatement(cnt, sql);

		stm.setInt(1, user.getId());
        int rs = stm.executeUpdate();
        if(rs == 1) {
            if(listeModel != null) {
                int i = 0;
                for (AbstractModel abstractModel : listeModel) {
                    if (abstractModel.getId() == user.getId()) {
                        listeModel.set(i, user);
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
	
	
	
	public ArrayList<AbstractModel> login(AbstractModel m) throws SQLException, ClassNotFoundException, IOException {
		if (listeModel == null) {
			Utilisateurs user = (Utilisateurs) m;
            listeModel = new ArrayList<>();
            sql = "SELECT "+tableName+".*, roles.name FROM " + tableName + ", roles where "+tableName+".roleId = roles.id and email = ? and password = ?";
            Connection cnt = DAOUtil.getConnection();
            PreparedStatement stm = DAOUtil.getStatement(cnt,sql);
            stm.setString(1, user.getEmail());
            stm.setString(2, user.getMdp());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
            	user = new Utilisateurs(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("tel"), 
            			rs.getString("email"), rs.getString("password"),  rs.getString("name") ,rs.getInt("status"));
                listeModel.add(user);
            }
            rs.close();
            rs = null;
            stm.close();
            stm = null;
            cnt.close();
            cnt = null;
        }
        return listeModel;
	}
	

}
