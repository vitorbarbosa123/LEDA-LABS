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
			try {
				stack1.push(element);
			} catch (StackOverflowException e) {
				e.printStackTrace();
			}
		} else {
			throw new QueueOverflowException();
		}
 	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T result = null;
		if(!isEmpty()) {
			try {
				stack1ToStack2();
				result = stack2.pop();
				stack2ToStack1();
			} catch (StackOverflowException e) {
				e.printStackTrace();
			} catch (StackUnderflowException e) {
				e.printStackTrace();
			}
		} else {
			throw new QueueUnderflowException();
		}

		return result;
	}

	@Override
	public T head() {
		T head = null;
		if(!stack1.isEmpty()) {
			try {
				stack1ToStack2();
				head = stack2.top();
				stack2ToStack1();
			} catch (StackOverflowException e) {
				e.printStackTrace();
			} catch (StackUnderflowException e) {
				e.printStackTrace();
			}
		}
	
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
			try {
				T elem = stack1.pop();
				stack2.push(elem);
			} catch (StackOverflowException e) {
				e.printStackTrace();
			} catch (StackUnderflowException e) {
				e.printStackTrace();
			}
		} 
	}

	private void stack2ToStack1() throws StackOverflowException, StackUnderflowException {
		while(!stack2.isEmpty()) {
			try {
				T elem = stack2.pop();
				stack1.push(elem);
			} catch (StackOverflowException e) {
				e.printStackTrace();
			} catch (StackUnderflowException e) {
				e.printStackTrace();
			}
		}
	}

}
