package domini;

import domini.Aula;
import domini.Horari;
import persistencia.CtrlPersistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class CtrlDominio {

    private Horari horari;
    private PlaEstudis pla;
    private ArrayList<DiaHora> hores;
    private ArrayList<Aula> aules;
    private Vector<Classe> classes;
    private ArrayList<Sessio> sessions;
    private ArrayList<String> nom_plans;
    private CtrlPersistencia pers;
    //CtrlPresentacio

    public CtrlDominio() throws Exception {
        this.horari = new Horari("Horari");
        this.hores = new ArrayList<DiaHora>();
        this.pers = new CtrlPersistencia();
        this.aules = new ArrayList<>();
        this.classes = new Vector<>();
        this.sessions = new ArrayList<>();
        this.nom_plans = pers.carregar_all_noms_plans();
      // carregar_all_aules();
    }


//GETTERS
    public PlaEstudis getPla() {
        return pla;
    }

    public Horari getHorari() {
        return horari;
    }

    public ArrayList<Aula> getaules() { return aules; }

    public ArrayList<ArrayList<String>> getAules() {
        ArrayList<ArrayList<String> > result = new ArrayList<>();
        for (Aula a : aules) {
            ArrayList<String> aux = new ArrayList<>();
            aux.addAll(Arrays.asList(a.getNom(), String.valueOf(a.getCapacitat()), String.valueOf(a.getTipus())));
            result.add(aux);
        }
        return result;
    }

    public ArrayList<String> getNom_plans() { return nom_plans;}

    public Vector<Classe> getclasses() { return classes;}

    public ArrayList<Sessio> getsessions() {return sessions;}


//CREADORES INDIVIDUALS

    public boolean afegirPlaEstudis(String nom, String horaIni, String horaFi) {           //OK
      //  if(nom_plans.contains(nom)) return true;
      //  else {
            int horai = Integer.valueOf(horaIni);
            int horaf = Integer.valueOf(horaFi);
            int[] periode = new int[]{horai, horaf};
            pla = new PlaEstudis(nom, periode);
            guardar_pla(nom, horai, horaf);
            hores.clear();
            sessions.clear();
            classes.clear();
            for (int i = horai; i < horaf; ++i) {
                DiaHora aux = new DiaHora("Dilluns", i);
                hores.add(aux);
                crear_classes_per_hora(aux);
                aux = new DiaHora("Dimarts", i);
                hores.add(aux);
                crear_classes_per_hora(aux);
                aux = new DiaHora("Dimecres", i);
                hores.add(aux);
                crear_classes_per_hora(aux);
                aux = new DiaHora("Dijous", i);
                hores.add(aux);
                crear_classes_per_hora(aux);
                aux = new DiaHora("Divendres", i);
                hores.add(aux);
                crear_classes_per_hora(aux);
            }
            return false;
      //  }
    }

    public int afegirAssignatura(String nomPla, String nom, String fase, String capG, String capSG, String mat, String tip, String nSes, String d, Vector<String> correquisits) throws Exception {      //OK
       // if(!nomPla.equals(pla.getNom())) return 1;      //Si el pla actiu no es el mateix en el que volem introduir la assignatura
       // if(pla.getAssignatures().contains(nom)) return 2;       //L'assignatura ja existeix en el pla
       // else {
            int capGrup = Integer.valueOf(capG);
            int capSGrup = Integer.valueOf(capSG);
            int matric = Integer.valueOf(mat);
            TipusAula tipus = TipusAula.stoTipusAula(tip);
            int numSes = Integer.valueOf(nSes);
            int dur = Integer.valueOf(d);
            Assignatura aux = new Assignatura(pla.getNom(), nom, fase, capGrup, capSGrup, matric, tipus, numSes, dur);
            int mida = correquisits.size();
            for (int i = 0; i < mida; ++i) {
                aux.afegirCorrequisit(correquisits.get(i));
            }
            pla.addAssignatura(aux);
            guardar_assignatura(pla.getNom(), nom, fase, capGrup, capSGrup, matric, String.valueOf(tipus), numSes, dur, correquisits);
            crear_sessions(aux);
            return 0;               //correcte
      //  }
    }

    public boolean afegirAula(String nom, String capacitat, String  tipus) throws Exception {
        if(aules.contains(nom)) return true;
        else {
            Aula aux = new Aula(nom, Integer.valueOf(capacitat), TipusAula.stoTipusAula(tipus));
            guardar_aula(nom, Integer.valueOf(capacitat), tipus);
            aules.add(aux);
            crear_classes_per_aula(aux);
            return false;
        }
    }

    public void crear_restriccions(Restriccio R) {
        horari.add_restriccio(R);
    }


//GENERACIO HORARI

    public void generar_horari() {
        horari.setClasses(classes);
        horari.setSessions(sessions);
        horari.generar_horari();
        guardar_horari();
        horari.printHorari();
    }

    public void print_horari() {
        horari.printHorari();
    }



//BORRAR

    public boolean esborrarAula(String nomAula) {
        boolean correct = true;
        for(int i = 0; i < aules.size() && correct;++i) {
            if(aules.get(i).getNom().equals(nomAula)) {
                correct = false;
                if(!pers.borrar_aula(nomAula)) return true;
                aules.remove(i);
                for(int j = 0; j < classes.size();++j) {
                    if(classes.get(j).getNomAulaClasse().equals(nomAula)) {
                        classes.removeElementAt(j);
                        --j;
                    }
                }
            }
        }
        return correct;

    }
//eliminar assig()
//eliminar horari();
//eliminar_pla();




//GUARDAR               //OK

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


//CARREGAR

    public void carregar_aula(String nom) throws Exception {                                    //OK
        ArrayList<String> dades = pers.carregar_aula(nom,true);
        Aula a = new Aula(dades.get(0),Integer.valueOf(dades.get(1)),TipusAula.stoTipusAula(dades.get(2)));
        aules.add(a);
        crear_classes_per_aula(a);
    }

    public void carregar_all_aules() throws Exception {                                //OK     //Cal fer-la nomes començar pero primer s ha de carregar pla sino no tira
        ArrayList<ArrayList<String> > aux = pers.carregar_all_aules();
        for(ArrayList<String> s: aux) {
            Aula a = new Aula(s.get(0),Integer.valueOf(s.get(1)),TipusAula.stoTipusAula(s.get(2)));
            aules.add(a);
            crear_classes_per_aula(a);
        }
    }

    public void carregar_assignatura(String nom) throws Exception {         //OK
        //OK
        if(!pla.getAssignatures().contains(nom)) {
            ArrayList<String> dades = pers.carregar_assignatura(nom, pla.getNom(), true);
            Assignatura a = new Assignatura(dades.get(0), dades.get(1), dades.get(2), Integer.valueOf(dades.get(3)), Integer.valueOf(dades.get(4)), Integer.valueOf(dades.get(5)), TipusAula.stoTipusAula(dades.get(6)), Integer.valueOf(dades.get(7)), Integer.valueOf(dades.get(8)));
            for (int i = 0; i < Integer.valueOf(dades.get(9)); ++i) {
                a.afegirCorrequisit(dades.get(i + 10));
            }
            pla.addAssignatura(a);
            crear_sessions(a);
        }
    }

    public void carregar_pla(String nom) throws Exception {                 //OK
        ArrayList<ArrayList<String> > dades = pers.carregar_pla(nom);
        int[] periode = {Integer.valueOf(dades.get(0).get(1)),Integer.valueOf(dades.get(0).get(2))};
        PlaEstudis p = new PlaEstudis(dades.get(0).get(0),periode);
        pla = p;
        sessions.clear();
        for(int k = 1; k < dades.size(); ++k) {
            carregar_assignatura(dades.get(k).get(1));
        }
        pla = p;
        hores.clear();
       // classes.clear();
        for(int i = pla.getPeriodeLectiu()[0]; i < pla.getPeriodeLectiu()[1];++i) {
            DiaHora aux = new DiaHora("Dilluns",i);
            hores.add(aux);
            crear_classes_per_hora(aux);
            aux = new DiaHora("Dimarts",i);
            hores.add(aux);
            crear_classes_per_hora(aux);
            aux = new DiaHora("Dimecres",i);
            hores.add(aux);
            crear_classes_per_hora(aux);
            aux = new DiaHora("Dijous",i);
            hores.add(aux);
            crear_classes_per_hora(aux);
            aux = new DiaHora("Divendres",i);
            hores.add(aux);
            crear_classes_per_hora(aux);
        }
    }

    public void carregar_horari(String nom) {



    }

//AUXILIARS

    public void crear_sessions(Assignatura a) {
        for (int i = 0; i < a.getGrups().size(); ++i) {
            Grup g = a.getGrups().get(i);
            for (int j = 0; j < g.getSessions().size(); ++j) {
                Sessio s = g.getSessions().get(j);
                sessions.add(s);
            }
        }
    }

    public void crear_classes_per_hora(DiaHora d) {         //OK
        if (aules.size() > 0) {
            for (int i = 0; i < aules.size(); ++i) {
                Classe c = new Classe(aules.get(i), d);
                classes.add(c);
            }
        }
    }

    public void crear_classes_per_aula(Aula a) {         //OK
        if (hores.size() > 0) {
            for (int i = 0; i < hores.size(); ++i) {
                Classe c = new Classe(a, hores.get(i));
                classes.add(c);
            }
        }
    }

   /*


    void esborrarAula(String nomAula) {
        System.out.println("Aula: "+nomAula+" eliminada correctament");
    }


    ArrayList<ArrayList<String>> getPlaEstudis(){
        ArrayList<String> a= new ArrayList<String>();
        a.add("INFO");
        a.add("8:00");
        a.add("21:00");
        ArrayList<String> b= new ArrayList<String>();
        b.add("ADE");
        b.add("10:30");
        b.add("13:30");
        ArrayList<ArrayList<String>> c = new ArrayList<ArrayList<String>>();
        c.add(a);
        c.add(b);
        return c;
    }

    Boolean afegirPlaEstudis(String nomPlaEstudis, String horaInici, String horaFinal) {
        return false;
    }

    void esborrarPlaEstudis(String nomPlaEstudis) {
        System.out.println("PlaEstudis: "+nomPlaEstudis+" eliminat correctament");
    }

    ArrayList<ArrayList<String>> getAssignatures(String nomPlaEstudis) {
        //retorna les assignatures d'un pla d'estudis indicat
        ArrayList<String> a= new ArrayList<String>();
        a.add("FM");
        a.add("INICIAL");
        a.add("60");
        a.add("20");
        a.add("120");
        a.add("PROBLEMES");
        a.add("2");
        a.add("2");

        ArrayList<String> b= new ArrayList<String>();
        b.add("ER");
        b.add("SOFTWARE");
        b.add("50");
        b.add("20");
        b.add("130");
        b.add("LABORATORI");
        b.add("2");
        b.add("2");

        ArrayList<ArrayList<String>> c = new ArrayList<ArrayList<String>>();
        c.add(a);
        c.add(b);
        return c;
    }

    void esborrarAssignatura(String nomAssignatura, String nomPlaEstudis) {
        //esborra l'assignatura indicada del pla d'estudis indicat
        System.out.println("Assignatura: "+nomAssignatura+" ("+ nomPlaEstudis+")" +" eliminada correctament");
    }

    Boolean afegirAssignatura(String nomAssignatura, String fase, String capacitatGrup, String capacitatSubGrup, String matriculats, String tipusSubGrup, String numSessions, String duracio, String nomPlaEstudis) {
        //retorna true si l'assignatura ja existeix o algun dels valors introduits son incorrectes
        return false;
    }

    ArrayList<ArrayList<String>> getCorrequisitsAssignatura(String nomAssignatura, String nomPlaEstudis) {
        ArrayList<String> a= new ArrayList<String>();
        a.add("M1");
        a.add("SEGONCURS");
        a.add("60");
        a.add("20");
        a.add("120");
        a.add("PROBLEMES");
        a.add("2");
        a.add("2");

        ArrayList<String> b= new ArrayList<String>();
        b.add("M2");
        b.add("SOFTWARE");
        b.add("50");
        b.add("20");
        b.add("130");
        b.add("LABORATORI");
        b.add("2");
        b.add("2");

        ArrayList<ArrayList<String>> c = new ArrayList<ArrayList<String>>();
        c.add(a);
        c.add(b);
        return c;
    }

    Boolean afegirCorrequisit(String nomAssignaturaEscollida, String nomAssignaturaActual, String nomPlaEstudis) {
        //retorna si les assignatures son correquisits entre elles
        //si no ho son, crea les associacions perque ho siguin
        //tb comprova que no sigui correquisit de si mateixa i coses aixi
        return false;
    }

    void esborrarAssignatura(String nomAssignaturaEscollida, String nomAssignaturaActual, String nomPlaEstudis) {
        //s'esborra el la relacio de correquits en els dos sentits
        System.out.println("Correquisit entre: "+nomAssignaturaEscollida+" i "+nomAssignaturaActual+" eliminat correctament");
    }
    */
}
