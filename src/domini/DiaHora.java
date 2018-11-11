package domini;

public class DiaHora {

    private String Dia;
    private int Hour;


    public  DiaHora(String Dia, int Hour) {
        this.Dia = Dia;
        this.Hour = Hour;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String dia) {
        Dia = dia;
    }

    public int getHour() {
        return Hour;
    }

    public void setHour(int hour) {
        Hour = hour;
    }
}
