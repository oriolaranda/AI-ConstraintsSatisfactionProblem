package testing.stubs;

import domini.Assignatura;

public class stubAssignatura extends Assignatura {
    public stubAssignatura() {
        super("Grau en Enginyeria Informatica", "PRO1", "inicial");
    }

    @Override
    public String getNomPlaEstudis() {
        return super.getNomPlaEstudis();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getFase() {
        return super.getFase();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
