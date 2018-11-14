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
     public void precondicions() {
        Map<Sessio, Vector<Classe>> m = super.getMap();
        for (Sessio s : m.keySet()) {
            Vector<Classe> c = m.get(s);
            Boolean stop = false;
            for (int i = 0; i < c.size() && !stop; ++i) {
                if (c.get(i).getHora().getDia().equals(dia) && (c.get(i).getHora().getHora() == hora) && c.get(i).getAula().getNom().equals(nomAula)) {
                    c.removeElementAt(i);
                    stop = true;
                }
            }
        }
    }

    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou,Sessio actual){
        return true;
    }

/*
    @Override
    public Boolean esCompleix(Map<Classe, Sessio> nou) { return true;}

        Iterator<Classe> it = nou.keySet().iterator();
        Classe c;
        while (it.hasNext()) {
            c = it.next();
            String a = c.getAula().getNom();
            String d = c.getHora().getDia();
            Integer h = c.getHora().getHora();

            if (a.equals(nomAula) && d.equals(dia) && h.equals(hora)) return false;
        }
        return true;

    }
    */
    @Override
    public String toString() {
        return nomAula+": "+dia+"de " +hora+":00 a" +(hora+1)+ ":00";
    }


}
