package domini;

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class Algorisme {
    private Map<Sessio,ArrayList<Classe>> prev;
    private Map<Sessio, Classe> nou;

    public Algorisme(Map<Sessio,ArrayList<Classe>> prev) {
        this.prev = prev;
    }

    public Map<Sessio,Classe> getHorari(){
        if (generarHorari()) return nou;
        return null;
    }

    public boolean backtraking(int i) {
        ArrayList<Sessio> s = new ArrayList<>(prev.keySet());
        if (i < s.size()) {
            for (Classe c: prev.get(s.get(i))){
                boolean
            }
        }
    }

    //retorna true si ja ha acabat o false si encara no
    public boolean selectClasse (int index) {
        ArrayList<assignacio> l = new ArrayList<>( conjuntAssignacions.values());

        if (index < l.size()) {
            assignacio a = l.get(index);
            ArrayList<Classe> possibleClasses = a.getAllPossibleClasses();

            for (Classe c: possibleClasses )
            {
                a.updateClassesRestants(-1);
                Stack<Classe> eliminades = new Stack();

                eliminades.addAll(forward_checking (c)); //forward checking

                boolean valid = checkNotEmpty ();

                if (!valid) System.out.println("Fals");
                if (valid)  //l'horari compleix totes les restriccions
                {
                    boolean r;
                    if (a.getNumeroClassesRestants() == 0) {  //vol dir que ja no cal seleccionar mes classes per aquesta assignacio
                        r = selectClasse(index + 1); //passem a comprovar la seguent assignacio
                    }
                    else {
                        r = selectClasse(index);  //encara queden classes que assignar
                    }

                    if (r) //ja hem acabat
                        return r;

                    //si not r, hem de seguir iterant

                }

                //revertim els canvis fets usant la stack eliminades
                revertChanges (eliminades);


                a.updateClassesRestants(1);

            }

            return false;   //vol dir que hem mirat totes les opcions i no n'hi ha cap que funcioni

        }
        else return true;

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
