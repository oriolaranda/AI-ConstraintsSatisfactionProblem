package domini;

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

    public String getDiaClasse(){
        return Hora.getDia();
    }

    public int getHoraClasse(){
        return Hora.getHora();
    }

    public String getNomAulaClasse(){
        return aula.getNom();
    }

    public TipusAula getTipusClasse(){
        return aula.getTipus();
    }
    public int getCapacitatClasse() {
        return aula.getCapacitat();
    }


}
