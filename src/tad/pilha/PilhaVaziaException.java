package tad.pilha;

/**
 * Objetivo da Classe: Sinalizar uma tentativa de operação ilegal em uma pilha vazia.
 * Esta exceção é lançada quando um método que requer elementos na pilha (como desempilhar ou topo)
 * é invocado em uma instância de pilha que não contém elementos.
 */
public class PilhaVaziaException extends RuntimeException {
	
	private static final long serialVersionUID = -2959856106469842073L;

	public PilhaVaziaException() {
		super("pilha vazia!!");
	}
	
	public PilhaVaziaException(String message) {
		super(message);
	}

}
