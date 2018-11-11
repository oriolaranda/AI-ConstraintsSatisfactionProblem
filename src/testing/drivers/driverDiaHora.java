package testing.drivers;

import domini.DiaHora;
import java.util.Scanner;

public class driverDiaHora {
    private static void menu() {
        System.out.println("Driver DiaHora:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 Dia<String> Hora<int> (Hora pot tenir valor entre 0-24)");

        System.out.println("\t2) Getter Dia:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter Hora:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Setter Dia:");
        System.out.println("\t\tformat: 4 Dia<String>");

        System.out.println("\t5) Setter Hora:");
        System.out.println("\t\tformat: 5 Hora<int> (Hora ha de ser un valor entre 0-24)");

        System.out.println("\t6) Sortir:");
        System.out.println("\t\tformat: 6");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        DiaHora d = null;
        String Dia = null;
        int Hora = -1;

        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while(opcio!=6){
            try {
                switch (opcio) {
                    case 1:
                        Dia = sc.next();
                        Hora = sc.nextInt();


                        d = new DiaHora(Dia, Hora);

                        System.out.println("DiaHora esperat: " + Dia + " a les " + Hora);
                        System.out.println("DiaHora creat: " + d.getDia() + " a les " + d.getHora());
                        break;
                    case 2:
                        if (d == null) throw new NullPointerException();
                        System.out.println("Dia esperat: " + Dia);
                        System.out.println("Dia obtingut: " + d.getDia());
                        break;
                    case 3:
                        if (d == null) throw new NullPointerException();
                        System.out.println("Hora esperada: " + Hora);
                        System.out.println("Hora obtinguda: " + d.getHora());
                        break;
                    case 4:
                        Dia = sc.next();
                        if (d == null) throw new NullPointerException();
                        d.setDia(Dia);
                        if (Dia.equals(d.getDia())) System.out.println("Dia assignat correctament");
                        else System.out.println("Dia NO assignat correctament");
                        break;
                    case 5:
                        Hora = sc.nextInt();
                        if (d == null) throw new NullPointerException();
                        d.setHora(Hora);
                        if (Hora == d.getHora()) System.out.println("Hora assignada correctament");
                        else System.out.println("Hora NO assignada correctament");
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
