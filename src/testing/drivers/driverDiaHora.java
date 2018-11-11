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
        DiaHora a = null;
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


                        a = new DiaHora(Dia, Hora);

                        System.out.println("DiaHora esperat: " + nomAula + "  " + "capacitat de: " + Capacitat + "  Tipus: " + Tipus);
                        System.out.println("DiaHora creat: " + a.getNom() + "  " + "capacitat de: " + a.getCapacitat() + "  Tipus: " + a.getTipus());
                        break;
                    case 2:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Dia esperat: " + nomAula);
                        System.out.println("Dia obtingut: " + a.getNom());
                        break;
                    case 3:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Hora esperada: " + Capacitat);
                        System.out.println("Hora obtinguda: " + a.getCapacitat());
                        break;
                    case 4:
                        nomAula = sc.next();
                        if (a == null) throw new NullPointerException();
                        a.setNom(nomAula);
                        if (nomAula.equals(a.getNom())) System.out.println("Nom Aula assignat correctament");
                        else System.out.println("Nom Aula NO assignat correctament");
                        break;
                    case 6:
                        Capacitat = sc.nextInt();
                        if (a == null) throw new NullPointerException();
                        a.setCapacitat(Capacitat);
                        if (Capacitat == a.getCapacitat()) System.out.println("Capacitat Aula assignada correctament");
                        else System.out.println("Capacitat Aula NO assignada correctament");
                        break;
                    case 7:
                        Tipus = stoTipusAula(sc.next());
                        if (a == null) throw new NullPointerException();
                        a.setTipus(Tipus);
                        if (Tipus.equals(a.getTipus())) System.out.println("Tipus Aula assignat correctament");
                        else System.out.println("Tipus Aula NO assignat correctament");
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
