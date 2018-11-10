package domini;

public class RestriccioAula extends Restriccio{
    private Aula a;


    //Constructoras
    public RestriccioAula (Aula aula){
        super();
        a=aula;
    }

    //Getters
    public Aula getA(){
        return a;
    }


    //Setters
    public void setA(Aula aula){
        a=aula;
    }

    //retorna true
    //@Override
    public Boolean esCompleix(){

        return true;
    }
}
