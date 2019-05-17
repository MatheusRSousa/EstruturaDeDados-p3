package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Encadeada.Fila;

class TesteFilaEncadeada {

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
	void testEnqueue() {
		Fila<Object> fila = new Fila<Object>();
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.enqueue(4);
		assertEquals("[1, 2, 3, 4]", fila.toString());
	}
	
	@Test
	void testDequeue() {
		Fila<Object> fila = new Fila<Object>();
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.enqueue(4);
		fila.dequeue();
		assertEquals("[2, 3, 4]", fila.toString());
		fila.dequeue();
		fila.dequeue();
		fila.dequeue();
		assertEquals("[]", fila.toString());
	}
	
	@Test
	void testFront() {
		Fila<Object> fila = new Fila<Object>();
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.enqueue(4);
		assertEquals(1, fila.front().getObj());
	}
	
	@Test
	void testDequeueException() {
		Fila<Object> fila = new Fila<Object>();
		assertThrows(NullPointerException.class, () ->{
			fila.dequeue();
		});
	}
	
	@Test
	void testFrontException() {
		Fila<Object> fila = new Fila<Object>();
		assertThrows(NullPointerException.class, () ->{
			fila.front();
		});
	}
}
