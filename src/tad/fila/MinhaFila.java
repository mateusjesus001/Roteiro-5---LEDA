package tad.fila;

/**
 * Implementação de uma fila de elementos do tipo {@link Integer} utilizando um array de tamanho fixo com estratégia circular.
 * A fila segue o princípio FIFO (First-In, First-Out).
 * Mantém ponteiros para a cabeça (início da fila) e cauda (próxima posição livre para inserção),
 * além de um contador para o número de elementos.
 */
public class MinhaFila implements FilaIF<Integer> {
	
	private int tamanho; // Capacidade máxima da fila
	
	private int cabeca;       // Índice do elemento na cabeça da fila
	private int cauda;        // Índice da próxima posição livre onde um elemento será inserido
	private int numElementos; // Número atual de elementos na fila
	
	private Integer[] meusDados = null;

	/**
	 * Constrói uma nova fila com a capacidade especificada.
	 * Se o tamanho especificado for menor ou igual a zero, a capacidade padrão de 10 é utilizada.
	 * @param tamanhoEspecificado a capacidade máxima da fila.
	 */
	public MinhaFila(int tamanhoEspecificado) {
		this.tamanho = tamanhoEspecificado > 0 ? tamanhoEspecificado : 10; 
		meusDados = new Integer[this.tamanho];
		cabeca = 0;
		cauda = 0;
		numElementos = 0;
	}
	
	/**
	 * Constrói uma nova fila com uma capacidade padrão de 10 elementos.
	 */
	public MinhaFila() {
		this(10); // Chama o construtor parametrizado com o tamanho padrão
	}

	/**
	 * {@inheritDoc}
     * Adiciona o item na posição indicada pelo índice {@code cauda} e avança {@code cauda}
     * de forma circular. Incrementa o número de elementos.
	 * @throws FilaCheiaException se a fila estiver cheia ({@code numElementos == tamanho}).
	 */
	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		if (isFull()) {
			throw new FilaCheiaException();
		}
		meusDados[cauda] = item;
		cauda = (cauda + 1) % tamanho;
		numElementos++;
	}

	/**
	 * {@inheritDoc}
     * Remove o item da posição indicada pelo índice {@code cabeca} e avança {@code cabeca}
     * de forma circular. Decrementa o número de elementos.
     * A posição do item removido no array é opcionalmente setada para {@code null}.
	 * @throws FilaVaziaException se a fila estiver vazia ({@code numElementos == 0}).
	 */
	@Override
	public Integer desenfileirar() throws FilaVaziaException {
		if (isEmpty()) {
			throw new FilaVaziaException();
		}
		Integer itemRemovido = meusDados[cabeca];
		meusDados[cabeca] = null; 
		cabeca = (cabeca + 1) % tamanho;
		numElementos--;
		return itemRemovido;
	}

	/**
	 * {@inheritDoc}
	 * Retorna o último elemento inserido na fila (o mais recente, que está logicamente
     * antes da posição {@code cauda}) sem removê-lo.
	 * @return o elemento na cauda lógica da fila, ou {@code null} se a fila estiver vazia.
	 */
	@Override
	public Integer verificarCauda() {
		if (isEmpty()) {
			return null;
		}
		// O último elemento inserido está na posição (cauda - 1) circularmente.
		int indiceUltimoElemento = (cauda - 1 + tamanho) % tamanho;
		return meusDados[indiceUltimoElemento];
	}

	/**
	 * {@inheritDoc}
     * Retorna o elemento na posição {@code cabeca} (início da fila) sem removê-lo.
	 * @return o elemento na cabeça da fila, ou {@code null} se a fila estiver vazia.
	 */
	@Override
	public Integer verificarCabeca() {
		if (isEmpty()) {
			return null;
		}
		return meusDados[cabeca];
	}

	/**
	 * {@inheritDoc}
     * Verifica se o contador {@code numElementos} é igual a zero.
	 */
	@Override
	public boolean isEmpty() {
		return numElementos == 0;
	}

	/**
	 * {@inheritDoc}
     * Verifica se o contador {@code numElementos} é igual à capacidade ({@code tamanho}) da fila.
	 */
	@Override
	public boolean isFull() {
		return numElementos == tamanho;
	}

}
