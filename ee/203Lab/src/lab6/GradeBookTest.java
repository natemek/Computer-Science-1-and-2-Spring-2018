package lab6;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeBookTest {
	GradeBook g1,g2;


	@Before
	public void setUp() throws Exception {
		g2 = new GradeBook(5);
		g1 = new GradeBook(5);
		g1.addScore(50);	
		g1.addScore(75);
		g2.addScore(50);
		g2.addScore(75);

	}

	@After
	public void tearDown() throws Exception {
		g1 = g2 =null;
	}

	@Test
	public void testAddScore() {
		assertTrue(g1.toString().equals("50.0 75.0 "));	
		g1.addScore(50);	
		assertTrue(g1.toString().equals("50.0 75.0 50.0 "));	
		}

	@Test
	public void testSum() {
		assertEquals(125, g1.sum(), .0001);
		g1.addScore(25);	
		assertEquals(150, g1.sum(), .0001);	
		}
		


	@Test
	public void testMinimum() {
		assertEquals(50, g1.minimum(), .001);	
		g1.addScore(25);	

		assertEquals(25, g1.minimum(), .001);	}


	@Test
	public void testFinalScore() {
		assertEquals(75,g1.finalScore(),.001);	
		g1.addScore(100);	
		assertEquals(175,g1.finalScore(),.001);	

	}

}
