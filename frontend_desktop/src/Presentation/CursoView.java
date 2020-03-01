/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import BusinessLogic.Curso;
import Control.CursoController;
import Model.CursoModel;
import frontend_desktop.Frontend_desktop;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Josue
 */
public class CursoView extends javax.swing.JDialog implements java.util.Observer {
    
    public CursoView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    CursoController controller;
    CursoModel model;
    
    public void setController(CursoController controller) {
        this.controller = controller;
    }
    
    public CursoController getController() {
        return controller;
    }
    
    public void setModel(CursoModel model) {
        this.model = model;
        model.addObserver(this);
    }
    
    boolean validar() {
        boolean error = false;
        
        this.jLabel2.setForeground(Frontend_desktop.COLOR_OK);
        if (this.codigoFld.getText().isEmpty()) {
            this.jLabel2.setForeground(Frontend_desktop.COLOR_ERROR);
            this.codigoFld.setBorder(BorderFactory.createLineBorder(Frontend_desktop.COLOR_ERROR, 1));
            error = true;
        }
        
        this.jLabel3.setForeground(Frontend_desktop.COLOR_OK);
        if (this.nombreFld.getText().isEmpty()) {
            this.jLabel3.setForeground(Frontend_desktop.COLOR_ERROR);
            this.nombreFld.setBorder(BorderFactory.createLineBorder(Frontend_desktop.COLOR_ERROR, 1));
            error = true;
        }
        this.jLabel4.setForeground(Frontend_desktop.COLOR_OK);
        if (this.creditosFld.getText().isEmpty()) {
            this.jLabel4.setForeground(Frontend_desktop.COLOR_ERROR);
            this.creditosFld.setBorder(BorderFactory.createLineBorder(Frontend_desktop.COLOR_ERROR, 1));
            error = true;
        }
        this.jLabel5.setForeground(Frontend_desktop.COLOR_OK);
        if (this.horasFld.getText().isEmpty()) {
            this.jLabel5.setForeground(Frontend_desktop.COLOR_ERROR);
            this.horasFld.setBorder(BorderFactory.createLineBorder(Frontend_desktop.COLOR_ERROR, 1));
            error = true;
        }
        return !error;
    }
    
    private Curso toCurso() {
        Curso curso = new Curso();
        curso.setCodigo(Integer.parseInt(this.codigoFld.getText()));
        curso.setNombre(this.nombreFld.getText());
        curso.setCreditos(Integer.parseInt(this.creditosFld.getText()));
        curso.setHorasSemanales(Integer.parseInt(this.horasFld.getText()));
        return curso;
    }

    private void fromCurso(Curso curso) {
        if (model.getModo() == Frontend_desktop.MODO_AGREGAR) {
            this.codigoFld.setText("");
            this.creditosFld.setText("");
            this.horasFld.setText("");
        } else {
            this.codigoFld.setText(Integer.toString(curso.getCodigo()));
            this.creditosFld.setText(Integer.toString(curso.getCreditos()));
            this.horasFld.setText(Integer.toString(curso.getHorasSemanales()));
        }
        this.nombreFld.setText(curso.getNombre());
    }

    @Override
    public void update(Observable o, Object arg) {
        Curso curso = model.getCurrent();
        this.fromCurso(curso);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        codigoFld = new javax.swing.JTextField();
        nombreFld = new javax.swing.JTextField();
        creditosFld = new javax.swing.JTextField();
        horasFld = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Curso");

        jLabel1.setText("Datos del curso");

        jLabel2.setText("Código");

        jLabel3.setText("Nombre");

        jLabel4.setText("Créditos");

        jLabel5.setText("Horas Semanales");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(134, 134, 134)
                            .addComponent(jButton2))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(codigoFld)
                                .addComponent(nombreFld)
                                .addComponent(creditosFld)
                                .addComponent(horasFld, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(codigoFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nombreFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(creditosFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(horasFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (this.validar()) {
            try {
                int guardar = this.controller.guardar(this.toCurso());
            } catch (Exception ex) {
                Logger.getLogger(CursoView.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Código ya Existe", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Error en datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controller.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigoFld;
    private javax.swing.JTextField creditosFld;
    private javax.swing.JTextField horasFld;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nombreFld;
    // End of variables declaration//GEN-END:variables

}
