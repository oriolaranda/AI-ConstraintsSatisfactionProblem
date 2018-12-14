package domini;


import java.util.Map;
import java.util.Vector;

public class RestriccioGrupDiaHora extends Restriccio{

    private String id;
    private String nomAssignatura;
    private int numGrup;

    private String dia;
    private int hora;


    //Constructora
    public RestriccioGrupDiaHora(String id, String nomAssignatura, int numGrup, String dia, int hora){
        this.id = id;
        this.nomAssignatura=nomAssignatura;
        this.numGrup=numGrup;
        this.dia=dia;
        this.hora=hora;
    }

    //Getters
    public String getNomAssignatura(){ return nomAssignatura;}

    public int getNumGrup() {
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
    public Boolean precondicions(Sessio s, Classe c){
        return !(s.getNomAssignaturaSessio().equals(nomAssignatura)&&(s.getNumGrupSessio()==numGrup)&&c.getDiaClasse().equals(dia)&&(c.getHoraClasse()==hora));
    }

    @Override
    public Boolean esCompleix(Map<Classe,Sessio> nou, Classe actualc, Sessio actuals){
        return true;
    }

    @Override
    public String toString() {
        return nomAssignatura+"-"+numGrup+" "+dia+"de "+hora+":00 a" + (hora + 1) + ":00";
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
