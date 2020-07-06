package BusinessNDataAccessLayer;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import PresentationLayer.DB;
import PresentationLayer.UserLoginSuccess;
public class CoursesDao {
	

public static boolean checkBook(String courselno){
	boolean status=false;
	try{
		Connection con=DB.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from courses where CourseID=?");
		ps.setString(1,courselno);
                ResultSet rs=ps.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}

     public static boolean CourseValidate( String CourseID)
    {
    boolean status = false;
    try(Connection con = DB.getConnection()) {
        PreparedStatement ps = con.prepareStatement("select * from courses where CourseID = ? and Major='"+UserLoginSuccess.GetMajor+"'"); 
        ps.setString(1, CourseID);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        con.close();
    }catch(Exception e){System.out.println(e);}
    return status;
}

         public static boolean UserValidate( String LoginID)
    {
    boolean status = false;
    try(Connection con = DB.getConnection()) {
        PreparedStatement ps = con.prepareStatement("select * from login where LoginID = ?"); 
        ps.setString(1, LoginID);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        con.close();
    }catch(Exception e){System.out.println(e);}
    return status;
}
         


public static int EnrollingCourse(int CourseID, String LoginID, String IDate, String RDate)
{
    int status =0;
    try{
        
        Connection con =DB.getConnection();
        PreparedStatement ps= con.prepareStatement("insert into enrollcourses values(?,?,?,?)");
        ps.setInt(1,CourseID);
        ps.setString(2, LoginID);
        ps.setString(3,IDate);
        ps.setString(4,RDate);
        status =ps.executeUpdate();
        con.close();
        
        
}catch(Exception e){System.out.println(e);}
    return status;
}

   
    public static int DropingCourse(int CourseID,String LoginID)
{
    int status =0;
    try{
        
        Connection con =DB.getConnection();
        PreparedStatement ps= con.prepareStatement("delete from enrollcourses where CourseID=? and UserID=?");
        ps.setInt(1,CourseID);
        ps.setString(2, LoginID);
        status =ps.executeUpdate();
        con.close();
}catch(Exception e){System.out.println(e);}
    return status;
}


public static boolean CheckEnrollCourses(int CourseID)
{
    boolean status = false;
    try(Connection con = DB.getConnection()) {
        PreparedStatement ps = con.prepareStatement("select * from enrollcourses where CourseID=?"); 
        ps.setInt(1, CourseID);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        con.close();
    }catch(Exception e){System.out.println(e);}
    return status;
}



   public static int Check(String LoginID)
   {
       boolean status=false;
       int num = 0;
       try(Connection con = DB.getConnection()) {
        PreparedStatement ps = con.prepareStatement("select * from course_count UserID=?"); 
        ps.setString(2, LoginID);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        num = rs.getInt("CourseNo");
        con.close();
    }catch(Exception e){System.out.println(e);}
       if(num==5)
           return 0;
       else
           return 1;
   }

 
       
   }
    


