package Encadeada;




import Genericos.Generico;

public class ListaEncadeada<T> extends Generico{
	
	private No<T> inicio;
	
	private No<T> fim;
	
	
	/**
	 * Metodo que adiciona no inicio da lista
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
	 * Metodo que adiciona no final da lista
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
	 * Metodo que adiciona por index
	 * @param index
	 * @param c
	 * @throws IndexOutOfBoundsException
	 * @throws NullPointerException
	 */
	public void add(int index, T obj) throws IndexOutOfBoundsException, NullPointerException{
		if (obj == null) {
			throw new NullPointerException("Objeto inválido");
		}
		if(index < 0 || index > inseridos) {
			throw new IndexOutOfBoundsException();
		}
		No<T> aux = inicio;
		No<T> auxiliar = inicio;
		No<T> novoObj = new No<T>(obj);
		if(index == 0 && inseridos > 0) {
			inicio = novoObj;
			inicio.setProximo(aux);
			inicio.setAnterior(null);
		}
		if(index == 0 && inseridos == 0) {
			inicio = novoObj;
			fim = novoObj;
		}
		else {
			for (int i = 0; i < index; i++) {
				aux = aux.getProximo();
				auxiliar = aux.getAnterior();
			}
			auxiliar.setProximo(novoObj);
			novoObj.setAnterior(auxiliar);
			novoObj.setProximo(aux);
			aux.setAnterior(novoObj);
		}
		inseridos++;
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
	 *  Metodo que remove da lista um determinado objeto
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
	 * Metodo que retorna o objeto no inicio da lista
	 * @return
	 * @throws NullPointerException
	 */
	public No<T> getFirst() throws NullPointerException{
		if (inseridos == 0) {
			throw new NullPointerException("Lista vazia");
		}
		return inicio;
	}
	
	/**
	 * Metodo que retorna o objeto do final da lista
	 * @return
	 * @throws NullPointerException
	 */
	public No<T> getLast() throws NullPointerException{
		if (inseridos == 0) {
			throw new NullPointerException("Lista vazia");
		}
		return fim;
	}
	
	/**
	 * Metodo que retorna o objeto em determinado index
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public No<T> get(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index >= inseridos) {
			throw new IndexOutOfBoundsException("Index invalido");
		}
		No<T> aux = inicio;
		for (int i = 0; i < index; i++) {
			aux = aux.getProximo();
		}
		return aux;
	}
	
	/**
	 * Metodo que retorna o indice de um objeto na lista
	 * @param obj
	 * @return
	 */
	public int indexOf(T obj) {
		No<T> aux = inicio;
		int index = -1;
		for (int i = 0; i < inseridos; i++) {
			if(aux.getObj().equals(obj)) {
				index = i;
				break;
			}
			aux = aux.getProximo();
		}
		return index;
	}
	
	/**
	 * Metodo que modifica um objeto passando a posição
	 * @param index
	 * @param obj
	 * @throws IndexOutOfBoundsException
	 */
	public void set(int index, T obj) throws IndexOutOfBoundsException{
		if(index < 0 || index >= inseridos) {
			throw new IndexOutOfBoundsException("Index invalido");
		}
		No<T> novoObj = new No<T>(obj);
		if(index == 0) {
			novoObj.setProximo(inicio.getProximo());
			inicio = novoObj;
		}
		else {
			No<T> aux = inicio;
		
			for (int i = 0; i < index; i++) {
				aux = aux.getProximo();
			}
			aux = novoObj;
		}
	}
	
	/**
	 * Metodo que modifica o objeto do inicio da lista
	 * @param obj
	 * @throws NullPointerException
	 */
	public void setFirst(T obj) throws NullPointerException{
		if (inseridos == 0) {
			throw new NullPointerException("Lista vazia");
		}
		
		No<T> novoObj = new No<T>(obj);
		novoObj.setProximo(inicio.getProximo());
		inicio = novoObj;
		
	}
	
	/**
	 * Metodo que modifica um objeto do final da lista
	 * @param obj
	 * @throws NullPointerException
	 */
	public void setLast(T obj) throws NullPointerException{
		if (inseridos == 0) {
			throw new NullPointerException("Lista vazia");
		}
		No<T> novoObj = new No<T>(obj);
		fim.getAnterior().setProximo(novoObj);
		novoObj.setAnterior(fim.getAnterior());
		fim = novoObj;
	}

	/** 
	 * Metodo que retorna a lista
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
