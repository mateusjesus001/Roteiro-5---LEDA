package tad.listasEncadeadas;

/**
 * Objetivo da Classe: Representar um nó individual em uma lista simplesmente encadeada.
 * Cada nó armazena uma chave (valor) de um tipo genérico {@code T} que deve ser comparável,
 * e uma referência para o próximo nó na lista.
 * @param <T> O tipo do dado armazenado no nó, deve implementar {@link Comparable}.
 */
public class NodoListaEncadeada<T extends Comparable<T>> {
	
	protected T chave;
	protected NodoListaEncadeada<T> proximo = null;
	
	/**
	 * Construtor padrão. Inicializa a chave e o próximo nó como nulos.
	 */
	public NodoListaEncadeada() {
		this.setChave(null);
		this.setProximo(null);
	}
	
	/**
	 * Construtor que inicializa o nó com uma chave específica.
	 * O próximo nó é inicializado como nulo.
	 * @param chave O valor a ser armazenado neste nó.
	 */
	public NodoListaEncadeada(T chave) {
		this.setChave(chave);
		this.setProximo(null);
	}
	
	/**
	 * Construtor que inicializa o nó com uma chave e uma referência para o próximo nó.
	 * @param chave O valor a ser armazenado neste nó.
	 * @param proximo A referência para o próximo nó na lista.
	 */
	public NodoListaEncadeada(T chave, NodoListaEncadeada<T> proximo) {
		this.setChave(chave);
		this.setProximo(proximo);
	}

	/**
	 * Retorna a chave armazenada neste nó.
	 * @return A chave armazenada neste nó.
	 */
	public T getChave() {
		return chave;
	}

	/**
	 * Define a chave armazenada neste nó.
	 * @param chave A nova chave a ser armazenada neste nó.
	 */
	public void setChave(T chave) {
		this.chave = chave;
	}

	/**
	 * Retorna o próximo nó na lista encadeada.
	 * @return O próximo nó na lista encadeada.
	 */
	public NodoListaEncadeada<T> getProximo() {
		return proximo;
	}

	/**
	 * Define o próximo nó na lista encadeada.
	 * @param proximo O novo próximo nó na lista encadeada.
	 */
	public void setProximo(NodoListaEncadeada<T> proximo) {
		this.proximo = proximo;
	}
	
	/**
	 * Verifica se a chave armazenada neste nó é nula.
	 * @return {@code true} se a chave for nula, {@code false} caso contrário.
	 */
	public boolean isNull() {
		return (chave == null ? true:false);
	}

	/**
	 * Compara este nó com outro objeto para verificar igualdade.
	 * Dois nós são considerados iguais se forem da mesma classe e suas chaves forem iguais.
	 * A referência ao próximo nó não é considerada na comparação de igualdade.
	 * @param obj O objeto a ser comparado com este nó.
	 * @return {@code true} se os nós forem iguais, {@code false} caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;

		NodoListaEncadeada<?> outro = (NodoListaEncadeada<?>) obj;

		// Comparar as chaves.
		if (chave != null ? !chave.equals(outro.chave) : outro.chave != null) return false;
		
		return true; 
	}

	/**
	 * Retorna um código hash para este nó, baseado na chave armazenada.
	 * Se a chave for nula, retorna 0.
	 * @return O código hash da chave, ou 0 se a chave for nula.
	 */
	@Override
	public int hashCode() {
		return chave != null ? chave.hashCode() : 0;
	}

	/**
	 * Retorna a representação em String deste nó, que é a representação em String da sua chave.
	 * Se a chave for nula, este método pode retornar null ou uma string indicativa, dependendo do comportamento de toString() da chave.
     * A implementação atual retorna {@code null} se a chave for nula (via this.isNull()).
	 * @return A representação em String da chave, ou {@code null} se a chave for nula.
	 */
	@Override
	public String toString() {
		if (!this.isNull())
			return this.chave.toString();
		return null;
	}
	
	

}
