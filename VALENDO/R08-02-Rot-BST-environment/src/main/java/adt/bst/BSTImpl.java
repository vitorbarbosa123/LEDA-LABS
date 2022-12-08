package adt.bst;

import java.util.ArrayList;

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
		return this.height(this.root);
	}

	private int height(BSTNode<T> node) {
		if(node.isEmpty()) {
			return -1;
		} else {
			return 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
		}
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(this.root, element);
	}

	private BSTNode<T> search(BSTNode node, T element) {
		if(node.isEmpty()) return null;

		if(element.compareTo((T) node.getData()) == 0) return node;
		if(element.compareTo((T) node.getData()) > 0) return search((BSTNode) node.getLeft(), element);
		else return search((BSTNode) node.getRight(), element);
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
		if(isEmpty()) return null;
		return maximum(this.root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {

		while(node.getRight().getData() != null) {
			node = (BSTNode<T>) node.getRight();
		}
		return node;
	}
	
	@Override
	public BSTNode<T> minimum() {
		if(isEmpty()) return null;
		return minimum(this.root);
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		if(node.getLeft().getData() == null) return node;
		else return minimum((BSTNode<T>) node.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);

		if(node.getData() == null) return null;

		if(node.getRight().getData() != null) {
			return minimum((BSTNode<T>) node.getRight());
		} else {
			BSTNode<T> aux = (BSTNode) node.getParent();

			while(aux != null && aux.getData().compareTo(node.getData()) < 0) {
				aux = (BSTNode) aux.getParent();
			}
			return aux;
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);

		if(node.getData() == null) return null;

		if(node.getLeft().getData() != null) {
			return maximum((BSTNode<T>) node.getLeft());
		} else {
			BSTNode<T> aux = (BSTNode<T>) node.getParent();

			while(aux.getData() != null && aux.getData().compareTo(node.getData()) > 0) {
				aux = (BSTNode<T>) aux.getParent();
			}
			return aux;

		}
	}

	@Override
	public void remove(T element) {
		BSTNode node = search(element);

		if(!isEmpty()) {
			if(node.getData() == getRoot().getData()) {
				this.root = null;
			}
		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> arr = new ArrayList<T>();
		preOrder(arr, root);
		T[] aux = (T[]) arr.toArray(new Comparable[arr.size()]);

		return aux;
	}

	private void preOrder(ArrayList<T> arr, BSTNode<T> node) {
		if(!node.isEmpty()) {
			arr.add(node.getData());
			preOrder(arr, (BSTNode<T>) node.getLeft());
			preOrder(arr, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> arr = new ArrayList<T>();
		order(arr, root);
		T[] aux = (T[]) arr.toArray(new Comparable[arr.size()]);

		return aux;
	}

	private void order(ArrayList<T> arr, BSTNode<T> node) {
		if(!node.isEmpty()) {
			order(arr, (BSTNode<T>) node.getLeft());
			arr.add(node.getData());
			order(arr, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> arr = new ArrayList<T>();
		postOrder(arr, root);
		T[] aux = (T[]) arr.toArray(new Comparable[arr.size()]);

		return aux;
	}

	private void postOrder(ArrayList<T> arr, BSTNode<T> node) {
		if(!node.isEmpty()) {
			postOrder(arr, (BSTNode<T>) node.getLeft());
			postOrder(arr, (BSTNode<T>) node.getRight());
			arr.add(node.getData());
		}
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
