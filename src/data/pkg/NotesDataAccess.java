package data.pkg;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class NotesDataAccess {
	private static Connection dbConn= null; 
	/**
	 * Inserting new Note in weathernotes database
	 * @param note
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	  public static void InsertNote(Note note) throws ClassNotFoundException, SQLException{
		
		dbConn= ConnectionManager.getConnectionManager().getConnection();
		String sql="INSERT INTO `weathernotes`.`note`(`NoteDate`,`Description`,`AddedBy`,`IsPredefined`,`ValueFrom`,`ValueTo`) VALUES(?,?,?,?,?,?)";
	    PreparedStatement pstmt=dbConn.prepareStatement(sql);
	    pstmt.setString(1,  note.getNoteDate());
	    pstmt.setString(2, note.getDescription());
	    pstmt.setInt(3, note.getAddedBy());
		pstmt.setBoolean(4, note.getIsPredefined());
		pstmt.setInt(5, note.getValueFrom()); 
		pstmt.setInt(6, note.getValueTo());  

	    pstmt.executeUpdate();
	    ConnectionManager.getConnectionManager().closeConnection();
	}
  	
	  /**
	   * Gets all the notes from wathernotes database
	   * @return
	   * @throws SQLException
	   * @throws ClassNotFoundException
	   */
	  public static ArrayList<Note> GetNotes() throws SQLException, ClassNotFoundException{
		 
			
		 dbConn= ConnectionManager.getConnectionManager().getConnection();
			String sql="SELECT * FROM weathernotes.note";
			 PreparedStatement pstmt=dbConn.prepareStatement(sql);
			
			 ResultSet rs =   pstmt.executeQuery(sql);
			 ArrayList<Note> notesList= new ArrayList<Note>(); 
		    while (rs.next())
		    {  
		        Note	note = new Note();
			    note.setDescription(rs.getString("Description"));	  
			    note.setValueFrom(rs.getInt("ValueFrom"));
			    note.setValueTo(rs.getInt("ValueTo"));
				note.setNoteDate(rs.getString("NoteDate"));
				note.setAddedBy(rs.getInt("AddedBy"));
			    notesList.add(note);
		    }   ConnectionManager.getConnectionManager().closeConnection();
			
	  return notesList; 
	}
  	 
	  /**
	   * Gets the added note for the current date , if there no one for that date gets one of the predefined notes based on the temperature degree 
	   * @return note
	   * @throws ClassNotFoundException
	   * @throws SQLException
	   */
	
	  public static Note getTodaysNote() throws ClassNotFoundException, SQLException
  	  { 
  		   
  		dbConn= ConnectionManager.getConnectionManager().getConnection();
 		 
		    String currentDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
	        System.out.println(currentDate);
		 	String sql="SELECT * FROM weathernotes.note  where note.NoteDate='"+currentDate+"'" ;
		    System.out.println(sql);
		     PreparedStatement pstmt=dbConn.prepareStatement(sql);
			  ResultSet rs =   pstmt.executeQuery(sql);
		      Note note= null; 
		      while(rs.next())
			   {
				    note = new Note();
				    note.setDescription(rs.getString("Description"));	  
				    note.setValueFrom(rs.getInt("ValueFrom"));
				    note.setValueTo(rs.getInt("ValueTo"));
					note.setNoteDate(rs.getString("NoteDate"));
					note.setAddedBy(rs.getInt("AddedBy"));
			    } 
		      String[] status=WeatherManager.getWeather();
		      
		      if(note==null)
		      {
		  		  int temp=Integer.parseInt( status[0]);
				  note= getNoteByValueRange(temp);
	  		  }
		      if(note==null) return null ;
		      
		      note.setAddedByName(UserDataAccess.getUserById(note.getAddedBy()).getName());
		      note.setTemperature(status[0]);
		      note.setHumidity(status[1]);
		      note.setWindSpeed(status[2]);
		    
		      return note;
  	  }
	 
	  private static Note getNoteByValueRange(int value) throws SQLException, ClassNotFoundException
	  {
		       Note note= null; 
		       dbConn= ConnectionManager.getConnectionManager().getConnection();
			   String sql="SELECT * FROM weathernotes.note where IsPredefined=true and "+value +" <=note.ValueTo and "+value +">=note.ValueFrom";
			   PreparedStatement pstmt=dbConn.prepareStatement(sql);
			
			   ResultSet rs =   pstmt.executeQuery(sql);
			  
			   while(rs.next())
			   {
				    note = new Note();
				    note.setDescription(rs.getString("Description"));	  
				    note.setValueFrom(rs.getInt("ValueFrom"));
				    note.setValueTo(rs.getInt("ValueTo"));
					note.setNoteDate(rs.getString("NoteDate"));
					note.setAddedBy(rs.getInt("AddedBy"));
			    }   
			   
			    ConnectionManager.getConnectionManager().closeConnection();
				
			    return note; 
	  }
}
