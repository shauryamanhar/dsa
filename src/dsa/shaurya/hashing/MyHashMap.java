package dsa.shaurya.hashing;

import java.util.Objects;

public class MyHashMap {
	static final int MAX_CAPACITY = 100;
	private Node table[];
	private int size;

	class Node {
		int key, value;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	MyHashMap() {
		this.size = 0;
		this.table = new Node[MAX_CAPACITY];
	}

	int size() {
		return size;
	}

	boolean isEmpty() {
		return size == 0;
	}

	int hashcode(Node data) {
		return Objects.hash(data.key) ^ Objects.hash(data.value);
	}

	void put(int key, int value) {
		Node node = new Node(key, value);
		int hashcode = hashcode(node);
	}

}
