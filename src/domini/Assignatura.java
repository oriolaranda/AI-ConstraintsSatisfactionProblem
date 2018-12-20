package domini;

import java.util.ArrayList;
import java.util.Objects;

public class Assignatura implements Comparable<Assignatura> {
    private String nomPlaEstudis;
    private String nom;
    private String fase;
    private int capacitatGrup;
    private int capacitatSubgrup;
    private int matriculats;
    private TipusAula tipusAulaSubgrup;

    private int numSessions;
    private int duracio;
    private ArrayList<Grup> grups;
    private ArrayList<String> correquisits;


    //Constructora
    public Assignatura() {
        nomPlaEstudis = null;
        nom = null;
        fase = null;
        grups = new ArrayList<Grup>();
        correquisits = new ArrayList<String>();
    }

    public Assignatura(String nomPlaEstudis, String nom, String fase) {
        this.nomPlaEstudis = nomPlaEstudis;
        this.nom = nom;
        this.fase = fase;
        this.grups = new ArrayList<Grup>();
        this.correquisits = new ArrayList<String>();
    }

    public Assignatura(String nomPlaEstudis, String nom, String fase, int capacitatGrup, int capacitatSubGrups, int matriculats, TipusAula tipusSubgrup, int numSessions, int duracio) {
        this.nomPlaEstudis = nomPlaEstudis;
        this.nom = nom;
        this.fase = fase;
        this.capacitatGrup = capacitatGrup;
        this.capacitatSubgrup = capacitatSubGrups;
        this.matriculats = matriculats;
        this.tipusAulaSubgrup = tipusSubgrup;
        this.numSessions = numSessions;
        this.duracio = duracio;
        this.grups = new ArrayList<Grup>();
        for (int i = 0; i < matriculats/capacitatGrup; ++i) {
            crearGrup((i + 1) * 10, TipusAula.TEORIA, capacitatGrup, numSessions, duracio);
            for (int j = 0; j < capacitatGrup / capacitatSubGrups;++j) {
                crearGrup((i+1)*10+j,tipusSubgrup,capacitatSubGrups,numSessions,duracio);
            }
        }
        this.correquisits= new ArrayList<String>();
    }


    //Getters
    public String getNomPlaEstudis() {
        return nomPlaEstudis;
    }

    public String getNom() {
        return nom;
    }

    public String getFase() {
        return fase;
    }

    public int getCapacitatGrup() { return capacitatGrup; }

    public int getCapacitatSubgrup() { return capacitatSubgrup; }

    public int getMatriculats() { return matriculats; }

    public TipusAula getTupusAulaSubgrup() { return tipusAulaSubgrup; }

    public int getNumSessions() { return numSessions; }

    public int getDuracio() { return duracio; }

    public ArrayList<Grup> getGrups() {
        return grups;
    }

    public ArrayList<String> getCorrequisits() {
        return correquisits;
    }


    //Setters
    public void setNomPlaEstudis(String pla) {
        nomPlaEstudis = pla;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setFase(String f) {
        fase = f;
    }

    public void setCapacitatGrup(int capacitatGrup) {
        this.capacitatGrup = capacitatGrup;
    }

    public void setCapacitatSubgrup(int capacitatSubgrup) {
        this.capacitatSubgrup = capacitatSubgrup;
    }

    public void setMatriculats(int matriculats) {
        this.matriculats = matriculats;
    }

    public void setTupusAulaSubgrup(TipusAula tupusAulaSubgrup) {
        this.tipusAulaSubgrup = tupusAulaSubgrup;
    }

    public void setNumSessions(int numSessions) {
        this.numSessions = numSessions;
    }

    public void setDuracio(int duracio) {
        this.duracio = duracio;
    }



    private void crearGrup(int num, TipusAula tipus, int capacitat, int numSessions, int duracio) {
        if (!existeixGrup(num)) {
            Grup g = new Grup(nom, num, tipus, numSessions, capacitat, duracio, this);
            grups.add(g);
        }
    }
    public void afegirCorrequisit(String nom){
        correquisits.add(nom);
    }

    public void eliminarCorrequisit(String nom){
        if(esCorrequisit(nom)) correquisits.remove(nom);
    }


    //Consultores
    public Boolean esCorrequisit(String nom){
        return correquisits.contains(nom);
    }
    //igual hay que hacer check del valor de nom para ver si es posible o no

    private Boolean existeixGrup(int num) {
        for (int i = 0; i < grups.size(); ++i) if (grups.get(i).getNum() == num) return true;
        return false;
    }



    @Override
    public String toString() {
        return nomPlaEstudis + ": " + nom + " (" + fase + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Assignatura)) return false;
        return this.nom.equals(((Assignatura) obj).nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomPlaEstudis, nom, fase, grups);
    }

    @Override
    public int compareTo(Assignatura o) {
        return this.nom.compareTo(o.nom);
    }

}
