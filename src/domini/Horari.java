package domini;

import java.util.ArrayList;
import java.util.Map;
import java.util.SortedMap;
import java.util.Vector;

public class Horari {

    //Atributs
    private String nom;
    private int HoraIni;
    private int HoraFi;
    private ArrayList<Sessio> Sessions;
    private Vector<Classe> Classes;
    private ArrayList<Restriccio> Restriccions;
    private Map<Sessio, Vector<Classe>> prev;
    private Map<Classe, Sessio> nou;
    private boolean Ple;

    //Constructors

    /**
     * Constructor for Horari
     */
    public Horari(String nom, int HoraIni, int HoraFi, ArrayList<Sessio> Sessions, Vector<Classe> Classes, ArrayList<Restriccio> Restriccions) {
        this.nom = nom;
        this.HoraIni = HoraIni;
        this.HoraFi = HoraFi;
        this.Sessions = Sessions;
        this.Classes = Classes;
        this.Restriccions = Restriccions;
        this.Ple = false;
    }


    //Getters
    public String getNom() {
        return nom;
    }

    public int getHoraIni() { return HoraIni; }

    public int getHoraFi() { return HoraFi; }

    public ArrayList<Sessio> getSessions() {
        return Sessions;
    }

    public Vector<Classe> getClasses() {
        return Classes;
    }

    public ArrayList<Restriccio> getRestriccions() {
        return Restriccions;
    }

    public boolean getPle() {
        return Ple;
    }

    public Map<Classe, Sessio> getNou() {
        return nou;
    }

    public Map<Sessio, Vector<Classe>> getPrev() {
        return prev;
    }


    //Setters

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setHoraIni(int horaIni) { HoraIni = horaIni; }

    public void setHoraFi(int horaFi) { HoraFi = horaFi; }

    public void setSessions(ArrayList<Sessio> Sessions) {
        this.Sessions = Sessions;
    }

    public void setRestriccions(ArrayList<Restriccio> Restriccions) {
        this.Restriccions = Restriccions;
    }

    public void setClasses(Vector<Classe> classes) {
        Classes = classes;
    }

    public void setPle(boolean ple) {
        Ple = ple;
    }


    //Metodes

    public void generar_horari() {

        for(int i = 0; i < Restriccions.size(); ++i) {
            Restriccions.get(i).precondicions();
        }
        for (int i = 0; i < Sessions.size(); ++i) {
            prev.put(Sessions.get(i),Classes);
        }

        Algorisme A = new Algorisme(prev, Restriccions);
        nou = A.getHorari();
        if (!nou.isEmpty()) Ple = true;
    }


}
