package ma.ministere.servlet.Agence;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ministere.dao.AgenceDao;
import ma.ministere.dao.DossierDao;
import ma.ministere.models.Agences;
import ma.ministere.models.Dossiers;

/**
 * Servlet implementation class AjouterAgenceServlet
 */ 
public class AjouterAgenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterAgenceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		AgenceDao agenceDao= new AgenceDao("agences");
		PrintWriter out=response.getWriter();  
		 
		String nomAgence=request.getParameter("nomAgence");
		int idGerant= Integer.parseInt(request.getParameter("idGerant")); 
		int idDirecteur= Integer.parseInt(request.getParameter("idDirecteur")); 
		String raisonSocial=request.getParameter("raisonSociale"); 
		String formeJuridique=request.getParameter("formeJuridique"); 
		String siegeSociale=request.getParameter("siegeSociale"); 
		String capitalSouscrit=request.getParameter("capitalSouscrit"); 
		String capitalLibere=request.getParameter("capitalLibere"); 
		String registreCommerce=request.getParameter("registreCommerce"); 
		int numPatent=Integer.parseInt(request.getParameter("numPatente")); 
		String telFix=request.getParameter("numTel");   
		String fax =request.getParameter("fax");   
		String email=request.getParameter("email");   
		String siteWeb=request.getParameter("siteWeb");   
		String type=request.getParameter("typePromoteur");   
		String iddossier =  request.getParameter("iddossier"); 
		 String attestationbancaire =  request.getParameter("attestationbancaire");
		 String actNaissance = request.getParameter("actNaissance");
		 String formulairedelav = request.getParameter("formulairedelav");
		 String casierjudiciare = request.getParameter("casierjudiciare");
		 String cdertinscription = request.getParameter("cdertinscription");
		 String copieCertifieeContratAssurance = request.getParameter("copieCertifieeContratAssurance");
		 String rapportPrevisionnel = request.getParameter("rapportPrevisionnel");
		 String PiecesRelativeOrganisation = request.getParameter("PiecesRelativeOrganisation");
		 String exempCertifSociete = request.getParameter("exempCertifSociete");
		 String listePersonnelRecruter = request.getParameter("listePersonnelRecruter");
		 String certifNegatif = request.getParameter("certifNegatif");
		 String cautionBancaire = request.getParameter("cautionBancaire");
		 String exempAuthentifie = request.getParameter("exempAuthentifie");
		 String comment = request.getParameter("comment"); 
		 
		 
		//Agences agence = new Agences(0,nomAgence, formeJuridique, raisonSocial, siegeSociale, registreCommerce, numPatent, idGerant, idDirecteur, telFix, fax,email, siteWeb, capitalLibere, capitalSouscrit, type, formulairedelav, actNaissance, casierjudiciare, cdertinscription, attestationbancaire,copieCertifieeContratAssurance, rapportPrevisionnel, PiecesRelativeOrganisation, exempCertifSociete, listePersonnelRecruter, certifNegatif, cautionBancaire, exempAuthentifie, comment, iddossier);
		// agenceDao.insert(agence);
		
	/*	 Agences agence = new Agences(0, nomAgence, formeJuridique, raisonSocial, siegeSociale, registreCommerce, numPatent, 
				 telFix, fax, email, siteWeb, idGerant, idDirecteur, capitalSouscrit, capitalLibere, type, formulairedelav,
				 actNaissance, casierjudiciare, cdertinscription, attestationbancaire, copieCertifieeContratAssurance, rapportPrevisionnel, 
				 PiecesRelativeOrganisation, exempCertifSociete, listePersonnelRecruter, certifNegatif, cautionBancaire, exempAuthentifie, comment, iddossier);
		*/ 
		 System.out.println(nomAgence+ " \n "  + formeJuridique+ " \n "  + raisonSocial+ " \n "  + siegeSociale+ " \n "  + registreCommerce+ " \n "  + 
		numPatent+ " \n "  + idGerant+ " \n "  + idDirecteur+ " \n "  + telFix+ " \n "  + fax+ " \n "  + 
				 email+ " \n "  + siteWeb+ " \n "  + capitalLibere+ " \n "  + capitalSouscrit+ " \n "  + type+ " \n "  + formulairedelav+ " \n "  + actNaissance+ " \n "  + casierjudiciare+ " \n "  + cdertinscription+ " \n "  + attestationbancaire+ " \n "  + 
				 copieCertifieeContratAssurance+ " \n "  + rapportPrevisionnel+ " \n "  + PiecesRelativeOrganisation+ " \n "  
				 + exempCertifSociete+ " \n "  + listePersonnelRecruter+ " \n "  + certifNegatif+ " \n "  + 
				 cautionBancaire+ " \n "  + exempAuthentifie+ " \n "  + comment+ " \n "  + iddossier
				);
		 
		 
			 Agences agence = new Agences(0, nomAgence , formeJuridique ,  raisonSocial , siegeSociale , registreCommerce , numPatent , idGerant , idDirecteur   ,  telFix ,  fax  , email , siteWeb ,  capitalLibere , capitalSouscrit , type , formulairedelav ,  actNaissance ,  casierjudiciare ,  cdertinscription ,  attestationbancaire ,  copieCertifieeContratAssurance ,rapportPrevisionnel ,  PiecesRelativeOrganisation ,  exempCertifSociete ,  listePersonnelRecruter , certifNegatif , cautionBancaire ,  exempAuthentifie ,  comment , iddossier);
			 
			//agenceDao.insert(agence);
		 
		 Dossiers dossier = new Dossiers(0, iddossier);
		 DossierDao ddao = new DossierDao("dossiers");
		 
		 
		  try {
			  int status = agenceDao.insert(agence);
			int dstatus =   ddao.insert(dossier);
			
			if(status == 1 || dstatus ==1) {
				response.sendRedirect("/LicencePro/views/index.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//response.sendRedirect("/LicencePro/views/index.jsp");
		//attestationbancaire  = true;
			
			//if(attestationbancaire == null) {
				
				//attestationbancaire = true;
				//System.out.println(attestationbancaire);
			//}
		 
		 
		
	/*	Agences agence = new Agences(0, 
				nomAgence, formeJuridique, raisonSocial, siegeSociale,
				registreCommerce, numPatente, idGerant, idDirecteur, 
				numTel, fax, email, siteWeb, capitalLibere, capitalSouscrit, type);
		
		*
		int status;
		
		status = agenceDao.insert(agence);
		
		if(status>0) {
			 out.print("<div class='alert alert-success' role='alert'>Record saved successfully!</div>");  
            request.getRequestDispatcher("/LicencePro/views/Admin/index.jsp").include(request, response);  
       
		}else {
			request.getRequestDispatcher("/LicencePro/views/Admin/index.jsp").include(request, response);
		}*/
	 
	}

}
