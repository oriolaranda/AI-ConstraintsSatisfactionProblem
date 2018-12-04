package domini;

import java.util.Map;
import java.util.Vector;

public class RestriccioCapacitat extends Restriccio {

    public RestriccioCapacitat() {

    }

    @Override
    public Boolean precondicions(Sessio s, Classe c) {
        return (c.getCapacitatClasse()>=s.getCapacitatSessio());
    }

    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou, Classe actualc, Sessio actuals) {
        return true;
    }
}