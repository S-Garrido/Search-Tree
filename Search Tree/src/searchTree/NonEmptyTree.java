package searchTree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * <ul>
 * <li>A key
 * <li>A value (that the key maps to)
 * <li>A reference to a left Tree that contains key:value pairs such that the
 * keys in the left Tree are less than the key stored in this tree node.
 * <li>A reference to a right Tree that contains key:value pairs such that the
 * keys in the right Tree are greater than the key stored in this tree node.
 * </ul>
 *  
 */
 public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {
	
	private Tree<K,V> left, right;
	private K key;
	private V value;

	public NonEmptyTree(K key, V value, Tree<K,V> left, Tree<K,V> right) { 
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public V search(K key) { //Searches tree for specified key
		if(key.compareTo(this.key) == 0) {
			return this.value;
		} else if(key.compareTo(this.key) > 0) {
			return this.right.search(key);
		} else if(key.compareTo(this.key) < 0) {
			return this.left.search(key);
		} else {
			return null;
		}
	}
	
	public NonEmptyTree<K, V> insert(K key, V value) { // Inserts key with specified value in tree
		int theKey = key.compareTo(this.key);
		if(theKey > 0) {
			right = this.right.insert(key, value);
			return this;
		} else if(theKey < 0) {
			left = this.left.insert(key,  value);
			return this;
		} else if(theKey == 0){
			this.value = value;
			return this;
		} else {
		}
			return this;
		}
	
	public Tree<K, V> delete(K key) { //deletes one specified key
		int theKey = key.compareTo(this.key);
		if(theKey > 0) {
			right = this.right.delete(key);
			return this;
		} else if(theKey < 0) {
			left = this.left.delete(key);
			return this;
		} else if(theKey == 0){
			try {
			this.key = this.left.max();
			this.value = this.left.search(this.key);
			left = this.left.delete(this.key);
			return this;
			} catch (TreeIsEmptyException e) {
				return this.right;
			}
		} else {
			return this;
		}	
		}

	public K max() { //Find tree's max value
		try { //check if it has a right child
			return this.right.max();
		}
		catch (TreeIsEmptyException e) {
			return this.key;
		}
	}

	public K min() { //Find tree's min value
		try { //check if it has a left child
			return this.left.min();
		}
		catch (TreeIsEmptyException e) {
			return this.key;
		}
	}

	public int size() { //return size of tree
		return this.left.size() + this.right.size() + 1;
		
	}

	public void addKeysToCollection(Collection<K> c) { //add keys in tree to collection c
		this.left.addKeysToCollection(c);
		c.add(this.key);
		this.right.addKeysToCollection(c);
	}
	
	public Tree<K,V> subTree(K fromKey, K toKey) { //create new tree only with keys in specified range
		int to = toKey.compareTo(this.key);
		int from = fromKey.compareTo(this.key);
		if(to > 0 && from < 0 || from == 0 || to == 0) {
			NonEmptyTree<K, V> sub = new NonEmptyTree<K,V>(this.key, this.value, left.subTree(fromKey, toKey), right.subTree(fromKey, toKey));
			return sub;
		} else if(to > 0){
			return this.left.subTree(fromKey, toKey);
		} else {
			return this.right.subTree(fromKey, toKey);
		}
	}
}