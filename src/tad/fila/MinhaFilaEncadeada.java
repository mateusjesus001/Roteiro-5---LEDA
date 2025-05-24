package tad.fila;

// TODO: Considerar importar e utilizar uma implementação de ListaEncadeadaIF, 
// por exemplo, tad.listasEncadeadas.ListaEncadeadaImpl ou tad.listasEncadeadas.ListaDuplamenteEncadeadaImpl
// para gerenciar os elementos da fila.

/**
 * Objetivo da Classe: Implementar a interface {@link FilaIF} para elementos do tipo {@link Integer},
 * utilizando uma estrutura de dados encadeada (não especificada, mas presumivelmente uma lista encadeada) internamente.
 * OBS: Os métodos atualmente são stubs e precisam ter sua lógica implementada.
 *      Uma lista encadeada interna precisará ser declarada e inicializada.
 */
public class MinhaFilaEncadeada implements FilaIF<Integer> {

	// Exemplo de atributo que seria necessário:
	// private tad.listasEncadeadas.ListaEncadeadaIF<Integer> elementosFila;

	// TODO: Adicionar um construtor para inicializar a estrutura encadeada interna.
	// Ex: public MinhaFilaEncadeada() { this.elementosFila = new tad.listasEncadeadas.ListaEncadeadaImpl<>(); }

	/**
	 * Adiciona um item {@link Integer} ao final da fila.
	 * (Implementação pendente - TODO)
	 * @param item O {@link Integer} a ser adicionado à fila.
	 * @throws FilaCheiaException Em uma implementação com lista encadeada sem limite de capacidade explícito,
     *                            esta exceção geralmente não é lançada, a menos que ocorra falta de memória.
	 */
	@Override
	public void enfileirar(Integer item) throws FilaCheiaException {
		// TODO Auto-generated method stub: Implementar enfileiramento usando lista encadeada.
		// Ex: elementosFila.insert(item); (geralmente no final da lista)
	}

	/**
	 * Remove e retorna o item {@link Integer} do início (cabeça) da fila.
	 * (Implementação pendente - TODO)
	 * @return O {@link Integer} removido do início da fila.
	 * @throws FilaVaziaException Se a fila estiver vazia ao tentar desenfileirar.
	 */
	@Override
	public Integer desenfileirar() throws FilaVaziaException {
		// TODO Auto-generated method stub: Implementar desenfileiramento.
		// Ex: if (isEmpty()) throw new FilaVaziaException(); 
        //     Integer item = elementosFila.search(/*primeiro elemento*/).getChave(); 
        //     elementosFila.remove(/*primeiro elemento*/); return item; 
        //     (Idealmente, a lista teria um método como removePrimeiro() que retorna o elemento)
		return null;
	}

	/**
	 * Retorna o último item adicionado à fila (cauda) sem removê-lo.
	 * (Implementação pendente - TODO)
	 * @return O {@link Integer} na cauda da fila, ou {@code null} se a fila estiver vazia.
	 */
	@Override
	public Integer verificarCauda() {
		// TODO Auto-generated method stub: Implementar visualização da cauda.
		// Ex: elementosFila.search(/*último elemento*/).getChave();
		return null;
	}

	/**
	 * Retorna o primeiro item da fila (cabeça) sem removê-lo.
	 * (Implementação pendente - TODO)
	 * @return O {@link Integer} na cabeça da fila, ou {@code null} se a fila estiver vazia.
	 */
	@Override
	public Integer verificarCabeca() {
		// TODO Auto-generated method stub: Implementar visualização da cabeça.
        // Ex: elementosFila.search(/*primeiro elemento*/).getChave();
		return null;
	}

	/**
	 * Verifica se a fila está vazia.
	 * (Implementação pendente - TODO)
	 * @return {@code true} se a fila não contiver elementos, {@code false} caso contrário.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub: Implementar verificação de fila vazia.
        // Ex: return elementosFila.isEmpty();
		return false;
	}

	/**
	 * Verifica se a fila está cheia.
	 * Para uma implementação com lista encadeada sem limite explícito, geralmente retorna {@code false}.
	 * (Implementação pendente - TODO)
	 * @return {@code false} (tipicamente).
	 */
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub: Implementar verificação de fila cheia.
        // Ex: return false;
		return false;
	}

}
