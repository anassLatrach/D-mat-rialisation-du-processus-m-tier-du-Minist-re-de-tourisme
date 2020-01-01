package ma.ministere.servlet.Utilsateur;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
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
public class ModifierUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try {
		 	UtilisateurDao userDao = new UtilisateurDao("users");
	        response.setContentType("text/html");  
	        PrintWriter out=response.getWriter();    
	       
	        String sid=request.getParameter("id");  
	        int id=Integer.parseInt(sid);     
	        System.out.println(sid);
	        String nom=request.getParameter("nom");  
	        String prenom=request.getParameter("prenom");  
	        String numTelPortable = request.getParameter("numTel");
	        //String numTelGsm = request.getParameter("numTelGsm");
	        String email=request.getParameter("email");  
	       // String addresse=request.getParameter("addresse");  
	        String role=request.getParameter("role");
	        String mdp=request.getParameter("password");
	        System.out.println(id);
	        Utilisateurs e=new Utilisateurs();
	        e.setId(id);
	        e.setNom(nom);
	        e.setPrenom(prenom);
	        e.setTel(numTelPortable);
	        e.setEmail(email);
	        e.setMdp(mdp);
	        System.out.println(nom + " "+ prenom + " "+ numTelPortable + " "+ email + " "+ mdp);
	        int status = userDao.update(e);
					 if(status>0){  
				            out.print("<div class='alert alert-success' role='alert'>Record saved successfully!</div>");  
				            request.getRequestDispatcher("/WebContent/views/Admin/index.jsp").include(request, response);  
				            response.sendRedirect("/LicencePro/views/Admin/index.jsp");
					 }else{  
				            out.println("<div class='alert alert-danger' role='alert'>Sorry! unable to save record</div>"); 
				            request.getRequestDispatcher("/WebContent/views/Admin/index.jsp").include(request, response);
				            response.sendRedirect("/LicencePro/views/Admin/index.jsp");
					 }
				        
				       
				        out.close(); 
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		
	}

}
