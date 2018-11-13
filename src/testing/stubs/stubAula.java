package testing.stubs;

import domini.Aula;
import domini.TipusAula;

public class stubAula extends Aula {

    public stubAula() {
        super("A5002", 60, TipusAula.TEORIA);
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public int getCapacitat() {
        return super.getCapacitat();
    }

    @Override
    public TipusAula getTipus() {
        return super.getTipus();
    }

}
