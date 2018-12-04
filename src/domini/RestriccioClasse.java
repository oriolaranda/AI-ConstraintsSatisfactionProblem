package domini;

import java.util.Map;
import java.util.Vector;

public class RestriccioClasse extends Restriccio {
    private String nomAula;
    private String dia;
    private int hora;

    //Constructoras
    public RestriccioClasse(String nomAula, String dia, int hora) {
        this.nomAula = nomAula;
        this.dia = dia;
        this.hora = hora;
    }

    //Getters
    public String getNomAula() {
        return nomAula;
    }

    public String getDia() {
        return dia;
    }

    public Integer getHora() {
        return hora;
    }


    //Setters
    public void setNomAula(String nomAula) {
        this.nomAula = nomAula;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }


    @Override
     public Boolean precondicions(Sessio s, Classe c) {
        return !(c.getDiaClasse().equals(dia)&&(c.getHoraClasse() == hora)&&c.getNomAulaClasse().equals(nomAula));
    }

    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou,Classe actualc, Sessio actuals){
        return true;
    }


    @Override
    public String toString() {
        return nomAula+": "+dia+"de " +hora+":00 a" +(hora+1)+ ":00";
    }


}
