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
            for(int i=0;i<classes.size();++i){
                if (classes.get(i).getAula().getCapacitat() < cs) classes.removeElementAt(i);
            }
        }
    }

    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou, Classe actualc, Sessio actuals) {
        return true;
    }
}