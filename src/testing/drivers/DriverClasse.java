package testing.drivers;

import domini.Aula;
import domini.Classe;
import domini.DiaHora;
import domini.TipusAula;

import java.util.Scanner;

import static domini.TipusAula.LABORATORI;
import static domini.TipusAula.TEORIA;
import static domini.TipusAula.stoTipusAula;
import static javafx.scene.input.KeyCode.T;

public class DriverClasse {
/*
    private static void menu() {
        System.out.println("Driver Classe:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 nomAula<String>  Dia<String> Hora<int>");

        System.out.println("\t2) Getter NomAula:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter Dia:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Getter Hora:");
        System.out.println("\t\tformat: 4");

        System.out.println("\t5) Setter NomAula");
        System.out.println("\t\tformat: 5 NomAula<String>");

        System.out.println("\t6) Setter Dia");
        System.out.println("\t\tformat: 6 Dia<String>");

        System.out.println("\t7) Setter Hora");
        System.out.println("\t\tformat: 7 Hora<int>");

        System.out.println("\t8) Sortir:");
        System.out.println("\t\tformat: 8");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        Classe c = null;

        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while (opcio != 8) {
            try {
                switch (opcio) {
                    case 1:
                        String nomAula = sc.next();
                        String dia = sc.next();
                        int hora = sc.nextInt();
                        c = new Classe(nomAula,dia,hora);
                        System.out.println("Classe creada: " + c.getNomAulaClasse() + " al " + c.getDiaClasse() + " a les " + c.getHoraClasse());
                        break;
                 /*   case 2:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Nom Aula obtinguda: " + c.getAula().getNom());
                        break;
                    case 3:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Dia obtingut: " + c.getHora().getDia() + " a les " + c.getHora().getHora());
                        break;*/
                    case 2:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Nom Aula: " + c.getNomAulaClasse());
                        break;
                    case 3:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Dia obtingut: " + c.getDiaClasse());
                        break;
                    case 4:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Hora obtinguda: " + c.getHoraClasse());
                        break;
                   /* case 7:
                        Aula a = null;
                        String nom = sc.next();
                        a.setNom(nom);
                        a.setCapacitat(sc.nextInt());
                        a.setTipus(stoTipusAula(sc.next()));
                        if (c == null) throw new NullPointerException();
                        //c.setAula(a);
                       // if (nom.equals(c.getAula())) System.out.println("Aula assignada correctament");
                        else System.out.println("Aula NO assignada correctament");
                        break;
                    case 8:
                        DiaHora d= null;
                        String day = sc.next();
                        int hour = sc.nextInt();
                        d.setDia(day);
                        d.setHora(hour);
                        if (c == null) throw new NullPointerException();
                        c.setHora(d);
                        if (day.equals(c.getHora().getDia()) && hour == c.getHora().getHora()) System.out.println("Dia i Hora assignats correctament");
                        else System.out.println("Dia i Hora NO assignats correctament");
                        break;*/
                    case 5:
                        nomAula = sc.next();
                        if (c == null) throw new NullPointerException();
                        c.setNomAulaClasse(nomAula);
                        if (nomAula.equals(c.getNomAulaClasse())) System.out.println("Nom Aula assignat correctament");
                        else System.out.println("Nom Aula NO assignat correctament");
                        break;
                    case 6:
                        dia = sc.next();
                        if (c == null) throw new NullPointerException();
                        c.setDiaClasse(dia);
                        if (dia.equals(c.getDiaClasse())) System.out.println("Nom Aula assignat correctament");
                        else System.out.println("Nom Aula NO assignat correctament");
                        break;
                    case 7:
                        hora = sc.nextInt();
                        if (c == null) throw new NullPointerException();
                        c.setHoraClasse(hora);
                        if (hora == c.getHoraClasse()) System.out.println("Nom Aula assignat correctament");
                        else System.out.println("Nom Aula NO assignat correctament");
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
