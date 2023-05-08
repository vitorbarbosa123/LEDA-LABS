package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		return array[top];                                                   
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		return this.top == array.length - 1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!isFull()) {
			top++;
			array[top] = element;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		T item = null;
		if(!isEmpty()) {
			item = this.top();
			array[top] = array[top+1];
			top--;
		}

		return item;
		
	}

}
