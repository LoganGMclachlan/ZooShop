/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.DBManager;
import Models.Order;
import Models.OrderLine;
import Models.ZooKeeper;
import java.util.Date;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author logan
 */
public class ViewBasket extends javax.swing.JFrame {

    private ZooKeeper loggedInZooKeeper;
    private Order currentOrder;
    
    /**
     * Creates new form ViewBasket
     */
    public ViewBasket(ZooKeeper zooKeeper, Order order) {
        loggedInZooKeeper = zooKeeper;
        currentOrder = order;
        initComponents();
        
        DefaultTableModel basketModel = (DefaultTableModel)tblBasket.getModel();
        
        for(Map.Entry<Integer, OrderLine> olEntry : currentOrder.getOrderLines().entrySet()){
            OrderLine ol = olEntry.getValue();
            
            basketModel.addRow( new Object[] {
                ol.getAnimal().getAnimalID(),
                ol.getAnimal().getName(),
                ol.getAnimal().getType(),
                ol.getAnimal().getCost(),
            });
        }
        
        lblTotal.setText("Line Total: £" + currentOrder.getOrderTotal());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBasket = new javax.swing.JTable();
        lblErrorMessage = new javax.swing.JLabel();
        btnRemoveFromBasket = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        btnBuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblBasket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Animal ID", "Name", "Type", "Cost"
            }
        ));
        jScrollPane1.setViewportView(tblBasket);

        btnRemoveFromBasket.setText("Remove Selected Animal");
        btnRemoveFromBasket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveFromBasketActionPerformed(evt);
            }
        });

        lblTotal.setText("Line Total: £0.00");

        btnBuy.setText("Buy");
        btnBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack)
                    .addComponent(jScrollPane1)
                    .addComponent(lblErrorMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemoveFromBasket)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuy)
                        .addGap(18, 18, 18)
                        .addComponent(lblTotal)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblErrorMessage)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveFromBasket)
                    .addComponent(lblTotal)
                    .addComponent(btnBuy))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        ViewAnimals viewAnimals = new ViewAnimals(loggedInZooKeeper, currentOrder);
        this.dispose();
        viewAnimals.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRemoveFromBasketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveFromBasketActionPerformed
        
        int selectedRow = tblBasket.getSelectedRow();
        
        if(selectedRow == -1){
            lblErrorMessage.setText("Select an animal first");
        }
        else{
            int aniamlID = Integer.parseInt(String.valueOf(tblBasket.getValueAt(selectedRow,0)));
            
            currentOrder.removeOrderLine(aniamlID);
            
            lblErrorMessage.setText("Animal removed from basket");
            
            DefaultTableModel basketModel = (DefaultTableModel)tblBasket.getModel();
            basketModel.removeRow(selectedRow);
            tblBasket.setModel(basketModel);
            
            lblTotal.setText("Line Total: £" + currentOrder.getOrderTotal());
        }
    }//GEN-LAST:event_btnRemoveFromBasketActionPerformed

    private void btnBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuyActionPerformed
        
        int numOfLines = 0;
        for(Map.Entry<Integer, OrderLine> olEntry : currentOrder.getOrderLines().entrySet()){
            numOfLines++;
        }
        
        if(numOfLines == 0){
            lblErrorMessage.setText("Error: Basket is empty");
        }
        else{
            currentOrder.setOrderDate(new Date());
            currentOrder.setStatus("Complete");
            
            DBManager db = new DBManager();
            db.WriteOrder(currentOrder, loggedInZooKeeper.getEmail());
            
            OrderConfirmation orderConfirmation = new OrderConfirmation(loggedInZooKeeper, currentOrder);
            this.dispose();
            orderConfirmation.setVisible(true);
        }
    }//GEN-LAST:event_btnBuyActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBasket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new ViewBasket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBuy;
    private javax.swing.JButton btnRemoveFromBasket;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblBasket;
    // End of variables declaration//GEN-END:variables
}
