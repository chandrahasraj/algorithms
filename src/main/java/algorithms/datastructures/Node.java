/**
 * 
 */
package algorithms.datastructures;

/**
 * @author chand
 *
 */
public abstract class Node<T> {
	T data;
	Node<T> left, right;

	public abstract void delete(T data);

	public abstract void insert(T data);

	public abstract void display();

	public abstract boolean lookup(T data);

	public Node(T data, Node<T> left, Node<T> right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public int compare(Node<T> o1, Node<T> o2) {
		if (String.class.isInstance(o1.getData())) {
			String d1 = (String) o1.getData();
			String d2 = (String) o2.getData();
			return d1.compareTo(d2.toString());
		} else {
			return ((Integer) o1.getData() - ((Integer) o2.getData())) < 0 ? -1
					: ((Integer) o1.getData() - ((Integer) o2.getData())) > 0 ? 1 : 0;
		}
	}

}
