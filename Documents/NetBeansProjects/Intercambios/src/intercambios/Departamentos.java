/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercambios;

/**
 *
 * @author francisco
 */
public class Departamentos {
    int cu;
    String periodo;
    int adm;
    int cle;
    int com;
    int con;
    int cso;
    int der;
    int eco;
    int ein;
    int est;
    int egn;
    int len;
    int mat;
    int sdi;
    int iio;
    boolean bAdm;
    boolean bCle;
    boolean bCom;
    boolean bCon;
    boolean bCso;
    boolean bDer;
    boolean bEco;
    boolean bEin;
    boolean bEst;
    boolean bEgn;
    boolean bLen;
    boolean bMat;
    boolean bSdi;
    boolean bIio;

    public Departamentos(int cu, String periodo) {
        this.cu = cu;
        this.periodo = periodo;
        this.bAdm = false;
        this.bCle = false;
        this.bCom = false;
        this.bCon = false;
        this.bCso = false;
        this.bDer = false;
        this.bEco = false;
        this.bEin = false;
        this.bEst = false;
        this.bEgn = false;
        this.bLen = false;
        this.bMat = false;
        this.bSdi = false;
        this.bIio = false;
        this.adm = 0;
        this.cle = 0;
        this.com = 0;
        this.con = 0;
        this.cso = 0;
        this.der = 0;
        this.eco = 0;
        this.ein = 0;
        this.est = 0;
        this.egn = 0;
        this.len = 0;
        this.mat = 0;
        this.sdi = 0;
        this.iio = 0;
    }

    public Departamentos(int cu, String periodo, int adm, int cle, int com, int con, int cso, int der, int eco, int ein, int est, int egn, int len, int mat, int sdi, int iio, boolean bAdm, boolean bCle, boolean bCom, boolean bCon, boolean bCso, boolean bDer, boolean bEco, boolean bEin, boolean bEst, boolean bEgn, boolean bLen, boolean bMat, boolean bSdi, boolean bIio) {
        this.cu = cu;
        this.periodo = periodo;
        this.adm = adm;
        this.cle = cle;
        this.com = com;
        this.con = con;
        this.cso = cso;
        this.der = der;
        this.eco = eco;
        this.ein = ein;
        this.est = est;
        this.egn = egn;
        this.len = len;
        this.mat = mat;
        this.sdi = sdi;
        this.iio = iio;
        this.bAdm = bAdm;
        this.bCle = bCle;
        this.bCom = bCom;
        this.bCon = bCon;
        this.bCso = bCso;
        this.bDer = bDer;
        this.bEco = bEco;
        this.bEin = bEin;
        this.bEst = bEst;
        this.bEgn = bEgn;
        this.bLen = bLen;
        this.bMat = bMat;
        this.bSdi = bSdi;
        this.bIio = bIio;
    }
    
    public boolean igual(int cu, String periodo){
        boolean res = false;
        if(cu==this.cu && periodo.equals(this.periodo)){
            res = true;
        }
        return res;
    }

    public int getCu() {
        return cu;
    }

    public String getPeriodo() {
        return periodo;
    }
    public int getAdm() {
        return adm;
    }

    public void setAdm(int adm) {
        this.adm = adm;
    }

    public int getCle() {
        return cle;
    }

    public void setCle(int cle) {
        this.cle = cle;
    }

    public int getCom() {
        return com;
    }

    public void setCom(int com) {
        this.com = com;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getCso() {
        return cso;
    }

    public void setCso(int cso) {
        this.cso = cso;
    }

    public int getDer() {
        return der;
    }

    public void setDer(int der) {
        this.der = der;
    }

    public int getEco() {
        return eco;
    }

    public void setEco(int eco) {
        this.eco = eco;
    }

    public int getEin() {
        return ein;
    }

    public void setEin(int ein) {
        this.ein = ein;
    }

    public int getEst() {
        return est;
    }

    public void setEst(int est) {
        this.est = est;
    }

    public int getEgn() {
        return egn;
    }

    public void setEgn(int egn) {
        this.egn = egn;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public int getSdi() {
        return sdi;
    }

    public void setSdi(int sdi) {
        this.sdi = sdi;
    }

    public int getIio() {
        return iio;
    }

    public void setIio(int iio) {
        this.iio = iio;
    }

    public boolean isbAdm() {
        return bAdm;
    }

    public void setbAdm(boolean bAdm) {
        this.bAdm = bAdm;
    }

    public boolean isbCle() {
        return bCle;
    }

    public void setbCle(boolean bCle) {
        this.bCle = bCle;
    }

    public boolean isbCom() {
        return bCom;
    }

    public void setbCom(boolean bCom) {
        this.bCom = bCom;
    }

    public boolean isbCon() {
        return bCon;
    }

    public void setbCon(boolean bCon) {
        this.bCon = bCon;
    }

    public boolean isbCso() {
        return bCso;
    }

    public void setbCso(boolean bCso) {
        this.bCso = bCso;
    }

    public boolean isbDer() {
        return bDer;
    }

    public void setbDer(boolean bDer) {
        this.bDer = bDer;
    }

    public boolean isbEco() {
        return bEco;
    }

    public void setbEco(boolean bEco) {
        this.bEco = bEco;
    }

    public boolean isbEin() {
        return bEin;
    }

    public void setbEin(boolean bEin) {
        this.bEin = bEin;
    }

    public boolean isbEst() {
        return bEst;
    }

    public void setbEst(boolean bEst) {
        this.bEst = bEst;
    }

    public boolean isbEgn() {
        return bEgn;
    }

    public void setbEgn(boolean bEgn) {
        this.bEgn = bEgn;
    }

    public boolean isbLen() {
        return bLen;
    }

    public void setbLen(boolean bLen) {
        this.bLen = bLen;
    }

    public boolean isbMat() {
        return bMat;
    }

    public void setbMat(boolean bMat) {
        this.bMat = bMat;
    }

    public boolean isbSdi() {
        return bSdi;
    }

    public void setbSdi(boolean bSdi) {
        this.bSdi = bSdi;
    }

    public boolean isbIio() {
        return bIio;
    }

    public void setbIio(boolean bIio) {
        this.bIio = bIio;
    }
}
