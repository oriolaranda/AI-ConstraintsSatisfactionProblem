package testing.stubs;

import domini.Classe;
import domini.Restriccio;
import domini.Sessio;

import java.util.Map;

public class stubRestriccio extends Restriccio {

    public stubRestriccio(){
        setHorari(new stubHorari());
    }

    @Override
    public Boolean precondicions(Sessio s, Classe c) {
        return true;
    }

    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou, Classe actualc, Sessio actuals) {
        return Boolean.TRUE;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
