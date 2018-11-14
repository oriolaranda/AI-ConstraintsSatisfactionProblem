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
        String dia = null;
        int hora = -1;

        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while (opcio != 11) {
            try {
                switch (opcio) {
                    case 1:
                        nomAssignatura = sc.next();
                        numGrup =sc.nextInt();
                        dia = sc.next();
                        hora = sc.nextInt();
                        rgdh = new RestriccioGrupDiaHora(nomAssignatura, numGrup, dia, hora);

                        System.out.println("RestriccioGrupDiaHora esperada: "+nomAssignatura+"-"+numGrup+" "+dia+"de "+hora+":00 a" + (hora + 1) + ":00");
                        System.out.println("RestriccioGrupDiaHora creada: " + rgdh.toString());
                        break;
                    case 2:
                        if (rgdh == null) throw new NullPointerException();
                        System.out.println("NomAssignatura RestriccioGrupDiaHora esperat: " + nomAssignatura);
                        System.out.println("NomAssignatura RestriccioGrupDiaHora obtingut: " + rgdh.getNomAssignatura());
                        break;
                    case 3:
                        if (rgdh == null) throw new NullPointerException();
                        System.out.println("NumGrup RestriccioGrupDiaHora esperat: " + numGrup);
                        System.out.println("NumGrup RestriccioGrupDiaHora obtingut: " + rgdh.getNumGrup());
                        break;
                    case 4:
                        if (rgdh == null) throw new NullPointerException();
                        System.out.println("Dia RestriccioGrupDiaHora esperada: " + dia);
                        System.out.println("Dia RestriccioGrupDiaHora obtinguda: " + rgdh.getDia());
                        break;
                    case 5:
                        if (rgdh == null) throw new NullPointerException();
                        System.out.println("Hora RestriccioGrupDiaHora esperada: " + hora);
                        System.out.println("Hora RestriccioGrupDiaHora obtinguda: " + rgdh.getHora());
                        break;
                    case 6:
                        nomAssignatura = sc.next();
                        if (rgdh == null) throw new NullPointerException();
                        rgdh.setNomAssignatura(nomAssignatura);
                        if (nomAssignatura.equals(rgdh.getNomAssignatura()))
                            System.out.println("NomAssignatura RestriccioGrupDiaHora assignat correctament");
                        else System.out.println("NomAssignatura RestriccioGrupDiaHora NO assignat correctament");
                        break;
                    case 7:
                        numGrup = sc.nextInt();
                        if (rgdh == null) throw new NullPointerException();
                        rgdh.setNumGrup(numGrup);
                        if (numGrup==rgdh.getNumGrup()) System.out.println("NumGrup RestriccioGrupDiaHora assignat correctament");
                        else System.out.println("NumGrup RestriccioGrupDiaHora NO assignat correctament");
                        break;
                    case 8:
                        dia = sc.next();
                        if (rgdh == null) throw new NullPointerException();
                        rgdh.setDia(dia);
                        if (dia.equals(rgdh.getDia())) System.out.println("Dia RestriccioGrupDiaHora assignada correctament");
                        else System.out.println("Dia RestriccioGrupDiaHora NO assignada correctament");
                        break;
                    case 9:
                        hora = sc.nextInt();
                        if (rgdh == null) throw new NullPointerException();
                        rgdh.setHora(hora);
                        if (hora==rgdh.getHora()) System.out.println("Hora RestriccioGrupDiaHora assignat correctament");
                        else System.out.println("Hora RestriccioGrupDiaHora NO assignat correctament");
                        break;
                    case 10:
                        if (rgdh == null) throw new NullPointerException();
                        rgdh.precondicions();
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
