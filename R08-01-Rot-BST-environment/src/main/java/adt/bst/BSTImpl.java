package adt.bst;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

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
		if (node.isEmpty())
			return -1;
		else
			return 1 + Math.max((height((BSTNode<T>) node.getLeft())), height((BSTNode<T>) node.getRight()));
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(element, getRoot());
	}

	private BSTNode<T> search(T element, BSTNode<T> node) {
		BSTNode<T> result = null;

		if (node.isEmpty() || node.getData().equals(element)) {
			result = node;
		} else {
			if (element.compareTo(node.getData()) < 0) {
				result = search(element, (BSTNode<T>) node.getLeft());
			} else {
				result = search(element, (BSTNode<T>) node.getRight());
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			this.root = buildNode(element);
			this.root.getLeft().setParent(this.root);
			this.root.getRight().setParent(this.root);
		} else {
			insert(getRoot(), element);
		}
	}

	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
		} else if (element.compareTo(node.getData()) < 0) {
			insert((BSTNode<T>) node.getLeft(), element);
		} else {
			insert((BSTNode<T>) node.getRight(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;

		if (!isEmpty()) {
			result = maximum(getRoot());
		}
		return result;
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		BSTNode<T> result = node;

		if (!node.getRight().isEmpty()) {
			result = maximum((BSTNode<T>) node.getRight());
		}
		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;

		if (!isEmpty()) {
			result = minimum(getRoot());
		}
		return result;
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		BSTNode<T> result = node;

		if (!node.getLeft().isEmpty()) {
			result = minimum((BSTNode<T>) node.getLeft());
		}

		return result;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> result = null;

		if (!node.isEmpty()) {
			BSTNode<T> aux = (BSTNode<T>) node.getRight();
			if (!aux.isEmpty()) {
				result = minimum(aux);
			} else {
				result = sucessor(element, (BSTNode<T>) node.getParent());
			}
		}
		return result;
	}

	private BSTNode<T> sucessor(T element, BSTNode<T> node) {
		BSTNode<T> result = null;
		if (node.isEmpty() || node.getData().compareTo(element) > 0) {
			result = node;
		} else {
			result = sucessor(element, (BSTNode<T>) node.getParent());
		}
		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		BSTNode<T> result = null;
		if (!node.isEmpty()) {
			BSTNode<T> aux = (BSTNode<T>) node.getLeft();
			if (!aux.isEmpty()) {
				result = maximum(aux);
			} else {
				result = predecessor(element, (BSTNode<T>) node.getParent());
			}
		}
		return result;
	}

	private BSTNode<T> predecessor(T element, BSTNode<T> node) {
		BSTNode<T> result = null;
		if (node == null || node.getData().compareTo(element) < 0) {
			result = node;
		} else {
			result = predecessor(element, (BSTNode<T>) node.getParent());
		}
		return result;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);

		if (!node.isEmpty()) {
			if (node.isLeaf()) {
				if (node == getRoot()) {
					this.root = new BSTNode<T>();
				} else {
					node.setData(null);
					node.setLeft(null);
					node.setRight(null);
				}
			} else if (node.getRight().isEmpty()) {
				if (node == getRoot()) {
					this.root = (BSTNode<T>) getRoot().getLeft();
					getRoot().setParent(null);
				} else {
					BSTNode<T> parent = (BSTNode<T>) node.getParent();
					if (node.getLeft().getData().compareTo(parent.getData()) < 0) {
						parent.setLeft(node.getLeft());
					} else {
						parent.setRight(node.getLeft());
					}

					node.getLeft().setParent(parent);
				}
			} else if (node.getLeft().isEmpty()) {
				if (node == getRoot()) {
					this.root = (BSTNode<T>) this.root.getRight();
					this.root.setParent(null);
				} else {
					BSTNode<T> parent = (BSTNode<T>) node.getParent();
					if (node.getRight().getData().compareTo(parent.getData()) < 0) {
						parent.setLeft(node.getRight());
					} else {
						parent.setRight(node.getRight());
					}

					node.getRight().setParent(parent);
				}
			} else {
				T aux = minimum((BSTNode<T>) node.getRight()).getData();
				remove(aux);
				node.setData(aux);
			}
		}
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> result = new ArrayList<T>();
		preOrder(getRoot(), result);
		return (T[]) result.toArray(new Comparable[this.size()]);
	}

	private void preOrder(BSTNode<T> node, ArrayList<T> array) {
		if (!node.isEmpty()) {
			array.add((T) node.getData());
			preOrder((BSTNode<T>) node.getLeft(), array);
			preOrder((BSTNode<T>) node.getRight(), array);
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> result = new ArrayList<T>();
		order(getRoot(), result);
		return (T[]) result.toArray(new Comparable[this.size()]);
	}

	private void order(BSTNode<T> node, ArrayList<T> array) {
		if (!node.isEmpty()) {
			order((BSTNode<T>) node.getLeft(), array);
			array.add((T) node.getData());
			order((BSTNode<T>) node.getRight(), array);
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> result = new ArrayList<T>();
		postOrder(getRoot(), result);
		return (T[]) result.toArray(new Comparable[this.size()]);
	}

	private void postOrder(BSTNode<T> node, ArrayList<T> array) {
		if (!node.isEmpty()) {
			postOrder((BSTNode<T>) node.getLeft(), array);
			postOrder((BSTNode<T>) node.getRight(), array);
			array.add((T) node.getData());
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

	private BSTNode<T> buildNode(T element) {
		BSTNode<T> node = (BSTNode<T>) new BSTNode.Builder<T>()
				.data(element)
				.left(new BSTNode<T>())
				.right(new BSTNode<T>())
				.parent(null)
				.build();

		return node;
	}

	public LinkedList<BSTNode<T>> printBFS() {
		Deque<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		Deque<BSTNode<T>> result = new LinkedList<BSTNode<T>>();

		if (!isEmpty()) {
			queue.addLast(this.root);
			while (!queue.isEmpty()) {
				BSTNode<T> current = queue.removeFirst();

				result.add(current);

				if (!current.getLeft().isEmpty())
					queue.addLast((BSTNode<T>) current.getLeft());
				if (!current.getRight().isEmpty())
					queue.addLast((BSTNode<T>) current.getRight());
			}
		}

		return (LinkedList<BSTNode<T>>) result;
	}

	public boolean compareBST(LinkedList<BSTNode<T>> bst1, LinkedList<BSTNode<T>> bst2) {
		boolean result = true;
		for (int i = 0; i < bst1.size(); i++) {
			if (!(bst1.get(i).equals(bst2.get(i)))) {
				result = false;
			}
		}
		return result;
	}

	public T findAncestral(BSTNode<T> element1, BSTNode<T> element2) {
		T result = null;

		if(!element1.isEmpty() || !element2.isEmpty()) {
			result = findAncestralRecursive(this.root, element1, element2);
		} 
		return result;
	}

	private T findAncestralRecursive(BSTNode<T> current, BSTNode<T> node1, BSTNode<T> node2) {
		T result = null;
		
		if(node1.getData().equals(current.getData()) || node2.getData().equals(current.getData())) {
			result = current.getData();
		} 
		
		T left = findAncestralRecursive((BSTNode<T>)current.getLeft(), node1, node2);
		T right = findAncestralRecursive((BSTNode<T>)current.getRight(), node1, node2);
		
		if(left != null && right != null) {
			result = current.getData();
		} else if(left != null) {
			result = left;
		} else {
			result = right;
		}

		return result;
	}

	
	public boolean isBalanced() {
		return isBalanced(this.root);
	}

	private boolean isBalanced(BSTNode<T> node) {
		boolean result = false;

		if(!node.isEmpty()) {
			int leftHeight = this.heightBalanced((BSTNode<T>) node.getLeft());
			int rightHeight = this.heightBalanced((BSTNode<T>) node.getRight());

			if(Math.abs(leftHeight - rightHeight) <= 1 && isBalanced((BSTNode<T>) node.getLeft()) && isBalanced((BSTNode<T>) node.getRight())) {
				result = true;
			}
		}
		return result;
	}

	private int heightBalanced(BSTNode<T> node) {
		if (node.isEmpty())
			return -1;
		else
			return 1 + Math.max((height((BSTNode<T>) node.getLeft())), height((BSTNode<T>) node.getRight()));
	}

}
