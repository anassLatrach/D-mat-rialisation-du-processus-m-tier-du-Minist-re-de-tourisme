package ma.ministere.servlet.Utilsateur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ministere.models.Utilisateurs;
import ma.ministere.dao.UtilisateurDao;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
public class AjouterUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UtilisateurDao userDao = new UtilisateurDao("users");
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String nom=request.getParameter("nom");  
        String prenom=request.getParameter("prenom");  
        String numTelPortable = request.getParameter("numTelPortable");
        //String numTelGsm = request.getParameter("numTelGsm");
        String email=request.getParameter("email");  
       // String addresse=request.getParameter("addresse");  
        String role=request.getParameter("role");
        String mdp=request.getParameter("password");
          
        Utilisateurs e=new Utilisateurs(0, nom, prenom, numTelPortable, email, mdp, role, 1);  
        
        
   
        int status;
		try {
			status = userDao.insert(e);
		
        if(status>0){  
           // out.print("<div class='alert alert-success' role='alert'>Record saved successfully!</div>");  
            //request.getRequestDispatcher("/LicencePro/views/Admin/index.jsp").include(request, response); 
            response.sendRedirect("/LicencePro/views/Admin/index.jsp");
        }else{  
            out.println("<div class='alert alert-danger' role='alert'>Sorry! unable to save record</div>"); 
            response.sendRedirect("/LicencePro/views/Admin/index.jsp");
        }
        } catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}  
       
        out.close();  
    }  
	}

