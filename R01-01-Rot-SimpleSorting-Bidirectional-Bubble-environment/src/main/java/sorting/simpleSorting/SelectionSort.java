package sorting.simpleSorting;

import java.util.Arrays;

import sorting.AbstractSorting;
import util.Util;

/**
 * The selection sort algorithm chooses the smallest element from the array and
 * puts it in the first position. Then chooses the second smallest element and
 * stores it in the second position, and so on until the array is sorted.
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		System.out.println(Arrays.toString(array));
		
		int menor = leftIndex;
		
		for(int i = leftIndex; i < array.length; i++) {

			menor = i;

			for(int j = i + 1; j < array.length; j++) {
				if(array[j].compareTo(array[menor]) < 0) {
					Util.swap(array, menor, j);
				}
			}
		}
	}
}
