package domini;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

public class Algorisme {
    private Map<Sessio, Vector<Classe>> prev;
    private Map<Classe, Sessio> nou;

    public Algorisme(Map<Sessio, Vector<Classe>> prev) {
        this.prev = prev;
    }

    public Map<Classe,Sessio> getHorari(){
        if (backtraking(0)) {
            return nou;
        }
        return null;
    }

    public boolean backtraking(int i) {
        ArrayList<Sessio> s = new ArrayList<>(prev.keySet());
        if (i < s.size()) {
            for (Classe c: prev.get(s.get(i))){
                Stack<Classe> poda = new Stack();
                boolean val = comprovarRestriccions();
                if (!val) {
                    System.out.println("Fals: no compleix restriccions");
                    revertirCanvis(poda);
                }
                else {
                    boolean seg = backtraking(i+1);
                    if (seg) return seg;
                }

            }
            return false;
        } else return true;
    }

    private void revertirCanvis(Stack<Classe> revert) {
        if (!revert.isEmpty()) {
            Classe c = revert.pop();
            while (! revert.isEmpty()) {
                afegir_possibilitat(c);
                c = revert.pop();
            }
        }

    }

    private boolean comprovarRestriccions() {
        for (Sessio s: prev.keySet()) {
            if(prev.get(s).isEmpty()) {
                System.out.println("No queden valors disponibles per a la variable");
                return false;
            }
        }
        return true;
    }




    private Stack<Classe> forwardChecking (Sessio s, Classe c) {
        Stack<Classe> poda = new Stack<>();
        poda.addAll(eliminarTotes(s,c));
        for (Sessio s2: prev.keySet()) {
            if (s2 != s) {
                ArrayList<Classe> podaF = eliminarTotes(s2, c);
                poda.addAll(podaF);
            }
        }
        return poda;
    }

}
