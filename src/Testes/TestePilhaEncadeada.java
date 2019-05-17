package Testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Encadeada.Pilha;

class TestePilhaEncadeada {

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
	void testPush() {
		Pilha<Object> pilha = new Pilha<Object>();
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		assertEquals("[3, 2, 1]", pilha.toString());
	}
	
	@Test
	void testPop() {
		Pilha<Object> pilha = new Pilha<Object>();
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		pilha.pop();
		assertEquals("[2, 1]", pilha.toString());
		pilha.pop();
		pilha.pop();
		assertEquals("[]", pilha.toString());
	}
	
	@Test
	void testPopException() {
		Pilha<Object> pilha = new Pilha<Object>();
		assertThrows(NullPointerException.class, ()->{
			pilha.pop();
		});
	}
	
	@Test
	void testTop() {
		Pilha<Object> pilha = new Pilha<Object>();
		pilha.push(1);
		pilha.push(2);
		pilha.push(3);
		assertEquals(3, pilha.top().getObj());
	}
	
	@Test
	void testTopException() {
		Pilha<Object> pilha = new Pilha<Object>();
		assertThrows(NullPointerException.class, ()->{
			pilha.top();
		});
	}

}
