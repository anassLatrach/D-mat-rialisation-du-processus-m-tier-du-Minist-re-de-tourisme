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
import ma.ministere.models.Directeurs;
import ma.ministere.models.Gerants;
import ma.ministere.models.Utilisateurs;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
public class DirecteurDao  extends AbstractDAO {
	
	public DirecteurDao(String tableName) {
		this.tableName = tableName;
	}

	
	@Override
	public ArrayList<AbstractModel> getAll() throws SQLException, ClassNotFoundException, IOException {
		 if (listeModel == null) {
	            listeModel = new ArrayList<>();
	            sql = "SELECT * from " + tableName + " where status = 1 ORDER BY id DESC" ;
	            Connection cnt = DAOUtil.getConnection();
	            Statement stm = DAOUtil.getStatement(cnt);
	            ResultSet rs = stm.executeQuery(sql);
	            Directeurs directeur;
	            while (rs.next()) {
	            	directeur = new Directeurs(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("tel"), 
	            			rs.getString("email"), rs.getString("cin"), rs.getString("nationalite") ,rs.getString("formation") , rs.getString("NiveauInstruction"),
	            			rs.getString("QualificationProfessionnelle"),rs.getString("ExperienceProfessionnelle"));
	            	listeModel.add(directeur);
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
		Directeurs directeur = (Directeurs) m;
		sql = "INSERT INTO " + tableName + "(id, nom, prenom, tel, email, cin, nationalite, formation, NiveauInstruction, QualificationProfessionnelle, ExperienceProfessionnelle,status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, 1)";
		Connection cnt = DAOUtil.getConnection();
		PreparedStatement stm = DAOUtil.getStatement(cnt, sql);
		//stm.setInt(1, Types.NULL);
		stm.setInt(1, Types.NULL);
		stm.setString(2, directeur.getNom());
		stm.setString(3, directeur.getPrenom());
		stm.setString(4, directeur.getTel());
		stm.setString(5, directeur.getEmail());
		stm.setString(6, directeur.getCin());
		stm.setString(7, directeur.getNationalite());
		stm.setString(8, directeur.getFormation());
		stm.setString(9, directeur.getNiveauInstruction());
		stm.setString(10, directeur.getQualificationProfessionnelle());
		stm.setString(11, directeur.getExperienceProfessionnelle());
		int rs = stm.executeUpdate();
		if (rs == 1) {
			if (listeModel != null)
				listeModel.add(directeur);
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
	public int delete(AbstractModel m) throws SQLException, ClassNotFoundException, IOException {
		Directeurs directeur = (Directeurs) m;
        sql = "UPDATE " + tableName + " SET status = 0 WHERE ID = ?";
        Connection cnt = DAOUtil.getConnection();
        PreparedStatement stm = DAOUtil.getStatement(cnt, sql);

		stm.setInt(1, directeur.getId());
        int rs = stm.executeUpdate();
        if(rs == 1) {
            if(listeModel != null) {
                int i = 0;
                for (AbstractModel abstractModel : listeModel) {
                    if (abstractModel.getId() == directeur.getId()) {
                        listeModel.set(i, directeur);
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
}
