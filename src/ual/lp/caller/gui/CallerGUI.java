/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ual.lp.caller.gui;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import ual.lp.caller.mgr.CallerMGR;
import ual.lp.caller.utils.Config;
import ual.lp.server.objects.Employee;

/**
 *
 * @author Divanio Silva
 */
public class CallerGUI extends javax.swing.JFrame {
    //colocar um botão bonitinho do call. Imagem Play????
    private Config config;
    private Employee employee;
    private CallerMGR callerMGR;

    /**
     * Creates new form CallerPanel
     */
    public CallerGUI() {
        initComponents();
        initData();
    }

    public CallerGUI(CallerMGR callerMGR) {
        this.callerMGR = callerMGR;
        initComponents();
        this.setLocationRelativeTo(null);
        initData();
    }

    public void initData() {
        jLabelNextTicket.setText(callerMGR.showNextCallTicket());
        jLabelActualTicket.setText(callerMGR.showActualTicket());
        //add o array todo dentro da list.
        //callerMGR.colleagueList().getData().toArray())

//        jComboBoxColegasList.setModel(new DefaultComboBoxModel(callerMGR.employeesList()));
////        jComboBoxColegasList.setModel(new DefaultComboBoxModel(callerMGR.employeesList()));
//        jComboBoxDeptList.setModel(new DefaultComboBoxModel(callerMGR.deptmentList()));
//        jComboBoxColegasList.addItem(this.callerMGR.colleagueList().getData().get(0).getName());
        
        //construo aqui o empl e envio para o server para ser colocado na lista de emp que estão a trabalhar.
        config = new Config();
        employee = config.getEmployee();
        
        JOptionPane.showMessageDialog(this, employee.getDeskNumber()+"\n "+employee.getName()+"\n"
                +employee.getDepartment().getName()+"\n"+employee.getDepartment().getAbbreviation());
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

        jPanel1 = new javax.swing.JPanel();
        jLabelNextTicket = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxColegasList = new javax.swing.JComboBox();
        jComboBoxDeptList = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelActualTicket = new javax.swing.JLabel();
        jButtonCallNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UAL");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("iSenhas - Caller"); // NOI18N
        setPreferredSize(new java.awt.Dimension(355, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Próxima", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabelNextTicket.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabelNextTicket.setForeground(new java.awt.Color(255, 0, 0));
        jLabelNextTicket.setText("D99");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelNextTicket)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabelNextTicket)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 90, 60));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("iSenhas - Caller");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Tranferências"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Colegas");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 17, -1, -1));

        jComboBoxColegasList.setMaximumRowCount(20);
        jComboBoxColegasList.setModel(new DefaultComboBoxModel(callerMGR.employeesList()));
        jComboBoxColegasList.setToolTipText("");
        jPanel2.add(jComboBoxColegasList, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 38, 135, -1));

        jComboBoxDeptList.setMaximumRowCount(20);
        jComboBoxDeptList.setModel(new DefaultComboBoxModel(callerMGR.deptmentList())
        );
        jComboBoxDeptList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDeptListActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBoxDeptList, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 89, 135, -1));

        jLabel4.setText("Departamentos");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 68, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 114, 160, 120));

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, -1, -1));

        jButtonCallNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ual/lp/caller/images/Play-icon120x120.png"))); // NOI18N
        jButtonCallNext.setToolTipText("Teste do botão chamar");
        jButtonCallNext.setContentAreaFilled(false);
        jButtonCallNext.setFocusCycleRoot(true);
        jButtonCallNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCallNextActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCallNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 120, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCallNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCallNextActionPerformed

        if(jComboBoxDeptList.getSelectedItem()!=""&&jComboBoxColegasList.getSelectedItem()!=""){
//            System.out.println("Tenho os dois selecionados.");
            JOptionPane.showMessageDialog(this, "Você não pode transferir para um colega e\n para um departamento ao mesmo tempo");
            jComboBoxColegasList.setSelectedIndex(0);
            jComboBoxDeptList.setSelectedIndex(0);
        }else if(jComboBoxDeptList.getSelectedItem()==""&&jComboBoxColegasList.getSelectedItem()==""){
//            System.out.println("Não tenho nenhum selecionado");
            jLabelNextTicket.setText(callerMGR.showNextCallTicket());
            jLabelActualTicket.setText(callerMGR.showActualTicket());
        }else{
//            System.out.println("Valor do colega: "+ jComboBoxColegasList.getSelectedItem()+"\nValor do dept:"+jComboBoxDeptList.getSelectedItem());
            JOptionPane.showMessageDialog(this, "Será feita a transferência para:\nColega "+ jComboBoxColegasList.getSelectedItem()+".\nDepartamento "+jComboBoxDeptList.getSelectedItem()+".");
            jComboBoxColegasList.setSelectedIndex(0);
            jComboBoxDeptList.setSelectedIndex(0);
            jLabelNextTicket.setText(callerMGR.showNextCallTicket());
            jLabelActualTicket.setText(callerMGR.showActualTicket());
        }
        
          //Testando o callerMGR para ser se funciona.
//        callerMGR.colleagueList();
//        jComboBoxColegasList.add(callerMGR.colleagueList());
        
//        System.out.println(callerMGR.showNextCallTicket());

//        System.out.println(jComboBoxColegasList.getSelectedItem());//Faz o get do item selecionado na jList

    }//GEN-LAST:event_jButtonCallNextActionPerformed

    private void jComboBoxDeptListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDeptListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxDeptListActionPerformed

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
    private javax.swing.JComboBox jComboBoxColegasList;
    private javax.swing.JComboBox jComboBoxDeptList;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelActualTicket;
    private javax.swing.JLabel jLabelNextTicket;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
