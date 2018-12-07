package domini;

import java.util.*;

public class Horari {

    //Atributs
    private String nom;
    private ArrayList<Sessio> Sessions;
    private Vector<Classe> Classes;
    private ArrayList<Restriccio> Restriccions;
    private Map<Sessio, Vector<Classe>> prev;
    private Map<Classe, Sessio> nou;
    private boolean Ple;

    //Constructors

    public Horari(String nom) {
        this.nom = nom;
        this.Ple = false;
        this.Sessions = new ArrayList<Sessio>();
        this.Classes = new Vector<Classe>();
        this.Restriccions = new ArrayList<Restriccio>();
        this.prev = new LinkedHashMap<>();
        this.nou = new HashMap<>();
    }

    /**
     * Constructor for Horari
     */
    public Horari(String nom, ArrayList<Sessio> Sessions, Vector<Classe> Classes, ArrayList<Restriccio> Restriccions) {
        this.nom = nom;
        this.Sessions = Sessions;
        this.Classes = Classes;
        this.Restriccions = Restriccions;
        this.Ple = false;
        this.prev = new LinkedHashMap<>();
        this.nou = new HashMap<>();
        Restriccio aux;
        aux = new RestriccioFase();
        add_restriccio(aux);
        aux = new RestriccioGrupDiaHora("bd",10,"Dimarts",9);
        add_restriccio(aux);
        aux = new RestriccioCapacitat();
        add_restriccio(aux);
        aux = new RestriccioTipusAula();
        add_restriccio(aux);
        aux = new RestriccioCorrequisit();
        add_restriccio(aux);
        aux = new RestriccioClasse("A5002","Dimecres",16);
        add_restriccio(aux);
    }


    //Getters
    public String getNom() {
        return nom;
    }

    public ArrayList<Sessio> getSessions() {
        return Sessions;
    }

    public Vector<Classe> getClasses() {
        return Classes;
    }

    public ArrayList<Restriccio> getRestriccions() {
        return Restriccions;
    }

    public boolean getPle() {
        return Ple;
    }

    public Map<Classe, Sessio> getNou() {
        return nou;
    }

    public Map<Sessio, Vector<Classe>> getPrev() {
        return prev;
    }


    //Setters

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSessions(ArrayList<Sessio> Sessions) {
        this.Sessions = Sessions;
    }

    public void setRestriccions(ArrayList<Restriccio> Restriccions) {
        this.Restriccions = Restriccions;
    }

    public void setClasses(Vector<Classe> classes) {
        this.Classes = classes;
    }

    public void setPle(boolean ple) {
        this.Ple = ple;
    }


    //Metodes

    public void generar_horari() {

        for (Sessio s:Sessions) {
            Vector <Classe> Classes1=(Vector<Classe>)Classes.clone();
            for (int j=0; j<Classes1.size();++j) {

                Boolean bien=true;
                Classe c=Classes1.get(j);
                for (int k=0; k<Restriccions.size() && bien;++k) {
                    bien=Restriccions.get(k).precondicions(s,c);
                }
                if(!bien) {
                    Classes1.removeElementAt(j);
                    --j;
                }
            }
            prev.put(s,Classes1);
        }

        Algorisme A = new Algorisme(prev, Restriccions);
        System.out.println("hola");
        nou = A.getHorari();

        if (!nou.isEmpty()) {
            Ple = true;
            System.out.println("NO S'HA TROBAT HORARI");
        }

    }

    public void printHorari() {
        if (Ple != false) {
            //nou.forEach((x, y) -> System.out.println(x + "->" + y));
            ArrayList<Classe> classes = new ArrayList<>(nou.keySet());
            Collections.sort(classes);
            String s = " ";
            for (Classe c : classes) {
                if (!s.equals(c.getDiaClasse())) {
                    System.out.println("---------------------");
                    System.out.println("-> " + c.getHora() );
                    System.out.println("---------------------");
                }
                System.out.println(c.getAula() + "->" + nou.get(c));
                s = c.getDiaClasse();
            }
            //System.out.println(classes);
        }
    }
    public void add_sessio(Sessio S) {
        Sessions.add(S);
    }

    public void remove_sessio(Sessio S) {
        Sessions.remove(S);
    }

    public void add_classe(Classe C) {
        Classes.add(C);
    }

    public void remove_classe(Classe C) {
        Classes.remove(C);
    }

    public void add_restriccio(Restriccio R) {
        Restriccions.add(R);
    }

    public void remove_restriccio(Restriccio R) {
        Restriccions.remove(R);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Horari)) return false;
        return this.nom.equals(((Horari) obj).nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prev, nou);
    }
}
