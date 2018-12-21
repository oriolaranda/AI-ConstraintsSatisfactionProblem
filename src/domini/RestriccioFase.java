package domini;

import java.util.Map;

public class RestriccioFase extends Restriccio {


    //Constructora
    public RestriccioFase(){

    }


    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou, Classe actualc, Sessio actuals) {
        String dca= actualc.getDiaClasse();
        int hca= actualc.getHoraClasse();
        String nomAula = actualc.getAula().getNom();
        String fase=actuals.getFaseSessio();
        for(Classe c: nou.keySet()) {
            if(c.getDiaClasse().equals(dca) && c.getHoraClasse()==hca && c.getAula().getNom() != nomAula){
                Sessio s=nou.get(c);
                if(s.getFaseSessio().equals(fase)) return false;
            }
        }
        return true;
    }

    @Override
    public Boolean precondicions(Sessio s, Classe c){
        return true;
    }

}

