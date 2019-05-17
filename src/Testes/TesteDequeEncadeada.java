package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Encadeada.Deque;

class TesteDequeEncadeada {

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
		Deque<Object> deque = new Deque<Object>(); 
		assertThrows(NullPointerException.class,  () ->{
			deque.addFirst(null);
		});
			
	}
	
	@Test
	void testAddInicio() {
		Deque<Object> deque = new Deque<Object>(); 
		deque.addFirst(1);
		deque.addFirst(2);
		deque.addFirst(3);
		assertEquals(3, deque.size());
		assertEquals("[3, 2, 1]", deque.toString());
	}
	
	@Test
	void testeAddFinal() {
		Deque<Object> deque = new Deque<Object>(); 
		deque.addLast(1);
		deque.addLast(2);
		deque.addLast(3);
		assertEquals(3, deque.size());
		assertEquals("[1, 2, 3]", deque.toString());
	}
	
	
	@Test
	void testRemoveInicio(){
		Deque<Object> deque = new Deque<Object>(); 
		deque.addLast(1);
		deque.addLast(2);
		deque.addLast(3);
		deque.removeFirst();
		assertEquals(2, deque.size());
		assertEquals("[2, 3]", deque.toString());
	}
	
	@Test
	void testRemoveFinal() {
		Deque<Object> deque = new Deque<Object>(); 
		deque.addLast(0);
		deque.addLast(1);
		deque.addLast(2);
		deque.removeLast();
		assertEquals(2, deque.size());
		assertEquals("[0, 1]", deque.toString());
	}
	
	@Test
	void testRemoveIndex() {
		Deque<Object> deque = new Deque<Object>(); 
		deque.addLast(1);
		deque.addLast(2);
		deque.addLast(3);
		deque.remove(1);
		assertEquals(2, deque.size());
		assertEquals("[1, 3]", deque.toString());
	}

	@Test
	void testRemoveObj() {
		Deque<Object> deque = new Deque<Object>(); 
		deque.addLast("a");
		deque.addLast("b");
		deque.addLast("c");
		deque.remove("b");
		assertEquals(2, deque.size());
		assertEquals("[a, c]", deque.toString());
	}

}
