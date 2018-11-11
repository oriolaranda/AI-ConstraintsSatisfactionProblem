package testing.drivers;

import domini.Aula;
import domini.TipusAula;

import java.util.Scanner;

import static domini.TipusAula.*;

public class driverAula {
    private static void menu() {
        System.out.println("Driver Aula:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 nomAula<String> Capacitat<int> Tipus<TipusAula> (TipusAula pot ser T = Teoria, P = Problemes, L = Laboratori");

        System.out.println("\t2) Getter nom Aula:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter Capacitat:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Getter Tipus Aula:");
        System.out.println("\t\tformat: 4");

        System.out.println("\t5) Setter nom Aula:");
        System.out.println("\t\tformat: 5 nomAula<String>");

        System.out.println("\t6) Setter Capacitat:");
        System.out.println("\t\tformat: 6 Capacitat<int>");

        System.out.println("\t7) Setter Tipus Aula:");
        System.out.println("\t\tformat: 7 Tipus<TipusAula>");

        System.out.println("\t8) Sortir:");
        System.out.println("\t\tformat: 8");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        Aula a = null;
        String nomAula = null;
        TipusAula Tipus = null;
        int Capacitat = -1;

        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while(opcio!=8){
            try {
                switch (opcio) {
                    case 1:
                        nomAula = sc.next();
                        Capacitat = sc.nextInt();
                        Tipus = stoTipusAula(sc.next());

                        a = new Aula(nomAula, Capacitat, Tipus);

                        System.out.println("Aula esperada: " + nomAula + "  " + "capacitat de: " + Capacitat + "  Tipus: " + Tipus);
                        System.out.println("Aula creada: " + a.getNom() + "  " + "capacitat de: " + a.getCapacitat() + "  Tipus: " + a.getTipus());
                        break;
                    case 2:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Nom Aula esperat: " + nomAula);
                        System.out.println("Nom Aula obtingut: " + a.getNom());
                        break;
                    case 3:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Capacitat esperada: " + Capacitat);
                        System.out.println("Capacitat obtinguda: " + a.getCapacitat());
                        break;
                    case 4:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Tipus grup esperat: " + Tipus);
                        System.out.println("Tipus grup obtingut: " + a.getTipus());
                        break;
                    case 5:
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
