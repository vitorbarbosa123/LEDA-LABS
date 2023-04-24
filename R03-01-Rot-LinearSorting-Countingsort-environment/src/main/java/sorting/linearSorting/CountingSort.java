package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(array.length > 1) {
			couting(array, leftIndex, rightIndex);
		}
		
	}

	private Integer[] couting(Integer[] array, int leftIndex, int rightIndex) {
		
		// Descobrindo o maior e o menor valor do array
		int maior = array[rightIndex];
		int menor = array[leftIndex];

		for(int i = leftIndex; i < rightIndex - 1; i++) {
			if(maior < array[i]) {
				maior = array[i];
			}
			if(array[i] < menor) {
				menor = array[i];
			}
		}

		// Criando um array de frequencia com base no maior e menor valor
		Integer[] frequence = new Integer[maior - menor + 1];

		// Setando todos os valores do novo array para zero
		for(int j = 0; j < frequence.length; j++) {
			frequence[j] = 0;
		}

		// Calculo de frequencia
		for(int m = leftIndex; m <= rightIndex; m++) {
			frequence[array[m] - menor] += 1;
		}

		// Acumulativa em array de frequência
		for(int n = 1; n < frequence.length; n++) {
			frequence[n] += frequence[n - 1];
		}

		// Criando array do tamanho do array original
		Integer[] result = new Integer[array.length];
		 for(int p = rightIndex; p >= leftIndex; p--) {
			result[frequence[array[p] - menor] - 1] = array[p];
	
			frequence[array[p] - menor] -= 1;
		}

		return result;
 	}
}

