package domini;

import java.util.ArrayList;
import java.util.Map;

public class RestriccioFase extends Restriccio {
    private ArrayList<Assignatura> assignaturas;

    //Constructoras
    public RestriccioFase(){

    }

    //Getters
    public ArrayList<Assignatura> getAssignaturas(){
        return assignaturas;
    }


    //Setters
    public void setAssignaturas(ArrayList<Assignatura> assignaturas) {
        this.assignaturas = assignaturas;
    }

    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou, Sessio actual) {
        Map<String,String> f=null;
        for(Assignatura a: assignaturas) f.put(a.getNom(),a.getFase());
        if (f!=null) {
            for(Classe c: nou.keySet()) {
                Sessio s=nou.get(c);
                if(f.get(s.getNomAssignatura()).equals(f.get(actual.getNomAssignatura()))) return false;
            }
        }
        return true;
    }

    @Override
    public void precondicions(){

    }

}

