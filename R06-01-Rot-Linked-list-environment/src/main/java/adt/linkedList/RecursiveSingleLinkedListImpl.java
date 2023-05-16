package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		boolean result = false;

		if(getData() == null) {
			result = true;
		} 
		return result;
	}

	@Override
	public int size() {
		int result = 0;
		if(!isEmpty()) {
			RecursiveSingleLinkedListImpl<T> next = getNext();
			result++;
			result = size(result, next);
		}

		return result;
	}

	private int size(int result, RecursiveSingleLinkedListImpl<T> next) {
		if(!(next.getData() == null)) {
			result++;
			RecursiveSingleLinkedListImpl<T> aux = next.getNext();
			result = size(result, aux);
		} 

		return result;
	}

	@Override
	public T search(T element) {
		T result = null;

		if(!isEmpty()) {
			if(getData().equals(element)) {
				result = getData();
			} else {
				RecursiveSingleLinkedListImpl<T> next = getNext();
				result = search(element, next);
			}
		}

		return result;
	}

	private T search(T element, RecursiveSingleLinkedListImpl<T> next) {
		T result = null;

		if(!(next.getData() == null)) {
			if(next.getData().equals(element)) {
				result = next.getData();
			} else {
				RecursiveSingleLinkedListImpl<T> aux = next.getNext();
				search(element, aux);
			}
		}

		return result;
	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			setData(element);
			setNext(new RecursiveSingleLinkedListImpl<T>());
		} else {
			RecursiveSingleLinkedListImpl<T> next = getNext();
			insert(element, next);
		}
	}

	private void insert(T element, RecursiveSingleLinkedListImpl<T> next) {
		if(next.getData() == null) {
			next.setData(element);
			next.setNext(new RecursiveSingleLinkedListImpl<T>());
		} else {
			RecursiveSingleLinkedListImpl<T> aux = next.getNext();
			insert(element, aux);
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()) {
			if(getData().equals(element)) {
				setData(getNext().getData());
				setNext(getNext().getNext());
			} else {
				RecursiveSingleLinkedListImpl<T> next = getNext();
				remove(element, next);
			}
		}
	}

	private void remove(T element, RecursiveSingleLinkedListImpl<T> next) {
		if(next.getData().equals(element)) {
			setData(next.getData());
			setNext(next.getNext());
		} else {
			RecursiveSingleLinkedListImpl<T> aux = next.getNext();
			remove(element, aux);
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[size()];

		if(!isEmpty()) {
			int i = 0;
			array = toArray(array, this, i);

		}
		return array;
	}

	private T[] toArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int i) {

			if(!(node.getNext() == null)) {
				array[i] = node.getData();
				i++;
				RecursiveSingleLinkedListImpl<T> aux = next.getNext();
				array = toArray(array, aux, i);
		}

		return array;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
