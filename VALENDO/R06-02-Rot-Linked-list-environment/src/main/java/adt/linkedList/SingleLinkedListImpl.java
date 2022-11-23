package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

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
		SingleLinkedListNode<T> auxHead = getHead();
		if(auxHead.isNIL()) {
			return count;
		} 
		while(!auxHead.isNIL()) {
			count += 1;
			auxHead = auxHead.getNext();
		}

		return count;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> auxHead = getHead();
		T result = null;
		boolean found = false;
		while(!auxHead.isNIL() && !found) {
			if(auxHead.getData().equals(element)) {
				result = auxHead.getData();
				found = true;
			}
			auxHead = auxHead.getNext();
		}
		return result;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = getHead();
		
		while(!auxHead.isNIL()) {
			auxHead = auxHead.getNext();
		}
		auxHead.setData(element);
		auxHead.setNext(new SingleLinkedListNode<T>());
		
	}

	@Override
	public void remove(T element) {
		if(head.getData().equals(element)) {
			head = head.getNext();
		} else {
			// Todo: criar 2 nós: 1 pegar do atual do head e o outro do antes-head
			SingleLinkedListNode<T> auxHead = getHead().getNext();
			SingleLinkedListNode<T> prev = getHead();
			while(!auxHead.isNIL() && !auxHead.getData().equals(element)) {
				prev = auxHead;
				auxHead = auxHead.getNext();
			}
			if(!auxHead.isNIL()) {
				prev.setNext(auxHead.getNext());
			}
			
		}
	}

	@Override
	public T[] toArray() {
		List<T> elem = new ArrayList<T>();
		SingleLinkedListNode<T> auxHead = this.head;
		while(!auxHead.isNIL()) {
			elem.add(auxHead.getData());
			auxHead = auxHead.getNext();
		}
		return (T[])elem.toArray(new Object[elem.size()]);
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
