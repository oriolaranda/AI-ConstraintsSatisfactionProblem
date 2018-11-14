package domini;

public class Classe {


    private String nomAula;
    private String dia;
    private int hour;

    public Classe() {
    }

    public Classe(String nomAula, String dia, int hour) {
        this.nomAula = nomAula;
        this.dia = dia;
        this.hour = hour;
       // aula.setNom(nomAula);
        //Hora.setDia(dia);
        //Hora.setHora(hour);
    }

  /*  public Classe(Aula aula, DiaHora hora) {
        this.aula = aula;
        this.Hora = hora;
        nomAula = aula.getNom();
        dia = hora.getDia();
        hour = hora.getHora();
    }*/
    public String getNomAulaClasse() { return nomAula; }

    public void setNomAulaClasse(String nomAula) { this.nomAula = nomAula; }

    public String getDiaClasse() { return dia; }

    public void setDiaClasse(String dia) { this.dia = dia; }

    public int getHoraClasse() { return hour; }

    public void setHoraClasse(int hour) { this.hour = hour; }

}
