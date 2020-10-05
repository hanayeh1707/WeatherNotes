package data.pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionManager {
	
private static ConnectionManager connMngr= null; 

private  final String userName="root";

private  final String password="123456";

private  final String connString ="jdbc:mysql://localhost/weathernotes";

private final String driverName="com.mysql.jdbc.Driver";

private Connection dbConn=null ; 

private ConnectionManager(){
	
}
/**
 * Get Instance of ConnectionManager
 * @param 
 * @return Instance of the ConnectionManager Class
 */
public static ConnectionManager getConnectionManager(){
	
	if(connMngr==null){
		
		connMngr=new ConnectionManager();
	}
	return connMngr;
	
}

private boolean openConnection() throws ClassNotFoundException{
	
	try {
		 Class.forName("com.mysql.jdbc.Driver");
			
		dbConn=DriverManager.getConnection(connString,userName,password);
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return true; 
}
/**
 * Opens a connection with weathernotes database
 * @return Connection 
 * @throws ClassNotFoundException
 */
public Connection getConnection() throws ClassNotFoundException{
	
	if(dbConn==null)
	{
		if(openConnection()){
		
			System.out.println("ConnectionOpened");
		
			return dbConn;
	    }
		else
		{
			return null ; 
		}
		
	}
	return dbConn; 
}

public void closeConnection(){
	try
	{
		
		dbConn.close();
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	dbConn=null; 
}

}

