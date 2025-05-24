package tad.conjuntoDinamico;

/**
 * Objetivo da Interface: Define o contrato para uma estrutura de dados do tipo Conjunto Dinâmico.
 * Um conjunto armazena elementos únicos. Esta interface especifica operações para manipular o conjunto,
 * como inserção, remoção, busca, e obtenção de informações como tamanho, mínimo, máximo, sucessor e predecessor.
 * @param <E> O tipo do dado armazenado no conjunto.
 */
public interface ConjuntoDinamicoIF<E> {
	
	/**
	 * Insere um item no conjunto, se ele ainda não estiver presente.
	 * Se o item já existir no conjunto, a operação pode não ter efeito ou pode atualizar o item existente,
	 * dependendo da semântica específica da implementação.
	 * @param item O item a ser inserido.
	 */
	public void inserir(E item);
	
	/**
	 * Remove um item do conjunto, se ele estiver presente.
	 * @param item O item a ser removido.
	 * @return O item removido, ou {@code null} se o item não estava no conjunto.
	 */
	public E remover(E item);
	
	/**
	 * Encontra o predecessor de um item no conjunto.
	 * O predecessor é o maior elemento no conjunto que é estritamente menor que o item fornecido.
	 * Requer que os elementos tenham uma ordem definida para que o conceito de predecessor seja significativo.
	 * @param item O item cujo predecessor é desejado.
	 * @return O predecessor do item, ou {@code null} se não houver predecessor, o item não estiver no conjunto,
	 *         ou se o item for o mínimo do conjunto.
	 */
	public E predecessor(E item);
	
	/**
	 * Encontra o sucessor de um item no conjunto.
	 * O sucessor é o menor elemento no conjunto que é estritamente maior que o item fornecido.
	 * Requer que os elementos tenham uma ordem definida para que o conceito de sucessor seja significativo.
	 * @param item O item cujo sucessor é desejado.
	 * @return O sucessor do item, ou {@code null} se não houver sucessor, o item não estiver no conjunto,
	 *         ou se o item for o máximo do conjunto.
	 */
	public E sucessor(E item);
	
	/**
	 * Retorna o número de elementos (únicos) presentes no conjunto.
	 * @return O total de elementos no conjunto.
	 */
	public int tamanho();
	
	/**
	 * Busca por um item no conjunto.
	 * @param item O item a ser buscado.
	 * @return O item encontrado (que será igual ao item buscado se presente, de acordo com o método equals),
	 *         ou {@code null} se não encontrado.
	 */
	public E buscar(E item);
	
	/**
	 * Encontra o menor elemento (mínimo) no conjunto, de acordo com a ordem natural dos elementos.
	 * Requer que os elementos tenham uma ordem definida.
	 * @return O menor elemento no conjunto, ou {@code null} se o conjunto estiver vazio.
	 */
	public E minimum();
	
	/**
	 * Encontra o maior elemento (máximo) no conjunto, de acordo com a ordem natural dos elementos.
	 * Requer que os elementos tenham uma ordem definida.
	 * @return O maior elemento no conjunto, ou {@code null} se o conjunto estiver vazio.
	 */
	public E maximum();

}
