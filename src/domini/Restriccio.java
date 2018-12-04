package domini;

import java.util.Map;
import java.util.Objects;
import java.util.Vector;

public abstract class Restriccio {

    private Horari horari;

    //Constructoras
    public Restriccio() {
        setHorari(null);
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

    public abstract Boolean precondicions(Sessio s, Classe c);

    public abstract Boolean esCompleix(Map<Classe, Sessio> nou,Classe actualc, Sessio actuals);

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (! (obj instanceof Restriccio)) return false;

        return this.horari.equals(((Restriccio) obj).horari);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horari);
    }
}
