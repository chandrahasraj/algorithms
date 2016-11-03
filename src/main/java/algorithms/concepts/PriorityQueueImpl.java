package algorithms.concepts;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PriorityQueueImpl {
	public static void main(String as[]) {
		Comparator<User> cmp = new Comparator<User>() {
			@Override
			public int compare(User u1, User u2) {
				return new Integer(u1.height).compareTo(u2.height);
			}
		};
		List<User> user = new ArrayList<>();
		user.add(new User(10, 120));
		user.add(new User(11, 110));
		user.add(new User(20, 90));
		user.add(new User(9, 160));
		user.add(new User(15, 150));
		user.add(new User(16, 177));

		QueueImpl<User> queue = new QueueImpl<>(User.class);
		for (User u : user) {
			queue.enqueue(u, cmp);
			System.out.println("current head-->" + queue.peek().toString());
		}
		
		User u = queue.dequeue(cmp);
		
		while (u!=null) {
			System.out.println("current head after deque-->" + u.toString());
			u = queue.dequeue(cmp);
			if(u==null)
				break;
		}
	}
}

class User {
	int age;
	int height;

	public User(int age, int height) {
		super();
		this.age = age;
		this.height = height;
	}

	public String toString() {
		return "current data " + age + "," + height;
	}
}

class QueueImpl<T> {
	T data[];
	int priority;
	private static final float fill_ratio = 0.75f;
	private static final int default_size = 10;
	int size;

	QueueImpl(Class<T> cls) {
		this(cls, default_size);
		size = 0;
	}

	@SuppressWarnings("unchecked")
	QueueImpl(Class<T> cls, int length) {
		data = (T[]) Array.newInstance(cls, length);
		size = 0;
	}

	@SuppressWarnings("unchecked")
	private void doubleArraySize(int length) {
		if ((size / length) >= fill_ratio) {
			T temp[] = Arrays.copyOf(data, length * 2);
			int i = 0;
			for (T value : data)
				temp[i++] = value;
			data = temp;
		}
	}

	void enqueue(T e, Comparator<? super T> cmp) {
		int i = size;
		doubleArraySize(data.length);
		size++;
		if (i == 0)
			data[i] = e;
		else {
			if (cmp != null) {
				while (i > 0) {
					int parent = i >>> 1;
					if (cmp.compare(e, data[parent]) >= 0)
						break;
					data[i] = data[parent];
					i = parent;
				}
				data[i] = e;
			} else {
				while (i > 0) {
					int parent = i >>> 1;
					Comparable<? super T> cp = (Comparable<? super T>) e;
					if (cp.compareTo(data[parent]) >= 0)
						break;
					data[i] = data[parent];
					i = parent;
				}
				data[i] = e;
			}
		}
	}

	T peek() {
		if (size == 0)
			return null;
		return data[0];
	}

	T dequeue(Comparator<? super T> cmp) {
		if(size==0)
			return null;
		int i = 0, half = size >>> 1;
		size--;
		T el = data[0];
		T last = data[size];

		while (i < half) {
			if (cmp != null) {
				int child = (i << 1) + 1;
				int right = child + 1;
				T temp = data[child];
				if (right < size && (cmp.compare(data[child], data[right]) > 0))
					temp = data[child = right];
				if (cmp.compare(last, temp) <= 0)
					break;
				data[i] = temp;
				i = child;
			} else {
				int child = (i << 1) + 1;
				int right = child + 1;
				T temp = data[child];
				Comparable<? super T> cp = (Comparable<? super T>) temp;
				if (right < size && (cp.compareTo(data[right]) > 0))
					temp = data[child = right];
				if (cp.compareTo(last) <= 0)
					break;
				data[i] = temp;
				i = child;
			}
		}
		data[i] = last;
		return el;
	}
}