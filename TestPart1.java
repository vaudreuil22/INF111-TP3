
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import clinique.Calendrier;

import clinique.Docteur;
import clinique.Identification;
import clinique.Infirmier;
import clinique.Patient;
import clinique.RendezVous;



public class TestPart1 {

    @Test
    public void testAjouterRendezVous() {

        Docteur d = new Docteur(new Identification("f", "b"), 0);
        Infirmier i = new Infirmier(new Identification("p", "b"), true);
        Patient p = new Patient(new Identification("m", "n"), "asd");


        Docteur dd = new Docteur(new Identification("xx", "yy"), 0);
        Infirmier ii = new Infirmier(new Identification("aa", "bb"), true);
        Patient pp = new Patient(new Identification("zz", "zz"), "asd");

        Calendar d1 = Calendar.getInstance();
        Calendar d2 = Calendar.getInstance();
        Calendar d3 = Calendar.getInstance();

        d1.set(1900 + 112, 2, 2, 12, 00);
        d2.set(1900 + 112, 2, 2, 13, 00);

        RendezVous rdv1 = new RendezVous(d, p, i);
        RendezVous rdv2 = new RendezVous(dd, pp, ii);

        Calendrier c = new Calendrier();
        c.creerPlageHoraire(d1);
        c.creerPlageHoraire(d2);
        c.creerPlageHoraire(d3);
        
        // 12:00 -> OK
        assertTrue(c.ajouterRdv(d1, rdv1));
        assertEquals(1, c.getPlageHoraire(d2).getNbRendezVous());

        // Meme rdv; pas possible
        assertFalse(c.ajouterRdv(d1, rdv1));

        // 13:00 -> ok
        assertTrue(c.ajouterRdv(d2, rdv1));

        // 13:00, avec un autre medecin et infirmier
        assertTrue(c.ajouterRdv(d2, rdv2));

        // Check les prochains rdvs
        assertEquals(rdv1, c.getPlageHoraire(d2).getRendezVous().get(0));
        assertEquals(rdv2, c.getPlageHoraire(d2).getRendezVous().get(1));
        
        c.annulerRdv(rdv1);
        assertEquals(rdv2, c.getPlageHoraire(d2).getRendezVous().get(0));
    }

}
