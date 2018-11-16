package testing.drivers;

import domini.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import static domini.TipusAula.stoTipusAula;

public class driverControlador {
    private static void menu() {
        System.out.println("Driver Controlador:");
        System.out.println("Opcions:");
        System.out.println("\t1) Crear Pla:");
        System.out.println("\t\tformat: 1 NomPlaEstudis<String> HoraInicial<int> HoraFinal<int>     //Valors entre 0-24 HoraInicial < HoraFinal");

        System.out.println("\t2) Crear Assignatura:");
        System.out.println("\t\tformat: 2 NomAssignatura<String> Fase<String> CapacitatGrup<int> CapacitatSubgrups<int> matriculats<int> TipusAula<TipusAula> numeroSessionsPerGrup<int> duracioSessions<int>  numAssignaturesSonCorrequisit Correqusist1<String> Correquisit2<int> ... CorrequisitN<String>     //Fase es el nom del nivell");

        System.out.println("\t3) Crear Aula:");
        System.out.println("\t\tformat: 3 NomAula<String> Capacitat<int> TipusAula<TipusAula>");

        System.out.println("\t4) Afegir restriccio de tipus:");
        System.out.println("\t\tformat: 4 1   //Activar o desactivar RestriccioFase per tenir en compte els nivells de les assignatures");
        System.out.println("\t\tformat: 4 2   //Activar o desactivar RestriccioCorrequisits per tenir en compte correquisits entre Assignatures");
        System.out.println("\t\tformat: 4 3   //Activar o desactivar RestriccioTipusAula");
        System.out.println("\t\tformat: 4 4   //Activar o desactivar RestriccioCapacitat");
        System.out.println("\t\tformat: 4 5   nomAssignatura<String> numGrup<int> dia<String> hora<int>     //Activar o desactivar RestriccioGrupDiaHora per bloquejar que un grup fagi classe a un Dia i Hora concrets");
        System.out.println("\t\tformat: 4 6   nomAula<String> Dia<String> Hora<int>    //Activar o desactivar RestriccioClasse per bloquejar una Aula en un dia i hora concrets");

        System.out.println("\t5) Generar Horari");
        System.out.println("\t\tformat: 5");

        System.out.println("\t6) Sortir:");
        System.out.println("\t\tformat: 6");

        System.out.println("Introdueix una opcio amb el seu format:");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        menu();
        CtrlDominio C = new CtrlDominio();
        int opcio = sc.nextInt();
        int opcio2;

        while(opcio!=6){
            try {
                switch (opcio) {
                    case 1:
                        String nom = sc.next();
                        int horaIni = sc.nextInt();
                        int horaFi = sc.nextInt();
                        if (horaIni >= horaFi || horaFi > 24 || horaIni < 0 || horaFi < 0 || horaIni > 24)
                            System.out.println("Valors entre 0-24 i HoraInicial < HoraFinal");
                        else {
                            C.crear_pla(nom, horaIni, horaFi);
                            System.out.println("Pla Esperat: " + nom + " comença a les " + horaIni + " i acaba a les " + horaFi);
                            System.out.println("Pla Obtingut: " + C.getPla().getNom() + " comença a les " + C.getPla().getPeriodeLectiu()[0] + " i acaba a les " + C.getPla().getPeriodeLectiu()[1]);
                        }
                        break;
                    case 2:
                        if (C == null) throw new NullPointerException();
                        String n = sc.next();
                        String f = sc.next();
                        int Cap = sc.nextInt();
                        int CapS = sc.nextInt();
                        int mat = sc.nextInt();
                        TipusAula t = stoTipusAula(sc.next());
                        int num = sc.nextInt();
                        int dur = sc.nextInt();
                        int co = sc.nextInt();
                        Vector<String> v = new Vector<String>();
                        for (int i = 0; i < co; ++i) {
                            String aux = sc.next();
                            v.add(aux);
                        }
                        C.crear_assignatura(n, f, Cap, CapS, mat, t, num, dur,v);
                        //System.out.println("Assignatura: " + C.getHorari().getSessions().get(3).getNomAssignaturaSessio() + " " + C.getHorari().getSessions().get(3).getNumGrupSessio() + " " + C.getHorari().getSessions().get(3).getNum());
                        break;
                    case 3:
                        if (C == null) throw new NullPointerException();
                        C.crear_aula(sc.next(), sc.nextInt(), stoTipusAula(sc.next()));
                       // System.out.println("Classe: " + C.getHorari().getClasses().get(3).getNomAulaClasse() + " " + C.getHorari().getClasses().get(3).getDiaClasse() + " " + C.getHorari().getClasses().get(3).getHoraClasse());

                        break;
                    case 4:
                        if (C == null) throw new NullPointerException();
                        opcio2 = sc.nextInt();
                        String active;
                        Restriccio aux;
                        ArrayList<Restriccio> r = new ArrayList<Restriccio>();
                        switch (opcio2) {
                            case 1:
                                aux = new RestriccioFase();
                                aux.setHorari(C.getHorari());
                                r.add(aux);
                                System.out.println("Restriccio Fase modificada");
                                break;
                            case 2:
                                aux = new RestriccioCorrequisit();
                                aux.setHorari(C.getHorari());
                                r.add(aux);
                                System.out.println("Restriccio Correquisit modificada");
                                break;
                            case 3:
                                aux = new RestriccioTipusAula();
                                aux.setHorari(C.getHorari());
                                r.add(aux);
                                System.out.println("Restriccio TipusAula modificada");
                                break;
                            case 4:
                                aux = new RestriccioCapacitat();
                                aux.setHorari(C.getHorari());
                                r.add(aux);
                                System.out.println("Restriccio Capacitat modificada");
                                break;
                            case 5:
                                String assig = sc.next();
                                int grup = sc.nextInt();
                                String day = sc.next();
                                int hour = sc.nextInt();
                                aux = new RestriccioGrupDiaHora(assig,grup,day,hour);
                                aux.setHorari(C.getHorari());
                                r.add(aux);
                                System.out.println("Restriccio Classe modificada");
                                break;
                            case 6:
                                String aula = sc.next();
                                String day2 = sc.next();
                                int hour2 = sc.nextInt();
                                aux = new RestriccioClasse(aula,day2,hour2);
                                aux.setHorari(C.getHorari());
                                r.add(aux);
                                System.out.println("Restriccio Classe modificada");
                                break;
                        }
                        C.crear_restriccions(r);
                        break;
                    case 5:
                        if (C == null) throw new NullPointerException();
                        C.generar_horari();
                        C.print_horari();
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
