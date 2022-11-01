package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de
 * contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de
 * entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a
 * ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros
 * negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		int max = 0;

		int[] sorted = new int[array.length];

		// 0º Passo: define o tamanho do array auxiliar com base
		// no maior valor presente
		for (int l = leftIndex; l <= rightIndex; l++) {
			if (array[l] > max) {
				max = array[l];
			}
		}
		max += 1;

		int[] aux = new int[max];

		// 1º Passo: contagem da frequência do array;
		for (int i = leftIndex; i <= rightIndex; i++) {
			aux[array[i]] += 1;
		}
		aux[0] += leftIndex;

		// 2º Passo: acumulativa do array;
		for (int j = 1; j < aux.length; j++) {
			aux[j] = aux[j] + aux[j - 1];
		}

		// 3º Passo: repasse ordenado para novo array;
		for (int k = rightIndex; k >= leftIndex; k--) {
			sorted[aux[array[k]] - 1] = array[k];
			aux[array[k]] -= 1;
		}

		for (int z = leftIndex; z <= rightIndex; z++) {
			array[z] = sorted[z];
		}
	}
}
