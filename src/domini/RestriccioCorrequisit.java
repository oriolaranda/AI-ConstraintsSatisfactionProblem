package domini;

public class RestriccioCorrequisit extends Restriccio{
    private Assignatura A;
    private Assignatura B;


    //Constructoras
    public RestriccioCorrequisit (Assignatura assigA, Assignatura assigB){
        super();
        A=assigA;
        B=assigB;
    }

    //Getters
    public Assignatura getA(){
        return A;
    }

    public Assignatura getB(){
        return B;
    }


    //Setters
    public void setA(Assignatura assig){
        A=assig;
    }
    public void setB(Assignatura assig){
        B=assig;
    }

    //retorna true si A i B no son correquisits;
    public Boolean esCompleix() {
        return true;
    }
}
