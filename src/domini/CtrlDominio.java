package domini;

import domini.Aula;
import domini.Horari;
import persistencia.CtrlPersistencia;

import java.util.ArrayList;
import java.util.Vector;

public class CtrlDominio {

    private Horari horari;
    private PlaEstudis pla;
    private ArrayList<DiaHora> hores;
    private ArrayList<Aula> aules;
    private ArrayList<String> nom_plans;
    private CtrlPersistencia pers;

    public CtrlDominio() throws Exception {
        this.horari = new Horari("Horari");
        this.hores = new ArrayList<DiaHora>();
        this.pers = new CtrlPersistencia();
        this.aules = new ArrayList<>();
        carregar_all_aules();
        this.nom_plans = pers.carregar_all_plans();
    }


//GETTERS
    public PlaEstudis getPla() {
        return pla;
    }

    public Horari getHorari() {
        return horari;
    }

    public ArrayList<Aula> getAules() {
        return aules;
    }

    public ArrayList<String> getNom_plans() { return nom_plans;}


//CREADORES INDIVIDUALS

    public void crear_pla(String nom, int horaIni, int horaFi) {
        int[] periode = new int[]{horaIni, horaFi};
        pla = new PlaEstudis(nom, periode);
        guardar_pla(nom, horaIni, horaFi);
        hores.clear();
        for (int i = horaIni; i < horaFi; ++i) {
            DiaHora aux = new DiaHora("Dilluns", i);
            hores.add(aux);
            aux = new DiaHora("Dimarts", i);
            hores.add(aux);
            aux = new DiaHora("Dimecres", i);
            hores.add(aux);
            aux = new DiaHora("Dijous", i);
            hores.add(aux);
            aux = new DiaHora("Divendres", i);
            hores.add(aux);
        }
    }

    public void crear_assignatura(String nom, String fase, int capGrup, int capSGrup, int matric, TipusAula tipus, int numSes, int dur, Vector<String> correquisits) throws Exception {
        Assignatura aux = new Assignatura(pla.getNom(), nom, fase, capGrup, capSGrup, matric, tipus, numSes, dur);
        int mida = correquisits.size();
        for (int i = 0; i < mida; ++i) {
            aux.afegirCorrequisit(correquisits.get(i));
        }
        pla.addAssignatura(aux);
        guardar_assignatura(pla.getNom(), nom, fase, capGrup, capSGrup, matric, String.valueOf(tipus), numSes, dur, correquisits);
        for (int i = 0; i < aux.getGrups().size(); ++i) {
            Grup g = aux.getGrups().get(i);
            for (int j = 0; j < g.getSessions().size(); ++j) {
                Sessio s = g.getSessions().get(j);
                horari.add_sessio(s);
            }
        }
    }

    public void crear_aula(String nom, int capacitat, TipusAula tipus) throws Exception {
        Aula aux = new Aula(nom, capacitat, tipus);
        guardar_aula(nom, capacitat, String.valueOf(tipus));
        aules.add(aux);
        crear_classes(aux);
    }

    public void crear_restriccions(ArrayList<Restriccio> R) {
        horari.setRestriccions(R);
    }


//GENERACIO HORARI

    public void generar_horari() {
        horari.generar_horari();
        guardar_horari();
    }

    public void print_horari() {
        horari.printHorari();
    }


//GUARDAR

    public void guardar_aula(String nom, int capacitat, String tipus) {
        pers.guardar_aula(nom, capacitat, tipus);
    }
    public void guardar_assignatura(String nomPlaEstudis, String nom, String fase, int capacitatGrup, int capacitatSubGrups, int matriculats, String tipusSubgrup, int numSessions, int duracio, Vector<String> correquisits) {
        pers.guardar_assignatura(nomPlaEstudis,nom,fase,capacitatGrup,capacitatSubGrups,matriculats,tipusSubgrup,numSessions,duracio,correquisits);
    }

    public void guardar_pla(String nom, int horaIni, int horaFi) {
        pers.guardar_pla(nom,horaIni,horaFi);
    }

    public void guardar_horari() {
        if(horari.getPle() != false) pers.guardar_horari(horari,pla.getNom());
    }


//CARREGAR INDIVUDUAL

    public void carregar_aula(String nom) throws Exception {
        Aula a = pers.carregar_aula(nom,true);
        aules.add(a);
        crear_classes(a);
    }

    public void carregar_all_aules() throws Exception {
        ArrayList<Aula> aux = pers.carregar_all_aules();
        for(Aula a:aux) {
            aules.add(a);
            crear_classes(a);
        }
    }

    public void carregar_assignatura(String nom) throws Exception {
        Assignatura a = pers.carregar_assignatura(nom,pla.getNom(),true);
        pla.addAssignatura(a);

    }

    public void carregar_pla(String nom) throws Exception {
        PlaEstudis p = pers.carregar_pla(nom);
        pla = p;
        hores.clear();
        for(int i = pla.getPeriodeLectiu()[0]; i < pla.getPeriodeLectiu()[1];++i) {
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
        for(int k = 0; k < pla.getAssignatures().size(); ++k) {
            Assignatura aux = pla.getAssignatures().get(k);
            for (int i = 0; i < aux.getGrups().size(); ++i) {
                Grup g = aux.getGrups().get(i);
                for (int j = 0; j < g.getSessions().size(); ++j) {
                    Sessio s = g.getSessions().get(j);
                    horari.add_sessio(s);
                }
            }
        }
    }

    public void carregar_horari(String nom) {}

//AUXILIARS

    public void crear_classes(Aula a) {
        if (hores.size() > 0) {
            for (int i = 0; i < hores.size(); ++i) {
                Classe c = new Classe(a, hores.get(i));
                horari.add_classe(c);
            }
        }

    }
}
