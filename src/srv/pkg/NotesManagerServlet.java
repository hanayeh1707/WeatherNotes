package srv.pkg;

import java.io.*;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import data.pkg.*;

public class NotesManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private static final Logger logger= Logger.getLogger(NotesManagerServlet.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotesManagerServlet() {
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
	        
			out.println("<font color=red>You need to logged in first</font>");
	         
			rd.include(request, response);
		}
		else if(user.isIsAdmin())
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
		else {
			
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
		User user=(User)request.getSession().getAttribute("user");
		
		if(user==null|| !user.isIsAdmin()){
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/UserLogin.jsp");
	      
			  PrintWriter out= response.getWriter();
	        
			  out.println("<font color=red>Please Login </font>");
	          
			  rd.include(request, response);
		}
		
		Note note= new Note(); 
		
		note.setAddedBy(((User)request.getSession().getAttribute("user")).getId());
		
		note.setDescription(request.getParameter("noteDescription"));
	
		note.setNoteDate(request.getParameter("noteDate"));	
    	
		
		
		String predifined= request.getParameter("isPredefined");
    	
    	
		if(predifined.equals("checked")){
			note.setIsPredefined(true) ; 
			
		}else{	
			note.setIsPredefined(false) ; 
		}

		String ValueFrom=request.getParameter("valueFrom");
		if((ValueFrom.equals("")||ValueFrom==null)&& note.getIsPredefined()){
			note.setValueFrom(Integer.MIN_VALUE);
			
		}else{
		note.setValueFrom(Integer.parseInt(ValueFrom));
		}
		String ValueTo=request.getParameter("valueTo");
		if((ValueTo.equals("")||ValueTo==null)&& note.getIsPredefined()){
			note.setValueTo(Integer.MAX_VALUE);
			
		}else{
		note.setValueTo(Integer.parseInt(ValueTo));
		}
		String errorMsg="";
		
		if(note.getNoteDate()==""||note.getNoteDate()==null)
		{
			errorMsg="Invalid Date!<br/>";
		}if(note.getDescription()==""||note.getDescription()==null)
		{
			errorMsg+="Invalid Description!<br/>";
		}
		if(errorMsg !="")
		{
			    RequestDispatcher rd = getServletContext().getRequestDispatcher("/NotesManager.jsp");
	            PrintWriter out= response.getWriter();
	            out.println("<font color=red>"+errorMsg+" </font>");
	            rd.include(request, response);	
		}
		try {
			
			 NotesDataAccess.InsertNote(note);
			 logger.info("NotesDataAccess.InsertNote("+note+")");
			 response.sendRedirect("NotesManagerServlet");
	    	   
		} catch (ClassNotFoundException e) {
				logger.info(e);
			e.printStackTrace();
		} catch (SQLException e) {
			logger.info(e);
			e.printStackTrace();
		}
		}

}
