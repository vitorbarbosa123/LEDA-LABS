package adt.bst;

import adt.bt.BTNode;

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
		if(node == null) {
			return -1;
		} else {
			return 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
		}
	}

	@Override
	public BSTNode<T> search(T element) {
		BSTNode<T> aux = getRoot();

		while(aux != null) {
			if(aux.getData() == element) {
				return aux;
			}
			if(element.compareTo(aux.getData()) < 0) {
				aux = (BSTNode<T>) aux.getLeft();
			}

			if(element.compareTo(aux.getData()) > 0) {
				aux = (BSTNode<T>) aux.getRight();
			}
		}

		return null;
	}

	@Override
	public void insert(T element) {
		if(isEmpty()) {
			BSTNode<T> newNode = new BSTNode<T>();
			newNode = getRoot();	
			newNode.setData(element);
		} else {

			BSTNode<T> aux = getRoot();

			while(aux != null) {
				if(element.compareTo(aux.getData()) < 0 ) {
					if(aux.getLeft().getData() == null) {
						BSTNode<T> newNode = new BSTNode<T>();
						aux.getLeft().setData((T)newNode);
						aux = (BSTNode<T>) newNode.getParent();
						return;
					} 
					aux = (BSTNode<T>) aux.getLeft();
				} else {
					if(aux.getRight().getData() == null) {
						BSTNode<T> newNode = new BSTNode<T>();
						aux.getRight().setData((T)newNode);
						aux = (BSTNode<T>) newNode.getParent();
						return;
					} 
					aux = (BSTNode<T>) aux.getRight();
				}
			}

		}
	}

	@Override
	public BSTNode<T> maximum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public BSTNode<T> minimum() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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
		BSTNode node = search(element);

		if(!isEmpty()) {
			if(node.getData() == getRoot().getData()) {
				this.root = null;
			} else {
				if()

			}

		}
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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

}
