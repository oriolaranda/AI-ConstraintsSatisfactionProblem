package domini;

public class Classe {

    private Aula aula;
    private Hora hora;


    public Classe(Aula aula, Hora hora) {
        this.aula = aula;
        this.hora = hora;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }
}
