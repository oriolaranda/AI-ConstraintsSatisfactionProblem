/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacio;

import javafx.scene.paint.Color;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel
 */
public class vistaPlaEstudis extends javax.swing.JPanel {
    CtrlPresentacio cp;
    String[] info= new String[3];
    /**
     * Creates new form vistaPlaEstudis
     */
    public vistaPlaEstudis(CtrlPresentacio cp) {
        this.cp=cp;
        initComponents();
    }
    
    public void inicia(){
        cp.getPlaEstudis();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        consultarPlaEstudisButton = new javax.swing.JButton();
        crearPlaEstudisButton = new javax.swing.JButton();
        eliminarPlaEstudisButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        consultarHorariButton = new javax.swing.JButton();
        modificarPlaEstudisButton = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));

        jScrollPane2.setBackground(new java.awt.Color(204, 204, 255));
        jScrollPane2.setAutoscrolls(true);
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTable1.setBackground(new java.awt.Color(204, 204, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pla Estudis", "Hora Inici", "Hora Final"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);

        consultarPlaEstudisButton.setText("Gestió Assignatures Pla Estudis");
        consultarPlaEstudisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    consultarPlaEstudisButtonActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        crearPlaEstudisButton.setText("Crear Pla Estudis");
        crearPlaEstudisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearPlaEstudisButtonActionPerformed(evt);
            }
        });

        eliminarPlaEstudisButton.setText("Eliminar Pla Estudis");
        eliminarPlaEstudisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPlaEstudisButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        consultarHorariButton.setText("Consultar Horaris");
        consultarHorariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    consultarHorariButtonActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        modificarPlaEstudisButton.setText("Modificar Pla Estudis");
        modificarPlaEstudisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPlaEstudisButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliminarPlaEstudisButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(crearPlaEstudisButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(consultarHorariButton))
                    .addComponent(consultarPlaEstudisButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificarPlaEstudisButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(crearPlaEstudisButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificarPlaEstudisButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(consultarPlaEstudisButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminarPlaEstudisButton)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultarHorariButton)
                    .addComponent(cancelButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void consultarPlaEstudisButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_consultarPlaEstudisButtonActionPerformed
        int col=jTable1.getSelectedColumn();
        int row=jTable1.getSelectedRow();
        if (col != -1){
            if (row != -1) {
                String nomPlaEstudis=jTable1.getValueAt(row,0).toString();
                cp.creaVistaAssignatures(nomPlaEstudis);
            }
        }
    }//GEN-LAST:event_consultarPlaEstudisButtonActionPerformed

    private void crearPlaEstudisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearPlaEstudisButtonActionPerformed
       infoPlaEstudisDialog i = new infoPlaEstudisDialog(new javax.swing.JFrame(),true,cp,info,false);
       i.setVisible(true);
    }//GEN-LAST:event_crearPlaEstudisButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cp.menu();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void eliminarPlaEstudisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPlaEstudisButtonActionPerformed
        int col=jTable1.getSelectedColumn();
        int row=jTable1.getSelectedRow();
        if (col != -1){
            if (row != -1) {
                errorDialog ce= new errorDialog(new javax.swing.JFrame(),true,jTable1.getValueAt(row, 0).toString(),"",false);
                ce.setVisible(true);
                if(ce.getReturnStatus()==1){
                    String nomPlaEstudis=jTable1.getValueAt(row,0).toString();
                    cp.esborrarPlaEstudis(nomPlaEstudis);
                    DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                    tm.removeRow(jTable1.getSelectedRow());
                }
            }
        }
    }//GEN-LAST:event_eliminarPlaEstudisButtonActionPerformed

    private void consultarHorariButtonActionPerformed(java.awt.event.ActionEvent evt) throws Exception {//GEN-FIRST:event_consultarHorariButtonActionPerformed
        int col=jTable1.getSelectedColumn();
        int row=jTable1.getSelectedRow();
        if (col != -1){
            if (row != -1) {
                String nomPlaEstudis=jTable1.getValueAt(row,0).toString();
                cp.creaVistaHoraris(nomPlaEstudis);
            }
        }
    }//GEN-LAST:event_consultarHorariButtonActionPerformed

    private void modificarPlaEstudisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPlaEstudisButtonActionPerformed
       int col=jTable1.getSelectedColumn();
        int row=jTable1.getSelectedRow();
        if (col != -1){
            if (row != -1) {
                String nomPlaEstudis=jTable1.getValueAt(row,0).toString();
                String horaInici=jTable1.getValueAt(row,1).toString();
                String horaFinal=jTable1.getValueAt(row,2).toString();
                info[0]=nomPlaEstudis;
                info[1]=horaInici;
                info[2]=horaFinal;
                
                DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
                tm.removeRow(jTable1.getSelectedRow());
                
                infoPlaEstudisDialog i = new infoPlaEstudisDialog(new javax.swing.JFrame(),true,cp,info,true);
                i.setVisible(true);
                                
            }
        }
    }//GEN-LAST:event_modificarPlaEstudisButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton consultarHorariButton;
    private javax.swing.JButton consultarPlaEstudisButton;
    private javax.swing.JButton crearPlaEstudisButton;
    private javax.swing.JButton eliminarPlaEstudisButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modificarPlaEstudisButton;
    // End of variables declaration//GEN-END:variables

    void afegirPlaEstudis(String nomPlaEstudis, String horaInici, String horaFinal) {
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
        tm.addRow(new Object[]{nomPlaEstudis, horaInici, horaFinal});
    }

}
