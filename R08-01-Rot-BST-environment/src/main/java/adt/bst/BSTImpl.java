package adt.bst;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(getRoot());
	}

	private int height(BSTNode<T> node) {
		int result = -1;

		if(!node.isEmpty()) {
			result = 1 + Math.max(height((BSTNode<T>) node.getLeft()),height((BSTNode<T>)node.getRight()));
		}
		return result;
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> result = null;
		BSTNode<T> aux = this.root;

		while(!aux.isEmpty()) {
			if(aux.getData().equals(element)) result = aux;
			if(element.compareTo(aux.getData()) < 0) aux = (BSTNode<T>) aux.getLeft();
			if(element.compareTo(aux.getData()) > 0) aux = (BSTNode<T>) aux.getRight();
		}

		return result;
	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			this.root = createNode(element);
		} else {

			BSTNode<T> aux = getRoot();

			while(aux != null) {
				if(element.compareTo(aux.getData()) < 0) {
					if(aux.getLeft().isEmpty()) {
						BSTNode<T> newNode = createNode(element);
						aux.setLeft(newNode);
						newNode.setParent(aux);
						return;
					}
					aux = (BSTNode<T>) aux.getLeft();
				} else {
					if(aux.getRight().isEmpty()) {
						BSTNode<T> newNode = createNode(element);
						aux.setRight(newNode);
						newNode.setParent(aux);
						return;
					}
					aux = (BSTNode<T>) aux.getRight();

				}
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;
		if(!isEmpty()) {
			BSTNode<T> aux = this.root;
			while(!aux.getRight().isEmpty()) {
				aux = (BSTNode<T>) aux.getRight();
			}
		}

		return result;

	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;

		if(!isEmpty()) {
			result = minimum(this.getRoot());
		}
		return result;
	}


	public BSTNode<T> minimum(BSTNode<T> node) {
		if(node.getLeft().isEmpty()) {
			return node;
		} else {
			return minimum((BSTNode<T>) node.getLeft());
		}
	}
 

	@Override
	public BSTNode<T> sucessor(T element) {		
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		T[] array = (T[]) new Comparable[size()];
		int count = 0;
		BSTNode<T> node = getRoot();
		return preOrder(array, node, count);
	}

	private T[] preOrder(T[] array, BSTNode<T> node, int count) {
		if(!isEmpty()) {
			array[count] = node.getData();
			count++;
			preOrder(array, (BSTNode<T>) node.getLeft(), count);
			preOrder(array, (BSTNode<T>) node.getRight(), count);
		}
		return array;
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

	private BSTNode<T> createNode(T element) {
		BSTNode<T> node = (BSTNode<T>) new BSTNode.Builder<T>()
			.data(element)
			.left(null)
			.right(null)
			.parent(null)
			.build();

		return node;
	}

}
