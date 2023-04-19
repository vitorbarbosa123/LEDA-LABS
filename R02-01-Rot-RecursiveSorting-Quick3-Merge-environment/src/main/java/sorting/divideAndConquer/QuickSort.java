package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if(leftIndex < rightIndex) {
			int pivot = quick(array, leftIndex, rightIndex);

			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}	

	private int quick(T[] array, int leftIndex, int rightIndex) {

		int i = leftIndex;
		int pivot = leftIndex;

		for(int j = i + 1; j <= rightIndex; j++) {
			if(array[j].compareTo(array[pivot]) < 0) {
				i++;
				Util.swap(array, j, i);
			}
		}
		Util.swap(array, pivot, i);

		return i;
	}
}
