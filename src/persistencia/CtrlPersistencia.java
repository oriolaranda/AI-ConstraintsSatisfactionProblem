package persistencia;

import domini.*;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


import static domini.TipusAula.stoTipusAula;

public class CtrlPersistencia {


    public CtrlPersistencia() {

    }

    public void guardar_aula(String nom, int capacitat, String tipus) {
        try {
            List<String> aula = Arrays.asList(nom + " " + String.valueOf(capacitat) + " " + tipus);
            Path file = Paths.get("src/persistencia/Aules/" + nom + ".txt");
            if(!Files.exists(file)) {
                Files.createDirectories(file.getParent());
                Files.createFile(file);
            }
            Files.write(file, aula, Charset.forName("UTF-8"));
        } catch (Exception e) {
        }
    }

    public void guardar_assignatura(String nomPlaEstudis, String nom, String fase, int capacitatGrup, int capacitatSubGrups, int matriculats, String tipusSubgrup, int numSessions, int duracio, ArrayList<String> correquisits) {
        try {
            String aux = nom + " " + fase + " " + capacitatGrup + " " + capacitatSubGrups + " " + matriculats + " " + tipusSubgrup + " " + numSessions + " " + duracio + " " + correquisits.size();
            for (int i = 0; i < correquisits.size(); ++i) {
                aux += " " + correquisits.get(i);
            }
            List<String> assig = Arrays.asList(aux);
            Path file = Paths.get("src/persistencia/PlaEstudis/" + nomPlaEstudis + "/Assignatures/" + nom + ".txt");
            if(!Files.exists(file)) {
                Files.createDirectories(file.getParent());
                Files.createFile(file);
            }
            Files.write(file, assig, Charset.forName("UTF-8"));
        } catch (Exception e) {
        }
    }

    public void guardar_pla(String nom, int horaIni, int horaFi) {
        try {
            List<String> pla = Arrays.asList(nom + " " + String.valueOf(horaIni) + " " + String.valueOf(horaFi));
            Path file = Paths.get("src/persistencia/PlaEstudis/" + nom + "/info_pla.txt");
            if(!Files.exists(file)) {
                Files.createDirectories(file.getParent());
                Files.createFile(file);
            }
            Files.write(file, pla, Charset.forName("UTF-8"));
        } catch (Exception e) {
        }
    }

    public void guardar_horari(ArrayList<ArrayList<String>> p) throws Exception {
            Path file = Paths.get("src/persistencia/PlaEstudis/" + p.get(0).get(1) + "/Horaris/" + p.get(0).get(0) + ".txt");
            if(!Files.exists(file)) {
                Files.createDirectories(file.getParent());
                Files.createFile(file);
            }
            List<String> linia = new ArrayList<>();
            for(int i = 0; i < p.size(); ++i) {
                String s = new String();
                for(int j = 0; j < p.get(i).size();++j) {
                    s += p.get(i).get(j) + " ";
                }
                linia.add(s);
                Files.write(file,linia,Charset.forName("UTF-8"));
            }
        }

  //  public Horari carregar_horari(String nomPla,String nom) {}

    public ArrayList<ArrayList<String> > carregar_pla(String nom) throws Exception {                    //OK

        Path path = Paths.get("src/persistencia/PlaEstudis/" + nom + "/info_pla.txt");
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(Files.exists(path)) {
            File f = new File(String.valueOf(path));
            Scanner sc = new Scanner(f);
            String n = sc.next();
            int[] periode = new int[]{sc.nextInt(), sc.nextInt()};
            ArrayList<String> aux = new ArrayList<String>();
            aux.addAll(Arrays.asList(n, String.valueOf(periode[0]), String.valueOf(periode[1])));
            result.add(aux);
            path = Paths.get("src/persistencia/PlaEstudis/" + nom + "/Assignatures");
            if (Files.exists(path)) {
                File[] files = new File(String.valueOf(path)).listFiles();
                for (File file : files) {
                    result.add(carregar_assignatura(file.getName(), nom, false));
                }
            }
        }
        return result;
    }

    public ArrayList<String> carregar_aula(String nom,Boolean sola) throws Exception {                          //OK
        Path path;
        if (sola) {
            path = Paths.get("src/persistencia/Aules/" + nom + ".txt");
        } else {
            path = Paths.get("src/persistencia/Aules/" + nom);
        }
        ArrayList<String> a = new ArrayList<String>();
        if(Files.exists(path)) {
            File f = new File(String.valueOf(path));
            Scanner sc = new Scanner(f);
            a.addAll(Arrays.asList(sc.next(), String.valueOf(sc.nextInt()), sc.next()));
        }
        return a;
    }

    public ArrayList<String> carregar_assignatura(String nom, String nomPla, Boolean sola) throws Exception {        //OK
        Path path;
        if (sola) {
            path = Paths.get("src/persistencia/PlaEstudis/" + nomPla + "/Assignatures/" + nom + ".txt");
        } else {
            path = Paths.get("src/persistencia/PlaEstudis/" + nomPla + "/Assignatures/" + nom);
        }
        ArrayList<String> a = new ArrayList<>();
        if(Files.exists(path)) {
            File f = new File(String.valueOf(path));
            Scanner sc = new Scanner(f);
            a.addAll(Arrays.asList(nomPla, sc.next(), sc.next(), String.valueOf(sc.nextInt()), String.valueOf(sc.nextInt()), String.valueOf(sc.nextInt()), sc.next(), String.valueOf(sc.nextInt()), String.valueOf(sc.nextInt())));
            int num_co = sc.nextInt();
            a.add(String.valueOf(num_co));
            for (int i = 0; i < num_co; ++i) a.add(sc.next());
        }
        return a;
    }

    public ArrayList<ArrayList<String> > carregar_all_aules() throws Exception {                                //OK
        Path path;
        path = Paths.get("src/persistencia/Aules");
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if(Files.exists(path)) {
            File[] files = new File(String.valueOf(path)).listFiles();
            for (File file : files) {
                result.add(carregar_aula(file.getName(), false));
            }
        }
        return result;
    }

    /*public ArrayList<Assignatura> carregar_all_assignatures(String nomPla) throws Exception {
        Path path;
        path = Paths.get("src/persistencia/PlaEstudis/" + nomPla + "/Assignatures/");
        File[] files = new File(String.valueOf(path)).listFiles();
        ArrayList<Assignatura> result = new ArrayList<>();
        for (File file : files) {
            result.add(carregar_assignatura(file.getName(),nomPla,false));
        }
        return result;
    }*/
/*
    public ArrayList<String> carregar_noms_horaris(String nomPla) {
        Path path;
        path = Paths.get("src/persistencia/PlaEstudis/" + nomPla + "/Horaris");
        File[] files = new File(String.valueOf(path)).listFiles();
        ArrayList<String> result = new ArrayList<>();

        if(files.length > 0) {
            for (File file : files) {
                ArrayList<String> aux = carregar_horari(file.getName()).get(0);
                result.add(aux.get(0));
                result.add(aux.get(1));
                result.add(aux.get(2));
            }
        }
        return result;
    }
    */

    public ArrayList<ArrayList<String>> carregar_all_plans() throws Exception {                       //OK
        Path path;
        path = Paths.get("src/persistencia/PlaEstudis");
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if(Files.exists(path)) {
            File[] files = new File(String.valueOf(path)).listFiles();
            if (files.length > 0) {
                for (File file : files) {
                    ArrayList<String> aux = carregar_pla(file.getName()).get(0);
                    ArrayList<String> aux2 = new ArrayList<>();
                    aux2.add(aux.get(0));
                    aux2.add(aux.get(1));
                    aux2.add(aux.get(2));
                    result.add(aux2);
                }
            }
        }
        return result;
    }

    public ArrayList<ArrayList<String>> carregar_horari(String nom, String pla, boolean sola) throws Exception {
        Path path;
        if (sola) {
            path = Paths.get("src/persistencia/PlaEstudis/" + pla + "/Horaris/" + nom + ".txt");
        } else {
            path = Paths.get("src/persistencia/PlaEstudis/" + pla + "/Horaris/" + nom);
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if(Files.exists(path)) {
            File f = new File(String.valueOf(path));
            Scanner sc = new Scanner(f);
            ArrayList<String> aux = new ArrayList<>();
            aux.add(sc.next());
            aux.add(sc.next());
            int res = sc.nextInt();
            int as = sc.nextInt();
            int cl = sc.nextInt();
            aux.add(String.valueOf(res));
            aux.add(String.valueOf(as));
            aux.add(String.valueOf(cl));
            result.add(aux);
            for (int i = 0; i < res; ++i) {
                ArrayList<String> aux2 = new ArrayList<>();
                String t = sc.next();
                aux2.add(t);
                if (t.equals("RCL")) {
                    for (int j = 0; j < 4; ++j) {
                        aux2.add(sc.next());
                    }
                }
                if (t.equals("RG")) {
                    for (int j = 0; j < 5; ++j) {
                        aux2.add(sc.next());
                    }
                }
                result.add(aux2);
            }
            for (int i = 0; i < as; ++i) {
                ArrayList<String> aux3 = new ArrayList<>();
                aux3.addAll(Arrays.asList(sc.next(), sc.next(), String.valueOf(sc.nextInt()), String.valueOf(sc.nextInt()), String.valueOf(sc.nextInt()), sc.next(), String.valueOf(sc.nextInt()), String.valueOf(sc.nextInt())));
                int num_co = sc.nextInt();
                aux3.add(String.valueOf(num_co));
                for (int j = 0; j < num_co; ++j) aux3.add(sc.next());
                result.add(aux3);
            }
            for (int i = 0; i < cl; ++i) {
                ArrayList<String> aux4 = new ArrayList<>();
                aux4.addAll(Arrays.asList(sc.next(), String.valueOf(sc.next()), sc.next(), sc.next(), String.valueOf(sc.nextInt()), sc.next(), String.valueOf(sc.nextInt())));
                result.add(aux4);
            }
        }
        return result;
    }

    public ArrayList<String> carregar_noms_horaris(String nomPla) throws Exception {
        ArrayList<String> result = new ArrayList<>();
        Path path;
        path = Paths.get("src/persistencia/PlaEstudis/" + nomPla + "/Horaris");
        if(Files.exists(path)) {
            File[] files = new File(String.valueOf(path)).listFiles();
            if (files.length > 0) {
                for (File file : files) {
                    ArrayList<ArrayList<String>> aux = carregar_horari(file.getName(),nomPla,false);
                    result.add(aux.get(0).get(0));
                }
            }
        }
        return result;
    }

    public boolean borrar_aula(String nom) {
        Path path = Paths.get("src/persistencia/Aules/" + nom + ".txt");
        File f = new File(String.valueOf(path));
        boolean correct;
        if(f.delete()){
            correct = true;
        }else{
            correct = false;
        }
        return correct;
    }

    public boolean borrar_assignatura(String nom, String nomPla) {
        Path path = Paths.get("src/persistencia/PlaEstudis/" + nomPla + "/Assignatures/" + nom + ".txt");
        File f = new File(String.valueOf(path));
        boolean correct;
        if(f.delete()){
            correct = true;
        }else{
            correct = false;
        }
        return correct;
    }

    public boolean borrar_pla(String nom) {
        boolean correct = true;
        Path path = Paths.get("src/persistencia/PlaEstudis/" + nom + "/Assignatures");
        File[] files = new File(String.valueOf(path)).listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.delete()) correct = false;
            }
            File f = new File(String.valueOf(path));
            if (!f.delete()) correct = false;
        }
        path = Paths.get("src/persistencia/PlaEstudis/" + nom + "/Horaris");
        files = new File(String.valueOf(path)).listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.delete()) correct = false;
            }
            File f = new File(String.valueOf(path));
            if (!f.delete()) correct = false;
        }
        path = Paths.get("src/persistencia/PlaEstudis/" + nom + "/info_pla.txt");
        File f = new File(String.valueOf(path));
        if(!f.delete()) correct = false;
        path = Paths.get("src/persistencia/PlaEstudis/" + nom);
        f = new File(String.valueOf(path));
        if(!f.delete()) correct = false;
        return correct;
    }

    public boolean borrar_horari(String nom, String nomPla) {
        Path path = Paths.get("src/persistencia/PlaEstudis/" + nomPla + "/Horaris/" + nom + ".txt");
        File f = new File(String.valueOf(path));
        boolean correct;
        if (f.delete()) {
            correct = true;
        } else {
            correct = false;
        }
        return correct;
    }

}
