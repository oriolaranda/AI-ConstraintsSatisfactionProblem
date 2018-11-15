package testing.drivers;




import domini.Assignatura;
import domini.Grup;
import domini.PlaEstudis;
import testing.stubs.stubAssignatura;
import testing.stubs.stubHorari;

import java.util.LinkedList;
import java.util.Scanner;

import static domini.TipusAula.stoTipusAula;

public class driverPlaEstudis {
    private static void menu() {
        System.out.println("Driver PlaEstudis:");
        System.out.println("Opcions:");
        System.out.println("\t1) Constructora:");
        System.out.println("\t\tformat: 1 nomPlaEstudis<String> periodeLectiu<int int>");

        System.out.println("\t2) Getter nom pla estudis:");
        System.out.println("\t\tformat: 2");

        System.out.println("\t3) Getter periode lectiu:");
        System.out.println("\t\tformat: 3");

        System.out.println("\t4) Getter assignatures:");
        System.out.println("\t\tformat: 4");

        System.out.println("\t5) Getter horari:");
        System.out.println("\t\tformat: 5");

        System.out.println("\t6) Setter nom pla estudis:");
        System.out.println("\t\tformat: 6 nomPlaEstudis<String>");

        System.out.println("\t7) Setter periode lectiu:");
        System.out.println("\t\tformat: 7 periodeLectiu<int int>");

        System.out.println("\t8) Afegir assignatura:");
        System.out.println("\t\tformat: 8");

        System.out.println("\t9) Esborrar assignatura:");
        System.out.println("\t\tformat: 9");

        System.out.println("\t10) Afegir horari:");
        System.out.println("\t\tformat: 10");


        System.out.println("\t11) Sortir:");
        System.out.println("\t\tformat: 11");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {
        PlaEstudis pe = null;
        String nom = null;
        int[] periodeLectiu = new int[] {0,0};
        stubHorari horari = new stubHorari();
        stubAssignatura assig = new stubAssignatura();
        LinkedList<stubAssignatura> assignatures = new LinkedList<stubAssignatura>();
        Scanner sc = new Scanner(System.in);
        menu();
        int opcio = sc.nextInt();

        while (opcio != 11) {
            try {
                switch (opcio) {
                    case 1:
                        nom = sc.next();
                        periodeLectiu[0] = sc.nextInt();
                        periodeLectiu[1] = sc.nextInt();
                        pe = new PlaEstudis(nom, periodeLectiu);
                        System.out.println("Periode Lectiu esperat: " + nom + " " + "periode lectiu "+periodeLectiu[0] + "h-" + periodeLectiu[1]+"h");
                        System.out.println("Periode Lectiu obtingut: " + pe.toString());
                        break;
                    case 2:
                        if (pe == null) throw new NullPointerException();
                        System.out.println("Nom pla estudis esperat: " + nom);
                        System.out.println("Nom pla estudis obtingut: " + pe.getNom());
                        break;
                    case 3:
                        if (pe == null) throw new NullPointerException();
                        System.out.println("Periode lectiu esperat: " + periodeLectiu[0]+"h-"+periodeLectiu[1]+"h");
                        System.out.println("Periode lectiu obtingut: " + pe.getPeriodeLectiu()[0]+"h-"+pe.getPeriodeLectiu()[1]+"h");
                        break;
                    case 4:
                        if (pe == null) throw new NullPointerException();
                        if (!pe.getAssignatures().contains(assig)) assignatures.add(assig);
                        System.out.println("Assignatures esperades: " + assignatures);
                        System.out.println("Assignatures obtingudes: " + pe.getAssignatures());

                        break;
                    case 5:
                        if (pe == null) throw new NullPointerException();
                        System.out.println("Horari esperat: " + horari);
                        System.out.println("Horari obtingut: " + pe.getHorari());
                        break;
                    case 6:
                        nom = sc.next();
                        if (pe == null) throw new NullPointerException();
                        pe.setNom(nom);
                        System.out.println("Nom esperat: " + nom);
                        System.out.println("Nom obtingut: " + pe.getNom());
                        break;
                    case 7:
                        periodeLectiu[0] = sc.nextInt();
                        periodeLectiu[1] = sc.nextInt();
                        if (pe == null) throw new NullPointerException();
                        pe.setPeriodeLectiu(periodeLectiu[0],periodeLectiu[1]);
                        System.out.println("Periode lectiu esperat: " + periodeLectiu[0]+"h-"+periodeLectiu[1]+"h");
                        System.out.println("Periode lectiu obtingut: " + pe.getPeriodeLectiu()[0] +"h-" +pe.getPeriodeLectiu()[1]+"h");
                        break;
                    case 8:
                        if (pe == null) throw new NullPointerException();
                        if (!pe.getAssignatures().contains(assig)) pe.addAssignatura(assig);
                        if (pe.getAssignatures().contains(assig)) System.out.println("Assignatura afegida correctament");
                        else System.out.println("Assignatura NO afegida correctament");
                        pe.removeAssignatura(assig);
                        break;
                    case 9:
                        if (pe == null) throw new NullPointerException();
                        if (!pe.getAssignatures().contains(assig)) pe.addAssignatura(assig);
                        pe.removeAssignatura(assig);
                        if (!pe.getAssignatures().contains(assig)) System.out.println("Assignatura esborrada correctament");
                        else System.out.println("Assignatura NO esborrada correctament");
                        break;
                    case 10:
                        if (pe == null) throw new NullPointerException();
                        if (pe.getHorari() == null) pe.addHorari(new stubHorari());
                        if (pe.getHorari() != null) System.out.println("Horari afegit correctament");
                        else System.out.println("Horari NO afegit correctament");
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
