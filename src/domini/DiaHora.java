package domini;

import java.util.Objects;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (! (obj instanceof DiaHora)) return false;

        DiaHora d = (DiaHora) obj;
        return this.dia.equals(d.dia) && this.hora == d.hora;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia,hora);
    }
}