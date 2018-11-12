package domini;

public class Classe {

    private Aula aula;
    private DiaHora hora;

    public Classe(Aula aula, DiaHora hora) {
        this.aula = aula;
        this.hora = hora;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public DiaHora getHora() {
        return hora;
    }

    public void setHora(DiaHora hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return aula.getNom() + "-> " + hora;
    }


}
