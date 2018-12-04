package domini;

import java.util.Map;

public class RestriccioCorrequisit extends Restriccio{

    //Constructora
    public RestriccioCorrequisit(){

    }

    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou, Classe actualc, Sessio actuals) {
        String dca= actualc.getDiaClasse();
        int hca= actualc.getHoraClasse();
        String ns = actuals.getNomAssignaturaSessio();
        for(Classe c: nou.keySet()) {
            if(c.getDiaClasse().equals(dca) && c.getHoraClasse()==hca){
                Sessio s=nou.get(c);
                if(s.esCorrequisit(ns)) return false;
            }
        }
        return true;
    }

    @Override
    public Boolean precondicions(Sessio s, Classe c){
        return true;
    }
}
