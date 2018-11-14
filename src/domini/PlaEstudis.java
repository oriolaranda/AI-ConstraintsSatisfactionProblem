package domini;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PlaEstudis {
    private String nom;
    private int[] periodeLectiu;
    private ArrayList<Assignatura> assignatures;
    private Horari horari;

    //Constructora
    public PlaEstudis(String nom, int[] periodeLectiu) {
        this.nom = nom;
        this.periodeLectiu = (int[]) periodeLectiu;
        horari = null;
        assignatures = new ArrayList<Assignatura>();
    }

    /**
     * GETTERS
     **/


    public String getNom() {
        return nom;
    }

    public ArrayList<Assignatura> getAssignatures() {
        return assignatures;
    }

    public Horari getHorari() {
        return horari;
    }

    public int[] getPeriodeLectiu() {
        return periodeLectiu;
    }

    /**
     * SETTERS
     **/

    //Canviar nom (el nom no existeix en cap altre PlaEstudis)
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPeriodeLectiu(int hi, int hf) {
        this.periodeLectiu = new int[]{hi,hf};
    }

    public void addAssignatura(Assignatura a) {
        assignatures.add(a);
        Collections.sort(assignatures);
    }

    public void addAssignatures(ArrayList<Assignatura> assignatures) {
        assignatures.addAll(assignatures);
    }
    public void removeAssignatura(Assignatura a) {
        assignatures.remove(a);
    }

    public void addHorari(Horari horari) {
        this.horari = horari;
    }

    @Override
    public String toString() {
        return nom + " periode lectiu "+periodeLectiu[0] +"h-"+periodeLectiu[1]+"h";
    }
}
