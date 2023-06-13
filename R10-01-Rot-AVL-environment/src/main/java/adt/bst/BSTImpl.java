package adt.bst;

import java.util.ArrayList;

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
		return height(this.root);
	}

	protected int height(BSTNode<T> node) {
		if (node.isEmpty())
			return -1;
		else
			return 1 + Math.max(height((BSTNode<T>) node.getLeft()),
					height((BSTNode<T>) node.getRight()));
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(this.root, element);
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> result = new BSTNode<T>();
		if (element != null) {
			if (node.isEmpty() || node.getData().equals(element))
				result = node;
			else if (element.compareTo(node.getData()) < 0) {
				result = search((BSTNode<T>) node.getLeft(), element);
			} else {
				result = search((BSTNode<T>) node.getRight(), element);
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			insert(this.root, element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode.Builder<T>().parent(node).build());
			node.setRight(new BSTNode.Builder<T>().parent(node).build());

		} else {
			if (element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>) node.getLeft(), element);
			} else {
				insert((BSTNode<T>) node.getRight(), element);
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;
		if (!this.isEmpty()) {
			result = maximum(this.root);
		}
		return result;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		if (node.getRight().isEmpty())
			return node;
		else
			return maximum((BSTNode<T>) node.getRight());
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;
		if (!this.isEmpty()){
			result = minimum(this.root);
		}
		return result;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		if (node.getLeft().isEmpty())
			return node;
		else
			return minimum((BSTNode<T>) node.getLeft());
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> result = null;

		if (element != null) {
			BSTNode<T> node = this.search(element);
			if (!node.isEmpty()) {
				if (!node.getRight().isEmpty()) {
					result = this.minimum((BSTNode<T>) node.getRight());
				} else {
					result = sucessor(node, element);
				}
			}
		}
		return result;
	}

	private BSTNode<T> sucessor(BSTNode<T> node, T element) {
		if (node != null && node.getData().compareTo(element) <= 0) {
			return sucessor((BSTNode<T>) node.getParent(), element);
		} else {
			return node;
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> result = null;

		if (element != null) {
			BSTNode<T> node = this.search(element);
			if (!node.isEmpty()) {
				if (!node.getLeft().isEmpty()) {
					result = this.maximum((BSTNode<T>) node.getLeft());
				} else {
					result = predecessor(node, element);
				}
			}
		}
		return result;
	}

	private BSTNode<T> predecessor(BSTNode<T> node, T element) {
		if (node != null && node.getData().compareTo(element) >= 0) {
			return predecessor((BSTNode<T>) node.getParent(), element);
		} else {
			return node;
		}
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = this.search(element);
		if (!node.isEmpty()) {
			this.remove(node);
		}
	}

	private void remove(BSTNode<T> node) {
		if (node.isLeaf()) {
			node.setData(null);
			node.setLeft(null);
			node.setRight(null);
		} else if (!node.getLeft().isEmpty() && node.getRight().isEmpty()) {
			if (node.equals(this.root)) {
				this.root = (BSTNode<T>) node.getLeft();
				this.root.setParent(null);
			} else {
				node.getLeft().setParent(node.getParent());

				if (node.getData().compareTo(node.getParent().getData()) < 0) {
					node.getParent().setLeft(node.getLeft());
				} else {
					node.getParent().setRight(node.getLeft());
				}
			}
		} else if (node.getLeft().isEmpty() && !node.getRight().isEmpty()) {
			if (node.equals(this.root)) {
				this.root = (BSTNode<T>) node.getRight();
				this.root.setParent(null);
			} else {
				node.getRight().setParent(node.getParent());

				if (node.getData().compareTo(node.getParent().getData()) < 0) {
					node.getParent().setLeft(node.getRight());
				} else {
					node.getParent().setRight(node.getRight());
				}
			}
		} else {
			BSTNode<T> sucessor = this.sucessor(node.getData());
			T element = sucessor.getData();
			this.remove(sucessor);
			node.setData(element);
		}
	}

	@Override
	public T[] preOrder() {
		return preOrder(this.root, new ArrayList<T>());
	}

	private T[] preOrder(BSTNode<T> node, ArrayList<T> list) {
		if (!node.isEmpty()) {
			list.add(node.getData());
			this.preOrder((BSTNode<T>) node.getLeft(), list);
			this.preOrder((BSTNode<T>) node.getRight(), list);
		}
		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public T[] order() {
		return order(this.root, new ArrayList<T>());
	}

	private T[] order(BSTNode<T> node, ArrayList<T> list) {
		if (!node.isEmpty()) {
			this.order((BSTNode<T>) node.getLeft(), list);
			list.add(node.getData());
			this.order((BSTNode<T>) node.getRight(), list);
		}
		return (T[]) list.toArray(new Comparable[0]);
	}

	@Override
	public T[] postOrder() {
		return postOrder(this.root, new ArrayList<T>());
	}

	private T[] postOrder(BSTNode<T> node, ArrayList<T> list) {
		if (!node.isEmpty()) {
			this.postOrder((BSTNode<T>) node.getLeft(), list);
			this.postOrder((BSTNode<T>) node.getRight(), list);
			list.add(node.getData());
		}
		return (T[]) list.toArray(new Comparable[0]);
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
