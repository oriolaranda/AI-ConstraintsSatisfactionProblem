package testing.stubs;

import domini.Classe;
import domini.Horari;
import domini.Restriccio;
import domini.Sessio;

import java.util.ArrayList;
import java.util.Vector;

public class stubHorari extends Horari {

    public stubHorari() {
        super("H1", 8, 20, new ArrayList<Sessio>(), new Vector<Classe>(), new ArrayList<Restriccio>() );
    }

    public String getNom() {
        return "H1";
    }

    public int getHoraIni() { return 8; }

    public int getHoraFi() { return 20; }

}
