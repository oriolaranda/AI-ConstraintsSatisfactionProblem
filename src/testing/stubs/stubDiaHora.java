package testing.stubs;

import domini.DiaHora;


public class stubDiaHora extends DiaHora {


    public stubDiaHora() {
        super("Dimarts", 11);
    }

    @Override
    public String getDia() {
        return super.getDia();
    }

    @Override
    public int getHora() {
        return super.getHora();
    }

}
