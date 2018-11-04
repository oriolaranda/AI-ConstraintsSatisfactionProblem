package domini;
import java.util.ArrayList;

public class Restriccio {
    private String id;
    private ArrayList<Horari> horari;  //estas cosas hay que iniciarlas en la constructora?

    //Constructoras
    public Restriccio () {
        id=null;
    }
    public Restriccio (String i) {
        id=i;
    }

    //Getters
    public String getId(){
        return id;
    }

    //Setters
    public void setId(String i){
        id=i;
    }
}
