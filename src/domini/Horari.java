package domini;

import java.util.ArrayList;

public class Horari {

    //Atributs
    String nom;
    int HoraIni;
    int HoraFi;
    ArrayList<Sessio> Sessions;
    ArrayList<Restriccio> Restriccions;

    //Constructors

    /**
     Basic constructor for Horari
     */
    public Horari() {
    }

    /**
     Constructor for Horari
     */
    public Horari(String nom, int HoraIni, int HoraFi, ArrayList<Sessio> Sessions, ArrayList<Restriccio> Restriccions) {
        this.nom = nom;
        this.HoraIni = HoraIni;
        this.HoraFi = HoraFi;
        this.Sessions = Sessions;
        this.Restriccions = Restriccions;
    }


    //Getters
    public String getNom() {
        return nom;
    }


    /**
     * Returns the value of HoraIni.
     */
    public int getHoraIni() {
        return HoraIni;
    }

    /**
     * Returns the value of HoraFi.
     */
    public int getHoraFi() {
        return HoraFi;
    }


    /**
     * Returns the value of Sessions.
     */
    public ArrayList<Sessio> getSessions() {
        return Sessions;
    }


    /**
     * Returns the value of Restriccions.
     */
    public ArrayList<Restriccio> getRestriccions() {
        return Restriccions;
    }



    //Setters
    /**
     * Sets the value of nom.
     * @param nom The value to assign nom.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     * Sets the value of HoraIni.
     * @param HoraIni The value to assign HoraIni.
     */
    public void setHoraIni(int HoraIni) {
        this.HoraIni = HoraIni;
    }


    /**
     * Sets the value of HoraFi.
     * @param HoraFi The value to assign HoraFi.
     */
    public void setHoraFi(int HoraFi) {
        this.HoraFi = HoraFi;
    }


    /**
     * Sets the value of Sessions.
     * @param Sessions The value to assign Sessions.
     */
    public void setSessions(ArrayList<Sessio> Sessions) {
        this.Sessions = Sessions;
    }


    /**
     * Sets the value of Restriccions.
     * @param Restriccions The value to assign Restriccions.
     */
    public void setRestriccions(ArrayList<Restriccio> Restriccions) {
        this.Restriccions = Restriccions;
    }



    //Metodes
}
