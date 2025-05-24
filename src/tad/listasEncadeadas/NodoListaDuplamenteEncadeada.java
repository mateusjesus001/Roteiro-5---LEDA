package tad.listasEncadeadas;

import java.util.Objects;

/**
 * Objetivo da Classe: Representar um nó individual em uma lista duplamente encadeada.
 * Estende {@link NodoListaEncadeada} adicionando uma referência para o nó anterior na lista.
 * @param <T> O tipo do dado armazenado no nó, deve implementar {@link Comparable}.
 */
public class NodoListaDuplamenteEncadeada<T extends Comparable<T>> extends NodoListaEncadeada<T>{
    private NodoListaDuplamenteEncadeada<T> anterior;

    /**
     * Construtor que inicializa o nó com uma chave específica.
     * O próximo nó (herdado) e o nó anterior são inicializados como nulos.
     * @param chave O valor a ser armazenado neste nó.
     */
    public NodoListaDuplamenteEncadeada(T chave) {
        super(chave); // Inicializa 'chave' e 'proximo' (para null) na superclasse
        this.anterior = null;
    }

    /**
     * Construtor para criar um nó com chave nula, frequentemente usado para nós sentinela.
     * O próximo nó (herdado) e o nó anterior são inicializados como nulos.
     */
    public NodoListaDuplamenteEncadeada() {
        super(null); 
        this.anterior = null;
    }

    // Getters e Setters para 'anterior' (auto-explicativos, não documentados individualmente)
    public NodoListaDuplamenteEncadeada<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaDuplamenteEncadeada<T> anterior) {
        this.anterior = anterior;
    }

    /**
     * Compara este nó com outro objeto para verificar igualdade.
     * Dois nós duplamente encadeados são considerados iguais se forem da mesma classe e suas chaves forem iguais.
     * As referências aos nós vizinhos (próximo e anterior) não são consideradas na comparação de igualdade.
     * @param o O objeto a ser comparado com este nó.
     * @return {@code true} se os nós forem iguais, {@code false} caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        

        NodoListaDuplamenteEncadeada<?> that = (NodoListaDuplamenteEncadeada<?>) o;

        return Objects.equals(getChave(), that.getChave());
    }

    /**
     * Retorna um código hash para este nó, baseado na chave armazenada.
     * Utiliza {@link Objects#hash(Object...)} para calcular o hash da chave.
     * @return O código hash da chave.
     */
    @Override
    public int hashCode() {

        return Objects.hash(getChave());
    }

    /**
     * Retorna a representação em String deste nó duplamente encadeado.
     * Inclui o nome da classe, o identity hash code do objeto e a representação em String da chave.
     * @return A representação em String do nó.
     */
    @Override
    public String toString() {

        return getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(this)) + "[" + getChave() + "]";
    }
}