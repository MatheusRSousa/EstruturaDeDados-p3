package Encadeada;

import Genericos.Generico;

public class Pilha<T> extends Generico{
	
	private No<T> inicio;
	
	/**
	 * Insere um objeto no topo da pilha
	 * @param obj
	 */
	public void push(T obj){
		No<T> novoObj = new No<T>(obj);
		if(isEmpty()) {
			inicio = novoObj;
			inicio.setAnterior(null);
		}
		else {
			No<T> aux = inicio;
			inicio = novoObj;
			inicio.setProximo(aux);
			aux.setAnterior(inicio);
			inicio.setAnterior(null);
		}
		inseridos++;
	}
	
	/**
	 * Remove um objeto do topo da pilja
	 * @throws NullPointerException
	 */
	public void pop() throws NullPointerException{
		if(isEmpty()) {
			throw new NullPointerException("Pilha vazia");
		}
		if(size() == 1) {
			inicio = null;
		}
		else {
			inicio = inicio.getProximo();
			inicio.setAnterior(null);
		}
		inseridos--;
	}
	
	/**
	 * Consulta o objeto do topo da pilha
	 * @return
	 */
	public No<T> top(){
		if(isEmpty()) {
			throw new NullPointerException("Pilha vazia");
		}
		
		return inicio;
	}
	
	/**
	 * Metodo que retorna os valores da pilha
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
