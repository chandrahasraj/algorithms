package algorithms.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaTricks {
	
	public static void main(String[] args) {
		Student s1=new Student(10,11,"asd");
		Student s2=new Student(1,11,"ew");
		Student s3=new Student(12,11,"fhr");
		Student s4=new Student(1,11,"qwe");
		List<Student> ll=new ArrayList<>();
		ll.add(s1);ll.add(s2);ll.add(s3);ll.add(s4);
		for(Student st:ll)
		System.out.print(st.toString());
		System.out.println();
		Collections.sort(ll,new AgeCompare());
		for(Student st:ll)
			System.out.print(st.toString());
	}
	
}

class Student{
	int age,number;
	String name;
	
	Student(int age,int number,String name){
		this.age=age;
		this.number=number;
		this.name=name;
	}
	@Override
	 public String toString(){
		return String.format("%d ", age);
	}
}

class AgeCompare implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.age<o2.age)
			return -1;
		else 
			return 1;
	}
	
}
