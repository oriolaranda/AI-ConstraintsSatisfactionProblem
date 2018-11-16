package testing.drivers;

import domini.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import testing.stubs.stubClasse;
import testing.stubs.stubHorari;
import testing.stubs.stubRestriccio;
import testing.stubs.stubSessio;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

public class HorariTest {
    private Horari h;
    private ArrayList<Sessio> sessions;
    private Vector<Classe> classes;
    private ArrayList<Restriccio> restriccions;
    private Map<Sessio, Vector<Classe>> prev;
    private Map<Classe, Sessio> nou;


    public HorariTest(){
        sessions = new ArrayList<>();
        sessions.add(new stubSessio());

        classes = new Vector<>();
        classes.add(new stubClasse());

        restriccions = new ArrayList<>();
        restriccions.add(new stubRestriccio());

        prev = new HashMap<>();
        prev.put(new stubSessio(), classes);

        nou = new HashMap<>();
        nou.put(new stubClasse(), new stubSessio());

        h = new Horari("H0",sessions, classes, restriccions);
    }
    @BeforeClass
    public static void beforeClass() {
        System.out.println("HORARITEST JUNIT HORARI");
        System.out.println("JUnit de la classe Horari. Testos de totes les seves funcions");

    }
    @AfterClass
    public static void afterClass(){
        System.out.println("TESTOS FINALITZATS OK!");
    }
    @Test
    public void constructora1() {
        assertNotNull("Creadora 1 incorrecte!",new Horari("H1"));
    }

    @Test
    public void construtora2() {
        assertNotNull("Creadora 2 incorrecte!",new Horari("H2",null, null, null ));
    }

    @Test
    public void getNom() {
        assertEquals("getNom incorrecte!", h.getNom(), "H0");
    }

    @Test
    public void getSessions() {
        assertEquals("getSessions incorrecte!",sessions, h.getSessions());
    }
    @Test
    public void getClasses() {
        assertEquals("getClasses incorrecte!",classes, h.getClasses());
    }
    @Test
    public void getRestriccions() {
        assertEquals("getRestriccions incorrecte!",restriccions, h.getRestriccions());
    }

    @Test
    public void getPle() {
        assertSame("getPle incorrecte!",false,h.getPle());
    }

    @Test
    public void getNou() {
        h.generar_horari();
        assertEquals("getNou incorrecte!",nou,h.getNou());
    }

    @Test
    public void getPrev() {
        h.generar_horari();
        assertEquals("getPrev incorrecte!",prev,h.getPrev());
    }

    @Test
    public void setNom() {
        h.setNom("H3");
        assertEquals("setNom incorrecte!","H3",h.getNom());
    }
    @Test
    public void setSessions() {
        Horari horari = new Horari("H4"); //sessions = null
        horari.setSessions(sessions);
        assertEquals("setSessions incorrecte!",sessions, horari.getSessions());
    }

    @Test
    public void setRestriccions() {
        Horari horari = new Horari("H4"); //restriccions = null
        horari.setRestriccions(restriccions);
        assertEquals("setRestriccions incorrecte!",restriccions, horari.getRestriccions());
    }

    @Test
    public void setClasses() {
        Horari horari = new Horari("H4"); // classes = null
        horari.setClasses(classes);
        assertEquals("setClasses incorrecte!",classes, horari.getClasses());
    }

    @Test
    public void setPle() {
        h.setPle(true);
        assertEquals("setPle incorrecte!", true,h.getPle());
    }

    @Test
    public void generarHorari() {
        Horari horari = new Horari("H5", sessions, classes, restriccions);
        assertEquals(false,horari.getPle());
        horari.generar_horari();
        assertEquals("generarHorari incorrecte!",true,horari.getPle());
    }

    @Test
    public void add_sessio() {
        Horari horari = new Horari("H5");
        horari.add_sessio(new stubSessio());
        assertEquals("add_sessio incorrecte!",new stubSessio(), horari.getSessions().get(0));
    }

    @Test
    public void remove_sessio() {
        Horari horari = new Horari("H5", sessions, null, null);
        assertNotNull(horari.getSessions());
        horari.remove_sessio(new stubSessio());
        assertEquals("remove_sessio incorrecte!",new ArrayList<>(), horari.getSessions());
    }
    @Test
    public void add_classe() {
        Horari horari = new Horari("H5");
        horari.add_classe(new stubClasse());
        assertEquals("add_classe incorrecte!",new stubClasse(), horari.getClasses().get(0));
    }
    @Test
    public void remove_classe() {
        Horari horari = new Horari("H5", null, classes, null);
        assertNotNull(horari.getClasses());
        horari.remove_classe(new stubClasse());
        assertEquals("remove_classe incorrecte!",new Vector<>(), horari.getClasses());
    }
    @Test
    public void add_restriccio() {
        Horari horari = new Horari("H5");
        horari.add_restriccio(new stubRestriccio());
        assertEquals("add_restriccio incorrecte!",new stubRestriccio(), horari.getRestriccions().get(0));
    }
    @Test
    public void remove_restriccio() {

        Horari horari = new Horari("H5", null, null, restriccions);
        assertNotNull(horari.getRestriccions());
        horari.remove_restriccio(new stubRestriccio());
        assertEquals("remove_restriccio incorrecte!",new ArrayList<>(), horari.getRestriccions());
    }

}
