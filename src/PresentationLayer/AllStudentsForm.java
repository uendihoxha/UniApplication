/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import PresentationLayer.DB;

/**
 *
 * @author hoxha
 */
public class AllStudentsForm extends javax.swing.JFrame {

    /**
     * Creates new form AllStudents
     * @throws java.sql.SQLException
     */
    public AllStudentsForm() throws SQLException {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        initComponents();
        DefaultTableModel model;
        model = (DefaultTableModel) studentsListTable.getModel();
 
        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select LoginID,FullName,UserName,Email,MajorN from login",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= ps.executeQuery();
            
           ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();

            String Row[];
            Row = new String[colnum];
            while(rs.next()){
                for(int i=1;i<=colnum;i++){
                    Row[i-1]=rs.getString(i);
                    }
                 model.addRow(Row);
            }

           Con.close();
        }catch(Exception e){System.out.println(e);
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentsListTable = new javax.swing.JTable();
        ALL = new javax.swing.JRadioButton();
        AuthorRadio = new javax.swing.JRadioButton();
        NameRadio = new javax.swing.JRadioButton();
        SearchField = new javax.swing.JTextField();
        Search = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanel3.setBackground(new java.awt.Color(122, 162, 162));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(247, 247, 247));
        jLabel12.setText("Check Students List");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel12)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        studentsListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "User ID", "Full Name", "Username", "Email", "Major"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(studentsListTable);

        ALL.setBackground(new java.awt.Color(204, 204, 204));
        ALL.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        ALL.setForeground(new java.awt.Color(51, 51, 51));
        ALL.setText("ALL");
        ALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ALLActionPerformed(evt);
            }
        });

        AuthorRadio.setBackground(new java.awt.Color(204, 204, 204));
        AuthorRadio.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        AuthorRadio.setForeground(new java.awt.Color(51, 51, 51));
        AuthorRadio.setText("Email");
        AuthorRadio.setToolTipText("");
        AuthorRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuthorRadioActionPerformed(evt);
            }
        });

        NameRadio.setBackground(new java.awt.Color(204, 204, 204));
        NameRadio.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        NameRadio.setForeground(new java.awt.Color(51, 51, 51));
        NameRadio.setText("Name");
        NameRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameRadioActionPerformed(evt);
            }
        });

        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });

        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/searchbtn.PNG"))); // NOI18N
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/closePic.PNG"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(NameRadio)
                                .addGap(18, 18, 18)
                                .addComponent(AuthorRadio)
                                .addGap(181, 181, 181)
                                .addComponent(ALL))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ALL)
                    .addComponent(AuthorRadio)
                    .addComponent(NameRadio))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(62, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code hereset
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void NameRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameRadioActionPerformed
        // TODO add your handling code here:
        AuthorRadio.setSelected(false);
        ALL.setSelected(false);
    }//GEN-LAST:event_NameRadioActionPerformed

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchActionPerformed
        // TODO add your handling code here:
        
                    DefaultTableModel model;
        model = (DefaultTableModel) studentsListTable.getModel();
        while(model.getRowCount()>0)
            model.removeRow(model.getRowCount()-1);
        if(NameRadio.isSelected())
        {
      
            String Search = "%"+SearchField.getText()+"%";
        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select * from login where UserName like ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, Search);
            ResultSet rs= ps.executeQuery();
            
           ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();
 
            String Row[];
            Row = new String[colnum];
            while(rs.next()){
                for(int i=1;i<=colnum;i++){
                    Row[i-1]=rs.getString(i);
                    }
                 model.addRow(Row);
            }
            int rowcount = model.getRowCount();
             System.out.println(rowcount);
            if(rowcount==0)
            {
                String NoRow[];
                NoRow = new String[7];
                NoRow[1]="NO";
                NoRow[2]="RESULT";
                NoRow[0]="";
                NoRow[3]="";
                NoRow[4]="";
                NoRow[5]="";
                NoRow[6]="";
                model.addRow(NoRow);
                
                
            }
   
           Con.close();
        }catch(Exception e){System.out.println(e);
    } }
        
        else if(AuthorRadio.isSelected())
        {
  
            String Search = "%"+SearchField.getText()+"%";
        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select * from login where Email like ?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, Search);
            ResultSet rs= ps.executeQuery();
            
           ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();
      
            String Row[];
            Row = new String[colnum];
            while(rs.next()){
                for(int i=1;i<=colnum;i++){
                    Row[i-1]=rs.getString(i);
                    }
                 model.addRow(Row);
            }
            int rowcount = model.getRowCount();
             System.out.println(rowcount);
            if(rowcount==0)
            {
                String NoRow[];
                NoRow = new String[7];
                NoRow[1]="NO";
                NoRow[2]="RESULT";
                NoRow[0]="";
                NoRow[3]="";
                NoRow[4]="";
                NoRow[5]="";
                NoRow[6]="";
                model.addRow(NoRow);
                
                
            }
  
            
           Con.close();
        }catch(Exception e){System.out.println(e);
    }
        }
        
        else
        {
            
	JOptionPane.showMessageDialog(AllStudentsForm.this, "Select Name or Email","No Selection!", JOptionPane.ERROR_MESSAGE);
        }
                
                  /*   Column = new String[colnum];
            for(int i=1;i<=colnum;i++){
               Column[i-1]=rsmd.getColumnClassName(i);
                }
            rs.last();
            
            int rows=rs.getRow();
            rs.beforeFirst();
            
            String[][] data = new String[rows][colnum];
            
            int count=0; */
            
    }//GEN-LAST:event_SearchActionPerformed

    private void AuthorRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuthorRadioActionPerformed
        // TODO add your handling code here:
        NameRadio.setSelected(false);
        ALL.setSelected(false);
    }//GEN-LAST:event_AuthorRadioActionPerformed

    private void ALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ALLActionPerformed
        // TODO add your handling code here:
          NameRadio.setSelected(false);
          AuthorRadio.setSelected(false);
          SearchField.setText("");
          DefaultTableModel model;
        model = (DefaultTableModel) studentsListTable.getModel();
          while(model.getRowCount()>0)
            model.removeRow(model.getRowCount()-1);

        try(Connection Con = DB.getConnection()) {
            PreparedStatement ps=Con.prepareStatement("select LoginID,FullName,UserName,Email,MajorN from login",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs= ps.executeQuery();
            
           ResultSetMetaData rsmd = rs.getMetaData();
  
            int colnum=rsmd.getColumnCount();

            String Row[];
            Row = new String[colnum];
            while(rs.next()){
                for(int i=1;i<=colnum;i++){
                    Row[i-1]=rs.getString(i);
                    }
                 model.addRow(Row);
            }

           Con.close();
        }catch(Exception e){System.out.println(e);
    }
    }//GEN-LAST:event_ALLActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AllStudentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AllStudentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AllStudentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AllStudentsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AllStudentsForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(AllStudentsForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ALL;
    private javax.swing.JRadioButton AuthorRadio;
    private javax.swing.JRadioButton NameRadio;
    private javax.swing.JButton Search;
    private javax.swing.JTextField SearchField;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable studentsListTable;
    // End of variables declaration//GEN-END:variables


}