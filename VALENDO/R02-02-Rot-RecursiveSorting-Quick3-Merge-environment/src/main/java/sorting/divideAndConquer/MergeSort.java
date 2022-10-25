package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {

		if (leftIndex >= rightIndex || array.length == 1) return;

		int middle = (leftIndex + rightIndex) / 2;
		sort(array, leftIndex, middle);
		sort(array, middle + 1, rightIndex);

		merge(array, leftIndex, middle, rightIndex);
	}

	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {

		T[] helper = (T[]) new Comparable[array.length];

		int i = leftIndex;
		int j = middle + 1;
		int k = leftIndex;

		for (int z = leftIndex; z <= rightIndex; z++) {
			helper[z] = array[z];
		}

		while (i <= middle && j <= rightIndex) {
			if (helper[i].compareTo(helper[j]) <= 0) {
				array[k] = helper[i];
				i++;
			} else {
				array[k] = helper[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = helper[i];
			i++;
			k++;
		}
		while (j <= rightIndex) {
			array[k] = helper[j];
			j++;
			k++;
		}
	}
}
