package tad.pilha;

/**
 * Objetivo da Interface: Define o contrato para uma estrutura de dados do tipo Pilha (Stack).
 * Especifica as operações fundamentais que uma pilha deve suportar, como empilhar,
 * desempilhar, verificar o topo e checar se está vazia.
 */
public interface PilhaIF<E> {
	
	/**
	 * Adiciona um elemento ao topo da pilha.
	 * @param item O elemento a ser empilhado.
	 * @throws PilhaCheiaException Se a pilha estiver cheia e não puder aceitar novos elementos.
	 */
	public void empilhar(E item) throws PilhaCheiaException;
	
	/**
	 * Remove e retorna o elemento do topo da pilha.
	 * @return O elemento removido do topo da pilha.
	 * @throws PilhaVaziaException Se a pilha estiver vazia ao tentar desempilhar.
	 */
	public E desempilhar() throws PilhaVaziaException;
	
	/**
	 * Retorna o elemento do topo da pilha sem removê-lo.
	 * @return O elemento atualmente no topo da pilha, ou null/lança exceção se estiver vazia (depende da implementação).
	 */
	public E topo();
	
	/**
	 * Retorna uma nova pilha contendo os 'k' elementos do topo da pilha original,
     * mantendo a ordem original (o elemento do topo da original é o topo da nova).
     * A pilha original não é modificada.
	 * @param k O número de elementos do topo a serem retornados.
	 * @return Uma nova PilhaIF contendo os 'k' elementos do topo, ou uma pilha vazia se 'k' for 0 ou a pilha original tiver menos de 'k' elementos.
	 */
	public PilhaIF<E> multitop(int k);
	
	/**
	 * Verifica se a pilha está vazia.
	 * @return true se a pilha não contiver elementos, false caso contrário.
	 */
	public boolean isEmpty();

}
