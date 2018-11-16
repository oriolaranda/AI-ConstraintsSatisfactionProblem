package testing.drivers;

import domini.RestriccioClasse;
import java.util.Scanner;


public class driverRestriccioClasse {
    private static void menu() {
        System.out.println("Driver RestriccioClasse:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 nomaAula<String> dia<String> hora<Integer>");

        System.out.println("\t2) Getter nomAula RestriccioClasse:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter dia RestriccioClasse:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Getter hora RestriccioClasse:");
        System.out.println("\t\tformat: 4");


        System.out.println("\t5) Setter nomAula RestriccioClasse:");
        System.out.println("\t\tformat: 5 nomAula<String>");

        System.out.println("\t6) Setter nomDia RestriccioClasse:");
        System.out.println("\t\tformat: 6 nomDia<String>");

        System.out.println("\t7) Setter hora RestriccioClasse:");
        System.out.println("\t\tformat: 7 hora<Integer>");

        System.out.println("\t8) Sortir:");
        System.out.println("\t\tformat: 8");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        RestriccioClasse rc = null;
        String nomAula = null;
        String dia = null;
        int hora = -1;

        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while (opcio != 8) {
            try {
                switch (opcio) {
                    case 1:
                        nomAula = sc.next();
                        dia = sc.next();
                        hora = sc.nextInt();
                        rc = new RestriccioClasse(nomAula, dia, hora);

                        System.out.println("RestriccioClasse esperada: " + nomAula + ": " + dia + " de " + hora + ":00 a " + (hora + 1) + ":00");
                        System.out.println("RestriccioClasse creada: " + rc.toString());
                        break;
                    case 2:
                        if (rc == null) throw new NullPointerException();
                        System.out.println("Nom Aula RestriccioClasse esperat: " + nomAula);
                        System.out.println("Nom Aula RestriccioClasse obtingut: " + rc.getNomAula());
                        break;
                    case 3:
                        if (rc == null) throw new NullPointerException();
                        System.out.println("Dia RestriccioClasse esperat: " + dia);
                        System.out.println("Dia RestriccioClasse obtingut: " + rc.getDia());
                        break;
                    case 4:
                        if (rc == null) throw new NullPointerException();
                        System.out.println("Hora RestriccioClasse esperada: " + hora);
                        System.out.println("Hora RestriccioClasse obtinguda: " + rc.getHora());
                        break;
                    case 5:
                        nomAula = sc.next();
                        if (rc == null) throw new NullPointerException();
                        rc.setNomAula(nomAula);
                        if (nomAula.equals(rc.getNomAula()))
                            System.out.println("Nom Aula RestriccioClasse assignat correctament");
                        else System.out.println("Nom Aula RestriccioClasse NO assignat correctament");
                        break;
                    case 6:
                        dia = sc.next();
                        if (rc == null) throw new NullPointerException();
                        rc.setDia(dia);
                        if (dia.equals(rc.getDia())) System.out.println("Dia RestriccioClasse assignat correctament");
                        else System.out.println("Dia RestriccioClasse NO assignat correctament");
                        break;
                    case 7:
                        hora = sc.nextInt();
                        if (rc == null) throw new NullPointerException();
                        rc.setHora(hora);
                        if (hora == (rc.getHora())) System.out.println("Hora RestriccioClasse assignada correctament");
                        else System.out.println("Hora RestriccioClasse NO assignada correctament");
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
