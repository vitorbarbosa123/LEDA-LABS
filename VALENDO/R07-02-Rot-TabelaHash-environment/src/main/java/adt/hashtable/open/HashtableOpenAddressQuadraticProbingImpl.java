package adt.hashtable.open;

import adt.hashtable.hashfunction.HashFunctionClosedAddressMethod;
import adt.hashtable.hashfunction.HashFunctionOpenAddress;
import adt.hashtable.hashfunction.HashFunctionQuadraticProbing;

public class HashtableOpenAddressQuadraticProbingImpl<T extends Storable>
		extends AbstractHashtableOpenAddress<T> {

	public HashtableOpenAddressQuadraticProbingImpl(int size,
			HashFunctionClosedAddressMethod method, int c1, int c2) {
		super(size);
		hashFunction = new HashFunctionQuadraticProbing<T>(size, method, c1, c2);
		this.initiateInternalTable(size);
	}

	private int getIndex(T element, int probe) {
		return ((HashFunctionOpenAddress) this.hashFunction).hash(element, probe);
	}

	@Override
	public void insert(T element) {
		if(isFull()) {
			throw new HashtableOverflowException();
		}
		else {
			int probe = 0;
			int index = getIndex(element, probe);
			if(element != null) {
				while( this.table[index] != null && 
				       this.table[index] != this.deletedElement && 
					   probe < this.table.length) {
							probe++;
							index = getIndex(element, probe);
							this.COLLISIONS++;
					   }
				this.table[index] = element;
				this.elements++;
			}
		}
		
	}

	@Override
	public void remove(T element) {
		if(!isEmpty()) {
			int probe = 0;
			int index = getIndex(element, probe);
			if(element != null) {
				while(this.table[index] != null &&
					  this.table[index] != this.deletedElement &&
					  !this.table[index].equals(element) &&
					  probe < this.table.length	) {
						probe++;
						index = getIndex(element, probe);
					  }
				if(this.table[index] != null && 
				   this.table[index].equals(element)) {
					this.table[index] = this.deletedElement;
					this.elements--;
				   }
			}
		}
	}

	@Override
	public T search(T element) {
		T isElementInTable = null;
		int isElementOut = indexOf(element);

		if(!isEmpty()) {
			if(element != null && isElementOut > 0) {
				if(this.table[isElementOut] instanceof DELETED) {
					isElementInTable = null;
				} else {
					isElementInTable = (T) this.table[isElementOut];
				}

			   }
		}
		return isElementInTable;
	}

	@Override
	public int indexOf(T element) {
		int isElementInTable = -1;
		if(!isEmpty()) {
			int probe = 0;
			int index = getIndex(element, probe);
			if(element != null) {
				while(this.table[index] != null && 
				      this.table[index] != this.deletedElement &&
					  !this.table[index].equals(element) && probe < this.table.length) {
						probe++;
						index = getIndex(element, probe);
				}
				if(probe < this.table.length) {
					isElementInTable = index;
				}
			}
		}
		return isElementInTable;
	}
}
