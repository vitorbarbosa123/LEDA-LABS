package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()) {
			throw new QueueOverflowException();
		}
		this.list.insertFirst(element);
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) {
			throw new QueueUnderflowException();
		}
		T item = ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
		this.list.removeFirst();
		this.size--;
		return item;

	}

	@Override
	public T head() {
		T item = null;

		if(isEmpty()) {
			item = ((DoubleLinkedListImpl<T>)this.list).getHead().getData();
		}

		return item;
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;
		if(this.list.size() == 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isFull() {
		boolean result = false;
		if(this.list.size() == size) {
			result = true;
		}
		return result;
	}

}
