package persistencia;

import domini.*;

import java.io.File;

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
                System.out.println(aux);
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

    public void guardar_horari(Horari horari, String pla) {
        try {
            Path file = Paths.get("src/persistencia/PlaEstudis/" + pla + "/Horaris/" + horari.getNom() + ".txt");
            if(!Files.exists(file)) {
                Files.createDirectories(file.getParent());
                Files.createFile(file);
            }
            List<String> sessio = new ArrayList<>();
            for (Map.Entry<Classe, Sessio> entry : horari.getNou().entrySet()) {
                sessio.add(entry.getKey().getAula().getNom() + " " + entry.getKey().getHora().getDia() + " " + entry.getKey().getHora().getHora() + " / " + entry.getValue().getId() + " " + entry.getValue().getNum());
                Files.write(file, sessio, Charset.forName("UTF-8"));
            }
        } catch (Exception e) {
        }
    }

  //  public Horari carregar_horari(String nomPla,String nom) {}

    public ArrayList<ArrayList<String> > carregar_pla(String nom) throws Exception {                    //OK

        Path path = Paths.get("src/persistencia/PlaEstudis/" + nom + "/info_pla.txt");
        File f = new File(String.valueOf(path));
        Scanner sc = new Scanner(f);
        String n = sc.next();
        int[] periode = new int[]{sc.nextInt(), sc.nextInt()};
        ArrayList<ArrayList<String> > result = new ArrayList<ArrayList<String> >();
        ArrayList<String> aux = new ArrayList<String>();
        aux.addAll(Arrays.asList(n,String.valueOf(periode[0]),String.valueOf(periode[1])));
        result.add(aux);
        path = Paths.get("src/persistencia/PlaEstudis/" + nom + "/Assignatures");
        if(Files.exists(path)) {
            File[] files = new File(String.valueOf(path)).listFiles();
            for (File file : files) {
                result.add(carregar_assignatura(file.getName(), nom, false));
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
        File f = new File(String.valueOf(path));
        Scanner sc = new Scanner(f);
        ArrayList<String> a = new ArrayList<String>();
        a.addAll(Arrays.asList(sc.next(), String.valueOf(sc.nextInt()), sc.next()));
        return a;
    }

    public ArrayList<String> carregar_assignatura(String nom, String nomPla, Boolean sola) throws Exception {        //OK
        Path path;
        if (sola) {
            path = Paths.get("src/persistencia/PlaEstudis/" + nomPla + "/Assignatures/" + nom + ".txt");
        } else {
            path = Paths.get("src/persistencia/PlaEstudis/" + nomPla + "/Assignatures/" + nom);
        }
        File f = new File(String.valueOf(path));
        Scanner sc = new Scanner(f);
        ArrayList<String> a = new ArrayList<>();
        a.addAll(Arrays.asList(nomPla, sc.next(), sc.next(), String.valueOf(sc.nextInt()), String.valueOf(sc.nextInt()), String.valueOf(sc.nextInt()), sc.next(), String.valueOf(sc.nextInt()), String.valueOf(sc.nextInt())));
        int num_co = sc.nextInt();
        a.add(String.valueOf(num_co));
        for (int i = 0; i < num_co; ++i) a.add(sc.next());
        return a;
    }

    public ArrayList<ArrayList<String> > carregar_all_aules() throws Exception {                                //OK
        Path path;
        path = Paths.get("src/persistencia/Aules");
        File[] files = new File(String.valueOf(path)).listFiles();
        ArrayList<ArrayList<String> > result = new ArrayList<>();
        for (File file : files) {
            result.add(carregar_aula(file.getName(),false));
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
        File[] files = new File(String.valueOf(path)).listFiles();
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        if(files.length > 0) {
            for (File file : files) {
                ArrayList<String> aux = carregar_pla(file.getName()).get(0);
                ArrayList<String> aux2 = new ArrayList<>();
                aux2.add(aux.get(0));
                aux2.add(aux.get(1));
                aux2.add(aux.get(2));
                result.add(aux2);
            }
        }
        return result;
    }
/*
    public ArrayList<String> carregar_noms_horaris(String nomPla) throws Exception {
        ArrayList<String> result = new ArrayList<>();
        Path path;
        path = Paths.get("src/persistencia/PlaEstudis/" + nomPla + "/Horaris");
        if(Files.exists(path)) {
            File[] files = new File(String.valueOf(path)).listFiles();
            if (files.length > 0) {
                for (File file : files) {
                    result.add(//carregar_horari(().getnom()))));
                }
            }
        }
        return result;
    }
*/
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
}
