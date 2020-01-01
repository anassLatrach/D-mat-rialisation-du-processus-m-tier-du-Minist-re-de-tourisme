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
import ma.ministere.models.Gerants;
import ma.ministere.models.Utilisateurs;


/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */

public class GerantDao extends AbstractDAO {

	public GerantDao(String tableName) {
		this.tableName = tableName;
	}

	
	@Override
	public ArrayList<AbstractModel> getAll() throws SQLException, ClassNotFoundException, IOException {
		 if (listeModel == null) {
	            listeModel = new ArrayList<>();
	            sql = "SELECT * from " + tableName +" ORDER BY id DESC";
	            Connection cnt = DAOUtil.getConnection();
	            Statement stm = DAOUtil.getStatement(cnt);
	            ResultSet rs = stm.executeQuery(sql);
	            Gerants gerant;
	            while (rs.next()) {
	            	gerant = new Gerants(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"), 
	            			rs.getString("tel"), rs.getString("cin"), rs.getString("nationalite") ,rs.getString("niveauInstruction") , rs.getString("qualificationProfessionnelle"));
	            	listeModel.add(gerant);
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
		Gerants gerant = (Gerants) m;
		sql = "INSERT INTO " + tableName + "(id, nom, prenom, niveauInstruction, qualificationProfessionnelle,tel, email, cin, nationalite) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection cnt = DAOUtil.getConnection();
		PreparedStatement stm = DAOUtil.getStatement(cnt, sql);
		//stm.setInt(1, Types.NULL);
		stm.setInt(1, Types.NULL);
		stm.setString(2, gerant.getNom());
		stm.setString(3, gerant.getPrenom());
		stm.setString(4, gerant.getNiveauInstruction());
		stm.setString(5, gerant.getQualificationProfessionnelle());
		stm.setString(6, gerant.getTel());
		stm.setString(7, gerant.getEmail());
		stm.setString(8, gerant.getCin());
		stm.setString(9, gerant.getNationalite());
		int rs = stm.executeUpdate();
		if (rs == 1) {
			if (listeModel != null)
				listeModel.add(gerant);
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
	
	
	
	
	

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		GerantDao gdao= new GerantDao("gerants");
	//	Gerants gerant = new Gerants(0, "nom3", "prenom3", "email@email.com", "021234567", "A123CV", "nationalite", "niveauInstruction", "qualificationProfessionnelle");
		
	//	System.out.println(gdao.insert(gerant));
		
		ArrayList<AbstractModel> liste = gdao.getAll();
		Gerants ds;
        for (AbstractModel abstractModel : liste) {
        	ds = (Gerants) abstractModel;
        
        	
        		
            System.out.println("* ID " + ds.getId() + " -  Nom: " + ds.getNom() +	"-  Email: " + ds.getEmail() ); }
	
        System.out.println("##############################");
        
        ds = (Gerants) gdao.getByID(2);
        System.out.println("* ID " + ds.getId() + " -  Nom: " + ds.getNom() +	"-  Email: " + ds.getEmail() ); 
        
        
        }

	
	

}
