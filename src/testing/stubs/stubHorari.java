package testing.stubs;


import domini.Horari;


public class stubHorari extends Horari {

    public stubHorari() {
        super("H1", null, null, null);
    }

    public String getNom() {
        return "H1";
    }


}
