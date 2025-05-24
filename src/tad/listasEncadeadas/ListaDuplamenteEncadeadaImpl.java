package tad.listasEncadeadas;

/**
 * Implementação de uma lista duplamente encadeada genérica.
 * Utiliza nós sentinela para cabeça (head) e cauda (tail) para simplificar as operações de borda.
 * Permite inserção (no início com {@link #inserePrimeiro(Comparable)} ou no fim com {@link #insert(Comparable)}),
 * remoção de elementos específicos ({@link #remove(Comparable)}), remoção do primeiro ({@link #removePrimeiro()})
 * e do último ({@link #removeUltimo()}), busca ({@link #search(Comparable)}), e outras operações de lista.
 * A inserção por índice {@link #insert(Comparable, int)} não é suportada por esta implementação.
 *
 * @param <T> o tipo de dado armazenado na lista, deve ser comparável.
 */
public class ListaDuplamenteEncadeadaImpl<T extends Comparable<T>> implements ListaDuplamenteEncadeadaIF<T> {
	
	NodoListaDuplamenteEncadeada<T> cabeca = null; // Nó sentinela da cabeça
	NodoListaDuplamenteEncadeada<T> cauda = null;  // Nó sentinela da cauda
	private int tamanhoAtual = 0;
	
	/**
	 * Constrói uma lista duplamente encadeada vazia.
     * Inicializa os nós sentinela {@code cabeca} e {@code cauda}, interligando-os
     * para representar uma lista vazia (cabeca.proximo = cauda, cauda.anterior = cabeca).
     * O tamanho da lista é inicializado como 0.
	 */
	public ListaDuplamenteEncadeadaImpl() {
		cabeca = new NodoListaDuplamenteEncadeada<T>();
		cauda = new NodoListaDuplamenteEncadeada<T>();
		cabeca.setProximo(cauda);
		cauda.setAnterior(cabeca);
		cabeca.setAnterior(null); // Sentinela cabeça não tem anterior
		cauda.setProximo(null);   // Sentinela cauda não tem próximo
		tamanhoAtual = 0;
	}

	/**
	 * {@inheritDoc}
     * Verifica se o tamanho atual da lista é zero.
	 */
	@Override
	public boolean isEmpty() {
		return tamanhoAtual == 0; 
	}

	/**
	 * {@inheritDoc}
     * Retorna o valor do contador interno de tamanho.
	 */
	@Override
	public int size() {
		return tamanhoAtual;
	}

	/**
	 * {@inheritDoc}
	 * Percorre a lista a partir do primeiro nó de dados (após a cabeça sentinela)
     * até encontrar um nó cuja chave seja igual à chave fornecida.
	 * Retorna o nó que contém a chave, ou {@code null} se não for encontrado antes de atingir a cauda sentinela.
     * Realiza downcast para {@link NodoListaDuplamenteEncadeada} ao percorrer.
	 */
	@Override
	public NodoListaDuplamenteEncadeada<T> search(T chave) {
		NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
		while (atual != cauda) {
			if (atual.getChave() != null && atual.getChave().equals(chave)) {
				return atual;
			}
			atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
		}
		return null; // Não encontrado
	}

	/**
	 * {@inheritDoc}
	 * Insere o elemento com a chave especificada no final da lista (antes do nó sentinela cauda).
     * Os ponteiros {@code anterior} e {@code proximo} dos nós envolvidos são ajustados.
	 */
	@Override
	public void insert(T chave) {
		NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<T>(chave);
		NodoListaDuplamenteEncadeada<T> penultimo = cauda.getAnterior();

		penultimo.setProximo(novoNo);
		novoNo.setAnterior(penultimo);
		novoNo.setProximo(cauda);
		cauda.setAnterior(novoNo);

		tamanhoAtual++;
	}

	/**
	 * {@inheritDoc}
	 * Remove a primeira ocorrência do elemento com a chave especificada.
     * Utiliza o método {@link #search(Comparable)} para encontrar o nó.
     * Se encontrado e não for um sentinela, os ponteiros dos nós vizinhos são reajustados.
     * Os ponteiros do nó removido são limpos (setados para null).
	 * @return o nó removido, ou {@code null} se a chave não for encontrada ou se o nó encontrado for um sentinela (o que não deveria ocorrer em uma busca normal por chave de dados).
	 * @throws ListaVaziaException se a lista estiver vazia antes da tentativa de remoção.
	 */
	@Override
	public NodoListaDuplamenteEncadeada<T> remove(T chave) {
		if (isEmpty()) {
			throw new ListaVaziaException();
		}

		NodoListaDuplamenteEncadeada<T> noParaRemover = search(chave);

		if (noParaRemover != null && noParaRemover != cabeca && noParaRemover != cauda) {
			NodoListaDuplamenteEncadeada<T> anterior = noParaRemover.getAnterior();
			NodoListaDuplamenteEncadeada<T> proximo = (NodoListaDuplamenteEncadeada<T>) noParaRemover.getProximo();

			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);

			noParaRemover.setAnterior(null); 
			noParaRemover.setProximo(null);
			tamanhoAtual--;
			return noParaRemover;
		}
		return null; 
	}

	/**
	 * {@inheritDoc}
	 * Retorna uma representação em String dos elementos na ordem de inserção (da cabeça para a cauda),
     * separados por ", " (vírgula e espaço).
	 */
	@Override
	public String imprimeEmOrdem() {
		StringBuilder sb = new StringBuilder();
		NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
		boolean primeiro = true;
		while (atual != cauda) {
			if (!primeiro) {
                sb.append(", ");
            }
			sb.append(atual.getChave());
			primeiro = false;
			atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
		}
		return sb.toString();
	}

	/**
	 * {@inheritDoc}
	 * Retorna uma representação em String dos elementos na ordem inversa de inserção (da cauda para a cabeça),
     * separados por ", " (vírgula e espaço).
	 */
	@Override
	public String imprimeInverso() {
		StringBuilder sb = new StringBuilder();
		NodoListaDuplamenteEncadeada<T> atual = cauda.getAnterior();
		boolean primeiro = true;
		while (atual != cabeca) {
			if (!primeiro) {
                sb.append(", ");
            }
			sb.append(atual.getChave());
			primeiro = false;
			atual = atual.getAnterior();
		}
		return sb.toString();
	}

	/**
	 * {@inheritDoc}
	 * Retorna o nó sucessor ao nó que contém a chave especificada.
     * O sucessor é o próximo nó na lista após o nó com a chave dada, desde que não seja o sentinela cauda.
	 * @return o nó sucessor, ou {@code null} se a chave não for encontrada ou se o sucessor for o sentinela cauda.
	 */
	@Override
	public NodoListaDuplamenteEncadeada<T> sucessor(T chave) {
		NodoListaDuplamenteEncadeada<T> noEncontrado = search(chave);
		if (noEncontrado != null) {
            NodoListaEncadeada<T> proximo = noEncontrado.getProximo();
            if (proximo != cauda) {
                return (NodoListaDuplamenteEncadeada<T>) proximo;
            }
        }
		return null;
	}

	/**
	 * {@inheritDoc}
	 * Retorna o nó predecessor ao nó que contém a chave especificada.
     * O predecessor é o nó anterior ao nó com a chave dada, desde que não seja o sentinela cabeça.
	 * @return o nó predecessor, ou {@code null} se a chave não for encontrada ou se o predecessor for o sentinela cabeça.
	 */
	@Override
	public NodoListaDuplamenteEncadeada<T> predecessor(T chave) {
		NodoListaDuplamenteEncadeada<T> noEncontrado = search(chave);
		if (noEncontrado != null) {
            NodoListaDuplamenteEncadeada<T> anterior = noEncontrado.getAnterior();
            if (anterior != cabeca) {
                return anterior;
            }
        }
		return null;
	}

	/**
	 * {@inheritDoc}
     * Cria um array do tipo {@code T} com o tamanho atual da lista.
     * Copia as chaves dos nós da lista para o array, na ordem em que aparecem na lista.
	 * @return um array contendo todos os elementos da lista na ordem de inserção,
	 *         ou {@code null} se a lista estiver vazia (conforme implementação atual).
	 */
	@Override
	public T[] toArray(Class<T> clazz) {
		if (isEmpty()) {
			// Seria mais consistente retornar um array vazio: return (T[]) java.lang.reflect.Array.newInstance(clazz, 0);
			return null;
		}
		@SuppressWarnings("unchecked")
		T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, tamanhoAtual);
		NodoListaDuplamenteEncadeada<T> atual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
		int i = 0;
		while (atual != cauda) {
			array[i++] = atual.getChave();
			atual = (NodoListaDuplamenteEncadeada<T>) atual.getProximo();
		}
		return array;
	}

	/**
	 * {@inheritDoc}
	 * Insere o elemento no início da lista (imediatamente após o nó sentinela cabeça).
     * Os ponteiros {@code anterior} e {@code proximo} dos nós envolvidos são ajustados.
	 */
	@Override
	public void inserePrimeiro(T elemento) {
		NodoListaDuplamenteEncadeada<T> novoNo = new NodoListaDuplamenteEncadeada<T>(elemento);
		NodoListaDuplamenteEncadeada<T> primeiroAtual = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();

		novoNo.setProximo(primeiroAtual);
        primeiroAtual.setAnterior(novoNo); // primeiroAtual nunca será null devido ao sentinela cauda
		cabeca.setProximo(novoNo);
		novoNo.setAnterior(cabeca);

		tamanhoAtual++;		
	}

	/**
	 * {@inheritDoc}
     * Remove e retorna o último nó de dados da lista (o nó imediatamente anterior ao sentinela cauda).
	 * @return o nó removido, ou {@code null} se a lista estiver vazia.
     * @throws ListaVaziaException se a lista estiver vazia.
	 */
	@Override
	public NodoListaDuplamenteEncadeada<T> removeUltimo() {
		if (isEmpty()) {
			throw new ListaVaziaException(); // Lançar exceção em vez de retornar null para ser consistente
		}
		NodoListaDuplamenteEncadeada<T> ultimoNo = cauda.getAnterior();
        // Não é necessário verificar se ultimoNo é cabeca, pois isEmpty() já tratou.
		NodoListaDuplamenteEncadeada<T> penultimoNo = ultimoNo.getAnterior();

		penultimoNo.setProximo(cauda);
		cauda.setAnterior(penultimoNo);

		ultimoNo.setAnterior(null);
		ultimoNo.setProximo(null);
		tamanhoAtual--;
		return ultimoNo;
	}

	/**
	 * {@inheritDoc}
     * Remove e retorna o primeiro nó de dados da lista (o nó imediatamente após o sentinela cabeça).
	 * @return o nó removido, ou {@code null} se a lista estiver vazia.
     * @throws ListaVaziaException se a lista estiver vazia.
	 */
	@Override
	public NodoListaDuplamenteEncadeada<T> removePrimeiro() {
		if (isEmpty()) {
			throw new ListaVaziaException(); // Lançar exceção
		}
		NodoListaDuplamenteEncadeada<T> primeiroNo = (NodoListaDuplamenteEncadeada<T>) cabeca.getProximo();
        // Não é necessário verificar se primeiroNo é cauda, pois isEmpty() já tratou.
		NodoListaDuplamenteEncadeada<T> segundoNo = (NodoListaDuplamenteEncadeada<T>) primeiroNo.getProximo();

		cabeca.setProximo(segundoNo);
		segundoNo.setAnterior(cabeca);

		primeiroNo.setAnterior(null);
		primeiroNo.setProximo(null);
		tamanhoAtual--;
		return primeiroNo;
	}

	/**
	 * {@inheritDoc}
	 * Este método não é suportado por esta implementação de lista duplamente encadeada.
     * A inserção por índice pode ser ineficiente e geralmente não é uma operação primária
     * para listas duplamente encadeadas focadas em manipulação de extremidades.
	 * @param chave A chave do elemento a ser inserido.
     * @param index O índice onde a inserção ocorreria.
	 * @throws UnsupportedOperationException sempre, pois a operação não é suportada.
	 */
	@Override
	public void insert(T chave, int index) {
		throw new UnsupportedOperationException("Operação de inserção por índice não suportada por esta implementação de ListaDuplamenteEncadeadaImpl.");
	}
}
