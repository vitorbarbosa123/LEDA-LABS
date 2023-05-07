package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!isFull()) {
			stack1.push(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T head() {
		T head = null;
	
		return head;
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}

	private void stack1ToStack2() throws StackOverflowException, StackUnderflowException {
		while(!stack1.isEmpty()) {
			T elem = stack1.pop();
			stack2.push(elem);
		}
	}

	private void stack2ToStack1() throws StackOverflowException, StackUnderflowException {
		while(!stack2.isEmpty()) {
			T elem = stack2.pop();
			stack1.push(elem);
		}
	}

}
