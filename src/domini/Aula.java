package domini;

import java.util.ArrayList;

public class Aula {
    //Atributs 

    private String Nom;
    private int Capacitat;
    private TipusAula Tipus;
    private ArrayList<Sessio> Sessions;



    //Constructors

    /**
     Constructor for Aula
     */
    public Aula(String Nom, int Capacitat, TipusAula Tipus, ArrayList<Sessio> Sessions) {
        this.Nom = Nom;
        this.Capacitat = Capacitat;
        this.Tipus = Tipus;
        this.Sessions = Sessions;
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


    /**
     * Returns the value of Sessions.
     */
    public ArrayList<Sessio> getSessions() {
        return Sessions;
    }



    //Setters

    /**
     * Sets the value of Nom.
     * @param Nom The value to assign Nom.
     */
    public void setNom(String Nom) {
        this.Nom = Nom;
    }


    /**
     * Sets the value of Capacitat.
     * @param Capacitat The value to assign Capacitat.
     */
    public void setCapacitat(int Capacitat) {
        this.Capacitat = Capacitat;
    }


    /**
     * Sets the value of Tipus.
     * @param Tipus The value to assign Tipus.
     */
    public void setTipus(TipusAula Tipus) {
        this.Tipus = Tipus;
    }


    /**
     * Sets the value of Sessions.
     * @param Sessions The value to assign Sessions.
     */
    public void setSessions(ArrayList<Sessio> Sessions) {
        this.Sessions = Sessions;
    }



    //Metodes
}
