package domini;

import java.util.Objects;

public class DiaHora implements Comparable<DiaHora>{

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
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    private int valorDia(String s) {
        if (s.equalsIgnoreCase("dilluns")) return 1;
        if (s.equalsIgnoreCase("dimarts")) return 2;
        if (s.equalsIgnoreCase("dimecres")) return 3;
        if (s.equalsIgnoreCase("dijous")) return 4;
        if (s.equalsIgnoreCase("divendres")) return 5;
        return -1;
    }

    @Override
    public String toString() {
        return dia + ": " + hora + "h-" + (hora + 1)+"h";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof DiaHora)) return false;
        return this.dia.equals(((DiaHora) obj).dia) && this.hora == ((DiaHora) obj).hora;
    }
    @Override
    public int hashCode() {
        return Objects.hash(dia,hora);
    }

    @Override
    public int compareTo(DiaHora h) {
        int dia1 = valorDia(dia);
        int hora1 = hora;
        int dia2 = valorDia(h.dia);
        int hora2 = h.hora;
        int comp = Integer.valueOf(hora1).compareTo(hora2);
        if (comp == 0) return Integer.valueOf(dia1).compareTo(dia2);
        return comp;
    }
}
