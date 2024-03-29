package partita;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import classiDMN.Carta;
import classiDMN.Giocatore;
import classiDMN.Turno;

public class BriscolaTest {
	private Modello scenario;

	 @Before
	    public void init() {
	      scenario=new Modello();
	    }
	 @Test
	    public void testStessoSemeNoPunti() {
	      Carta carta1= new Carta("7", "Cuori", 0);
	      Carta carta2=new Carta("5","Cuori",0);
	     
	      ArrayList<Carta> mano1=new ArrayList<Carta>();
	      mano1.add(new Carta("K", "Fiori",4));mano1.add(new Carta("6","Fiori",0));
	      Giocatore giocatore1= new Giocatore("Mario", 0, mano1);
	      
	      ArrayList<Carta> mano2=new ArrayList<Carta>();
	      mano2.add(new Carta("Q", "Fiori",3));mano2.add(new Carta("2","Fiori",0));
	      Giocatore giocatore2= new Giocatore("Giovanni", 0, mano2);
	      
	      Turno turno= new Turno(carta1, carta2, "Fiori");
	      scenario.esecuzioneModello(turno, giocatore1, giocatore2);
	      Giocatore vincitore=scenario.vincitoreTurno();
	      
	      assertEquals("Mario", vincitore.getNome());
	      assertEquals(0,vincitore.getPunti());
	      assertEquals(2,vincitore.getMano().size());
	      assertThat(vincitore.getMano()).isEqualTo(mano1);
	    }

	 @Test
	 public void testStessoSemePunti() {
	      Carta carta1= new Carta("6", "Fiori", 0);
	      Carta carta2=new Carta("A","Fiori",11);
	      
	      ArrayList<Carta> mano1=new ArrayList<Carta>();
	      mano1.add(new Carta("K", "Fiori",4));mano1.add(new Carta("6","Fiori",0));
	      Giocatore giocatore1= new Giocatore("Mario", 0, mano1);
	      
	      ArrayList<Carta> mano2=new ArrayList<Carta>();
	      mano2.add(new Carta("Q", "Fiori",3));mano2.add(new Carta("2","Fiori",0));
	      Giocatore giocatore2= new Giocatore("Giovanni", 0, mano2);
	      
	      Turno turno= new Turno(carta1, carta2, "Picche");
	      scenario.esecuzioneModello(turno, giocatore1, giocatore2);
	      Giocatore vincitore=scenario.vincitoreTurno();
	     
	      assertEquals("Giovanni", vincitore.getNome());
	      assertEquals(11,vincitore.getPunti());
	      assertEquals(2,vincitore.getMano().size());
	      assertThat(vincitore.getMano()).isEqualTo(mano2);
	      
	 }

	 @Test
	 public void testSemeBriscola() {
	      Carta carta1= new Carta("K", "Cuori", 4);
	      Carta carta2=new Carta("5","Fiori",0);
	      
	      ArrayList<Carta> mano1=new ArrayList<Carta>();
	      mano1.add(new Carta("K", "Fiori",4));mano1.add(new Carta("6","Fiori",0));
	      Giocatore giocatore1= new Giocatore("Mario", 0, mano1);
	      
	      ArrayList<Carta> mano2=new ArrayList<Carta>();
	      mano2.add(new Carta("Q", "Fiori",3));mano2.add(new Carta("2","Fiori",0));
	      Giocatore giocatore2= new Giocatore("Giovanni", 0, mano2);
	      
	      Turno turno= new Turno(carta1, carta2, "Fiori");
	      scenario.esecuzioneModello(turno, giocatore1, giocatore2);
	      Giocatore vincitore=scenario.vincitoreTurno();
	      
	      assertEquals("Giovanni", vincitore.getNome());
	      assertEquals(4,vincitore.getPunti());
	      assertEquals(2,vincitore.getMano().size());
	      assertThat(vincitore.getMano()).isEqualTo(mano2);
	    }
	 @Test
	 public void testSemeDiverso() {
	      Carta carta1= new Carta("A", "Cuori", 11);
	      Carta carta2=new Carta("J","Fiori",2);
	      
	      ArrayList<Carta> mano1=new ArrayList<Carta>();
	      mano1.add(new Carta("K", "Fiori",4));mano1.add(new Carta("6","Fiori",0));
	      Giocatore giocatore1= new Giocatore("Mario", 15, mano1);
	      
	      ArrayList<Carta> mano2=new ArrayList<Carta>();
	      mano2.add(new Carta("Q", "Fiori",3));mano2.add(new Carta("2","Fiori",0));
	      Giocatore giocatore2= new Giocatore("Giovanni", 3, mano2);
	      
	      Turno turno= new Turno(carta1, carta2, "Quadri");
	      scenario.esecuzioneModello(turno, giocatore1, giocatore2);
	      
	      Giocatore vincitore=scenario.vincitoreTurno();
	      assertEquals("Mario", vincitore.getNome());
	      assertEquals(28,vincitore.getPunti());
	      assertEquals(2,vincitore.getMano().size());
	      assertThat(vincitore.getMano()).isEqualTo(mano1);
	    }

		@Test
	 public void testSemeDiversoStessoValore() {
	      Carta carta1= new Carta("A", "Cuori", 11);
	      Carta carta2=new Carta("A","Fiori",11);
	      
	      ArrayList<Carta> mano1=new ArrayList<Carta>();
	      mano1.add(new Carta("K", "Fiori",4));mano1.add(new Carta("6","Fiori",0));
	      Giocatore giocatore1= new Giocatore("Mario", 15, mano1);
	      
	      ArrayList<Carta> mano2=new ArrayList<Carta>();
	      mano2.add(new Carta("Q", "Fiori",3));mano2.add(new Carta("2","Fiori",0));
	      Giocatore giocatore2= new Giocatore("Giovanni", 3, mano2);
	      
	      Turno turno= new Turno(carta1, carta2, "Quadri");
	      scenario.esecuzioneModello(turno, giocatore1, giocatore2);
	      
	      Giocatore vincitore=scenario.vincitoreTurno();
	      assertEquals("Mario", vincitore.getNome());
	      assertEquals(37,vincitore.getPunti());
	      assertEquals(2,vincitore.getMano().size());
	      assertThat(vincitore.getMano()).isEqualTo(mano1);
	    }
	 @Test
	 public void testPartitaNonConclusa() {
	      Carta carta1= new Carta("A", "Cuori", 11);
	      Carta carta2=new Carta("J","Fiori",2);
	     
	      Giocatore giocatore1= new Giocatore("Mario", 15, new ArrayList<Carta>());
	      
	      Giocatore giocatore2= new Giocatore("Giovanni", 3, new ArrayList<Carta>());
	      
	      Turno turno= new Turno(carta1, carta2, "Quadri");
	      scenario.esecuzioneModello(turno, giocatore1, giocatore2);
	      assertEquals("La partita non è conclusa",scenario.esitoPartita());
	    }
	 
	 @Test
	 public void testVincitorePartita() {
	      Carta carta1= new Carta("A", "Cuori", 11);
	      Carta carta2=new Carta("J","Fiori",2);
	      
	      Giocatore giocatore1= new Giocatore("Mario", 60, new ArrayList<Carta>());
	      
	     
	    
	      Giocatore giocatore2= new Giocatore("Giovanni", 47, new ArrayList<Carta>());
	      
	      Turno turno= new Turno(carta1, carta2, "Quadri");
	      scenario.esecuzioneModello(turno, giocatore1, giocatore2);
	      assertEquals("Ha vinto la partita Mario",scenario.esitoPartita());
	    }
	 @Test
	 public void testPareggioPartita() {
	      Carta carta1= new Carta("J","Fiori",2);
	      Carta carta2=new Carta("A", "Quadri", 11);
	      
	      Giocatore giocatore1= new Giocatore("Mario", 60, new ArrayList<Carta>());
	  
	    
	      Giocatore giocatore2= new Giocatore("Giovanni", 47, new ArrayList<Carta>());
	      
	      Turno turno= new Turno(carta1, carta2, "Quadri");
	      scenario.esecuzioneModello(turno, giocatore1, giocatore2);
	      assertEquals("La partita è finita in pareggio",scenario.esitoPartita());
	    }
}
