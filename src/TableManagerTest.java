import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;

import org.junit.jupiter.api.Test;

class TableManagerTest {

	@Before
	void setUp() throws Exception {
	}


	@Test
	void testGetLast_standard() {
		TableManager tablica = new TableManager();
		tablica.PushBack(3);
		tablica.PushBack(99);
		try {
			assertEquals(99, tablica.getLast());
		} catch (NoElementsInTable e) {
			fail("Brak elementów w tablicy");
		}
		
	}
	
	@Test
	void testGetLast_zeroElements() {
		TableManager tablica = new TableManager();
		try {
			tablica.getLast();
			fail("Mial poleciec wyjatek NoElementsInTable, a nie polecial");
		} catch (NoElementsInTable e) {
			
		}	
	}
	
	@Test
	void testGetLastAndRemove_zeroElements() {
		TableManager tablica = new TableManager();
		tablica.PushBack(3);
		try 
		{
			assertEquals(3, tablica.getLastAndRemove());
			tablica.getLastAndRemove();
			fail("Mial poleciec wyjatek NoElementsInTable, a nie polecial");
		}
		catch (NoElementsInTable e)
		{
			
		}
		 
	}
	
	@Test
	void testGetLastAndRemove_standard() throws NoElementsInTable {
		TableManager tablica = new TableManager();
		tablica.PushBack(3);
		tablica.PushBack(99);
		tablica.PushBack(44);
		assertEquals(44, tablica.getLastAndRemove()); 
	}
	
	@Test
	void testGetElementFromPosition_standard() throws NoSuchElementInTable {
		TableManager tablica = new TableManager();
		tablica.PushBack(3);
		tablica.PushBack(99);
		tablica.PushBack(44);
		tablica.PushBack(800);
		tablica.PushBack(44);
		assertEquals(800, tablica.getElementFromPosition(3));
	}
	
	@Test
	void testGetElementFromPosition_zero() throws NoSuchElementInTable {
		TableManager tablica = new TableManager();
		try
		{
			tablica.getElementFromPosition(0);
			fail("Mial poleciec wyjatek NoSuchElementInTable, a nie polecial");
		}
		catch (NoSuchElementInTable e)
		{
			
		}
	}
	
	@Test
	void testGetElementFromPosition_badPosition() throws NoSuchElementInTable {
		TableManager tablica = new TableManager();
		tablica.PushBack(3);
		tablica.PushBack(99);
		tablica.PushBack(44);
		tablica.PushBack(800);
		tablica.PushBack(44);
		try
		{
			assertEquals(800, tablica.getElementFromPosition(10));
			fail("Mial poleciec wyjatek NoSuchElementInTable, a nie polecial");
		}
		catch (NoSuchElementInTable e)
		{
			
		}
	}

}
