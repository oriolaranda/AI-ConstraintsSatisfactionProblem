package domini;

import java.util.Map;
import java.util.Vector;

public class RestriccioTipusAula extends Restriccio{

    public RestriccioTipusAula() {

    }

    @Override
    public Boolean precondicions(Sessio s, Classe c) {
        return (s.getTipusSessio().equals(c.getTipusClasse()));
    }

    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou,Classe actualc, Sessio actuals){
        return true;
    }
}
