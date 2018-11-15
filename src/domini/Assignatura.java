package domini;

import java.util.ArrayList;
import java.util.Objects;

public class Assignatura implements Comparable<Assignatura> {
    private String nomPlaEstudis;
    private String nom;
    private String fase;
    private ArrayList<Grup> grup;


    //Constructora
    public Assignatura() {
        nomPlaEstudis = null;
        nom = null;
        fase = null;
        grup = new ArrayList<Grup>();
    }

    public Assignatura(String nomPlaEstudis, String nom, String fase) {
        this.nomPlaEstudis = nomPlaEstudis;
        this.nom = nom;
        this.fase = fase;
        this.grup = new ArrayList<Grup>();
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
        for (int i = 0; i < grup.size(); ++i) if (grup.get(i).getNum() == num) return true;
        return false;
    }

    public void crearGrup(int num, TipusAula tipus, int capacitat, int numSessions, int duracio) {
        if (!existeixGrup(num)) {
            Grup g = new Grup(nom, num, tipus, capacitat, duracio);
            grup.add(g);
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
        return Objects.hash(nomPlaEstudis, nom, fase, grup);
    }


    @Override
    public int compareTo(Assignatura o) {
        return this.nom.compareTo(o.nom);
    }
}
