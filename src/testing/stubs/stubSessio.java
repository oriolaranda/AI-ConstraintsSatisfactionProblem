package testing.stubs;

import domini.Sessio;

public class stubSessio extends Sessio {


    public stubSessio() {
        super("PRO1-20", 0, new stubGrup());
    }

    @Override
    public int getNum() {
        return 0;
    }

    @Override
    public String getId() {
        return "PRO1-20";
    }

    @Override
    public String toString() {
        return "PRO1-20[0]";
    }
}
