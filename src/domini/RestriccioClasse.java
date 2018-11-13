package domini;

import java.util.Iterator;
import java.util.Map;

public class RestriccioClasse extends Restriccio {
    private String nomAula;
    private String dia;
    private int hora;

    //Constructoras
    public RestriccioClasse(String id, String aula, String dia, int hora) {
        super(id);
        nomAula = aula;
        this.nomAula = aula;
        this.dia = dia;
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
    public void setNomAula(String aula) {
        nomAula = aula;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }


    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou) {
        Iterator<Classe> it = nou.keySet().iterator();
        Classe c = new Classe();
        while (it.hasNext()) {
            c = it.next();
            String a = c.getAula().getNom();
            String d = c.getHora().getDia();
            Integer h = c.getHora().getHora();

            if (a.equals(nomAula) && d.equals(dia) && h.equals(hora)) return false;
        }
        return true;
    }
}
