package domini;

import java.util.ArrayList;
import java.util.Objects;

public class Assignatura implements Comparable<Assignatura> {
    private String nomPlaEstudis;
    private String nom;
    private String fase;
    private ArrayList<Grup> grups;


    //Constructora
    public Assignatura() {
        nomPlaEstudis = null;
        nom = null;
        fase = null;
        grups = new ArrayList<Grup>();
    }

    public Assignatura(String nomPlaEstudis, String nom, String fase) {
        this.nomPlaEstudis = nomPlaEstudis;
        this.nom = nom;
        this.fase = fase;
        this.grups = new ArrayList<Grup>();
    }
    public Assignatura(String nomPlaEstudis, String nom, String fase, int capacitatGrup, int capacitatSubGrups, int matriculats, TipusAula tipusSubgrup, int numSessions, int duracio) {
        this.nomPlaEstudis = nomPlaEstudis;
        this.nom = nom;
        this.fase = fase;
        this.grups = new ArrayList<Grup>();
        for (int i = 0; i < matriculats/capacitatGrup; ++i) {
            crearGrup((i + 1) * 10, TipusAula.TEORIA, capacitatGrup, numSessions, duracio);
            for (int j = 0; j < capacitatGrup / capacitatSubGrups;++j) {
                crearGrup((i+1)*10+j,tipusSubgrup,capacitatSubGrups,numSessions,duracio);
            }
        }
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

    public ArrayList<Grup> getGrups() {
        return grups;
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

    private Boolean existeixGrup(int num) {
        for (int i = 0; i < grups.size(); ++i) if (grups.get(i).getNum() == num) return true;
        return false;
    }

    private void crearGrup(int num, TipusAula tipus, int capacitat, int numSessions, int duracio) {
        if (!existeixGrup(num)) {
            Grup g = new Grup(nom, num, tipus, numSessions, capacitat, duracio, fase);
            grups.add(g);
        }
        //else tractar excepcio
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
