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
			aux.setData(aux.getNext().getData());
		}
		return count;

	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> aux = getHead();

		while(!(aux.isNIL() && aux.getData().equals(element))) {
			aux.setData(aux.getNext().getData());
		}

		return (T) aux;

	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			SingleLinkedListNode<T> node = new SingleLinkedListNode<T>();
			node.setNext(getHead());
			setHead(node);
		} else {
			SingleLinkedListNode<T> aux = new SingleLinkedListNode<T>();
			while(!aux.isNIL()) {
				aux.setData(aux.getNext().getData());
			}
			aux.setData(element);
			aux.setNext(new SingleLinkedListNode<T>());

		}
	}

	@Override
	public void remove(T element) {
		if(getHead().getData().equals(element)) {
			setHead(getHead().getNext());
		} else {
			SingleLinkedListNode<T> aux = new SingleLinkedListNode<T>();
			while(!(aux.isNIL() && aux.getData().equals(element))) {
				aux.setData(aux.getNext().getData());
			}
			if(!aux.isNIL()) {
				aux.setData(aux.getNext().getData());
				aux.setNext(aux.getNext().getNext());
			}
		}
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
