package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguintes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		int max = 0;
		int min = 0;

		int[] sorted = new int[array.length];

		// 0º Passo: define o tamanho do array auxiliar com base
		// no maior valor presente
		for (int l = leftIndex; l <= rightIndex; l++) {
			if (array[l] > max) {
				max = array[l];
			} else if (array[l] < min) {
				min = array[l];
			}
		}
		max += 1;

		if (min < 0) {
			min = Math.abs(min);
		} else {
			min = -min;
		}

		int[] aux = new int[max += min];

		// 1º Passo: contagem da frequência do array;
		for (int i = leftIndex; i <= rightIndex; i++) {
			aux[array[i] + min] += 1;
		}
		aux[0] += leftIndex;

		// 2º Passo: acumulativa do array;
		for (int j = 1; j < aux.length; j++) {
			aux[j] = aux[j] + aux[j - 1];
		}

		// 3º Passo: repasse ordenado para novo array;
		for (int k = rightIndex; k >= leftIndex; k--) {
			sorted[aux[array[k] + min] - 1] = array[k];
			aux[array[k] + min] -= 1;
		}

		for (int z = leftIndex; z <= rightIndex; z++) {
			array[z] = sorted[z];
		}
	}

}
