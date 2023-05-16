package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>(element, null, null);
		node.setNext(getHead());
		node.setPrevious(new DoubleLinkedListNode<T>());
		// head.previous = node
		if(getHead().isNIL()) {
			setLast(node);
		}
		setHead(node);
	}	

	@Override
	public void removeFirst() {
		if(!getHead().isNIL()) {
			setHead(getHead().getNext());

			if(getHead().isNIL()) {
				setLast((DoubleLinkedListNode<T>) getHead());
			} else {
				// head.previous = NIL
			}
		}
	}

	@Override
	public void removeLast() {
		if(getLast() != null) {
			setLast(getLast().getPrevious());

			if(getLast().isNIL()) {
				setHead(getLast());
			} else {
				getLast().setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
