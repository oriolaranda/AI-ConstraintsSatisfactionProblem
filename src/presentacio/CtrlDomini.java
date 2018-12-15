/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacio;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class CtrlDomini {
    private CtrlPresentacio cp;
    
    public CtrlDomini(CtrlPresentacio cp){
        this.cp=cp;
    }
    
    public Boolean afegirAula(String nomAula, String capacitat, String tipus) {
        //DOMINIO SERA EL ENCARGADO DE PASAR LOS TIPOS A SUS VALORES CORRECTOS
        //SOLO SE COMUNICACRÀ CON PRESENTACIÓN CON STRINGS
        //comprueba tambien que tipus es correcto, podria ser un int que devolviera 1 si existe, 2 si tipo incorrecto 0 si bien
        return false;
    }
    
    Boolean esborrarAula(String nomAula) {
        System.out.println("Aula: "+nomAula+" eliminada correctament");
        return true;
    }
    
    ArrayList<ArrayList<String>> getAules() {
        ArrayList<String> a= new ArrayList<>(); 
        a.add("A5202");
        a.add("20");
        a.add("TEORIA");
        ArrayList<String> b= new ArrayList<>(); 
        b.add("A6E01");
        b.add("60");
        b.add("PROBLEMES");
        ArrayList<String> c=new ArrayList<>();
        c.add("A5S109");
        c.add("25");
        c.add("LABORATORI");
        
        ArrayList<ArrayList<String>> d = new ArrayList<>();
        d.add(a);
        d.add(b);
        d.add(c);
        return d;
    }
    
    ArrayList<ArrayList<String>> getPlaEstudis(){
        ArrayList<String> a= new ArrayList<>(); 
        a.add("INFO");
        a.add("8:00");
        a.add("21:00");
        ArrayList<String> b= new ArrayList<>(); 
        b.add("ADE");
        b.add("10:30");
        b.add("13:30");
        ArrayList<ArrayList<String>> c = new ArrayList<>();
        c.add(a);
        c.add(b);
        return c;
    }

    Boolean afegirPlaEstudis(String nomPlaEstudis, String horaInici, String horaFinal) {
        return false;
    }

    Boolean esborrarPlaEstudis(String nomPlaEstudis) {
        System.out.println("PlaEstudis: "+nomPlaEstudis+" eliminat correctament");
        return true;
    }

    ArrayList<ArrayList<String>> getAssignatures(String nomPlaEstudis) {
        //en funció del pla d'estudis
        ArrayList<String> a= new ArrayList<>(); 
        a.add("FM");
        a.add("INICIAL");
        a.add("60");
        a.add("20");
        a.add("120");
        a.add("PROBLEMES");
        a.add("2");
        a.add("2");

        ArrayList<String> b= new ArrayList<>(); 
        b.add("ER");
        b.add("SOFTWARE");
        b.add("50");
        b.add("20");
        b.add("130");
        b.add("LABORATORI");
        b.add("2");
        b.add("2");
        
        ArrayList<ArrayList<String>> c = new ArrayList<>();
        c.add(a);
        c.add(b);
        return c;
    }

    Boolean esborrarAssignatura(String nomAssignatura, String nomPlaEstudis) {
        System.out.println("Assignatura: "+nomAssignatura+" ("+ nomPlaEstudis+")" +" eliminada correctament");
        return true;
    }

    Boolean afegirAssignatura(String nomAssignatura, String fase, String capacitatGrup, String capacitatSubGrup, String matriculats, String tipusSubGrup, String numSessions, String duracio, String nomPlaEstudis) {
        return false;
    }
    
     ArrayList<ArrayList<String>> getCorrequisitsAssignatura(String nomAssignatura, String nomPlaEstudis) {
        ArrayList<String> a= new ArrayList<>(); 
        a.add("M1");
        a.add("SEGONCURS");
        a.add("60");
        a.add("20");
        a.add("120");
        a.add("PROBLEMES");
        a.add("2");
        a.add("2");

        ArrayList<String> b= new ArrayList<>(); 
        b.add("M2");
        b.add("SOFTWARE");
        b.add("50");
        b.add("20");
        b.add("130");
        b.add("LABORATORI");
        b.add("2");
        b.add("2");
        
        ArrayList<ArrayList<String>> c = new ArrayList<>();
        c.add(a);
        c.add(b);
        return c;
    }

    Boolean afegirCorrequisit(String nomAssignaturaEscollida, String nomAssignaturaActual, String nomPlaEstudis) {
        //retorna si les assignatures son correquisits entre elles
        //si no ho son, crea les associacions perque ho siguin
        //tb comprova que no sigui correquisit de si mateixa i coses aixi
        return false;
    }

    Boolean esborrarCorrequisit(String nomAssignaturaEscollida, String nomAssignaturaActual, String nomPlaEstudis) {
        //s'esborra el la relacio de correquits en els dos sentits
        System.out.println("Correquisit entre: "+nomAssignaturaEscollida+" i "+nomAssignaturaActual+" eliminat correctament");
        return true;
    }

    ArrayList<String> getHorarisPlaEstudis(String nomPlaEstudis) {
        //retorna els horaris que tenen com atribut l'string nomplaestudis indicat
        ArrayList<String> horaris = new ArrayList<>();
        horaris.add("Horari1");
        horaris.add("Horari2");
        return horaris;
    }

    Boolean esborrarHorari(String nomHorari, String nomPlaEstudis) {
        //tb esborra les seves restriccions associades i tal
        System.out.println("Horari: "+nomHorari+" ("+nomPlaEstudis+") "+"eliminat correctament");
        return true;
    }

    Boolean crearHorari(String nomHorari, Boolean restriccioCapacitat, Boolean restriccioCorrequisit, Boolean restriccioFase, Boolean restriccioTipusAula, ArrayList<ArrayList<String>> restriccions,String nomPlaEstudis) {
        //retorna true si l'horari ja existeix o alguna de les restriccions té parametres incorrectes
        //et podria passar dos vectors "restriccions" un amb les de classe i un altre amb les de grupdiahora o comprovar tu si restriccions.get(i).get(2) que es nomaula té un valor o es ""
        //crea l'horari, amb les sessions del pla d'estudis indicat (que tb associa l'string a l'horari com a atribut), totes les aules del sistema i unes restriccions que crea segons les indicades.
        return false;
    }

    ArrayList<String> getHores(String nomPlaEstudis) {
        ArrayList<String> hores = new ArrayList<>();
        hores.add("8:00");
        hores.add("9:00");
        hores.add("10:00");
        hores.add("11:00");
        hores.add("12:00");
        hores.add("13:00");
        hores.add("14:00");
        return hores;
    }

    String getSessio(String dia, String hora, String nomAula, String capacitat, String tipus, String nomHorari, String nomPlaEstudis) {
        //retorna la sessio (String constituit per nomAssig+numGrup+numSessio en un String) format possible= "PROP 11 (1)"
        //la sessio es del horari del pla d'estudis indicat en la Classe indicada
        //si no hi ha sessio assignada per aquesta Classe retorna un String "";
        if(dia.equals("Dilluns")){
            if(hora.charAt(0)=='1') return "PROP 14 (4)";
        }
        if(dia.equals("Dimarts")){
            return "ER 23 (2)";
        }         
        return "AS 11 (1)";
    }

    Boolean intercanviar(String dia1, String hora1, String nomAula1, String dia2, String hora2, String nomAula2) {
        //Si es poden intercanviar( tenint en compte les restriccions i tal) s'intercanvien i retorna true
        //si no, retorna false
        return true;
    }

    void intercanviarObligat(String dia1, String hora1, String nomAula1, String dia2, String hora2, String nomAula2) {
        //s'intercanvien els dos valors de les sessions d'aquestes classes apropiadament tenint en compte si algun d'ells es buit
    }

    Boolean modificarAula(String nomAulaAntic, String nomAula, String capacitat, String tipus) {
        //se modifica con los valores indicados los atributos del aula identificada como nomAulaAntic 
        //retorna true si es pot modificar, false si hi ha algun error en parametres
        return true;
    }

    boolean modificarPlaEstudis(String nomPlaEstudisAntic, String nomPlaEstudis, String horaInici, String horaFinal) {
        //se modifica con los valores indicados 
        //retorna true si es pot modificar, false si hi ha algun error en parametres
        return true;
    }

    boolean modificarAssignatura(String nomAssignaturaAntic, String nomAssignatura, String fase, String capacitatGrup, String capacitatSubGrup, String matriculats, String tipusSubGrup, String numSessions, String duracio) {
        //es modifica amb els valors indicats
        //retorna true si es pot modificar, false si hi ha algun error en parametres
        return false;
    }
    
    
}
