package domini;

import domini.Aula;
import domini.Horari;

import java.util.ArrayList;
import java.util.Vector;

public class CtrlDominio {

    private Horari horari;
    private int preparat;           //Si val 4 haura fet els passos previs per poder generar horari.

    public CtrlDominio() {
        preparat = 0;
    }

    public int getPreparat() { return preparat; }

    public void setPreparat(int p) { this.preparat = p; }

    public void inicialitzar_horari(String nom) {
        horari = new Horari(nom,8,21);
        ++preparat;

    }

    public void inicialitzar_sessions(ArrayList<Sessio> S) {
        horari.setSessions(S);
        ++preparat;
    }

    public void inicialitzar_classes(Vector<Classe> C) {
        horari.setClasses(C);
        ++preparat;
    }

    public void inicialitzar_restriccions(ArrayList<Restriccio> R) {
        horari.setRestriccions(R);
        ++preparat;
    }

    public void generacio_horari() {
        if(preparat == 4) horari.generar_horari();
    }
}
