package domini;

import java.util.*;

public class Algorisme {
    private Map<Sessio, Vector<Classe>> prev;
    private Map<Classe, Sessio> nou;
    private LinkedList<Sessio> s;
    private ArrayList<Restriccio> restriccions;

    public Algorisme(Map<Sessio, Vector<Classe>> prev, ArrayList<Restriccio> restriccions) {
        this.prev = (HashMap<Sessio, Vector<Classe>>) prev;
        nou = new HashMap<>();
        s = new LinkedList<Sessio>(prev.keySet());
        this.restriccions = restriccions;
    }

    public Map<Classe, Sessio> getHorari() {
        System.out.println(s);
        if (backtracking(0)) {
            System.out.println("S'HA TROBAT UN HORARI");
            /*for (Map.Entry<Sessio, Vector<Classe>> entry : prev.entrySet()) {
                nou.put(entry.getValue().firstElement(), entry.getKey());
            }*/
            return nou;
        }
        System.out.println("NO S'HA TROBAT UN HORARI");
        return null;
    }

    private LinkedList<Sessio> split(int x) {
        LinkedList<Sessio> vector = (LinkedList<Sessio>) s.clone();
        for (int i = 0; i < x; ++i) {
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

    public boolean backtracking(int i) {
        if (i < s.size()) {

            for (Classe c : prev.get(s.get(i))) {
                System.out.println("***"+s.get(i));

                /*eliminem el valor de les altres variables
                for (Sessio s1 : split(i + 1)) {
                    prev.put(s1, supr(prev.get(s1), c));
                    //System.out.println(s1+" "+prev.get(s1));
                }
                //eliminem tots els valors menys el bo a la variable
                prev.put(s.get(i), eliminar(prev.get(s.get(i)), c));
                //System.out.println(s.get(i)+" "+ prev.get(s.get(i)));
                */

                boolean correcte = comprovarRestriccions(c,s.get(i));

                if (correcte) {
                    if (backtracking(i+1)) return true;
                    else nou.remove(c);
                } else {

                    //tornem a posar el valor a la resta de variables
                    /*for (Sessio s1 : split(i + 1)) {
                        prev.put(s1, add(prev.get(s1), c));
                        //System.out.println(s1+" "+prev.get(s1));
                    }
                    //tornem a posar tots els valors que tenia la variable
                    prev.put(s.get(i), prev.get(s.get(i)));
                    */
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

    }

    private void afegir_possibilitat(Classe c) {

    }

    private boolean comprovarRestriccions(Classe classe, Sessio sessio) {
        /*for (Sessio s : prev.keySet()) {
            if (prev.get(s).isEmpty()) {
                System.out.println("No queden valors disponibles per a la variable " + s);
                return false;
            }
        }*/
        System.out.println(sessio+" "+classe);

        if (nou.containsKey(classe) && nou.get(classe) != null) return false;
        nou.put(classe,sessio);

        /*for(Restriccio r: restriccions){
            Boolean b = r.esCompleix(nou,classe,sessio);
        }*/
        return true;
    }


    private Stack<Classe> forwardChecking(int i, Classe c) {
        Stack<Classe> poda = new Stack<>();
        for (Sessio sessio : s.subList(i+1, s.size()-1)) {
            prev.put(sessio, supr(prev.get(sessio), c));
        }
        return poda;
    }

    private ArrayList<Classe> eliminarTotes(Sessio s, Classe c) {
        return null;
    }


}
