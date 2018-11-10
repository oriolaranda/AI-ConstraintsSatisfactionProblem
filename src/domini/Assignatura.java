package domini;
import java.util.ArrayList;

public class Assignatura {
    private String id;
    private String fase;
    private ArrayList<Assignatura> correquisit;
    private ArrayList<Grup> grup;
    private String nomPlaEstudis;


    //Constructoras
    public Assignatura() {
        id = null;
        fase = null;
    }

    public Assignatura(String i, String f) {
        id = i;
        fase = f;
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getFase() {
        return fase;
    }


    //Setters
    public void setId(String i) {
        id = i;
    }

    public void setFase(String f) {
        fase = f;
    }

    private Boolean existeixGrup(int num) {
        for (int i = 0; i < grup.size(); ++i) if (grup.get(i).getNum() == num) return true;
        return false;
    }

    public void crearGrup(int num, TipusAula tipus, int capacitat, int duracio) {
        if (!existeixGrup(num)) {
            Grup g = new Grup(id, num, tipus, capacitat, duracio);
            grup.add(g);
        }
        //else tractar excepcio
    }

    public Boolean esCorrequisit(Assignatura a) {
        for (int i = 0; i < correquisit.size(); ++i) if (correquisit.get(i).equals(a)) return true;
        return false;
    }
}
