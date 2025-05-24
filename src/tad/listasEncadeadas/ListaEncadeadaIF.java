package tad.listasEncadeadas;

/**
 * Objetivo da Interface: Define o contrato para uma estrutura de dados do tipo Lista Encadeada.
 * Especifica as operações comuns para listas, como inserção, remoção, busca,
 * verificação de tamanho e obtenção de representações da lista.
 * @param <T> O tipo do dado armazenado na lista, deve implementar {@link Comparable}.
 */
public interface ListaEncadeadaIF<T extends Comparable<T>> {
	
	/**
	 * Verifica se a lista está vazia.
	 * @return {@code true} se a lista não contiver elementos, {@code false} caso contrário.
	 */
	public boolean isEmpty();

	/**
	 * Retorna o número de elementos presentes na lista.
	 * @return O total de elementos na lista.
	 */
	public int size();

	/**
	 * Procura por um elemento com a chave especificada na lista.
	 * @param chave A chave do elemento a ser procurado.
	 * @return O {@link NodoListaEncadeada} contendo a chave, se encontrado; caso contrário, {@code null}.
	 */
	public NodoListaEncadeada<T> search(T chave);

	/**
	 * Insere um novo elemento com a chave especificada na lista.
	 * A posição exata da inserção (ex: início, fim, ordenada) depende da implementação.
	 * @param chave A chave do elemento a ser inserido.
	 */
	public void insert(T chave);

	/**
	 * Insere um novo elemento com a chave especificada em uma posição (índice) específica da lista.
	 * @param chave A chave do elemento a ser inserido.
	 * @param index A posição na qual o elemento deve ser inserido (0-based).
	 * @throws IndexOutOfBoundsException Se o índice for inválido para a lista.
	 */
	public void insert(T chave, int index);

	/**
	 * Remove o primeiro elemento encontrado na lista que corresponde à chave especificada.
	 * @param chave A chave do elemento a ser removido.
	 * @return O {@link NodoListaEncadeada} que foi removido contendo a chave, ou {@code null} se a chave não for encontrada.
	 */
	public NodoListaEncadeada<T> remove(T chave);
	/**
	 * Existem uma conotação semântica para o imprime em ordem. É para imprimir na ordem em que
	 * os elementos são inseridos.
	 * @return String cadeia de string com as chaves dos elementos concatenadas e separadas
	 *  por um espaço
	 */
	public String imprimeEmOrdem();
	
	/**
	 * Imprimir uma cadeia de caracteres de acordo com as chaves inseridas. A ordem dos elementos
	 * deve ser inversa a que foram inseridos
	 * @return String com o conjunto das chaves inseridas em ordem inversa.
	 */
	public String imprimeInverso();

	/**
	 * Encontra e retorna o nó sucessor ao nó que contém a chave especificada, na ordem da lista.
	 * @param chave A chave do elemento cujo sucessor é desejado.
	 * @return O {@link NodoListaEncadeada} sucessor, ou {@code null} se não houver sucessor ou a chave não for encontrada.
	 */
	public NodoListaEncadeada<T> sucessor(T chave);

	/**
	 * Encontra e retorna o nó predecessor ao nó que contém a chave especificada, na ordem da lista.
	 * @param chave A chave do elemento cujo predecessor é desejado.
	 * @return O {@link NodoListaEncadeada} predecessor, ou {@code null} se não houver predecessor ou a chave não for encontrada.
	 */
	public NodoListaEncadeada<T> predecessor(T chave);
	/**
	 * Gerar um array de elementos de acordo com a ordem em que foram inseridos
	 * @return Array de elementos chave de acordo como foi inserido 
	 */
	public T[] toArray(Class<T> clazz);

}
