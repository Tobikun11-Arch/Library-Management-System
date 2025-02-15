/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joene
 */
public class Overdue extends javax.swing.JFrame {

    /**
     * Creates new form Overdue
     */
    public Overdue() {
        initComponents();
        
         try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
            String selectt = "SELECT * FROM duedate";
            PreparedStatement select = con.prepareStatement(selectt);
            
            ResultSet rs = select.executeQuery();

            DefaultTableModel tb1Model = (DefaultTableModel) jTable7.getModel();
            tb1Model.setRowCount(0); 

            while (rs.next()) {
                
                String Studentid = rs.getString("studentid");
                String access = rs.getString("access");
                String issue = rs.getString("issue_date");
                String Return = rs.getString("return_date");
                String status = rs.getString("status");
 
                if(!status.equals("Returned")) {
                   
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-dd-yyyy | hh:mm:a");
    Date currentDate = new Date();
    String formattedCurrentDate = dateFormat.format(currentDate);

    try {
        
        Date returnDate = dateFormat.parse(Return);
        long late = (currentDate.getTime() - returnDate.getTime()) / (24 * 60 * 60 * 1000);

        if (late > 0) {
            Double penalty = late * 5.0;
            String penaltyStringg = String.valueOf(penalty);
            String penaltyString = "₱" + penaltyStringg + "0";

            String[] tbData = {Studentid, access, issue, Return, status, penaltyString, formattedCurrentDate};
            tb1Model.addRow(tbData);
            
        }
    } 
    
    catch (ParseException e) {
        
        System.out.println("Error " + e.getMessage());
        
    }
    
                }
            }

        }
    }
       
         
         catch (ClassNotFoundException e) {
        
        System.out.println("Error loading MySQL JDBC driver: " + e.getMessage());
        
    } 
             
             catch (SQLException e) {
                 
        System.out.println("Error connecting to the database: " + e.getMessage());
        
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));

        jTable7.setBackground(new java.awt.Color(0, 255, 255));
        jTable7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Accession No.", "Issue Date", "Return Date", "Status", "Fine", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable7.setGridColor(new java.awt.Color(0, 0, 0));
        jTable7.setRowHeight(35);
        jTable7.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable7.setShowGrid(true);
        jTable7.getTableHeader().setReorderingAllowed(false);
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTable7MouseExited(evt);
            }
        });
        jTable7.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable7PropertyChange(evt);
            }
        });
        jTable7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable7KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable7KeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);
        if (jTable7.getColumnModel().getColumnCount() > 0) {
            jTable7.getColumnModel().getColumn(3).setMinWidth(200);
            jTable7.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTable7.getColumnModel().getColumn(3).setMaxWidth(200);
            jTable7.getColumnModel().getColumn(6).setMinWidth(1);
            jTable7.getColumnModel().getColumn(6).setPreferredWidth(1);
            jTable7.getColumnModel().getColumn(6).setMaxWidth(1);
        }

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Back");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel6MouseEntered(evt);
            }
        });

        jLabel1.setBackground(java.awt.Color.blue);
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("OverDue");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 897, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(258, 258, 258)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked

        int select = jTable7.getSelectedRow();
        
        if (select != -1) {
            
            int result = JOptionPane.showConfirmDialog(rootPane, "Delete this student list?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                
                DefaultTableModel model = (DefaultTableModel) jTable7.getModel();

                
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
                    
                    String select1 = "SELECT * FROM duedate WHERE access = ?";
                    String remove1 = "DELETE FROM duedate WHERE access = ?";
                    
                    PreparedStatement selectt = conn.prepareStatement(select1);
                    PreparedStatement remove = conn.prepareStatement(remove1);
                        
                   String accession = (String) model.getValueAt(select, 1);
                   
                   selectt.setString(1, accession);
                   
                   ResultSet rs = selectt.executeQuery();
                   
                    if (rs.next()) {
                        
                        remove.setString(1, accession);
                        remove.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Delete Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                         model.removeRow(select);
                        
                    }
                    
                    
                } 
                
                catch (Exception e) {
                    
                    System.out.println("Error " + e.getMessage());
                }
                
            }
            
        }
        
    }//GEN-LAST:event_jTable7MouseClicked

    private void jTable7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable7MouseEntered

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseEntered

    private void jTable7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable7KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable7KeyReleased

    private void jTable7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable7KeyPressed
   
    }//GEN-LAST:event_jTable7KeyPressed

    private void jTable7PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable7PropertyChange
        

        
    }//GEN-LAST:event_jTable7PropertyChange

    private void jTable7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseExited

    }//GEN-LAST:event_jTable7MouseExited

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
            java.util.logging.Logger.getLogger(Overdue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Overdue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Overdue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Overdue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Overdue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable7;
    // End of variables declaration//GEN-END:variables
}
