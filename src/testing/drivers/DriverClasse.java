package testing.drivers;

import domini.Aula;
import domini.Classe;
import domini.DiaHora;


import java.util.Scanner;


import static domini.TipusAula.TEORIA;
import static domini.TipusAula.stoTipusAula;
import static javafx.scene.input.KeyCode.T;

public class DriverClasse {

    private static void menu() {
        System.out.println("Driver Classe:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 nomAula<String>  Dia<String> Hora<int>");

        System.out.println("\t2) Getter Aula:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter DiaHora:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Setter Aula:");
        System.out.println("\t\tformat: 4 nomAula<String> capacitat<int> tipusAula<TipusAula>");

        System.out.println("\t5) Setter Dia");
        System.out.println("\t\tformat: 5 Dia<String> Hora<int>");

        System.out.println("\t6) Getter NomAula:");
        System.out.println("\t\tformat: 6");

        System.out.println("\t7) Getter Dia:");
        System.out.println("\t\tformat: 7");

        System.out.println("\t8) Getter Hora:");
        System.out.println("\t\tformat: 8");

        System.out.println("\t9) Sortir:");
        System.out.println("\t\tformat: 9");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        Classe c = null;
        Aula a;
        DiaHora d;

        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while (opcio != 9) {
            try {
                switch (opcio) {
                    case 1:
                        a = new Aula(sc.next(),60,TEORIA);
                        d = new DiaHora(sc.next(),sc.nextInt());
                        c = new Classe(a,d);
                        System.out.println("Classe creada: " + c.getAula().getNom() + " al " + c.getHora().getDia() + " a les " + c.getHora().getHora());
                        break;
                    case 2:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Nom Aula obtinguda: " + c.getAula().getNom());
                        break;
                    case 3:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Dia obtingut: " + c.getHora().getDia() + " a les " + c.getHora().getHora());
                        break;
                    case 4:
                        a = c.getAula();
                        String nomAula = sc.next();
                        a.setNom(nomAula);
                        a.setCapacitat(sc.nextInt());
                        a.setTipus(stoTipusAula(sc.next()));
                        if (c == null) throw new NullPointerException();
                        c.setAula(a);
                        if (nomAula.equals(c.getNomAulaClasse())) System.out.println("Aula assignada correctament");
                        else System.out.println("Aula NO assignada correctament");
                        break;
                    case 5:
                        d = c.getHora();
                        String dia = sc.next();
                        int hora = sc.nextInt();
                        d.setDia(dia);
                        d.setHora(hora);
                        if (c == null) throw new NullPointerException();
                        c.setHora(d);
                        if (dia.equals(c.getDiaClasse()) && hora == c.getHoraClasse()) System.out.println("Dia i Hora assignats correctament");
                        else System.out.println("Dia i Hora NO assignats correctament");
                        break;
                    case 6:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Nom Aula: " + c.getNomAulaClasse());
                        break;
                    case 7:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Dia obtingut: " + c.getDiaClasse());
                        break;
                    case 8:
                        if (c == null) throw new NullPointerException();
                        System.out.println("Hora obtinguda: " + c.getHoraClasse());
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
