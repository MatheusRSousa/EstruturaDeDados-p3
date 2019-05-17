package Encadeada;

public class No<T> {
	
	private No<T> proximo;
	
	private No<T> anterior;

	private T obj;
	
	
	public No(T obj){
		this.obj = obj;
	} 
	/**
	 * @return the proximo
	 */
	public No<T> getProximo() {
		return proximo;
	}

	/**
	 * @param proximo the proximo to set
	 */
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}

	/**
	 * @return the obj
	 */
	public T getObj() {
		return obj;
	}

	/**
	 * @param obj the obj to set
	 */
	public void setObj(T obj) {
		this.obj = obj;
	}

	/**
	 * @return the anterior
	 */
	public No<T> getAnterior() {
		return anterior;
	}

	/**
	 * @param anterior the anterior to set
	 */
	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}
	

	
}
