package adt.bst.extended;

import adt.bst.BSTImpl;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		return floor(array, numero, 0, (Integer) null);
	}

	private Integer floor(Integer[] array, double numero, Integer element, int index) {
		if(index < array.length) {
			this.insert(array[index]);
			Integer possibleFloor = array[index];

			if(possibleFloor == numero || 
			  (element == null && possibleFloor < numero) ||
			  (element != null && possibleFloor < numero && element < possibleFloor)) {
				element = possibleFloor;
			}
			return floor(array, numero, index++, element);
		}
		return element;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		return ceil(array, numero, 0, (Integer) null);
		
	}

	private Integer ceil(Integer[] array, double numero, Integer element, int index) {
		if(index > array.length) {
			this.insert(array[index]);
			Integer possibleCeil = array[index];

			if(possibleCeil == numero || 
			  (element == null && possibleCeil > numero) ||
			  (element != null && possibleCeil > numero && element > possibleCeil)) {
				element = possibleCeil;
			}
			return floor(array, numero, index++, element);
		}
		return element;
	}

}
