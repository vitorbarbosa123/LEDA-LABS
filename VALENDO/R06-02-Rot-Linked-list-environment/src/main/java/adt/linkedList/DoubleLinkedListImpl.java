package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<>();
		this.last = (DoubleLinkedListNode<T>) this.head;
	}

	@Override
	public void insert(T element) {
		if(element != null) {
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>();
			newLast.setData(element);
			newLast.setPrevious(this.getLast());
			newLast.setNext(new DoubleLinkedListNode<>());

			this.getLast().setNext(newLast);

			if(this.getLast().isNIL()) {
				this.setHead(newLast);
			}
			this.setLast(newLast);
		}
	}

	@Override
	public void insertFirst(T element) {
		if(element != null) {
			DoubleLinkedListNode newNode = new DoubleLinkedListNode<T>();
			newNode.setData(element);
			newNode.setNext(this.getHead());
			newNode.setPrevious(new DoubleLinkedListNode<>());
			((DoubleLinkedListNode<T>)this.getHead()).setPrevious(newNode);
			if(this.getLast().isNIL()) {
				this.setHead(newNode);
			}
			this.setHead(newNode);
		}	
	}

	@Override
	public void removeFirst() {
		if(!this.getHead().isNIL()) {
			this.setHead(this.getHead().getNext());
		} else if (this.getHead().isNIL()) {
			this.setLast((DoubleLinkedListNode<T>) this.getHead());
		}
		((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
	}

	@Override
	public void removeLast() {
		if(!this.getLast().isNIL()) {
			this.setLast(this.getLast().getPrevious());
		   if(this.getLast().isNIL()) {
			this.setHead(this.getLast());
		   } 
			this.getLast().setNext(new SingleLinkedListNode<>()); 
		}
	}

	@Override
	public void remove(T element) {
		if(element != null) {
			if(this.getHead().equals(element)) {
				this.removeFirst();
			}
			else {
				DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.getHead();
				
				while(!aux.isNIL() && !aux.getData().equals(element)) {
					aux = (DoubleLinkedListNode<T>) aux.next;
				}

				if(!aux.isNIL()) {
					aux.getPrevious().setNext(aux.getNext());
					((DoubleLinkedListNode) aux.getNext()).setPrevious(aux.getPrevious());
				}
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
