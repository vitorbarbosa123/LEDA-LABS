package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!isFull()) {
			int temp = (head + 1) % array.length;

			if(this.head() == null) {
				array[temp] = element;
				head = temp;
				tail = temp;
			} else {
				if(this.tail == array.length) {
					tail = 0;
					array[tail] = element;
					tail++;
				} else {
					tail++;
					array[tail] = element;
				}	
			}
			elements++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		T item = this.head();
		if(!isEmpty()) {
			if(this.head == array.length) {
				array[head] = array[0];
			} else {
				array[head] = array[head + 1];
			}
			tail--;
			elements--;
		}
		return item;
	}

	@Override
	public T head() {
		return head == -1 ? array[(head + 1) % array.length] : array[head];
	}

	@Override
	public boolean isEmpty() {
		return this.elements == 0;
	}

	@Override
	public boolean isFull() {
		return this.elements == array.length;
	}

}
