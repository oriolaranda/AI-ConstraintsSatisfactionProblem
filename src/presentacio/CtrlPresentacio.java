/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacio;

import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Daniel
 */
public class CtrlPresentacio {
    private CtrlDomini cd;
    private vistaMenu vm;
    private vistaAules va;
    private vistaAssignatures vas;
    private vistaPlaEstudis vpe;
    private vistaCorrequisits vc;
    private vistaHoraris vh;
    private infoHoraris ih;
    private vistaCalendariHorari vch;
    private window w;
    
    
    
    public CtrlPresentacio() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      cd=new CtrlDomini(this);
      vm=new vistaMenu(this);
      w=new window(this);
      w.setContentPane(vm);
      w.setVisible(true);
    }
    
    public void menu(){
        w.setContentPane(vm);
        w.setVisible(true);
    }
    
    public void assignatures(){
        w.setContentPane(vas);
        w.setVisible(true);
    }
    
    public void creaVistaAules(){
        va=new vistaAules(this);
        va.inicia();
        w.setContentPane(va);
        w.setVisible(true);
    }
    
    public void creaVistaPlaEstudis(){
        vpe=new vistaPlaEstudis(this);
        vpe.inicia();
        w.setContentPane(vpe);
        w.setVisible(true);
    }
    
    public void creaVistaAssignatures(String nomPlaEstudis){
        vas=new vistaAssignatures(this, nomPlaEstudis);
        vas.inicia();
        w.setContentPane(vas);
        w.setVisible(true);
    }
    
    public void creaVistaCorrequisits(String nomAssignatura, String nomPlaEstudis) {
        vc=new vistaCorrequisits(this, nomAssignatura, nomPlaEstudis);
        vc.inicia();
        w.setContentPane(vc);
        w.setVisible(true);
    }
    
    public void creaVistaHoraris(String nomPlaEstudis) {
        vh=new vistaHoraris(this,nomPlaEstudis);
        vh.inicia();
        w.setContentPane(vh);
        w.setVisible(true);
    }
    public void creaInfoHoraris(String nomPlaEstudis) {
        ih=new infoHoraris(this,nomPlaEstudis);
        //ih.inicia(); potser fa falta 
        w.setContentPane(ih);
        w.setVisible(true);
    }    
    void afegirAulaTaula(String nomAula, String capacitat, String tipus){
        va.afegirAula(nomAula,capacitat,tipus);
    }

    boolean afegirAula(String nomAula, String capacitat, String tipus) {
        boolean existia=cd.afegirAula(nomAula,capacitat,tipus);
        if(!existia) afegirAulaTaula(nomAula,capacitat,tipus);
        return existia;
    }
    
    boolean modificarAula(String nomAulaAntic, String nomAula, String capacitat, String tipus) {
        boolean modificada=cd.modificarAula(nomAulaAntic,nomAula,capacitat,tipus);
        if(modificada)afegirAulaTaula(nomAula,capacitat,tipus);
        return modificada;
    }
    
    boolean esborrarAula(String nomAula){
        return cd.esborrarAula(nomAula);
    }
    
    ArrayList<ArrayList<String>> getAules(){
        ArrayList<ArrayList<String>> aules=cd.getAules();
       return aules;
    }
    
    void getAulesVistaAules() {
        ArrayList<ArrayList<String>> aules=getAules();
        if(aules!=null && !aules.isEmpty()){
            for (ArrayList<String> a : aules) {  
                va.afegirAula(a.get(0),a.get(1),a.get(2));
            }
        }
    }
    
    void getPlaEstudis() {
        ArrayList<ArrayList<String>> plans=cd.getPlaEstudis();
        if(plans!=null && !plans.isEmpty()){
            for (ArrayList<String> p : plans) {  
                vpe.afegirPlaEstudis(p.get(0),p.get(1),p.get(2));
            }
        }
    }
    
     ArrayList<ArrayList<String>> getAssignaturesPlaEstudis(String nomPlaEstudis) {
        ArrayList<ArrayList<String>> assig=cd.getAssignatures(nomPlaEstudis);
        return assig;
    }
     
     ArrayList<ArrayList<String>> getCorrequisitsAssignatura(String nomAssignatura, String nomPlaEstudis) {
        ArrayList<ArrayList<String>> assig=cd.getCorrequisitsAssignatura(nomAssignatura,nomPlaEstudis);
        return assig;
    }
     
    void getAssignaturesVistaAssignatures(String nomPlaEstudis) {
        ArrayList<ArrayList<String>> assig=getAssignaturesPlaEstudis(nomPlaEstudis);
        if(assig!=null && !assig.isEmpty()){
            for (ArrayList<String> a : assig) {  
                vas.afegirAssignatura(a.get(0),a.get(1),a.get(2),a.get(3),a.get(4),a.get(5),a.get(6),a.get(7));
            }
        }
    }
    void getAssignaturesVistaCorrequisits(String nomAssignatura, String nomPlaEstudis) {
        ArrayList<ArrayList<String>> assig=getAssignaturesPlaEstudis(nomPlaEstudis);
        if(assig!=null && !assig.isEmpty()){
            for (ArrayList<String> a : assig) {  
                vc.afegirAssignaturaPlaEstudis(a.get(0),a.get(1),a.get(2),a.get(3),a.get(4),a.get(5),a.get(6),a.get(7));
            }
        }
        ArrayList<ArrayList<String>> assig2=getCorrequisitsAssignatura(nomAssignatura,nomPlaEstudis);
        if(assig2!=null && !assig2.isEmpty()){
            for (ArrayList<String> a : assig2) {  
                vc.afegirAssignaturaCorrequisit(a.get(0),a.get(1),a.get(2),a.get(3),a.get(4),a.get(5),a.get(6),a.get(7));
            }
        }
    }
    
    
    void afegirPlaEstudisTaula(String nomPlaEstudis,String horaInici,String horaFinal){
        vpe.afegirPlaEstudis(nomPlaEstudis,horaInici,horaFinal);
    }
    
    
    boolean afegirPlaEstudis(String nomPlaEstudis, String horaInici, String horaFinal) {
        boolean existia=cd.afegirPlaEstudis(nomPlaEstudis,horaInici,horaFinal);    
        if(!existia) afegirPlaEstudisTaula(nomPlaEstudis,horaInici,horaFinal);
        return existia;
    }
    
    boolean modificarPlaEstudis(String nomPlaEstudisAntic, String nomPlaEstudis, String horaInici, String horaFinal) {
        boolean modificat=cd.modificarPlaEstudis(nomPlaEstudisAntic,nomPlaEstudis,horaInici,horaFinal);
        if(modificat) afegirPlaEstudisTaula(nomPlaEstudis,horaInici,horaFinal);
        return modificat;
    }

    boolean esborrarPlaEstudis(String nomPlaEstudis) {
        return cd.esborrarPlaEstudis(nomPlaEstudis);
    }

    void plaestudis() {
        w.setContentPane(vpe);
        w.setVisible(true);    
    }

    void esborrarAssignatura(String nomAssignatura, String nomPlaEstudis) {
        cd.esborrarAssignatura(nomAssignatura,nomPlaEstudis);
    }
    
    void esborrarCorrequisit(String nomAssignaturaEscollida, String nomAssignaturaActual, String nomPlaEstudis) {
        cd.esborrarCorrequisit(nomAssignaturaEscollida,nomAssignaturaActual,nomPlaEstudis);
    }
    
    void afegirAssignaturaTaula(String nomAssignatura,String fase,String capacitatGrup,String capacitatSubGrup,String matriculats,String tipusSubGrup,String numSessions,String duracio){
        vas.afegirAssignatura(nomAssignatura,fase,capacitatGrup,capacitatSubGrup,matriculats,tipusSubGrup,numSessions,duracio);
    }
    
    boolean modificarAssignatura(String nomAssignaturaAntic, String nomAssignatura, String fase, String capacitatGrup, String capacitatSubGrup, String matriculats, String tipusSubGrup, String numSessions, String duracio) {
        boolean modificada=cd.modificarAssignatura(nomAssignaturaAntic,nomAssignatura,fase,capacitatGrup,capacitatSubGrup,matriculats,tipusSubGrup,numSessions,duracio);
        if(modificada) afegirAssignaturaTaula(nomAssignatura,fase,capacitatGrup,capacitatSubGrup,matriculats,tipusSubGrup,numSessions,duracio);
        return modificada;
    }

    boolean afegirAssignatura(String nomAssignatura, String fase, String capacitatGrup, String capacitatSubGrup, String matriculats, String tipusSubGrup, String numSessions, String duracio) {
        String nomPlaEstudis=vas.getNomPlaEstudis();
        boolean existia=cd.afegirAssignatura(nomAssignatura,fase,capacitatGrup,capacitatSubGrup,matriculats,tipusSubGrup,numSessions,duracio,nomPlaEstudis);    
        if(!existia) afegirAssignaturaTaula(nomAssignatura,fase,capacitatGrup,capacitatSubGrup,matriculats,tipusSubGrup,numSessions,duracio);
        return existia;
    }
    
    void afegirCorrequisit(String nomAssignaturaEscollida,String fase, String capacitatGrup, String capacitatSubGrup, String matriculats, String tipusSubGrup, String numSessions, String duracio,String nomAssignaturaActual, String nomPlaEstudis) {
        Boolean jahoes=cd.afegirCorrequisit(nomAssignaturaEscollida,nomAssignaturaActual,nomPlaEstudis);    
        if(!jahoes){
            vc.afegirAssignaturaCorrequisit(nomAssignaturaEscollida, fase, capacitatGrup, capacitatSubGrup, matriculats, tipusSubGrup, numSessions, duracio);
        }
    }

    void getHorarisPlaEstudis(String nomPlaEstudis) {
        ArrayList<String> horaris= cd.getHorarisPlaEstudis(nomPlaEstudis);
        if(horaris!=null && !horaris.isEmpty()){
            for (String nomHorari : horaris) {  
                vh.afegirHorari(nomHorari);
            }
        }
    }

    void esborrarHorari(String nomHorari, String nomPlaEstudis) {
        cd.esborrarHorari(nomHorari,nomPlaEstudis);
    }

    void horaris() {
        w.setContentPane(vh);
        w.setVisible(true);
    }

    void afegirRestriccioTaula(String idRestriccio, String nomAula, String dia, String hora, String nomAssignatura, String numGrup) {
        ih.afegirRestriccioTaula(idRestriccio,nomAula,dia,hora,nomAssignatura,numGrup);
    }

    void crearHorari(String nomHorari, Boolean restriccioCapacitat, Boolean restriccioCorrequisit, Boolean restriccioFase, Boolean restriccioTipusAula, ArrayList<ArrayList<String>> restriccions, String nomPlaEstudis) {
        Boolean existeix=cd.crearHorari(nomHorari,restriccioCapacitat,restriccioCorrequisit,restriccioFase,restriccioTipusAula,restriccions,nomPlaEstudis);
        if(!existeix){
            vh.afegirHorari(nomHorari);
        }
        horaris();
        //igual hay que hacer update al vistahoraris
    }

    void visualitzarHorari(String nomHorari, String nomPlaEstudis) {
        vch=new vistaCalendariHorari(this,nomHorari,nomPlaEstudis);
        vch.inicia();
        w.setContentPane(vch);
        w.setVisible(true);
    }

    ArrayList<String> getHores(String nomPlaEstudis) {
        return cd.getHores(nomPlaEstudis);
    }

    String getSessio(String dia, String hora, String nomAula, String capacitat, String tipus, String nomHorari, String nomPlaEstudis) {
        return cd.getSessio(dia, hora, nomAula, capacitat, tipus , nomHorari, nomPlaEstudis);
    }

    Boolean intecanviar(String dia1, String hora1, String nomAula1, String dia2, String hora2, String nomAula2) {
        return cd.intercanviar( dia1,  hora1,  nomAula1,  dia2,  hora2,  nomAula2);
    }

    void intercanviarObligat(String dia1, String hora1, String nomAula1, String dia2, String hora2, String nomAula2){
        cd.intercanviarObligat( dia1,  hora1,  nomAula1,  dia2,  hora2,  nomAula2);    
    }
   

    
}
