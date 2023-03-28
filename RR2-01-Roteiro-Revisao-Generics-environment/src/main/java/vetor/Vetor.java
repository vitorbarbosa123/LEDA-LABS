package vetor;

import java.util.Comparator;

/**
 * Implementação de um vetor de objetos simples para exercitar os conceitos de
 * Generics.
 * 
 * @author Adalberto
 *
 */
public class Vetor {

	// O array interno onde os objetos manipulados são guardados
	private Object[] arrayInterno;

	// O tamanho que o array interno terá
	private int tamanho;

	// Indice que guarda a proxima posição vazia do array interno
	private int indice;

	// O Comparators a serem utilizados
	private Comparator comparadorMaximo;
	private Comparator comparadorMinimo;

	public Vetor(int tamanho) {
		super();
		this.tamanho = tamanho;
		this.indice = -1;
	}

	public void setComparadorMaximo(Comparator comparadorMaximo) {
		this.comparadorMaximo = comparadorMaximo;
	}

	public void setComparadorMinimo(Comparator comparadorMinimo) {
		this.comparadorMinimo = comparadorMinimo;
	}

	// Insere um objeto no vetor
	public void inserir(Object o) {
		if(!isCheio()) {
			if(this.arrayInterno[0] == null) {
				this.arrayInterno[0] = o;
			}
			for(int i = 0; i <= this.arrayInterno.length; i++) {
				if(this.arrayInterno[i] == null) {
					this.arrayInterno[i] = o;
					indice++;
				}
			}
		}
		throw new Error("Array cheio");
	}

	// Remove um objeto do vetor
	public Object remover(Object o) {
		if(!isVazio()) {
			Object vetor = null;
	
			for(int i = 0; i <= this.arrayInterno.length; i++) {
				if(this.arrayInterno[i] != null) {
					if(this.arrayInterno[i] == o) {
						vetor = this.arrayInterno[i];
						this.arrayInterno[i] = null;
					}
				} else {
					throw new Error("Item não existe");
				}
			}
			return vetor;
		}
		throw new Error("Array vazio");

	}

	// Procura um elemento no vetor
	public Object procurar(Object o) {
		Object object = null;
		int i = 0;

		while(i <= this.arrayInterno.length) {
			if(this.arrayInterno[i] == o) {
				object = o;
				break;
			}
		}
		return object;
	}

	// Diz se o vetor está vazio
	public boolean isVazio() {
		return this.arrayInterno.length == 0;
	}

	// Diz se o vetor está cheio
	public boolean isCheio() {
		return this.arrayInterno.length == indice;
	}

}
