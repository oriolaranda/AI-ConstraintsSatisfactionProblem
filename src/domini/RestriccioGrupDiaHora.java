package domini;

import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class RestriccioGrupDiaHora extends Restriccio{
    private String nomAssignatura;
    private int numGrup;

    private String dia;
    private int hora;


    //Constructora
    RestriccioGrupDiaHora(String nomAssignatura, int numGrup, String dia, int hora){
        this.nomAssignatura=nomAssignatura;
        this.numGrup=numGrup;
        this.dia=dia;
        this.hora=hora;
    }

    //Getters
    public String getNomAssignatura(){ return nomAssignatura;}

    public int getNum() {
        return numGrup;
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

    public void setNumGrup(int numGrup) {
        this.numGrup = numGrup;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public void precondicions(){
        Map<Sessio, Vector<Classe>> m = super.getMap();
        for (Sessio s : m.keySet()) {
            if(s.getNomAssignatura().equals(nomAssignatura) && s.getNumGrup().equals(numGrup)) {
                Vector<Classe> c = m.get(s);
                for (int i = 0; i < c.size(); ++i) {
                    if(c.get(i).getHora().getDia().equals(dia) && c.get(i).getHora().getHora()==hora) c.remove(i);
                }
            }
        }

    }
    @Override
    public Boolean esCompleix(Map<Classe,Sessio> nou, Sessio actual){
        return true;
    }


}
