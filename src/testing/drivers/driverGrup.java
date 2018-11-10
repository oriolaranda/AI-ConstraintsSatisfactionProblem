package testing.drivers;

import domini.Grup;
import domini.TipusAula;

import java.util.Scanner;

import static domini.TipusAula.*;

public class driverGrup {

    private static void menu() {
        System.out.println("Driver Grup:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 nomAssignatura<String> num<int> tipus<TipusAula> capacitat<int> duracio<int>");

        System.out.println("\t2) Getter nom assignatura:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter num grup:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Getter tipus grup:");
        System.out.println("\t\tformat: 4");

        System.out.println("\t5) Getter capacitat grup:");
        System.out.println("\t\tformat: 5");

        System.out.println("\t6) Getter duracio sessio:");
        System.out.println("\t\tformat: 6");

        System.out.println("\t7) Setter nom assignatura:");
        System.out.println("\t\tformat: 7 nomAssignatura<String>");

        System.out.println("\t8) Setter num grup:");
        System.out.println("\t\tformat: 8 num<int>");

        System.out.println("\t9) Setter tipus grup:");
        System.out.println("\t\tformat: 9 tipus<TipusAula>");

        System.out.println("\t10) Setter capacitat:");
        System.out.println("\t\tformat: 10 capacitat<int>");

        System.out.println("\t11) Setter duracio:");
        System.out.println("\t\tformat: 11 duracio<int>");

        System.out.println("\t12) Sortir:");
        System.out.println("\t\tformat: 12");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        Grup g = null;
        String nomAssig = null;
        int num = -1;
        TipusAula tipus = null;
        int capacitat = -1;
        int duracio = -1;

        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while(opcio!=12){
            try {
                switch (opcio) {
                    case 1:
                        nomAssig = sc.next();
                        num = sc.nextInt();
                        tipus = stoTipusAula(sc.next());
                        capacitat = sc.nextInt();
                        duracio = sc.nextInt();
                        g = new Grup(nomAssig, num, tipus, capacitat, duracio);

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
                        System.out.println("Capacitat esperada: " + capacitat);
                        System.out.println("Capacitat obtinguda: " + g.getCapacitat());
                        break;
                    case 6:
                        if (g == null) throw new NullPointerException();
                        System.out.println("Duracio esperada: " + duracio);
                        System.out.println("Duracio obtinguda: " + g.getDuracio());
                        break;
                    case 7:
                        nomAssig = sc.next();
                        if (g == null) throw new NullPointerException();
                        g.setAssig(nomAssig);
                        if (nomAssig.equals(g.getAssig())) System.out.println("Nom assignatura assignat correctament");
                        else System.out.println("Nom assignatura NO assignat correctament");
                        break;
                    case 8:
                        num = sc.nextInt();
                        if (g == null) throw new NullPointerException();
                        g.setNum(num);
                        if (num == g.getNum()) System.out.println("Num grup assignat correctament");
                        else System.out.println("Num grup NO assignat correctament");
                        break;
                    case 9:
                        tipus = stoTipusAula(sc.next());
                        if (g == null) throw new NullPointerException();
                        g.setTipus(tipus);
                        if (tipus.equals(g.getTipus())) System.out.println("Tipus grup assignat correctament");
                        else System.out.println("Tipus grup NO assignat correctament");
                        break;
                    case 10:
                        capacitat = sc.nextInt();
                        if (g == null) throw new NullPointerException();
                        g.setCapacitat(capacitat);
                        if (capacitat == g.getCapacitat()) System.out.println("Capacitat grup assignat correctament");
                        else System.out.println("Capacitat grup NO assignat correctament");
                        break;
                    case 11:
                        duracio = sc.nextInt();
                        if (g == null) throw new NullPointerException();
                        g.setDuracio(duracio);
                        if (duracio == g.getDuracio()) System.out.println("Duracio sessio assignat correctament");
                        else System.out.println("Duracio sessio NO assignat correctament");
                        break;
                }

            } catch (NullPointerException n){
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

