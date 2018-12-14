package domini;

import domini.Aula;
import domini.Horari;
import persistencia.CtrlPersistencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

public class CtrlDominio {

    private Horari horari;
    private PlaEstudis pla;
    private ArrayList<DiaHora> hores;
    private ArrayList<Aula> aules;
    private Vector<Classe> classes;
    private ArrayList<Sessio> sessions;
    private ArrayList<String> nom_plans;
   // private Vector<String> nom_horaris_pla;
    private CtrlPersistencia pers;
    //private CtrlPresentacio pres;

    public CtrlDominio() throws Exception {
        this.horari = new Horari("Horari");
        this.hores = new ArrayList<DiaHora>();
        this.pers = new CtrlPersistencia();
        this.aules = new ArrayList<>();
        this.classes = new Vector<>();                                      //Classes actives
        this.sessions = new ArrayList<>();                                  //Sessions actives
        this.nom_plans = pers.carregar_all_noms_plans();
      // this.nom_horaris_pla = pers.carregar_noms_horaris(pla.getNom());
      carregar_all_aules();
      carregar_pla("FIB");
      //  this.pres = new CtrlPresentacio();
    }


//GETTERS
    public PlaEstudis getPla() { return pla; }

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

    public ArrayList<String> getPlaEstudis(){               //Retornara les dades del pla estudis actiu

        ArrayList<String> c = new ArrayList<>();
        c.add(pla.getNom());
        c.add(String.valueOf(pla.getPeriodeLectiu()[0]));
        c.add(String.valueOf(pla.getPeriodeLectiu()[1]));
        return c;
    }

    public ArrayList<ArrayList<String>> getAssignatures(String nomPlaEstudis) {

        ArrayList<ArrayList<String>> c = new ArrayList<>();

        for(Assignatura as: pla.getAssignatures()) {

            ArrayList<String> a = new ArrayList<>();
            a.add(as.getNom());
            a.add(as.getFase());
            a.add(String.valueOf(as.getCapacitatGrup()));
            a.add(String.valueOf(as.getCapacitatSubgrup()));
            a.add(String.valueOf(as.getMatriculats()));
            a.add(String.valueOf(as.getTupusAulaSubgrup()));
            a.add(String.valueOf(as.getNumSessions()));
            a.add(String.valueOf(as.getDuracio()));
            c.add(a);
        }
        return c;
    }

    public ArrayList<String> getNom_plans() { return nom_plans;}

    public Vector<Classe> getclasses() { return classes;}

    public ArrayList<Sessio> getsessions() {return sessions;}

    public ArrayList<String> getHores() {
        ArrayList<String> hores = new ArrayList<>();
        for(int i = pla.getPeriodeLectiu()[0]; i < pla.getPeriodeLectiu()[1];++i) {
            if(i < 10) hores.add("0" + i + ":00");
            else hores.add(i + ":00");
        }
        return hores;
    }

    public String getSessio(String dia, String hora, String nomAula, String nomHorari, String nomPlaEstudis) {

        //return horari.getNou().get();
    }


//CREADORES

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

    public void crearHorari(String nomHorari, Boolean restriccioCapacitat, Boolean restriccioCorrequisit, Boolean restriccioFase, Boolean restriccioTipusAula, ArrayList<ArrayList<String>> restriccions,String nomPlaEstudis) {                              //omple horari amb les classes i les sessions actives i genera
        horari.setNom(nomHorari);
        horari.setNomPla(nomPlaEstudis);
        horari.setClasses(classes);
        horari.setSessions(sessions);
        ArrayList<Restriccio> res = new ArrayList<>();
        if(restriccioCapacitat) res.add(new RestriccioCapacitat());
        if(restriccioCorrequisit) res.add(new RestriccioCorrequisit());
        if(restriccioFase) res.add(new RestriccioFase());
        if(restriccioTipusAula) res.add(new RestriccioTipusAula());
        for(ArrayList<String> as: restriccions) {
            if (as.get(1).equals("")) res.add(new RestriccioGrupDiaHora(as.get(0), as.get(4),Integer.valueOf(as.get(5)),as.get(2),Integer.valueOf(as.get(3))));
            else res.add(new RestriccioClasse(as.get(0), as.get(1), as.get(2), Integer.valueOf(as.get(3))));
        }
        horari.setRestriccions(res);
        horari.generar_horari();
        guardar_horari();
        horari.printHorari();
    }

    public void print_horari() {
        horari.printHorari();
    }



//BORRAR

    public boolean esborrarAula(String nomAula) {
        boolean correct = false;
        for(int i = 0; i < aules.size() && !correct;++i) {
            if(aules.get(i).getNom().equals(nomAula)) {
                if(!pers.borrar_aula(nomAula)) return false;
                aules.remove(i);
                for(int j = 0; j < classes.size();++j) {
                    if(classes.get(j).getNomAulaClasse().equals(nomAula)) {
                        classes.removeElementAt(j);
                        --j;
                    }
                }
                correct = true;
            }
        }
        return correct;

    }

    public boolean esborrarPlaEstudis(String nomPlaEstudis) {
        boolean correct = false;
        for(int i = 0; i < nom_plans.size(); ++i) {
            if (nom_plans.get(i).equals(nomPlaEstudis)) {
                if (!pers.borrar_pla(nomPlaEstudis)) return false;
                System.out.println("patata");
                nom_plans.remove(i);
                /* si eliminem pla quan esta carregat
                hores.clear();
                sessions.clear();
                classes.clear();
                 */
                correct = true;
            }
        }
        return correct;
    }

    public boolean esborrarAssignatura(String nomAssignatura) {

        boolean correct = false;
        for(int i = 0; i < pla.getAssignatures().size() && !correct;++i) {
            if(pla.getAssignatures().get(i).getNom().equals(nomAssignatura)) {
                if(!pers.borrar_assignatura(nomAssignatura,pla.getNom())) return false;
                pla.getAssignatures().remove(i);
                for(Iterator<Sessio> it = sessions.iterator(); it.hasNext();) {
                    Sessio aux = it.next();
                    if(aux.getNomAssignaturaSessio().equals(nomAssignatura)) {
                        it.remove();
                    }
                }
                correct = true;
            }
        }
        return correct;
    }





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
        ArrayList<ArrayList<String> > aux = pers.carregar_all_aules()ArrayList<Restriccio> res;;
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

     ArrayList<ArrayList<String>> getCorrequisitsAssignatura(String nomAssignatura, String nomPlaEstudis) {
        ArrayList<String> a= new ArrayList<>();
        a.add("M1");
        a.add("SEGONCURS");
        a.add("60");
        a.add("20");
        a.add("120");
        a.add("PROBLEMES");
        a.add("2");
        a.add("2");

        ArrayList<String> b= new ArrayList<>();
        b.add("M2");
        b.add("SOFTWARE");
        b.add("50");
        b.add("20");
        b.add("130");
        b.add("LABORATORI");
        b.add("2");
        b.add("2");

        ArrayList<ArrayList<String>> c = new ArrayList<>();
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

    Boolean esborrarCorrequisit(String nomAssignaturaEscollida, String nomAssignaturaActual, String nomPlaEstudis) {
        //s'esborra el la relacio de correquits en els dos sentits
        System.out.println("Correquisit entre: "+nomAssignaturaEscollida+" i "+nomAssignaturaActual+" eliminat correctament");
        return true;
    }

    ArrayList<String> getHorarisPlaEstudis(String nomPlaEstudis) {
        //retorna els horaris que tenen com atribut l'string nomplaestudis indicat
        ArrayList<String> horaris = new ArrayList<>();
        horaris.add("Horari1");
        horaris.add("Horari2");
        return horaris;
    }

    Boolean esborrarHorari(String nomHorari, String nomPlaEstudis) {
        //tb esborra les seves restriccions associades i tal
        System.out.println("Horari: "+nomHorari+" ("+nomPlaEstudis+") "+"eliminat correctament");
        return true;
    }

    Boolean crearHorari(String nomHorari, Boolean restriccioCapacitat, Boolean restriccioCorrequisit, Boolean restriccioFase, Boolean restriccioTipusAula, ArrayList<ArrayList<String>> restriccions,String nomPlaEstudis) {
        //retorna true si l'horari ja existeix o alguna de les restriccions té parametres incorrectes
        //et podria passar dos vectors "restriccions" un amb les de classe i un altre amb les de grupdiahora o comprovar tu si restriccions.get(i).get(2) que es nomaula té un valor o es ""
        //crea l'horari, amb les sessions del pla d'estudis indicat (que tb associa l'string a l'horari com a atribut), totes les aules del sistema i unes restriccions que crea segons les indicades.
        return false;
    }

    String getSessio(String dia, String hora, String nomAula, String nomHorari, String nomPlaEstudis) {
        //retorna la sessio (String constituit per nomAssig+numGrup+numSessio en un String) format possible= "PROP 11 (1)"
        //la sessio es del horari del pla d'estudis indicat en la Classe indicada
        //si no hi ha sessio assignada per aquesta Classe retorna un String "";
        return "AS 11 (2)";
    }


    */
}
