package domini;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class RestriccioGrupDiaHora {
    private String nomAssignatura;
    private int num;

    private String dia;
    private int hora;


    //Constructora
    RestriccioGrupDiaHora(String nomAssignatura, int num, String dia, int hora){
        this.nomAssignatura=nomAssignatura;
        this.num=num;
        this.dia=dia;
        this.hora=hora;
    }

    //Getters
    public String getNomAssignatura() {
        return nomAssignatura;
    }

    public int getNum() {
        return num;
    }

    public String getDia() {
        return dia;
    }

    public int getHora() {
        return hora;
    }

    //Setters
    public void setNomAssignatura(String nomAssignatura) {
        this.nomAssignatura = nomAssignatura;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public void precondicions(){

    }


}
