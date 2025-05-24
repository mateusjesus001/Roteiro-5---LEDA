package tad.util;

import java.lang.reflect.Array;

/**
 * Objetivo da Classe: Fornecer um mecanismo para criar arrays de tipos genéricos.
 * Esta classe utilitária encapsula a criação de arrays usando reflexão,
 * o que é necessário em Java quando o tipo do array não é conhecido em tempo de compilação.
 */
public class Conversor<E> {
	
	/**
	 * Cria e retorna um novo array do tipo genérico especificado e com a capacidade dada.
	 * Utiliza reflexão (Array.newInstance) para instanciar o array.
	 *
	 * @param clazz A classe do tipo de elemento do array a ser gerado (ex: Integer.class).
	 * @param capacity A capacidade desejada para o novo array.
	 * @return Um novo array do tipo especificado (E[]) com a capacidade dada.
	 */
	@SuppressWarnings("unchecked")
	public E[] gerarArray(Class<E> clazz, int capacity) {
		return (E[])Array.newInstance(clazz, capacity);
	}

}
