import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.junit.rules.ExpectedException;

import com.mysql.jdbc.MySQLConnection;

import BusinessNDataAccessLayer.CommentsDao;
import BusinessNDataAccessLayer.CoursesDao;
import BusinessNDataAccessLayer.DB;
import BusinessNDataAccessLayer.FriendsDao;
import BusinessNDataAccessLayer.LoginDao;
import BusinessNDataAccessLayer.UsersDao;
import PresentationLayer.MySQLConn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Uendi Hoxha
 * @version 1.0.0
 *
 *          Testing
 */

@DisplayName("Testing CRS")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class TestingUtil {
	String testid = "1";

	/** Testing User on UsersDao */

	@Test
	@Order(1)
	final void testConnectionDB() throws SQLException, ClassNotFoundException {
		DB conn = new DB();
		assertNotNull(conn);

	}

	@Test
	@Order(2)
	final void testValidation() {
		UsersDao conn = new UsersDao();
		assertNotNull(conn);

		boolean validation = UsersDao.validate("uendi") ;
		assertTrue(validation);
		validation = UsersDao.validate("helloworld");
		assertFalse(validation);
		
		boolean validation2 =  UsersDao.CheckIfAlready("uendi");
		assertTrue(validation2);
		validation2 =  UsersDao.CheckIfAlready("helloworld");
		assertFalse(validation2);

	}

	/** Testing on CoursesDao */
	@Test
	@Order(3)
	final void testConnectionnDB() {
		DB conn = new DB();
		assertNotNull(conn);

	}
	
	@Test
	@Order(4)
	final void testUsersCourses() {
		CoursesDao conn = new CoursesDao();
		assertNotNull(conn);
		boolean validation = CoursesDao.UserValidate("1");
		assertTrue(validation);

		// User does not exist.
		validation = CoursesDao.UserValidate("helloworld");
		assertFalse(validation);
	}

	@Test
	@Order(5)
	final void testConnectionnCourses() {
		DB conn = new DB();
		assertNotNull(conn);

	}

	
	@Rule

	public ExpectedException expectedEx = ExpectedException.none();

	@Test

	public void shouldThrowRuntimeExceptionWhenEmployeeIDisNull() throws Exception {

	expectedEx.expect(RuntimeException.class);

	expectedEx.expectMessage("Course is invalid");


	} 
	
	@Test
	@Order(6)
	final void testCourses() {
		boolean validation = CoursesDao.CoursesValidate("18");
		assertTrue(validation);

		// User does not exist.
		validation = CoursesDao.CoursesValidate("helloworld");
		assertFalse(validation);


	}

	@Test
	@Order(7)
	final void testCheckBox() { 

		boolean validation = CoursesDao.checkBook("2");
		assertTrue(validation);

		// Course does not exist.
		validation = CoursesDao.checkBook("helloworld");
		assertFalse(validation);
	}

	@Test
	@Order(8)
	final void testCheckEnrollCourses() {

		boolean validation = CoursesDao.CheckEnrollCourses(14);
		assertTrue(validation);

		// Course does not exist.
		validation = CoursesDao.CheckEnrollCourses(105);
		assertFalse(validation);
	}

	@Test
	@Order(9)
	final void testEnrollingCourse() {

		int validation = CoursesDao.EnrollingCourse(14, "3", "2020-06-09", "2020-06-24");
		Integer.valueOf(validation);

		// Course does not exist.
		validation = CoursesDao.EnrollingCourse(100, "5", "2020-05-24", "2020-06-08");
		Integer.valueOf(validation);
	}

	@Test
	@Order(10)
	final void testDropingCourse() {

		int validation = CoursesDao.DropingCourse(23, "1");
		Integer.valueOf(validation);

		// Course does not exist.
		validation = CoursesDao.DropingCourse(500, "6");
		Integer.valueOf(validation);
	}

	/** Testing on LoginDao */

	@Test
	@Order(11)
	final void testConnectionLogin() {
		LoginDao conn = new LoginDao();
		assertNotNull(conn);
	}

	@Test
	@Order(12)
	final void testLoginDaoValidate() {

		boolean validation = LoginDao.validate("uendi", "uendi");
		assertTrue(validation);

		// Course does not exist.
		validation = LoginDao.validate("6", "test");
		assertFalse(validation);
	}

	/** Testing on FriendsDao */
	@Test
	@Order(13)
	final void testConnectionFriends() {
		FriendsDao conn = new FriendsDao();
		assertNotNull(conn);
	}

	@Test
	@Order(14)
	final void testFriendValidate() {

		boolean validation = FriendsDao.FriendValidate("1");
		assertTrue(validation);

		// Friend does not exist.
		validation = FriendsDao.FriendValidate("thisisnot");
		assertFalse(validation);
	}

	@Test
	@Order(15)
	final void testUserValidate() {

		boolean validation = FriendsDao.UserValidate("1");
		assertTrue(validation);

		// User does not exist.
		validation = FriendsDao.UserValidate("thisisnot");
		assertFalse(validation);
	}

	@Test
	@Order(16)
	final void testaddFriend() {

		int validation = FriendsDao.addFriend(1, "2");
		Integer.valueOf(validation);

		// User does not exist.
		validation = FriendsDao.addFriend(2, "4");
		Integer.valueOf(validation);
	}
	
	
	/** Testing on CommentsDao */
	
	@Test
	@Order(17)
	final void testConnectionComments() {
		CommentsDao conn = new CommentsDao();
		assertNotNull(conn);
	}
	
	@Test
	@Order(18)
	final void testInsertComment() {
		int validation = CommentsDao.InsertComment("uendi","Security", "very good course!");
		Integer.valueOf(validation);

		// User does not exist.
		validation = CommentsDao.InsertComment("hi","this is not a comment", "comment");
		Integer.valueOf(validation);
	}
	
	
	

}
