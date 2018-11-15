package domini;

import java.util.Objects;

public class Sessio {
    private String id;
    private int num;
    private Grup grup;

    public Sessio(String id, int num, Grup grup) {
        this.num = num;
        this.id = id;
        this.grup = grup;
    }

    /* GETTERS */

    public String getId() {
        return id;
    }

    public int getNum() {
        return num;
    }
    public String getFaseSessio(){
        return grup.getFase();
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

    public void setGrup(Grup grup) {
        this.grup = grup;
    }

    @Override
    public String toString() {
        return id+"[" + num + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (! (obj instanceof Sessio)) return false;

        Sessio s = (Sessio) obj;
        return this.id.equals(s.id) && this.num == s.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,num,grup);
    }
}
