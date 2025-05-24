package tad.listasEncadeadas;

/**
 * Implementação de uma lista simplesmente encadeada genérica.
 * Utiliza nós sentinela para cabeça (head) e cauda (tail) para simplificar as operações de borda.
 * Os elementos são inseridos no final da lista por padrão com {@code insert(T chave)},
 * ou em um índice específico com {@code insert(T chave, int index)}.
 *
 * @param <T> o tipo de dado armazenado na lista, deve ser comparável.
 */
public class ListaEncadeadaImpl<T extends Comparable<T>> implements ListaEncadeadaIF<T>{
	
//	NodoListaEncadeada<T> cabeca = null;
	
	NodoListaEncadeada<T> cabeca = null; // Estratégia usando marcação sentinela
	NodoListaEncadeada<T> cauda = null;// Estratégia usando marcação sentinela
	private int tamanhoAtual = 0; // Adicionado
	
	/**
	 * Constrói uma lista simplesmente encadeada vazia.
     * Inicializa os nós sentinela {@code cabeca} e {@code cauda} e os interliga.
     * O tamanho da lista é inicializado como 0.
	 */
	public ListaEncadeadaImpl() {// Estratégia usando marcação sentinela
		cabeca = new NodoListaEncadeada<T>();
		cauda = new NodoListaEncadeada<T>();
		cabeca.setProximo(cauda);
		tamanhoAtual = 0; // Inicializa o tamanho
	}
	

	/**
	 * {@inheritDoc}
     * Verifica se o tamanho atual da lista é zero.
	 */
	@Override
	public boolean isEmpty() {
		return tamanhoAtual == 0;
		// Alternativamente: return cabeca.getProximo() == cauda;
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
	 */
	@Override
	public NodoListaEncadeada<T> search(T chave) {
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		while (atual != cauda) {
			if (atual.getChave() != null && atual.getChave().equals(chave)) {
				return atual; // Retorna o nodo quando encontrar a chave
			}
			atual = atual.getProximo();
		}
		return null; // Retorna null quando não encontrar a chave
	}

	/**
	 * {@inheritDoc}
	 * Insere o elemento com a chave especificada no final da lista.
     * Um novo nó é criado e posicionado entre o último nó de dados existente e a cauda sentinela.
	 */
	@Override
	public void insert(T chave) {
		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<>(chave);
		NodoListaEncadeada<T> penultimo = cabeca;
		while (penultimo.getProximo() != cauda) {
			penultimo = penultimo.getProximo();
		}
		novoNo.setProximo(cauda);
		penultimo.setProximo(novoNo);
		tamanhoAtual++;
	}

	/**
	 * {@inheritDoc}
	 * Remove a primeira ocorrência do elemento com a chave especificada.
     * Percorre a lista e, ao encontrar a chave, ajusta os ponteiros para remover o nó.
     * Cria um novo nó com a chave do elemento removido para retorná-lo (preservando o nó original da lista para GC).
	 * @return o nó contendo a chave removida, ou {@code null} se a chave não for encontrada.
	 * @throws ListaVaziaException se a lista estiver vazia antes da tentativa de remoção.
	 */
	@Override
	public NodoListaEncadeada<T> remove(T chave) {
		if (isEmpty()) {
			throw new ListaVaziaException();
		}

		NodoListaEncadeada<T> anterior = cabeca;
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		NodoListaEncadeada<T> removido = null;

		while (atual != cauda) {
			if (atual.getChave() != null && atual.getChave().equals(chave)) {
				removido = new NodoListaEncadeada<>(atual.getChave()); // Retorna uma cópia do valor no nó removido
				anterior.setProximo(atual.getProximo());
				atual.setProximo(null); // Ajuda o GC
				tamanhoAtual--;
				return removido;
			}
			anterior = atual;
			atual = atual.getProximo();
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
		
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		int i = 0;
		while (atual != cauda && i < tamanhoAtual) {
			array[i] = atual.getChave();
			i++;
			atual = atual.getProximo();
		}
		
		return array;
	}

	/**
	 * {@inheritDoc}
	 * Retorna uma representação em String dos elementos na ordem de inserção (da cabeça para a cauda),
     * separados por ", " (vírgula e espaço).
	 */
	@Override
	public String imprimeEmOrdem() {
		StringBuilder sb = new StringBuilder();
		NodoListaEncadeada<T> atual = cabeca.getProximo();
		boolean primeiro = true;
		while (atual != cauda) {
			if (!primeiro) {
				sb.append(", ");
			}
			sb.append(atual.getChave());
			primeiro = false;
			atual = atual.getProximo();
		}
		return sb.toString();
	}

	/**
	 * {@inheritDoc}
	 * Retorna uma representação em String dos elementos na ordem inversa de inserção (da cauda para a cabeça),
     * separados por ", " (vírgula e espaço). Utiliza um método auxiliar recursivo.
	 */
	@Override
	public String imprimeInverso() {
		StringBuilder sb = new StringBuilder();
		imprimeInversoRecursivo(cabeca.getProximo(), sb);
		// Remove a vírgula e o espaço extras do final, se houver, após a chamada recursiva ter preenchido.
		if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.setLength(sb.length() - 2); // Remove ", "
        }
		return sb.toString();
	}

	/**
	 * Método auxiliar recursivo para construir a string com os elementos em ordem inversa.
	 * Percorre recursivamente até o final da lista (antes da cauda sentinela) e então,
	 * no retorno das chamadas, anexa a chave do nó ao StringBuilder, seguida de ", ".
	 * @param no o nó atual na recursão (começando do primeiro nó de dados).
	 * @param sb o StringBuilder para construir a string.
	 */
	private void imprimeInversoRecursivo(NodoListaEncadeada<T> no, StringBuilder sb) {
		if (no == cauda) {
			return;
		}
		imprimeInversoRecursivo(no.getProximo(), sb);
		sb.append(no.getChave());
		sb.append(", "); 
	}

	/**
	 * {@inheritDoc}
	 * Retorna o nó sucessor ao nó que contém a chave especificada.
     * O sucessor é o próximo nó na lista após o nó com a chave dada.
	 * @return o nó sucessor (que pode ser a cauda sentinela se a chave for o último elemento de dados),
     *         ou {@code null} se a chave não for encontrada. Se o sucessor for a cauda sentinela, retorna {@code null}.
	 */
	@Override
	public NodoListaEncadeada<T> sucessor(T chave) {
		NodoListaEncadeada<T> noChave = search(chave);
        if (noChave != null) {
            NodoListaEncadeada<T> proximo = noChave.getProximo();
            return (proximo != cauda) ? proximo : null;
        }
        return null;
	}

	/**
	 * {@inheritDoc}
	 * Retorna o nó predecessor ao nó que contém a chave especificada.
     * O predecessor é o nó que antecede o nó com a chave dada.
	 * @return o nó predecessor (que pode ser a cabeça sentinela se a chave for o primeiro elemento de dados),
     *         ou {@code null} se a chave não for encontrada. Se o predecessor for a cabeça sentinela,
     *         retorna {@code null} (indicando nenhum predecessor de dados).
	 */
	@Override
	public NodoListaEncadeada<T> predecessor(T chave) {
		NodoListaEncadeada<T> anterior = cabeca;
        NodoListaEncadeada<T> atual = cabeca.getProximo();

        while (atual != cauda) {
            if (atual.getChave() != null && atual.getChave().equals(chave)) {
                return (anterior != cabeca) ? anterior : null;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        return null; // Chave não encontrada
	}

	/**
	 * {@inheritDoc}
	 * Insere um elemento na posição especificada (índice baseado em zero).
	 * Se o índice for igual ao tamanho atual da lista, o elemento é inserido no final.
     * Percorre a lista até a posição anterior ao índice de inserção e ajusta os ponteiros.
	 * @param chave o elemento a ser inserido.
	 * @param index a posição onde o elemento deve ser inserido.
	 * @throws IndexOutOfBoundsException se o índice for inválido (menor que 0 ou maior que o tamanho atual da lista).
	 */
	@Override
	public void insert(T chave, int index) {
		if (index < 0 || index > tamanhoAtual) {
			throw new IndexOutOfBoundsException("Índice inválido: " + index);
		}

		NodoListaEncadeada<T> novoNo = new NodoListaEncadeada<>(chave);
		
		NodoListaEncadeada<T> anteriorAoIndice = cabeca;
        for (int i = 0; i < index; i++) {
            anteriorAoIndice = anteriorAoIndice.getProximo();
        }
        
        novoNo.setProximo(anteriorAoIndice.getProximo());
        anteriorAoIndice.setProximo(novoNo);
		
		tamanhoAtual++;
	}

}
