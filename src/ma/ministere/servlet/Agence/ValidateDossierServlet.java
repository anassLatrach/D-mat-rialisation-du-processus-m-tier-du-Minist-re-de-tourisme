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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ministere.dao.DossierDao;
import ma.ministere.models.Dossiers;



public class ValidateDossierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateDossierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out=response.getWriter();  
		String iddossier =  request.getParameter("iddossier"); 
		String status =  request.getParameter("status"); 
		String commentaire =  request.getParameter("commentaire");  
		
		
		
		Dossiers dossier = new Dossiers();
		 dossier.setIdDossier(iddossier);
		 dossier.setStatusDelegue(status);
		 dossier.setCommentaireDelegue(commentaire);
		 DossierDao ddoa = new DossierDao("dossiers");
		 try {
			int statusDossier = ddoa.validateDelegue(dossier);
			if(statusDossier == 1) {
				response.sendRedirect("/LicencePro/views/index.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
