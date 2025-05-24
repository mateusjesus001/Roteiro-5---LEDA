package tad.conjuntoDinamico;

// TODO: Considerar importar e utilizar uma implementação de ListaEncadeadaIF 
// (ex: tad.listasEncadeadas.ListaEncadeadaImpl) ou uma estrutura de árvore para 
// gerenciar os elementos do conjunto, garantindo a unicidade dos elementos.

/**
 * Objetivo da Classe: Implementar a interface {@link ConjuntoDinamicoIF} para elementos do tipo {@link Integer},
 * utilizando uma estrutura de dados encadeada (não especificada, mas poderia ser uma lista encadeada ou árvore de busca).
 * Um conjunto armazena elementos únicos. A ordem dos elementos pode depender da estrutura interna utilizada.
 * OBS: Os métodos atualmente são stubs e precisam ter sua lógica implementada.
 *      Uma estrutura encadeada interna precisará ser declarada e inicializada.
 */
public class MeuConjuntoDinamicoEncadeado implements ConjuntoDinamicoIF<Integer> {

	// Exemplo de atributo que seria necessário (se usando lista):
	// private tad.listasEncadeadas.ListaEncadeadaIF<Integer> elementosConjunto;

	// TODO: Adicionar um construtor para inicializar a estrutura encadeada interna.
	// Ex: public MeuConjuntoDinamicoEncadeado() { this.elementosConjunto = new tad.listasEncadeadas.ListaEncadeadaImpl<>(); }

	/**
	 * Insere um item {@link Integer} no conjunto, se ele ainda não estiver presente.
	 * (Implementação pendente - TODO)
	 * @param item O {@link Integer} a ser inserido.
	 */
	@Override
	public void inserir(Integer item) {
		// TODO Auto-generated method stub: Implementar inserção.
		// Lógica: Verificar se o item já existe. Se não, adicionar à estrutura encadeada.
	}

	/**
	 * Remove um item {@link Integer} do conjunto, se ele estiver presente.
	 * (Implementação pendente - TODO)
	 * @param item O {@link Integer} a ser removido.
	 * @return O item removido, ou {@code null} se o item não estava no conjunto.
	 */
	@Override
	public Integer remover(Integer item) {
		// TODO Auto-generated method stub: Implementar remoção.
		// Lógica: Buscar o item. Se encontrado, remover da estrutura e retornar o item. Senão, retornar null.
		return null;
	}

	/**
	 * Encontra o predecessor de um item {@link Integer} no conjunto (o maior elemento menor que o item).
	 * (Implementação pendente - TODO)
	 * @param item O {@link Integer} cujo predecessor é desejado.
	 * @return O predecessor do item, ou {@code null} se não houver predecessor ou o item não estiver no conjunto.
	 */
	@Override
	public Integer predecessor(Integer item) {
		// TODO Auto-generated method stub: Implementar busca por predecessor.
		// Requer que o conjunto mantenha uma ordem ou seja percorrido para encontrar.
		return null;
	}

	/**
	 * Encontra o sucessor de um item {@link Integer} no conjunto (o menor elemento maior que o item).
	 * (Implementação pendente - TODO)
	 * @param item O {@link Integer} cujo sucessor é desejado.
	 * @return O sucessor do item, ou {@code null} se não houver sucessor ou o item não estiver no conjunto.
	 */
	@Override
	public Integer sucessor(Integer item) {
		// TODO Auto-generated method stub: Implementar busca por sucessor.
		// Requer que o conjunto mantenha uma ordem ou seja percorrido para encontrar.
		return null;
	}

	/**
	 * Retorna o número de elementos (únicos) presentes no conjunto.
	 * (Implementação pendente - TODO)
	 * @return O total de elementos no conjunto.
	 */
	@Override
	public int tamanho() {
		// TODO Auto-generated method stub: Implementar contagem de tamanho.
		// Ex: return elementosConjunto.size();
		return 0;
	}

	/**
	 * Busca por um item {@link Integer} no conjunto.
	 * (Implementação pendente - TODO)
	 * @param item O {@link Integer} a ser buscado.
	 * @return O item encontrado (que será igual ao item buscado se presente), ou {@code null} se não encontrado.
	 */
	@Override
	public Integer buscar(Integer item) {
		// TODO Auto-generated method stub: Implementar busca.
		// Ex: if (elementosConjunto.search(item) != null) return item; else return null;
		return null;
	}

	/**
	 * Encontra o menor elemento (mínimo) no conjunto.
	 * (Implementação pendente - TODO)
	 * @return O menor {@link Integer} no conjunto, ou {@code null} se o conjunto estiver vazio.
	 */
	@Override
	public Integer minimum() {
		// TODO Auto-generated method stub: Implementar busca por mínimo.
		// Requer que o conjunto mantenha uma ordem ou seja percorrido para encontrar.
		return null;
	}

	/**
	 * Encontra o maior elemento (máximo) no conjunto.
	 * (Implementação pendente - TODO)
	 * @return O maior {@link Integer} no conjunto, ou {@code null} se o conjunto estiver vazio.
	 */
	@Override
	public Integer maximum() {
		// TODO Auto-generated method stub: Implementar busca por máximo.
		// Requer que o conjunto mantenha uma ordem ou seja percorrido para encontrar.
		return null;
	}

}
