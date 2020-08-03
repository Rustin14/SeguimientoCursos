/*MARIO DORANTES
**13/07/2020
*/
 
package GUIS;

import DataAccess.ActividadDAO;
import DataAccess.AvanceDeCursoDAO;
import DataAccess.CursoDAO;
import DataAccess.PlanDeCursoDAO;
import DataAccess.TemaDAO;
import Dominio.Actividad;
import Dominio.AvanceDeCurso;
import Dominio.Curso;
import Dominio.Docente;
import Dominio.PlanDeCurso;
import Dominio.Tema;
import LogicaDeNegocio.ValidacionesCurso;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegistrarAvanceDeCurso extends javax.swing.JFrame {
    
    AvanceDeCurso avanceDeCurso;
    Docente docente;
    String plan1;
    String nombreCurso;
    String nombreTema = null;
    String nombreActividad = null;
    Curso curso;
    Tema tema = new Tema();
    Actividad actividad = new Actividad();
    CursoDAO cursoDAO = new CursoDAO();
    PlanDeCurso planDeCurso = new PlanDeCurso();
    AvanceDeCursoDAO avanceDeCursoDAO = new AvanceDeCursoDAO();
    PlanDeCursoDAO planDeCursoDAO = new PlanDeCursoDAO();
    TemaDAO temaDAO = new TemaDAO();
    ActividadDAO actividadDAO = new ActividadDAO();
    ArrayList<Tema> listaTemas = new ArrayList<Tema>();
    ArrayList<Actividad> listaActividades = new ArrayList<Actividad>();
    ArrayList<Tema> listaTemasRegistrados = new ArrayList<Tema>();
    ArrayList<Actividad> listaActividadesRegistradas = new ArrayList<Actividad>();
    DefaultTableModel TablaTemas = new DefaultTableModel();
    DefaultTableModel TablaActividades = new DefaultTableModel();
    DefaultTableModel TablaTemasRegistrados = new DefaultTableModel();
    DefaultTableModel TablaActividadesRegistradas = new DefaultTableModel();
    String [] titulosTemas = {"Nombre del Tema", "Fecha Establecida"};
    String [] titulosActividades = {"Nombre de Actividad", "Tema de la Actividad"};
    
    public RegistrarAvanceDeCurso(Docente docente) {
        this.docente = docente;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Registrar Avance de Curso");
        try {
            leerPlanes();
        } catch (SQLException | ClassNotFoundException sqlException) {
            JOptionPane.showMessageDialog(this, "No se puede acceder a la base de datos en este momento. Intente más tarde.");
            sqlException.printStackTrace();
        }
        configurarGUI();
        listenerTablaTema();
        listenerTablaActividad();
    }
    
    public RegistrarAvanceDeCurso () {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Registrar Avance de Curso");
        try {
            leerPlanes();
        } catch (SQLException | ClassNotFoundException sqlException) {
            JOptionPane.showMessageDialog(this, "No se puede acceder a la base de datos en este momento. Intente más tarde.");
            sqlException.printStackTrace();
        }
        configurarGUI();
        listenerTablaTema();
        listenerTablaActividad();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane11 = new javax.swing.JScrollPane();
        jTableTemas1 = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTableActividades1 = new javax.swing.JTable();
        jLabelSeccionesAvanceDeCurso = new javax.swing.JLabel();
        jLabelFechaAvance = new javax.swing.JLabel();
        jLabelActividadesRealizadas = new javax.swing.JLabel();
        jLabelTemasAbordados = new javax.swing.JLabel();
        jButtonRegistrarPlan = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTableActividades = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldPorcentajeTema = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaObservacionesActividad = new javax.swing.JTextArea();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTableTemas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaObservacionesTema = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabelNombreActividad = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelNombreTema = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPorcentajeActividad = new javax.swing.JTextField();
        jButtonRegistrarTema = new javax.swing.JButton();
        jButtonRegistrarActividad = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableTemasRegistrados = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableActividadesRegistradas = new javax.swing.JTable();

        jTableTemas1.setModel(TablaTemas);
        jTableTemas1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane11.setViewportView(jTableTemas1);

        jTableActividades1.setModel(TablaActividades);
        jTableActividades1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane12.setViewportView(jTableActividades1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelSeccionesAvanceDeCurso.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelSeccionesAvanceDeCurso.setText("Avance de Curso");
        getContentPane().add(jLabelSeccionesAvanceDeCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        jLabelFechaAvance.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelFechaAvance.setText("Fecha de avance: ");
        getContentPane().add(jLabelFechaAvance, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        jLabelActividadesRealizadas.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelActividadesRealizadas.setText("Actividades Realizadas: ");
        getContentPane().add(jLabelActividadesRealizadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        jLabelTemasAbordados.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelTemasAbordados.setText("Temas Abordados:");
        getContentPane().add(jLabelTemasAbordados, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jButtonRegistrarPlan.setBackground(new java.awt.Color(153, 255, 153));
        jButtonRegistrarPlan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonRegistrarPlan.setText("Registrar Avance");
        jButtonRegistrarPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarPlanActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrarPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 700, 130, 40));

        jButtonCancelar.setBackground(new java.awt.Color(255, 153, 153));
        jButtonCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 700, 130, 40));
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 130, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nombre del curso:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, -1, -1));

        jTableActividades.setModel(TablaActividades);
        jTableActividades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane13.setViewportView(jTableActividades);

        getContentPane().add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 260, 90));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Porcentaje de avance del tema: ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));
        getContentPane().add(jTextFieldPorcentajeTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 90, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Observaciones de avance del tema (máx. 254 car.):");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        jTextAreaObservacionesActividad.setColumns(20);
        jTextAreaObservacionesActividad.setRows(5);
        jScrollPane3.setViewportView(jTextAreaObservacionesActividad);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 280, -1));

        jTableTemas.setModel(TablaTemas);
        jTableTemas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane14.setViewportView(jTableTemas);

        getContentPane().add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 260, 90));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Observaciones de actividad (máx. 254 car.):");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, -1, -1));

        jTextAreaObservacionesTema.setColumns(20);
        jTextAreaObservacionesTema.setRows(5);
        jScrollPane4.setViewportView(jTextAreaObservacionesTema);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 280, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("Nombre de actividad:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, -1));

        jLabelNombreActividad.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(jLabelNombreActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Nombre del tema:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, -1, -1));

        jLabelNombreTema.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        getContentPane().add(jLabelNombreTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Porcentaje de avance del actividad: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 450, -1, -1));
        getContentPane().add(jTextFieldPorcentajeActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 90, -1));

        jButtonRegistrarTema.setText("Registrar Tema");
        jButtonRegistrarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarTemaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrarTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, -1));

        jButtonRegistrarActividad.setText("Registrar Actividad");
        jButtonRegistrarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActividadActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrarActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 630, -1, -1));

        jTableTemasRegistrados.setModel(TablaTemasRegistrados);
        jScrollPane5.setViewportView(jTableTemasRegistrados);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 260, 90));

        jTableActividadesRegistradas.setModel(TablaActividadesRegistradas);
        jScrollPane1.setViewportView(jTableActividadesRegistradas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 260, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*    */
    private void jButtonRegistrarPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarPlanActionPerformed
        if (validarCampos()) {
            registrarAvanceDeCurso();
            registrarTema();
            registrarActividad();
            regresarPrincipalProfesor();
        }
    }//GEN-LAST:event_jButtonRegistrarPlanActionPerformed
    
    String [] botonesCancelar = {"Si", "No"}; 
    
    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        int opcionSeleccionada = JOptionPane.showOptionDialog(this,"¿Seguro desea cancelar?", "Cancelar",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.CANCEL_OPTION, null, botonesCancelar, botonesCancelar[0] );

        if (opcionSeleccionada == 0) {
            regresarPrincipalProfesor();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonRegistrarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarTemaActionPerformed
        try {
            guardarTemaEnLista();
        } catch (InterruptedException ex) {
            
        }
    }//GEN-LAST:event_jButtonRegistrarTemaActionPerformed

    private void jButtonRegistrarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActividadActionPerformed
        guardarActividadEnLista();
    }//GEN-LAST:event_jButtonRegistrarActividadActionPerformed
    
    void regresarPrincipalProfesor(){
        VentanaPrincipalProfesor regresarAProfesor = new VentanaPrincipalProfesor(docente);
        regresarAProfesor.setVisible(true);
        dispose();
    } 
    
    void configurarGUI() {
        TablaTemas.setColumnIdentifiers(titulosTemas);
        TablaActividades.setColumnIdentifiers(titulosActividades);
        TablaTemasRegistrados.setColumnIdentifiers(titulosTemas);
        TablaActividadesRegistradas.setColumnIdentifiers(titulosActividades);
        jTableTemas.getTableHeader().setReorderingAllowed(false);
        jTableTemas.setDefaultEditor(Object.class, null);
        jTableTemasRegistrados.getTableHeader().setReorderingAllowed(false);
        jTableTemasRegistrados.setDefaultEditor(Object.class, null);
        jTableActividades.getTableHeader().setReorderingAllowed(false);
        jTableActividades.setDefaultEditor(Object.class, null);
        jTableActividadesRegistradas.getTableHeader().setReorderingAllowed(false);
        jTableActividadesRegistradas.setDefaultEditor(Object.class, null);
        jLabel2.setText(nombreCurso);
        mostrarTemas();
        mostrarActividades();
    }
    
     void leerPlanes() throws SQLException, ClassNotFoundException {
        int i = 0;
        PlanDeCursoDAO planDAO = new PlanDeCursoDAO();
        ArrayList<Curso> todosLosCursos = cursoDAO.leerTodosLosCursos();
        String[] stringNombreDePlanes = null;
        ArrayList<PlanDeCurso> todosLosPlanes = planDAO.leerTodosLosPlanes();
        List<String> nombreDePlanes = new ArrayList<>();
        if (!todosLosPlanes.isEmpty()) { 
            while (i < todosLosPlanes.size()) {
                for (int x = 0; x < todosLosCursos.size(); x++) {
                    if (todosLosCursos.get(x).getNumeroDePersonal().equals(docente.getNumPersonal())) {
                        if (todosLosCursos.get(x).getNrc().equals(todosLosPlanes.get(i).getNRCCurso())) {
                            nombreDePlanes.add(todosLosPlanes.get(i).getNombreCurso());
                        }
                    }
                }
                i++;
            }
            stringNombreDePlanes = nombreDePlanes.toArray(new String[nombreDePlanes.size()]);
            JComboBox jComboBoxListaDePlanes = new JComboBox(stringNombreDePlanes);
            jComboBoxListaDePlanes.setEditable(true);
            JOptionPane.showMessageDialog(null, jComboBoxListaDePlanes, "Seleccione el Plan De Curso de su avance", JOptionPane.QUESTION_MESSAGE);
            nombreCurso = (String) jComboBoxListaDePlanes.getSelectedItem();
            for (i = 0; i < todosLosPlanes.size(); i++) {
                if (todosLosPlanes.get(i).getNombreCurso().equals(nombreCurso)) {
                    planDeCurso = todosLosPlanes.get(i);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay planes de curso registrados para ningún curso.");
        }
    } 
    
     void mostrarTemas() {
        ArrayList<Tema> todosLosTemas = new ArrayList<Tema>();
        try {
            todosLosTemas = temaDAO.leerTodosLosTemas();
        } catch (SQLException | ClassNotFoundException sqlException) {
            JOptionPane.showMessageDialog(this, "No se puede acceder a la base de datos en este momento. Intente más tarde.");
            sqlException.printStackTrace();
        }
        for (int i = 0; i < todosLosTemas.size(); i++) {
            if (planDeCurso.getIdPlan() == todosLosTemas.get(i).getIdPlan()) {
                String [] filaTema = new String[2];
                filaTema[0] = todosLosTemas.get(i).getNombreTema();
                filaTema[1] = String.valueOf(todosLosTemas.get(i).getFechaEstablecida());
                TablaTemas.addRow(filaTema);
                listaTemas.add(todosLosTemas.get(i));
            }
        }
    }
     
     void mostrarActividades(){
        ArrayList<Actividad> todasLasActividades = new ArrayList<Actividad>();
         try {
            todasLasActividades = actividadDAO.leerTodasLasActividades();
        } catch (SQLException | ClassNotFoundException sqlException) {
            JOptionPane.showMessageDialog(this, "No se puede acceder a la base de datos en este momento. Intente más tarde.");
            sqlException.printStackTrace();
        }
        for (int i = 0; i < todasLasActividades.size(); i++) {
            for (int x = 0; x < listaTemas.size(); x++) {
                if (listaTemas.get(x).getIdTema() == todasLasActividades.get(i).getIdTema()) {
                    String [] filaActividad = new String[2];
                    filaActividad[0] = todasLasActividades.get(i).getNombreActividad();
                    filaActividad[1] = String.valueOf(todasLasActividades.get(i).getNombreTema());
                    TablaActividades.addRow(filaActividad);
                    listaActividades.add(todasLasActividades.get(i));
                }
            }
        }
    }
     
    void listenerTablaTema () {
        jTableTemas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable jTable = (JTable)e.getSource();
                    int columna = jTable.getSelectedColumn();
                    int fila = jTable.getSelectedRow();
                    nombreTema = (String)jTable.getValueAt(fila, columna);
                    jLabelNombreTema.setText(nombreTema);
                    String [] filaTema = new String[2];
                    int i = 0;
                    while (i < listaTemas.size()) {
                        if (listaTemas.get(i).getNombreTema().equals(nombreTema)) {
                            filaTema[0] = listaTemas.get(i).getNombreTema();
                            filaTema[1] = String.valueOf(listaTemas.get(i).getFechaEstablecida());
                            tema = listaTemas.get(i);
                            listaTemas.remove(i);
                        }
                        i++;
                    }
                    TablaTemasRegistrados.addRow(filaTema);          
                    TablaTemas.removeRow(fila);
                }
            }
        });
    }
    
    void listenerTablaActividad () {
         jTableActividades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable jTable= (JTable)e.getSource();
                    int columna = jTable.getSelectedColumn();
                    int fila = jTable.getSelectedRow();
                    nombreActividad = (String)jTable.getValueAt(fila, columna);
                    jLabelNombreActividad.setText(nombreActividad);
                    String [] filaActividad = new String[2];
                    boolean salirDeCiclo = false;
                    int i = 0; 
                    while (i < listaActividades.size() && !salirDeCiclo ) {
                        if (listaActividades.get(i).getNombreActividad().equals(nombreActividad)) {
                            filaActividad[0] = listaActividades.get(i).getNombreActividad();
                            filaActividad[1] = listaActividades.get(i).getNombreActividad();
                            actividad = listaActividades.get(i);
                            listaActividades.remove(i);
                        }
                        i++;
                    }
                    TablaActividadesRegistradas.addRow(filaActividad);
                    TablaActividades.removeRow(fila);
                }
            }
        });
    }
    
    void guardarTemaEnLista() throws InterruptedException {
        Tema temaTemporal = new Tema();
        temaTemporal = tema;
        temaTemporal.setObservaciones(jTextAreaObservacionesTema.getText());
        temaTemporal.setPorcentajeAvance(jTextFieldPorcentajeTema.getText());
        listaTemasRegistrados.add(temaTemporal);
        jTextFieldPorcentajeTema.setText("");
        jTextAreaObservacionesTema.setText("");
        JOptionPane.showMessageDialog(this, "Tema actualizado y agregado a lista de registro.");
    }
    
    void guardarActividadEnLista() {
        Actividad actividadTemporal = new Actividad();
        actividadTemporal = actividad;
        actividadTemporal.setObservaciones(jTextAreaObservacionesActividad.getText());
        actividadTemporal.setPorcentajeAvance(jTextFieldPorcentajeActividad.getText());
        listaActividadesRegistradas.add(actividadTemporal);
        jTextFieldPorcentajeActividad.setText("");
        jTextAreaObservacionesActividad.setText("");
        JOptionPane.showMessageDialog(this, "Tema actualizado y agregado a lista de registro.");
    } 
    
    AvanceDeCurso llenarAvanceDeCurso() {
       AvanceDeCurso avance;
       Date fechaAvance = jDateChooser1.getDate();
       int idPlan = 0;
       try {
            idPlan = planDeCursoDAO.leerPlanDeCursoConNombreCurso(nombreCurso).getIdPlan();
        } catch (SQLException | ClassNotFoundException sqlException) {
            JOptionPane.showMessageDialog(this, "No se puede acceder a la base de datos en este momento. Intente más tarde.");
            sqlException.printStackTrace();
        }
       avance = new AvanceDeCurso(fechaAvance, idPlan, planDeCurso.getNRCCurso());
       return avance;
    }
    
    
    boolean validarCampos(){
        boolean camposValidos = true;
        if(jDateChooser1.getDate() == null){
            JOptionPane.showMessageDialog(this, "Favor de no dejar campos vacíos");
            camposValidos = false;
        }
     return camposValidos;   
    }
    
    void registrarTema() {
        AvanceDeCurso avance = new AvanceDeCurso();
        Tema temaAvance = new Tema();
        try {
            avance = avanceDeCursoDAO.leerAvanceDeCursoPorIDPlan(planDeCurso.getIdPlan());
        } catch (SQLException | ClassNotFoundException sqlException) {
                JOptionPane.showMessageDialog(this, "No es posible acceder ahora a la base de datos. ");
                sqlException.printStackTrace();                
        }
         for (int i = 0; i < listaTemasRegistrados.size(); i++) {
            temaAvance = listaTemasRegistrados.get(i);
            temaAvance.setIdAvance(avance.getIdAvance());
            try {
                temaDAO.actualizarTema(temaAvance);
            } catch (SQLException | ClassNotFoundException sqlException) {
                JOptionPane.showMessageDialog(this, "No es posible acceder ahora a la base de datos. ");
                sqlException.printStackTrace();                
            }
        }
    }
    
    void registrarActividad() {
        AvanceDeCurso avance = new AvanceDeCurso();
        Actividad actividadAvance = new Actividad();
        try {
            avance = avanceDeCursoDAO.leerAvanceDeCursoPorIDPlan(planDeCurso.getIdPlan());
        } catch (SQLException | ClassNotFoundException sqlException) {
                JOptionPane.showMessageDialog(this, "No es posible acceder ahora a la base de datos. ");
                sqlException.printStackTrace();                
        }
         for (int i = 0; i < listaActividadesRegistradas.size(); i++) {
            actividadAvance = listaActividadesRegistradas.get(i);
            actividadAvance.setIdAvance(avance.getIdAvance());
            try {
                actividadDAO.actualizarActividad(actividadAvance);
            } catch (SQLException | ClassNotFoundException sqlException) {
                JOptionPane.showMessageDialog(this, "No es posible acceder ahora a la base de datos. ");
                sqlException.printStackTrace();                
            }
        }
    }
    
    void registrarAvanceDeCurso() {
        AvanceDeCurso avance = llenarAvanceDeCurso();
        try {
            avanceDeCursoDAO.guardarAvanceDeCurso(avance);
        } catch (SQLException | ClassNotFoundException sqlException) {
            JOptionPane.showMessageDialog(this, "No se puede acceder a la base de datos en este momento. Intente más tarde.");
            sqlException.printStackTrace();
        }
        JOptionPane.showMessageDialog(this, "¡Operación exitosa!");
    }
    
    public static void main(String args[]) {
  
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarAvanceDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarAvanceDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarAvanceDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarAvanceDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarAvanceDeCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonRegistrarActividad;
    private javax.swing.JButton jButtonRegistrarPlan;
    private javax.swing.JButton jButtonRegistrarTema;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelActividadesRealizadas;
    private javax.swing.JLabel jLabelFechaAvance;
    private javax.swing.JLabel jLabelNombreActividad;
    private javax.swing.JLabel jLabelNombreTema;
    private javax.swing.JLabel jLabelSeccionesAvanceDeCurso;
    private javax.swing.JLabel jLabelTemasAbordados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableActividades;
    private javax.swing.JTable jTableActividades1;
    private javax.swing.JTable jTableActividadesRegistradas;
    private javax.swing.JTable jTableTemas;
    private javax.swing.JTable jTableTemas1;
    private javax.swing.JTable jTableTemasRegistrados;
    private javax.swing.JTextArea jTextAreaObservacionesActividad;
    private javax.swing.JTextArea jTextAreaObservacionesTema;
    private javax.swing.JTextField jTextFieldPorcentajeActividad;
    private javax.swing.JTextField jTextFieldPorcentajeTema;
    // End of variables declaration//GEN-END:variables
}
