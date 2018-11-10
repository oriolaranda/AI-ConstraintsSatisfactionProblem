package domini;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Algorisme {
    private Map<Sessio,Map<Classe, Boolean>> prev;
    private Map<Sessio, Classe> nou;

    public Algorisme(Map<Sessio, Map<Classe, Boolean>> prev) {
        this.prev = prev;
    }

    public Map<Sessio,Classe> getHorari(){
        if (backtraking(0)) return nou;
        return null;
    }

    public boolean backtraking(int i) {
        ArrayList<Sessio> s = new ArrayList<>(prev.keySet());
        if (i < s.size()) {
            for (Classe c: prev.get(s.get(i)).keySet()){
                Stack<Classe> poda = new Stack();
                boolean val = comprovarRestriccions();
                if (!val) System.out.println("Fals: no compleix restriccions");
                else {
                    boolean seg = backtraking(i+1);
                    if (seg) return seg;
                }
                revertirCanvis();
            }
            return false;
        } else return true;
    }

    private void revertirCanvis() {

    }

    private boolean comprovarRestriccions() {

    }




    private Stack<Classe> forward_checking (Classe c) {
        Stack<Classe> totes_eliminades = new Stack<>();

        assignacio assig_actual = conjuntAssignacions.get(c.getId_assig()+c.getId_grup());
        totes_eliminades.addAll(assig_actual.borrarTotes (c));


        for (Map.Entry<String, assignacio> aux : conjuntAssignacions.entrySet()) {
            assignacio a = aux.getValue();
            if (a != assig_actual) {
                ArrayList<Classe> eliminades = a.forwardChecking(c);
                totes_eliminades.addAll(eliminades);
            }
        }
        return totes_eliminades;
    }


    private boolean checkNotEmpty () {
        for (Map.Entry<String, assignacio> aux : conjuntAssignacions.entrySet()) {
            assignacio a = aux.getValue();
            if (a.getAllPossibleClasses().isEmpty()) {
                System.out.println("La assignacio ");
                a.showAll();
                return false;
            }
        }
        return true;
    }


    private void revertChanges (Stack<Classe> eliminades) {
        if (! eliminades.empty()) {
            Classe c = eliminades.pop();
            while (!eliminades.isEmpty()) {
                assignacio a = conjuntAssignacions.get(c.getId_assig() + c.getId_grup());
                a.afegeixPossibilitat(c);
                c = eliminades.pop();
            }
        }
    }

}
