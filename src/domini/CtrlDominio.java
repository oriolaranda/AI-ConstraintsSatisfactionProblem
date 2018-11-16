package domini;

import domini.Aula;
import domini.Horari;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class CtrlDominio {

    private Horari horari;
    private PlaEstudis pla;
    private ArrayList<DiaHora> hores;
    private ArrayList<Aula> aules;

    public CtrlDominio() {
        this.horari = new Horari("Alex");
        this.hores = new ArrayList<DiaHora>();
        this.aules = new ArrayList<Aula>();
    }

    public PlaEstudis getPla() {
        return pla;
    }

    public Horari getHorari() {
        return horari;
    }
    public ArrayList<DiaHora> getHores() {
        return hores;
    }

    public ArrayList<Aula> getAules() {
        return aules;
    }

    public void crear_pla(String nom, int horaIni, int horaFi) {
        int[] periode = new int[] {horaIni,horaFi};
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

    public void crear_assignatura(String nom, String fase,int capGrup, int capSGrup, int matric, TipusAula tipus, int numSes, int dur,Vector<String> correquisits) {
        Assignatura aux = new Assignatura(pla.getNom(),nom,fase,capGrup,capSGrup,matric,tipus,numSes,dur);
        int mida = correquisits.size();
        for (int i = 0; i < mida; ++i) {
            aux.afegirCorrequisit(correquisits.get(i));
        }
        pla.addAssignatura(aux);
        for(int i = 0; i < aux.getGrups().size();++i) {
            Grup g = aux.getGrups().get(i);
            for (int j = 0; j < g.getSessions().size(); ++j) {
                Sessio s = g.getSessions().get(j);
                horari.add_sessio(s);
            }
        }
    }

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

    public void print_horari() {
        horari.printHorari();
    }
}
