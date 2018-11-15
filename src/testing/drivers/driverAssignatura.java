package testing.drivers;

import domini.Assignatura;
import testing.stubs.stubGrup;

import java.util.ArrayList;
import java.util.Scanner;

public class driverAssignatura {

    private static void menu() {
        System.out.println("Driver Assignatura:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 NomPlaEstudis<String> Nom<String> Fase<String>");

        System.out.println("\t2) Getter nomPlaEstudis assignatura:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter nom assignatura:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Getter fase assignatura:");
        System.out.println("\t\tformat: 4");

        System.out.println("\t5) Getter correquisits assignatura:");
        System.out.println("\t\tformat 5");

        System.out.println("\t6) Afegir correquisit assignatura:");
        System.out.println("\t\tformat 6 nomAssignatura<String>");

        System.out.println("\t7) Eliminar correquisit assignatura:");
        System.out.println("\t\tformat 7 nomAssignatura<String>");

        System.out.println("\t8) Comprovar si es correquisit assignatura:");
        System.out.println("\t\tformat 8 nomAssignatura<String>");

        System.out.println("\t9) Setter nomPlaEstudis PlaEstudis:");
        System.out.println("\t\tformat: 5 nomPlaEstudis<String>");

        System.out.println("\t10) Setter nom assignatura:");
        System.out.println("\t\tformat: 6 nom<String>");

        System.out.println("\t11) Setter fase assignatura:");
        System.out.println("\t\tformat: 7 fase<String>");

        System.out.println("\t12) Sortir:");
        System.out.println("\t\tformat: 12");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        Assignatura a = null;
        String nomPlaEstudis = null;
        String nom = null;
        String fase = null;
        ArrayList<String> correquisits= new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while(opcio!=12){
            try {
                switch (opcio) {
                    case 1:
                        nomPlaEstudis = sc.next();
                        nom = sc.next();
                        fase = sc.next();
                        a = new Assignatura(nomPlaEstudis,nom,fase);

                        System.out.println("Assignatura esperada: " + nomPlaEstudis+": "+nom+" ("+fase+")");
                        System.out.println("Assignatura creada: " + a.toString());
                        break;
                    case 2:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Nom plaEstudis esperat: " + nomPlaEstudis);
                        System.out.println("Nom plaEstudis obtingut: " + a.getNomPlaEstudis());
                        break;
                    case 3:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Nom assignatura esperat: " + nom);
                        System.out.println("Nom assignatura obtingut: " + a.getNom());
                        break;
                    case 4:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Fase assignatura esperada: " + fase);
                        System.out.println("Fase assignatura obtinguda: " + a.getFase());
                        break;
                    case 5:
                        if (a == null) throw new NullPointerException();
                        System.out.println("Correquisits assignatura esperadats: ");
                        for(String c:correquisits) System.out.println(c);
                        System.out.println("Correquisits assignatura obtinguts: ");
                        for(String c:a.getCorrequisits()) System.out.println(c);
                        break;
                    case 6:
                        String c=sc.next();
                        if (a == null) throw new NullPointerException();
                        correquisits.add(c);
                        a.afegirCorrequisit(c);
                        if (correquisits.equals(a.getCorrequisits())) System.out.println("Correquisit afegit correctament");
                        else System.out.println("Correquisit NO afegit correctament");
                        break;
                    case 7:
                        String c1=sc.next();
                        if (a == null) throw new NullPointerException();
                        correquisits.remove(c1);
                        a.eliminarCorrequisit(c1);
                        if (correquisits.equals(a.getCorrequisits())) System.out.println("Correquisit eliminat correctament");
                        else System.out.println("Correquisit NO eliminat correctament");
                        break;
                    case 8:
                        String c2=sc.next();
                        if (a == null) throw new NullPointerException();
                        if (a.esCorrequisit(c2).equals(correquisits.contains(c2))) {
                            System.out.println("Comprovació correcta");
                            if(correquisits.contains(c2)) System.out.println(c2+" es correquisit de "+nom);
                            if(!correquisits.contains(c2)) System.out.println(c2+" No es correquisit de "+nom);
                        }
                        else System.out.println("Comprovació errònia");
                        break;
                    case 9:
                        nomPlaEstudis = sc.next();
                        if (a == null) throw new NullPointerException();
                        a.setNomPlaEstudis(nomPlaEstudis);
                        if (nomPlaEstudis.equals(a.getNomPlaEstudis())) System.out.println("Nom plaEstudis assignat correctament");
                        else System.out.println("Nom plaEstudis NO assignat correctament");
                        break;
                    case 10:
                        nom = sc.next();
                        if (a == null) throw new NullPointerException();
                        a.setNom(nom);
                        if (nom.equals(a.getNom())) System.out.println("Nom assignatura assignat correctament");
                        else System.out.println("Nom assignatura NO assignat correctament");
                        break;
                    case 11:
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