package tad.listasEncadeadas;

import tad.fila.FilaCheiaException;
import tad.fila.FilaIF;
import tad.fila.FilaVaziaException;

/**
 * Objetivo da Classe: Implementar a interface {@link FilaIF} utilizando uma lista encadeada como estrutura de armazenamento subjacente.
 * Esta fila armazena elementos do tipo {@link NodoListaEncadeada}&lt;Integer&gt;.
 * Observação: A declaração da variável interna {@code fila} como {@code ListaEncadeadaIF<Integer>} parece inconsistente
 * com o tipo de dado da fila ({@code NodoListaEncadeada<Integer>}). Idealmente, seria {@code ListaEncadeadaIF<NodoListaEncadeada<Integer>>}.
 * Os métodos atualmente são stubs e precisam ter sua lógica implementada.
 */
public class FilaListaEncadeada implements FilaIF<NodoListaEncadeada<Integer>> {
	
	// Atributo para armazenar os elementos da fila. Deveria ser ListaEncadeadaIF<NodoListaEncadeada<Integer>> para consistência.
	private ListaEncadeadaIF<Integer> fila; 

    // TODO: Adicionar um construtor para inicializar a lista interna 'fila'. 
    // Ex: public FilaListaEncadeada() { this.fila = new ListaEncadeadaImpl<>(); }
    // (ajustando o tipo da lista interna conforme o comentário acima)

	/**
	 * Adiciona um item (um {@link NodoListaEncadeada}&lt;Integer&gt;) ao final da fila.
	 * (Implementação pendente - TODO)
	 * @param item O {@link NodoListaEncadeada}&lt;Integer&gt; a ser adicionado à fila.
	 * @throws FilaCheiaException Em uma implementação com lista encadeada sem limite de capacidade explícito,
     *                            esta exceção geralmente não é lançada, a menos que ocorra falta de memória.
	 */
	@Override
	public void enfileirar(NodoListaEncadeada<Integer> item) throws FilaCheiaException {
		// TODO Auto-generated method stub: Implementar a lógica de enfileirar usando a lista interna.
		// Ex: this.fila.insert(item); (considerando o tipo correto para 'fila')
	}

	/**
	 * Remove e retorna o item do início (cabeça) da fila.
	 * (Implementação pendente - TODO)
	 * @return O {@link NodoListaEncadeada}&lt;Integer&gt; removido do início da fila.
	 * @throws FilaVaziaException Se a fila estiver vazia ao tentar desenfileirar.
	 */
	@Override
	public NodoListaEncadeada<Integer> desenfileirar() throws FilaVaziaException {
		// TODO Auto-generated method stub: Implementar a lógica de desenfileirar.
		// Ex: if (isEmpty()) throw new FilaVaziaException(); 
        //     return this.fila.remove(this.fila.search(verificarCabeca().getChave())); // Exemplo complexo, idealmente a lista teria removePrimeiro()
		return null;
	}

	/**
	 * Retorna o último item adicionado à fila (cauda) sem removê-lo.
	 * (Implementação pendente - TODO)
	 * @return O {@link NodoListaEncadeada}&lt;Integer&gt; na cauda da fila, ou {@code null} se a fila estiver vazia.
	 */
	@Override
	public NodoListaEncadeada<Integer> verificarCauda() {
		// TODO Auto-generated method stub: Implementar a lógica para verificar a cauda.
		// Ex: Se a lista interna for usada no sentido padrão, pode ser o último elemento da lista.
		return null;
	}

	/**
	 * Retorna o primeiro item da fila (cabeça) sem removê-lo.
	 * (Implementação pendente - TODO)
	 * @return O {@link NodoListaEncadeada}&lt;Integer&gt; na cabeça da fila, ou {@code null} se a fila estiver vazia.
	 */
	@Override
	public NodoListaEncadeada<Integer> verificarCabeca() {
		// TODO Auto-generated method stub: Implementar a lógica para verificar a cabeça.
		// Ex: Se a lista interna for usada no sentido padrão, pode ser o primeiro elemento da lista.
		return null;
	}

	/**
	 * Verifica se a fila está vazia.
	 * (Implementação pendente - TODO)
	 * @return {@code true} se a fila não contiver elementos, {@code false} caso contrário.
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub: Implementar a verificação de fila vazia.
		// Ex: return this.fila.isEmpty(); (se 'fila' for inicializada)
		return false;
	}

	/**
	 * Verifica se a fila está cheia.
	 * Em uma implementação com lista encadeada, geralmente uma fila não fica "cheia" a menos que
	 * haja um limite de capacidade artificial ou falta de memória.
	 * (Implementação pendente - TODO)
	 * @return {@code false} para uma implementação típica de fila com lista encadeada sem limite explícito,
     *         a menos que uma capacidade seja definida.
	 */
	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub: Implementar a verificação de fila cheia.
		// Ex: return false; // Para lista encadeada sem limite de capacidade
		return false;
	}

}
