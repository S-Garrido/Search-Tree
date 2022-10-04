package searchTree;

import java.util.Collection;

/**
 * This class is used to represent the empty search tree: a search tree that
 * contains no entries.
 * 
 * This class is a singleton class: since all empty search trees are the same,
 * there is no need for multiple instances of this class. Instead, a single
 * instance of the class is created and made available through the static field
 * SINGLETON.
 * 
 * The constructor is private, preventing other code from mistakenly creating
 * additional instances of the class.
 *  
 */
 public class EmptyTree<K extends Comparable<K>,V> implements Tree<K,V> {
	/**
	 * This static field references the one and only instance of this class.
	 * We won't declare generic types for this one, so the same singleton
	 * can be used for any kind of EmptyTree.
	 */
	private static EmptyTree SINGLETON = new EmptyTree();

	public static  <K extends Comparable<K>, V> EmptyTree<K,V> getInstance() {
		return SINGLETON;
	}

	/**
	 * Constructor is private to enforce it being a singleton
	 *  
	 */
	private EmptyTree() {
		// Nothing to do
	}
	
	public V search(K key) { //Searches tree for specified key
		return null;
	}
	
	public NonEmptyTree<K, V> insert(K key, V value) { // Inserts key with specified value in tree
		NonEmptyTree<K, V> tree = new NonEmptyTree(key, value, SINGLETON, SINGLETON );
		return tree;
	}

	public Tree<K, V> delete(K key) { //deletes one specified key
		return SINGLETON;
	}
	
	public K max() throws TreeIsEmptyException { //Find tree's max value
		throw new TreeIsEmptyException();	
	}

	public K min() throws TreeIsEmptyException { //Find tree's min value
		throw new TreeIsEmptyException();
	}

	public int size() { //return size of tree
		return 0;
	}

	public void addKeysToCollection(Collection<K> c) { //add keys in tree to collection c
		
	}

	public Tree<K,V> subTree(K fromKey, K toKey) { //create new tree only with keys in specified range
		return SINGLETON;
	}
}