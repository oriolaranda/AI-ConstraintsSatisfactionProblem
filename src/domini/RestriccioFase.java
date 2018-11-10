package domini;

public class RestriccioFase extends Restriccio{
    private Assignatura a;
    private Assignatura b;


    //Constructoras
    public RestriccioFase (Assignatura assigA, Assignatura assigB){
        super();
        a=assigA;
        b=assigB;
    }

    //Getters
    public Assignatura getA(){
        return a;
    }

    public Assignatura getB(){
        return b;
    }


    //Setters
    public void setA(Assignatura assig){
        a=assig;
    }
    public void setB(Assignatura assig){
        b=assig;
    }

//retorna true si A i B son de fases diferents.
    public Boolean esCompleix() {
        String fa = a.getFase();
        String fb = b.getFase();
        return !(fa.equals(fb));
    }
}

