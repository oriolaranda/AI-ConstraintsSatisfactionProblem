package domini;

import java.util.Objects;

public class Classe {

    private Aula aula;
    private DiaHora Hora;

    public Classe() {
    }

    public Classe(Aula aula, DiaHora hora) {
        this.aula = aula;
        this.Hora = hora;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula  aula) {
        this.aula = aula;
    }

    public DiaHora getHora() {
        return Hora;
    }

    public void setHora(DiaHora hora) { this.Hora = hora; }

    @Override
    public String toString() {
        return aula.getNom()+": "+Hora;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (! (obj instanceof Classe)) return false;

        Classe c = (Classe) obj;
        return this.aula.equals(c.aula) && this.Hora.equals(c.Hora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aula,Hora);
    }
}
