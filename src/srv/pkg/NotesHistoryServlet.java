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



import org.apache.log4j.Logger;

import data.pkg.*;


/**
 * Servlet implementation class NotesHistoryServlet
 */
public class NotesHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static final Logger logger= Logger.getLogger(NotesHistoryServlet.class);   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotesHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User admin=(User)request.getSession().getAttribute("user");
		if(admin==null)
		{ 
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserLogin.jsp");
		    PrintWriter out= response.getWriter();
		    out.println("<font color=red>You are not logged in as adminstrator</font>");
		    rd.include(request, response);
	    }
		else
		{
			
			try {
				ArrayList<Note> notesList= NotesDataAccess.GetNotes();
			    request.setAttribute("notes",notesList);  
				 logger.info(" NotesDataAccess.GetNotes()");
			    RequestDispatcher rd = getServletContext().getRequestDispatcher("/AdminView.jsp");
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
