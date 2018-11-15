package testing.stubs;

import domini.Grup;
import domini.TipusAula;

public class stubGrup extends Grup {

    public stubGrup() {
        super("PRO1", 20, TipusAula.TEORIA, 2, 70, 2, "inicial");
    }

    @Override
    public String getAssig() {
        return "PRO1";
    }

    @Override
    public int getNum() {
        return 20;
    }

    @Override
    public TipusAula getTipus() {
        return TipusAula.TEORIA;
    }

    @Override
    public int getCapacitat() {
        return 70;
    }

    @Override
    public int getNumSessions() {
        return 2;
    }

    @Override
    public int getDuracio() {
        return 2;
    }

    @Override
    public String toString() {
        return "PRO1-20: TEORIA 70 alumnes 2 sessions 2h/sessio";
    }
}
