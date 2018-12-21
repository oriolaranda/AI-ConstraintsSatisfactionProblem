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
        if (backtracking(0)) {

            return nou;
        }
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

            for (int j = 0; j < prev.get(s.get(i)).size();++j){
                Classe c = prev.get(s.get(i)).get(j);


                boolean correcte = comprovarRestriccions(c,s.get(i));


                if (correcte) {
                    nou.put(c,s.get(i));
                    //eliminem el valor de les altres variables
                    for (Sessio s1 : split(i + 1)) {
                        prev.put(s1, supr(prev.get(s1), c));
                        //System.out.println(s1+" "+prev.get(s1));
                    }
                    forwardChecking(s.get(i),c);

                    if (backtracking(i+1)) return true;
                    else {
                        nou.remove(c);
                        for (Sessio s1 : split(i + 1)) {
                            prev.put(s1, add(prev.get(s1), c));
                            //System.out.println(s1+" "+prev.get(s1));
                        }
                    }
                } else {

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


    private boolean comprovarRestriccions(Classe classe, Sessio sessio) {
        for (Sessio s1 : split(s.indexOf(sessio)+1)) {
            if (prev.get(s1).isEmpty()) {
                return false;
            }
        }

        if (restriccions != null) {
            for (Restriccio r : restriccions) {
                Boolean b = r.esCompleix(nou, classe, sessio);
                if (!b) return false;
            }
            return true;
        }
        return true;
    }


    /**
     *
     *
     * @param sessio
     * @param classe
     * @return stack<classe>
     */
    private void forwardChecking(Sessio sessio, Classe classe) {
        for (Sessio s1 : split(s.size()-1)) {
            Vector<Classe> v = supr(prev.get(s1), classe);


            for(Restriccio r: restriccions) {
                if(r instanceof RestriccioFase) { //Restriccio fase
                    for(int i = 0;  i < v.size(); ++i) {
                        Classe c = v.get(i);
                        if(c.getDiaClasse().equals(classe.getDiaClasse()) && c.getHoraClasse() == c.getHoraClasse()) {
                            v.remove(i);

                        }
                    }
                } else if(r instanceof RestriccioCorrequisit) { //Restriccio Correquisit
                    for (int i = 0; i < v.size(); ++i) {
                        Classe c = v.get(i);
                        if (c.getDiaClasse().equals(classe.getDiaClasse()) && c.getHoraClasse() == c.getHoraClasse()) {
                            v.remove(i);

                        }
                    }
                }

            }

            prev.put(s1,v);

        }
    }

    private ArrayList<Classe> eliminarTotes(Sessio s, Classe c) {
        return null;
    }


}
