package ma.ministere.servlet.Utilsateur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ministere.dao.UtilisateurDao;
import ma.ministere.models.Utilisateurs;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
@WebServlet("/SupprimerUtilisateurServlet")
public class SupprimerUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupprimerUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		 response.setContentType("text/html");  
         PrintWriter out=response.getWriter();  
         int id=Integer.parseInt(request.getParameter("idDelete"));  
         UtilisateurDao userDao = new UtilisateurDao("users");
         Utilisateurs us = new Utilisateurs();
         us.setId(id);
         
			int status = userDao.delete(us);
			if(status>0){  
	            out.print("<div class='alert alert-success' role='alert'>Record saved successfully!</div>");  
	            request.getRequestDispatcher("/WebContent/views/Admin/index.jsp").include(request, response);  
	            response.sendRedirect("/LicencePro/views/Admin/index.jsp");
			}else{  
	            out.println("<div class='alert alert-danger' role='alert'>Sorry! unable to save record</div>"); 
	            request.getRequestDispatcher("/WebContent/views/Admin/index.jsp").include(request, response);
	        }
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
