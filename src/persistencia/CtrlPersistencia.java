package persistencia;

import domini.Classe;
import domini.Horari;
import domini.PlaEstudis;
import domini.Sessio;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

   /* public void guardar_assignatura(String nom, int capacitat, String tipus) {
        try {
            List<String> aula = Arrays.asList(nom + " " + String.valueOf(capacitat) + " " + tipus);
            Path file = Paths.get("src/persistencia/Aules/"+ nom + ".txt");
            Files.write(file, aula, Charset.forName("UTF-8"));
        } catch(Exception e) {}
    }*/

    public void guardar_pla(String nom, int horaIni, int horaFi) {
        try {
            List<String> pla = Arrays.asList(nom + " " + String.valueOf(horaIni) + " " + String.valueOf(horaFi));
            Path file = Paths.get("src/persistencia/PlaEstudis/"+ nom + "/info_pla.txt");
            Files.createDirectories(file.getParent());
            Files.createFile(file);
            Files.write(file, pla, Charset.forName("UTF-8"));
        } catch(Exception e) {}
    }

    public void guardar_horari(Horari horari, PlaEstudis pla) {
        try {
            Path file = Paths.get("src/persistencia/PlaEstudis/" + pla.getNom() + "/"+ horari.getNom() + ".txt");
            Files.createDirectories(file.getParent());
            Files.createFile(file);
            List<String> sessio = new ArrayList<>();
            for(Map.Entry<Classe, Sessio> entry : horari.getNou().entrySet()) {
                sessio.add(entry.getKey().getAula().getNom() + " " + entry.getKey().getHora().getDia() + " " + entry.getKey().getHora().getHora() + " / "  + entry.getValue().getId() + " " + entry.getValue().getNum() );
                Files.write(file,sessio, Charset.forName("UTF-8"));
            }
        } catch(Exception e) {}
    }


}
