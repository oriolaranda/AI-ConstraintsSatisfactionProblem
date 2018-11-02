package domini;

import java.util.ArrayList;

public class PlaEstudis {
    private String nom;
    private int periodeLectiu;
    private ArrayList<Assignatura> assignatures;
    private Horari horari;

    //Constructora
    public PlaEstudis(String nom){
        this.nom = nom;
        periodeLectiu = 0;
        horari = null;
        assignatures = new ArrayList<Assignatura>();
    }

    /** GETTERS **/


    public String getNom() {
        return nom;
    }

    public ArrayList<Assignatura> getAssignatures() {
        return assignatures;
    }

    /** SETTERS **/

    //Canviar nom (el nom no existeix en cap altre PlaEstudis)
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void addAssignatura(Assignatura a) {
        assignatures.add(a);
    }
    public void removeAssignatura(Assignatura a){
        assignatures.remove(a);
    }

    public void modAssignatura(Assignatura a) {

    }

    public showAssignatures() {

    }
}
