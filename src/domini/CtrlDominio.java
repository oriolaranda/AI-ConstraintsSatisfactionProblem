package domini;

import domini.Aula;
import domini.Horari;
import persistencia.CtrlPersistencia;

import java.util.*;

public class CtrlDominio {

    private Horari horari;
    private PlaEstudis pla;
    private ArrayList<DiaHora> hores;
    private ArrayList<Aula> aules;
    private Vector<Classe> classes;
    private ArrayList<Sessio> sessions;
    private ArrayList<ArrayList<String>> info_plans;
    private CtrlPersistencia pers;
    //private CtrlPresentacio pres;

    public CtrlDominio() throws Exception {
        this.horari = new Horari("Horari");
        this.hores = new ArrayList<>();
        this.pers = new CtrlPersistencia();
        this.aules = new ArrayList<>();
        this.classes = new Vector<>();                                      //Classes actives
        this.sessions = new ArrayList<>();                                  //Sessions actives
        this.info_plans = pers.carregar_all_plans();
        carregar_all_aules();
      //  carregar_pla("FIB");
    }


//GETTERS
    public PlaEstudis getPla() { return pla; }

    public Horari getHorari() {
        return horari;
    }

    //public ArrayList<Aula> getaules() { return aules; }

    public ArrayList<ArrayList<String>> getAules() {                                //OK
        ArrayList<ArrayList<String> > result = new ArrayList<>();
        for (Aula a : aules) {
            ArrayList<String> aux = new ArrayList<>();
            aux.addAll(Arrays.asList(a.getNom(), String.valueOf(a.getCapacitat()), String.valueOf(a.getTipus())));
            result.add(aux);
        }
        return result;
    }
/*
    public ArrayList<String> getPlaEstudis(){               //Retornara les dades del pla estudis actiu

        ArrayList<String> c = new ArrayList<>();
        c.add(pla.getNom());
        c.add(String.valueOf(pla.getPeriodeLectiu()[0]));
        c.add(String.valueOf(pla.getPeriodeLectiu()[1]));
        return c;
    }
*/

    public Assignatura getAssignatura(String nom) {
        Assignatura aux = new Assignatura();
        for(Assignatura as: pla.getAssignatures()) {
            if(as.getNom().equals(nom)) aux = as;
        }
        return aux;
    }

    public ArrayList<ArrayList<String>> getAssignatures(String nomPlaEstudis) {             //OK

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

    public ArrayList<ArrayList<String>> getCorrequisitsAssignatura(String nomAssig, String nomPla) {
        Assignatura aux = getAssignatura(nomAssig);
        ArrayList<String> co = aux.getCorrequisits();
        ArrayList<ArrayList<String>> c = new ArrayList<>();
        for(String s: co) {
            Assignatura aux2 = getAssignatura(s);
            ArrayList<String> a = new ArrayList<>();
            a.add(aux2.getNom());
            a.add(aux2.getFase());
            a.add(String.valueOf(aux2.getCapacitatGrup()));
            a.add(String.valueOf(aux2.getCapacitatSubgrup()));
            a.add(String.valueOf(aux2.getMatriculats()));
            a.add(String.valueOf(aux2.getTupusAulaSubgrup()));
            a.add(String.valueOf(aux2.getNumSessions()));
            a.add(String.valueOf(aux2.getDuracio()));
            c.add(a);
            }
        return c;
    }

    public ArrayList<String> getHorarisPlaEstudis(String nomPla) throws Exception {
        ArrayList<String> aux = pers.carregar_noms_horaris(nomPla);
        return aux;
    }

    public ArrayList<ArrayList<String>> getAll_plans() { return info_plans;}
/*
    public Vector<Classe> getclasses() { return classes;}

    public ArrayList<Sessio> getsessions() {return sessions;}
*/
    public ArrayList<String> getHores(String nomPla) {
        ArrayList<String> hores = new ArrayList<>();
        for(int i = pla.getPeriodeLectiu()[0]; i < pla.getPeriodeLectiu()[1];++i) {
          hores.add(String.valueOf(i));
        }
        return hores;
    }

    public String getSessio(String dia, String hora, String nomAula, String capacitat, String tipus, String nomHorari, String nomPlaEstudis) throws Exception {
        Aula aula = new Aula(nomAula, Integer.valueOf(capacitat),TipusAula.stoTipusAula(tipus));
        DiaHora dh = new DiaHora(dia,Integer.valueOf(hora));

        if(aula == null | dh == null) return "";
        Classe c = new Classe(aula, dh);
        if (c==null) return "";
        if (horari.getNou().containsKey(c)) return horari.getNou().get(c).toString();
        return "";
    }



//CREADORES

    public boolean afegirPlaEstudis(String nom, String horaIni, String horaFi) {           //OK
      for(ArrayList<String> s: info_plans) {
          if(s.get(0).equals(nom)) return true;
      }
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
    }

    public boolean afegirAssignatura(String nomPla, String nom, String fase, String capG, String capSG, String mat, String tip, String nSes, String d) throws Exception {      //OK
        if(!nomPla.equals(pla.getNom())) return true;      //Si el pla actiu no es el mateix en el que volem introduir la assignatura
        for(Assignatura a: pla.getAssignatures()) {
            if(a.getNom().equals(nom)) return true; //Ja existeix una assignatura amb aquest nom
        }
        int capGrup = Integer.valueOf(capG);
        int capSGrup = Integer.valueOf(capSG);
        int matric = Integer.valueOf(mat);
        TipusAula tipus = TipusAula.stoTipusAula(tip);
        int numSes = Integer.valueOf(nSes);
        int dur = Integer.valueOf(d);
        Assignatura aux = new Assignatura(pla.getNom(), nom, fase, capGrup, capSGrup, matric, tipus, numSes, dur);
        ArrayList<String> correquisits = new ArrayList<>();
        pla.addAssignatura(aux);
        guardar_assignatura(pla.getNom(), nom, fase, capGrup, capSGrup, matric, String.valueOf(tipus), numSes, dur, correquisits);
        crear_sessions(aux);
        return false;               //correcte
    }

    public boolean afegirCorrequisit(String Escollida, String Actual, String nomPla) {
        Assignatura aux = getAssignatura(Actual);
        if(aux.getCorrequisits().contains(Escollida)) return true;
        aux.afegirCorrequisit(Escollida);
        guardar_assignatura(pla.getNom(),aux.getNom(),aux.getFase(),aux.getCapacitatGrup(),aux.getCapacitatSubgrup(),aux.getMatriculats(),String.valueOf(aux.getTupusAulaSubgrup()),aux.getNumSessions(),aux.getDuracio(),aux.getCorrequisits());
        return false;
    }

    public boolean afegirAula(String nom, String capacitat, String  tipus) throws Exception {       //OK
        for( Aula a:aules) {
            if (a.getNom().equals(nom)) return true;
        }
        Aula aux = new Aula(nom, Integer.valueOf(capacitat), TipusAula.stoTipusAula(tipus));
        guardar_aula(nom, Integer.valueOf(capacitat), tipus);
        aules.add(aux);
        crear_classes_per_aula(aux);
        return false;
    }
/*
    public void crear_restriccions(Restriccio R) {
        horari.add_restriccio(R);
    }
*/

//GENERACIO HORARI

    public boolean crearHorari(String nomHorari, Boolean restriccioCapacitat, Boolean restriccioCorrequisit, Boolean restriccioFase, Boolean restriccioTipusAula, ArrayList<ArrayList<String>> restriccions,String nomPlaEstudis) throws Exception {                              //omple horari amb les classes i les sessions actives i genera
//        if(nom_horaris_pla.contains(nomHorari)) return true;
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
        return false;
    }
/*
    public void print_horari() {
        horari.printHorari();
    }
*/
//MODIFICAR

   public boolean modificarAula(String nomAulaAntic,String nomAula,String capacitat,String tipus) throws Exception { //OK

       for (Aula aula: aules) {
           if(aula.getNom().equals(nomAulaAntic)) {
               if(!nomAulaAntic.equals(nomAula)) {
                   for (Aula a: aules) {
                       if(a.getNom().equals(nomAula)) return false; //comprovar que no hi ha aula amb el mateix nom nou.
                   }
               }
               esborrarAula(nomAulaAntic);
               afegirAula(nomAula,capacitat,tipus);
               guardar_aula(nomAula,Integer.valueOf(capacitat),tipus);
               return true;
           }
       }

       //Si aula antiga no extisteix en aules retornes false
       //Modificar el vector aules
        //Modificar el vector de classes segons Aula modificada
       //Cridar guardar_aula(nom, Integer.valueOf(capacitat), tipus) amb parametres nous
       return false;
   }
    //REVISAR!!!!!!!!!!!!!!
   public boolean modificarPlaEstudis( String nomPlaEstudisAntic,String nomPlaEstudis,String horaInici,String horaFinal) throws Exception {

       //Si nomantic no esta en info_plans return false
       //Modificar variable pla si el nom del pla que modifiques es el mateix del que tenim actiu
       //Modificar el vector hores on hi ha els dies i hores actius pel pla
       //Modificar classes segons si canvien les hores del pla en que estem
       //guardar_pla(nom, horai, horaf);
       if (pla == null || !pla.getNom().equals(nomPlaEstudisAntic)) {

           for (ArrayList<String> pla : info_plans) {
               if (pla.get(0).equals(nomPlaEstudisAntic)) {
                   if (!nomPlaEstudisAntic.equals(nomPlaEstudis)) {
                       for (ArrayList<String> s: info_plans) {
                           if(s.get(0).equals(nomPlaEstudis)) return false;
                       }
                   }
                   esborrarPlaEstudis(nomPlaEstudisAntic);
                   afegirPlaEstudis(nomPlaEstudis,horaInici,horaFinal);
                   guardar_pla(nomPlaEstudis,Integer.valueOf(horaInici),Integer.valueOf(horaFinal));
                   info_plans = pers.carregar_all_plans();
                   return true;
               }
           }
           return false;
       } else {
           if(!nomPlaEstudisAntic.equals(nomPlaEstudis)) {
               for (ArrayList<String> s: info_plans) {
                   if(s.get(0).equals(nomPlaEstudis)) return false;
               }
               pla.setNom(nomPlaEstudis);
               pers.borrar_pla(nomPlaEstudisAntic);
           }
           pla.setPeriodeLectiu(Integer.valueOf(horaInici),Integer.valueOf(horaFinal));
           guardar_pla(nomPlaEstudis,Integer.valueOf(horaInici),Integer.valueOf(horaFinal));
       }
       info_plans = pers.carregar_all_plans();      //Deixa aquesta linia i si la toques no la posis abans de guardar
       return true;
   }
   //OK
   public boolean modificarAssignatura(String nomAssignaturaAntic,String nomAssignatura,String fase,String capacitatGrup,String capacitatSubGrup,String matriculats,String tipusSubGrup,String numSessions,String duracio) throws Exception { //OK
        for (Assignatura assig: pla.getAssignatures()) {
            if(assig.getNom().equals(nomAssignaturaAntic)) {
                if(!nomAssignaturaAntic.equals(nomAssignatura)) {
                    for (Assignatura as: pla.getAssignatures()) {
                        if(as.getNom().equals(nomAssignatura)) return false; //comprovar que no hi ha assig amb mateix nom nou
                    }
                }
                esborrarAssignatura(nomAssignaturaAntic,pla.getNom());
                afegirAssignatura(pla.getNom(),nomAssignatura,fase,capacitatGrup,capacitatSubGrup, matriculats,tipusSubGrup,numSessions,duracio);
                guardar_assignatura(pla.getNom(),nomAssignatura,fase,Integer.valueOf(capacitatGrup),Integer.valueOf(capacitatSubGrup),Integer.valueOf(matriculats),tipusSubGrup,Integer.valueOf(numSessions),Integer.valueOf(duracio),assig.getCorrequisits());
                return true;
            }
        }
       //Si nom antic no esta en les assigs del pla return false
       //Modificar sessions segons els canvis
       //guardar_assignatura(pla.getNom(), nom, fase, capGrup, capSGrup, matric, String.valueOf(tipus), numSes, dur, correquisits);    el vector correquisits posa el mateix vector que hi havia, ja que no es modifca aqui
       return false;
   }

    public boolean intercanviar(String dia1,String  hora1,String  nomAula1,String  dia2,String  hora2,String  nomAula2) { //OK
        //Modificar horari pero no se la dif entre els 2 intercanviars
        Map<Classe,Sessio> h = horari.getNou();
        DiaHora d1 = new DiaHora(dia1,Integer.valueOf(hora1));
        DiaHora d2 = new DiaHora(dia2,Integer.valueOf(hora2));
        Aula a1 = null;
        Aula a2 = null;
        for (Aula a: aules) {
            if(a.getNom().equals(nomAula1)) a1 = a;
            if (a.getNom().equals(nomAula2)) a2 = a;
        }
        if(a1 == null || a2 == null) return false;
        Classe c1 = new Classe(a1,d1);
        Classe c2 = new Classe(a2,d2);
        if(!h.containsKey(c1) || !h.containsKey(c2)) return false;
        Sessio s1 = h.get(c1);
        Sessio s2 = h.get(c2);
        ArrayList<Restriccio> restriccions = horari.getRestriccions();
        h.put(c1,s2);
        h.put(c2,s1);
        if (restriccions != null) {
            for (Restriccio r : restriccions) {
                boolean b = r.esCompleix(h, c1, s2);
                boolean c = r.esCompleix(h, c2,s1);
                if (!b || !c) {
                    h.put(c1,s1);
                    h.put(c2,s2);
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public void intercanviarObligat(String dia1,String  hora1,String  nomAula1,String  dia2,String  hora2,String  nomAula2) { //OK
        Map<Classe,Sessio> h = horari.getNou();
        DiaHora d1 = new DiaHora(dia1,Integer.valueOf(hora1));
        DiaHora d2 = new DiaHora(dia2,Integer.valueOf(hora2));
        Aula a1 = null;
        Aula a2 = null;
        for (Aula a: aules) {
            if(a.getNom().equals(nomAula1)) a1 = a;
            if (a.getNom().equals(nomAula2)) a2 = a;
        }
        if(a1 != null && a2 != null) {
            Classe c1 = new Classe(a1, d1);
            Classe c2 = new Classe(a2, d2);
           if ( h.containsKey(c1) && h.containsKey(c2)) {
                Sessio s1 = h.get(c1);
                Sessio s2 = h.get(c2);
                h.put(c1, s2);
                h.put(c2, s1);

           }
        }
    }

//BORRAR

    public boolean esborrarAula(String nomAula) {                       //OK
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
        for(int i = 0; i < info_plans.size(); ++i) {
            if (info_plans.get(i).get(0).equals(nomPlaEstudis)) {
                if (!pers.borrar_pla(nomPlaEstudis)) return false;
                info_plans.remove(i);
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

    public boolean esborrarAssignatura(String nomAssignatura, String nomPla) { //OK

        boolean correct = false;
        for(int i = 0; i < pla.getAssignatures().size() && !correct;++i) {
            if(pla.getAssignatures().get(i).getNom().equals(nomAssignatura)) {
                if(!pers.borrar_assignatura(nomAssignatura,pla.getNom())) return false;
                pla.getAssignatures().remove(i);
                for(int j = 0; j < sessions.size(); ++j) {
                    Sessio s = sessions.get(j);
                    if(s.getNomAssignaturaSessio().equals(nomAssignatura)) {
                        sessions.remove(j);
                        --j;
                    }
                }
                correct = true;
            }
        }
        return correct;
    }


    public void esborrarCorrequisit(String Escollida, String Actual, String nomPla) {
        Assignatura aux = getAssignatura(Actual);
        if (aux.getCorrequisits().contains(Escollida)) {
            aux.eliminarCorrequisit(Escollida);
            System.out.println("vaig a esborrar");
            guardar_assignatura(pla.getNom(), aux.getNom(), aux.getFase(), aux.getCapacitatGrup(), aux.getCapacitatSubgrup(), aux.getMatriculats(), String.valueOf(aux.getTupusAulaSubgrup()), aux.getNumSessions(), aux.getDuracio(), aux.getCorrequisits());
            System.out.println("borrat");
        }
    }
    public boolean esborrarHorari(String nomHorari,String nomPlaEstudis) {
        boolean correct = false;
        if(!pers.borrar_horari(nomHorari,nomPlaEstudis)) return false;
        return correct;
    }



//GUARDAR               //OK

    public void guardar_aula(String nom, int capacitat, String tipus) {
        pers.guardar_aula(nom, capacitat, tipus);
    }
    public void guardar_assignatura(String nomPlaEstudis, String nom, String fase, int capacitatGrup, int capacitatSubGrups, int matriculats, String tipusSubgrup, int numSessions, int duracio, ArrayList<String> correquisits) {
        pers.guardar_assignatura(nomPlaEstudis,nom,fase,capacitatGrup,capacitatSubGrups,matriculats,tipusSubgrup,numSessions,duracio,correquisits);
    }

    public void guardar_pla(String nom, int horaIni, int horaFi) {
        pers.guardar_pla(nom,horaIni,horaFi);
    }

    public void guardar_horari() throws Exception {
        if (horari.getPle() != false) {
            ArrayList<ArrayList<String>> p = new ArrayList<>();
            ArrayList<String> aux = new ArrayList<>();
            aux.add(horari.getNom());
            aux.add(pla.getNom());
            aux.add(String.valueOf(horari.getRestriccions().size()));
            aux.add(String.valueOf(pla.getAssignatures().size()));
            aux.add(String.valueOf(horari.getNou().size()));
            p.add(aux);
            ArrayList<String> aux2 = new ArrayList<>();
            for (Restriccio r : horari.getRestriccions()) {
                if (r instanceof RestriccioFase) aux2.add("RF");
                if (r instanceof RestriccioCorrequisit) aux2.add("RC");
                if (r instanceof RestriccioTipusAula) aux2.add("RT");
                if (r instanceof RestriccioCapacitat) aux2.add("RCP");
                if (r instanceof RestriccioClasse) {
                    aux2.add("RCL");
                    aux2.add(((RestriccioClasse) r).getId());
                    aux2.add(((RestriccioClasse) r).getNomAula());
                    aux2.add(((RestriccioClasse) r).getDia());
                    aux2.add(String.valueOf(((RestriccioClasse) r).getHora()));
                }
                if (r instanceof RestriccioGrupDiaHora) {
                    aux2.add("RG");
                    aux2.add(((RestriccioGrupDiaHora) r).getId());
                    aux2.add(((RestriccioGrupDiaHora) r).getNomAssignatura());
                    aux2.add(String.valueOf(((RestriccioGrupDiaHora) r).getNumGrup()));
                    aux2.add(((RestriccioGrupDiaHora) r).getDia());
                    aux2.add(String.valueOf(((RestriccioGrupDiaHora) r).getHora()));
                }
            }
            p.add(aux2);
            for (Assignatura a : pla.getAssignatures()) {
                ArrayList<String> aux3 = new ArrayList<>();
                aux3.add(a.getNom());
                aux3.add(a.getFase());
                aux3.add(String.valueOf(a.getCapacitatGrup()));
                aux3.add(String.valueOf(a.getCapacitatSubgrup()));
                aux3.add(String.valueOf(a.getMatriculats()));
                aux3.add(String.valueOf(a.getTupusAulaSubgrup()));
                aux3.add(String.valueOf(a.getNumSessions()));
                aux3.add(String.valueOf(a.getDuracio()));
                aux3.add(String.valueOf(a.getCorrequisits().size()));
                for (int i = 0; i < a.getCorrequisits().size(); ++i) {
                    aux3.add(a.getCorrequisits().get(i));
                }
                p.add(aux3);
            }
            for (Map.Entry<Classe, Sessio> entry : horari.getNou().entrySet()) {
                ArrayList<String> aux4 = new ArrayList<>();
                aux4.add(entry.getKey().getAula().getNom());
                aux4.add(String.valueOf(entry.getKey().getAula().getCapacitat()));
                aux4.add(String.valueOf(entry.getKey().getAula().getTipus()));
                aux4.add(entry.getKey().getDiaClasse());
                aux4.add(String.valueOf(entry.getKey().getHoraClasse()));
                aux4.add(entry.getValue().getId());
                aux4.add(String.valueOf(entry.getValue().getNum()));
                p.add(aux4);
            }
            pers.guardar_horari(p);
            }
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
        ArrayList<String> h = getHorarisPlaEstudis(nom);
        for(int j = 0; j < h.size();++j) {
            carregar_horari(h.get(j));
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

    public void carregar_horari(String nom) throws Exception {                          //OK
        Horari nou = new Horari("");
        ArrayList<ArrayList<String> > dades = pers.carregar_horari(nom,pla.getNom(),true);
        ArrayList<String> aux = dades.get(0);
        nou.setNom(aux.get(0));
        nou.setNomPla(aux.get(1));
        int res = Integer.valueOf(aux.get(2));
        int as = Integer.valueOf(aux.get(3));
        int cl = Integer.valueOf(aux.get(4));
        for(int i = 1; i < res+1; ++i) {
            ArrayList<String> aux2 = dades.get(i);
            if(aux2.get(0).equals("RF")) {
                RestriccioFase r = new RestriccioFase();
                nou.add_restriccio(r);
            }
            if(aux2.get(0).equals("RC")) {
                RestriccioCorrequisit r = new RestriccioCorrequisit();
                nou.add_restriccio(r);
            }
            if(aux2.get(0).equals("RCP")) {
                RestriccioCapacitat r = new RestriccioCapacitat();
                nou.add_restriccio(r);
            }
            if(aux2.get(0).equals("RT")) {
                RestriccioTipusAula r = new RestriccioTipusAula();
                nou.add_restriccio(r);
            }
            if(aux2.get(0).equals("RG")) {
                RestriccioGrupDiaHora r = new RestriccioGrupDiaHora(aux2.get(1),aux2.get(2),Integer.valueOf(aux2.get(3)),aux2.get(4),Integer.valueOf(aux2.get(5)));
                nou.add_restriccio(r);
            }
            if(aux2.get(0).equals("RCL")) {
                RestriccioClasse r = new RestriccioClasse(aux2.get(1),aux2.get(2),aux2.get(3),Integer.valueOf(aux2.get(4)));
                nou.add_restriccio(r);
            }
        }
        for(int i = 1 + res; i < as + res + 1; ++i) {
            ArrayList<String> aux3 = dades.get(i);
            Assignatura a = new Assignatura(pla.getNom(),aux3.get(0),aux3.get(1),Integer.valueOf(aux3.get(2)),Integer.valueOf(aux3.get(3)),Integer.valueOf(aux3.get(4)),TipusAula.stoTipusAula(aux3.get(5)),Integer.valueOf(aux3.get(6)),Integer.valueOf(aux3.get(7)));
            for (int j = 0; j < Integer.valueOf(aux3.get(8)); ++j) {
                a.afegirCorrequisit(aux3.get(j + 9));
            }
            for (int k = 0; k < a.getGrups().size(); ++k) {
                Grup g = a.getGrups().get(k);
                for (int j = 0; j < g.getSessions().size(); ++j) {
                    Sessio s = g.getSessions().get(j);
                    nou.getSessions().add(s);
                }
            }
        }
        for(int i = 1 + res + as; i < cl + 1 + res + as; ++i) {
            ArrayList<String> aux4 = dades.get(i);
            Aula a = new Aula(aux4.get(0),Integer.valueOf(aux4.get(1)),TipusAula.stoTipusAula(aux4.get(2)));
            DiaHora d = new DiaHora(aux4.get(3),Integer.valueOf(aux4.get(4)));
            Classe c = new Classe(a,d);
            nou.add_classe(c);
            String s = aux4.get(5);
            int x = Integer.valueOf(aux4.get(6));
            for(int j = 0; j < nou.getSessions().size(); ++j) {
                if (x == nou.getSessions().get(j).getNum() && s.equals(nou.getSessions().get(j).getId())) nou.getNou().put(c,nou.getSessions().get(j));
            }
        }
        horari = nou;
    }

//AUXILIARS

    public void crear_sessions(Assignatura a) {                 //OK
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
}