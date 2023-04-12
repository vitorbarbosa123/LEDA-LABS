package sorting.variationsOfSelectionsort;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		
		int menor = 0;
		System.out.println(Arrays.toString(array));


		for(int i = leftIndex; i < rightIndex; i++) {
			menor = i;
			for(int j = i + 1; j <= rightIndex; j++) {
				if(array[j].compareTo(array[menor]) < 0) {
					Util.swap(array, j, menor);
				}
			}
			leftIndex++;
			sort(array, leftIndex, rightIndex);
		}

		System.out.println(Arrays.toString(array));

	}

}
