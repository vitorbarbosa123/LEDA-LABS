package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionLinearProbing;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;

public class HashtableOpenAddressLinearProbingImpl<T extends Storable> extends
		AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressLinearProbingImpl(int size,
			HashFunctionClosedAddressMethod method) {
		super(size);
		hashFunction = new HashFunctionLinearProbing<T>(size, method);
		this.initiateInternalTable(size);
	}

	@Override
	public void insert(T element) {
		
		if(isFull()) {
			throw new HashtableOverflowException();
		}

		if(element != null) {
			int count = 0;
			boolean aux = true;
			int index = -1;

			while(aux && count < this.capacity()) {
	
				index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, count++);
				
				if(this.table[index] == null || this.table[index].equals(new DELETED())) {
					this.table[index] = element;
					elements++;
					aux = false;
				} else {
					COLLISIONS++;
				}
			}
		}

	}

	@Override
	public void remove(T element) {
		
		if(element != null) {
			int count = 0;
			boolean aux = true;
			int index;

			while(aux && count < capacity()) {
	
				index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, count++);
				
				if(this.table[index] != null && this.table[index].equals(element)) {
					this.table[index] = new DELETED();
					elements--;
					aux = false;
				}
			}
		}
	}

	@Override
	public T search(T element) {
		T result = null;

		if(element != null) {
			int count = 0;
			boolean aux = true;
			int index = 0;

			while(aux && count < this.capacity()) {
	
				index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, count++);
				
				if(this.table[index] != null && this.table[index].equals(element)) {
					result = (T) this.table[index];
					aux = false;
				}
			}
		}

		return result;
	}

	@Override
	public int indexOf(T element) {
		int result = -1;
		int count = 0;
		boolean aux = true;
		int index = 0;

		while(aux && count < capacity()) {
			index = ((HashFunctionOpenAddress<T>) this.hashFunction).hash(element, count++);

			if(this.table[index] != null && this.table[index].equals(element)) {
				result = index;
				aux = false;
			}

		}
		return result;
		
	}

	
}
