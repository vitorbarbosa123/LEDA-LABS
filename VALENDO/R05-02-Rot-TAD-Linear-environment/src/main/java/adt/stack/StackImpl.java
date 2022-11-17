package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	/*
	 * visualizar ultimo elemento da pilha, mas não remove
	 */
	@Override
	public T top() {

		return this.array[top];
	}
	/*
	 * verifica se a lista e
	 */
	@Override
	public boolean isEmpty() {
		if(this.top == -1) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		if(this.array.length -1 == this.top) {
			return true;
		}
		
		return false;
	}

	/*
	Inserir valor
	*/
	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()) {
			throw new StackOverflowException();
		}
		this.top++;
		this.array[top] = element;
	}

	/*
	 * remover valor
	 */
	@Override
	public T pop() throws StackUnderflowException {
		
		if(isEmpty()) {
			throw new StackUnderflowException();
		}
		return this.array[top--];
	}

}
