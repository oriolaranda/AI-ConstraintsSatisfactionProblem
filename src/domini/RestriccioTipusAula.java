package domini;

import java.util.Map;
import java.util.Vector;

public class RestriccioTipusAula extends Restriccio{



    @Override
    public void precondicions() {
        Map<Sessio, Vector<Classe>> m = super.getMap();
        for (Sessio s : m.keySet()) {
            Vector<Classe> classes = m.get(s);
            TipusAula tas=s.getTipusSessio();
            for (Classe c :classes) {
                if(!c.getTipusClasse().equals(tas)) classes.removeElement(c);
            }
        }
    }

    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou,Classe actualc, Sessio actuals){
        return true;
    }
}
