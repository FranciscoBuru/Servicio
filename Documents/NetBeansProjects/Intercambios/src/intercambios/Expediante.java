/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
   */
package intercambios;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Francisco Aramburu 
 */
public class Expediante {
    int cu;
    String periodo;
    LocalDate creaExp;
    LocalDate primerEnvioSE;
    LocalDate correoAlReciv;
    LocalDate copiaEnvASSySE;
    LocalDate solDeCRNs;
    LocalDate lleganExpYCrn;
    LocalDate crnGenerado;
    LocalDate envioCrnSE;
    LocalDate actasGeneradas;
    
    LocalDate transcript;
    
    LocalDate envioDepAcad;
    LocalDate regresoDepAcad;
    
    boolean pendPre;
    
    LocalDate entregaDE;
    LocalDate auxiliarTranscript;
    
    //Constructor por omisio+n
    public Expediante() {
    }
    //Constructor de un nuevo expediente
    public Expediante(int cu, String periodo) {
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        this.cu = cu;
        this.periodo = periodo;
        this.creaExp = LocalDate.now();
        this.primerEnvioSE = control;
        this.correoAlReciv = control;
        this.copiaEnvASSySE = control;
        this.solDeCRNs = control;
        this.lleganExpYCrn = control;
        this.crnGenerado = control;
        this.envioCrnSE = control;
        this.actasGeneradas = control;
        this.transcript = control;
        this.envioDepAcad = control;
        this.regresoDepAcad = control;
        this.entregaDE = control;
        this.auxiliarTranscript = control;
        this.pendPre = false;
    }
    //Constructor para lectura de archivo
    public Expediante(int cu, String periodo, LocalDate creaExp, LocalDate primerEnvioSE, LocalDate correoAlReciv, LocalDate copiaEnvASSySE,LocalDate solDeCRNs, LocalDate lleganExpYCrn, LocalDate crnGenerado, LocalDate envioCrnSE, LocalDate actasGeneradas, LocalDate auxiliarTranscript, LocalDate transcript, LocalDate envioDepAcad, LocalDate regresoDepAcad, boolean pendPre, LocalDate entregaDE) {
        this.cu = cu;
        this.periodo = periodo;
        this.creaExp = creaExp;
        this.primerEnvioSE = primerEnvioSE;
        this.correoAlReciv = correoAlReciv;
        this.copiaEnvASSySE = copiaEnvASSySE;
        this.solDeCRNs = solDeCRNs;
        this.lleganExpYCrn = lleganExpYCrn;
        this.crnGenerado = crnGenerado;
        this.envioCrnSE = envioCrnSE;
        this.actasGeneradas = actasGeneradas;
        this.auxiliarTranscript = auxiliarTranscript;
        this.transcript = transcript;
        this.envioDepAcad = envioDepAcad;
        this.regresoDepAcad = regresoDepAcad;
        this.pendPre = pendPre;
        this.entregaDE = entregaDE;
        
    }
    //getters
    public int getCu() {
        return cu;
    }
    
    public String getPeriodo() {
        return periodo;
    }

    public LocalDate getCreaExp() {
        return creaExp;
    }

    public LocalDate getPrimerEnvioSE() {
        return primerEnvioSE;
    }

    public LocalDate getCorreoAlReciv() {
        return correoAlReciv;
    }
    
    public LocalDate getCopiaEnvASSySE() {
        return copiaEnvASSySE;
    }
    
    public LocalDate getSolDeCRNs(){
        return solDeCRNs;
    }

    public LocalDate getLleganExpYCrn() {
        return lleganExpYCrn;
    }

    public LocalDate getCrnGenerado() {
        return crnGenerado;
    }

    public LocalDate getEnvioCrnSE() {
        return envioCrnSE;
    }

    public LocalDate getActasGeneradas() {
        return actasGeneradas;
    }
    
    public LocalDate getAuxiliarTranscript() {
        return auxiliarTranscript;
    }
    
    public LocalDate getTranscript() {
        return transcript;
    }

    public LocalDate getEnvioDepAcad() {
        return envioDepAcad;
    }

    public LocalDate getRegresoDepAcad() {
        return regresoDepAcad;
    }

    public LocalDate getEntregaDE() {
        return entregaDE;
    }
    public boolean getPendPre() {
        return pendPre;
    }
    
    
    //setters
    public void setPrimerEnvioSE(LocalDate primerEnvioSE) {
        this.primerEnvioSE = primerEnvioSE;
    }

    public void setCorreoAlReciv(LocalDate correoAlReciv) {
        this.correoAlReciv = correoAlReciv;
    }
    
    public void setCopiaEnvASSySE(LocalDate copiaEnvASSySE) {
        this.copiaEnvASSySE = copiaEnvASSySE;
    }
    
    public void setSolDeCRNs(LocalDate solDeCRNs){
        this.solDeCRNs = solDeCRNs;
    }

    public void setLleganExpYCrn(LocalDate lleganExpYCrn) {
        this.lleganExpYCrn = lleganExpYCrn;
    }

    public void setCrnGenerado(LocalDate crnGenerado) {
        this.crnGenerado = crnGenerado;
    }

    public void setEnvioCrnSE(LocalDate envioCrnSE) {
        this.envioCrnSE = envioCrnSE;
    }

    public void setActasGeneradas(LocalDate actasGeneradas) {
        this.actasGeneradas = actasGeneradas;
    }
    
    public void setAuxiliarTranscript(LocalDate auxiliarTranscript) {
        this.auxiliarTranscript = auxiliarTranscript;
    }
    
    public void setTranscript(LocalDate transcript) {
        this.transcript = transcript;
    }

    public void setEnvioDepAcad(LocalDate envioDepAcad) {
        this.envioDepAcad = envioDepAcad;
    }

    public void setRegresoDepAcad(LocalDate regresoDepAcad) {
        this.regresoDepAcad = regresoDepAcad;
    }
    
    public void setPendPre(boolean pendPre) {
        this.pendPre = pendPre;
    }
    
    public void setEntregaDE(LocalDate entregaDE) {
        this.entregaDE = entregaDE;
    }
     @Override
    public String toString() {
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        boolean primerEnvioSEB;
        boolean correoAlRecivB;
        boolean copiaEnvASSySEB;
        boolean solDeCRNsB;
        boolean lleganExpYCrnB;
        boolean crnGeneradoB;
        boolean envioCrnSEB;
        boolean actasGeneradasB;
        boolean transcriptB;
        boolean envioDepAcadB;
        boolean regresoDepAcadB;
        boolean entregaDEB;
        String ex1;
        String ex2;
        String ex3;
        String ex4;
        String ex17;
        String ex5;
        String ex6;
        String ex7;
        String ex8;
        String ex9;
        String ex20;
        String ex50;
        String ex70;
        primerEnvioSEB = !primerEnvioSE.equals(control);
        if(primerEnvioSEB){
            ex1 = "   "+ primerEnvioSE;
        }else{
            ex1 = " ";
        }
        correoAlRecivB = !correoAlReciv.equals(control);
        if(correoAlRecivB){
            ex2 = "   "+ correoAlReciv;
        }else{
            ex2 = " ";
        }
        copiaEnvASSySEB = !copiaEnvASSySE.equals(control);
        if(copiaEnvASSySEB){
            ex20 = "   "+ correoAlReciv;
        }else{
            ex20 = " ";
        }
        
        solDeCRNsB = !solDeCRNs.equals(control);
        if(solDeCRNsB){
            ex17 = "   "+ solDeCRNs;
        }else{
            ex17 = " ";
        }
        lleganExpYCrnB = !lleganExpYCrn.equals(control);
        if(lleganExpYCrnB){
            ex3 = "   "+ lleganExpYCrn;
        }else{
            ex3 = " ";
        }
        crnGeneradoB = !crnGenerado.equals(control);
        if(crnGeneradoB){
            ex4 = "   "+ crnGenerado;
        }else{
            ex4 = " ";
        }
        envioCrnSEB = !envioCrnSE.equals(control);
        if(envioCrnSEB){
            ex5 = "   "+ envioCrnSE;
        }else{
            ex5 = " ";
        }
        actasGeneradasB = !actasGeneradas.equals(control);
        if(actasGeneradasB){
            ex6 = "   "+ actasGeneradas;
        }else{
            ex6 = " ";
        }
        
        transcriptB = !transcript.equals(control);
        if(transcriptB){
            ex50 = "   "+ transcript;
        }else{
            ex50 = " ";
        }
        
        envioDepAcadB = !envioDepAcad.equals(control);
        if(envioDepAcadB){
            ex7 = "   "+ envioDepAcad;
        }else{
            ex7 = " ";
        }
        regresoDepAcadB = !regresoDepAcad.equals(control);
        if(regresoDepAcadB){
            ex8 = "   "+ regresoDepAcad;
        }else{
            ex8 = " ";
        }
        
        if(pendPre){
            ex70 = "SI";
        }
        else{
            ex70 = "NO";
        }
        
        
        
        entregaDEB = !entregaDE.equals(control);
        if(entregaDEB){
            ex9 = "   "+ entregaDE;
        }else{
            ex9 = " ";
        }
        return "Expediante con CU:               " + cu +"\n\nPeriodo:                                   " + periodo + "\n\nFecha de Creación:               " + creaExp + "\n\nPrimer envio a SE:              "  + ex1 + "\n\nCorreo Recivido:                  "  + ex2 + "\n\nCopia enviada a SS y SE:   "  + ex20 +"\n\nCRNs Solicitados:               "+ ex17 +"\n\nLlegada de Exp. y CRN's:   "  + ex3 + "\n\nCRN's Generados:              " + ex4 + "\n\nCRN's enviados a SE:        " + ex5 + "\n\nActas Generads:                  "  +ex6+ "\n\nTranscript:                             " + ex50 + "\n\nEnviado al Dep. Acad:        " +ex7 + "\n\nRegresa del Dep. Acad:     " +ex8 + "\n\nPrerrequisitos pendeientes:   " +ex70+ "\n\nEntrega a DE:                       "  + ex9;
    }
    
    public boolean revisaPrimerEnvioSE(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !primerEnvioSE.equals(control);
    }
    
    public boolean revisaCorreoAlReciv(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !correoAlReciv.equals(control);
    }
    
    public boolean revisaCopiaEnvASSySE(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !copiaEnvASSySE.equals(control);
    }
   
    
    public boolean revisaSolDeCRNs(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !solDeCRNs.equals(control);
    }
    
    public boolean revisaLleganExpYCrn(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !lleganExpYCrn.equals(control);
    }
    
    public boolean revisaCrnGenerado(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !crnGenerado.equals(control);
    }
    
    public boolean revisaEnvioCrnSE(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !envioCrnSE.equals(control);
    }
    
    public boolean revisaActasGeneradas(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !actasGeneradas.equals(control);
    }
    
    public boolean revisaAuxiliarTranscript(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !auxiliarTranscript.equals(control);
    }
    
    
    public boolean revisaTranscript(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !transcript.equals(control);
    }
    
    public boolean revisaEnvioDepAcad(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !envioDepAcad.equals(control);
    }
    
    public boolean revisaRegresoDepAcad(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !regresoDepAcad.equals(control);
    }
    
    public boolean revisaEntregaDE(){
        LocalDate control = LocalDate.of(2000, Month.JANUARY, 1);
        return !entregaDE.equals(control);
    }
}

