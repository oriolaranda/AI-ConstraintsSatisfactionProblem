package domini;

public class Grup {
    //Dades
    private String nom_assig;
    private int num;
    private TipusAula tipus;
    private int capacitat;
    private int duracio;

    //Constructora
    public Grup(String nom_assig,int num, TipusAula tipus, int capacitat, int duracio) {
        this.nom_assig = nom_assig;
        this.num = num;
        this.tipus = tipus;
        this.capacitat = capacitat;
        this.duracio = duracio;
    }

    /** GETTERS **/

    public String getAssig() {
        return nom_assig;
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

    public void setAssig(String nom_assig){
        this.nom_assig = nom_assig;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public void getDuracio(int duracio) {
        this.duracio = duracio;
    }

    public void getTipus(TipusAula tipus) {
        this.tipus = tipus;
    }

}
