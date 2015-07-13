/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.lp.caller.gui;

import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import ual.lp.caller.mgr.CallerMGR;
import ual.lp.caller.rmi.CallerInf;
import ual.lp.caller.rmi.ClientRMI;
import ual.lp.caller.utils.Config;
import ual.lp.exceptions.BadConfigurationException;
import ual.lp.exceptions.NoTicketsException;
import ual.lp.server.objects.Employee;
import ual.lp.server.objects.Ticket;
import ual.lp.server.rmi.ServerInf;

/**
 *
 * @author Divanio Silva
 */
public class CallerGUI extends javax.swing.JFrame {

    static final Logger callerLog = Logger.getLogger("callerLogger");
    private AdminPanel adminPanel;
    private Config config;
    private Employee employee;
    private CallerMGR callerMGR;
    private ClientRMI clientRMI;
    private ServerInf remoteObject;
    Ticket ticket;
    private CallerInf callerInf;
    private List<Employee> employees;
    private String closeCaller;
    
    
    /**
     * Creates new form CallerPanel
     */
    public CallerGUI() {
       this.getContentPane().setBackground(Color.white);

        this.setLocationRelativeTo(null);
        this.employees = new LinkedList<>();

        initComponents();
        try {

            this.clientRMI = new ClientRMI(this);
            initData();
        } catch (RemoteException e) {
            System.err.println("O server esta off-line.\n" + e.getMessage());
            callerLog.error("O server esta off-line.", e);
            JOptionPane.showMessageDialog(this, "O servidor esta off-line.\nContacte o administrador do sistema.");
            System.exit(1);
        } catch (NotBoundException e) {
            System.err.println("Caiu na notBound" + e.getMessage());
            callerLog.error("Caiu na notBound", e);
            System.exit(1);
            JOptionPane.showMessageDialog(this, "O servidor esta off-line.\nContacte o administrador do sistema.");
        } catch (NullPointerException en) {
            System.err.println("Deu nullPointer" + en.getMessage());
            callerLog.error("Deu nullPointer", en);
            JOptionPane.showMessageDialog(this, "O servidor esta off-line.\nContacte o administrador do sistema.");
            System.exit(1);
        } catch (BadConfigurationException bad) {
            callerLog.error("O caller apresenta configurações inválidas.", bad);
            JOptionPane.showMessageDialog(this, "As configurações do posto de trabalho não foram"
                    + "\n não foram feitas correctamente.\nContacte o administrador do sistema.");
            System.exit(1);
        }
    }

    public void initData() throws RemoteException, BadConfigurationException {

        config = new Config();
        employee = config.getEmployee();
        jLabelEmpName.setText(employee.getName());
        jLabelEmpDepartment.setText(employee.getDepartment().getName());
        jLabelEmpDesk.setText(String.valueOf(employee.getDeskNumber()));
        adminPanel = new AdminPanel();
        adminPanel.setVisible(false);
        employee.setCallerInf(this.callerInf);
        remoteObject.connect(employee);
        jLabelActualTicket.setText("");

        //chama o connect do rmi e mando o emp como argumento.
    }

    /**
     * Faz o update da lista de employees do mesmo departamento quando existem
     * alterações
     *
     * @param employees
     */
    public void updateEmployees(List<Employee> employees) {
//        this.employees = null;
        this.employees = employees;
        jComboBoxColleagues.removeAllItems();
        jComboBoxColleagues.addItem("");

        System.out.println("Lista dos employees recebidas do server:");
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getName() + " e id " + employees.get(i).getEmpNumber());
        }

//        for (int i = 1; i < jComboBoxColleagues.getItemCount(); i++) {
//            System.out.println("Irei remover "+ jComboBoxColleagues.getItemAt(i));
//            
//            jComboBoxColleagues.removeItemAt(i);
//            
//
//        }
        for (Employee emp : employees) {
            if (!(emp.getName().equals(employee.getName()))) {
                jComboBoxColleagues.addItem(emp.getName());
                callerLog.debug("Irei adicionar " + emp.getName());
            }

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

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxColleagues = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabelActualTicket = new javax.swing.JLabel();
        jButtonRefresh = new javax.swing.JButton();
        jButtonCallNext = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelEmpName = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelEmpDepartment = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelEmpDesk = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("UAL iSenhas");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(222, 222, 222));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(222, 222, 222));
        setName("iSenhas - Caller"); // NOI18N
        setPreferredSize(new java.awt.Dimension(420, 330));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Transferências", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Colegas");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jComboBoxColleagues.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxColleagues.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jComboBoxColleagues.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        jComboBoxColleagues.setPreferredSize(new java.awt.Dimension(35, 24));
        jComboBoxColleagues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxColleaguesActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxColleagues, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 130, 130));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actual", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(90, 61));

        jLabelActualTicket.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabelActualTicket.setForeground(new java.awt.Color(0, 0, 255));
        jLabelActualTicket.setText("D99");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelActualTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelActualTicket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 51, 120, 80));

        jButtonRefresh.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ual/lp/caller/images/refresh2.png"))); // NOI18N
        jButtonRefresh.setToolTipText("Teste do botão chamar");
        jButtonRefresh.setContentAreaFilled(false);
        jButtonRefresh.setFocusCycleRoot(true);
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 120, 120));

        jButtonCallNext.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCallNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ual/lp/caller/images/Play-icon120x120.png"))); // NOI18N
        jButtonCallNext.setToolTipText("Teste do botão chamar");
        jButtonCallNext.setContentAreaFilled(false);
        jButtonCallNext.setFocusCycleRoot(true);
        jButtonCallNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCallNextActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCallNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 120, 120));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Colaborador", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nome:");

        jLabelEmpName.setText("Pedro Maria Thomaz Reis de Almeida");

        jLabel5.setText("Depart:");

        jLabelEmpDepartment.setText("Tesouraria");

        jLabel7.setText("Secretaria:");

        jLabelEmpDesk.setText("jLabel6");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEmpName))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEmpDepartment)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelEmpDesk)))
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmpDepartment)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmpDesk))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 250, -1));

        jButton1.setForeground(new java.awt.Color(51, 51, 55));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ual/lp/caller/images/ExitButtonBlue100x80.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 80, 30));

        getAccessibleContext().setAccessibleName("UAL iSenhas");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed

//        adminPanel.setVisible(true);
//        try {
//            JOptionPane.showMessageDialog(this, "Rechamar a senha "+this.ticket.getDepartment().getAbbreviation()+""+this.ticket.getNumberticket());
//        } catch (NullPointerException e) {
//            callerLog.error(employee.getName()+" rechamou um ticket sem tem um ticket atribuido", e);
//        }
//
    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonCallNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCallNextActionPerformed
//        try {
//
//            if (jComboBoxColleagues.getSelectedItem() != "") {
////                System.out.println("Transferir para " + jComboBoxColleagues.getSelectedItem());
//                //correr o array dos emp para encontrar o que quero fazer a transf.
//                for (int i = 0; i < this.employees.size(); i++) {
//                    if (employees.get(i).getName().equals(jComboBoxColleagues.getSelectedItem())) {
//                        this.employees.get(i);
//                        System.out.println("Encontrei o gajo na lista.\nIrei transferir para " + employees.get(i).getName());
//                        System.out.println(i);
//                        this.ticket.setTransferId(this.employees.get(i).getEmpNumber());
//                        remoteObject.transferTicket(ticket);
//                        continue;
//                    }
//
//                }
//                remoteObject.getNextTicket(this.employee);
////                jComboBoxColleagues.setSelectedIndex(0);
//            } else {
//
//                if (jLabelActualTicket.getText().equals("")) {
//
//                    this.ticket = remoteObject.getNextTicket(this.employee);
//
//                    jLabelActualTicket.setText(this.ticket.getDepartment().getAbbreviation() + "" + String.valueOf(this.ticket.getNumberticket()));
//                } else {
//                    remoteObject.closeTicket(this.ticket);
//                    this.ticket = remoteObject.getNextTicket(this.employee);
//                    jLabelActualTicket.setText(this.ticket.getDepartment().getAbbreviation() + "" + String.valueOf(this.ticket.getNumberticket()));
//                }
//            }

            //Fazer o close deste ticket.
////////        if(jComboBoxDeptList.getSelectedItem()!=""&&jComboBoxColegasList.getSelectedItem()!=""){
//////////            System.out.println("Tenho os dois selecionados.");
////////            JOptionPane.showMessageDialog(this, "Você não pode transferir para um colega e\n para um departamento ao mesmo tempo");
////////            jComboBoxColegasList.setSelectedIndex(o);
////////            jComboBoxDeptList.setSelectedIndex(o);
////////        }else if(jComboBoxDeptList.getSelectedItem()==""&&jComboBoxColegasList.getSelectedItem()==""){
//////////            System.out.println("Não tenho nenhum selecionado");
////////            jLabelNextTicket.setText(callerMGR.showNextCallTicket());
////////            jLabelActualTicket.setText(callerMGR.showActualTicket());
////////        }else{
//////////            System.out.println("Valor do colega: "+ jComboBoxColegasList.getSelectedItem()+"\nValor do dept:"+jComboBoxDeptList.getSelectedItem());
////////            JOptionPane.showMessageDialog(this, "Será feita a transferência para:\nColega "+ jComboBoxColegasList.getSelectedItem()+".\nDepartamento "+jComboBoxDeptList.getSelectedItem()+".");
////////            jComboBoxColegasList.setSelectedIndex(o);
////////            jComboBoxDeptList.setSelectedIndex(o);
////////            jLabelNextTicket.setText(callerMGR.showNextCallTicket());
////////            jLabelActualTicket.setText(callerMGR.showActualTicket());
////////        }
        //Testando o callerMGR para ser se funciona.
        if (jLabelActualTicket.getText().equals("")) {
            try {
                this.ticket = remoteObject.getNextTicket(this.employee);
                jComboBoxColleagues.setSelectedIndex(0);
                jLabelActualTicket.setText(this.ticket.getDepartment().getAbbreviation() + "" + String.valueOf(this.ticket.getNumberticket()));
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(this, "Existe um problema de comunicação com o servidor.\nContacte o administrador do sistema!");
                callerLog.error("Existe um problema de comunicação\n com o servidor", ex);
                System.exit(1);
            } catch (NoTicketsException ex) {
                JOptionPane.showMessageDialog(this, "Não existem tickets por atender.");
                jLabelActualTicket.setText("");
                jComboBoxColleagues.setSelectedIndex(0);
            }
        } else {

            try {
                if (jComboBoxColleagues.getSelectedItem() != "") {
//                System.out.println("Transferir para " + jComboBoxColleagues.getSelectedItem());
                    //correr o array dos emp para encontrar o que quero fazer a transf.
                    for (int i = 0; i < this.employees.size(); i++) {
                        if (employees.get(i).getName().equals(jComboBoxColleagues.getSelectedItem())) {
                            this.employees.get(i);
                            System.out.println("Encontrei o gajo na lista.\nIrei transferir para " + employees.get(i).getName());
                            System.out.println(i);
                            this.ticket.setTransferId(this.employees.get(i).getEmpNumber());
                            remoteObject.transferTicket(ticket);
                            break;

                        }
                    }
                    this.ticket = remoteObject.getNextTicket(this.employee);
                    jLabelActualTicket.setText(this.ticket.getDepartment().getAbbreviation() + "" + String.valueOf(this.ticket.getNumberticket()));
                    jComboBoxColleagues.setSelectedIndex(0);
                } else {

                    remoteObject.closeTicket(this.ticket);
                    this.ticket = remoteObject.getNextTicket(this.employee);
                    jLabelActualTicket.setText(this.ticket.getDepartment().getAbbreviation() + "" + String.valueOf(this.ticket.getNumberticket()));
                }
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(this, "Existe um problema de comunicação com o servidor.\nContacte o administrador do sistema!");
                callerLog.error("Existe um problema de comunicação\n com o servidor", ex);
                System.exit(1);
            } catch (NoTicketsException ex) {
                JOptionPane.showMessageDialog(this, "Não existem tickets por atender.");
                callerLog.info("Não existem tickets por atender", ex);
                jLabelActualTicket.setText("");
                jComboBoxColleagues.setSelectedIndex(0);
            }

        }

    }//GEN-LAST:event_jButtonCallNextActionPerformed

    private void jComboBoxColleaguesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxColleaguesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxColleaguesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            remoteObject.closeTicket(this.ticket);
            JOptionPane.showMessageDialog(this, "Estou a encerrar o caller, o ticket já foi encerrado.");
            System.exit(0);
        } catch (RemoteException e) {
            System.err.println("O server esta off-line.\n" + e.getMessage());
            callerLog.error("O server esta off-line.", e);
            JOptionPane.showMessageDialog(this, "O servidor esta off-line.\nContacte o administrador do sistema.");
            System.exit(1);
        } catch (NullPointerException e){
//            System.err.println("O server esta off-line.\n" + e.getMessage());
            callerLog.error("O server esta off-line.", e);
            JOptionPane.showMessageDialog(this, "A aplicação foi encerrada com sucesso.");
            System.exit(0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(CallerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(CallerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(CallerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(CallerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
////                new CallerPanel().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCallNext;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JComboBox jComboBoxColleagues;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelActualTicket;
    private javax.swing.JLabel jLabelEmpDepartment;
    private javax.swing.JLabel jLabelEmpDesk;
    private javax.swing.JLabel jLabelEmpName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the remoteObject
     */
    public ServerInf getRemoteObject() {
        return remoteObject;
    }

    /**
     * @param remoteObject the remoteObject to set
     */
    public void setRemoteObject(ServerInf remoteObject) {
        this.remoteObject = remoteObject;
    }

    /**
     * @return the callerInf
     */
    public CallerInf getCallerInf() {
        return callerInf;
    }

    /**
     * @param callerInf the callerInf to set
     */
    public void setCallerInf(CallerInf callerInf) {
        this.callerInf = callerInf;
    }

}
