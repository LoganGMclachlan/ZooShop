/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.Animal;
import Models.Admin;
import Models.DBManager;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;

/**
 *
 * @author logan
 */
public class AnimalMenu extends javax.swing.JFrame {

    // stores animal data from db
    private HashMap<Integer, Animal> animals;
    // stores admin currently logged in
    private Admin loggedInAdmin;
    
    /**
     * Creates new form AnimalMenu
     */
    public AnimalMenu(Admin admin) {
        // gets animal data from db
        DBManager db = new DBManager();
        animals = db.loadAnimals();
        
        // sets logged in admin
        loggedInAdmin = admin;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDeleteAnimal = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCatagories = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstAnimals = new javax.swing.JList<>();
        btnEditAnimal = new javax.swing.JButton();
        lblErrorMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnDeleteAnimal.setText("Delete Animal");
        btnDeleteAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAnimalActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setText("Animal Menu");

        jLabel2.setText("Catagory");

        jLabel3.setText("Animal");

        lstCatagories.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Bird", "Fish" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstCatagories.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCatagoriesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstCatagories);

        jScrollPane3.setViewportView(lstAnimals);

        btnEditAnimal.setText("Edit Animal");
        btnEditAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAnimalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblErrorMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack)
                            .addComponent(btnEditAnimal))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(btnDeleteAnimal)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(lblErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditAnimal)
                    .addComponent(btnDeleteAnimal))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        AdminHome home = new AdminHome(loggedInAdmin);
        this.dispose();
        home.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void lstCatagoriesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCatagoriesValueChanged

        DefaultListModel animalList = new DefaultListModel();

        String selectedValue = lstCatagories.getSelectedValue();

        for(Map.Entry<Integer, Animal> animalEntry : animals.entrySet())
        {
            Animal animal = animalEntry.getValue();

            if(animal.getClass().getName().equals("Models." + selectedValue))
            {
                animalList.addElement(animal);
            }
        }
        lstAnimals.setModel(animalList);
    }//GEN-LAST:event_lstCatagoriesValueChanged

    private void btnEditAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAnimalActionPerformed
        if(lstAnimals.getSelectedIndex() == -1){
            lblErrorMessage.setText("Error: Select an animal first");
        }
        else{

            Object obj = (Object)lstAnimals.getSelectedValue();
            Animal animal = (Animal)obj;

            EditAnimal editAnimal = new EditAnimal(loggedInAdmin,animal);
            this.dispose();
            editAnimal.setVisible(true);
        }
    }//GEN-LAST:event_btnEditAnimalActionPerformed

    private void btnDeleteAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAnimalActionPerformed
        if(lstAnimals.getSelectedIndex() == -1){
            lblErrorMessage.setText("Error: Select an animal first");
        }
        else{
            Object obj = (Object)lstAnimals.getSelectedValue();
            Animal animal = (Animal)obj;

            DBManager db = new DBManager();
            db.DeleteAnimal(animal.getAnimalID());
            
            animals.remove(animal.getAnimalID());
            
            DefaultListModel animalList = (DefaultListModel)lstAnimals.getModel();
            animalList.remove(lstAnimals.getSelectedIndex());
            lstAnimals.setModel(animalList);
            
            lblErrorMessage.setText("Animal was deleted");
        }
    }//GEN-LAST:event_btnDeleteAnimalActionPerformed

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
            java.util.logging.Logger.getLogger(AnimalMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnimalMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnimalMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnimalMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new AnimalMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteAnimal;
    private javax.swing.JButton btnEditAnimal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblErrorMessage;
    private javax.swing.JList<String> lstAnimals;
    private javax.swing.JList<String> lstCatagories;
    // End of variables declaration//GEN-END:variables
}
