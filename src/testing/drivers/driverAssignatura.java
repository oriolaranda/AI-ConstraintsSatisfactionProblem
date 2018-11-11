package testing.drivers;

import domini.Assignatura;

import java.util.Scanner;

public class driverAssignatura {

    private static void menu() {
        System.out.println("Driver Assignatura:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 NomPlaEstudis<String> Id<String> Fase<String>");

        System.out.println("\t2) Getter nomPlaEstudis assignatura:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter id assignatura:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Getter fase assignatura:");
        System.out.println("\t\tformat: 4");


        System.out.println("\t5) Setter nomPlaEstudis PlaEstudis:");
        System.out.println("\t\tformat: 5 nomPlaEstudis<String>");

        System.out.println("\t6) Setter id assignatura:");
        System.out.println("\t\tformat: 6 id<int>");

        System.out.println("\t7) Setter fase assignatura:");
        System.out.println("\t\tformat: 7 fase<String>");

        System.out.println("\t8) Sortir:");
        System.out.println("\t\tformat: 8");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        Assignatura a = null;
        String nomPlaEstudis = null;
        String id = null;
        String fase = null;

        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while(opcio!=8){
            try {
                switch (opcio) {
                    case 1:
                        nomPlaEstudis = sc.next();
                        id = sc.next();
                        fase = sc.next();
                        a = new Assignatura(nomPlaEstudis,id,fase);

                        System.out.println("Assignatura esperada: " + nomPlaEstudis+": "+id+" ("+fase+")");
                        System.out.println("Assignatura creada: " + a.toString());
                        break;
                    case 2:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Nom plaEstudis esperat: " + nomPlaEstudis);
                        System.out.println("Nom plaEstudis obtingut: " + a.getNomPlaEstudis());
                        break;
                    case 3:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Id assignatura esperat: " + id);
                        System.out.println("Id assignatura obtingut: " + a.getId());
                        break;
                    case 4:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Fase assignatura esperada: " + fase);
                        System.out.println("Fase assignatura obtinguda: " + a.getFase());
                        break;
                    case 5:
                        nomPlaEstudis = sc.next();
                        if (a == null) throw new NullPointerException();
                        a.setNomPlaEstudis(nomPlaEstudis);
                        if (nomPlaEstudis.equals(a.getNomPlaEstudis())) System.out.println("Nom plaEstudis assignat correctament");
                        else System.out.println("Nom plaEstudis NO assignat correctament");
                        break;
                    case 6:
                        id = sc.next();
                        if (a == null) throw new NullPointerException();
                        a.setId(id);
                        if (id.equals(a.getId())) System.out.println("Id assignatura assignat correctament");
                        else System.out.println("Id assignatura NO assignat correctament");
                        break;
                    case 7:
                        fase = sc.next();
                        if (a == null) throw new NullPointerException();
                        a.setFase(fase);
                        if (fase.equals(a.getFase())) System.out.println("Fase assignatura assignada correctament");
                        else System.out.println("Fase assignatura NO assignada correctament");
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