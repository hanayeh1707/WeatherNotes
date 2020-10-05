package data.pkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDataAccess {
	
	private static Connection dbConn= null; 
/**
 * Get user by email and password
 * @param email
 * @param password
 * @return user
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public static User getUser(String email, String password) throws ClassNotFoundException, SQLException
   	{
	   
	   
		 dbConn= ConnectionManager.getConnectionManager().getConnection();
			String sql="SELECT * FROM weathernotes.user where user.email='"+email+"' and user.password='"+password+"'";
			 PreparedStatement pstmt=dbConn.prepareStatement(sql);
			
			   ResultSet rs =   pstmt.executeQuery(sql);
		       User user= null; 
		       while (rs.next())
		       {
			  
				  user = new User();
				  user.setName(rs.getString("Name"));
				  user.setId(rs.getInt("Id"));
				  user.setEmail(rs.getString("Email"));
				  user.setMobile(rs.getString("Mobile"));
				  user.setIsAdmin(rs.getBoolean("IsAdmin")); 
				
		     }
		       ConnectionManager.getConnectionManager().closeConnection();
	  return user; 
    }
/**
 *  Get user by Id
 * @param id
 * @return user
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public static User getUserById(int  id) throws ClassNotFoundException, SQLException
	{
 	   
 	   
 		 dbConn= ConnectionManager.getConnectionManager().getConnection();
 			String sql="SELECT * FROM weathernotes.user where user.Id="+id;
 			 PreparedStatement pstmt=dbConn.prepareStatement(sql);
 			
 			   ResultSet rs =   pstmt.executeQuery(sql);
 		       User user= null; 
 		       while (rs.next())
 		       {
 			  
 				  user = new User();
 				  user.setName(rs.getString("Name"));
 				  user.setId(rs.getInt("Id"));
 				  user.setEmail(rs.getString("Email"));
 				  user.setMobile(rs.getString("Mobile"));
 				  user.setIsAdmin(rs.getBoolean("IsAdmin")); 
 				
 		     }
 		      ConnectionManager.getConnectionManager().closeConnection();
 	  return user; 
     }

	/**
	 * Add user
	 * @param user
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static User addUser(User user) throws ClassNotFoundException, SQLException
	{
		 dbConn= ConnectionManager.getConnectionManager().getConnection();
			
		String sql="INSERT INTO `weathernotes`.`user`(`Name`,`Email`,`Password`,`Mobile`,`IsAdmin`)VALUES(?,?,?,?,?)";
	    PreparedStatement pstmt=dbConn.prepareStatement(sql);
	    pstmt.setString(1, user.getName());
	    pstmt.setString(2, user.getEmail());
	    pstmt.setString(3, user.getPassword());
	    pstmt.setString(4, user.getMobile());
	    pstmt.setBoolean(5, user.isIsAdmin());
	    pstmt.executeUpdate(); 
	    ConnectionManager.getConnectionManager().closeConnection();
	   
	    return getUser(user.getEmail(), user.getPassword()); 
	}
  
	public static boolean userExits(String email) throws SQLException, ClassNotFoundException{

		   dbConn= ConnectionManager.getConnectionManager().getConnection();
		   String sql="SELECT * FROM weathernotes.user where user.Email='"+email+"'";
		   PreparedStatement pstmt=dbConn.prepareStatement(sql);
	
		   ResultSet rs =pstmt.executeQuery(sql);
		
		   boolean exists=false;
		
		   if (rs.next()) {
			
			   exists=true;
			   
	       }
		   ConnectionManager.getConnectionManager().closeConnection();
	    
		   return exists; 
   }

}
