package ma.ministere.servlet.Directeur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ministere.dao.DirecteurDao;
import ma.ministere.models.Directeurs;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
public class AjouterDirecteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterDirecteurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        
		String nomDirecteur = request.getParameter("nomDirecteur");
		String prenomDirecteur = request.getParameter("prenomDirecteur");
		String nationalite = request.getParameter("nationalite");
		String niveauInstruction = request.getParameter("niveauInstruction");
		String qualificationProfessionnelle = request.getParameter("qualificationProfessionnelle");
		String cin = request.getParameter("cin");

		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String formation = request.getParameter("formation");
		String professionnelle = request.getParameter("experienceProfessionnelle");
	
	
	System.out.println(nomDirecteur+ "\n " + prenomDirecteur+ "\n " + nationalite+ "\n "  + niveauInstruction+ "\n " + qualificationProfessionnelle+ "\n " + cin+ "\n " + tel+email+ "\n " +formation+ "\n " +professionnelle
			 );
	
	Directeurs ds = new Directeurs(0, nomDirecteur, prenomDirecteur, email, tel, cin, nationalite, formation, niveauInstruction, qualificationProfessionnelle, professionnelle);
	
	DirecteurDao ddao = new DirecteurDao("directeurs");
	
	try {
		int status = ddao.insert(ds);
		if(status > 0) {
			response.sendRedirect("/LicencePro/views/delegue/indexd.jsp");
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
