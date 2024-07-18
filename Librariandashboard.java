
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


public class Librariandashboard extends javax.swing.JFrame {

 public void log() {
       
     jTabbedPane1.setSelectedIndex(6);
     
    }
 
 public void register() {
     
      jTabbedPane1.setSelectedIndex(4);
     
 }
 
  public void two() {
     
      jTabbedPane1.setSelectedIndex(2);
     
 }
  
   public void one() {
     
      jTabbedPane1.setSelectedIndex(1);
     
 }
   
      public void three() {
     
      jTabbedPane1.setSelectedIndex(3);
     
 }
    

      
      
    public Librariandashboard() {
        initComponents();
        
    
        
        jTabbedPane1.setBorder(null);
        jTabbedPane1.setBackground(null);
        
        
        //list on update area
         try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
            String sql = "SELECT * FROM CatalogBook";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel tb1Model = (DefaultTableModel) jTable4.getModel();
            tb1Model.setRowCount(0); 

            while (rs.next()) {
                String author = rs.getString("Author");
                String title = rs.getString("Title");
                String copyright = rs.getString("Copyright");
                String id = rs.getString("id1");

                String[] tbData = {author, title, copyright, id};
                tb1Model.addRow(tbData);
            }
        }
    } catch (ClassNotFoundException e) {
        System.out.println("Error loading MySQL JDBC driver: " + e.getMessage());
    } catch (SQLException e) {
        System.out.println("Error connecting to the database: " + e.getMessage());
}
        
         
         
         
        //List on remove book area
             try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
            String sql = "SELECT * FROM CatalogBook";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel tb1Model = (DefaultTableModel) jTable5.getModel();
            tb1Model.setRowCount(0); 

            while (rs.next()) {
                String author = rs.getString("Author");
                String title = rs.getString("Title");
                String copyright = rs.getString("Copyright");

                String[] tbData = {author, title, copyright};
                tb1Model.addRow(tbData);
            }
        }
    } 
             
             catch (ClassNotFoundException e) {
        
        System.out.println("Error loading MySQL JDBC driver: " + e.getMessage());
        
    } 
             
             catch (SQLException e) {
                 
        System.out.println("Error connecting to the database: " + e.getMessage());
        
}
             
             
        
        //for attendancelog 
          try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
            String sql = "SELECT * FROM attendancelog";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel tb1Model = (DefaultTableModel) jTable2.getModel();
            tb1Model.setRowCount(0); 

            while (rs.next()) {
                String id_number = rs.getString("id_number");
                String timein = rs.getString("timein");
                String timeout = rs.getString("timeout");
                String date = rs.getString("date");

                String[] tbData = {id_number, timein, timeout, date};
                tb1Model.addRow(tbData);
            }
        }
    } 
          catch (ClassNotFoundException e) {
        System.out.println("Error loading MySQL JDBC driver: " + e.getMessage());
    } 
          catch (SQLException e) {
        System.out.println("Error connecting to the database: " + e.getMessage());
    }
        
          
          
          
          
          
          //show list from attendance records database
             try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
            String sql = "SELECT * FROM attendancerecords";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel tb1Model = (DefaultTableModel) jTable3.getModel();
            tb1Model.setRowCount(0); // Clear existing table data

            while (rs.next()) {
                String id_number = rs.getString("id_number");
                String timein = rs.getString("timein");
                String timeout = rs.getString("timeout");
                String date = rs.getString("date");

                String[] tbData = {id_number, timein, timeout, date};
                tb1Model.addRow(tbData);
            }
        }
    } catch (ClassNotFoundException e) {
        System.out.println("Error loading MySQL JDBC driver: " + e.getMessage());
    } catch (SQLException e) {
        System.out.println("Error connecting to the database: " + e.getMessage());
    }
             
             
          
             
            // Discard na to d na involve sa System
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
            String sql = "SELECT * FROM CatalogBook";
            PreparedStatement pst = con.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();

            DefaultTableModel tb1Model = (DefaultTableModel) jTable1.getModel();
            tb1Model.setRowCount(0); // Clear existing table data

            while (rs.next()) {
                String author = rs.getString("Author");
                String title = rs.getString("Title");
                String copyright = rs.getString("Copyright");

                String[] tbData = {author, title, copyright};
                tb1Model.addRow(tbData);
            }
        }
        
        
    } catch (ClassNotFoundException e) {
        
        System.out.println("Error loading MySQL JDBC driver: " + e.getMessage());
        
    } 
        
        catch (SQLException e) {
            
        System.out.println("Error connecting to the database: " + e.getMessage());
        
    }
        
  
            //show kung ilan ang nasa due date
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")){
                    String selectt = "SELECT COUNT(*) AS totalRows FROM duedate";
                    
                    PreparedStatement select = conn.prepareStatement(selectt);
                    
                    ResultSet rs = select.executeQuery();
                    
                    if(rs.next()) {
                        
                        int countt = rs.getInt("totalRows");
                        
                        String count1 = String.valueOf(countt);
                         count.setText(count1);
    
                    }
 
                    
                }
                
                
                catch (SQLException e) {
                    
                    System.out.println("Error " + e.getMessage());
                    
                }
                
                
            }
            
            catch (ClassNotFoundException e) {
                
                System.out.println("Error " + e.getMessage());
                
            }
            
            
            
            
            
            //Show list kung sino mga nanghiram and expected date ng pagbalik
                try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
        String selectt = "SELECT * FROM issuebook";

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

            if (status.equals("Issued")) {
                String[] tbData = {Studentid, access, issue, Return, status};
                tb1Model.addRow(tbData);
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
   
    } //close librarian dashboard


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        absoluteLayout1 = new org.netbeans.lib.awtextra.AbsoluteLayout();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jToolBar1 = new javax.swing.JToolBar();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        LogoutBtn2 = new javax.swing.JButton();
        CheckBtn3 = new javax.swing.JButton();
        CheckBtn4 = new javax.swing.JButton();
        CheckBtn5 = new javax.swing.JButton();
        CheckBtn6 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        CheckBtn9 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        label19 = new java.awt.Label();
        placeofpublicationn = new javax.swing.JTextField();
        label20 = new java.awt.Label();
        classificationn = new javax.swing.JTextField();
        label21 = new java.awt.Label();
        label22 = new java.awt.Label();
        callnumberr = new javax.swing.JTextField();
        librarycopiess = new javax.swing.JTextField();
        label23 = new java.awt.Label();
        label24 = new java.awt.Label();
        titlee = new javax.swing.JTextField();
        remarkss = new javax.swing.JTextField();
        label25 = new java.awt.Label();
        authorr = new javax.swing.JTextField();
        label26 = new java.awt.Label();
        editionn = new javax.swing.JTextField();
        addbookBtn = new javax.swing.JButton();
        label27 = new java.awt.Label();
        volumee = new javax.swing.JTextField();
        label28 = new java.awt.Label();
        pagess = new javax.swing.JTextField();
        label29 = new java.awt.Label();
        copyrightt = new javax.swing.JTextField();
        label30 = new java.awt.Label();
        label31 = new java.awt.Label();
        sourceoffundd = new javax.swing.JTextField();
        isbnn = new javax.swing.JTextField();
        label32 = new java.awt.Label();
        publisherr = new javax.swing.JTextField();
        label33 = new java.awt.Label();
        accessionnumberr = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        homesearch1 = new javax.swing.JTextField();
        SearchBtn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        homesearch2 = new javax.swing.JTextField();
        SearchBtn3 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        count = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        RegIdUserInput = new javax.swing.JTextField();
        label1 = new java.awt.Label();
        RegisterUserBtn = new javax.swing.JButton();
        FirstName = new java.awt.Label();
        RegUserInput = new javax.swing.JTextField();
        LastName = new java.awt.Label();
        LastNameInput = new javax.swing.JTextField();
        LastName1 = new java.awt.Label();
        RegUsernameInput = new javax.swing.JTextField();
        IDNumberInput = new java.awt.Label();
        CreatePasswordInput1 = new java.awt.Label();
        emailuserinput = new javax.swing.JTextField();
        CreatePasswordInput2 = new java.awt.Label();
        course = new javax.swing.JTextField();
        CreatePasswordInput3 = new java.awt.Label();
        address = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        SearchBtn = new javax.swing.JButton();
        homesearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        label2 = new java.awt.Label();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        CheckBtn7 = new javax.swing.JButton();
        CheckBtn8 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        InputValue2 = new javax.swing.JTextField();
        SearchBtn2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jToolBar1.setRollover(true);

        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));

        LogoutBtn2.setBackground(java.awt.Color.blue);
        LogoutBtn2.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        LogoutBtn2.setForeground(java.awt.Color.white);
        LogoutBtn2.setText("Exit");
        LogoutBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtn2ActionPerformed(evt);
            }
        });

        CheckBtn3.setBackground(java.awt.Color.blue);
        CheckBtn3.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        CheckBtn3.setForeground(java.awt.Color.white);
        CheckBtn3.setText("Register Student");
        CheckBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBtn3ActionPerformed(evt);
            }
        });

        CheckBtn4.setBackground(java.awt.Color.blue);
        CheckBtn4.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        CheckBtn4.setForeground(java.awt.Color.white);
        CheckBtn4.setText("Get Catalog");
        CheckBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBtn4ActionPerformed(evt);
            }
        });

        CheckBtn5.setBackground(java.awt.Color.blue);
        CheckBtn5.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        CheckBtn5.setForeground(java.awt.Color.white);
        CheckBtn5.setText("Attendance Log");
        CheckBtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBtn5ActionPerformed(evt);
            }
        });

        CheckBtn6.setBackground(java.awt.Color.blue);
        CheckBtn6.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        CheckBtn6.setForeground(java.awt.Color.white);
        CheckBtn6.setText("Attendance Records");
        CheckBtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBtn6ActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(java.awt.Color.blue);
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jComboBox1.setForeground(java.awt.Color.white);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "            Add Book", "          Update Book", "         Remove Book", "            Issue Book" }));
        jComboBox1.setBorder(null);
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox1MouseEntered(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });

        CheckBtn9.setBackground(java.awt.Color.blue);
        CheckBtn9.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        CheckBtn9.setForeground(java.awt.Color.white);
        CheckBtn9.setText("MasterList");
        CheckBtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBtn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoutBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CheckBtn3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CheckBtn4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CheckBtn5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CheckBtn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CheckBtn9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CheckBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CheckBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CheckBtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CheckBtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CheckBtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(LogoutBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        label19.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label19.setText("Place of Publication");

        label20.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label20.setText("Classification");

        label21.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label21.setText("Call Number");

        label22.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label22.setText("Library Copies");

        label23.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label23.setText("Title");

        label24.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label24.setText("Remarks");

        label25.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label25.setText("Author");

        label26.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label26.setText("Edition");

        addbookBtn.setBackground(java.awt.Color.blue);
        addbookBtn.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        addbookBtn.setForeground(java.awt.Color.white);
        addbookBtn.setText("Add Book");
        addbookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbookBtnActionPerformed(evt);
            }
        });

        label27.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label27.setText("Volume");

        label28.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label28.setText("Pages");

        label29.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label29.setText("Copyright");

        label30.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label30.setText("Source of Fund");

        label31.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label31.setText("ISBN");

        isbnn.setToolTipText("");

        label32.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label32.setText("Publisher");

        label33.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label33.setText("Accession Number");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isbnn, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(volumee, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editionn, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(authorr, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titlee, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(callnumberr, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accessionnumberr, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pagess, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copyrightt, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sourceoffundd, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publisherr, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placeofpublicationn, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classificationn, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(librarycopiess, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(remarkss, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbookBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(label31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)
                                                .addComponent(isbnn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(label29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)
                                                .addComponent(copyrightt, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(label33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(accessionnumberr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(label30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(sourceoffundd, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(label21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(callnumberr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(label32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(publisherr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(titlee, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(label19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(placeofpublicationn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(authorr, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(classificationn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(editionn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(librarycopiess, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(volumee, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(remarkss, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pagess, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addbookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("B", jPanel2);

        jTable4.setBackground(new java.awt.Color(0, 255, 255));
        jTable4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Author", "Title", "Copyright", "1"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setGridColor(new java.awt.Color(0, 0, 0));
        jTable4.setRowHeight(35);
        jTable4.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable4.setShowGrid(true);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable4MouseEntered(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);
        if (jTable4.getColumnModel().getColumnCount() > 0) {
            jTable4.getColumnModel().getColumn(3).setMinWidth(1);
            jTable4.getColumnModel().getColumn(3).setPreferredWidth(1);
            jTable4.getColumnModel().getColumn(3).setMaxWidth(1);
        }

        homesearch1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homesearch1ActionPerformed(evt);
            }
        });
        homesearch1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                homesearch1KeyReleased(evt);
            }
        });

        SearchBtn1.setBackground(java.awt.Color.blue);
        SearchBtn1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SearchBtn1.setForeground(java.awt.Color.white);
        SearchBtn1.setText("Search");
        SearchBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/2267901.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(homesearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchBtn1)
                            .addComponent(homesearch1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("S", jPanel3);

        jTable5.setBackground(new java.awt.Color(0, 255, 255));
        jTable5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Author", "Title", "Copyright"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setGridColor(new java.awt.Color(0, 0, 0));
        jTable5.setRowHeight(35);
        jTable5.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable5.setShowGrid(true);
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable5MouseEntered(evt);
            }
        });
        jScrollPane5.setViewportView(jTable5);

        homesearch2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homesearch2ActionPerformed(evt);
            }
        });
        homesearch2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                homesearch2KeyReleased(evt);
            }
        });

        SearchBtn3.setBackground(java.awt.Color.blue);
        SearchBtn3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SearchBtn3.setForeground(java.awt.Color.white);
        SearchBtn3.setText("Search");
        SearchBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(homesearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchBtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homesearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("I", jPanel6);

        jTable7.setBackground(new java.awt.Color(0, 255, 255));
        jTable7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Accession No.", "Issue Date", "Return Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTable7.setGridColor(new java.awt.Color(0, 0, 0));
        jTable7.setRowHeight(35);
        jTable7.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable7.setShowGrid(true);
        jTable7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable7MouseEntered(evt);
            }
        });
        jScrollPane7.setViewportView(jTable7);
        if (jTable7.getColumnModel().getColumnCount() > 0) {
            jTable7.getColumnModel().getColumn(3).setMinWidth(200);
            jTable7.getColumnModel().getColumn(3).setPreferredWidth(200);
            jTable7.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        jPanel12.setBackground(new java.awt.Color(0, 51, 51));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/7598663.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Lend Book");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Returned Book");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(0, 0, 0));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
        });

        count.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        count.setForeground(java.awt.Color.red);
        count.setText("0");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Overdue Books");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(count, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(count)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4))
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("T", jPanel8);

        jPanel4.setBackground(java.awt.Color.yellow);

        RegIdUserInput.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RegIdUserInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegIdUserInputActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        label1.setForeground(java.awt.Color.blue);
        label1.setText("Registration Form");

        RegisterUserBtn.setBackground(java.awt.Color.blue);
        RegisterUserBtn.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        RegisterUserBtn.setForeground(java.awt.Color.white);
        RegisterUserBtn.setText("Register");
        RegisterUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterUserBtnActionPerformed(evt);
            }
        });

        FirstName.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        FirstName.setText("First Name");

        RegUserInput.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RegUserInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegUserInputActionPerformed(evt);
            }
        });

        LastName.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        LastName.setText("Last Name");

        LastNameInput.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LastNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LastNameInputActionPerformed(evt);
            }
        });

        LastName1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        LastName1.setText("Username");

        RegUsernameInput.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        RegUsernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegUsernameInputActionPerformed(evt);
            }
        });

        IDNumberInput.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        IDNumberInput.setText("ID Number");

        CreatePasswordInput1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        CreatePasswordInput1.setText("Program & Section");

        emailuserinput.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        emailuserinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailuserinputActionPerformed(evt);
            }
        });

        CreatePasswordInput2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        CreatePasswordInput2.setText("Email");

        course.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });

        CreatePasswordInput3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        CreatePasswordInput3.setText("Address");

        address.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(RegisterUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(FirstName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LastName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LastName1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDNumberInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegUsernameInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LastNameInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegUserInput, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RegIdUserInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CreatePasswordInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailuserinput, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreatePasswordInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CreatePasswordInput3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(189, 189, 189))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(FirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(CreatePasswordInput2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RegUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailuserinput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(LastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CreatePasswordInput1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(course, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LastName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreatePasswordInput3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(IDNumberInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(RegIdUserInput, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(RegisterUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jTabbedPane1.addTab("-", jPanel4);

        SearchBtn.setBackground(java.awt.Color.blue);
        SearchBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SearchBtn.setForeground(java.awt.Color.white);
        SearchBtn.setText("Search");
        SearchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtnActionPerformed(evt);
            }
        });

        homesearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homesearchActionPerformed(evt);
            }
        });
        homesearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                homesearchKeyReleased(evt);
            }
        });

        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Author", "Title", "Copyright"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(35);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(200);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(200);
            jTable1.getColumnModel().getColumn(1).setMinWidth(340);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(340);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(340);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homesearch, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(homesearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        jTabbedPane1.addTab("2", jPanel9);

        label2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label2.setText("Attendance Log");

        jTable2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Time in", "Time out", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setRowHeight(30);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
            jTable2.getColumnModel().getColumn(2).setResizable(false);
            jTable2.getColumnModel().getColumn(3).setResizable(false);
        }

        CheckBtn7.setBackground(java.awt.Color.blue);
        CheckBtn7.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        CheckBtn7.setForeground(java.awt.Color.white);
        CheckBtn7.setText("Save");
        CheckBtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBtn7ActionPerformed(evt);
            }
        });

        CheckBtn8.setBackground(java.awt.Color.blue);
        CheckBtn8.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        CheckBtn8.setForeground(java.awt.Color.white);
        CheckBtn8.setText("Add");
        CheckBtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBtn8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CheckBtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CheckBtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckBtn7)
                    .addComponent(CheckBtn8))
                .addContainerGap())
        );

        jTabbedPane1.addTab("0", jPanel10);

        InputValue2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        InputValue2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        InputValue2.setToolTipText("");
        InputValue2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputValue2ActionPerformed(evt);
            }
        });
        InputValue2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                InputValue2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                InputValue2KeyReleased(evt);
            }
        });

        SearchBtn2.setBackground(java.awt.Color.blue);
        SearchBtn2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        SearchBtn2.setForeground(java.awt.Color.white);
        SearchBtn2.setText("Search");
        SearchBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBtn2ActionPerformed(evt);
            }
        });

        jTable3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Number", "Time in", "Time out", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setRowHeight(30);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(1).setResizable(false);
            jTable3.getColumnModel().getColumn(2).setResizable(false);
            jTable3.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(InputValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(SearchBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InputValue2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(532, 532, 532))
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(28, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("2", jPanel11);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/library/STI_logo_40th(2) (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtn2ActionPerformed

         this.dispose();
        
    }//GEN-LAST:event_LogoutBtn2ActionPerformed

    private void CheckBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBtn3ActionPerformed
        
        jTabbedPane1.setSelectedIndex(4);
     
    }//GEN-LAST:event_CheckBtn3ActionPerformed

    private void CheckBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBtn4ActionPerformed
       
        GetCatalog get = new GetCatalog();
        get.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_CheckBtn4ActionPerformed

    private void CheckBtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBtn5ActionPerformed
        
        jTabbedPane1.setSelectedIndex(6);
        
    }//GEN-LAST:event_CheckBtn5ActionPerformed

    private void CheckBtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBtn6ActionPerformed
        
        jTabbedPane1.setSelectedIndex(7);
        
    }//GEN-LAST:event_CheckBtn6ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
         String selectedItem = (String) jComboBox1.getSelectedItem();
    if (selectedItem.equals("            Add Book")) {
        jTabbedPane1.setSelectedIndex(0);
    }
    
     if (selectedItem.equals("          Update Book")) {
        jTabbedPane1.setSelectedIndex(1);
    }
     
      if (selectedItem.equals("         Remove Book")) {
        jTabbedPane1.setSelectedIndex(2);
    }
      
       if (selectedItem.equals("            Issue Book")) {
        jTabbedPane1.setSelectedIndex(3);
 
        
          try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
        String selectt = "SELECT * FROM issuebook";

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

            //pag click ng combobox if kinilick ni librarian is issue laht ng nasa issuebook na database na may status na issued un lang makikita sa table.
            if (status.equals("Issued")) {
                String[] tbData = {Studentid, access, issue, Return, status};
                tb1Model.addRow(tbData);
            }
            
            
//declare ng mga value para magamit (date/time)
    Date currentDate = new Date();    

int rowCount = tb1Model.getRowCount();

SimpleDateFormat dtFormatt = new SimpleDateFormat("MMM-dd-yyyy | hh:mm:a");


for (int row = 0; row < rowCount; row++) {
    String date = (String) tb1Model.getValueAt(row, 3);
   
    Date returnDate = dtFormatt.parse(date); 
    
    String formattedCurrentDate = dtFormatt.format(currentDate);
String formattedReturnDate = dtFormatt.format(returnDate);

    System.out.println(formattedCurrentDate);
    System.out.println(formattedReturnDate);
    
    if (formattedCurrentDate.compareTo(formattedReturnDate) > 0) { 
        //to due date
       String insertt = "INSERT INTO duedate (studentid, access, issue_date, return_date, status, Fine) VALUES (?, ?, ?, ?, ?, ?)";
        String deleteQuery = "DELETE FROM issuebook WHERE studentid = ? AND return_date = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "");
             PreparedStatement insert = conn.prepareStatement(insertt);
             PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery)) {
            
            String Penalty = "5.00";
            
            insert.setString(1, Studentid);
            insert.setString(2, access);
            insert.setString(3, issue);
            insert.setString(4, date); 
            insert.setString(5, status);
            insert.setString(6, Penalty);
            insert.executeUpdate();

            deleteStatement.setString(1, Studentid);
            deleteStatement.setString(2, date); 
            deleteStatement.executeUpdate();
            
            Librariandashboard close = new Librariandashboard();
            close.setVisible(true);
            close.three();
            this.dispose();
           
                
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        
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
          
          catch (ParseException e) {
              
    System.out.println("Error parsing date: " + e.getMessage());
    
}

    }
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange
        
    }//GEN-LAST:event_jComboBox1PropertyChange

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked

        int row = jTable3.getSelectedRow();

        if (row != -1) {
            int option = JOptionPane.showConfirmDialog(null, "Do you want to see the details of this student?", "Student Details", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {

                String id_number = jTable3.getValueAt(row, 0).toString();

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
                    String sql = "SELECT * FROM StudentRegisteredAccount WHERE IdNumber = ?";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, id_number);

                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            StringBuilder data = new StringBuilder();
                            String firstname = resultSet.getString("firstname");
                            String lastname = resultSet.getString("lastname");
                            String course_section = resultSet.getString("course_section");
                            String email = resultSet.getString("email");
                            String address = resultSet.getString("address");
                            String IdNumber = resultSet.getString("IdNumber");

                            data.append("\n").append("   ").append("First Name:    ").append(firstname).append("\n").append("\n")
                            .append("   ").append("Last Name:    ").append(lastname).append("\n").append("\n")
                            .append("   ").append("Program & Section:    ").append(course_section).append("\n").append("\n")
                            .append("   ").append("Email:    ").append(email).append("\n").append("\n")
                            .append("   ").append("Address:    ").append(address).append("\n").append("\n")
                            .append("   ").append("ID Number:    ").append(IdNumber);

                            new StudentDetails(data.toString()).setVisible(true);

                        }

                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }

    }//GEN-LAST:event_jTable3MouseClicked

    private void SearchBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBtn2ActionPerformed

    private void InputValue2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputValue2KeyReleased
           
        String searchText = InputValue2.getText().trim();
        String sql = "SELECT * FROM attendancerecords WHERE LOWER(id_number) LIKE '%"+searchText.toLowerCase()+"%' OR LOWER(date) LIKE '%"+searchText.toLowerCase()+"%'";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    DefaultTableModel tb1Model = (DefaultTableModel) jTable3.getModel();
                    tb1Model.setRowCount(0);

                    while (rs.next()) {

                        String student = rs.getString("id_number");
                        String timein = rs.getString("timein");
                        String timeout = rs.getString("timeout");
                        String date = rs.getString("date");

                        String[] tbData = {student, timein, timeout, date};
                        tb1Model.addRow(tbData);
                        
                    }
                }
            }
        } 
        
        catch (SQLException e) {
            
            System.out.println("Error connecting to the database: " + e.getMessage());
            
        } 
        
        catch (Exception e) {
            
            System.out.println("Error: " + e.getMessage());
            
        }
        
    }//GEN-LAST:event_InputValue2KeyReleased

    private void InputValue2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputValue2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputValue2ActionPerformed

    private void CheckBtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBtn8ActionPerformed

        AddStudent close = new AddStudent();
        close.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_CheckBtn8ActionPerformed

    private void CheckBtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBtn7ActionPerformed
        
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int rowCount = model.getRowCount();

        if (rowCount > 0) {
            int result = JOptionPane.showConfirmDialog(null, "Save all rows to Attendance Records?", "Confirm Save", JOptionPane.YES_NO_OPTION);

            if (result == JOptionPane.YES_OPTION) {
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
                    String sql = "INSERT INTO attendancerecords (id_number, timein, timeout, date) VALUES (?, ?, ?, ?)";
                    PreparedStatement statement = conn.prepareStatement(sql);

                    for (int row = 0; row < rowCount; row++) {
                        String idnumber = (String) model.getValueAt(row, 0);
                        String timein = (String) model.getValueAt(row, 1);
                        String timeout = (String) model.getValueAt(row, 2);
                        String date = (String) model.getValueAt(row, 3);

                        statement.setString(1, idnumber);
                        statement.setString(2, timein);
                        statement.setString(3, timeout);
                        statement.setString(4, date);
                        statement.executeUpdate();

                    }

                }

                catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error saving data to Attendance Records: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {

                    String deleteQuery = "DELETE FROM attendancelog";
                    try (PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery)) {
                        deleteStatement.executeUpdate();
                        model.setRowCount(0);

                    }
                }

                catch (SQLException ex) {

                    System.out.println(ex.getMessage());
                }
                
                model.setRowCount(0);

                JOptionPane.showMessageDialog(null, "All rows saved to Attendance Records successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

               

            }

            if (result == JOptionPane.NO_OPTION) {

                System.out.println("hotdog");

            }
        }

        else {
            JOptionPane.showMessageDialog(null, "No rows to save", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_CheckBtn7ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int row = jTable2.getSelectedRow();
        if (row != -1) {
            int result = JOptionPane.showConfirmDialog(null, "Time out this row?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                
                SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:a");
                String timestamp = sdf.format(new Date());

                DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                model.setValueAt(timestamp, row, 2);
            }
        }

    }//GEN-LAST:event_jTable2MouseClicked

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseActionPerformed

    private void emailuserinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailuserinputActionPerformed

    }//GEN-LAST:event_emailuserinputActionPerformed

    private void RegUsernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegUsernameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegUsernameInputActionPerformed

    private void LastNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LastNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LastNameInputActionPerformed

    private void RegUserInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegUserInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegUserInputActionPerformed

    private void RegisterUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterUserBtnActionPerformed

        String sql = "INSERT INTO StudentRegisteredAccount (firstname, lastname, username, IdNumber, email, course_section, address) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "");
            PreparedStatement pstmt = conn.prepareStatement(sql)){
         
            String firstname = RegUserInput.getText();
            String lastname = LastNameInput.getText();
            String username = RegUsernameInput.getText();
            String IdNumber = RegIdUserInput.getText();
            String Email = emailuserinput.getText();
            String Course_Section = course.getText();
            String Address = address.getText();
           
            if (firstname.isEmpty() || lastname.isEmpty() || username.isEmpty() || IdNumber.isEmpty() || Email.isEmpty() || Course_Section.isEmpty() || Address.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            else {

                pstmt.setString(1, firstname);
                pstmt.setString(2, lastname);
                pstmt.setString(3, username);
                pstmt.setString(4, IdNumber);
                pstmt.setString(5, Email);
                pstmt.setString(6, Course_Section);
                pstmt.setString(7, Address);

                int rowsInserted = pstmt.executeUpdate();
                if (rowsInserted > 0) {

                    JOptionPane.showMessageDialog(this, "Registered Successful!", "Registered", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    Librariandashboard backtohome = new Librariandashboard();
                    backtohome.setVisible(true);
                    backtohome.register();

                }

                // Close the PreparedStatement and Connection
                pstmt.close();
                conn.close();
            }
        }
        catch (SQLException ex) {

            System.out.println("Error " + ex.getMessage());
        }
    }//GEN-LAST:event_RegisterUserBtnActionPerformed

    private void RegIdUserInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegIdUserInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RegIdUserInputActionPerformed

    private void SearchBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBtn3ActionPerformed

    private void homesearch2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_homesearch2KeyReleased
     String searchText = homesearch2.getText().trim();
    String sql = "SELECT * FROM CatalogBook WHERE LOWER(title) LIKE '%"+searchText.toLowerCase()+"%' OR LOWER(author) LIKE '%"+searchText.toLowerCase()+"%' OR LOWER(copyright) LIKE '%"+searchText.toLowerCase()+"%'";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "");
       PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {
        
                DefaultTableModel tb1Model = (DefaultTableModel) jTable5.getModel();
                tb1Model.setRowCount(0);

                
                while (rs.next()) {

                    String Title = rs.getString("title");
                    String Author = rs.getString("author");
                    String Copyright = rs.getString("copyright");
       

                    String[] tbData = {Author, Title, Copyright};
                    tb1Model.addRow(tbData);
           
        }
    } 
                
                catch (SQLException e) {
        System.out.println("Error connecting to the database: " + e.getMessage());
    } 
                
                    catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    }//GEN-LAST:event_homesearch2KeyReleased

    private void homesearch2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homesearch2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_homesearch2ActionPerformed

    private void jTable5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable5MouseEntered

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked

        int row = jTable5.getSelectedRow();
        if (row != -1) {
            int result = JOptionPane.showConfirmDialog(null, "Remove this book?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {

                String selectt = "SELECT * FROM CatalogBook WHERE title = ?";
                String deleteQuery = "DELETE FROM CatalogBook WHERE title = ?";

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "");
                    PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
                    PreparedStatement select = conn.prepareStatement(selectt)) {

                    DefaultTableModel model = (DefaultTableModel) jTable5.getModel();

                    String Title = (String) model.getValueAt(row, 1);
                    select.setString(1, Title);

                    ResultSet rs = select.executeQuery();

                    if(rs.next()) {

                        deleteStatement.setString(1, Title);
                        deleteStatement.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Delete Successful", "Success", JOptionPane.INFORMATION_MESSAGE);

                        model.removeRow(jTable5.getSelectedRow());

                    }

                }

                catch (SQLException ex) {

                    System.out.println(ex.getMessage());
                }

            }
        }

    }//GEN-LAST:event_jTable5MouseClicked

    private void addbookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbookBtnActionPerformed
        
        String selectt = "SELECT id1 FROM CatalogBook ORDER BY id1 DESC LIMIT 1";
        String sql1 = "INSERT INTO CatalogBook (isbn, accesionnumber, callnumber, title, author, edition, volume, pages, copyright, sourceoffund, publisher, placeofpublication, classification, librarycopies, remarks, id1) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sql2 = "INSERT INTO DefaultTable (author, title, copyright) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "");
            PreparedStatement select = conn.prepareStatement(selectt);
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            PreparedStatement pstmt2 = conn.prepareStatement(sql2)) {

           
            String isbn = isbnn.getText();
            String accesionnumber = accessionnumberr.getText();
            String callnumber = callnumberr.getText();
            String title = titlee.getText();
            String author = authorr.getText();
            String edition = editionn.getText();
            String volume = volumee.getText();
            String pages = pagess.getText();
            String copyright = copyrightt.getText();
            String sourceoffund = sourceoffundd.getText();
            String publisher = publisherr.getText();
            String placeofpublication = placeofpublicationn.getText();
            String classification = classificationn.getText();
            String librarycopies = librarycopiess.getText();
            String remarks = remarkss.getText();
  
           
            
            
            if (isbn.isEmpty() || accesionnumber.isEmpty() || callnumber.isEmpty() || title.isEmpty() || author.isEmpty() || edition.isEmpty() || volume.isEmpty() || pages.isEmpty() || copyright.isEmpty() || sourceoffund.isEmpty() || publisher.isEmpty() || placeofpublication.isEmpty() || classification.isEmpty() || librarycopies.isEmpty() || remarks.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields or input 0 in empty ones.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            else {
                
                
                pstmt1.setString(1, isbn);
                pstmt1.setString(2, accesionnumber);
                pstmt1.setString(3, callnumber);
                pstmt1.setString(4, title);
                pstmt1.setString(5, author);
                pstmt1.setString(6, edition);
                pstmt1.setString(7, volume);
                pstmt1.setString(8, pages);
                pstmt1.setString(9, copyright);
                pstmt1.setString(10, sourceoffund);
                pstmt1.setString(11, publisher);
                pstmt1.setString(12, placeofpublication);
                pstmt1.setString(13, classification);
                pstmt1.setString(14, librarycopies);
                pstmt1.setString(15, remarks);
                ResultSet rs = select.executeQuery();
        
               if(rs.next()) {
                int idbase = rs.getInt("id1"); 
                int id = idbase + 1; 

                pstmt1.setInt(16, id);
                pstmt1.executeUpdate();
               }
               
               
                pstmt2.setString(1, author);
                pstmt2.setString(2, title);
                pstmt2.setString(3, copyright);
                pstmt2.executeUpdate();
                
                JOptionPane.showMessageDialog(this, "Add Book Successful!", "Add Book", JOptionPane.INFORMATION_MESSAGE);
                Librariandashboard dashboard = new Librariandashboard();
                dashboard.setVisible(true);
                this.dispose();

            }

            pstmt1.close();
            pstmt2.close();
            conn.close();

        }

        catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_addbookBtnActionPerformed

    private void SearchBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtn1ActionPerformed

        String userInput = homesearch.getText();

        if (userInput.isEmpty()) {

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
                String sql = "SELECT * FROM DefaultTable";
                PreparedStatement pst = con.prepareStatement(sql);

                ResultSet rs = pst.executeQuery();

                DefaultTableModel tb1Model = (DefaultTableModel) jTable1.getModel();
                tb1Model.setRowCount(0);

                while (rs.next()) {
                    String author = rs.getString("Author");
                    String title = rs.getString("Title");
                    String copyright = rs.getString("Copyright");

                    String[] tbData = {author, title, copyright};
                    tb1Model.addRow(tbData);
                }
            }
            catch (SQLException e) {
                System.out.println("Error connecting to the database: " + e.getMessage());
            }
        } 
        
        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
                    String sql = "SELECT * FROM DefaultTable WHERE Title LIKE ? OR Copyright LIKE ? OR Author LIKE ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, "%" + userInput + "%");
                    pst.setString(2, "%" + userInput + "%");
                    pst.setString(3, "%" + userInput + "%");

                    ResultSet rs = pst.executeQuery();

                    DefaultTableModel tb1Model = (DefaultTableModel) jTable1.getModel();
                    tb1Model.setRowCount(0); // Clear existing table data

                    while (rs.next()) {
                        String author = rs.getString("Author");
                        String title = rs.getString("Title");
                        String copyright = rs.getString("Copyright");

                        String[] tbData = {author, title, copyright};
                        tb1Model.addRow(tbData);
                    }
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Error loading MySQL JDBC driver: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error connecting to the database: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_SearchBtn1ActionPerformed

    private void homesearch1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_homesearch1KeyReleased
String searchText = homesearch1.getText().trim();
    String sql = "SELECT * FROM CatalogBook WHERE LOWER(title) LIKE '%"+searchText.toLowerCase()+"%' OR LOWER(author) LIKE '%"+searchText.toLowerCase()+"%' OR LOWER(copyright) LIKE '%"+searchText.toLowerCase()+"%'";
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "");
       PreparedStatement pst = con.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {
        
                DefaultTableModel tb1Model = (DefaultTableModel) jTable4.getModel();
                tb1Model.setRowCount(0);

                
                while (rs.next()) {

                    String Title = rs.getString("title");
                    String Author = rs.getString("author");
                    String Copyright = rs.getString("copyright");
       

                    String[] tbData = {Author, Title, Copyright};
                    tb1Model.addRow(tbData);
           
        }
    } 
                
                catch (SQLException e) {
        System.out.println("Error connecting to the database: " + e.getMessage());
    } 
                
                    catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    }//GEN-LAST:event_homesearch1KeyReleased

    private void homesearch1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homesearch1ActionPerformed

    }//GEN-LAST:event_homesearch1ActionPerformed

    private void jTable4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseEntered

    }//GEN-LAST:event_jTable4MouseEntered

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked

        int row = jTable4.getSelectedRow();
        
     

        if (row != -1) {
            int option = JOptionPane.showConfirmDialog(null, "Do you want to Update this Book?", "Student Details", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {

                String Title = jTable4.getValueAt(row, 1).toString();

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
                    String sql = "SELECT * FROM CatalogBook WHERE title = ?";
                    PreparedStatement statement = conn.prepareStatement(sql);
                    statement.setString(1, Title);
                    

                    try (ResultSet resultSet = statement.executeQuery()) {
                        if (resultSet.next()) {
                            StringBuilder data = new StringBuilder();
                            String isbn = resultSet.getString("isbn");
                            String accesionnumber = resultSet.getString("accesionnumber");
                            String callnumber = resultSet.getString("callnumber");
                            String title = resultSet.getString("title");
                            String author = resultSet.getString("author");
                            String edition = resultSet.getString("edition");
                            String volume = resultSet.getString("volume");
                            String pages = resultSet.getString("pages");
                            String copyright = resultSet.getString("copyright");
                            String sourceoffund = resultSet.getString("sourceoffund");
                            String publisher = resultSet.getString("publisher");
                            String placeofpublication = resultSet.getString("placeofpublication");
                            String classification = resultSet.getString("classification");
                            String librarycopies = resultSet.getString("librarycopies");
                            String remarks = resultSet.getString("remarks");
                            String id = resultSet.getString("id1");

                            data.append("   ").append("ISBN:    ").append(isbn).append("\n").append("\n")
                            .append("   ").append("ACCESSION NUMBER:    ").append(accesionnumber).append("\n").append("\n")
                            .append("   ").append("CALL NUMBER:    ").append(callnumber).append("\n").append("\n")
                            .append("   ").append("TITLE:    ").append(title).append("\n").append("\n")
                            .append("   ").append("AUTHOR:    ").append(author).append("\n").append("\n")
                            .append("   ").append("EDITION:    ").append(edition).append("\n").append("\n")
                            .append("   ").append("VOLUME:    ").append(volume).append("\n").append("\n")
                            .append("   ").append("PAGES:    ").append(pages).append("\n").append("\n")
                            .append("   ").append("COPYRIGHT:    ").append(copyright).append("\n").append("\n")
                            .append("   ").append("SOURCE OF FUND:    ").append(sourceoffund).append("\n").append("\n")
                            .append("   ").append("PUBLISHER:    ").append(publisher).append("\n").append("\n")
                            .append("   ").append("Place of Publication:    ").append(placeofpublication).append("\n").append("\n")
                            .append("   ").append("CLASSIFICATION:    ").append(classification).append("\n").append("\n")
                            .append("   ").append("LIBRARY COPIES:    ").append(librarycopies).append("\n").append("\n")
                            .append("   ").append("REMARKS:    ").append(remarks).append("\n").append("\n")
                            .append("   ").append("Book Register # (not Editable):    ").append(id).append("\n").append("\n");

                            new Update(data.toString()).setVisible(true);
                            
                         
                            
                        }

                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            
          
}

            
        
    }//GEN-LAST:event_jTable4MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
         Librariandashboard close = new Librariandashboard();
        close.setVisible(true);
        close.one();

        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTable7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseClicked
       
       int row = jTable7.getSelectedRow();
        if (row != -1) {
            
            DefaultTableModel model = (DefaultTableModel) jTable7.getModel();
            
            int result = JOptionPane.showConfirmDialog(null, "Has the student already returned the book?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (result == JOptionPane.YES_OPTION) {
                String status = "Returned";
                
                model.setValueAt(status, row, 4);  
                
                String selectt = "SELECT * FROM issuebook WHERE studentid = ?";
                String updatee = "UPDATE issuebook set status = ? WHERE studentid = ?";
                
                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "");
                        PreparedStatement select = conn.prepareStatement(selectt);
                        PreparedStatement update = conn.prepareStatement(updatee)){
                    
                    String studentid = (String) model.getValueAt(row, 0);
                    String statuss = (String) model.getValueAt(row, 4);
                    
                    select.setString(1, studentid);
                    
                    ResultSet rs = select.executeQuery();
                    
                    while(rs.next()) {
                        
                        update.setString(1, statuss);
                        update.setString(2, studentid);
                        update.executeUpdate();
                        
                        model.removeRow(jTable7.getSelectedRow());
        
                    }
   
                } 
                
                catch (SQLException e) {
                    
                    System.out.println("Error " + e.getMessage());
                    
                }
                
                
             
            }
        }
    }//GEN-LAST:event_jTable7MouseClicked

    private void jTable7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable7MouseEntered

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        
        LendBook close = new LendBook();
        close.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        
        ReturnedBook close = new ReturnedBook();
        close.setVisible(true);
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void CheckBtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBtn9ActionPerformed
       
        Masterlist close = new Masterlist();
        close.setVisible(true);
    
        
    }//GEN-LAST:event_CheckBtn9ActionPerformed

    private void SearchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBtnActionPerformed

        String userInput = homesearch.getText();

        if (userInput.isEmpty()) {

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
                String sql = "SELECT * FROM DefaultTable";
                PreparedStatement pst = con.prepareStatement(sql);

                ResultSet rs = pst.executeQuery();

                DefaultTableModel tb1Model = (DefaultTableModel) jTable1.getModel();
                tb1Model.setRowCount(0);

                while (rs.next()) {
                    String author = rs.getString("Author");
                    String title = rs.getString("Title");
                    String copyright = rs.getString("Copyright");

                    String[] tbData = {author, title, copyright};
                    tb1Model.addRow(tbData);
                }
            }
            catch (SQLException e) {
                System.out.println("Error connecting to the database: " + e.getMessage());
            }
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
                    String sql = "SELECT * FROM DefaultTable WHERE Title LIKE ? OR Copyright LIKE ? OR Author LIKE ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    pst.setString(1, "%" + userInput + "%");
                    pst.setString(2, "%" + userInput + "%");
                    pst.setString(3, "%" + userInput + "%");

                    ResultSet rs = pst.executeQuery();

                    DefaultTableModel tb1Model = (DefaultTableModel) jTable1.getModel();
                    tb1Model.setRowCount(0); // Clear existing table data

                    while (rs.next()) {
                        String author = rs.getString("Author");
                        String title = rs.getString("Title");
                        String copyright = rs.getString("Copyright");

                        String[] tbData = {author, title, copyright};
                        tb1Model.addRow(tbData);
                    }
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Error loading MySQL JDBC driver: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error connecting to the database: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_SearchBtnActionPerformed

    private void homesearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_homesearchKeyReleased

        String searchText = homesearch.getText().trim();
        String sql = "SELECT * FROM defaulttable WHERE LOWER(title) LIKE '%" + searchText.toLowerCase() + "%'";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/TestInfo", "root", "")) {
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    DefaultTableModel tb1Model = (DefaultTableModel) jTable1.getModel();
                    tb1Model.setRowCount(0);

                    while (rs.next()) {

                        String Author = rs.getString("author");
                        String Title = rs.getString("title");
                        String Copyright = rs.getString("copyright");

                        String[] tbData = {Author, Title, Copyright};
                        tb1Model.addRow(tbData);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//GEN-LAST:event_homesearchKeyReleased

    private void homesearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homesearchActionPerformed

    }//GEN-LAST:event_homesearchActionPerformed

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked

    Overdue close = new Overdue();
    close.setVisible(true);
      
    }//GEN-LAST:event_jPanel13MouseClicked

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseEntered

    private void InputValue2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_InputValue2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputValue2KeyPressed

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
            java.util.logging.Logger.getLogger(Librariandashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Librariandashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Librariandashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Librariandashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Librariandashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CheckBtn3;
    private javax.swing.JButton CheckBtn4;
    private javax.swing.JButton CheckBtn5;
    private javax.swing.JButton CheckBtn6;
    private javax.swing.JButton CheckBtn7;
    private javax.swing.JButton CheckBtn8;
    private javax.swing.JButton CheckBtn9;
    private java.awt.Label CreatePasswordInput1;
    private java.awt.Label CreatePasswordInput2;
    private java.awt.Label CreatePasswordInput3;
    private java.awt.Label FirstName;
    private java.awt.Label IDNumberInput;
    private javax.swing.JTextField InputValue2;
    private java.awt.Label LastName;
    private java.awt.Label LastName1;
    private javax.swing.JTextField LastNameInput;
    private javax.swing.JButton LogoutBtn2;
    private javax.swing.JTextField RegIdUserInput;
    private javax.swing.JTextField RegUserInput;
    private javax.swing.JTextField RegUsernameInput;
    private javax.swing.JButton RegisterUserBtn;
    private javax.swing.JButton SearchBtn;
    private javax.swing.JButton SearchBtn1;
    private javax.swing.JButton SearchBtn2;
    private javax.swing.JButton SearchBtn3;
    private org.netbeans.lib.awtextra.AbsoluteLayout absoluteLayout1;
    private javax.swing.JTextField accessionnumberr;
    private javax.swing.JButton addbookBtn;
    private javax.swing.JTextField address;
    private javax.swing.JTextField authorr;
    private javax.swing.JTextField callnumberr;
    private javax.swing.JTextField classificationn;
    private javax.swing.JTextField copyrightt;
    private javax.swing.JLabel count;
    private javax.swing.JTextField course;
    private javax.swing.JTextField editionn;
    private javax.swing.JTextField emailuserinput;
    private javax.swing.JTextField homesearch;
    private javax.swing.JTextField homesearch1;
    private javax.swing.JTextField homesearch2;
    private javax.swing.JTextField isbnn;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable7;
    private javax.swing.JToolBar jToolBar1;
    private java.awt.Label label1;
    private java.awt.Label label19;
    private java.awt.Label label2;
    private java.awt.Label label20;
    private java.awt.Label label21;
    private java.awt.Label label22;
    private java.awt.Label label23;
    private java.awt.Label label24;
    private java.awt.Label label25;
    private java.awt.Label label26;
    private java.awt.Label label27;
    private java.awt.Label label28;
    private java.awt.Label label29;
    private java.awt.Label label30;
    private java.awt.Label label31;
    private java.awt.Label label32;
    private java.awt.Label label33;
    private javax.swing.JTextField librarycopiess;
    private javax.swing.JTextField pagess;
    private javax.swing.JTextField placeofpublicationn;
    private javax.swing.JTextField publisherr;
    private javax.swing.JTextField remarkss;
    private javax.swing.JTextField sourceoffundd;
    private javax.swing.JTextField titlee;
    private javax.swing.JTextField volumee;
    // End of variables declaration//GEN-END:variables
}
