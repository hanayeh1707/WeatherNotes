package data.pkg;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class NotesDataAccessTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertNote() {
	  
		Note note = new Note();
		note.setAddedBy(1);
		note.setNoteDate("17/08/2015");
		note.setDescription("Note17082015");
		note.setIsPredefined(false);
		note.setValueFrom(0);
		note.setValueTo(0);
		
		try {
			NotesDataAccess.InsertNote(note);
			assertTrue(true);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetNotes() {
		try {
			ArrayList<Note> notesList= NotesDataAccess.GetNotes();
			
			assertTrue(notesList.size()>0);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetTodaysNote() {
		try {
			Note note= NotesDataAccess.getTodaysNote();
			assertTrue(note!=null); 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/**		@Test
public void testGetNoteByValueRange() {
		try {
			Note note= NotesDataAccess.getNoteByValueRange(8);
			assertTrue(note!=null); 
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}**/

}
