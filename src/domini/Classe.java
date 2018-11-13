package domini;

public class Classe {

    private String aula;
    private String dia;
    private int hora;

    public Classe() {
    }

    public Classe(String aula, String dia,  int hora) {
        this.aula = aula;
        this.dia = dia;
        this.hora = hora;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String  aula) {
        this.aula = aula;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String  Dia) {
        this.dia = Dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }


}
