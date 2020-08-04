package GUIS;

import DataAccess.AdministradorDAO;
import DataAccess.DocenteDAO;
import Dominio.Administrador;
import Dominio.Docente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

Docente docente = null;
Administrador admin = null;
DocenteDAO docenteDAO = new DocenteDAO();
AdministradorDAO adminDAO = new AdministradorDAO();
ArrayList<Docente> todosLosDocentes = new ArrayList<Docente>();
ArrayList<Administrador> todosLosAdmin = new ArrayList<Administrador>();
    
    public Login() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCorreo = new javax.swing.JTextField();
        jButtonIniciarSesion = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jTextFieldContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Software para el Seguimiento de Desarrollo de Cursos");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Correo:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Contraseña:");

        jButtonIniciarSesion.setText("Iniciar Sesión");
        jButtonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSesionActionPerformed(evt);
            }
        });

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                            .addComponent(jTextFieldContraseña))))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonIniciarSesion)
                .addGap(37, 37, 37)
                .addComponent(jButtonSalir)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonIniciarSesion)
                    .addComponent(jButtonSalir))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarSesionActionPerformed
        iniciarSesion();
    }//GEN-LAST:event_jButtonIniciarSesionActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed
    
    void iniciarSesion () {
      boolean extraerProfesor = false;
      boolean extraerAdmin = false;
      try {
          extraerProfesor = extraerProfesor(jTextFieldCorreo.getText());
          extraerAdmin = extraerAdministrador(jTextFieldCorreo.getText());
      } catch (SQLException | ClassNotFoundException sqlException) {
        JOptionPane.showMessageDialog(this, "No es posible acceder a la base de datos");
        sqlException.printStackTrace();
        }
        if (extraerProfesor) {
                if (docente.getContraseña().equals(jTextFieldContraseña.getText())) {
                    VentanaPrincipalProfesor pantallaProfesor = new VentanaPrincipalProfesor(docente);
                    pantallaProfesor.setVisible(true);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Contraseña incorrecta.");
                }
        } else if (extraerAdmin) {
            if (admin.getContraseña().equals(jTextFieldContraseña.getText())) {
                VentanaPrincipalAdministrador pantallaAdmin = new VentanaPrincipalAdministrador(admin);
                pantallaAdmin.setVisible(true);
                setVisible(false);
            } else {
                 JOptionPane.showMessageDialog(this, "Contraseña incorrecta.");
            }
        } else {
             JOptionPane.showMessageDialog(this, "No encontramos ninguna coincidencia con el correo introducido. Intente de nuevo.");
             jTextFieldContraseña.setText("");
        }
    }
    
    boolean extraerProfesor(String correoProfesor) throws SQLException, ClassNotFoundException {
       int i = 0;
       boolean profesorEncontrado = false;
       todosLosDocentes = docenteDAO.leerTodosLosDocentes();
       while (i < todosLosDocentes.size() && !profesorEncontrado) {
           if (todosLosDocentes.get(i).getCorreo().equals(correoProfesor)) {
               docente = todosLosDocentes.get(i);
               profesorEncontrado = true;
           }
           i++;
       }
       return profesorEncontrado;
    }
    
    boolean extraerAdministrador (String correoAdmin) throws SQLException, ClassNotFoundException {
        int i = 0;
        boolean adminEncontrado = false;
        todosLosAdmin = adminDAO.leerTodosLosAdministradores();
        while (i < todosLosAdmin.size() && !adminEncontrado) {
            if (todosLosAdmin.get(i).getCorreo().equals(correoAdmin)) {
                admin = todosLosAdmin.get(i);
                adminEncontrado = true;
            }
            i++;
        }
        return adminEncontrado;
    }
    
     public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciarSesion;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jTextFieldContraseña;
    private javax.swing.JTextField jTextFieldCorreo;
    // End of variables declaration//GEN-END:variables
}
