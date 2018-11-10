package domini;

public enum TipusAula {
    TEORIA, PROBLEMES, LABORATORI;

    public static TipusAula stoTipusAula(String s) throws Exception {
        s = s.toUpperCase();
        if (s.equals("T") | s.equals("TEORIA")) return TEORIA;
        if (s.equals("P") | s.equals("PROBLEMES")) return PROBLEMES;
        if (s.equals("L") | s.equals("LABORATORI")) return LABORATORI;
        throw new Exception("No existeix el tipus");
    }
}
