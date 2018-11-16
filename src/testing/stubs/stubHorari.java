package testing.stubs;


import domini.Classe;
import domini.Horari;
import domini.Restriccio;
import domini.Sessio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


public class stubHorari extends Horari {

    public stubHorari() {
        super("H0", null, null, null);
    }

    @Override
    public String getNom() {
        return "H0";
    }

    @Override
    public ArrayList<Sessio> getSessions() {
        ArrayList<Sessio> sessions = new ArrayList<>();
        sessions.add(new stubSessio());

        return sessions;
    }

    @Override
    public Vector<Classe> getClasses() {
        Vector<Classe> classes = new Vector<>();
        classes.add(new stubClasse());

        return classes;
    }

    @Override
    public ArrayList<Restriccio> getRestriccions() {
        ArrayList<Restriccio> restriccions = new ArrayList<>();
        restriccions.add(new stubRestriccio());

        return restriccions;
    }

    @Override
    public Map<Classe, Sessio> getNou() {
        Map<Classe, Sessio> nou = new HashMap<>();
        nou.put(new stubClasse(), new stubSessio());
        return nou;
    }

    @Override
    public Map<Sessio, Vector<Classe>> getPrev() {
        Map<Sessio, Vector<Classe>> prev = new HashMap<>();
        Vector<Classe> v = new Vector<>();
        v.add(new stubClasse());
        prev.put(new stubSessio(), v);
        return prev;
    }

    @Override
    public boolean getPle() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
