package testing.stubs;

import domini.Classe;
import domini.Horari;
import domini.Restriccio;
import domini.Sessio;

import java.util.ArrayList;
import java.util.Vector;

public class stubHorari extends Horari {

    public stubHorari() {
        super("H1", null, null, null);
    }

    public String getNom() {
        return "H1";
    }

    public int getHoraIni() { return 8; }

    public int getHoraFi() { return 20; }

}
