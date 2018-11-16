package testing.stubs;

import domini.Aula;
import domini.Classe;
import domini.DiaHora;

public class stubClasse extends Classe {

    public stubClasse() {
        super(new stubAula(), new stubDiaHora());
    }

    @Override
    public Aula getAula() {
        return new stubAula();
    }

    @Override
    public DiaHora getHora() {
        return new stubDiaHora();
    }

    @Override
    public String getDiaClasse(){
        return new stubDiaHora().getDia();
    }

    @Override
    public int getHoraClasse(){
        return new stubDiaHora().getHora();
    }

    @Override
    public String getNomAulaClasse(){
        return new stubAula().getNom();
    }

    @Override
    public String toString() {
        return super.toString();
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
