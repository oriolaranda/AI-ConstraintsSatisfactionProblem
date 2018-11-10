package testing.drivers;

import domini.Grup;
import domini.TipusAula;

import java.util.Scanner;

public class driverGrup {
    public static void main(String[] args) {
        Grup g = null;

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

        System.out.println("\t5) Getter capacitat:");
        System.out.println("\t\tformat: 5");

        System.out.println("\t6) Getter duracio:");
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

        Scanner sc = new Scanner(System.in);
        int opcio = sc.nextInt();
        String nomAssig = null;
        int num = -1;
        TipusAula tipus = null;
        int capacitat = -1;
        int duracio = -1;
        while(opcio!=12){
            try {
                switch (opcio) {
                    case 1:
                        nomAssig = sc.next();
                        num = sc.nextInt();
                        tipus = TipusAula.stoTipusAula(sc.next());
                        capacitat = sc.nextInt();
                        duracio = sc.nextInt();
                        g = new Grup(nomAssig, num, tipus, capacitat, duracio);

                        System.out.println("Grup esperat: " + id + ":" + capacitat + ":" + horari + ":" + tipus);
                        System.out.println("Grup creat: " + g.toString());
                        break;
                    case 2:
                        if (g == null) throw new NullPointerException();
                        System.out.println("Id esperat: " + id);
                        System.out.println("Id obtingut: " + g.getId());
                        break;
                    case 3:
                        if (g == null) throw new NullPointerException();
                        System.out.println("Capacitat esperada: " + capacitat);
                        System.out.println("Capacitat obtinguda: " + g.getCapacitat());
                        break;
                    case 4:
                        if (g == null) throw new NullPointerException();
                        System.out.println("Horari esperat: " + horari);
                        System.out.println("Horari obtingut: " + g.getHorariAssig());
                        break;
                    case 5:
                        if (g == null) throw new NullPointerException();
                        System.out.println("Tipus esperat: " + tipus);
                        System.out.println("Tipus obtingut: " + g.getTipus());
                        break;
                }
            }catch(NullPointerException npe){
                System.out.println("Abans de probar altres funcions, crea un grup probant la creadora");
            }finally{
                System.out.println("Introdueix una opcio amb el seu format:");
                opcio = sc.nextInt();
            }
        }





    }
}

