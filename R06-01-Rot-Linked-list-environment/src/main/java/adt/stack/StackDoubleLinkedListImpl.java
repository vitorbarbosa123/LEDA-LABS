package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		this.top.insertFirst(element);
		this.size++;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		T item = ((DoubleLinkedListImpl<T>) this.top).getHead().getData();
		this.top.removeFirst();
		this.size--;
		return item;
	}

	@Override
	public T top() {
		return ((DoubleLinkedListImpl<T>) this.top).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		boolean result = false;
		if(this.top.size() == 0) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean isFull() {
		boolean result = false;
		if(this.top.size() == size) {
			result = true;
		}
		return result;
	}

}
