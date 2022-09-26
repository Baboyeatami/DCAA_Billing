/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dcaa_billing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jamie Eduardo Rosal <Jamiewertalmighty@gmail.com>
 */
public class Student_List extends javax.swing.JInternalFrame {

    DefaultComboBoxModel SYcomBoxModel;
    DefaultTableModel tableModel = new DefaultTableModel();
    TableColumnModel TCM;
    public int ID;
    public String UserID;
    String StudentId;
    Batch_posting batchP = null;
    Statements payment_History = null;
    MainFrame main;
    StudentInfo_new studentInfo = null;
    JMenuItem Bill = new JMenuItem("Bill Student");
    JMenuItem PaymentH = new JMenuItem("View Payment History");
    JMenuItem StudentI = new JMenuItem("View Student Information");
    JMenuItem Balances = new JMenuItem("View Balance");
    JMenuItem DeleteStudent = new JMenuItem("Delete Student");
    Balances balances;
    Batch_Payment batch_Payment = null;
    boolean Registrar = false, Prinsipal = false;
    ArrayList<String> Sydisplay = new ArrayList<>(), idSydisplay = new ArrayList<>();

    JPopupMenu menu = new JPopupMenu();
//

    /**
     * Creates new form StudentInfo
     */
    public Student_List() {

        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        setBorder(null);
        // LoadSY();
        tableModel = (DefaultTableModel) Table1.getModel();
        TCM = Table1.getColumnModel();
        TCM.getColumn(0).setPreferredWidth(0);
        LoadSY();

        Bill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentBill studentBill = null;
                if (Casher) {
                    studentBill = new StudentBill();
                    studentBill.Set_casherMode(true);
                    studentBill.UserId = UserID;
                    studentBill.set_ID(StudentId);
                    studentBill.setVisible(true);
                } else {
                    studentBill = new StudentBill();
                    studentBill.UserId = UserID;
                    studentBill.set_ID(StudentId);
                    studentBill.setVisible(true);

                }
            }
        });

        PaymentH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (payment_History == null) {
                    payment_History = new Statements();
                    payment_History.setBounds(62, -1, 1100, 550);
                    payment_History.set_id(StudentId);
                    Display_StatementWindow(main);
                    payment_History.setVisible(true);
                } else {
                    payment_History.setBounds(62, -1, 1100, 550);
                    payment_History.set_id(StudentId);
                    Display_StatementWindow(main);
                    payment_History.setVisible(true);

                }

            }
        });

        StudentI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    if (studentInfo == null) {

                        studentInfo = new StudentInfo_new();
                        studentInfo.UserId = UserID;
                        main.DesktopPane.add(studentInfo);
                        studentInfo.setBounds(56, 7, 1067, 535);
                        studentInfo.loadInformation(StudentId);
                        studentInfo.setVisible(true);

                    } else {
                        main.DesktopPane.add(studentInfo);
                        studentInfo.UserId = UserID;
                        studentInfo.setBounds(56, 7, 1067, 535);
                        studentInfo.loadInformation(StudentId);
                        studentInfo.setVisible(true);
                    }

                } catch (ParseException ex) {
                    Logger.getLogger(Student_List.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Balances.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (balances == null) {
                    balances = new Balances();
                    balances.Display_StatementWindow(main);
                    balances.load_Balance(StudentId);
                    balances.setVisible(true);

                } else {
                    balances.dispose();
                    balances = new Balances();
                    balances.Display_StatementWindow(main);
                    balances.load_Balance(StudentId);
                    balances.setVisible(true);

                }

            }
        });
        DeleteStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DeleteStudent(StudentId);
            }
        });

        menu.add(Bill);
        menu.add(PaymentH);
        menu.add(StudentI);
        menu.add(Balances);
        menu.add(DeleteStudent);

        Table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    menu.show(e.getComponent(), e.getX(), e.getY());

                }

            }

        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        StudentID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SearchCreteria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        searchKey = new javax.swing.JTextField();
        SchoolYear = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        RStudentId = new javax.swing.JRadioButton();
        RLastName = new javax.swing.JRadioButton();
        RGrade = new javax.swing.JRadioButton();
        Rstatus = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(22, 27, 34));
        setClosable(true);
        setIconifiable(true);
        setTitle("Billing");
        setMaximumSize(new java.awt.Dimension(1200, 550));
        setMinimumSize(new java.awt.Dimension(1200, 550));
        setPreferredSize(new java.awt.Dimension(1200, 550));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton1.setText("Billing");
        jButton1.setMaximumSize(new java.awt.Dimension(64, 60));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton3.setText("Payment History");
        jButton3.setMaximumSize(new java.awt.Dimension(64, 60));
        jButton3.setPreferredSize(new java.awt.Dimension(64, 32));
        jButton3.setSelected(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton4.setText("Student Information");
        jButton4.setMaximumSize(new java.awt.Dimension(64, 60));
        jButton4.setPreferredSize(new java.awt.Dimension(64, 32));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton5.setText("Close");
        jButton5.setMaximumSize(new java.awt.Dimension(64, 60));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton2.setText("Batch Posting");
        jButton2.setMaximumSize(new java.awt.Dimension(64, 60));
        jButton2.setPreferredSize(new java.awt.Dimension(64, 32));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton6.setText("Account Balance");
        jButton6.setMaximumSize(new java.awt.Dimension(64, 60));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton7.setText("Batch Payment");
        jButton7.setMaximumSize(new java.awt.Dimension(64, 60));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        Table1.setBackground(new java.awt.Color(46, 46, 56));
        Table1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Table1.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        Table1.setForeground(new java.awt.Color(255, 255, 255));
        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student ID", "Name", "Grade", "Status"
            }
        ));
        Table1.setGridColor(new java.awt.Color(41, 41, 49));
        Table1.setSelectionBackground(new java.awt.Color(0, 153, 255));
        Table1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        Table1.setShowHorizontalLines(true);
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        jPanel2.setBackground(new java.awt.Color(13, 17, 23));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        StudentID.setBackground(new java.awt.Color(255, 255, 255));
        StudentID.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        StudentID.setForeground(new java.awt.Color(0, 0, 0));
        StudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StudentIDActionPerformed(evt);
            }
        });
        StudentID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                StudentIDKeyReleased(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Student ID:");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Search by:");

        SearchCreteria.setBackground(new java.awt.Color(22, 27, 34));
        SearchCreteria.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        SearchCreteria.setForeground(new java.awt.Color(255, 255, 255));
        SearchCreteria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First Name", "Last Name", "Grade Level", "School Year", " " }));
        SearchCreteria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SearchCreteriaItemStateChanged(evt);
            }
        });
        SearchCreteria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchCreteriaActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter Keyword:");

        searchKey.setBackground(new java.awt.Color(255, 255, 255));
        searchKey.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        searchKey.setForeground(new java.awt.Color(255, 51, 51));
        searchKey.setToolTipText("Search Here");
        searchKey.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        searchKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchKeyActionPerformed(evt);
            }
        });

        SchoolYear.setBackground(new java.awt.Color(22, 27, 34));
        SchoolYear.setForeground(new java.awt.Color(255, 255, 255));
        SchoolYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SchoolYear.setEnabled(false);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("School Year:");

        jButton8.setText("Print List");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Note: If search by School Year, Last name is used as  keyword");

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup1.add(RStudentId);
        RStudentId.setText("Student ID");
        RStudentId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RStudentIdItemStateChanged(evt);
            }
        });
        RStudentId.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                RStudentIdStateChanged(evt);
            }
        });

        buttonGroup1.add(RLastName);
        RLastName.setText("Name");
        RLastName.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RLastNameItemStateChanged(evt);
            }
        });

        buttonGroup1.add(RGrade);
        RGrade.setText("Grade");
        RGrade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RGradeItemStateChanged(evt);
            }
        });

        buttonGroup1.add(Rstatus);
        Rstatus.setText("Status");
        Rstatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RstatusItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RStudentId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RLastName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RGrade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Rstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RStudentId)
                    .addComponent(RLastName)
                    .addComponent(RGrade)
                    .addComponent(Rstatus)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SchoolYear, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StudentID, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(SearchCreteria, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(searchKey, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(StudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchCreteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SchoolYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Billing ");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if (payment_History == null) {
            payment_History = new Statements();
            payment_History.setBounds(62, -1, 1100, 550);
            payment_History.set_id(StudentId);
            Display_StatementWindow(main);
            payment_History.setVisible(true);
        } else {
            payment_History.setBounds(62, -1, 1100, 550);
            payment_History.set_id(StudentId);
            Display_StatementWindow(main);
            payment_History.setVisible(true);

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void SearchCreteriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchCreteriaActionPerformed

    }//GEN-LAST:event_SearchCreteriaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        StudentBill studentBill = null;
        if (Casher) {
            studentBill = new StudentBill();
            studentBill.Set_casherMode(true);
            studentBill.UserId = UserID;
            studentBill.set_ID(StudentId);
            studentBill.setVisible(true);
        } else {
            studentBill = new StudentBill();
            studentBill.UserId = UserID;
            studentBill.set_ID(StudentId);
            studentBill.setVisible(true);

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        System.out.println(String.valueOf(tableModel.getValueAt(Table1.getSelectedRow(), 0)));
        StudentId = String.valueOf(tableModel.getValueAt(Table1.getSelectedRow(), 0));

    }//GEN-LAST:event_Table1MouseClicked

    private void searchKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchKeyActionPerformed

        if (SearchCreteria.getSelectedItem().equals("First Name")) {
            loadSearchData_FirstName();
        } else if (SearchCreteria.getSelectedItem().equals("Last Name")) {
            loadSearchData_Lastnme();
        } else if (SearchCreteria.getSelectedItem().equals("Grade Level")) {
            loadSearchData_GradeLevel();
        } else if (SearchCreteria.getSelectedItem().equals("School Year")) {
            SchoolYear.setEnabled(true);
            Search_Student_LastName_in_SY();
        }
    }//GEN-LAST:event_searchKeyActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {

            if (studentInfo == null && !Prinsipal) {

                studentInfo = new StudentInfo_new();
                studentInfo.UserId = UserID;
                main.DesktopPane.add(studentInfo);
                studentInfo.setBounds(56, 7, 1067, 535);
                studentInfo.loadInformation(StudentId);
                studentInfo.setVisible(true);

            } else if (studentInfo == null && Prinsipal) {
                studentInfo = new StudentInfo_new();
                studentInfo.UserId = UserID;
                main.DesktopPane.add(studentInfo);
                studentInfo.setBounds(56, 7, 1067, 535);
                studentInfo.loadInformation(StudentId);
                studentInfo.setVisible(true);
                studentInfo.jButton2.setVisible(false);

            } else if (Prinsipal) {
                studentInfo = new StudentInfo_new();
                studentInfo.UserId = UserID;
                main.DesktopPane.add(studentInfo);
                studentInfo.setBounds(56, 7, 1067, 535);
                studentInfo.loadInformation(StudentId);
                studentInfo.setVisible(true);
                studentInfo.jButton2.setVisible(false);

            } else {
                main.DesktopPane.add(studentInfo);
                studentInfo.UserId = UserID;
                studentInfo.setBounds(56, 7, 1067, 535);
                studentInfo.loadInformation(StudentId);
                studentInfo.setVisible(true);
            }

        } catch (ParseException ex) {
            Logger.getLogger(Student_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (batchP == null) {
            batchP = new Batch_posting();
            batchP.Userid = UserID;
            main.DesktopPane.add(batchP);
            batchP.setVisible(true);

        } else {
            batchP.Userid = UserID;
            main.DesktopPane.add(batchP);
            batchP.setVisible(true);

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        System.out.println("Registrar Mode:" + Registrar);
        if (balances == null && !Prinsipal) {
            balances = new Balances();
            if (Registrar) {
                balances.Set_registar_mode(Registrar);
                System.out.println("Registrar Mode:" + Registrar);
            }

            balances.Display_StatementWindow(main);
            balances.load_Balance(StudentId);
            balances.setVisible(true);
            balances.setAlwaysOnTop(true);

        } else if (Prinsipal) {
            balances = new Balances();
            if (Registrar) {
                balances.Set_registar_mode(Registrar);
                System.out.println("Prinsipal Mode" + Prinsipal);
            }

            balances.Display_StatementWindow(main);
            balances.load_Balance(StudentId);
            balances.setVisible(true);
            balances.setAlwaysOnTop(true);
            balances.set_PrisipalModel(true);

        } else {
            if (Registrar) {
                balances.Set_registar_mode(Registrar);
                System.out.println("Registrar Mode:" + Registrar);
            }
            balances.Display_StatementWindow(main);
            balances.load_Balance(StudentId);
            balances.setVisible(true);
            balances.setAlwaysOnTop(true);

        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void StudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StudentIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StudentIDActionPerformed

    private void StudentIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StudentIDKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loadSearchData();
        } else if (SchoolYear.isEnabled()) {
            Search_Student_in_SY();
        }
    }//GEN-LAST:event_StudentIDKeyReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (batch_Payment == null) {
            batch_Payment = new Batch_Payment();
            batch_Payment.Userid = UserID;
            batch_Payment.setVisible(true);
        } else {
            batch_Payment.Userid = UserID;
            batch_Payment.setVisible(true);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void SearchCreteriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_SearchCreteriaItemStateChanged
        if (SearchCreteria.getSelectedItem().equals("School Year")) {
            SchoolYear.setEnabled(true);
        } else {
            SchoolYear.setEnabled(false);
        }
    }//GEN-LAST:event_SearchCreteriaItemStateChanged

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            PrintStudent_list();
        } catch (SQLException ex) {
            Logger.getLogger(Student_List.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void RStudentIdStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_RStudentIdStateChanged

    }//GEN-LAST:event_RStudentIdStateChanged

    private void RStudentIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RStudentIdItemStateChanged
        // TODO add your handling code here:
        SortDataSearth();
    }//GEN-LAST:event_RStudentIdItemStateChanged

    private void RLastNameItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RLastNameItemStateChanged
        SortDataSearth();
    }//GEN-LAST:event_RLastNameItemStateChanged

    private void RGradeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RGradeItemStateChanged
        SortDataSearth();
    }//GEN-LAST:event_RGradeItemStateChanged

    private void RstatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RstatusItemStateChanged
        SortDataSearth();
    }//GEN-LAST:event_RstatusItemStateChanged

    private void loadSearchData() {
        try {

            tableModel.setRowCount(0);
            String S = "%" + StudentID.getText() + "%";
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where id like '" + S + "' AND f_name is not Null  Order by create_time DESC limit 30");
            rs = ps.executeQuery();
            while (rs.next()) {
                tableModel.addRow(new Object[]{rs.getString(2), rs.getString("L_name") + ", " + rs.getString("F_name") + " " + rs.getString("M_name"), rs.getString(6), rs.getString(7)});
            }
        } catch (SQLException e) {
            System.out.println(e);

        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    void Activity_log(String Transaction, String Number) {

        try {
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;
            String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

            ps = c.prepareStatement("Insert into activity_log ( Activity_name, Description, Date, UseAccounts_idUseAccounts) values ('" + Transaction + "','" + StudentId + "','" + timeStamp + "','" + UserID + "')");
            ps.execute();
            System.out.println("Deleted activity loged ");

        } catch (SQLException ex) {
            Logger.getLogger(Section.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void LoadSY() {

        try {

            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs = null;

            ps = c.prepareStatement("Select idschool_year,School_Year,Semester from school_year");
            rs = ps.executeQuery();
            while (rs.next()) {
                Sydisplay.add(rs.getString(2) + "-" + rs.getString(3));
                idSydisplay.add(rs.getString(1));
            }

            rs.close();

            SYcomBoxModel = new DefaultComboBoxModel(Sydisplay.toArray());
            SchoolYear.setModel(SYcomBoxModel);
            System.out.println(idSydisplay);

        } catch (SQLException ex) {
            Logger.getLogger(Addcategories.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void Display_StatementWindow(MainFrame frame) {
        main = frame;
        main.DesktopPane.add(payment_History);

    }

    void Display_StudentInfo(MainFrame frame) {
        main = frame;
        main.DesktopPane.add(studentInfo);

    }

    void DeleteStudent(String id) {

        try {

            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;

            int op = JOptionPane.showConfirmDialog(this, "Before Data will be deleted please check balances \n Do you want to Continue?", "Student Data Delete Procedure", JOptionPane.YES_NO_OPTION);

            if (op == 0) {
                ps = c.prepareStatement("Update student_info set   F_name=NULL, M_name=NULL, L_name=NULL where id='" + id + "'");
                ps.execute();
                JOptionPane.showMessageDialog(this, "Student info Deleted!");
            } else {

                JOptionPane.showMessageDialog(this, "Student deletion cancelled");

            }

            Activity_log("Deleted Student with Id", id);

            loadSearchData();
        } catch (SQLException ex) {
            Logger.getLogger(Student_List.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadSearchData_Lastnme() {
        try {

            tableModel.setRowCount(0);
            String S = "%" + searchKey.getText() + "%";
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where L_name like '" + S + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                tableModel.addRow(new Object[]{rs.getString(2), rs.getString("L_name") + ", " + rs.getString("F_name") + " " + rs.getString("M_name"), rs.getString(6), rs.getString(7)});
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void loadSearchData_GradeLevel() {
        try {

            tableModel.setRowCount(0);
            String S = "%" + searchKey.getText() + "%";
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;
            ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where GradeLevel like '" + S + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                tableModel.addRow(new Object[]{rs.getString(2), rs.getString("L_name") + ", " + rs.getString("F_name") + " " + rs.getString("M_name"), rs.getString(6), rs.getString(7)});
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    boolean Casher = false;

    void set_casher_mode() {
        Casher = true;
        menu.remove(DeleteStudent);
        //sdf
    }

    void set_Prinsipal_() {
        jButton1.setVisible(false);
        jButton3.setVisible(false);
        jButton2.setVisible(false);
        jButton7.setVisible(false);
        menu.removeAll();
    }

    void set_RegistrarMode() {
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton7.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        menu.remove(Bill);
        menu.remove(PaymentH);
        menu.remove(DeleteStudent);
        menu.remove(Balances);

        Registrar = true;
    }

    void set_PrinciaplMode() {
        jButton1.setVisible(false);
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton7.setVisible(false);
        jButton6.setVisible(false);
        menu.remove(Bill);
        menu.remove(PaymentH);
        menu.remove(DeleteStudent);
        Prinsipal = true;
    }

    private void SortDataSearth() {
        try {

            tableModel.setRowCount(0);
            String S = "%" + searchKey.getText() + "%";
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;

            if (RStudentId.isSelected() && SearchCreteria.getSelectedIndex() == 0) {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where F_name like '" + S + "' order by  idStudent_Info");
            } else if (RStudentId.isSelected() && SearchCreteria.getSelectedIndex() == 1) {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where L_name like '" + S + "' order by  idStudent_Info");
            } else if (RStudentId.isSelected() && SearchCreteria.getSelectedIndex() == 2) {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where GradeLevel like '" + S + "' order by  idStudent_Info");
            } else if (RLastName.isSelected() && SearchCreteria.getSelectedIndex() == 0) {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where F_name like '" + S + "' order by  F_name");
            } else if (RLastName.isSelected() && SearchCreteria.getSelectedIndex() == 1) {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where L_name like '" + S + "' order by  F_name");
            } else if (RLastName.isSelected() && SearchCreteria.getSelectedIndex() == 2) {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where GradeLevel like '" + S + "' order by  F_name");
            } else if (RGrade.isSelected() && SearchCreteria.getSelectedIndex() == 0) {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where F_name like '" + S + "' order by GradeLevel");
            } else if (RGrade.isSelected() && SearchCreteria.getSelectedIndex() == 1) {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where L_name like '" + S + "' order by  GradeLevel");
            } else if (RGrade.isSelected() && SearchCreteria.getSelectedIndex() == 2) {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where GradeLevel like '" + S + "' order by  GradeLevel");
            } else if (Rstatus.isSelected() && SearchCreteria.getSelectedIndex() == 0) {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where F_name like '" + S + "' order by Status");
            } else if (Rstatus.isSelected() && SearchCreteria.getSelectedIndex() == 1) {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where L_name like '" + S + "' order by  Status");
            } else if (Rstatus.isSelected() && SearchCreteria.getSelectedIndex() == 2) {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where GradeLevel like '" + S + "' order by  Status");
            } else {
                ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where F_name like '" + S + "' order by  F_name");

            }

            //ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where F_name like '" + S + "' ");
            rs = ps.executeQuery();
            while (rs.next()) {
                tableModel.addRow(new Object[]{rs.getString(2), rs.getString("L_name") + ", " + rs.getString("F_name") + " " + rs.getString("M_name"), rs.getString(6), rs.getString(7)});
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void loadSearchData_FirstName() {
        try {

            tableModel.setRowCount(0);
            String S = "%" + searchKey.getText() + "%";
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps;
            ResultSet rs;

            ps = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where F_name like '" + S + "'");
            rs = ps.executeQuery();
            while (rs.next()) {
                tableModel.addRow(new Object[]{rs.getString(2), rs.getString("L_name") + ", " + rs.getString("F_name") + " " + rs.getString("M_name"), rs.getString(6), rs.getString(7)});
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    void Search_Student_in_SY() {
        try {
            tableModel.setRowCount(0);
            String S = "%" + searchKey.getText() + "%";
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT distinct Student_Info_idStudent_Info FROM dcaa_databse.billing where School_Year_idSchool_Year='" + idSydisplay.get(SchoolYear.getSelectedIndex()) + "'");
            ResultSet rs = ps.executeQuery();
            PreparedStatement ps1;
            ResultSet rs1;
            while (rs.next()) {
                ps1 = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where id  like '" + S + "' and IS NOT NULL");
                rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    tableModel.addRow(new Object[]{rs.getString(2), rs.getString("L_name") + ", " + rs.getString("F_name") + " " + rs.getString("M_name"), rs.getString(6), rs.getString(7)});
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student_List.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void Search_Student_LastName_in_SY() {
        try {
            tableModel.setRowCount(0);
            String S = "%" + searchKey.getText() + "%";
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement("Select id from student_info where L_name  like '" + S + "'");
            ResultSet rs = ps.executeQuery();

            PreparedStatement ps1;
            ResultSet rs1;

            while (rs.next()) {

                ps1 = c.prepareStatement("SELECT distinct Student_Info_idStudent_Info FROM dcaa_databse.billing where School_Year_idSchool_Year='" + idSydisplay.get(SchoolYear.getSelectedIndex()) + "' And Student_Info_idStudent_Info='" + rs.getString(1) + "'");
                rs1 = ps1.executeQuery();
                while (rs1.next()) {
                    System.out.println(rs1.getString(1));
                    ps1 = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where id = '" + rs1.getString(1) + "'");
                    rs1 = ps1.executeQuery();
                    if (rs1.next()) {
                        tableModel.addRow(new Object[]{rs1.getString(2), rs1.getString("L_name") + ", " + rs1.getString("F_name") + " " + rs1.getString("M_name"), rs1.getString(6), rs1.getString(7)});
                    }
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(Student_List.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void Load_Student_in_SY() {
        try {
            tableModel.setRowCount(0);
            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT distinct Student_Info_idStudent_Info FROM dcaa_databse.billing where School_Year_idSchool_Year='" + idSydisplay.get(SchoolYear.getSelectedIndex()) + "'");
            ResultSet rs = ps.executeQuery();
            PreparedStatement ps1;
            ResultSet rs1;
            while (rs.next()) {
                ps1 = c.prepareStatement("Select idStudent_Info,id,F_name,M_name,L_name,GradeLevel,Status from student_info where id = '" + 3 + "'");
                rs1 = ps1.executeQuery();
                if (rs1.next()) {
                    tableModel.addRow(new Object[]{rs.getString(2), rs.getString("L_name") + ", " + rs.getString("F_name") + " " + rs.getString("M_name"), rs.getString(6), rs.getString(7)});
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student_List.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void PrintStudent_list() throws SQLException {
        try {
            JasperReport JR;
            JasperPrint JP;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            DBConnection.init();
            Connection c = DBConnection.getConnection();
            PreparedStatement ps, ps1;
            ResultSet rs, rs1 = null;

            // String Q="%"+this.txtSearch.getText() +"%";
            // String Source="C:\\Users\\JAMIEXXX3\\Documents\\NetBeansProjects\\Phonelist\\src\\Forms\\report1.jrxml";
            JasperDesign Jd = JRXmlLoader.load(System.getProperty("user.dir") + "\\\\reports\\\\Student_List.jrxml");
            String Location = System.getProperty("user.dir") + "\\\\reports\\\\";
            String SQL = "SELECT distinct Student_Info_idStudent_Info FROM dcaa_databse.billing where School_Year_idSchool_Year='" + idSydisplay.get(SchoolYear.getSelectedIndex()) + "'";

            JRDesignQuery JQ = new JRDesignQuery();
            JQ.setText(SQL);
            Jd.setQuery(JQ);
            JR = JasperCompileManager.compileReport(Jd);

            HashMap m = new HashMap<>();

            m.put("Section_Details", "School Year: " + Sydisplay.get(SchoolYear.getSelectedIndex()));
            m.put("SUBREPORT_DIR", Location);
            // m.put("SY", SchoolYear.getSelectedItem());
            //m.put("SY", SchoolYear.getSelectedItem().toString());
            // m.put("Description", );
            JP = JasperFillManager.fillReport(JR, m, DBConnection.getConnection());

            JasperViewer.viewReport(JP, false);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(this, ex);
            System.out.println(ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RGrade;
    private javax.swing.JRadioButton RLastName;
    private javax.swing.JRadioButton RStudentId;
    private javax.swing.JRadioButton Rstatus;
    private javax.swing.JComboBox<String> SchoolYear;
    private javax.swing.JComboBox<String> SearchCreteria;
    private javax.swing.JTextField StudentID;
    private javax.swing.JTable Table1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchKey;
    // End of variables declaration//GEN-END:variables
}
