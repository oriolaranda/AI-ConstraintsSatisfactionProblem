package domini;
import java.util.ArrayList;

public class Assignatura {
    private String nomPlaEstudis;
    private String id;
    private String fase;
    private ArrayList<Grup> grup;


    //Constructoras
    /*public Assignatura() {
        id = null;
        fase = null;
        grup = new ArrayList<Grup>();
    }

    public Assignatura(String i, String f) {
        id = i;
        fase = f;

    }*/

    public Assignatura(String nomPlaEstudis, String id, String fase) {
        this.nomPlaEstudis = nomPlaEstudis;
        this.id = id;
        this.fase = fase;
    }

    //Getters
    public String getNomPlaEstudis() {
        return nomPlaEstudis;
    }

    public String getId() {
        return id;
    }

    public String getFase() {
        return fase;
    }


    //Setters
    public void setNomPlaEstudis(String nom){
        nomPlaEstudis=nom;
    }

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

    @Override
    public String toString() {
        return nomPlaEstudis+": "+id+" ("+fase+")";
    }
}
