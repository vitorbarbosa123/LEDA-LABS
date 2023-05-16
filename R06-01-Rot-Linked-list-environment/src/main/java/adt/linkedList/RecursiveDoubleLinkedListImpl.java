package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if(isEmpty()) {
			setData(element);
			setNext(new RecursiveDoubleLinkedListImpl<T>());
			if(getPrevious() == null) {
				setPrevious(new RecursiveDoubleLinkedListImpl<T>());
			}
		} else {
			RecursiveDoubleLinkedListImpl<T> aux = (RecursiveDoubleLinkedListImpl<T>) getNext();
			insertFirst(element, aux);
		}
	}

	private void insertFirst(T element, RecursiveDoubleLinkedListImpl<T> node) {
		if(next.getData() == null) {
			next.setData(element);
			next.setNext(new RecursiveSingleLinkedListImpl<T>());
		} else {
			RecursiveDoubleLinkedListImpl<T> aux = (RecursiveDoubleLinkedListImpl) next.getNext();
			insertFirst(element, aux);
		}
	}

	@Override
	public void removeFirst() {
		
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
