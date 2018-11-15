package domini;

import java.util.Map;
import java.util.Vector;

public abstract class Restriccio {

    private Horari horari;

    //Constructoras
    public Restriccio() {

    }

    public void setHorari(Horari horari) {
        this.horari = horari;
    }

    //Getters

    public Horari getHorari() {
        return horari;
    }

    public Map<Sessio, Vector<Classe>> getMap(){
        return horari.getPrev();
    }

    public abstract void precondicions();

    public abstract Boolean esCompleix(Map<Classe, Sessio> nou,Classe actualc, Sessio actuals);

}
