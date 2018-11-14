package domini;

import java.util.Vector;

public class Grup {
    //Dades
    private String nomAssig;
    private int num;
    private TipusAula tipus;
    private int capacitat;
    private int numSessions;
    private int duracio;
    private Vector<Sessio> sessions;
    private Assignatura assignatura;

    //Constructora
    public Grup(String nomAssig, int num, TipusAula tipus, int capacitat, int duracio) {
        this.nomAssig = nomAssig;
        this.num = num;
        this.tipus = tipus;
        this.capacitat = capacitat;
        this.duracio = duracio;
        for (int i = 0; i < numSessions; ++i) {
            sessions.add(new Sessio(nomAssig + "-" + num, i));
        }
    }

    /**
     * GETTERS
     **/

    public String getAssig() {
        return nomAssig;
    }

    public int getNum() {
        return num;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public int getDuracio() {
        return duracio;
    }

    public TipusAula getTipus() {
        return tipus;
    }

    public int getNumSessions() {
        return numSessions;
    }

    public String getFaseGrup(){
        return assignatura.getFase();
    }

    /**
     * SETTERS
     **/

    public void setAssig(String nomAssig) {
        this.nomAssig = nomAssig;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public void setDuracio(int duracio) {
        this.duracio = duracio;
    }

    public void setTipus(TipusAula tipus) {
        this.tipus = tipus;
    }

    public void setNumSessions(int numSessions) {
        this.numSessions = numSessions;
    }


    @Override
    public String toString() {
        return nomAssig + "-" + num + " " + tipus + " " + capacitat + " alumnes" + " " + duracio + "h/sessio";
    }


}
