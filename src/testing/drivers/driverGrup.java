package testing.drivers;

import domini.Grup;
import domini.TipusAula;

import java.util.Scanner;

import static domini.TipusAula.stoTipusAula;

public class driverGrup {

    private static void menu() {
        System.out.println("Driver Grup:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 nomAssignatura<String> num<int> tipus<TipusAula> numSessions<int> capacitat<int> duracio<int>");
        System.out.println("\t\t<TipusAula> pot ser (T | TEORIA) | (L | LABORATORI) | (P | PROBLEMES)");

        System.out.println("\t2) Getter nom assignatura:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter num grup:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Getter tipus grup:");
        System.out.println("\t\tformat: 4");

        System.out.println("\t5) Getter num sessions:");
        System.out.println("\t\tformat: 5");

        System.out.println("\t6) Getter capacitat grup:");
        System.out.println("\t\tformat: 6");

        System.out.println("\t7) Getter duracio sessio:");
        System.out.println("\t\tformat: 7");

        System.out.println("\t8) Setter nom assignatura:");
        System.out.println("\t\tformat: 8 nomAssignatura<String>");

        System.out.println("\t9) Setter num grup:");
        System.out.println("\t\tformat: 9 num<int>");

        System.out.println("\t10) Setter tipus grup:");
        System.out.println("\t\tformat: 10 tipus<TipusAula>");

        System.out.println("\t11) Setter num sessions:");
        System.out.println("\t\tformat: 11 numSessions<int>");

        System.out.println("\t12) Setter capacitat:");
        System.out.println("\t\tformat: 12 capacitat<int>");

        System.out.println("\t13) Setter duracio:");
        System.out.println("\t\tformat: 13 duracio<int>");

        System.out.println("\t14) Sortir:");
        System.out.println("\t\tformat: 14");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        Grup g = null;
        String nomAssig = null;
        int num = -1;
        TipusAula tipus = null;
        int numSessions = -1;
        int capacitat = -1;
        int duracio = -1;
        String fase = null;

        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while (opcio != 14) {
            try {
                switch (opcio) {
                    case 1:
                        nomAssig = sc.next();
                        num = sc.nextInt();
                        tipus = stoTipusAula(sc.next());
                        numSessions = sc.nextInt();
                        capacitat = sc.nextInt();
                        duracio = sc.nextInt();
                        fase = sc.next();
                        g = new Grup(nomAssig, num, tipus, numSessions, capacitat, duracio, fase);

                        System.out.println("Grup esperat: " + nomAssig + "-" + num + " " + tipus + " " + capacitat + "alumnes" + " " + duracio + "h/sessio");
                        System.out.println("Grup creat: " + g.toString());
                        break;
                    case 2:
                        if (g == null) throw new NullPointerException();
                        System.out.println("Nom assignatura esperat: " + nomAssig);
                        System.out.println("Nom assignatura obtingut: " + g.getAssig());
                        break;
                    case 3:
                        if (g == null) throw new NullPointerException();
                        System.out.println("Num grup esperat: " + num);
                        System.out.println("Num grup obtingut: " + g.getNum());
                        break;
                    case 4:
                        if (g == null) throw new NullPointerException();
                        System.out.println("Tipus grup esperat: " + tipus);
                        System.out.println("Tipus grup obtingut: " + g.getTipus());
                        break;
                    case 5:
                        if (g == null) throw new NullPointerException();
                        System.out.println("Num sessions esperat: " + numSessions);
                        System.out.println("Num sessions obtingut: " + g.getNumSessions());
                        break;
                    case 6:
                        if (g == null) throw new NullPointerException();
                        System.out.println("Capacitat esperada: " + capacitat);
                        System.out.println("Capacitat obtinguda: " + g.getCapacitat());
                        break;
                    case 7:
                        if (g == null) throw new NullPointerException();
                        System.out.println("Duracio esperada: " + duracio);
                        System.out.println("Duracio obtinguda: " + g.getDuracio());
                        break;
                    case 8:
                        nomAssig = sc.next();
                        if (g == null) throw new NullPointerException();
                        g.setAssig(nomAssig);
                        if (nomAssig.equals(g.getAssig())) System.out.println("Nom assignatura assignat correctament");
                        else System.out.println("Nom assignatura NO assignat correctament");
                        break;
                    case 9:
                        num = sc.nextInt();
                        if (g == null) throw new NullPointerException();
                        g.setNum(num);
                        if (num == g.getNum()) System.out.println("Num grup assignat correctament");
                        else System.out.println("Num grup NO assignat correctament");
                        break;
                    case 10:
                        tipus = stoTipusAula(sc.next());
                        if (g == null) throw new NullPointerException();
                        g.setTipus(tipus);
                        if (tipus.equals(g.getTipus())) System.out.println("Tipus grup assignat correctament");
                        else System.out.println("Tipus grup NO assignat correctament");
                        break;
                    case 11:
                        numSessions = sc.nextInt();
                        if (g == null) throw new NullPointerException();
                        g.setNumSessions(numSessions);
                        if (numSessions == g.getNumSessions())
                            System.out.println("Capacitat grup assignat correctament");
                        else System.out.println("Capacitat grup NO assignat correctament");
                        break;
                    case 12:
                        capacitat = sc.nextInt();
                        if (g == null) throw new NullPointerException();
                        g.setCapacitat(capacitat);
                        if (capacitat == g.getCapacitat()) System.out.println("Capacitat grup assignat correctament");
                        else System.out.println("Capacitat grup NO assignat correctament");
                        break;
                    case 13:
                        duracio = sc.nextInt();
                        if (g == null) throw new NullPointerException();
                        g.setDuracio(duracio);
                        if (duracio == g.getDuracio()) System.out.println("Duracio sessio assignat correctament");
                        else System.out.println("Duracio sessio NO assignat correctament");
                        break;
                }

            } catch (NullPointerException n) {
                System.out.println("Abans de provar aquesta opcio utilitza la creadora");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                System.out.println("Introdueix una opcio amb el seu format:");
                opcio = sc.nextInt();
            }
        }


    }
}

