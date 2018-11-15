package domini;

import java.util.ArrayList;
import java.util.Vector;

public class Grup {
    //Dades
    private String nomAssig;
    private int num;
    private TipusAula tipus;
    private int capacitat;
    private int numSessions;
    private int duracio;
    private String fase;
    private ArrayList<Sessio> sessions;


    //Constructora
    public Grup(String nomAssig, int num, TipusAula tipus, int numSessions, int capacitat, int duracio, String fase) {
        this.nomAssig = nomAssig;
        this.num = num;
        this.tipus = tipus;
        this.numSessions = numSessions;
        this.capacitat = capacitat;
        this.duracio = duracio;
        this.sessions = new ArrayList<>();
        for (int i = 0; i < numSessions; ++i) {
            sessions.add(new Sessio(nomAssig + "-" + num, i,this));
        }
        this.fase = fase;
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

    public String getFase(){ return fase; }

    public ArrayList<Sessio> getSessions() {
        return sessions;
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

    public void setFase(String fase) {
        this.fase = fase;
    }

    @Override
    public String toString() {
        return nomAssig + "-" + num + " " + tipus + " " + capacitat + " alumnes" + " " + duracio + "h/sessio";
    }


}
