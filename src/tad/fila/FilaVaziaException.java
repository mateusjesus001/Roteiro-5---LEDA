package tad.fila;

/**
 * Objetivo da Classe: Sinalizar uma tentativa de operação ilegal em uma fila que está vazia.
 * Esta exceção checada é lançada quando um método que requer elementos na fila (como desenfileirar)
 * é invocado em uma instância de fila que não contém elementos.
 */
public class FilaVaziaException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2035554480259121771L;

	/**
	 * Construtor padrão. Inicializa a exceção com a mensagem "fila vazia!".
	 */
	public FilaVaziaException() {
		super("fila vazia!");
	}
	
	/**
	 * Construtor que permite especificar uma mensagem customizada para a exceção.
	 * @param message A mensagem detalhando a causa da exceção.
	 */
	public FilaVaziaException(String message) {
		super(message);
	}

}
