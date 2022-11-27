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
		T value = ((DoubleLinkedListImpl<T>) this.top).getHead().getData();

		this.top.removeFirst();
		this.size--;


		return value;
	}

	@Override
	public T top() {
		return ((DoubleLinkedListImpl<T>)this.top).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		if(this.top.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(this.top.size() == size) {
			return true;
		}
		return false;
	}

}
