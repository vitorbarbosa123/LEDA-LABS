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
		if (isFull()) {
			throw new QueueOverflowException();
		}
		this.list.insertFirst(element);

	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}
		T value = ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
		this.list.removeFirst();
		this.size--;

		return value;
	}

	@Override
	public T head() {
		if(isEmpty()) {
			return null;
		}
		return ((DoubleLinkedListImpl<T>) this.list).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		if(this.list.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(this.list.size() == size) {
			return true;
		}
		return false;
	}

}
