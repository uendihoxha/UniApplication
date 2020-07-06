package BusinessNDataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import PresentationLayer.MySQLConn;


public class CommentsDao {
    // Method To Insert Data Into MySQL
    public static void saveCommentData(String person, String course, String comment, JFrame frame){
        try{
            Connection mySqlConn = MySQLConn.getConnection();
            String mySqlQuery = "INSERT INTO comments (PersonName, Course, CommentText) VALUES ( ?, ?, ?)";
            
            PreparedStatement preparedStatement = mySqlConn.prepareStatement(mySqlQuery);
            preparedStatement.setString(1, person);
            preparedStatement.setString(2, course);
            preparedStatement.setString(3, comment);
            
            try{
                preparedStatement.execute();
                JOptionPane.showMessageDialog(frame, "Your comment was added!");
            }catch (Exception exception){
                JOptionPane.showMessageDialog(frame, "Data Error: " + exception.getMessage());
            }
                        
        }catch (Exception exception){
            JOptionPane.showMessageDialog(frame, "Error: " + exception.getMessage());
        }
    }
    // Method To Call Back Data From MySQL
    public static void listCommentsData(JTable personsTable, JFrame frame){
        try{
            Connection mySqlConn = MySQLConn.getConnection();
            PreparedStatement preparedStatement = mySqlConn.prepareStatement("SELECT * FROM comments");
            ResultSet resultSet = preparedStatement.executeQuery();
            
            // Getting Table Model
            DefaultTableModel tableModel = (DefaultTableModel)personsTable.getModel();
            tableModel.setRowCount(0);
            while(resultSet.next()){
                Object personObject[] = {
                    resultSet.getInt("CommentID"),
                    resultSet.getString("PersonName"),
                    resultSet.getString("Course"),
                    resultSet.getString("CommentText")
                };
                tableModel.addRow(personObject);
            }
            
        }
        
        catch (Exception exception){
            JOptionPane.showMessageDialog(frame, "Error: " + exception.getMessage());
        }
    }
}
