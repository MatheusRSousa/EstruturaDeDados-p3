package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Encadeada.ListaEncadeada;

class TesteListaEncadeada {

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
	void testAddObjetoNull() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>(); 
		assertThrows(NullPointerException.class,  () ->{
			lista.addFirst(null);
		});
			
	}
	
	@Test
	void testAddInicio() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>(); 
		lista.addFirst(1);
		lista.addFirst(2);
		lista.addFirst(3);
		assertEquals(3, lista.size());
		assertEquals(3, lista.getFirst().getObj());
		assertEquals(1, lista.getLast().getObj());
	}
	
	@Test
	void testeAddFinal() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>(); 
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		assertEquals(3, lista.size());
		assertEquals(3, lista.getLast().getObj());
		assertEquals(1, lista.getFirst().getObj());
	}
	
	@Test
	void testAddIndex() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>(); 
		lista.add(0, 0);
		assertEquals("[0]", lista.toString());
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(4);
		lista.add(3, 3);
		assertEquals(3, lista.get(3).getObj());
		assertEquals("[0, 1, 2, 3, 4]", lista.toString());
	}
	
	@Test
	void testAddIndexInvalido() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>(); 
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		assertThrows(IndexOutOfBoundsException.class, () ->{
			lista.add(4, 2);
		});
	}
	
	@Test
	void testRemoveInicio(){
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>(); 
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		lista.removeFirst();
		assertEquals(2, lista.size());
		assertEquals("[2, 3]", lista.toString());
	}
	
	@Test
	void testRemoveFinal() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>();
		lista.addLast(0);
		lista.addLast(1);
		lista.addLast(2);
		lista.removeLast();
		assertEquals(2, lista.size());
		assertEquals("[0, 1]", lista.toString());
	}
	
	@Test
	void testRemoveIndex() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>();
		lista.addLast(1);
		lista.addLast(2);
		lista.addLast(3);
		lista.remove(1);
		assertEquals(2, lista.size());
		assertEquals("[1, 3]", lista.toString());
	}

	@Test
	void testRemoveObj() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>();
		lista.addLast("a");
		lista.addLast("b");
		lista.addLast("c");
		lista.remove("b");
		assertEquals(2, lista.size());
		assertEquals("[a, c]", lista.toString());
	}
	
	@Test
	void testGetInicial() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>();
		lista.addLast(3);
		lista.addFirst(1);
		lista.add(1, 2);
		assertEquals(1, lista.getFirst().getObj());
	}
	
	@Test
	void testGetFinal() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>();
		lista.addLast(3);
		lista.addFirst(1);
		lista.add(1, 2);
		lista.addLast(4);
		assertEquals(4, lista.getLast().getObj());
	}
	
	@Test
	void testGetIndex() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>();
		lista.addLast(3);
		lista.addFirst(1);
		lista.add(1, 2);
		lista.addLast(4);
		assertEquals(4, lista.get(3).getObj());
	}
	
	@Test
	void testIndexOf() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>();
		lista.addLast("c");
		lista.addFirst("a");
		lista.add(1, "b");
		lista.addLast("d");
		assertEquals(1,lista.indexOf("b"));
		assertEquals(-1, lista.indexOf("e"));
	}
	
	@Test
	void testSetPorIndex() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>();
		lista.addLast("c");
		lista.addFirst("a");
		lista.add(1, "b");
		lista.set(0,"d");
		assertEquals("[d, b, c]",lista.toString());
	}
	
	@Test
	void testSetFirst() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>();
		lista.addLast("c");
		lista.addFirst("a");
		lista.add(1, "b");
		lista.setFirst("e");
		assertEquals("[e, b, c]", lista.toString());
	}
	
	@Test
	void testSetLast() {
		ListaEncadeada<Object> lista = new ListaEncadeada<Object>();
		lista.addLast("c");
		lista.addFirst("a");
		lista.add(1, "b");
		lista.setLast("e");
		lista.addLast("o");
		lista.setLast("f");
		assertEquals("[a, b, e, f]", lista.toString());
	}
	
}
