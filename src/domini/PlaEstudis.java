package domini;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PlaEstudis {
    private String nom;
    private int[] periodeLectiu;
    private ArrayList<Assignatura> assignatures;
    private ArrayList<Horari> horaris;

    //Constructora
    public PlaEstudis(String nom, int[] periodeLectiu) {
        this.nom = nom;
        this.periodeLectiu = periodeLectiu;
        horaris = new ArrayList<>();
        assignatures = new ArrayList<>();
    }

    public PlaEstudis(String nom, int[] periodeLectiu, ArrayList<Assignatura> assignatures) {
        this.nom = nom;
        this.periodeLectiu = periodeLectiu;
        horaris = new ArrayList<>();
        this.assignatures = (ArrayList<Assignatura>) assignatures.clone();
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

    public ArrayList<Horari> getHoraris() {
        return horaris;
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

    public void addAssignatures(ArrayList<Assignatura> assig) {
        assignatures.addAll(assig);
        Collections.sort(assignatures);
    }
    public void removeAssignatura(Assignatura a) {
        assignatures.remove(a);
    }

    public void removeAssignatures(ArrayList<Assignatura> assig) {
        assignatures.removeAll(assig);
    }

    public void addHorari(Horari horari) {
        this.horaris.add(horari);
    }

    public void removeHorari(Horari horari) {this.horaris.remove(horari);}

    @Override
    public String toString() {
        return nom + " periode lectiu "+periodeLectiu[0] +"h-"+periodeLectiu[1]+"h";
    }
}
