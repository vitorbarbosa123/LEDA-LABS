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
		return search(element, this.root);
	}

	private BSTNode<T> search(T element, BSTNode<T> node)  {
		if(node.isEmpty()) return node;

		if(element.compareTo((T) node.getData()) < 0) return search(element, (BSTNode<T>) node.getLeft());
		if(element.compareTo((T) node.getData()) > 0) return search(element, (BSTNode<T>) node.getRight());
		else {
			return node;
		}
	}

	@Override
	public void insert(T element) {
		
		if(element != null) {
			insert(root, element);
		}
	}

	private void insert(BSTNode<T> node, T element) {

		if(node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
			node.getLeft().setParent(node);
		} else {
			if(node.getData().compareTo(element) > 0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else {
				insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		if(isEmpty()) return null;
		return maximum(root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {

		while(node.getRight().getData() != null) {
			node = (BSTNode<T>) node.getRight();
		}
		return node;
	}
	
	@Override
	public BSTNode<T> minimum() {
		return minimum(root);
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> aux = null;

		while(!node.isEmpty()) {
			aux = node;
			node = (BSTNode<T>) node.getLeft();
		}
		return aux;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> aux = null;

		if(!node.isEmpty()) {
			if(!node.getRight().isEmpty()) {
				aux = minimum((BSTNode<T>) node.getRight());
			} else {
				BSTNode<T> parent = (BSTNode<T>) node.getParent();
	
				while(parent != null && node.equals(parent.getRight())) {
					node = parent;
					parent = (BSTNode<T>) node.getParent();
				}
				aux = parent;
			}
			
		}
		return aux;

	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);

		if(node.isEmpty()) return null;

		if(!node.getLeft().isEmpty()) {
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
