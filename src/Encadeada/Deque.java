package Encadeada;

import Genericos.Generico;

public class Deque<T> extends Generico{

	private No<T> inicio;
	
	private No<T> fim;
	
	/**
	 * Metodo que adiciona no inicio da deque
	 * @param c
	 * @throws NullPointerException
	 */
	public void addFirst(T obj) throws NullPointerException{
		if (obj == null) {
			throw new NullPointerException("Objeto inválido");
		}
		
		No<T> novoObj = new No<T>(obj);
		if(inicio == null) {
			inicio = novoObj;
			fim = novoObj;
		}
		else {
			No<T> auxiliar = inicio;
			inicio = novoObj;
			inicio.setProximo(auxiliar);
			auxiliar.setAnterior(inicio);
		}
		inseridos++;
	}
	
	/**
	 * Metodo que adiciona no final da deque
	 * @param c
	 * @throws NullPointerException
	 */
	public void addLast(T obj) throws NullPointerException{
		if (obj == null) {
			throw new NullPointerException("Objeto inválido");
		}
		
		No<T> novoObj = new No<T>(obj);
		if(inicio == null) {
			inicio = novoObj;
			fim = novoObj;
		}
		
		else {
			No<T> auxiliar = fim;
			fim = novoObj;
			auxiliar.setProximo(fim);
			fim.setAnterior(auxiliar);
		}
		inseridos ++;
	}
	
	
	
	/**
	 * Metodo que remove no inicio
	 * @throws NullPointerException
	 */
	public void removeFirst() throws NullPointerException{
		if(inseridos == 0) {
			throw new NullPointerException("Lista vazia");
		}
		
		inicio = inicio.getProximo();
		inicio.setAnterior(null);
		inseridos--;
	}
	
	/**
	 * Metodo que remove no final
	 * @throws NullPointerException
	 */
	public void removeLast() throws NullPointerException{
		if (inseridos == 0) {
			throw new NullPointerException("Lista vazia");
		}
		
		fim = fim.getAnterior();
		fim.setProximo(null);
		inseridos--;
	}
	
	/**
	 * Metodo que remove por index
	 * @param index
	 * @throws IndexOutOfBoundsException
	 */
	public void remove(int index) throws IndexOutOfBoundsException{
		if(index<0 || index>= inseridos) {
			throw new IndexOutOfBoundsException("Index invalido");
		}
		if (index == 0) {
			inicio = inicio.getProximo();
			
		}
		if(index == inseridos-1 && index > 0) {
			fim = fim.getAnterior();
			fim.setProximo(null);
		}
		else {
			No<T> aux = inicio; 
			No<T> auxiliar = inicio;
			for (int i = 0; i < index; i++) {
				aux = aux.getProximo();
				auxiliar = aux.getAnterior();
			}
			aux = aux.getProximo();
			auxiliar.setProximo(aux);
		}
		inseridos--;
	}
	
	/**
	 *  Metodo que remove da deque um determinado objeto
	 * @param obj
	 */
	public void remove(T obj) {
		No<T> aux = inicio;
		for (int i = 0; i < inseridos; i++) {
			if(aux.getObj().equals(obj)) {
				aux.getAnterior().setProximo(aux.getProximo());
				inseridos--;
				break;
			}
			aux = aux.getProximo();
		}
	}
	
	/**
	 * Metodo que retorna os valores da deque
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
