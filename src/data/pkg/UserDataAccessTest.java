package data.pkg;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserDataAccessTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetUser() {
		String email1="", password1="",email2="admin@dom.com", password2="123";
		User u;
		try {
			u = UserDataAccess.getUser(email1, password1);
			assertTrue(u==null);
			u=UserDataAccess.getUser(email2, password2);
			assertTrue(u!=null);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Test
	public void testGetUserById() {
      int id1=0 , id2=1; 
      User u;
		try {
			u = UserDataAccess.getUserById(id1);
			assertTrue(u==null);
			u=UserDataAccess.getUserById(id2);
			assertTrue(u!=null);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAddUser() {
		User u = new User();
		u.setEmail("test@dom.com");
		u.setName("unameTest");
		u.setPassword("testpwd");
		u.setMobile("111111111");
	
		try {
			UserDataAccess.addUser(u);
			assertTrue(true);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
