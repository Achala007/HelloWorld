/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cstute;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ramzan Dieze
 */
public class viewEmployeeList extends javax.swing.JFrame {

    /**
     * Creates new form viewCustomerList
     */
    DefaultTableModel model;

    public viewEmployeeList() {
        initComponents();
        getContentPane().setBackground(Color.GRAY);
        setTitle("eBank");
        ImageIcon img = new ImageIcon("src/icon.png");
        this.setLocationRelativeTo(null);
        model = (DefaultTableModel) jTable1.getModel();
        insertToTable();
    }

    public void insertToTable() {
        List<String> customerDetails = retrieveEmployeeList();
        for (String emp : customerDetails) {
            model.insertRow(model.getRowCount(), new Object[]{emp.split("&")[0], emp.split("&")[1], emp.split("&")[2]});
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        manageEmployee = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Postion", "Username"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        manageEmployee.setText("Manage");
        manageEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeActionPerformed(evt);
            }
        });

        

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manageEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeActionPerformed
        // TODO add your handling code here:
        EmployeeUp.startEmp();
        dispose();
    }//GEN-LAST:event_manageEmployeeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void viewEmpList() {
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewEmployeeList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton manageEmployee;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<java.lang.String> retrieveEmployeeList() {
        ebank.RetrieveData_Service service = new ebank.RetrieveData_Service();
        ebank.RetrieveData port = service.getRetrieveDataPort();
        return port.retrieveEmployeeList();
    }

    
}
