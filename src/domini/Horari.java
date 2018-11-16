package domini;

import java.util.*;

public class Horari {

    //Atributs
    private String nom;
    private ArrayList<Sessio> Sessions;
    private Vector<Classe> Classes;
    private ArrayList<Restriccio> Restriccions;
    private Map<Sessio, Vector<Classe>> prev;
    private Map<Classe, Sessio> nou;
    private boolean Ple;

    //Constructors

    public Horari(String nom) {
        this.nom = nom;
        this.Ple = false;
        this.Sessions = new ArrayList<Sessio>();
        this.Classes = new Vector<Classe>();
        this.Restriccions = new ArrayList<Restriccio>();
        this.prev = new HashMap<>();
        this.nou = new HashMap<>();
    }

    /**
     * Constructor for Horari
     */
    public Horari(String nom, ArrayList<Sessio> Sessions, Vector<Classe> Classes, ArrayList<Restriccio> Restriccions) {
        this.nom = nom;
        this.Sessions = Sessions;
        this.Classes = Classes;
        this.Restriccions = Restriccions;
        this.Ple = false;
    }


    //Getters
    public String getNom() {
        return nom;
    }

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

    public void setSessions(ArrayList<Sessio> Sessions) {
        this.Sessions = Sessions;
    }

    public void setRestriccions(ArrayList<Restriccio> Restriccions) {
        this.Restriccions = (ArrayList<Restriccio>) Restriccions.clone();
    }

    public void setClasses(Vector<Classe> classes) {
        this.Classes = classes;
    }

    public void setPle(boolean ple) {
        this.Ple = ple;
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

    public void add_sessio(Sessio S) {
        Sessions.add(S);
    }

    public void remove_sessio(Sessio S) {
        Sessions.remove(S);
    }

    public void add_classe(Classe C) {
        Classes.add(C);
    }

    public void remove_classe(Classe C) {
        Classes.remove(C);
    }

    public void add_restriccio(Restriccio R) {
        Restriccions.add(R);
    }

    public void remove_restriccio(Restriccio R) {
        Restriccions.remove(R);
    }
}
