package GUIS;

import DataAccess.ActividadDAO;
import DataAccess.CursoDAO;
import DataAccess.PlanDeCursoDAO;
import DataAccess.TemaDAO;
import Dominio.Actividad;
import Dominio.Curso;
import Dominio.Docente;
import Dominio.PlanDeCurso;
import Dominio.Tema;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegistrarPlanDeCurso extends javax.swing.JFrame {

    String nombreCurso;
    Curso curso;
    Docente docente;
    CursoDAO cursoDAO = new CursoDAO();
    PlanDeCursoDAO planDeCursoDAO = new PlanDeCursoDAO();
    TemaDAO temaDAO = new TemaDAO();
    ActividadDAO actividadDAO = new ActividadDAO();
    ArrayList<Tema> listaTemas = new ArrayList<Tema>();
    ArrayList<Actividad> listaActividades = new ArrayList<Actividad>();
    DefaultTableModel TablaTemas = new DefaultTableModel();
    DefaultTableModel TablaActividades = new DefaultTableModel();
    String valueInCell;
    String [] titulosTemas = {"Nombre del Tema", "Fecha Establecida"};
    String [] titulosActividades = {"Nombre de Actividad", "Tema de la Actividad"};
    boolean flag = false;
    
    public RegistrarPlanDeCurso(Docente docente) {
        this.docente = docente;
        try {
            flag = leerCursosDisponibles();
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "No es posible acceder a la base de datos.");
        }
        if (flag) {
            initComponents();
            this.setLocationRelativeTo(null);
            this.setTitle("Registrar Plan de Curso");
            TablaTemas.setColumnIdentifiers(titulosTemas);
            TablaActividades.setColumnIdentifiers(titulosActividades);
            jTableTemas.getTableHeader().setReorderingAllowed(false);
            jTableTemas.setDefaultEditor(Object.class, null);
            jTableActividades.getTableHeader().setReorderingAllowed(false);
            jTableActividades.setDefaultEditor(Object.class, null); 
            jLabelNombreCurso.setText(nombreCurso);
            JDatePlanListener();
            JDateTemaListener();
            JTableListener();
        } else {
            setVisible(false);
            VentanaPrincipalProfesor ventanaProfesor = new VentanaPrincipalProfesor(docente);
            ventanaProfesor.setVisible(true);
        }
    }
    
    public RegistrarPlanDeCurso() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Registrar Plan de Curso");
        TablaTemas.setColumnIdentifiers(titulosTemas);
        TablaActividades.setColumnIdentifiers(titulosActividades);
        jTableTemas.getTableHeader().setReorderingAllowed(false);
        jTableTemas.setDefaultEditor(Object.class, null);
        jTableActividades.getTableHeader().setReorderingAllowed(false);
        jTableActividades.setDefaultEditor(Object.class, null);
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButtonCancelar = new javax.swing.JButton();
        jButtonRegistrarPlan = new javax.swing.JButton();
        jLabelFechaFin = new javax.swing.JLabel();
        jLabelSeccionesRegistroPlanDeCurso = new javax.swing.JLabel();
        jLabelNombrePlan = new javax.swing.JLabel();
        jLabelFechaInicio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombreTema = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNombreActividad = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonRegistrarTema = new javax.swing.JButton();
        jButtonRegistrarActividad = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jDateChooserInicio = new com.toedter.calendar.JDateChooser();
        jDateChooserFin = new com.toedter.calendar.JDateChooser();
        jDateChooserInicioTema = new com.toedter.calendar.JDateChooser();
        jLabelNombreCurso = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableActividades = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTemas = new javax.swing.JTable();
        jLabelNombreTema = new javax.swing.JLabel();
        jDateChooserFinTema = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonCancelar.setBackground(new java.awt.Color(255, 153, 153));
        jButtonCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 670, 130, 40));

        jButtonRegistrarPlan.setBackground(new java.awt.Color(153, 255, 153));
        jButtonRegistrarPlan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonRegistrarPlan.setText("Registrar Plan");
        jButtonRegistrarPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarPlanActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrarPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 670, 130, 40));

        jLabelFechaFin.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelFechaFin.setText("Fecha Fin:");
        getContentPane().add(jLabelFechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, -1));

        jLabelSeccionesRegistroPlanDeCurso.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabelSeccionesRegistroPlanDeCurso.setText(" Registro Plan de Curso");
        getContentPane().add(jLabelSeccionesRegistroPlanDeCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jLabelNombrePlan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelNombrePlan.setText("Nombre del Curso:");
        getContentPane().add(jLabelNombrePlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        jLabelFechaInicio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelFechaInicio.setText("Fecha Inicio:");
        getContentPane().add(jLabelFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Temas del Plan de Curso ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 10));

        jLabel2.setText("Temas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jLabel3.setText("Actividades");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, -1, 10));

        jLabel4.setText("Nombre del tema:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jTextFieldNombreTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreTemaActionPerformed(evt);
            }
        });
        getContentPane().add(jTextFieldNombreTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 240, -1));

        jLabel5.setText("Fecha tentativa para finalizar tema: ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Actividades por tema");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, -1, -1));

        jLabel7.setText("Nombre de la actividad:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, 20));
        getContentPane().add(jTextFieldNombreActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 250, 240, -1));

        jButton1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jButton1.setText("Borrar Tema");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 100, 20));

        jButton2.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jButton2.setText("Borrar Actividad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 360, 110, 20));

        jButtonRegistrarTema.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jButtonRegistrarTema.setText("Registrar Tema");
        jButtonRegistrarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarTemaActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrarTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 110, 20));

        jButtonRegistrarActividad.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        jButtonRegistrarActividad.setText("Registrar Actividad");
        jButtonRegistrarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActividadActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegistrarActividad, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 130, 20));

        jLabel8.setText("Tema de la actividad:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));
        getContentPane().add(jDateChooserInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 160, 30));
        getContentPane().add(jDateChooserFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 160, 30));
        getContentPane().add(jDateChooserInicioTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 120, -1));

        jLabelNombreCurso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(jLabelNombreCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jTableActividades.setModel(TablaActividades);
        jTableActividades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTableActividades);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, 260, 210));

        jTableTemas.setModel(TablaTemas);
        jTableTemas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(jTableTemas);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 260, 210));

        jLabelNombreTema.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(jLabelNombreTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 210, 20));
        getContentPane().add(jDateChooserFinTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 120, -1));

        jLabel9.setText("Fecha tentativa para inicio del tema: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        int opcionSeleccionada = JOptionPane.showOptionDialog(this,"¿Seguro desea cancelar?", "Cancelar",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.CANCEL_OPTION, null, botonesCancelar, botonesCancelar[0] );

        if (opcionSeleccionada == 0) {
            regresarPrincipalProfesor();
        }

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonRegistrarPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarPlanActionPerformed
        //validarCampos();
        registrarPlanDeCurso();
        regresarPrincipalProfesor();
    }//GEN-LAST:event_jButtonRegistrarPlanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarTemaDeLista();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        borrarActividadDeLista();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldNombreTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreTemaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreTemaActionPerformed

    private void jButtonRegistrarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarTemaActionPerformed
        guardarTemaEnLista();
        actualizarFechaInicio();
    }//GEN-LAST:event_jButtonRegistrarTemaActionPerformed

    private void jButtonRegistrarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActividadActionPerformed
        guardarActividadEnLista();
    }//GEN-LAST:event_jButtonRegistrarActividadActionPerformed
    
    String [] botonesCancelar = {"Si", "No"};
    
    void regresarPrincipalProfesor(){
        VentanaPrincipalProfesor regresarAProfesor = new VentanaPrincipalProfesor(docente);
        regresarAProfesor.setVisible(true);
        dispose();
    }  
    
    boolean leerCursosDisponibles() throws SQLException, ClassNotFoundException {
        int i = 0; int x = 0; int estado = 0;
        int ESTADO_ACTIVO = 1;
        boolean cursosDisponibles = true;
        CursoDAO cursoDAO = new CursoDAO();
        String[] stringNombreDeCursos = null;
        ArrayList<Curso> todosLosCursos = new ArrayList<Curso>();
        ArrayList<Curso> todosLosCursosAUX = new ArrayList<Curso>();
        todosLosCursosAUX = cursoDAO.leerTodosLosCursosPorNumPersonal(docente.getNumPersonal());
        if (!todosLosCursosAUX.isEmpty()) {
            for (x = 0; x < todosLosCursosAUX.size();x++) {
                estado = todosLosCursosAUX.get(x).getEstado();
                if (estado != ESTADO_ACTIVO) {
                    todosLosCursos.add(todosLosCursosAUX.get(x));
                }
            }
            if (!todosLosCursos.isEmpty()) {
                List<String> nombreDeCursos = new ArrayList<>();
                while (i < todosLosCursos.size()) {
                   nombreDeCursos.add(todosLosCursos.get(i).getNombre());
                   i++;
                }
                stringNombreDeCursos = nombreDeCursos.toArray(new String[nombreDeCursos.size()]);
                JComboBox jComboBoxListaDeCursos = new JComboBox(stringNombreDeCursos);
                jComboBoxListaDeCursos.setEditable(true);
                JOptionPane.showMessageDialog(null, jComboBoxListaDeCursos, "Registrar Plan de Curso", JOptionPane.QUESTION_MESSAGE);
                nombreCurso = (String) jComboBoxListaDeCursos.getSelectedItem();
                for (i = 0; i < todosLosCursos.size(); i++) {
                    if (todosLosCursos.get(i).getNombre().equals(nombreCurso)) {
                        curso = todosLosCursos.get(i);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Todos los cursos cuentan con un Plan de Curso.");
                cursosDisponibles = false;
            }
        } else {
             JOptionPane.showMessageDialog(this, "No hay cursos disponibles para este(a) Docente.");
             cursosDisponibles = false;
        }
        return cursosDisponibles;
    }  
     
     void JDatePlanListener () {
        jDateChooserInicio.getDateEditor().addPropertyChangeListener(
            new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    Date tempDate = jDateChooserInicio.getDate();
                    Calendar c = Calendar.getInstance(); 
                    try {
                        c.setTime(tempDate);
                    } catch (NullPointerException ex ) {}
                    c.add(Calendar.DATE, 1);
                    tempDate = c.getTime();
                    jDateChooserFin.getJCalendar().setMinSelectableDate(tempDate);
                    jDateChooserInicioTema.getJCalendar().setMinSelectableDate(tempDate);
                }
            });
     }
     
     void JDateTemaListener () {
        jDateChooserInicioTema.getDateEditor().addPropertyChangeListener(
            new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent e) {
                    Date tempDate = jDateChooserInicioTema.getDate();
                    Calendar c = Calendar.getInstance(); 
                    c.setTime(tempDate); 
                    c.add(Calendar.DATE, 1);
                    tempDate = c.getTime();
                    jDateChooserFinTema.getJCalendar().setMinSelectableDate(tempDate);
                }
            });
     }
     
     void JTableListener() {
         jTableTemas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(final MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JTable jTable= (JTable)e.getSource();
                    int row = jTable.getSelectedRow();
                    int column = jTable.getSelectedColumn();
                    valueInCell = (String)jTable.getValueAt(row, column);
                    jLabelNombreTema.setText(valueInCell);
                }
        }
        });
     }
    
    Tema buscarTemaEnLista(String nombreTema) {
        Tema tema = null;
        boolean salirArreglo = false;
        int i = 0;
        while (i < listaTemas.size() && salirArreglo == false) {
            if (listaTemas.get(i).getNombreTema() == nombreTema) {
                tema = listaTemas.get(i);
                salirArreglo = true;
            }
            i++;
        }
        return tema;
    }
    
    void actualizarFechaInicio() {
        if (listaTemas.size() > 0) {
            Date tempDate = listaTemas.get(listaTemas.size()-1).getFechaFinTema();
            jDateChooserInicioTema.getJCalendar().setMinSelectableDate(tempDate);
        }
    }
    
    void guardarTemaEnLista() {
        if (!(jTextFieldNombreTema.getText().isEmpty()) || !(jDateChooserInicioTema.getDate() == null)) {
            Tema tema = new Tema();
            int i = 0;
            String [] filaTema = new String[2];
            String nombreTema = jTextFieldNombreTema.getText();
            Date fechaEstablecida = jDateChooserInicioTema.getDate();
            Date fechaFinTema = jDateChooserFinTema.getDate();
            tema.setNombreTema(nombreTema);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.format(fechaEstablecida);
            sdf.format(fechaFinTema);
            tema.setFechaEstablecida(fechaEstablecida);
            tema.setFechaFinTema(fechaFinTema);
            listaTemas.add(tema);
            filaTema[0] = nombreTema;
            filaTema[1] = String.valueOf(fechaEstablecida);
            TablaTemas.addRow(filaTema);
            jTextFieldNombreTema.setText("");
            jDateChooserInicioTema.setDate(null);
            jDateChooserFinTema.setDate(null);
        } else {
            JOptionPane.showMessageDialog(this, "No dejar campos vacíos.");
        }
    }
        
    
    void guardarActividadEnLista() {
        if (!(jTextFieldNombreActividad.getText().isEmpty())) {
            String nombreTema = valueInCell;
            Tema tema = buscarTemaEnLista(nombreTema);
            String [] filaActividad = new String[2];
            int i = 0;
            if (valueInCell == null) {
                JOptionPane.showMessageDialog(this, "Seleccione el Tema correspondiente a su actividad");
            } else {
                Actividad actividad = new Actividad();
                int idActividad = listaActividades.size() + 1;
                String nombreActividad = jTextFieldNombreActividad.getText();
                actividad.setIdActividad(idActividad);
                actividad.setNombreActividad(nombreActividad);
                actividad.setNombreTema(nombreTema);
                    listaActividades.add(actividad);
                    filaActividad[0] = nombreActividad;
                    filaActividad[1] = nombreTema;
                    TablaActividades.addRow(filaActividad);
           }
            jTextFieldNombreActividad.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "No deje campos vacíos.");
        }
    }
    
    void borrarTemaDeLista() {
        int columna = jTableTemas.getSelectedColumn();
        int fila = jTableTemas.getSelectedRow();
        String valorDeCelda = (String)jTableTemas.getValueAt(fila, columna);
        boolean salirDeCiclo = false;
        int i = 0; int indiceTema = 0;
        while (i < listaTemas.size() && !salirDeCiclo ) {
            if (listaTemas.get(i).getNombreTema() == valorDeCelda) {
                salirDeCiclo = true;
                indiceTema = i;
            }
            i++;
        }
        listaTemas.remove(indiceTema);
        TablaTemas.removeRow(fila);
    }
    
    void borrarActividadDeLista() {
        int columna = jTableActividades.getSelectedColumn();
        int fila = jTableActividades.getSelectedRow();
        String valorDeCelda = (String)jTableActividades.getValueAt(fila, columna);
        boolean salirDeCiclo = false;
        int i = 0; int indiceActividad = 0;
        while (i < listaActividades.size() && !salirDeCiclo ) {
            if (listaActividades.get(i).getNombreActividad() == valorDeCelda) {
                salirDeCiclo = true;
                indiceActividad = i;
            }
            i++;
        }
        listaActividades.remove(indiceActividad);
        TablaActividades.removeRow(fila);
    }

    PlanDeCurso llenarPlanDeCurso() {
        PlanDeCurso planDeCurso;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio = jDateChooserInicio.getDate();
        Date fechaFin = jDateChooserFin.getDate();
        sdf.format(fechaInicio);
        sdf.format(fechaFin);
        String NRCCurso = curso.getNrc();
        planDeCurso = new PlanDeCurso(curso.getNombre(), fechaInicio, fechaFin, NRCCurso);
        return planDeCurso;
    }
    
    boolean validarCamposRegistroPlan(){
        boolean validarCampos = false;
        if(jDateChooserInicio.getDate() == null || jDateChooserFin.getDate() == null) { 
            JOptionPane.showMessageDialog(this, "Favor de no dejar campos vacíos");
        } else {
            validarCampos = true;
        }
        return validarCampos;
    }
    
    void registrarTemaEnBase() {
        PlanDeCurso planDeCurso = new PlanDeCurso();
        Tema tema = new Tema();
        try {
            planDeCurso = planDeCursoDAO.leerPlanDeCursoConNombreCurso(nombreCurso);
        } catch (SQLException | ClassNotFoundException sqlException) {
                JOptionPane.showMessageDialog(this, "No es posible acceder ahora a la base de datos. ");
                sqlException.printStackTrace();                
        }
         for (int i = 0; i < listaTemas.size(); i++) {
            tema = listaTemas.get(i);
            tema.setIdPlan(planDeCurso.getIdPlan());
            try {
                temaDAO.guardarTema(tema);
            } catch (SQLException | ClassNotFoundException sqlException) {
                JOptionPane.showMessageDialog(this, "No es posible acceder ahora a la base de datos. ");
                sqlException.printStackTrace();                
            }
        }
    }
    
    void registrarActividadEnBase() {
        Actividad actividad = new Actividad();
        int i = 0; int x = 0;
        ArrayList<Actividad> listaActividadesConID = new ArrayList<Actividad>();
        try {
            listaTemas = temaDAO.leerTodosLosTemas();
        } catch (SQLException | ClassNotFoundException sqlException) {
                JOptionPane.showMessageDialog(this, "No es posible acceder ahora a la base de datos. ");
                sqlException.printStackTrace();                
        }
        for (i = 0; i < listaTemas.size(); i++) {
            for (x = 0; x < listaActividades.size(); x++) {
                if (listaTemas.get(i).getNombreTema().equals(listaActividades.get(x).getNombreTema())) {
                    actividad = listaActividades.get(x);
                    actividad.setIdTema(listaTemas.get(i).getIdTema());
                    listaActividadesConID.add(actividad);
                }
            }
        }
        for (i = 0; i < listaActividadesConID.size(); i++) {
            try {
                actividadDAO.guardarActividad(listaActividadesConID.get(i));
            }  catch (SQLException | ClassNotFoundException sqlException) {
                JOptionPane.showMessageDialog(this, "No es posible acceder ahora a la base de datos. ");
                sqlException.printStackTrace();
            }
        }
    }
    
    void registrarPlanDeCurso() {
        if (validarCamposRegistroPlan()) {
            PlanDeCurso planDeCurso = llenarPlanDeCurso();
            try {
                planDeCursoDAO.guardarPlanDeCurso(planDeCurso);
                cursoDAO.actualizarEstadoCurso(curso.getNrc());
            } catch (SQLException | ClassNotFoundException sqlException) {
                JOptionPane.showMessageDialog(this, "No es posible acceder ahora a la base de datos. ");
                sqlException.printStackTrace();
            }
            registrarTemaEnBase();
            registrarActividadEnBase();
            JOptionPane.showMessageDialog(this, "¡Operación exitosa!");
        } else { }
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
            java.util.logging.Logger.getLogger(RegistrarPlanDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPlanDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPlanDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPlanDeCurso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
       
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarPlanDeCurso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonRegistrarActividad;
    private javax.swing.JButton jButtonRegistrarPlan;
    private javax.swing.JButton jButtonRegistrarTema;
    private com.toedter.calendar.JDateChooser jDateChooserFin;
    private com.toedter.calendar.JDateChooser jDateChooserFinTema;
    private com.toedter.calendar.JDateChooser jDateChooserInicio;
    private com.toedter.calendar.JDateChooser jDateChooserInicioTema;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFechaFin;
    private javax.swing.JLabel jLabelFechaInicio;
    private javax.swing.JLabel jLabelNombreCurso;
    private javax.swing.JLabel jLabelNombrePlan;
    private javax.swing.JLabel jLabelNombreTema;
    private javax.swing.JLabel jLabelSeccionesRegistroPlanDeCurso;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableActividades;
    private javax.swing.JTable jTableTemas;
    private javax.swing.JTextField jTextFieldNombreActividad;
    private javax.swing.JTextField jTextFieldNombreTema;
    // End of variables declaration//GEN-END:variables
}
