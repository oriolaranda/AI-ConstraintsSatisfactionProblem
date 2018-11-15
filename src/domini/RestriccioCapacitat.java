package domini;

import java.util.Map;
import java.util.Vector;

public class RestriccioCapacitat extends Restriccio {

    public RestriccioCapacitat() {

    }

    @Override
    public void precondicions() {
        Map<Sessio, Vector<Classe>> m = super.getMap();
        for (Sessio s : m.keySet()) {
            Vector<Classe> classes = m.get(s);
            int cs = s.getCapacitatSessio();
            for (Classe c : classes) {
                if (c.getCapacitatClasse() < cs) classes.removeElement(c);
            }
        }
    }

    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou, Classe actualc, Sessio actuals) {
        return true;
    }
}