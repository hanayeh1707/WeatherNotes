package srv.pkg;

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

import org.apache.log4j.Logger;

import data.pkg.*;


/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static final Logger logger= Logger.getLogger(RegistrationServlet.class);  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserRegistration.jsp");
         
			rd.include(request, response);

	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/**
		try {
			if(UserDataAccess.userExits(request.getParameter("email"))){
				 RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserRegistration.jsp");
		         PrintWriter out= response.getWriter();
		         out.println("<font color=red>a user with this email already registerd</font>");
				 rd.include(request, response);
		          
				
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	**/	
		User user= new User();
		user.setName(request.getParameter("uName")); 
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setMobile(request.getParameter("mobile"));
		user.setIsAdmin(false);
	    try {
	   
	    	user=UserDataAccess.addUser(user);
		    logger.info("UserDataAccess.addUser("+user+")");
	    
		    HttpSession session=request.getSession(); 
			
	    	session.setAttribute("user", user);
           
			response.sendRedirect("HomeServlet");
			
		} catch (ClassNotFoundException | SQLException e) {
			logger.info(e);
			e.printStackTrace();
		}
	}

}
