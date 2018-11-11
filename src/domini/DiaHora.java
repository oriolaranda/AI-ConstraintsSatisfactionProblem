package domini;

public class DiaHora {

    private String Dia;
    private int Hora;


    public  DiaHora(String Dia, int Hora) {
        this.Dia = Dia;
        this.Hora = Hora;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String dia) {
        Dia = dia;
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int hora) {
        Hora = hora;
    }
}
