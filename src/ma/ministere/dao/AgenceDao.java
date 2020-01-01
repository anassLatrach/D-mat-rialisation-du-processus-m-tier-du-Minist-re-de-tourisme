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
import ma.ministere.models.Agences;
import ma.ministere.models.Directeurs;
import ma.ministere.models.Gerants;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */


public class AgenceDao  extends AbstractDAO{
	
	public AgenceDao(String tableName) {
		this.tableName = tableName;
	}
	
	@Override
	public ArrayList<AbstractModel> getAll() throws SQLException, ClassNotFoundException, IOException {
		 if (listeModel == null) {
	            listeModel = new ArrayList<>();
	            sql = "select a.*, dir.nom as nomDirecteur, dir.prenom as prenomDirecteur, ger.nom as nomGerant, ger.prenom as prenomGerant FROM "+ tableName +
	            		" a, directeurs dir, gerants ger WHERE a.idGerant = ger.id AND  a.idDirecteur = dir.id";
	            Connection cnt = DAOUtil.getConnection();
	            Statement stm = DAOUtil.getStatement(cnt);
	            ResultSet rs = stm.executeQuery(sql);
	            Agences agence;
	            while (rs.next()) {
	            	agence =  new Agences(rs.getInt("id"), rs.getString("nomAgence"), rs.getString("formeJuridique"), rs.getString("raisonSocial"), rs.getString("siegeSociale"),  rs.getString("registreCommerce"), rs.getInt("numPatente"), rs.getString("nomGerant"), rs.getString("prenomGerant"), rs.getString("nomDirecteur"), rs.getString("prenomDirecteur"), rs.getString("telFix"), rs.getString("fax"), rs.getString("email"), rs.getString("siteWeb"), rs.getString("capitalLibere"), rs.getString("capitalSouscrit"), rs.getString("type"), rs.getString("formulairedelav"), rs.getString("actNaissance"), rs.getString("casierjudiciare"), rs.getString("cdertinscription"), rs.getString("attestationbancaire"), rs.getString("copieCertifieeContratAssurance"), rs.getString("rapportPrevisionnel"),  rs.getString("piecesRelativeOrganisation"), rs.getString("exempCertifSocieté"), rs.getString("listePersonnelRecruter"), rs.getString("certifNegatif"), rs.getString("cautionBancaire"), rs.getString("exempAuthentifie"), rs.getString("comment"), rs.getString("iddossier"));
	            	listeModel.add(agence);
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
		Agences agence = (Agences) m;
		sql = "INSERT INTO " + tableName + "(id, nomAgence ,  formeJuridique , raisonSocial, siegeSociale, registreCommerce , numPatente, idGerant, idDirecteur , telFix,  fax ,     email ,  siteweb,   capitalLibere , capitalSouscrit,  type, formulairedelav , actNaissance,  casierjudiciare , cdertinscription, attestationbancaire,  copieCertifieeContratAssurance, rapportPrevisionnel,  PiecesRelativeOrganisation , exempCertifSocieté,  listePersonnelRecruter, certifNegatif , cautionBancaire , exempAuthentifie , comment, iddossier) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection cnt = DAOUtil.getConnection();
		PreparedStatement stm = DAOUtil.getStatement(cnt, sql);
		//stm.setInt(1, Types.NULL);
		stm.setInt(1, Types.NULL);
		stm.setString(2,agence.getNomAgence());
		stm.setString(3,agence.getFormeJuridique());
		stm.setString(4,agence.getRaisonSocial());
		stm.setString(5,agence.getSiegeSociale());
		stm.setString(6,agence.getRegistreCommerce());
		stm.setInt(7,agence.getNumPatent());
		stm.setInt(8,agence.getIdGerant());
		stm.setInt(9,agence.getIdDirecteur());
		stm.setString(10,agence.getTelFix());
		stm.setString(11,agence.getFax());
		stm.setString(12,agence.getEmail());
		stm.setString(13,agence.getSiteWeb()); 
		stm.setString(14,agence.getCapitalLibere()); 
		stm.setString(15,agence.getCapitalSouscrit()); 
		stm.setString(16,agence.getType()); 
		stm.setString(17,agence.getFormulairedelav()); 
		stm.setString(18,agence.getActNaissance());
		stm.setString(19,agence.getCasierjudiciare()); 
		stm.setString(20,agence.getCdertinscription()); 
		stm.setString(21,agence.getAttestationbancaire()); 
		stm.setString(22,agence.getCopieCertifieeContratAssurance()); 
		stm.setString(23,agence.getRapportPrevisionnel()); 
		stm.setString(24,agence.getPiecesRelativeOrganisation()); 
		stm.setString(25,agence.getExempCertifSocieté()); 
		stm.setString(26,agence.getListePersonnelRecruter()); 
		stm.setString(27,agence.getCertifNegatif()); 
		stm.setString(28,agence.getCautionBancaire()); 
		stm.setString(29,agence.getExempAuthentifie()); 
		stm.setString(30,agence.getComment()); 
		stm.setString(31,agence.getIddossier()); 
		int rs = stm.executeUpdate();
		if (rs == 1) {
			if (listeModel != null)
				listeModel.add(agence);
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
		AgenceDao gdao= new AgenceDao("agences");
	//	Agences agence = new Agences(0, ,  ,  ,  ,   ,   54652313  ,  49 ,   1 ,   "33555433740"  ,  " 767986760 " ,  " migaud@3il.fr " ,  " RUE DU CHAUDRON / RUE DE LA FILATURE, 87000 LIMOGE " ,  " dsfgsdfg " ,  " qsdf " ,  "morale " ,  " True " ,  " True " ,  " True " ,  " True " ,  " True " ,  " True " ,  " True " ,  " True " ,  " True " ,  " True" ,  " True " ,  " True " ,  " True " ,  "  " ,  " APPA54652313" );
		 
		/*Agences agence = new Agences(1, "nomAgence" , " formeJuridique" , " raisonSocial" , " siegeSociale" ,
				"registreCommerce" , 454545 , 1 , 1 , " 664654653" , " 768768765" , " email@d" , " siteWeb" , " capitalLibere" , 
				" capitalSouscrit" , " type" , "formulairedelav" , " actNaissance" , " casierjudiciare" , " cdertinscription" , " attestationbancaire" ,
				" copieCertifieeContratAssurance" , " rapportPrevisionnel" , " piecesRelativeOrganisation" , " exempCertifSocieté" , " listePersonnelRecruter" ,
				" certifNegatif" , "cautionBancaire" , " exempAuthentifie" , " comment" , "AP88");
		 /=*/
		//Agences agence = new Agences(0, "nomAgence", "formeJuridique", "raisonSocial", "siegeSociale", "registreCommerce", 32474798, 11 , 1,"123798744456" , "fa123xfqfsdfqsdfsdfqf45", "ems231qdafqgdsgsd@sfsil", "siqsqd123dteWeb", "capitalSouscrit", "capitalLibere","physique");
	//	Gerants gerant = new Gerants(0, "nom3", "prenom3", "email@email.com", "021234567", "A123CV", "nationalite", "niveauInstruction", "qualificationProfessionnelle");
		//System.out.println(gdao.insert(agence));
	//	System.out.println(gdao.insert(gerant));
		// System.out.println(gdao.getAll());
		
		
		ArrayList<AbstractModel> liste = gdao.getAll();
		Agences ds;
        for (AbstractModel abstractModel : liste) {
        	ds = (Agences) abstractModel;
        
        	
        		
            System.out.println("* ID " + ds.getId() + " -  Nom: " + ds.getNomAgence() +	"-  Dossier: " + ds.getIddossier() + "-  Nom Gerants :" + ds.getNomGerant() + "-  PreNom Gerants :" + ds.getPrenomGerant() + "-  Nom Directeur :" + ds.getPrenomDirecteur()  ); 
	
      
        
        }
		
		
		
        }
	
}
