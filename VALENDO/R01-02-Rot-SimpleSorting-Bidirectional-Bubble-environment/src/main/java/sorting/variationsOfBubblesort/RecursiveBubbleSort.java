package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
				
		if(rightIndex > array.length - 1 || leftIndex < 0 || leftIndex >= rightIndex) return;
		for(int i = 0; i < array.length; i++) {
			boolean swapped = false;
			for(int j = leftIndex; j < rightIndex; j++){
				if(array[j].compareTo(array[j+1]) > 0 ) {
					Util.swap(array,j,j+1);
					swapped = true;
				}
			}
			if(!swapped) return;
		}

		sort(array, leftIndex, rightIndex-1);
	}

}
