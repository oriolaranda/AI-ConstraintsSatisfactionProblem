package domini;

import java.util.*;

public class Algorisme {
    private Map<Sessio, Vector<Classe>> prev;
    private Map<Classe, Sessio> nou;
    private Vector<Sessio> s;

    public Algorisme(Map<Sessio, Vector<Classe>> prev) {
        this.prev = (Map<Sessio, Vector<Classe>>) prev;
        nou = new HashMap<>();
        s = new Vector<Sessio>(prev.keySet());
    }

    public Map<Classe,Sessio> getHorari(){
        System.out.println(s);
        if (backtraking(0)) {
            for (Map.Entry<Sessio, Vector<Classe>> entry: prev.entrySet()) {
                nou.put(entry.getValue().firstElement(),entry.getKey());
            }
            return nou;
        }
        return null;
    }

    private Vector<Sessio> split(int x) {
        Vector<Sessio> vector = (Vector<Sessio>) s.clone();
        for (int i = 0; i < x; ++i){
            vector.remove(0);
        }
        return vector;
    }
    private Vector<Classe> eliminar(Vector<Classe> v, Classe c) {
        Vector<Classe> vector = (Vector<Classe>) v.clone();
        vector.removeAllElements();
        vector.add(c);
        return vector;
    }
    private Vector<Classe> supr(Vector<Classe> v, Classe c) {
        Vector<Classe> vector = (Vector<Classe>) v.clone();
        vector.remove(c);
        return vector;
    }

    public boolean backtraking(int i) {
        if (i < s.size()) {

            for (Classe c: prev.get(s.get(i))){
                //System.out.println("***"+s.get(i));

                //eliminem el valor de les altres variables
                for (Sessio s1 : split(i+1)){
                    prev.put(s1,supr(prev.get(s1),c));
                    //System.out.println(s1+" "+prev.get(s1));
                }
                //eliminem tots els valors menys el bo a la variable
                prev.put(s.get(i), eliminar(prev.get(s.get(i)),c));
                //System.out.println(s.get(i)+" "+ prev.get(s.get(i)));
                boolean correcte = comprovarRestriccions();
                if (correcte) {
                    boolean seg = backtraking(i+1);
                    if (seg) return seg;
                } else {
                    //revertirCanvis(poda);

                    //tornem a posar el valor a la resta de variables
                    for (Sessio s1 : split(i+1)){
                        prev.put(s1,add(prev.get(s1),c));
                        //System.out.println(s1+" "+prev.get(s1));
                    }
                    //tornem a posar tots els valors que tenia la variable
                    prev.put(s.get(i), prev.get(s.get(i))); //
                }

            }
            return false;
        } else return true;
    }

    private Vector<Classe> add(Vector<Classe> v, Classe c) {
        Vector<Classe> vector = (Vector<Classe>) v.clone();
        vector.add(c);
        return vector;
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

    private void afegir_possibilitat(Classe c) {
    }

    private boolean comprovarRestriccions() {
        for (Sessio s: prev.keySet()) {
            if(prev.get(s).isEmpty()) {
                System.out.println("No queden valors disponibles per a la variable "+s);
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

    private ArrayList<Classe> eliminarTotes(Sessio s, Classe c) {
        return null;
    }


}
