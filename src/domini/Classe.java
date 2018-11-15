package domini;

import java.util.Objects;

public class Classe {

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

}