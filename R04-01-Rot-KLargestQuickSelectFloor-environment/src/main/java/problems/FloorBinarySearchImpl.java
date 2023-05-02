package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		
		Integer result = null;

		int leftIndex = 0;
		int rightIndex = array.length - 1;

		sort(array, leftIndex, rightIndex);
		result = binarySearch(array, x, leftIndex, rightIndex);

		if(result != -1) {
			result = array[result];
		}
		
		return result;
	}

	private void medianOfThree(Integer[] array, int leftIndex, int rightIndex) {

		int middle = (leftIndex + rightIndex) / 2;

		if(array[rightIndex].compareTo(array[leftIndex]) < 0) {
			Util.swap(array, rightIndex, leftIndex);
		}

		if(array[middle].compareTo(array[leftIndex]) < 0) {
			Util.swap(array, middle, leftIndex);
		}

		if(array[rightIndex].compareTo(array[middle]) < 0) {
			Util.swap(array, rightIndex, middle);
		}

		Util.swap(array, leftIndex, middle);
	}

	private int partition (Integer[] array, int leftIndex, int rightIndex) {

		this.medianOfThree(array, leftIndex, rightIndex);

		Integer pivot = array[leftIndex];
		int i = leftIndex;

		for(int j = leftIndex + 1; j <= rightIndex; j++) {
			if(array[j].compareTo(pivot) <= 0) {
				Util.swap(array, j, i);
				i++;
			}
		}
		Util.swap(array, leftIndex, i);

		return i;
	}

	private void sort(Integer[] array, int leftIndex, int rightIndex) {

		if(leftIndex < rightIndex) {
			int pivot = partition(array, leftIndex, rightIndex);

			sort(array, leftIndex, pivot - 1);
			sort(array, pivot + 1, rightIndex);
		}
	}	

	private int binarySearch(Integer[] array, int k, int leftIndex, int rightIndex) {

		int result = -1;

		if(leftIndex <= rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;

			if(array[middle] == k) {
				return middle;
			} else if (array[middle] < k) {
				result = binarySearch(array, k, middle + 1, rightIndex);

				if(result == -1) {
					result = middle;
				}

			} else {
				result = binarySearch(array, k, leftIndex, middle - 1);
			}
		}

		return result;
	}

}
