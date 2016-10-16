package algorithms.interviewQuestions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class OrderDescending {

	public static void main(String as[]){
		String input ="1005 2\n1001 5\n1002 5\n1004 1";
		String data[]= input.split("\n");
		HashMap<Integer,Integer> map= new HashMap<>();
		for(String d:data){
			int key=Integer.valueOf(d.split(" ")[0]);
			int value=Integer.valueOf(d.split(" ")[1]);
			
			map.put(key, value);
		}
		System.out.println(map);
		
		Comparator<Integer> comp=new Customer(map);
		TreeMap<Integer,Integer> tmap=new TreeMap<>(comp);
		tmap.putAll(map);
		System.out.println(tmap);
	}
}

class Customer  implements Comparator<Integer>{
	HashMap<Integer,Integer>map=new HashMap<>();
	Customer(HashMap<Integer,Integer>map){
		this.map.putAll(map);
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		if(map.get(o1)<map.get(o2))
			return -1;
		else if(map.get(o1)>=map.get(o2))
			return 1;
		return 0;
	}

}
