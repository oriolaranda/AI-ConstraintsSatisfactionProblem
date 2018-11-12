package domini;

public class Sessio {
    private String id;
    private int num;


    public Sessio (String id, int num) {
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


    /*SETTERS */

    public void setId(String id) {
        this.id = id;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return id+"["+num+"]";
    }
}
