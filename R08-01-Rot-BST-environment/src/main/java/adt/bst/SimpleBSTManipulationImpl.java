package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		return equals((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
	}

	private boolean equals(BSTNode<T> node1, BSTNode<T> node2) {
		boolean result = false;
		if(node1.isEmpty() && node2.isEmpty()) {
			result = true;
		} else if(!node1.isEmpty() && !node1.isEmpty()) {
			if(node1.equals(node2)) {
				result = equals((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft()) 
						&& equals((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
			}
		}
		return result;
	}

	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		return isSimilar((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
	}

	private boolean isSimilar(BSTNode<T> node1, BSTNode<T> node2) {
		boolean result = false;
		if(node1.isEmpty() && node2.isEmpty()) {
			result = true;
		} else if(!node1.isEmpty() && !node1.isEmpty()) {
			result = isSimilar((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft()) 
				  && isSimilar((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
		}
		return result;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T result = null;
		int count  = 0;
		if(k >= 1) {
			result = this.orderStatistic((BSTNode<T>) tree.getRoot(), k, count);
		}
		return result;
	}

	private T orderStatistic(BSTNode<T> node, int k, int count) {
		T result = null;
		if(!node.isEmpty()) {
			result = orderStatistic((BSTNode<T>) node.getLeft(), k, count);
			count++;
			if(count == k) {
				result = node.getData();
			}
			if(result == null) {
				result = orderStatistic((BSTNode<T>) node.getRight(), k, count);
			}
		}
		return result;
	}
}
