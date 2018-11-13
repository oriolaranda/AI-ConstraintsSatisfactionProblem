package testing.drivers;

import domini.Aula;
import domini.Classe;
import domini.DiaHora;
import domini.TipusAula;

import java.util.Scanner;

import static domini.TipusAula.stoTipusAula;

public class DriverClasse {
/*
    private static void menu() {
        System.out.println("Driver Classe:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 nomAula<String> Capacitat<int> TipusAula<TipusAula> Dia<String> Hora<int>");

        System.out.println("\t2) Getter Aula:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter DiaHora:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Setter Aula:");
        System.out.println("\t\tformat: 4 nomAula<String> Capacitat<int> TipusAula<TipusAula>");

        System.out.println("\t5) Setter Dia");
        System.out.println("\t\tformat: 6 Dia<String> Hora<int>");

        System.out.println("\t6) Sortir:");
        System.out.println("\t\tformat: 6");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        Classe c = null;
        Aula a = null;
        DiaHora h = null;


        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while (opcio != 6) {
            try {
                switch (opcio) {
                    case 1:
                        a.setNom(); = sc.next();
                        a.setCapacitat(); = sc.nextInt();
                        a.setTipus()= stoTipusAula(sc.next());

                        c = new Classe(nomAula, Dia, Hora);

                        System.out.println("Classe esperada: " + nomAula + "  " + "el " + Dia + " a les " + Hora);
                        System.out.println("Classe creada: " + c.getAula() + "  " + "el " + c.getDia() + " a les " + c.getHora());
                        break;
                    case 2:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Nom Classe esperat: " + nomAula);
                        System.out.println("Nom Classe obtingut: " + c.getAula());
                        break;
                    case 3:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Dia esperat: " + Dia);
                        System.out.println("Dia obtingut: " + c.getDia());
                        break;
                    case 4:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Hora esperada: " + Hora);
                        System.out.println("Hora obtinguda: " + c.getHora());
                        break;
                    case 5:
                        nomAula = sc.next();
                        if (c == null) throw new NullPointerException();
                        c.setAula(nomAula);
                        if (nomAula.equals(c.getAula())) System.out.println("Nom Aula assignat correctament");
                        else System.out.println("Nom Aula NO assignat correctament");
                        break;
                    case 6:
                        Dia = sc.next();
                        if (c == null) throw new NullPointerException();
                        c.setDia(Dia);
                        if (Dia.equals(c.getDia())) System.out.println("Dia assignat correctament");
                        else System.out.println("Dia NO assignat correctament");
                        break;
                    case 7:
                        Hora = sc.nextInt();
                        if (c == null) throw new NullPointerException();
                        c.setHora(Hora);
                        if (Hora == c.getHora()) System.out.println("Hora assignada correctament");
                        else System.out.println("Hora NO assignada correctament");
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

    }*/
}
