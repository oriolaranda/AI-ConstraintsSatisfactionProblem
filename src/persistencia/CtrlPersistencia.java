package persistencia;

import domini.*;

import java.io.File;

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
            Path file = Paths.get("src/persistencia/Aules/"+ nom + ".txt");
            Files.createDirectories(file.getParent());
            Files.createFile(file);
            Files.write(file, aula, Charset.forName("UTF-8"));
        } catch(Exception e) {}
    }

    public void guardar_assignatura(String nomPlaEstudis, String nom, String fase, int capacitatGrup, int capacitatSubGrups, int matriculats, String tipusSubgrup, int numSessions, int duracio, Vector<String> correquisits) {
        try {
            String aux = nom + " " + fase + " " + capacitatGrup + " " + capacitatSubGrups + " " + matriculats + " " + tipusSubgrup + " " + numSessions + " " + duracio + " " + correquisits.size();
            for (int i = 0; i < correquisits.size(); ++i) aux += " " + correquisits.get(i);
            List<String> assig = Arrays.asList(aux);
            Path file = Paths.get("src/persistencia/PlaEstudis/" + nomPlaEstudis + "/Assignatures/"+ nom + ".txt");
            Files.createDirectories(file.getParent());
            Files.createFile(file);
            Files.write(file, assig, Charset.forName("UTF-8"));
        } catch(Exception e) {}
    }

    public void guardar_pla(String nom, int horaIni, int horaFi) {
        try {
            List<String> pla = Arrays.asList(nom + " " + String.valueOf(horaIni) + " " + String.valueOf(horaFi));
            Path file = Paths.get("src/persistencia/PlaEstudis/"+ nom + "/info_pla.txt");
            Files.createDirectories(file.getParent());
            Files.createFile(file);
            Files.write(file, pla, Charset.forName("UTF-8"));
        } catch(Exception e) {}
    }

    public void guardar_horari(Horari horari, String pla) {
        try {
            Path file = Paths.get("src/persistencia/PlaEstudis/" + pla + "/Horaris/"+ horari.getNom() + ".txt");
            Files.createDirectories(file.getParent());
            Files.createFile(file);
            List<String> sessio = new ArrayList<>();
            for(Map.Entry<Classe, Sessio> entry : horari.getNou().entrySet()) {
                sessio.add(entry.getKey().getAula().getNom() + " " + entry.getKey().getHora().getDia() + " " + entry.getKey().getHora().getHora() + " / "  + entry.getValue().getId() + " " + entry.getValue().getNum() );
                Files.write(file,sessio, Charset.forName("UTF-8"));
            }
        } catch(Exception e) {}
    }

    public PlaEstudis carregar_pla(String nom) throws Exception {
        Path path = Paths.get("src/persistencia/PlaEstudis/"+ nom + "/info_pla.txt");
        File f = new File(String.valueOf(path));
        Scanner sc = new Scanner(f);
        String n = sc.next();
        int[] periode = new int[] {sc.nextInt(),sc.nextInt()};
        PlaEstudis p = new PlaEstudis(n,periode);
        path = Paths.get("src/persistencia/PlaEstudis/"+ nom + "/Assignatures");
        File[] files = new File(String.valueOf(path)).listFiles();
        for (File file : files) {
            p.addAssignatura(carregar_assignatura(file.getName(),nom,false));
        }
        return p;
    }

    public Aula carregar_aula(String nom) throws Exception {
        Path path = Paths.get("src/persistencia/Aules/"+ nom + ".txt");
        File f = new File(String.valueOf(path));
        Scanner sc = new Scanner(f);
        Aula a = new Aula(sc.next(),sc.nextInt(),stoTipusAula(sc.next()));
        return a;
    }

    public Assignatura carregar_assignatura(String nom, String nomPla,Boolean sola) throws Exception {
        Path path;
        if (sola) {
             path = Paths.get("src/persistencia/PlaEstudis/" + nomPla + "/Assignatures/"+ nom + ".txt");
        }
        else {
             path = Paths.get("src/persistencia/PlaEstudis/" + nomPla + "/Assignatures/"+ nom);
        }
        File f = new File(String.valueOf(path));
        Scanner sc = new Scanner(f);
        Assignatura a = new Assignatura(nomPla,sc.next(),sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt(),stoTipusAula(sc.next()),sc.nextInt(),sc.nextInt());
        int num_co = sc.nextInt();
        for (int i = 0; i < num_co; ++i) a.afegirCorrequisit(sc.next());
        return a;
    }

}
