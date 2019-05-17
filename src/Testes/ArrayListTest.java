package Testes;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ArrayListSequencial.ArrayList;

class ArrayListTest {
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testAdd1() {
		ArrayList<Object> array = new ArrayList<Object>();
		assertThrows(NullPointerException.class, () -> {
			array.add(null);
		});
	}
	
	@Test
	void testAdd2() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("banana");
		array.add("cafe");
		array.add("bala");
		array.add("feijao");
		assertEquals("bala", array.get(2));
	}
	
	@Test
	void testAdd3() {
		ArrayList<Object> array = new ArrayList<Object>();
		assertThrows(IndexOutOfBoundsException.class, () ->{
			array.add(-1,5);
		});
	}
	
	@Test
	void testAdd4() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("banana");
		array.add("cafe");
		array.add("bala");
		array.add("feijao");
		array.add(2,"cuscuz");
		assertEquals("cuscuz", array.get(2));
	}
	
	@Test
	void testAdd5() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("banana");
		array.add("cafe");
		array.add("bala");
		array.add("feijao");
		array.add(2,"cuscuz");
		assertEquals("bala", array.get(3));
	}
	
	@Test
	void testAdd6() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("banana");
		array.add("cafe");
		array.add("bala");
		array.add("feijao");
		array.add(2,"cuscuz");
		assertEquals(5, array.size());
	}
	
	@Test
	void testAdd7() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("banana");
		array.add("cafe");
		array.add("bala");
		array.add("feijao");
		array.add(2,"cuscuz");
		array.add(4,"farinha");
		assertEquals("feijao", array.get(5));
	}
	
	@Test
	void testAdd8() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("banana");
		array.add("cafe");
		array.add("bala");
		array.add("feijao");
		array.add(2,"cuscuz");
		array.add(4,"farinha");
		assertEquals(6, array.size());
	}
	
	@Test
	void testAdd9() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("banana");
		array.add("cafe");
		array.add("bala");
		array.add("feijao");
		array.add(2,"cuscuz");
		array.add(4,"farinha");
		
		assertThrows(IndexOutOfBoundsException.class, () ->{
			array.add(6,"arroz");
		});
	}
	
	@Test
	void testAdd10() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("banana");
		array.add("cafe");
		array.add("bala");
		array.add("feijao");
		array.add(2,"cuscuz");
		array.add(4,"farinha");
		array.add(0,"tudo");
		assertEquals("tudo", array.get(0));
	}
	
	@Test
	void testAdd11() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("banana");
		array.add("cafe");
		array.add("bala");
		array.add("feijao");
		array.add(2,"cuscuz");
		array.add(4,"farinha");
		array.add(0,"tudo");
		assertEquals("feijao", array.get(6));
	}
	
	@Test
	void testAddAll1() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add(0);
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(2,50);
		
		ArrayList<Object> aux = new ArrayList<Object>();
		for (int i = 0; i < 10 ; i++) {
			aux.add(i);
		}
		array.addAll(aux);
		assertEquals(15, array.size());
	}
	
	@Test
	void testAddAll2() {
	ArrayList<Object> array = new ArrayList<Object>();
	array.add(0);
	array.add(1);
	array.add(2);
	array.add(3);
	array.add(2,50);
	
	ArrayList<Object> aux = new ArrayList<Object>();
	for (int i = 0; i < 5 ; i++) {
		aux.add(i);
	}
	array.addAll(aux);
	
	assertEquals(3, array.get(8));
	}
	
	@Test
	void testAddAll3() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add(0);
		array.add(1);
		array.add(3);
		array.add(4);
		array.add(2,2);
		
		ArrayList<Object> aux = new ArrayList<Object>();
		for (int i = 5; i < 11 ; i++) {
			aux.add(i);
		}
		array.addAll(aux);
		assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]", array.toString());
	}
	
	@Test
	void testRemove1() {
		ArrayList<Object> array = new ArrayList<Object>();
		
		assertThrows(IndexOutOfBoundsException.class, () ->{
			array.remove(0);
		});
	}	
	
	@Test
	void testRemove2() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("pao");
		array.remove(0);
		assertEquals(0, array.size());
	}
	
	@Test
	void testRemove3() {
		ArrayList<Object> array = new ArrayList<Object>();
	
		array.add("bolacha");
		array.add("biscoito");
		array.add("queijo");
		array.remove("biscoito");
		assertEquals("queijo", array.get(1));
	}
	
	@Test
	void testRemove4() {
		ArrayList<Object> array = new ArrayList<Object>();
		assertThrows(IndexOutOfBoundsException.class, () ->{
			array.remove(-1);});
	}
	
	@Test
	void testRemove5() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("bolacha");
		array.add("biscoito");
		array.add("queijo");
		array.remove("biscoito");
		assertThrows(IndexOutOfBoundsException.class, () ->{
			array.remove(2);
		});
	}
	
	@Test 
	void testeGet1() {
		ArrayList<Object> array = new ArrayList<Object>();
		
		
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.get(0);
		});
	}
	
	@Test 
	void testeGet2() {
		ArrayList<Object> array = new ArrayList<Object>();
	
		array.add(0);
		array.add(1);
		assertEquals(1, array.get(1));
	}
	
	@Test 
	void testeGet3() {
		ArrayList<Object> array = new ArrayList<Object>();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.get(-1);
		});
	}
	
	@Test 
	void testeGet4() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add(0);
		array.add(1);
		assertThrows(IndexOutOfBoundsException.class, () -> {
			array.get(2);
		});
	}
	
	@Test
	void testSet1() {
		ArrayList<Object> array = new ArrayList<Object>();
		
		assertThrows(IndexOutOfBoundsException.class, () ->{
			array.set(0, "feijão");
		});
	}
	
	@Test
	void testSet2() {
		ArrayList<Object> array = new ArrayList<Object>();
	
		array.add("paçoca");
		array.add("cuscuz");
		array.add("bolo");
		array.set(2, "pao");
		assertEquals("pao", array.get(2));
	}
	
	@Test
	void testSet3() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("paçoca");
		array.add("cuscuz");
		array.add("bolo");
		array.set(2, "pao");
		assertThrows(IndexOutOfBoundsException.class, () ->{
			array.set(3, "bolacha");
		});
	}
	
	void testSet4() {
		ArrayList<Object> array = new ArrayList<Object>();
		assertThrows(IndexOutOfBoundsException.class, () ->{
			array.set(-1, "carne");
		});
	}
	
	@Test 
	void testSize1() {
		ArrayList<Object> array = new ArrayList<Object>();
		assertEquals(0, array.size());
	}
	
	@Test 
	void testSize2() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
		assertEquals(5, array.size());
	}
	
	@Test 
	void testSize3() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add(1);
		array.add(2);
		array.add(3);
		array.add(4);
		array.add(5);
		array.remove(3);
		assertEquals(4, array.size());
	}
	
	@Test
	void testContains1() {
		ArrayList<Object> array = new ArrayList<Object>();
		assertEquals(false,array.contains(null));
	}
	
	@Test
	void testContains2() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add(6);
		array.add(5);
		array.add(8);
		assertEquals(true,array.contains(8));
	}
	
	@Test
	void testContains3() {
		ArrayList<Object> array = new ArrayList<Object>();
		assertEquals(false,array.contains("kaka"));
	}
	
	@Test
	void testIsEmpty1() {
		ArrayList<Object> array = new ArrayList<Object>();
		assertEquals(true, array.isEmpty());
	}
	
	@Test
	void testIsEmpty2() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add(1);
		array.remove(0);
		assertEquals(true, array.isEmpty());
	}
	
	@Test
	void testIsEmpty3() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add(2);
		array.add(9);
		array.add(8);
		array.add(50);
		array.add(90);
		array.remove(new Integer(9));
		assertEquals(false, array.isEmpty());
	}
	
	@Test
	void testToString1() {
		ArrayList<Object> array = new ArrayList<Object>();
		assertEquals("[]", array.toString());
	}
	
	@Test
	void testToString2() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add(0);
		array.add(5);
		array.add(7);
		array.add(9);
		array.remove(1);
		assertEquals("[0, 7, 9]", array.toString());
	}
	
	@Test
	void testClone1() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("a");
		array.add("b");
		array.add("c");
		assertEquals(3,array.clone().size());
	}
	
	@Test
	void testClone2() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("a");
		array.add("b");
		array.add("c");
		assertEquals(array.toString(), array.clone().toString());
	}
	
	@Test
	void testIndexOf1() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("a");
		array.add("b");
		array.add("c");
		assertEquals(-1, array.indexOf("d"));
	}
	
	@Test
	void testIndexOf2() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("a");
		array.add("b");
		array.add("c");
		assertEquals(1, array.indexOf("b"));
	}
	
	@Test
	void testSublist1() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("a");
		array.add("b");
		array.add("c");
		array.add("d");
		assertEquals(3, array.subList(1, 4).size());
	}
	
	@Test
	void testSublist2() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("a");
		array.add("b");
		array.add("c");
		array.add("d");
		assertEquals("[b, c, d]", array.subList(1, 4).toString());
	}
	
	@Test
	void testSublist3() {
		ArrayList<Object> array = new ArrayList<Object>();
		assertThrows(IllegalArgumentException.class, () ->{
			array.subList(3, 2);
		});
	}
	
	@Test
	void testSublist4() {
		ArrayList<Object> array = new ArrayList<Object>();
		assertThrows(IndexOutOfBoundsException.class, () ->{
			array.subList(-1, 2);
		});
	}
	
	@Test
	void testClear() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("b");
		array.add("c");
		array.add("d");
		array.clear();
		assertEquals("[]", array.toString());
	}
	
	@Test
	void testSort() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("b");
		array.add("a");
		array.add("d");
		array.add("z");
		array.add("m");
		array.sort();
		assertEquals("[a, b, d, m, z]", array.toString());
	}
	
	@Test
	void testToArray() {
		ArrayList<Object> array = new ArrayList<Object>();
		array.add("b");
		array.add("a");
		array.add("d");
		array.add("z");
		array.add("m");
	}
	
}
