package Genericos;


public abstract class Generico{
	
	protected int inseridos;
	
	/**
	 * Metodo que retorna o tamanho da lista
	 * @return
	 */
	public int size() {
		return inseridos;
	}
	
	/**
	 * Metodo que mostra se a lista � vazia ou n�o
	 * @return
	 */
	public boolean isEmpty() {
		return inseridos == 0;
	}
	
	
}
