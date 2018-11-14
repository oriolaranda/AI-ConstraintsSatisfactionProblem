package testing.stubs;

import domini.Aula;
import domini.TipusAula;

public class stubAula extends Aula {

    public stubAula() {
        super("A5002", 60, TipusAula.TEORIA);
    }

    @Override
    public String getNom() {
        return "A5002";
    }

    @Override
    public int getCapacitat() {
        return 60;
    }

    @Override
    public TipusAula getTipus() {
        return TipusAula.TEORIA;
    }



    @Override
    public String toString() {
        return "Aula A5002 amb capacitat de 60 i tipus Teoria";
    }
}
