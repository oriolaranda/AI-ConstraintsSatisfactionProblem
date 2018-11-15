package domini;

import java.util.Objects;

public class Sessio {
    private String nomAssig;
    private int numG;
    private int numS;
    private String id;
    private int num;
    private Grup grup;


    public Sessio(String nomAssig, int numG,int numS) {
        this.nomAssig = nomAssig;
        this.numG = numG;
        this.numS = numS;
    }

    public Sessio(String id, int num) {
        this.numS = num;
        this.nomAssig = id.split("-")[0];
        this.numG = Integer.parseInt(id.split("-")[1]);
    }

    /* GETTERS */

    public String getNomAssig() {
        return nomAssig;
    }

    public int getNumG() {
        return numG;
    }

    public int getNumS() {
        return numS;
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


    public String getId() {
        return id;
    }

    public int getNum() {
        return num;
    }
    public void setNumG(int num) {
        this.numG = numG;
    }

    public void setNumS(int numS) {
        this.numS = numS;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setNum(int num) {
        this.num = num;
    }
    @Override
    public String toString() {
        return nomAssig+"-"+numG + "[" + numS + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (! (obj instanceof Sessio)) return false;

        Sessio s = (Sessio) obj;
        return this.nomAssig.equals(s.nomAssig) && this.numG == s.numG && this.numS == s.numS;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomAssig,numG,numS);
    }
}
