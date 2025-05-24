package tad.conjuntoDinamico;

/**
 * Implementação de um conjunto dinâmico de inteiros usando um array.
 * Este conjunto armazena elementos únicos na ordem em que são inseridos.
 * O array interno cresce dinamicamente conforme necessário quando novos elementos são adicionados.
 * Operações como predecessor e sucessor são baseadas na ordem de inserção dos elementos.
 */
public class MeuConjuntoDinamico implements ConjuntoDinamicoIF<Integer>{

	
	private static final int TAMANHO_INICIAL = 10;
	private Integer[] meusDados = null;
	private int posInsercao = 0; // Indica o número de elementos e a próxima posição de inserção
	
	/**
	 * Constrói um novo conjunto dinâmico com uma capacidade inicial padrão (10 elementos).
	 */
	public MeuConjuntoDinamico() {
		meusDados = new Integer[TAMANHO_INICIAL];
	}

	/**
	 * {@inheritDoc}
	 * Insere o item no final da sequência de elementos do conjunto.
	 * Se o array interno estiver cheio, sua capacidade é dobrada antes da inserção.
	 * Esta implementação não verifica duplicatas explicitamente na inserção, permitindo múltiplas
	 * instâncias do mesmo valor se inseridas sequencialmente, comportando-se mais como uma lista
	 * nesta operação específica, embora a interface seja de Conjunto.
	 */
	@Override
	public void inserir(Integer item) {
		if (meusDados == null) { // Salvaguarda caso o construtor não seja chamado (improvável)
			meusDados = new Integer[TAMANHO_INICIAL];
		}
		if (posInsercao == meusDados.length) {
			meusDados = aumentarArray();
		}
		meusDados[posInsercao] = item;
		posInsercao++;
	}
	
	/**
	 * Dobra o tamanho do array interno que armazena os elementos do conjunto.
	 * Os elementos existentes (até {@code posInsercao}) são copiados para o novo array.
	 * Se o array atual tiver tamanho 0, o novo tamanho será {@code TAMANHO_INICIAL}.
	 * @return Um novo array com o dobro da capacidade (ou TAMANHO_INICIAL) e os elementos do array antigo.
	 */
	private Integer[] aumentarArray() {
		int novoTamanho = (meusDados.length == 0) ? TAMANHO_INICIAL : meusDados.length * 2;
		Integer[] arrayMaior = new Integer[novoTamanho];
		for (int i = 0; i < posInsercao; i++) { 
			arrayMaior[i] = meusDados[i];
		}
		return arrayMaior;
	}

	/**
	 * {@inheritDoc}
	 * Remove a primeira ocorrência do item especificado do conjunto (considerando a ordem de inserção).
	 * Após a remoção, os elementos subsequentes no array são deslocados para a esquerda para preencher o espaço.
	 * A última posição anteriormente ocupada é setada para {@code null}.
	 * @param item O item a ser removido.
	 * @return O item removido.
	 * @throws RuntimeException se o item não for encontrado no conjunto para remoção.
	 */
	@Override
	public Integer remover(Integer item) {
		int indiceRemover = -1;
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i] != null && meusDados[i].equals(item)) { // Adicionado null check
				indiceRemover = i;
				break;
			}
		}

		if (indiceRemover == -1) {
			throw new RuntimeException("Elemento não encontrado para remoção: " + item);
		}

		Integer itemRemovido = meusDados[indiceRemover];

		for (int i = indiceRemover; i < posInsercao - 1; i++) {
			meusDados[i] = meusDados[i + 1];
		}
		meusDados[posInsercao - 1] = null; 
		posInsercao--;

		return itemRemovido;
	}

	/**
	 * {@inheritDoc}
	 * Retorna o elemento que foi inserido imediatamente antes do item especificado, baseado na ordem de inserção.
	 * @param item o item cujo predecessor (baseado na ordem de inserção) é buscado.
	 * @return o item predecessor, ou {@code null} se o item especificado for o primeiro
	 *         elemento inserido (índice 0) ou não tiver um predecessor direto na ordem de inserção.
	 * @throws RuntimeException se o conjunto estiver vazio ou se o item não for encontrado.
	 */
	@Override
	public Integer predecessor(Integer item) {
		if (posInsercao == 0) {
			throw new RuntimeException("Conjunto vazio, não é possível encontrar predecessor.");
		}
		int indiceItem = -1;
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i] != null && meusDados[i].equals(item)) { // Adicionado null check
				indiceItem = i;
				break;
			}
		}

		if (indiceItem == -1) {
			throw new RuntimeException("Elemento não encontrado para buscar predecessor: " + item);
		}

		if (indiceItem == 0) {
			return null; // Primeiro elemento não tem predecessor na ordem de inserção
		}
		return meusDados[indiceItem - 1];
	}

	/**
	 * {@inheritDoc}
	 * Retorna o elemento que foi inserido imediatamente após o item especificado, baseado na ordem de inserção.
	 * @param item o item cujo sucessor (baseado na ordem de inserção) é buscado.
	 * @return o item sucessor, ou {@code null} se o item especificado for o último
	 *         elemento inserido ou não existir um sucessor direto na ordem de inserção.
	 * @throws RuntimeException se o conjunto estiver vazio ou se o item não for encontrado.
	 */
	@Override
	public Integer sucessor(Integer item) {
		if (posInsercao == 0) {
			throw new RuntimeException("Conjunto vazio, não é possível encontrar sucessor.");
		}
		int indiceItem = -1;
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i] != null && meusDados[i].equals(item)) { // Adicionado null check
				indiceItem = i;
				break;
			}
		}

		if (indiceItem == -1) {
			throw new RuntimeException("Elemento não encontrado para buscar sucessor: " + item);
		}

		if (indiceItem == posInsercao - 1) {
			return null; // Último elemento não tem sucessor na ordem de inserção
		}
		return meusDados[indiceItem + 1];
	}

	/**
	 * {@inheritDoc}
     * Retorna o número de elementos atualmente armazenados no conjunto ({@code posInsercao}).
	 */
	@Override
	public int tamanho() {
		return posInsercao;
	}

	/**
	 * {@inheritDoc}
     * Busca o item no conjunto e o retorna se encontrado.
     * Diferente da especificação da interface que sugere retornar {@code null} se não encontrado,
     * esta implementação lança uma {@link RuntimeException}.
	 * @param item O item a ser buscado.
     * @return O item encontrado.
	 * @throws RuntimeException se o item não for encontrado no conjunto.
	 */
	@Override
	public Integer buscar(Integer item) {
		for (int i = 0; i < posInsercao; i++) {
			if (meusDados[i] != null && meusDados[i].equals(item)) { // Adicionado null check
				return meusDados[i];
			}
		}
		throw new RuntimeException("Elemento não encontrado no conjunto: " + item);
	}

	/**
	 * {@inheritDoc}
     * Encontra e retorna o menor valor numérico presente no conjunto.
     * Percorre todos os elementos armazenados para determinar o mínimo.
	 * @throws RuntimeException se o conjunto estiver vazio.
	 */
	@Override
	public Integer minimum() {
		if (posInsercao == 0) {
			throw new RuntimeException("Conjunto vazio, não há mínimo."); 
		}
		Integer minimo = meusDados[0];
		for (int i = 1; i < posInsercao; i++) {
			if (meusDados[i] != null && meusDados[i].compareTo(minimo) < 0) { // Adicionado null check
				minimo = meusDados[i];
			}
		}
		return minimo;
	}

	/**
	 * {@inheritDoc}
     * Encontra e retorna o maior valor numérico presente no conjunto.
     * Percorre todos os elementos armazenados para determinar o máximo.
	 * @throws RuntimeException se o conjunto estiver vazio.
	 */
	@Override
	public Integer maximum() {
		if (posInsercao == 0) {
			throw new RuntimeException("Conjunto vazio, não há máximo."); 
		}
		Integer maximo = meusDados[0];
		for (int i = 1; i < posInsercao; i++) {
			if (meusDados[i] != null && meusDados[i].compareTo(maximo) > 0) { // Adicionado null check
				maximo = meusDados[i];
			}
		}
		return maximo;
	}

}
