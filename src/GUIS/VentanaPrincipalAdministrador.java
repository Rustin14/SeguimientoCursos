/*BRANDON TRUJILLO
**12/07/2020
*/
package GUIS;


import Dominio.Administrador;
import javax.swing.JOptionPane;

public class VentanaPrincipalAdministrador extends javax.swing.JFrame {
    
    Administrador admin = null;
    
    public VentanaPrincipalAdministrador(Administrador administrador) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Pantalla inicial Administrador");
        this.admin = administrador;
        jLabelNombreAdmins.setText(admin.getNombre());
    }
    
    public VentanaPrincipalAdministrador() {
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jButtonRegistraDirectr = new javax.swing.JButton();
        jButtonRegistrarCoordinador = new javax.swing.JButton();
        jButtonRegistrarProfesor = new javax.swing.JButton();
        jButtonAñadirCatalogo = new javax.swing.JButton();
        jButtonActualizarCatalogo = new javax.swing.JButton();
        jButtonEliminarDirector = new javax.swing.JButton();
        jButtonEliminarCoordinador = new javax.swing.JButton();
        jButtonEliminarProfesor = new javax.swing.JButton();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelNombreAdmins = new javax.swing.JLabel();
        jLabelNombreAdmin = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelTitle.setText("Administrador");
        getContentPane().add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jButtonRegistraDirectr.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonRegistraDirectr.setText("Registrar Director");
        jButtonRegistraDirectr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistraDirectrActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistraDirectr, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 200, 60));

        jButtonRegistrarCoordinador.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonRegistrarCoordinador.setText("<html><center"
            + ">Registar Coordinador");
        jButtonRegistrarCoordinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarCoordinadorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrarCoordinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 200, 60));

        jButtonRegistrarProfesor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonRegistrarProfesor.setText("Registrar Profesor");
        jButtonRegistrarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarProfesorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrarProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 200, 60));

        jButtonAñadirCatalogo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonAñadirCatalogo.setText("Añadir Catálogo");
        jButtonAñadirCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirCatalogoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonAñadirCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 200, 60));

        jButtonActualizarCatalogo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonActualizarCatalogo.setText("Actualizar Catálogo");
        jButtonActualizarCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarCatalogoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonActualizarCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 210, 60));

        jButtonEliminarDirector.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonEliminarDirector.setText("Eliminar Director");
        jButtonEliminarDirector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarDirectorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarDirector, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 210, 60));

        jButtonEliminarCoordinador.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonEliminarCoordinador.setText("<html><center>Eliminar Coordinador");
        jButtonEliminarCoordinador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarCoordinadorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarCoordinador, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 210, 60));

        jButtonEliminarProfesor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButtonEliminarProfesor.setText("Eliminar Profesor");
        jButtonEliminarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarProfesorActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonEliminarProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, 210, 60));

        jButtonCerrarSesion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButtonCerrarSesion.setText("cerrar sesión");
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, -1, 30));

        jLabelNombreAdmins.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelNombreAdmins.setText("Nombre del Administrador: ");
        getContentPane().add(jLabelNombreAdmins, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabelNombreAdmin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(jLabelNombreAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarProfesorActionPerformed
      RegistrarProfesor irARegistrar = new RegistrarProfesor();
      irARegistrar.setVisible(true);
      dispose();
    }//GEN-LAST:event_jButtonRegistrarProfesorActionPerformed

    private void jButtonRegistraDirectrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistraDirectrActionPerformed
        JOptionPane.showMessageDialog(this, "Sin implementación");
    }//GEN-LAST:event_jButtonRegistraDirectrActionPerformed

    private void jButtonRegistrarCoordinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarCoordinadorActionPerformed
        JOptionPane.showMessageDialog(this, "Sin implementación");
    }//GEN-LAST:event_jButtonRegistrarCoordinadorActionPerformed

    private void jButtonAñadirCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirCatalogoActionPerformed
        JOptionPane.showMessageDialog(this, "Sin implementación");
    }//GEN-LAST:event_jButtonAñadirCatalogoActionPerformed

    private void jButtonActualizarCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarCatalogoActionPerformed
       JOptionPane.showMessageDialog(this, "Sin implementación");
    }//GEN-LAST:event_jButtonActualizarCatalogoActionPerformed

    private void jButtonEliminarDirectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarDirectorActionPerformed
        JOptionPane.showMessageDialog(this, "Sin implementación");
    }//GEN-LAST:event_jButtonEliminarDirectorActionPerformed

    private void jButtonEliminarCoordinadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarCoordinadorActionPerformed
       JOptionPane.showMessageDialog(this, "Sin implementación");
    }//GEN-LAST:event_jButtonEliminarCoordinadorActionPerformed

    private void jButtonEliminarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarProfesorActionPerformed
        JOptionPane.showMessageDialog(this, "Sin implementación");
    }//GEN-LAST:event_jButtonEliminarProfesorActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
       Login login = new Login();
       login.setVisible(true);
       setVisible(false);
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

        public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipalAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizarCatalogo;
    private javax.swing.JButton jButtonAñadirCatalogo;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonEliminarCoordinador;
    private javax.swing.JButton jButtonEliminarDirector;
    private javax.swing.JButton jButtonEliminarProfesor;
    private javax.swing.JButton jButtonRegistraDirectr;
    private javax.swing.JButton jButtonRegistrarCoordinador;
    private javax.swing.JButton jButtonRegistrarProfesor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNombreAdmin;
    private javax.swing.JLabel jLabelNombreAdmins;
    private javax.swing.JLabel jLabelTitle;
    // End of variables declaration//GEN-END:variables
}
