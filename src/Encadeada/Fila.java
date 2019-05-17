package Encadeada;

import Genericos.Generico;

public class Fila<T> extends Generico{

	private No<T> inicio;
	
	private No<T> fim;
	
	/**
	 * metodo que insere um objeto no final da fila
	 * @param obj
	 */
	public void enqueue(T obj) {
		No<T> novoObj = new No<T>(obj);
		if(inicio == null) {
			inicio = novoObj;
			fim = novoObj;
		}
		else {
			No<T> aux = fim;
			fim = novoObj;
			aux.setProximo(fim);
			fim.setAnterior(aux);
		}
		inseridos++;
	}
	
	/**
	 * Metodo que remove um objeto no inicio da fila e mostra
	 * @return
	 * @throws NullPointerException
	 */
	public No<T> dequeue() throws NullPointerException{
		if(isEmpty()) {
			throw new NullPointerException("Fila vazia");
		}
		No<T> aux = inicio;
		if(inseridos == 1) {
			inicio = null;
		}
		else {
		inicio = inicio.getProximo();
		inicio.setAnterior(null);
		}
		inseridos--;
		return aux;
	}
	
	/**
	 * Metodo que consulta o objeto do inicio da fila
	 * @return
	 * @throws NullPointerException
	 */
	public No<T> front() throws NullPointerException{
		if(isEmpty()) {
			throw new NullPointerException("Fila vazia");
		}
		return inicio;
	}
	
	/**
	 * Metodo que retorna os valores da fila
	 */
	@Override
	public String toString() {
		String var = "[";
		if(isEmpty()) {
			var+="]";
		}
		else {
			No<T> aux = inicio;
			while (aux.getProximo()!=null) {
				var+=""+aux.getObj()+", ";
				aux = aux.getProximo();
			}
			var+=""+aux.getObj()+"]";
		}
		return var;
	}
	
}
