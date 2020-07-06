package BusinessNDataAccessLayer;

import java.sql.*;
import javax.swing.JTextField;
import PresentationLayer.DB;


/**
 *
 * @author hoxha
 */
public class FriendsDao {


     public static boolean FriendValidate( String friendshipID)
    {
    boolean status = false;
    try(Connection con = DB.getConnection()) {
        PreparedStatement ps = con.prepareStatement("select * from login where friendshipID = ?"); 
        ps.setString(1, friendshipID);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        con.close();
    }catch(Exception e){System.out.println(e);}
    return status;
}

         public static boolean UserValidate( String UserID)
    {
    boolean status = false;
    try(Connection con = DB.getConnection()) {
        PreparedStatement ps = con.prepareStatement("select * from login where LoginID = ?"); 
        ps.setString(1, UserID);
        ResultSet rs=ps.executeQuery();
        status=rs.next();
        con.close();
    }catch(Exception e){System.out.println(e);}
    return status;
}

public static int addFriend(int frID, String UserID)
{
    int status =0;
    try{
        
        Connection con =DB.getConnection();
        PreparedStatement ps= con.prepareStatement("insert into friends values(?,?)");
        ps.setString(1,UserID);
        ps.setInt(2, frID);

        status =ps.executeUpdate();
        con.close();
}catch(Exception e){System.out.println(e);}
    return status;
}

   public static int Check(String UserID)
   {
       boolean status=false;
       int num = 0;
       try(Connection con = DB.getConnection()) {
        PreparedStatement ps = con.prepareStatement("select * from Course_Count LoginID=?"); 
        ps.setString(2, UserID);
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
    


