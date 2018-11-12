package testing.stubs;

import domini.Grup;
import domini.TipusAula;

public class stubGrup extends Grup {

    public stubGrup() {
        super("PRO1", 20, TipusAula.TEORIA, 70, 2);
    }

    @Override
    public String getAssig() {
        return super.getAssig();
    }

    @Override
    public int getNum() {
        return super.getNum();
    }

    @Override
    public TipusAula getTipus() {
        return super.getTipus();
    }

    @Override
    public int getCapacitat() {
        return super.getCapacitat();
    }

    @Override
    public int getNumSessions() {
        return super.getNumSessions();
    }

    @Override
    public int getDuracio() {
        return super.getDuracio();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
