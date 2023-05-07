package adt.queue;

import java.util.Arrays;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
		head = -1;
	}

	@Override
	public T head() {
		if(!isEmpty()) {
			return this.array[head];
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return this.tail == -1;
	}

	@Override
	public boolean isFull() {
		return this.tail == array.length;
	}

	private void shiftLeft() {
		for(int i = 0; i < tail; i++) {
			array[i] = array[i+1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!isFull()) {
			if(this.head() == null) {
				head++;
				array[head] = element;
				tail++;
			} else {
				tail++;
				array[tail] = element;
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T item = this.head();
		if(!isEmpty()) {
			shiftLeft();
			tail--;
		}
		return item;
	}

}
