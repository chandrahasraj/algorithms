package algorithms.datastructures;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class SortByValues {
	public static void main(String as[]){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		System.out.println(map);
		
		Comparator<String> comparator = new ValueComparator<String, Integer>(map);
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
 
		System.out.println(result);
	}
}

class ValueComparator<K, V extends Comparable<V>> implements Comparator<K>{
	 
	HashMap<K, V> map = new HashMap<K, V>();
 
	public ValueComparator(HashMap<K, V> map){
		this.map.putAll(map);
	}
 
	@Override
	public int compare(K s1, K s2) {
		return -map.get(s1).compareTo(map.get(s2));//descending order	
	}
}