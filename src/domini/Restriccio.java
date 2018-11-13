package domini;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;

public abstract class Restriccio {
    //private String id;
    private Horari horari;

    //Constructoras
    public Restriccio() {
    }

    //Getters

    public Vector<Classe> getClassesHorari() {
        return horari.getClasses();
    }

    public ArrayList<Sessio> getSessionsHorari() {
        return horari.getSessions();
    }

    public Map<Sessio, Vector<Classe>> getMap(){
        return horari.getPrev();
    }
    //Setters

    /*public void setHorari(String horari) {this.horari=horari;}

     public void afegirHorari(Horari h) throws HorariJaExisteix {
        for(int i =0;i<horari.size();++i){
            if(horari.get(i).equals(h)) horari.add(h);
            //else throw new HorariJaExisteix();
        }
    } */
    public abstract void precondicions();

    public abstract Boolean esCompleix(Map<Classe, Sessio> nou);
}
