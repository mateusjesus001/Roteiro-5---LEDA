package tad.pilha;

/**
 * Objetivo da Classe: Sinalizar uma tentativa de adicionar um elemento a uma pilha que já atingiu sua capacidade máxima.
 * Esta exceção é lançada pela operação de empilhar quando a pilha está cheia.
 */
public class PilhaCheiaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PilhaCheiaException() {
		super("pilha cheia!");
	}
	
}
