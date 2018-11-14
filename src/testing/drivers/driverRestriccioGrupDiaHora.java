package testing.drivers;

import domini.RestriccioGrupDiaHora;
import java.util.Scanner;


public class driverRestriccioGrupDiaHora {
    private static void menu() {
        System.out.println("Driver RestriccioGrupDiaHora:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 nomAssignatura<String> numGrup<Integer> dia<String> hora<Integer>");

        System.out.println("\t2) Getter nomAssignatura RestriccioGrupDiaHora:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter numGrup RestriccioGrupDiaHora:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Getter dia RestriccioGrupDiaHora:");
        System.out.println("\t\tformat: 4");

        System.out.println("\t5) Getter hora RestriccioGrupDiaHora:");
        System.out.println("\t\tformat: 5");

        System.out.println("\t6) Setter nomAssignatura RestriccioGrupDiaHora:");
        System.out.println("\t\tformat: 6 nomAssignatura<String>");

        System.out.println("\t7) Setter numGrup RestriccioGrupDiaHora:");
        System.out.println("\t\tformat: 7 numGrup<Integer>");

        System.out.println("\t8) Setter dia RestriccioGrupDiaHora:");
        System.out.println("\t\tformat: 8 dia<String>");

        System.out.println("\t9) Setter hora RestriccioGrupDiaHora:");
        System.out.println("\t\tformat: 9 hora<Integer>");

        System.out.println("\t10) precondicions//Elimina de l'estructura de dades les classes de les sessions del grup especificat en un dia i hora donats");
        System.out.println("\t\tformat: 10");

        System.out.println("\t11) Sortir:");
        System.out.println("\t\tformat: 11");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        RestriccioGrupDiaHora rgdh = null;
        String nomAssignatura = null;
        int numGrup = -1;
        String
        int hora = -1;

        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while (opcio != 9) {
            try {
                switch (opcio) {
                    case 1:
                        nomAula = sc.next();
                        dia = sc.next();
                        hora = sc.nextInt();
                        rc = new RestriccioClasse(nomAula, dia, hora);

                        System.out.println("RestriccioClasse esperada: " + nomAula + ": " + dia + " de " + hora + ":00 a" + (hora + 1) + ":00");
                        System.out.println("RestriccioClasse creada: " + rc.toString());
                        break;
                    case 2:
                        if (rc == null) throw new NullPointerException();
                        System.out.println("Nom Aula classe esperat: " + nomAula);
                        System.out.println("Nom Aula classe obtingut: " + rc.getNomAula());
                        break;
                    case 3:
                        if (rc == null) throw new NullPointerException();
                        System.out.println("Dia classe esperat: " + dia);
                        System.out.println("Dia classe obtingut: " + rc.getDia());
                        break;
                    case 4:
                        if (rc == null) throw new NullPointerException();
                        System.out.println("Hora classe esperada: " + hora);
                        System.out.println("Hora classe obtinguda: " + rc.getHora());
                        break;
                    case 5:
                        nomAula = sc.next();
                        if (rc == null) throw new NullPointerException();
                        rc.setNomAula(nomAula);
                        if (nomAula.equals(rc.getNomAula()))
                            System.out.println("Nom Aula classe assignat correctament");
                        else System.out.println("Nom Aula classe NO assignat correctament");
                        break;
                    case 6:
                        dia = sc.next();
                        if (rc == null) throw new NullPointerException();
                        rc.setDia(dia);
                        if (dia.equals(rc.getDia())) System.out.println("Dia classe assignat correctament");
                        else System.out.println("Dia classe NO assignat correctament");
                        break;
                    case 7:
                        hora = sc.nextInt();
                        if (rc == null) throw new NullPointerException();
                        rc.setHora(hora);
                        if (hora == (rc.getHora())) System.out.println("Hora classe assignada correctament");
                        else System.out.println("Hora classe NO assignada correctament");
                        break;
                    case 8:
                        if (rc == null) throw new NullPointerException();
                        rc.precondicions();
                        System.out.println("Ja s'han eliminat els dominis de les variables que satisfeien la restriccio");
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
