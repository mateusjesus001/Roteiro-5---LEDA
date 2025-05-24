package tad.fila;

/**
 * Objetivo da Interface: Define o contrato para uma estrutura de dados do tipo Fila (Queue).
 * Especifica as operações fundamentais que uma fila deve suportar, como enfileirar,
 * desenfileirar, verificar cabeça e cauda, e checar estados de vazia ou cheia.
 * @param <E> O tipo do dado armazenado na fila.
 */
public interface FilaIF<E> {
	
	/**
	 * Adiciona um elemento ao final (cauda) da fila.
	 * @param item O elemento a ser adicionado à fila.
	 * @throws FilaCheiaException Se a fila estiver cheia e não puder aceitar novos elementos.
	 */
	public void enfileirar(E item) throws FilaCheiaException;
	
	/**
	 * Remove e retorna o elemento do início (cabeça) da fila.
	 * @return O elemento removido do início da fila.
	 * @throws FilaVaziaException Se a fila estiver vazia ao tentar desenfileirar.
	 */
	public E desenfileirar() throws FilaVaziaException;
	
	/**
	 * Retorna o elemento no final (cauda) da fila sem removê-lo.
	 * @return O elemento atualmente na cauda da fila, ou {@code null} se a fila estiver vazia (dependendo da implementação).
	 */
	public E verificarCauda();
	
	/**
	 * Retorna o elemento no início (cabeça) da fila sem removê-lo.
	 * (Também conhecido como peek ou front).
	 * @return O elemento atualmente na cabeça da fila, ou {@code null} se a fila estiver vazia (dependendo da implementação).
	 */
	public E verificarCabeca();
	
	/**
	 * Verifica se a fila está vazia.
	 * @return {@code true} se a fila não contiver elementos, {@code false} caso contrário.
	 */
	public boolean isEmpty();
	
	/**
	 * Verifica se a fila está cheia (atingiu sua capacidade máxima).
	 * @return {@code true} se a fila estiver cheia, {@code false} caso contrário.
	 */
	public boolean isFull();

}
