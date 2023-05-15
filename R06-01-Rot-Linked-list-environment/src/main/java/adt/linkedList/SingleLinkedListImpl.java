package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return getHead().isNIL();
	}

	@Override
	public int size() {
		int count = 0;
		SingleLinkedListNode<T> aux = getHead();

		while(!aux.isNIL()) {
			count++;
			aux = aux.getNext();
		}
		return count;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux =  getHead();

		while(!aux.isNIL() && !aux.getData().equals(element)) {
			aux = aux.getNext();
		}
		return aux.getData();
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> aux =  getHead();

		if(isEmpty()) {
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, null);
			newHead.setNext(getHead());
			setHead(newHead);
		} else {
			while(!aux.getNext().isNIL()) {
				aux = aux.getNext();
			}
			aux.setNext(new SingleLinkedListNode<T>(element, null));
			aux.getNext().setNext(new SingleLinkedListNode<T>());
		}

	}

	@Override
	public void remove(T element) {
		if(this.head.getData().equals(element)) {
			setHead(head.getNext());
		} else {
			SingleLinkedListNode<T> aux = getHead();
			while(!aux.isNIL() && !aux.getData().equals(element)) {
				aux = aux.getNext();
			}
			if(!aux.isNIL()) {
				aux.setData(aux.getNext().getData());
				aux.setNext(aux.getNext().getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		int i = 0; 		
		SingleLinkedListNode<T> aux = getHead();
		T[] array = (T[]) new Comparable[size()];

		while(!aux.isNIL()) {
			array[i] = aux.getData();
			i++;
			aux = aux.getNext();
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
