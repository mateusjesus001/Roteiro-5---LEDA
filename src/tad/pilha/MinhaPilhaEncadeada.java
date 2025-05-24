package tad.pilha;

/**
 * Objetivo da Classe: Implementar a interface {@link PilhaIF} utilizando uma estrutura de dados encadeada.
 * Esta classe representa uma pilha de elementos do tipo {@code Integer}.
 * A capacidade da pilha é dinâmica, limitada principalmente pela memória disponível.
 * OBS: Os métodos atualmente são stubs e precisam ter sua lógica implementada.
 */
public class MinhaPilhaEncadeada implements PilhaIF<Integer> {
	
//	private ListaEncadeadaIF<Integer> listaEncadeada = new MinhaListaEncadeada<Integer>();

	/**
	 * Adiciona um elemento ({@code item}) ao topo da pilha.
	 * Em uma implementação encadeada, esta operação geralmente não lança PilhaCheiaException,
	 * a menos que haja falha na alocação de memória.
	 * (Implementação pendente - TODO)
	 * @param item O elemento {@code Integer} a ser empilhado.
	 * @throws PilhaCheiaException Teoricamente possível se a memória acabar, mas improvável para esta estrutura.
	 */
	@Override
	public void empilhar(Integer item) throws PilhaCheiaException {
		// TODO Auto-generated method stub: Implementar a lógica de empilhar em uma estrutura encadeada.
//		listaEncadeada.insere(item); // Exemplo de como poderia ser com uma lista encadeada.
		
	}

	/**
	 * Remove e retorna o elemento do topo da pilha.
	 * (Implementação pendente - TODO)
	 * @return O elemento {@code Integer} removido do topo da pilha.
	 * @throws PilhaVaziaException Se a pilha estiver vazia ao tentar desempilhar.
	 */
	@Override
	public Integer desempilhar() throws PilhaVaziaException {
		// TODO Auto-generated method stub: Implementar a lógica de desempilhar.
		return null;
	}

	/**
	 * Retorna o elemento do topo da pilha sem removê-lo.
	 * (Implementação pendente - TODO)
	 * @return O elemento {@code Integer} atualmente no topo da pilha, ou null se a pilha estiver vazia.
	 */
	@Override
	public Integer topo() {
		// TODO Auto-generated method stub: Implementar a lógica para visualizar o topo.
		return null;
	}

	/**
	 * Retorna uma nova pilha contendo os 'k' elementos do topo da pilha original,
     * mantendo a ordem original (o elemento do topo da original é o topo da nova).
     * A pilha original não é modificada.
	 * (Implementação pendente - TODO)
	 * @param k O número de elementos do topo a serem retornados.
	 * @return Uma nova {@code PilhaIF<Integer>} contendo os 'k' elementos do topo.
     *         Se k for <= 0, retorna uma pilha vazia.
     *         Se a pilha original tiver menos de k elementos, retorna uma pilha com todos os elementos da original.
	 */
	@Override
	public PilhaIF<Integer> multitop(int k) {
		// TODO Auto-generated method stub: Implementar a lógica de multitop para pilha encadeada.
		return null;
	}

	/**
	 * Verifica se a pilha está vazia.
	 * (Implementação pendente - TODO)
	 * @return {@code true} se a pilha não contiver elementos, {@code false} caso contrário.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub: Implementar a verificação de pilha vazia.
		return false;
	}

}
