package testing.stubs;

import domini.DiaHora;


public class stubDiaHora extends DiaHora {


    public stubDiaHora() {
        super("Dimarts", 11);
    }

    @Override
    public String getDia() {
        return "Dimarts";
    }

    @Override
    public int getHora() {
        return 11;
    }

    @Override
    public String toString() {
        return "Dimarts a les 11";
    }

}
