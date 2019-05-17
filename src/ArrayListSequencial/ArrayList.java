package ArrayListSequencial;

import java.util.Arrays;


/**
 * 
 * @author Matheus Rodrigues Sousa
 *
 * @param <T>
 */
public class ArrayList<Objetc>{
	
	private static final int TAMANHO_INICIAL = 5;
	Object[] array = new Object[TAMANHO_INICIAL];
	private int tamanho;
	
	
	/**
	 * Metodo que adiciona um objeto no array
	 * @param object
	 * @throws NullPointerException
	 */
	public void add(Object object) throws NullPointerException{
		if (object == null) {
			throw new NullPointerException();
		}
		if(tamanho == array.length) {
			aumentaArray();
		}
		array[tamanho] = object;
		tamanho++;
	}
	
	/**
	 * Metodo que adiciona varios objetos no array
	 * @param objects
	 */
	public void addAll(ArrayList<Object> objects) {
		for (int i = 0; i < objects.size(); i++) {
			add(objects.get(i));
		}
	}
	
	/**
	 * Metodo que retorna outra lista com os mesmos objetos
	 */
	public ArrayList<Object> clone() {
		ArrayList<Object> novoArray = new ArrayList<Object>();
		for (int i = 0; i < tamanho; i++) {
			novoArray.add(array[i]);
		}
		return novoArray;
	}
	
	/**
	 * Metodo que retorna o index do objeto
	 * @param object
	 * @return
	 */
	public int indexOf(Object object) {
		
		int posi = -1;
		for (int i = 0; i < tamanho; i++) {
			if(array[i].equals(object)) {
				posi =  i;
				break;
			}
		}
		return posi;
	}
	
	/**
	 * Metodo que adiciona um objeto no index passado
	 * @param index
	 * @param object
	 * @throws IndexOutOfBoundsException
	 */
	public void add(int index, Object object) throws IndexOutOfBoundsException{
		if(index >= tamanho || index < 0 || tamanho == 0) {
			throw new IndexOutOfBoundsException("index invalido");
		}
		int cont = 1;
		Object[] novoArray = new Object[tamanho+TAMANHO_INICIAL];
		for (int i = 0; i < array.length; i++) {
			if (index == i) {
				novoArray[i] = object;
				novoArray[cont] = array[i];
			}
			else if(index < i) {
				novoArray[cont] = array[i];
			}
			else{
				novoArray[i] = array[i];
			}
			cont++;
		}
		array=novoArray;
		tamanho++;
	}
	
	/**
	 * Metodo que ordena o array
	 */
	public void sort() {
		Arrays.sort(arrayTamanhoCerto());
	}
	
	/**
	 * Metodo que remove o objeto no array
	 * @param object
	 */
	public void remove(Object object) {
		boolean achou = false;
		if(object != null && tamanho > 0) {
			int pos = 0;
			Object[] novoArray = new Object[tamanho];
			for (int i = 0; i < array.length; i++) {
				if(array[i].equals(object)) {
					achou = true;
					array[i] = null;
					break;
				}
			}
			if(achou) {
				for (int i = 0; i < array.length; i++) {
					if(array[i]!=null) {
						novoArray[pos] = array[i];
						pos++;
					}
				}
				tamanho--;
				array = novoArray;
			}
		}
	}
	
	/**
	 * Metodo que retorna o array do tamanho certo
	 * @return
	 */
	private Object[] arrayTamanhoCerto() {
		Object[] array2 = new Object[tamanho];
		for (int i = 0; i < array2.length; i++) {
			array2[i] = array[i];
		}
		array = array2;
		return array;
	}
	
	/**
	 * Metodo que aumenta o array
	 */
	private void aumentaArray() {
		Object[] novoArray = new Object[tamanho+TAMANHO_INICIAL];
		for (int i = 0; i < array.length; i++) {
			novoArray[i] = array[i];
		}
		array=novoArray;
	}
	/**
	 * Metodo que remove um objeto pelo index
	 * @param index
	 * @throws IndexOutOfBoundsException
	 */
	public void remove(int index) throws IndexOutOfBoundsException{
		if(index >= tamanho || index < 0 || tamanho == 0) {
			throw new IndexOutOfBoundsException("index invalido");
		}
	
		int pos = 0;
		Object[] novoArray = new Object[tamanho];
		array[index] = null;
		for (int i = 0; i < array.length; i++) {
			if(array[i]!=null) {
				novoArray[pos] = array[i];
				pos++;
			}
		}
		tamanho--;
		array = novoArray;
	}
	
	/**
	 * Metodo que modifica um objeto do array no index informado
	 * @param index
	 * @param object
	 * @throws IndexOutOfBoundsException
	 */
	public void set(int index, Object object) throws IndexOutOfBoundsException{
		if(index < 0 || index >= tamanho || tamanho == 0) {
			throw new IndexOutOfBoundsException("index invalido");
		}
		array[index] = object;

	}
	
	/**
	 * Metodo que retorna o objeto no index do array
	 * @param index
	 * @return
	 * @throws IndexOutOfBoundsException
	 */
	public Object get(int index) throws IndexOutOfBoundsException{
		if(index < 0 || index >= tamanho || tamanho == 0) {
			throw new IndexOutOfBoundsException("index invalido");
		}
		return array[index];	
	}
	
	/**
	 * Metodo que retorna uma nova lista de um index a outro
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 * @throws IndexOutOfBoundsException
	 * @throws IllegalArgumentException
	 */
	public ArrayList<Object> subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException, IllegalArgumentException {
		if (fromIndex > toIndex) {
			throw new IllegalArgumentException();
		}
		if(tamanho == 0 || fromIndex < 0 || toIndex > tamanho) {
			throw new IndexOutOfBoundsException();
		}
		ArrayList<Object> novoArray = new ArrayList<Object>();
		for (int i = fromIndex; i < toIndex; i++) {
			novoArray.add(array[i]);
		}
		return novoArray;
	}
	/**
	 * Metodo que retorna o tamanho do array
	 * @return
	 */
	public int size() {
		return tamanho;
	}
	
	/**
	 * Metodo que verifica se contém o objeto no array
	 * @param object
	 * @return
	 */
	public boolean contains(Object object) {
		boolean existe = false;
		if (object!= null) {
			for (Object object2 : array) {
				if(object.equals(object2)) {
					existe = true;
				}
		}
		}
		return existe;
	}
	
	/**
	 * Metodo que exclui todos os objetos do array
	 */
	public void clear() {
		this.array = new Object[TAMANHO_INICIAL];
		this.tamanho = 0;
	}
	
	/**
	 * Metodo que retorna um array de objetos
	 * @return
	 */
	public Object[] toArray() {
		
		return arrayTamanhoCerto();
	}
	
	/**
	 * Metodo que verifica se o array é vazio
	 * @return
	 */
	public boolean isEmpty() {
		boolean vazio = false;
		if(tamanho == 0) {
			vazio = true;
		}
		return vazio;
	}


	/**
	 * Metodo que retorna o array
	 */
	public String toString() {
		String string = "";
		for (int i = 0; i < tamanho; i++) {
			if(i == tamanho-1) {
				string += ""+array[i]+"";
			}
			else {
				string += ""+array[i]+", ";
			}
		}
		return "["+string+"]";
	}

}
	
		


