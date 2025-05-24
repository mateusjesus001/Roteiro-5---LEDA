package tad.listasEncadeadas;

/**
 * Objetivo da Interface: Define o contrato para uma estrutura de dados do tipo Lista Duplamente Encadeada.
 * Estende a interface {@link ListaEncadeadaIF} adicionando operações específicas que são
 * eficientemente suportadas por listas duplamente encadeadas, como inserção no início
 * e remoção nas extremidades (primeiro/último).
 * @param <T> O tipo do dado armazenado na lista, deve implementar {@link Comparable}.
 */
public interface ListaDuplamenteEncadeadaIF<T extends Comparable<T>> extends ListaEncadeadaIF<T>{
	
	/**
	 * Insere um novo elemento no início da lista duplamente encadeada.
	 * @param elemento A chave do elemento a ser inserido na primeira posição.
	 */
	public void inserePrimeiro(T elemento);

	/**
	 * Remove e retorna o último elemento da lista duplamente encadeada.
	 * @return O {@link NodoListaDuplamenteEncadeada} que era o último elemento, ou {@code null} se a lista estiver vazia.
	 * @throws ListaVaziaException Se a lista estiver vazia ao tentar remover o último elemento.
	 */
	public NodoListaDuplamenteEncadeada<T> removeUltimo();

	/**
	 * Remove e retorna o primeiro elemento da lista duplamente encadeada.
	 * @return O {@link NodoListaDuplamenteEncadeada} que era o primeiro elemento, ou {@code null} se a lista estiver vazia.
	 * @throws ListaVaziaException Se a lista estiver vazia ao tentar remover o primeiro elemento.
	 */
	public NodoListaDuplamenteEncadeada<T> removePrimeiro();

}
