package testing.drivers;

import domini.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;


public class driverAlgorisme {

    public static void main(String[] args) {
        Map<Sessio, Vector<Classe>> m = new HashMap<Sessio, Vector<Classe>>();
        String[] vs = {"M1-10", "M1-20", "M1-30", "M1-40", "M2-10", "M2-20", "M2-30", "M2-40", "FM-10", "FM-20", "FM-30", "FM-40", "F-10", "F-20", "F-30", "F-40", "PRO1-10", "PRO1-20", "PRO1-30", "PRO1-40"};
        String[] as = {"A5001", "A5002", "A5003", "A5004", "A5005", "A5006", "A5007", "A5008", "A5009", "A5010", "A5011", "A5012", "A5013", "A5014"};
        Vector<Classe> v = new Vector<Classe>();
        for (String a : as) {
           v.add(new Classe(new Aula(a, 50, TipusAula.TEORIA), new DiaHora("Dilluns", 8)));
            v.add(new Classe(new Aula(a, 50, TipusAula.TEORIA), new DiaHora("Dimarts", 8)));
            v.add(new Classe(new Aula(a, 50, TipusAula.TEORIA), new DiaHora("Dimecres", 8)));
            v.add(new Classe(new Aula(a, 50, TipusAula.TEORIA), new DiaHora("Dijous", 8)));
            v.add(new Classe(new Aula(a, 50, TipusAula.TEORIA), new DiaHora("Divendres", 8)));
        }
        for (String s : vs) {
            m.put(new Sessio(s, 0), v);
        }
        Algorisme a = new Algorisme(m, null);
        for (Sessio s : m.keySet()) {
            //System.out.print(s+"= { ");
            for (Classe e : m.get(s)) {
                // System.out.print(e + ", ");
            }
            //System.out.print("}\n");
        }
        System.out.println("Num variables: " + m.keySet().size() + " Num valors: " + v.size());
        a.getHorari().forEach((x, y) -> System.out.println(x + "->" + y));
        //a.getHorari();
    }
}
