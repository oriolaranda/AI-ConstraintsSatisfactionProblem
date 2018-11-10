package domini;

public enum TipusAula {
    TEORIA, PROBLEMES, LABORATORI;

    public TipusAula stoTipusAula(String s) {
        s = s.toUpperCase();
        if (s.equals("T") | s.equals("TEORIA")) return TEORIA;
        if (s.equals("P") | s.equals("PROBLEMES")) return PROBLEMES;
        if (s.equals("L") | s.equals("LABORATORI")) return LABORATORI;
        return null;
    }
}
