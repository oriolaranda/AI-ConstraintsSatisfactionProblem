package domini;

import java.util.Objects;

public class Classe implements Comparable<Classe> {

    private Aula aula;
    private DiaHora hora;

    public Classe() {
    }

    public Classe(Aula aula, DiaHora hora) {
        this.aula = aula;
        this.hora = hora;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula  aula) {
        this.aula = aula;
    }

    public DiaHora getHora() {
        return hora;
    }

    public void setHora(DiaHora hora) { this.hora = hora; }

    public String getDiaClasse(){
        return hora.getDia();
    }

    public int getHoraClasse(){
        return hora.getHora();
    }

    public String getNomAulaClasse(){
        return aula.getNom();
    }


    @Override
    public String toString() {
        return aula+"->"+hora;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Classe)) return false;
        return this.aula.equals(((Classe) obj).aula) && this.hora.equals(((Classe) obj).hora);
    }
    @Override
    public int hashCode() {
        return Objects.hash(aula, hora);
    }


    @Override
    public int compareTo(Classe o) {
        int diahora = this.hora.compareTo(o.hora);
        if (diahora == 0) return this.aula.getNom().compareTo(o.aula.getNom());
        return diahora;
    }
}