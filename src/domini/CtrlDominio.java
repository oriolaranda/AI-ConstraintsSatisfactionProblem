package domini;

import domini.Aula;
import domini.Horari;

import java.util.ArrayList;
import java.util.Vector;

public class CtrlDominio {

    private Horari horari;
    private PlaEstudis pla;

    public CtrlDominio() {
        pla = new
    }

    public void inicialitzar_horari(String nom) {
        int horaI;
        int horaF;
        //get hores del pla i tal
        horari = new Horari(nom,horaI,horaF);

    }

    public void inicialitzar_sessions(ArrayList<Sessio> S) {
        horari.setSessions(S);
    }

    public void inicialitzar_classes(Vector<Classe> C) {
        horari.setClasses(C);
    }

    public void inicialitzar_restriccions(ArrayList<Restriccio> R) {
        horari.setRestriccions(R);
    }

    public void generacio_horari() {
        horari.generar_horari();
        if(horari.Pl)
    }
}
