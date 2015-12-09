/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.AdministradorDeAlumno;
import ManejoDatos.ConexionBD;
import ManejoDatos.ValidadorDeLongitudTexto;
import Modulo.Alumno;
import javax.swing.JOptionPane;


/**
 *
 * @author Edwin
 */
public class VistaRegistrarAlumno extends javax.swing.JFrame {

    /**
     * Creates new form VistaAlumno
     */
    public VistaRegistrarAlumno() {
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

        etiquetaNombre = new javax.swing.JLabel();
        etiquetaApellidos = new javax.swing.JLabel();
        etiquetaMatricula = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        etiquetaTitulo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtMatricula = new javax.swing.JFormattedTextField();
        txtNombreAlumno = new javax.swing.JFormattedTextField();
        txtApellidosAlumno = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        etiquetaNombre.setLabelFor(txtNombreAlumno);
        etiquetaNombre.setText("Nombre:");

        etiquetaApellidos.setLabelFor(txtApellidosAlumno);
        etiquetaApellidos.setText("Apellidos:");

        etiquetaMatricula.setLabelFor(txtMatricula);
        etiquetaMatricula.setText("Matricula:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        etiquetaTitulo.setText("Registrar Alumno");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        txtMatricula.setDocument(new ManejoDatos.ValidadorDeLongitudTexto(8));
        txtMatricula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMatriculaKeyTyped(evt);
            }
        });

        txtNombreAlumno.setDocument(new ManejoDatos.ValidadorDeLongitudTexto(30));
        txtNombreAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreAlumnoKeyTyped(evt);
            }
        });

        txtApellidosAlumno.setDocument(new ManejoDatos.ValidadorDeLongitudTexto(30));
        txtApellidosAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosAlumnoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTitulo)
                .addGap(151, 151, 151))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaNombre)
                    .addComponent(etiquetaApellidos)
                    .addComponent(etiquetaMatricula))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(btnCancelar))
                    .addComponent(txtMatricula)
                    .addComponent(txtNombreAlumno)
                    .addComponent(txtApellidosAlumno))
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(etiquetaTitulo)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaNombre)
                    .addComponent(txtNombreAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaApellidos)
                    .addComponent(txtApellidosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaMatricula)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        String nombre = txtNombreAlumno.getText();
        String apellidos = txtApellidosAlumno.getText();
        String matricula = txtMatricula.getText().replaceAll("\\s","");
        
        Alumno unAlumno = new Alumno(matricula, nombre, apellidos);
        
        if(txtNombreAlumno.getText().equals("") || txtApellidosAlumno.getText().equals("")){
            JOptionPane.showMessageDialog(null, "ERROR: Llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            if(matricula.length() < ValidadorDeLongitudTexto.LONGITUD_MATRICULA){
                JOptionPane.showMessageDialog(null, "ERROR: Matricula debe ser de 8 numeros. Ej: 12345678", "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                String msjResultado = AdministradorDeAlumno.Registrar(unAlumno);
                JOptionPane.showMessageDialog(null, msjResultado);
                if(JOptionPane.showConfirmDialog(null, "Desea registrar otro?",
                        "Registrar", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION){
                    this.dispose();
                }
            }
        }
        
        txtMatricula.setText("");
        txtNombreAlumno.setText("");
        txtApellidosAlumno.setText("");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreAlumnoKeyTyped
        // TODO add your handling code here:
        char validacion = evt.getKeyChar();
        
        if((validacion<'a' || validacion>'z')&&(validacion<'A' || validacion>'Z')&&(validacion<' ' || validacion>' '))evt.consume();
    }//GEN-LAST:event_txtNombreAlumnoKeyTyped

    private void txtApellidosAlumnoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosAlumnoKeyTyped
        // TODO add your handling code here:
        char validacion = evt.getKeyChar();
        
        if((validacion<'a' || validacion>'z')&&(validacion<'A' || validacion>'Z')&&(validacion<' ' || validacion>' '))evt.consume();
    }//GEN-LAST:event_txtApellidosAlumnoKeyTyped

    private void txtMatriculaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMatriculaKeyTyped
        // TODO add your handling code here:
        char validacion = evt.getKeyChar();
        
        if(validacion < '0' || validacion > '9')evt.consume();
    }//GEN-LAST:event_txtMatriculaKeyTyped

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
            java.util.logging.Logger.getLogger(VistaRegistrarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrarAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel etiquetaApellidos;
    private javax.swing.JLabel etiquetaMatricula;
    private javax.swing.JLabel etiquetaNombre;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JFormattedTextField txtApellidosAlumno;
    private javax.swing.JFormattedTextField txtMatricula;
    private javax.swing.JFormattedTextField txtNombreAlumno;
    // End of variables declaration//GEN-END:variables
}
