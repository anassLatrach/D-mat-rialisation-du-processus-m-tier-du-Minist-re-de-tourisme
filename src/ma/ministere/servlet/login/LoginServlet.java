package ma.ministere.servlet.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.ministere.dao.UtilisateurDao;
import ma.ministere.models.AbstractModel;
import ma.ministere.models.Utilisateurs;

/**
 * 
 * @author Latrach Anass
 * @email anaslatrach@gmail.com
 * 	
 * 
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		 response.setContentType("text/html");  
	     PrintWriter out=response.getWriter();    
	       
		UtilisateurDao  udao= new UtilisateurDao("users");
		Utilisateurs user = new Utilisateurs();
		String email=request.getParameter("email");
		String mdp=request.getParameter("password");
		user.setEmail(email);
		user.setMdp(mdp);
		ArrayList<AbstractModel> liste = udao.login(user);
		
			
			for (AbstractModel abstractModel : liste) {
				user = (Utilisateurs) abstractModel;
		    if (user.getStatus() != 0) {
		    	HttpSession session = request.getSession(true);
		    	 session.setAttribute("id", user.getId());
		    	 session.setAttribute("nom", user.getNom());
		    	 session.setAttribute("prenom", user.getPrenom());
		    	 session.setAttribute("email", user.getEmail());
		    	 session.setAttribute("role",user.getRole());
		    	 session.setMaxInactiveInterval(30000);
		    	 //System.out.println(session.getAttribute("id") + " " +  session.getAttribute("nom") + " " +  
		    		//	 session.getAttribute("prenom") + " Role :" + session.getAttribute("role")   + "   \n " +  session.getAttribute("status") +   " " +  session.getAttribute("email"));
		    	 //System.out.println( session.setAttribute("id", ds.getId()) ); 
		       // System.out.println("* ID " + ds.getId() + " -  Nom: " + ds.getNom() + " -  Role: " + ds.getRole() +" -  Email: " + ds.getEmail() );
		    	 if(user.getRole().equals("Super Admin") || user.getRole().equals("super admin") || user.getRole().equals("Admin") || user.getRole().equals("admin")) {
		    		 System.out.println("Super Admin!!");
		    		 //rd = request.getRequestDispatcher("/views/Admin/index.jsp");
		    		response.sendRedirect("/LicencePro/views/Admin/index.jsp");
		               // rd.forward(request, response);
		             }
		    	 else if(user.getRole().equals("Délégue") || user.getRole().equals("Délégue")) {
		    		 System.out.println("Délégue");   
		    		 response.sendRedirect("/LicencePro/views/delegue/indexa.jsp");
		    	 }else if(user.getRole().equals("Ministére") || user.getRole().equals("ministére")){
		    		 System.out.println("Ministére");   
		    		 response.sendRedirect("/LicencePro/views/Ministére/index.jsp");
		    	 }
		    	 
		}else {
			response.sendRedirect("/LicencePro/views/Errors/404.html");
		}  
			}
		    
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
