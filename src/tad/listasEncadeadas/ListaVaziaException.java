package tad.listasEncadeadas;

/**
 * Objetivo da Classe: Sinalizar uma tentativa de operação ilegal em uma lista que está vazia.
 * Esta exceção é lançada quando um método que requer elementos na lista (como remover,
 * obter primeiro/último elemento) é invocado em uma instância de lista que não contém elementos.
 */
public class ListaVaziaException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2035554480259121771L;

	/**
	 * Construtor padrão. Inicializa a exceção com a mensagem "lista vazia!".
	 */
	public ListaVaziaException() {
		super("lista vazia!");
	}
	
	/**
	 * Construtor que permite especificar uma mensagem customizada para a exceção.
	 * @param message A mensagem detalhando a causa da exceção.
	 */
	public ListaVaziaException(String message) {
		super(message);
	}

}
