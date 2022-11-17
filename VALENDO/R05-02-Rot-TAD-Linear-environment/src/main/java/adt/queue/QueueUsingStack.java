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
		if(isFull()) {
			throw new QueueOverflowException();
		} try {
			this.stack1.push(element);

		} catch (StackOverflowException e ) {
			e.printStackTrace();
		}
		
	}	
	
	@Override
	public T dequeue() throws QueueUnderflowException {
		if(this.isEmpty()) {
			throw new QueueUnderflowException();
		}

		try {
			while(!this.stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		} catch (StackOverflowException | StackUnderflowException err) {
			err.printStackTrace();
		}

		T value = null;

		try {
			value = this.stack2.pop();
		} catch (StackUnderflowException e ) {
			e.printStackTrace();
		}

		try {
			while(!this.stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
		} catch (StackOverflowException | StackUnderflowException err) {
			err.printStackTrace();
		}

		return value;
	}

	@Override
	public T head() {

		try {
			while(!this.stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		} catch (StackOverflowException | StackUnderflowException err) {
			err.printStackTrace();
		}
		T value = this.stack2.top();

		try {
			while(!this.stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
		} catch (StackOverflowException | StackUnderflowException err) {
			err.printStackTrace();
		}

		return value;
	}

	@Override
	public boolean isEmpty() {
		if(this.stack1.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(this.stack1.isFull()) {
			return true;
		}
		return false;
	}

}
