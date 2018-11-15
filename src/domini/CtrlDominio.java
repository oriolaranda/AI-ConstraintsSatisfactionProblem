package domini;

import domini.Aula;
import domini.Horari;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class CtrlDominio {

    private Horari horari;
    private PlaEstudis pla;
    private Vector<DiaHora> hores;
    private Vector<Aula> aules;

    public CtrlDominio() {
    }

    public void crear_pla(String nom, int horaIni, int horaFi) {
        int[] periode = null;
        periode[0] = horaIni;
        periode[1] = horaFi;
        pla = new PlaEstudis(nom,periode);
        for(int i = horaIni; i < horaFi;++i) {
            DiaHora aux = new DiaHora("Dilluns",i);
            hores.add(aux);
            aux = new DiaHora("Dimarts",i);
            hores.add(aux);
            aux = new DiaHora("Dimecres",i);
            hores.add(aux);
            aux = new DiaHora("Dijous",i);
            hores.add(aux);
            aux = new DiaHora("Divendres",i);
            hores.add(aux);
        }
    }
    /*
    public void crear_assignatura(String nom, String fase) {
        Assignatura aux = new Assignatura(pla.getNom(),nom,fase);
        pla.addAssignatura(aux);
        for(int i = 0; i < aux.getGrups().size();++i) {
            Grup g = aux.getGrups.get(i);
            for (int j = 0; j < g.getSessions().size(); ++i) {
                Sessio s = g.getSessions().get(j);
                horari.add_sessio(s);
            }
        }
    }*/

    public void crear_aula(String nom, int capacitat, TipusAula tipus) {
        Aula aux = new Aula(nom, capacitat, tipus);
        aules.add(aux);
        if (hores.size() > 0) {
            for (int i = 0; i < hores.size(); ++i) {
                Classe c = new Classe(aux, hores.get(i));
                horari.add_classe(c);
            }
        }
    }

    public void crear_restriccions(ArrayList<Restriccio> R) {
        horari.setRestriccions(R);
    }

    public void generar_horari() {
        horari.generar_horari();
    }
}
