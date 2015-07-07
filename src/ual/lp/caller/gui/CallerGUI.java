/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.lp.caller.gui;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import org.apache.log4j.Logger;
import ual.lp.caller.mgr.CallerMGR;
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

    //colocar um botão bonitinho do call. Imagem Play????
    private Config config;
    private Employee employee;
    private CallerMGR callerMGR;
    private ClientRMI clientRMI;
    private ServerInf remoteObject;
    Ticket ticket;

    /**
     * Creates new form CallerPanel
     */
    public CallerGUI() {
        this.setLocationRelativeTo(null);

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
        } catch (NullPointerException en) {
            System.err.println("Deu nullPointer" + en.getMessage());
            callerLog.error("Deu nullPointer", en);
        } catch (BadConfigurationException bad) {
            callerLog.error("O caller apresenta configurações inválidas.", bad);
        }
    }

    public void initData() throws RemoteException, BadConfigurationException {

        //construo aqui o empl e envio para o server para ser colocado na lista de emp que estão a trabalhar.
        config = new Config();
        employee = config.getEmployee();
        remoteObject.connect(employee);
        jLabelActualTicket.setText("");

        //chama o connect do rmi e mando o emp como argumento.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxColleagues = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabelActualTicket = new javax.swing.JLabel();
        jButtonRefresh = new javax.swing.JButton();
        jButtonCallNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UAL");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("iSenhas - Caller"); // NOI18N
        setPreferredSize(new java.awt.Dimension(420, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("iSenhas - Caller");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tranferências"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Colegas");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 17, -1, -1));

        jComboBoxColleagues.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(jComboBoxColleagues, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 130, 130));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actual", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel3.setPreferredSize(new java.awt.Dimension(90, 61));

        jLabelActualTicket.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabelActualTicket.setForeground(new java.awt.Color(0, 0, 255));
        jLabelActualTicket.setText("D99");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelActualTicket))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelActualTicket)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        jButtonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ual/lp/caller/images/refresh2.png"))); // NOI18N
        jButtonRefresh.setToolTipText("Teste do botão chamar");
        jButtonRefresh.setContentAreaFilled(false);
        jButtonRefresh.setFocusCycleRoot(true);
        jButtonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRefreshActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 120, 120));

        jButtonCallNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ual/lp/caller/images/Play-icon120x120.png"))); // NOI18N
        jButtonCallNext.setToolTipText("Teste do botão chamar");
        jButtonCallNext.setContentAreaFilled(false);
        jButtonCallNext.setFocusCycleRoot(true);
        jButtonCallNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCallNextActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCallNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 120, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRefreshActionPerformed


    }//GEN-LAST:event_jButtonRefreshActionPerformed

    private void jButtonCallNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCallNextActionPerformed
        try {

            if (jLabelActualTicket.getText().equals("")) {

                this.ticket = remoteObject.getNextTicket(this.employee);

                jLabelActualTicket.setText(this.ticket.getDepartment().getAbbreviation() + "" + String.valueOf(this.ticket.getNumberticket()));
            } else {
                remoteObject.closeTicket(this.ticket);
                this.ticket = remoteObject.getNextTicket(this.employee);
                jLabelActualTicket.setText(this.ticket.getDepartment().getAbbreviation() + "" + String.valueOf(this.ticket.getNumberticket()));
            }

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
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, "Existe um problema de comunicação\n com o servidor");
            callerLog.error("Existe um problema de comunicação\n com o servidor", ex);
        } catch (NoTicketsException ex) {
            JOptionPane.showMessageDialog(this, "Não existem tickets por atender.");
            jLabelActualTicket.setText("");
        }
    }//GEN-LAST:event_jButtonCallNextActionPerformed

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
    private javax.swing.JButton jButtonCallNext;
    private javax.swing.JButton jButtonRefresh;
    private javax.swing.JComboBox jComboBoxColleagues;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelActualTicket;
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
}
