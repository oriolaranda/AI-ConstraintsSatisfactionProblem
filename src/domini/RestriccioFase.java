package domini;

import java.util.Map;

public class RestriccioFase extends Restriccio {


    //Constructoras
    public RestriccioFase(){

    }


    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou, Classe actualc, Sessio actuals) {
        String dca= actualc.getDiaClasse();
        int hca= actualc.getHoraClasse();
        String fase=actuals.getFaseSessio();
        for(Classe c: nou.keySet()) {
            if(c.getDiaClasse().equals(dca) && c.getHoraClasse()==hca){
                Sessio s=nou.get(c);
                if(s.getFaseSessio().equals(fase)) return false;
            }
        }
        return true;
    }

    @Override
    public void precondicions(){

    }

}

