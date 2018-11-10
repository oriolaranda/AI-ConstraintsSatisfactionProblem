package domini;

public class Grup {
    //Dades
    private String nomAssig;
    private int num;
    private TipusAula tipus;
    private int capacitat;
    private int duracio;

    //Constructora
    public Grup(String nom_assig,int num, TipusAula tipus, int capacitat, int duracio) {
        this.nomAssig = nom_assig;
        this.num = num;
        this.tipus = tipus;
        this.capacitat = capacitat;
        this.duracio = duracio;
    }

    /** GETTERS **/

    public String getAssig() {
        return nomAssig;
    }

    public int getNum() {
        return num;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public int getDuracio() {
        return duracio;
    }

    public TipusAula getTipus() {
        return tipus;
    }

    /** SETTERS **/

    public void setAssig(String nomAssig){
        this.nomAssig = nomAssig;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public void setDuracio(int duracio) {
        this.duracio = duracio;
    }

    public void setTipus(TipusAula tipus) {
        this.tipus = tipus;
    }

    @Override
    public String toString() {
        return nomAssig+"-"+num+" "+tipus+" "+capacitat+"alumnes"+" "+duracio+"h/sessio";
    }
}
