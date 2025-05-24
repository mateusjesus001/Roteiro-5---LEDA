package tad.fila;

/**
 * Objetivo da Classe: Sinalizar uma tentativa de adicionar um elemento a uma fila que atingiu sua capacidade máxima.
 * Esta exceção checada é lançada pela operação de enfileirar quando a fila está cheia.
 */
public class FilaCheiaException extends Exception {
	
	private static final long serialVersionUID = 2205604804082710180L;

	/**
	 * Construtor padrão. Inicializa a exceção com a mensagem "fila cheia".
	 */
	public FilaCheiaException() {
		super("fila cheia");
	}

}
