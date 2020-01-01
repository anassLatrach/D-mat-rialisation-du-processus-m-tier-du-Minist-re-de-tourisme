package ma.ministere.servlet.Gerant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.ministere.dao.GerantDao;
import ma.ministere.models.Gerants;


/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
public class AjouterGerantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterGerantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int status;
		GerantDao gdao= new GerantDao("gerants");
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
		String nom = request.getParameter("nomGerant");
		String prenom = request.getParameter("prenomGerant");
		String nationalite = request.getParameter("nationalite");
		String cin = request.getParameter("cin");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String niveauInstruction = request.getParameter("niveauInstruction");
		String qualificationProfessionnelle = request.getParameter("qualificationProfessionnelle");
		
		Gerants gerant = new Gerants(0, nom, prenom, email, tel, cin, nationalite, niveauInstruction, qualificationProfessionnelle);
		
		
		
		gdao.insert(gerant);
			
			if(gdao.insert(gerant) == 1) {
				//request.getRequestDispatcher("/views/delegue/index.jsp").include(request, response);
				//request.getRequestDispatcher("/LicencePro/views/delegue/index.jsp").include(request, response); 
				//out.println("<script>  window.location.href=\"https://www.w3schools.com\" </script>");
				
				//request.getRequestDispatcher("/LicencePro/views/delegue/index.jsp").include(request, response);
	            //out.print("<div class='alert alert-success' role='alert'>Record saved successfully!</div><script>window.location.href=\"/LicencePro/views/Admin/index.jsp\"</script>");  
	          
	            
	              //request.getRequestDispatcher("/LicencePro/views/Admin/index.jsp").include(request, response);
				//request.getRequestDispatcher("/views/delegue/index.jsp?msg=success").forward(request, response);
				response.sendRedirect("/LicencePro/views/index.jsp");
	              
			}else {
				request.getRequestDispatcher("/views/delegue/index.jsp").include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
