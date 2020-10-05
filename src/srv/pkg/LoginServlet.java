package srv.pkg;

import java.awt.print.Pageable;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import data.pkg.*; 

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       private static final Logger logger= Logger.getLogger(LoginServlet.class);
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
		    RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserLogin.jsp");
		    rd.include(request, response);
	         
		  	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String email= request.getParameter("email");
	String password=request.getParameter("password");
	try {
		User user=UserDataAccess.getUser(email, password);
	//  String method=new String("UserDataAccess.getUser("+email+","+password+")");
	    logger.info("UserDataAccess.getUser("+email+","+password+")");
		if(user==null)
		{
			    RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserLogin.jsp");
	            PrintWriter out= response.getWriter();
	            out.println("<font color=red>Invalid user email or password</font>");
			    rd.include(request, response);
	          
		}
		else
		{
	        HttpSession session=request.getSession(); 
			session.setAttribute("user", user);
           if(user.isIsAdmin())
        	   response.sendRedirect("NotesManagerServlet");
           else
        	   response.sendRedirect("HomeServlet");
		}
		
	
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
