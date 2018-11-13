package domini;

import java.util.Objects;

public class Aula {
    //Atributs 

    private String Nom;
    private int Capacitat;
    private TipusAula Tipus;
    // private ArrayList<Classe> Classes;


    //Constructors

    /**
     * Constructor for Aula
     */
    public Aula(String Nom, int Capacitat, TipusAula Tipus/*ArrayList<Classe> Classes*/) {
        this.Nom = Nom;
        this.Capacitat = Capacitat;
        this.Tipus = Tipus;
        //this.Classes = Classes;
    }


    //Getters

    /**
     * Returns the value of Nom.
     */
    public String getNom() {
        return Nom;
    }


    /**
     * Returns the value of Capacitat.
     */
    public int getCapacitat() {
        return Capacitat;
    }


    /**
     * Returns the value of Tipus.
     */
    public TipusAula getTipus() {
        return Tipus;
    }


  /*
    public ArrayList<Classe> getClasses() {
        return Classes;
    }
*/


    //Setters

    /**
     * Sets the value of Nom.
     *
     * @param Nom The value to assign Nom.
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }


    /**
     * Sets the value of Capacitat.
     *
     * @param Capacitat The value to assign Capacitat.
     */
    public void setCapacitat(int Capacitat) {
        this.Capacitat = Capacitat;
    }


    /**
     * Sets the value of Tipus.
     *
     * @param Tipus The value to assign Tipus.
     */
    public void setTipus(TipusAula Tipus) {
        this.Tipus = Tipus;
    }

/*
    public void setClasses(ArrayList<Classe> Classes) {
        this.Classes = Classes;
    }
*/


    //Metodes


    @Override
    public String toString() {
        return Nom + ": " + Tipus + " " + Capacitat + " persones ";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Aula)) return false;
        return this.Nom.equals(((Aula) obj).Nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nom, Capacitat, Tipus);
    }
}
