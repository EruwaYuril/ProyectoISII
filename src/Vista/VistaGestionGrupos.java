/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import ConexionBD.BaseDatos;

/**
 *
 * @author Edwin
 */
public class VistaGestionGrupos extends javax.swing.JFrame {

    /**
     * Creates new form VistaGestionGrupos
     */
    public VistaGestionGrupos() {
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

        jLabel1 = new javax.swing.JLabel();
        btnAdminAlumno = new javax.swing.JButton();
        btnAdminProfesor = new javax.swing.JButton();
        btnAdminAsignatura = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de Grupos Escolares");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Sistema de Gestion de Grupos Escolares");

        btnAdminAlumno.setText("Administrar Alumno");
        btnAdminAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminAlumnoActionPerformed(evt);
            }
        });

        btnAdminProfesor.setText("Administrar Profesor");
        btnAdminProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminProfesorActionPerformed(evt);
            }
        });

        btnAdminAsignatura.setText("Administrar Asignatura");
        btnAdminAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminAsignaturaActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdminAsignatura)
                    .addComponent(btnAdminProfesor)
                    .addComponent(btnAdminAlumno))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSalir)
                        .addGap(170, 170, 170))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(btnAdminAlumno)
                .addGap(18, 18, 18)
                .addComponent(btnAdminProfesor)
                .addGap(18, 18, 18)
                .addComponent(btnAdminAsignatura)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAdminAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminAsignaturaActionPerformed

        VistaAdministradorAsignatura ventanaAdminAsignatura = new VistaAdministradorAsignatura();
        ventanaAdminAsignatura.setVisible(true);
    }//GEN-LAST:event_btnAdminAsignaturaActionPerformed

    private void btnAdminAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminAlumnoActionPerformed
        VistaListaAlumno ventanaAdminAlumno = new VistaListaAlumno(this);
        ventanaAdminAlumno.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAdminAlumnoActionPerformed

    private void btnAdminProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminProfesorActionPerformed
        
        VistaAdministradorProfesor ventanaAdminProfesor = new VistaAdministradorProfesor();
        ventanaAdminProfesor.setVisible(true);
    }//GEN-LAST:event_btnAdminProfesorActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(VistaGestionGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGestionGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGestionGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGestionGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaGestionGrupos().setVisible(true);
                if(BaseDatos.Conectar() == -1){
                    BaseDatos.GenerarBD();
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminAlumno;
    private javax.swing.JButton btnAdminAsignatura;
    private javax.swing.JButton btnAdminProfesor;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}