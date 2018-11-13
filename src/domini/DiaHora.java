package domini;

public class DiaHora {

    private String dia;
    private int hora;


    public DiaHora(String Dia, int Hora) {
        this.dia = Dia;
        this.hora = Hora;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return dia + ": " + hora + "-" + (hora + 1);
    }
}
