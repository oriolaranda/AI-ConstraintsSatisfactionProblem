package domini;

public class Sessio {
    private String id;
    private int num;
    private Grup grup;


    public Sessio(String id, int num) {
        this.id = id;
        this.num = num;
    }

    /* GETTERS */

    public String getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    public String getFaseSessio(){
        return grup.getFaseGrup();
    }

    public String getNomAssignaturaSessio(){
        return grup.getAssig();
    }

    public int getNumGrupSessio(){
        return grup.getNum();
    }

    public TipusAula getTipusSessio(){
        return grup.getTipus();
    }

    public int getCapacitatSessio(){
        return grup.getCapacitat();
    }
    /*SETTERS */

    public void setId(String id) {
        this.id = id;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return id + "[" + num + "]";
    }
}
