package srv.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import data.pkg.Note;
import data.pkg.NotesDataAccess;
import data.pkg.User;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static final Logger logger= Logger.getLogger(HomeServlet.class);  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
           User user=(User)request.getSession().getAttribute("user");
		
		 if(user==null){
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserLogin.jsp");
	         
			PrintWriter out= response.getWriter();
	        
			out.println("<font color=red>You are not logged in first</font>");
	         
			rd.include(request, response);
		 }else{
			 Note note;
				try {
					
					note = NotesDataAccess.getTodaysNote();
					
					logger.info("NotesDataAccess.getTodaysNote()");
					
					request.setAttribute("note", note);
				    RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
				    rd.include(request, response);
					
			        
				} catch (ClassNotFoundException | SQLException e) {
					logger.info(e);
					e.printStackTrace();
				} 
			 
		 }
		
			 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
