/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercambios;

import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.temporal.ChronoUnit;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;

/**
 *
 * @author Francisco Aramburu
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    ArrayList<Expediante>  arre;
    ArrayList<Departamentos>  arreDep;
    int n;
    boolean uno;
    boolean dos;
    boolean tres;
    LocalDate ultimo;
    @SuppressWarnings("unchecked")
    public Interfaz() {
        initComponents();
        escribe.setText("");
        arre = new ArrayList<>();
        arreDep = new ArrayList<>();
        lee();
        leeAct();
        actualiza();
        guardarAct();
        guardar();
        leeDepartamentos();
        dllNuevo.add("17-01");
        dllNuevo.add("17-02");
        dllNuevo.add("17-03");
        dllNuevo.add("18-01");
        dllNuevo.add("18-02");
        dllNuevo.add("18-03");
        dllNuevo.add("19-01");
        dllNuevo.add("19-02");
        dllNuevo.add("19-03");
        dllNuevo.add("20-01");
        dllNuevo.add("20-02");
        dllNuevo.add("20-03");
        dllNuevo.add("21-01");
        dllNuevo.add("21-02");
        dllNuevo.add("21-03");
        dllNuevo.add("22-01");
        dllNuevo.add("22-02");
        dllNuevo.add("22-03");
        dllNuevo.add("23-01");
        dllNuevo.add("23-02");
        dllNuevo.add("23-03");
    }
    public void guardar(){
        try {
            File file = new File("Guardados.txt");
            Scanner input = new Scanner(file);
            try (PrintWriter writer = new PrintWriter(file)) {
                file.delete();
                writer.print("");
            }
            // Escribe Archivo
            int j = arre.size();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Guardados.txt"))) {
                for(int i = 0 ;i<j;i++){
                    bw.write(arre.get(i).getCu() + "");
                    bw.write(" ");
                    bw.write(arre.get(i).getPeriodo() + "");
                    bw.write(" ");
                    bw.write(arre.get(i).getCreaExp() + "");
                    bw.write(" ");
                    bw.write(arre.get(i).getPrimerEnvioSE() + "");
                    bw.write(" ");
                    bw.write(arre.get(i).getCorreoAlReciv() + "");
                    bw.write(" ");
                    
                    bw.write(arre.get(i).getSolDeCRNs() + "");
                    bw.write(" ");
                    
                    
                    bw.write(arre.get(i).getCopiaEnvASSySE() + "");
                    bw.write(" ");
                    bw.write(arre.get(i).getLleganExpYCrn() + "");
                    bw.write(" ");
                    bw.write(arre.get(i).getCrnGenerado() + "");
                    bw.write(" ");
                    bw.write(arre.get(i).getEnvioCrnSE() + "");
                    bw.write(" ");
                    bw.write(arre.get(i).getActasGeneradas() + "");
                    bw.write(" " + "\n");
                    
                    bw.write(arre.get(i).getAuxiliarTranscript() + "");
                    bw.write(" " + "\n");
                    
                    
                    bw.write(arre.get(i).getTranscript() + "");
                    bw.write(" " + "\n");
                    bw.write(arre.get(i).getEnvioDepAcad() + "");
                    bw.write(" " + "\n");
                    bw.write(arre.get(i).getRegresoDepAcad() + "");
                    bw.write(" " + "\n");
                    
                    bw.write(arre.get(i).getPendPre() + "");
                    bw.write(" " + "\n");
                    
                    bw.write(arre.get(i).getEntregaDE() + "");
                    bw.write(" " + "\n");
                }
                
            } catch (Exception e) {
                throw new ErrorWritingDocumentException();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Expediante.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void lee(){
       try {
           File file = new File("Guardados.txt");
           try (Scanner input = new Scanner(file)) {
               while(input.hasNext()) {
                   int cuL = Integer.parseInt(input.next());
                   String perL = input.next();
                   LocalDate creaExpL = LocalDate.parse(input.next());
                   LocalDate primerEnvioSEL = LocalDate.parse(input.next());
                   LocalDate correoAlRecivL = LocalDate.parse(input.next());
                   LocalDate copiaEnvASSySEL = LocalDate.parse(input.next());

                   LocalDate solDeCRNsL = LocalDate.parse(input.next());

                   LocalDate lleganExpYCrnL = LocalDate.parse(input.next());
                   LocalDate crnGeneradoL = LocalDate.parse(input.next());
                   LocalDate envioCrnSEL = LocalDate.parse(input.next());
                   LocalDate actasGeneradasL = LocalDate.parse(input.next());

                   LocalDate auxiliarTranscriptL = LocalDate.parse(input.next());
                   LocalDate transcriptL = LocalDate.parse(input.next());

                   LocalDate envioDepAcadL = LocalDate.parse(input.next());
                   LocalDate regresoDepAcadL = LocalDate.parse(input.next());
                   boolean pendientes = Boolean.parseBoolean(input.next());
                   LocalDate entregaDEL = LocalDate.parse(input.next());
                   Expediante nuevo = new Expediante(cuL, perL, creaExpL, primerEnvioSEL, correoAlRecivL, copiaEnvASSySEL, solDeCRNsL, lleganExpYCrnL, crnGeneradoL, envioCrnSEL, actasGeneradasL, auxiliarTranscriptL, transcriptL, envioDepAcadL, regresoDepAcadL, pendientes, entregaDEL);
                   arre.add(nuevo);
               }
               input.close();
           }

       } catch (FileNotFoundException ex) {
           Logger.getLogger(Expediante.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    public void leeAct(){
       try {
           File file = new File("Actu.txt");
           try (Scanner input = new Scanner(file)) {
               while(input.hasNext()) {
                   ultimo = LocalDate.parse(input.next()); 
                   uno = Boolean.parseBoolean(input.next());
                   dos = Boolean.parseBoolean(input.next());
                   tres = Boolean.parseBoolean(input.next());
               }
               input.close();

           }
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Expediante.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    public void guardarAct(){
        try {
            File file = new File("Actu.txt");
            Scanner input = new Scanner(file);
            try (PrintWriter writer = new PrintWriter(file)) {
                file.delete();
                writer.print("");
                 
            }
            // Escribe Archivo
           
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Actu.txt"))) {
                
                bw.write(LocalDate.now()+"");
                bw.write(" ");
                bw.write(uno + "");
                bw.write(" ");
                bw.write(dos + "");
                bw.write(" ");
                bw.write(tres + "");
                bw.write(" ");
                    
                
                bw.close();
            } catch (Exception e) {
                
                throw new ErrorWritingDocumentException();
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Expediante.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void actualiza(){
    String clave;
    LocalDate hoy = LocalDate.now();
    if(ultimo.isBefore(hoy)){
        if(uno && dos && tres){
            if(hoy.getYear() == ultimo.getYear() + 1){
                clave = hoy.getYear()-2001 + "-03";
                dos = false;
                tres = false;
                int j = arre.size();
                for(int i = 0;i<j;i++){
                    if(((String)(arre.get(i).getPeriodo())).matches(clave)){
                        arre.get(i).setAuxiliarTranscript(hoy);
                    }
                }
            }
        }
        //Cambio 2001 por 2000, 2001 es cuando cambia el año.
        else if (uno && !dos && !tres){
            if(hoy.isAfter(LocalDate.of(hoy.getYear(), Month.JUNE,1)) && ultimo.isBefore(LocalDate.of(hoy.getYear(), Month.JUNE,1)) ){
                clave = hoy.getYear()-2000 + "-01";
                dos = true;
                int j = arre.size();
                for(int i = 0;i<j;i++){
                    if(((String)(arre.get(i).getPeriodo())).matches(clave)){
                        arre.get(i).setAuxiliarTranscript(hoy);
                    }
                }
            }
        }
        else if (uno && dos && !tres){
            if(hoy.isAfter(LocalDate.of(hoy.getYear(), Month.AUGUST,1)) && ultimo.isBefore(LocalDate.of(hoy.getYear(), Month.AUGUST,1))){
                clave = hoy.getYear()-2000 + "-02";
                tres = true;
                int j = arre.size();
                for(int i = 0;i<j;i++){
                    if(((String)(arre.get(i).getPeriodo())).matches(clave)){
                        arre.get(i).setAuxiliarTranscript(hoy);
                    }
                }
            }
        }
    }
    }
    
    public void leeDepartamentos(){
       try {
            File file = new File("Departamentos.txt");
            try (Scanner input = new Scanner(file)) {
                while(input.hasNext()) {
                   int cu = Integer.parseInt(input.next());
                   String per = input.next();
                   int adm = Integer.parseInt(input.next());
                   int cle = Integer.parseInt(input.next());
                   int com = Integer.parseInt(input.next());
                   int con = Integer.parseInt(input.next());
                   int cso = Integer.parseInt(input.next());
                   int der = Integer.parseInt(input.next());
                   int eco = Integer.parseInt(input.next());
                   int ein = Integer.parseInt(input.next());
                   int est = Integer.parseInt(input.next());
                   int egn = Integer.parseInt(input.next());
                   int len = Integer.parseInt(input.next());
                   int mat = Integer.parseInt(input.next());
                   int sdi = Integer.parseInt(input.next());
                   int iio = Integer.parseInt(input.next());
                   boolean bAdm = Boolean.parseBoolean(input.next());
                   boolean bCle = Boolean.parseBoolean(input.next());
                   boolean bCom = Boolean.parseBoolean(input.next());
                   boolean bCon = Boolean.parseBoolean(input.next());
                   boolean bCso = Boolean.parseBoolean(input.next());
                   boolean bDer = Boolean.parseBoolean(input.next());
                   boolean bEco = Boolean.parseBoolean(input.next());
                   boolean bEin = Boolean.parseBoolean(input.next());
                   boolean bEst = Boolean.parseBoolean(input.next());
                   boolean bEgn = Boolean.parseBoolean(input.next());
                   boolean bLen = Boolean.parseBoolean(input.next());
                   boolean bMat = Boolean.parseBoolean(input.next());
                   boolean bSdi = Boolean.parseBoolean(input.next());
                   boolean bIio = Boolean.parseBoolean(input.next());
                   
                   Departamentos nuevo = new Departamentos(cu, per, adm, cle, com, con, cso, der, eco, ein, est, egn, len, mat, sdi, iio, bAdm, bCle, bCom, bCon, bCso, bDer, bEco, bEin, bEst, bEgn, bLen, bMat, bSdi, bIio);
                   arreDep.add(nuevo);
               }
               input.close();
               
           }

       } catch (FileNotFoundException ex) {
           Logger.getLogger(Expediante.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    
    public void guardarDepartamentos(){
        try {
            File file = new File("Departamentos.txt");
            Scanner input = new Scanner(file);
            try (PrintWriter writer = new PrintWriter(file)) {
                file.delete();
                writer.print("");
            
            // Escribe Archivo
            int j = arre.size();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("Departamentos.txt"))) {
                for(int i = 0 ;i<j;i++){
                    bw.write(arreDep.get(i).getCu() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getPeriodo() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getAdm() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getCle() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getCom() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getCon() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getCso() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getDer() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getEco() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getEin() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getEst() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getEgn() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getLen() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getMat() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getSdi() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).getIio() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbAdm() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbCle() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbCom() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbCon() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbCso() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbDer() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbEco() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbEin() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbEst() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbEgn() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbLen() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbMat() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbSdi() + "");
                    bw.write(" ");
                    bw.write(arreDep.get(i).isbIio() + "");
                    bw.write(" " + "\n");
                }

            } catch (Exception e) {
                throw new ErrorWritingDocumentException();
                
            }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Expediante.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        escribe = new java.awt.TextArea();
        cuNuevo = new java.awt.TextField();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        cuCons = new java.awt.TextField();
        label6 = new java.awt.Label();
        label7 = new java.awt.Label();
        cuAct = new java.awt.TextField();
        btnCrear = new java.awt.Button();
        btnConsExp = new java.awt.Button();
        btnElige = new java.awt.Button();
        btnAct = new java.awt.Button();
        btnConsFechas = new java.awt.Button();
        act3 = new java.awt.Checkbox();
        act4 = new java.awt.Checkbox();
        act5 = new java.awt.Checkbox();
        act6 = new java.awt.Checkbox();
        act7 = new java.awt.Checkbox();
        label9 = new java.awt.Label();
        cons2 = new java.awt.Checkbox();
        cons3 = new java.awt.Checkbox();
        cons4 = new java.awt.Checkbox();
        btnMostrarTodosLosExpedientes = new java.awt.Button();
        act2 = new java.awt.Checkbox();
        act8 = new java.awt.Checkbox();
        act9 = new java.awt.Checkbox();
        act10 = new java.awt.Checkbox();
        btnLimpiar = new java.awt.Button();
        act11 = new java.awt.Checkbox();
        cons5 = new java.awt.Checkbox();
        dllNuevo = new java.awt.Choice();
        label3 = new java.awt.Label();
        label8 = new java.awt.Label();
        act12 = new java.awt.Checkbox();
        act13 = new java.awt.Checkbox();
        cons6 = new java.awt.Checkbox();
        label10 = new java.awt.Label();
        ddlAct = new java.awt.Choice();
        btnElExp1 = new java.awt.Button();
        btnElimina = new java.awt.Button();
        btnDetalle = new java.awt.Button();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escribe.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        escribe.setEditable(false);

        cuNuevo.setName("cuNuevo"); // NOI18N

        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setText("Nuevo Expediente");

        label2.setText("Clave Única");

        label4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label4.setText("Consulta Expediente");

        label5.setText("Clave Única");

        cuCons.setName("cuCons"); // NOI18N

        label6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label6.setText("Actualiza Expediente");

        label7.setText("Clave Única");

        cuAct.setName("cuAct"); // NOI18N

        btnCrear.setLabel("Crear");
        btnCrear.setName("btnCrear"); // NOI18N
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnConsExp.setLabel("Consultar");
        btnConsExp.setName("btnConsExp"); // NOI18N
        btnConsExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsExpActionPerformed(evt);
            }
        });

        btnElige.setLabel("Elige Periodo");
        btnElige.setName("btnElige"); // NOI18N
        btnElige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEligeActionPerformed(evt);
            }
        });

        btnAct.setEnabled(false);
        btnAct.setLabel("Actualizar");
        btnAct.setName("btnAct"); // NOI18N
        btnAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActActionPerformed(evt);
            }
        });

        btnConsFechas.setLabel("Consultar");
        btnConsFechas.setName("btnConsFechas"); // NOI18N
        btnConsFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsFechasActionPerformed(evt);
            }
        });

        act3.setLabel("Copia enviada a SS y SE");
        act3.setName("act3"); // NOI18N

        act4.setLabel("Llegan exp. y CRN's");
        act4.setName("act4"); // NOI18N

        act5.setLabel("CRN's Generados");
        act5.setName("act5"); // NOI18N

        act6.setLabel("Envío CRN´s a SE");
        act6.setName("act6"); // NOI18N

        act7.setLabel("Actas Generadas");
        act7.setName("act7"); // NOI18N

        label9.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label9.setText("Consulta Fechas");

        cons2.setLabel("Espera de CRN's");
        cons2.setName("cons2"); // NOI18N
        cons2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cons2MouseClicked(evt);
            }
        });

        cons3.setLabel("Espera para Insc. de Materia");
        cons3.setName("cons3"); // NOI18N
        cons3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cons3MouseClicked(evt);
            }
        });

        cons4.setLabel("Calificaciones de Intercambio");
        cons4.setName("cons4"); // NOI18N
        cons4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cons4MouseClicked(evt);
            }
        });

        btnMostrarTodosLosExpedientes.setBackground(new java.awt.Color(240, 240, 240));
        btnMostrarTodosLosExpedientes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnMostrarTodosLosExpedientes.setLabel("Mostrar Expedientes Guardados");
        btnMostrarTodosLosExpedientes.setName("btnMostrarTodosLosExpedientes"); // NOI18N
        btnMostrarTodosLosExpedientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodosLosExpedientesActionPerformed(evt);
            }
        });

        act2.setLabel("Correo de Alumno Recibido");
        act2.setName("act2"); // NOI18N

        act8.setLabel("Envío a Dep. Acad");
        act8.setName("act8"); // NOI18N

        act9.setLabel("Regreso de Dep. Acad.");
        act9.setName("act9"); // NOI18N

        act10.setLabel("Entrega Dir. Esc.");
        act10.setName("act10"); // NOI18N

        btnLimpiar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnLimpiar.setLabel("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        act11.setLabel("Solicitud de CRNs");
        act11.setName("act3"); // NOI18N

        cons5.setLabel("Espera Dep. Acad.");
        cons5.setName("cons4"); // NOI18N
        cons5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cons5MouseClicked(evt);
            }
        });

        label3.setText("Periodo de Intercambio");
        label3.setVisible(false);

        label8.setText("Pediodo");

        act12.setLabel("Transcript");

        act13.setLabel("Pendiente Prerequisitos");

        cons6.setLabel("Pendiente Prerequisitos");
        cons6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cons6MouseClicked(evt);
            }
        });

        label10.setText("Pediodo");

        btnElExp1.setLabel("EligeExpediente");
        btnElExp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElExp1ActionPerformed(evt);
            }
        });

        btnElimina.setEnabled(false);
        btnElimina.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnElimina.setLabel("Borrar Expediente");
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaActionPerformed(evt);
            }
        });

        btnDetalle.setEnabled(false);
        btnDetalle.setLabel("Detalle");
        btnDetalle.setName("btnDetalle"); // NOI18N
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnMostrarTodosLosExpedientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(cuNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(58, 58, 58)
                                        .addComponent(dllNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnConsExp, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cuCons, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cons2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cons3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cons4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cons5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(btnConsFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cons6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(act3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(act2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(act6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(act5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(act7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(act4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(act8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(btnDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(act9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(act10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(act11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(act12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(act13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cuAct, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(ddlAct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnElExp1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnElige, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(escribe, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(escribe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cuAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElExp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ddlAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnElige, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(act2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(act3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(act11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(act4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(act5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(act6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(act7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(act12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(act8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(act9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(act13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(act10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cuNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(dllNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cuCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnConsExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(55, 55, 55)
                                .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cons2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cons3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cons4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cons6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cons5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConsFechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMostrarTodosLosExpedientes, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        btnElige.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        int cu;
        String per;
        Expediante exp;
        btnAct.setEnabled(false);
        boolean ban = false;
        int i =0; 
        int max = arre.size();
        try{
                cu = Integer.parseInt(cuNuevo.getText());
                per = dllNuevo.getSelectedItem();
                while(!ban && i<max){
                    if((Integer)(arre.get(i).getCu()) == cu){
                        if(((String)(arre.get(i).getPeriodo())).matches(per))
                            ban = true;
                            //escribe.setText(arre.get(i).toString());
                    }
                    i=i+1;
                }
                if(ban){
                    escribe.setText("El expediente ya existe"); 
                }
                else{
                    exp = new Expediante(cu,per);
                    escribe.setText("Expediente creado exitosamente.");
                    arre.add(exp);
                    guardar();
                }
            }catch(NumberFormatException e){
                escribe.setText("Error, introduzca un número válido.");
            }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        cuNuevo.setText(" ");
        cuAct.setText(" ");
        cuCons.setText(" ");
        cuNuevo.setText("");
        cuAct.setText("");
        cuCons.setText("");
        escribe.setText(" ");
       
        act2.setState(false);
        act3.setState(false);
        act4.setState(false);
        act5.setState(false);
        act6.setState(false);
        act7.setState(false);
        act8.setState(false);
        act9.setState(false);
        act10.setState(false);
        act11.setState(false);
        act12.setState(false);
        act13.setState(false);
        
        act2.setEnabled(true);
        act3.setEnabled(true);
        act4.setEnabled(true);
        act5.setEnabled(true);
        act6.setEnabled(true);
        act7.setEnabled(true);
        act8.setEnabled(true);
        act9.setEnabled(true);
        act10.setEnabled(true);
        act11.setEnabled(true);
        act12.setEnabled(true);
        act13.setEnabled(true);
       
        cons2.setState(false);
        cons3.setState(false);
        cons4.setState(false);  
        cons5.setState(false); 
        cons6.setState(false); 
        btnAct.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnMostrarTodosLosExpedientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosLosExpedientesActionPerformed
        // TODO add your handling code here:
        int k = arre.size();
        escribe.setText(" ");
        for(int m = 0; m<k ; m++){
            escribe.append("Expediente " + arre.get(m).getCu() + " Periodo " + arre.get(m).getPeriodo()+"\n");
        }
        if(k==0){
            escribe.setText("No hay expedientes");
        }
    }//GEN-LAST:event_btnMostrarTodosLosExpedientesActionPerformed

    private void btnConsExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsExpActionPerformed
        // TODO add your handling code here:
        ArrayList<String>  periodos = new  ArrayList<>();
        btnAct.setEnabled(false);
        int cu;
        int i = 0;
        escribe.setText("");
        int max = arre.size();
        try{
            cu = parseInt(cuCons.getText());
            while(i<max){
                if((Integer)(arre.get(i).getCu()) == cu){
                    if(!periodos.contains((String)(arre.get(i).getPeriodo()))){
                        escribe.append(arre.get(i).toString()+"\n------------------------------------------------------------------\n");
                        periodos.add((String)(arre.get(i).getPeriodo()));
                    }
                }
                i=i+1;
            }
        }catch(NumberFormatException e){
                escribe.setText("Error, introduzca un número válido.");
            }        
    }//GEN-LAST:event_btnConsExpActionPerformed

    private void btnEligeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEligeActionPerformed
        // TODO add your handling code here:
        int cu;
        boolean ban = false;
        n = 0;
        int max = arre.size();
        try{
            cu = Integer.parseInt(cuAct.getText());
            while(!ban && n<max){
                if((Integer)(arre.get(n).getCu()) == cu && ((String)(arre.get(n).getPeriodo())).matches(ddlAct.getSelectedItem())){
                    ban = true;
                    act2.setState(arre.get(n).revisaCorreoAlReciv());
                    act2.setEnabled(!arre.get(n).revisaCorreoAlReciv());
                    act3.setState(arre.get(n).revisaCopiaEnvASSySE());
                    act3.setEnabled(!arre.get(n).revisaCopiaEnvASSySE());
                    act4.setState(arre.get(n).revisaLleganExpYCrn());
                    act4.setEnabled(!arre.get(n).revisaLleganExpYCrn());
                    act5.setState(arre.get(n).revisaCrnGenerado());
                    act5.setEnabled(!arre.get(n).revisaCrnGenerado());
                    act6.setState(arre.get(n).revisaEnvioCrnSE());
                    act6.setEnabled(!arre.get(n).revisaEnvioCrnSE());
                    act7.setState(arre.get(n).revisaActasGeneradas());
                    act7.setEnabled(!arre.get(n).revisaActasGeneradas());
                    act8.setState(arre.get(n).revisaEnvioDepAcad());
                    act8.setEnabled(!arre.get(n).revisaEnvioDepAcad());
                    act9.setState(arre.get(n).revisaRegresoDepAcad());
                    act9.setEnabled(!arre.get(n).revisaRegresoDepAcad());
                    act10.setState(arre.get(n).revisaEntregaDE());
                    act10.setEnabled(!arre.get(n).revisaEntregaDE());
                    act11.setState(arre.get(n).revisaSolDeCRNs());
                    act11.setEnabled(!arre.get(n).revisaSolDeCRNs());
                    
                    act12.setState(arre.get(n).revisaTranscript());
                    act12.setEnabled(!arre.get(n).revisaTranscript());
                    
                    act13.setState(arre.get(n).getPendPre());
                    
                    btnAct.setEnabled(true);
                    escribe.setText("Expediente a actualizar con CU = " + arre.get(n).getCu()+ "    Y periodo: " +arre.get(n).getPeriodo()+"\n");
                    btnElimina.setEnabled(true);
                    btnDetalle.setEnabled(true);
                }
                n=n+1;
            }
            if(!ban){
               escribe.setText("Expediente Inexistente"); 
            }
        }catch(NumberFormatException e){
                escribe.setText("Error, introduzca un número válido.");
        }   
    }//GEN-LAST:event_btnEligeActionPerformed

    private void btnActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActActionPerformed
        // TODO add your handling code here:
        n=n-1;
        
        if(act2.getState() && act2.isEnabled()){
            arre.get(n).setCorreoAlReciv(LocalDate.now());
            escribe.append("Correo de alumno recibido Actualizado\nCU modificada = "+arre.get(n).getCu()+"\n");
        }
        if(act3.getState() && act3.isEnabled()){
            arre.get(n).setCopiaEnvASSySE(LocalDate.now());
            escribe.append("Copia enviada a SS y SE Actualizado\nCU modificada = "+arre.get(n).getCu()+"\n");
        }
        if(act4.getState() && act4.isEnabled()){
            arre.get(n).setLleganExpYCrn(LocalDate.now());
            escribe.append("Llegan Exp. y CRN's Actualizado\nCU modificada = "+arre.get(n).getCu()+"\n");
        }
        if(act5.getState() && act5.isEnabled()){
            arre.get(n).setCrnGenerado(LocalDate.now());
            escribe.append("CRN generado Actualizado\nCU modificada = "+arre.get(n).getCu()+"\n");
        }
        if(act6.getState() && act6.isEnabled()){
            arre.get(n).setEnvioCrnSE(LocalDate.now());
            escribe.append("Envio CRN a SE Actualizado\nCU modificada = "+arre.get(n).getCu()+"\n");
        }
        if(act7.getState() && act7.isEnabled()){
            arre.get(n).setActasGeneradas(LocalDate.now());
            escribe.append("Actas Generadas Actualizado\nCU modificada = "+arre.get(n).getCu()+"\n");
        }
        if(act8.getState() && act8.isEnabled()){
            arre.get(n).setEnvioDepAcad(LocalDate.now());
            escribe.append("Envio Dep. Acad. Actualizado\nCU modificada = "+arre.get(n).getCu()+"\n");
        }
        if(act9.getState() && act9.isEnabled()){
            arre.get(n).setRegresoDepAcad(LocalDate.now());
            escribe.append("Regreso Dep. Acad. Actualizado\nCU modificada = "+arre.get(n).getCu()+"\n");
        }
        if(act10.getState() && act10.isEnabled()){
            arre.get(n).setEntregaDE(LocalDate.now());
            escribe.append("Entrega a Dir. Esc. Actualizado\nCU modificada = "+arre.get(n).getCu()+"\n");
        }
        
        if(act11.getState() && act11.isEnabled()){
            arre.get(n).setSolDeCRNs(LocalDate.now());
            escribe.append("Solicitud de CRNs Actualizado\nCU modificada = "+arre.get(n).getCu()+"\n");
        }
        if(act12.getState() && act12.isEnabled()){
            arre.get(n).setTranscript(LocalDate.now());
            escribe.append("Transcript Actualizado\nCU modificada = "+arre.get(n).getCu()+"\n");
            
        }
        
        arre.get(n).setPendPre(act13.getState());
        
        btnAct.setEnabled(false);
        
        act2.setState(false);
        act3.setState(false);
        act4.setState(false);
        act5.setState(false);
        act6.setState(false);
        act7.setState(false);
        act8.setState(false);
        act9.setState(false);
        act10.setState(false);
        act11.setState(false);
        act12.setState(false);
        act13.setState(false);
        
        act2.setEnabled(true);
        act3.setEnabled(true);
        act4.setEnabled(true);
        act5.setEnabled(true);
        act6.setEnabled(true);
        act7.setEnabled(true);
        act8.setEnabled(true);
        act9.setEnabled(true);
        act10.setEnabled(true);
        act11.setEnabled(true);
        act12.setEnabled(true);
        act13.setEnabled(true);
        n=n+1;
        btnElimina.setEnabled(false);
        btnDetalle.setEnabled(false);
        guardar();
    }//GEN-LAST:event_btnActActionPerformed

    private void btnConsFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsFechasActionPerformed
        // TODO add your handling code here:
        int k=arre.size();
        int dias;
        String respuesta = "";
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        LocalDate hoy = LocalDate.now();
        
        
        if (cons2.getState()){
            for(int m=0; m<k;m++){
                if(!arre.get(m).getSolDeCRNs().equals(control) && arre.get(m).getLleganExpYCrn().equals(control)){
                    respuesta = respuesta + "\nExpediente: " + arre.get(m).getCu() +"   Periodo:  "+ arre.get(m).getPeriodo() +"    Días de espera:  " + ChronoUnit.DAYS.between((LocalDate)arre.get(m).getSolDeCRNs(), LocalDate.now());
                }
            }
        }
        else if (cons3.getState()){
            for(int m=0; m<k;m++){
                if(!arre.get(m).getEnvioCrnSE().equals(control) && arre.get(m).getActasGeneradas().equals(control)){
                    respuesta = respuesta + "\nExpediente: " + arre.get(m).getCu() +"   Periodo:  "+ arre.get(m).getPeriodo() +"    Días de espera:  " + ChronoUnit.DAYS.between((LocalDate)arre.get(m).getEnvioCrnSE(), LocalDate.now());
                }
            }
        }
        else if (cons4.getState()){
            for(int m=0; m<k;m++){
                if(!arre.get(m).getAuxiliarTranscript().equals(control) && arre.get(m).getTranscript().equals(control)  ){
                    respuesta = respuesta + "\nExpediente: " + arre.get(m).getCu() +"   Periodo:  "+ arre.get(m).getPeriodo() +"    Días de espera:  " + ChronoUnit.DAYS.between((LocalDate)arre.get(m).getAuxiliarTranscript(), LocalDate.now());
                }
            }
        
        }
        else if (cons5.getState()){
            for(int m=0; m<k;m++){
                if(!arre.get(m).getEnvioDepAcad().equals(control) && arre.get(m).getRegresoDepAcad().equals(control)){
                    respuesta = respuesta + "\nExpediente: " + arre.get(m).getCu() +"   Periodo:  "+ arre.get(m).getPeriodo() +"    Días de espera:  " + ChronoUnit.DAYS.between((LocalDate)arre.get(m).getEnvioDepAcad(), LocalDate.now());
                }
            }
        }
        else if (cons6.getState()){
            for(int m=0; m<k ; m++){
                if(arre.get(m).getPendPre())
                    respuesta = respuesta + "\nExpediente: " + arre.get(m).getCu() +"   Periodo:  "+ arre.get(m).getPeriodo();
            }
        
        }
        if(!respuesta.equals("")){
            escribe.setText(respuesta);
        }
        else{ 
            escribe.setText("No hay datos");
        }
        
        
    }//GEN-LAST:event_btnConsFechasActionPerformed

    private void cons2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cons2MouseClicked
        // TODO add your handling code here:
        cons6.setState(false);
        cons3.setState(false);
        cons4.setState(false);  
        cons5.setState(false); 
    }//GEN-LAST:event_cons2MouseClicked

    private void cons3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cons3MouseClicked
        // TODO add your handling code here:
        cons6.setState(false);
        cons2.setState(false);
        cons4.setState(false);  
        cons5.setState(false); 
    }//GEN-LAST:event_cons3MouseClicked

    private void cons4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cons4MouseClicked
        // TODO add your handling code here:
        cons6.setState(false);
        cons2.setState(false);
        cons3.setState(false);
        cons5.setState(false); 
    }//GEN-LAST:event_cons4MouseClicked

    private void cons5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cons5MouseClicked
        // TODO add your handling code here:
        cons6.setState(false);
        cons2.setState(false);
        cons3.setState(false);
        cons4.setState(false);
    }//GEN-LAST:event_cons5MouseClicked

    private void cons6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cons6MouseClicked
        // TODO add your handling code here:
        cons5.setState(false);
        cons2.setState(false);
        cons3.setState(false);
        cons4.setState(false);    
    }//GEN-LAST:event_cons6MouseClicked

    private void btnElExp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElExp1ActionPerformed
        // TODO add your handling code here:
        int cu;
        int m = 0;
        int max = arre.size();
        boolean ban = false;
        ddlAct.removeAll();
        try{
            cu = Integer.parseInt(cuAct.getText());
            while(m<max){
                if((Integer)(arre.get(m).getCu()) == cu){
                  ddlAct.add(arre.get(m).getPeriodo());
                  ban = true;
                }
                m++;
            }
            if(ban){
                escribe.setText("Expediente seleccionado: " + cu);
            }
            else{
                escribe.setText("No exixten expedientes con CU: " + cu);
            }
            
        }catch(NumberFormatException e){
                escribe.setText("Error, introduzca un número válido.");
        }
        
        
    }//GEN-LAST:event_btnElExp1ActionPerformed

    private void btnEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaActionPerformed
        // TODO add your handling code here:
        n=n-1;
        int resp = JOptionPane.showConfirmDialog(this, "Borrar expediente " +arre.get(n).getCu()+ " del periodo "+ arre.get(n).getPeriodo() , "Elimina", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(resp == JOptionPane.YES_OPTION){
            arre.remove(n);
        }
        btnAct.setEnabled(false);
        btnElimina.setEnabled(false);
        act2.setState(false);
        act3.setState(false);
        act4.setState(false);
        act5.setState(false);
        act6.setState(false);
        act7.setState(false);
        act8.setState(false);
        act9.setState(false);
        act10.setState(false);
        act11.setState(false);
        act12.setState(false);
        act13.setState(false);
        
        act2.setEnabled(true);
        act3.setEnabled(true);
        act4.setEnabled(true);
        act5.setEnabled(true);
        act6.setEnabled(true);
        act7.setEnabled(true);
        act8.setEnabled(true);
        act9.setEnabled(true);
        act10.setEnabled(true);
        act11.setEnabled(true);
        act12.setEnabled(true);
        act13.setEnabled(true);
        n=n+1;
        guardar();
        
        
        
    }//GEN-LAST:event_btnEliminaActionPerformed

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed
        // TODO add your handling code here:
        JTextField adm = new JTextField(5);
        JTextField cle = new JTextField(5);
        JTextField com = new JTextField(5);
        JTextField con = new JTextField(5);
        JTextField cso = new JTextField(5);
        JTextField der = new JTextField(5);
        JTextField eco = new JTextField(5);
        JTextField ein = new JTextField(5);
        JTextField est = new JTextField(5);
        JTextField egn = new JTextField(5);
        JTextField len = new JTextField(5);
        JTextField mat = new JTextField(5);
        JTextField sdi = new JTextField(5);
        JTextField iio = new JTextField(5);
        JCheckBox chAdm = new JCheckBox("Recibido");
        JCheckBox chCle = new JCheckBox("Recibido");
        JCheckBox chCom = new JCheckBox("Recibido");
        JCheckBox chCon = new JCheckBox("Recibido");
        JCheckBox chCso = new JCheckBox("Recibido");
        JCheckBox chDer = new JCheckBox("Recibido");
        JCheckBox chEco = new JCheckBox("Recibido");
        JCheckBox chEin = new JCheckBox("Recibido");
        JCheckBox chEst = new JCheckBox("Recibido");
        JCheckBox chEgn = new JCheckBox("Recibido");
        JCheckBox chLen = new JCheckBox("Recibido");
        JCheckBox chMat = new JCheckBox("Recibido");
        JCheckBox chSdi = new JCheckBox("Recibido");
        JCheckBox chIio = new JCheckBox("Recibido");
        boolean ban = false;
        int cu = Integer.parseInt(cuAct.getText());
        String per = ddlAct.getSelectedItem();
        int k = 0;
        while(k<arreDep.size() && !ban){
            if((Integer)(arreDep.get(k).getCu()) == cu && ((String)(arreDep.get(k).getPeriodo())).matches(ddlAct.getSelectedItem())){
                ban = true;
                adm.setText(arreDep.get(k).getAdm()+"");
                cle.setText(arreDep.get(k).getCle()+"");
                com.setText(arreDep.get(k).getCom()+"");
                con.setText(arreDep.get(k).getCon()+"");
                cso.setText(arreDep.get(k).getCso()+"");
                der.setText(arreDep.get(k).getDer()+"");
                eco.setText(arreDep.get(k).getEco()+"");
                ein.setText(arreDep.get(k).getEin()+"");
                est.setText(arreDep.get(k).getEst()+"");
                egn.setText(arreDep.get(k).getEgn()+"");
                len.setText(arreDep.get(k).getLen()+"");
                mat.setText(arreDep.get(k).getMat()+"");
                sdi.setText(arreDep.get(k).getSdi()+"");
                iio.setText(arreDep.get(k).getIio()+"");
                
                chAdm.setSelected(arreDep.get(k).isbAdm());
                chCle.setSelected(arreDep.get(k).isbCle());
                chCom.setSelected(arreDep.get(k).isbCom());
                chCon.setSelected(arreDep.get(k).isbCon());
                chCso.setSelected(arreDep.get(k).isbCso());
                chDer.setSelected(arreDep.get(k).isbDer());
                chEco.setSelected(arreDep.get(k).isbEco());
                chEin.setSelected(arreDep.get(k).isbEin());
                chEst.setSelected(arreDep.get(k).isbEst());
                chEgn.setSelected(arreDep.get(k).isbEgn());
                chLen.setSelected(arreDep.get(k).isbLen());
                chMat.setSelected(arreDep.get(k).isbMat());
                chSdi.setSelected(arreDep.get(k).isbSdi());
                chIio.setSelected(arreDep.get(k).isbIio());
            }
            k=k+1;
        }
        if(!ban){
            adm.setText("0");
            cle.setText("0");
            com.setText("0");
            con.setText("0");
            cso.setText("0");
            der.setText("0");
            eco.setText("0");
            ein.setText("0");
            est.setText("0");
            egn.setText("0");
            len.setText("0");
            mat.setText("0");
            sdi.setText("0");
            iio.setText("0");
        }
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0,3));
        panel.add(new JLabel("ADM:"));
        panel.add(adm);
        panel.add(chAdm);
        panel.add(new JLabel("CLE:"));
        panel.add(cle);
        panel.add(chCle);
        panel.add(new JLabel("COM:"));
        panel.add(com);
        panel.add(chCom);
        panel.add(new JLabel("CON:"));
        panel.add(con);
        panel.add(chCon);
        panel.add(new JLabel("CSO:"));
        panel.add(cso);
        panel.add(chCso);
        panel.add(new JLabel("DER:"));
        panel.add(der);
        panel.add(chDer);
        panel.add(new JLabel("ECO:"));
        panel.add(eco);
        panel.add(chEco);
        panel.add(new JLabel("EIN:"));
        panel.add(ein);
        panel.add(chEin);
        panel.add(new JLabel("EST:"));
        panel.add(est);
        panel.add(chEst);
        panel.add(new JLabel("EGN:"));
        panel.add(egn);
        panel.add(chEgn);
        panel.add(new JLabel("LEN:"));
        panel.add(len);
        panel.add(chLen);
        panel.add(new JLabel("MAT:"));
        panel.add(mat);
        panel.add(chMat);
        panel.add(new JLabel("SDI:"));
        panel.add(sdi);
        panel.add(chSdi);
        panel.add(new JLabel("IIO:"));
        panel.add(iio);
        panel.add(chIio);
        int result = JOptionPane.showConfirmDialog(null, panel, 
                 "Número de materias por Dep. Acad.", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try{
                int adm_act = Integer.parseInt(adm.getText());
                int cle_act = Integer.parseInt(cle.getText());
                int com_act = Integer.parseInt(com.getText());
                int con_act = Integer.parseInt(con.getText());
                int cso_act = Integer.parseInt(cso.getText());
                int der_act = Integer.parseInt(der.getText());
                int eco_act = Integer.parseInt(eco.getText());
                int ein_act = Integer.parseInt(ein.getText());
                int est_act = Integer.parseInt(est.getText());
                int egn_act = Integer.parseInt(egn.getText());
                int len_act = Integer.parseInt(len.getText());
                int mat_act = Integer.parseInt(mat.getText());
                int sdi_act = Integer.parseInt(sdi.getText());
                int iio_act = Integer.parseInt(iio.getText());
                boolean bAdm = chAdm.isSelected();
                boolean bCle = chCle.isSelected();
                boolean bCom = chCom.isSelected();
                boolean bCon = chCon.isSelected();
                boolean bCso = chCso.isSelected();
                boolean bDer = chDer.isSelected();
                boolean bEco = chEco.isSelected();
                boolean bEin = chEin.isSelected();
                boolean bEst = chEst.isSelected();
                boolean bEgn = chEgn.isSelected();
                boolean bLen = chLen.isSelected();
                boolean bMat = chMat.isSelected();
                boolean bSdi = chSdi.isSelected();
                boolean bIio = chIio.isSelected();
                if(ban){
                    k=k-1;
                    arreDep.get(k).setAdm(adm_act);
                    arreDep.get(k).setCle(cle_act);
                    arreDep.get(k).setCom(com_act);
                    arreDep.get(k).setCon(con_act);
                    arreDep.get(k).setCso(cso_act);
                    arreDep.get(k).setDer(der_act);
                    arreDep.get(k).setEco(eco_act);
                    arreDep.get(k).setEin(ein_act);
                    arreDep.get(k).setEst(est_act);
                    arreDep.get(k).setEgn(egn_act);
                    arreDep.get(k).setLen(len_act);
                    arreDep.get(k).setMat(mat_act);
                    arreDep.get(k).setSdi(sdi_act);
                    arreDep.get(k).setIio(iio_act);
                    arreDep.get(k).setbAdm(bAdm);
                    arreDep.get(k).setbCle(bCle);
                    arreDep.get(k).setbCom(bCom);
                    arreDep.get(k).setbCon(bCon);
                    arreDep.get(k).setbCso(bCso);
                    arreDep.get(k).setbDer(bDer);
                    arreDep.get(k).setbEco(bEco);
                    arreDep.get(k).setbEin(bEin);
                    arreDep.get(k).setbEst(bEst);
                    arreDep.get(k).setbEgn(bEgn);
                    arreDep.get(k).setbLen(bLen);
                    arreDep.get(k).setbMat(bMat);
                    arreDep.get(k).setbSdi(bSdi);
                    arreDep.get(k).setbIio(bIio);
                }
                else{
                    Departamentos nuevo = new Departamentos(cu, per, adm_act, cle_act, com_act, con_act, cso_act, der_act, eco_act, ein_act, est_act, egn_act, len_act, mat_act, sdi_act, iio_act, bAdm, bCle, bCom, bCon, bCso, bDer, bEco, bEin, bEst, bEgn, bLen, bMat, bSdi, bIio);
                    arreDep.add(nuevo);
                }
                guardarDepartamentos();
                escribe.setText("Información de departamentos actualizada");
            }catch(Exception e){
                escribe.setText("número inválido en materias por departamento");
        }
        }
        
        
    }//GEN-LAST:event_btnDetalleActionPerformed
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Interfaz().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Checkbox act10;
    private java.awt.Checkbox act11;
    private java.awt.Checkbox act12;
    private java.awt.Checkbox act13;
    private java.awt.Checkbox act2;
    private java.awt.Checkbox act3;
    private java.awt.Checkbox act4;
    private java.awt.Checkbox act5;
    private java.awt.Checkbox act6;
    private java.awt.Checkbox act7;
    private java.awt.Checkbox act8;
    private java.awt.Checkbox act9;
    private java.awt.Button btnAct;
    private java.awt.Button btnConsExp;
    private java.awt.Button btnConsFechas;
    private java.awt.Button btnCrear;
    private java.awt.Button btnDetalle;
    private java.awt.Button btnElExp1;
    private java.awt.Button btnElige;
    private java.awt.Button btnElimina;
    private java.awt.Button btnLimpiar;
    private java.awt.Button btnMostrarTodosLosExpedientes;
    private java.awt.Checkbox cons2;
    private java.awt.Checkbox cons3;
    private java.awt.Checkbox cons4;
    private java.awt.Checkbox cons5;
    private java.awt.Checkbox cons6;
    private java.awt.TextField cuAct;
    private java.awt.TextField cuCons;
    private java.awt.TextField cuNuevo;
    private java.awt.Choice ddlAct;
    private java.awt.Choice dllNuevo;
    public java.awt.TextArea escribe;
    private javax.swing.JDialog jDialog1;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    // End of variables declaration//GEN-END:variables
}
