package Java.a10_collections;

import java.util.HashSet;
import java.util.Set;

public class A04_Set {
	
	/*
	
	#Set 하위객체 
	1. 중복불가, 순서확보 안됨

	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Set<String> set = new HashSet<String>();
		set.add("자바");
		set.add("자바");
		set.add("jsp");
		set.add("jsp");
		set.add("스프링");
		set.add("Mybatis");
		System.out.println("# 저장된 Set객체 #");
		for(String ele:set) {
			System.out.println(ele);
		}
		
	}

}