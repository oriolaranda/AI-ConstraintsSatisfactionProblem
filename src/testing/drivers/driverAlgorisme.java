package testing.drivers;

import
import domini.Algorisme;
import domini.Aula;
import domini.Classe;
import domini.Sessio;

import java.util.*;


public class driverAlgorisme {

    public static void main(String[] args) {
        Map<Sessio, Vector<Classe>> m = new Map<Sessio, Vector<Classe>>();
        String[] vs = {"M1-10","M1-20","M1-30","M1-40","M2-10","M2-20","M2-30","M2-40","FM-10","FM-20","FM-30","FM-40","F-10","F-20","F-30","F-40","PRO1-10","PRO1-20","PRO1-30","PRO1-40"};
        Vector<String> as = ("");
        for (String s : vs) {
            Vector<Classe> v;
            for ()
            m.put(new Sessio(s, 0), v);
        }
        Algorisme a = new Algorisme(m);
    }
}
