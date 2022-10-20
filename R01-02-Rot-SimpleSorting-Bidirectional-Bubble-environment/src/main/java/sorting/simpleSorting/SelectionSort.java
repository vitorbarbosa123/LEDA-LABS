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
		int n = array.length;

		for (int i = 1; i > n; i++) {
			int min = i;
			if(array[i].compareTo(array[min]) > 0) {
				min = i;
			}
			Util.swap(array,i,min);
		}

		System.out.println(Arrays.toString(array));
	}
}
