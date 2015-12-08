/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.AdministradorDeGrupo;
import ManejoDatos.ConexionBD;
import Modulo.Asignatura;
import Modulo.GrupoEscolar;
import Modulo.Profesor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aaron
 */
public class VistaAdministradorGrupo extends javax.swing.JFrame {

    /**
     * Creates new form VistaAdministradorGrupoEscolar
     */
    public VistaAdministradorGrupo(VistaGestionGrupos ventanaPadre) {
        initComponents();
        menuPrincipal = ventanaPadre;
        this.setLocationRelativeTo(menuPrincipal);
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        WindowListener exitListener = new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                btnSalirActionPerformed(null);
            }
        };
        this.addWindowListener(exitListener);
        
        actualizarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnListar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGrupo = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnListar.setText("Listar");
        btnListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ADMINISTRADOR GRUPOS");

        tablaGrupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Clave", "Asignatura", "Profesor", "Aula", "Horario"
            }
        ));
        jScrollPane1.setViewportView(tablaGrupo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(btnListar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnListar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        VistaRegistrarGrupoEscolar ventanaRegistrar = new VistaRegistrarGrupoEscolar();
        ventanaRegistrar.setVisible(true);
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        int registroSeleccionado = tablaGrupo.getSelectedRow();
        VistaModificarGrupoEscolar ventanaModificar;
        if(registroSeleccionado == -1){
            ventanaModificar = new VistaModificarGrupoEscolar();
        }else{
            GrupoEscolar grupoModificar = new GrupoEscolar();
            grupoModificar.SetClaveGrupo((String)tablaGrupo.getValueAt(registroSeleccionado,0));
            //grupoModificar.SetUnAsignatura((Asignatura) tablaGrupo.getValueAt(registroSeleccionado, 1));
            //grupoModificar.SetUnProfesor((Profesor) tablaGrupo.getValueAt(registroSeleccionado, 2));
            grupoModificar.SetAula((String)tablaGrupo.getValueAt(registroSeleccionado,3));
            grupoModificar.SetHorario((String)tablaGrupo.getValueAt(registroSeleccionado,4));
            ventanaModificar = new VistaModificarGrupoEscolar(grupoModificar);
        }
        ventanaModificar.setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int registroSeleccionado = tablaGrupo.getSelectedRow();
        VistaEliminarGrupoEscolar ventanaEliminar;
        if(registroSeleccionado == -1){
            ventanaEliminar = new VistaEliminarGrupoEscolar();
        }else{
            String claveEliminar = (String) tablaGrupo.getValueAt(registroSeleccionado, 0);
            ventanaEliminar = new VistaEliminarGrupoEscolar(claveEliminar);
        }
        ventanaEliminar.setVisible(true);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        menuPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_btnListarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaAdministradorGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAdministradorGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAdministradorGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAdministradorGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               if(ConexionBD.Conectar() == -1){
                    ConexionBD.GenerarBD();
                }
            }
        });
    }
    
    private void actualizarTabla(){
        
        
        ArrayList<GrupoEscolar> lista;
        lista = AdministradorDeGrupo.ObtenerLista();
        
        Vector <String> titulo = new Vector<String>();
        Vector<Vector<Object>> data= new Vector<Vector<Object>>();
        
        titulo.add("Clave");
        titulo.add("Asignatura");
        titulo.add("Profesor");
        titulo.add("Aula");
        titulo.add("Horario");
        
        for(int i=0; i<lista.size(); i++){
            Vector<Object> row= new Vector<Object>();
            row.add(((GrupoEscolar)lista.get(i)).GetClave());
            row.add(((GrupoEscolar)lista.get(i)).GetUnaAsignatura().GetNombre());
            row.add(((GrupoEscolar)lista.get(i)).GetUnProfesor().GetNombre());            
            row.add(((GrupoEscolar)lista.get(i)).GetAula());
            row.add(((GrupoEscolar)lista.get(i)).GetHorario());
            
            
            data.add(row);
        }
        
        DefaultTableModel modelo= new javax.swing.table.DefaultTableModel(data, titulo);
        tablaGrupo.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnListar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaGrupo;
    // End of variables declaration//GEN-END:variables
    private VistaGestionGrupos menuPrincipal;
}
