package testing.drivers;

import domini.Grup;
import domini.Sessio;
import domini.TipusAula;
import testing.stubs.stubGrup;

import java.util.Scanner;

import static domini.TipusAula.stoTipusAula;

public class driverSessio {

    private static void menu() {
        System.out.println("Driver Sessio:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 (utilitzara l'stubGrup) ");

        System.out.println("\t2) Getter id sessio:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter num sessio:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Getter fase:");
        System.out.println("\t\tformat: 4");

        System.out.println("\t5) Getter nom assignatura:");
        System.out.println("\t\tformat: 5");

        System.out.println("\t6) Getter num grup:");
        System.out.println("\t\tformat: 6");

        System.out.println("\t7) Getter tipus grup:");
        System.out.println("\t\tformat: 7");

        System.out.println("\t8) Getter capacitat grup:");
        System.out.println("\t\tformat: 8");

        System.out.println("\t9) Setter id sessio:");
        System.out.println("\t\tformat: 9 id<String>");

        System.out.println("\t10) Setter num sessio:");
        System.out.println("\t\tformat: 10 num<int>");

        System.out.println("\t11) Sortir:");
        System.out.println("\t\tformat: 11");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        Sessio s = null;
        stubGrup g = new stubGrup();
        String id = null;
        int num = -1;
        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while (opcio != 12) {
            try {
                switch (opcio) {
                    case 1:
                        s = new Sessio(g.getAssig()+"-"+g.getNum(),0,g);
                        if (s != null) System.out.println("Sessio creada correctament, comprovar amb els getters");
                        else System.out.println("Sessio NO creada correctament ");
                        break;
                    case 2:
                        if (s == null) throw new NullPointerException();
                        System.out.println("Id sessio esperat: " + g.getAssig()+"-"+g.getNum());
                        System.out.println("Id sessio obtingut: " + s.getId());
                        break;
                    case 3:
                        if (s == null) throw new NullPointerException();
                        System.out.println("Num sessio esperada: " + 0);
                        System.out.println("Num sessio obtinguda: " + s.getNum());
                        break;
                    case 4:
                        if (s == null) throw new NullPointerException();
                        System.out.println("Fase esperada: " + g.getFase());
                        System.out.println("Fase obtinguda: " + s.getFaseSessio());
                        break;
                    case 5:
                        if (s == null) throw new NullPointerException();
                        System.out.println("Nom assignatura esperada: " + g.getAssig());
                        System.out.println("Nom assignatura obtinguda: " + s.getNomAssignaturaSessio());
                        break;
                    case 6:
                        if (s == null) throw new NullPointerException();
                        System.out.println("Num grup esperat: " + g.getNum());
                        System.out.println("Num grup obtingut: " + s.getNumGrupSessio());
                        break;
                    case 7:
                        if (s == null) throw new NullPointerException();
                        System.out.println("Tipus grup esperat: " + g.getTipus());
                        System.out.println("Tipus grup obtingut: " + s.getTipusSessio());
                        break;
                    case 8:
                        if (s == null) throw new NullPointerException();
                        System.out.println("Capacitat esperada: " + g.getCapacitat());
                        System.out.println("Capacitat obtinguda: " + s.getCapacitatSessio());
                        break;
                    case 9:
                        id = sc.next();
                        if (s == null) throw new NullPointerException();
                        s.setId(id);
                        if (s.getId().equals(id)) System.out.println("Id sessio assignat correctament");
                        else System.out.println("Id sessio NO assignat correctament");
                        break;
                    case 10:
                        num = sc.nextInt();
                        if (s == null) throw new NullPointerException();
                        s.setNum(num);
                        if (s.getNum() == num) System.out.println("Num sessio assignat correctament");
                        else System.out.println("Num sessio NO assignat correctament");
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
