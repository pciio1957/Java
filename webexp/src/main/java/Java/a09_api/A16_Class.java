package Java.a09_api;

import java.util.Scanner;

import Java.z01_vo.Book;
import Java.z01_vo.Car;
import Java.z01_vo.Food;
import Java.z01_vo.Product;

public class A16_Class {
	
	/*
	#Class
	1. 클래스와 인터페이스의 메터테이터 관리
		메터데이터 : 클래스의 이름, 생성자, 필드, 메소드 정보
	2. Class의 객체 얻기
		1) getClass() : 
			ex) Class class1 = obj.getClass();
		2) Class.forName("문자열클래스정보")
	3. Class를 통한 객체 생성
		.newInstance()
		
	
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. 메터데이터 가져오기 위한 처리
		Car c1 = new Car();
		// clazz1을 통해서 Car 클래스의 메타정보를 가져온다
		Class clazz1 = c1.getClass();
		
		System.out.println(clazz1.getName()); // 패키지명.클래스명
		System.out.println(clazz1.getSimpleName()); // 클래스명만
		System.out.println(clazz1.getPackage().getName()); // 패키지명만
		
		try {
			Class clazz2 = Class.forName("javaexp.z01_vo.Book");
			System.out.println(clazz2.getName()); // 패키지명.클래스명
			System.out.println(clazz2.getSimpleName()); // 클래스명만
			System.out.println(clazz2.getPackage().getName()); // 패키지명만
			// newInstance는 Object형식으로 와서 타입캐스팅이 필요함
			Book b1 = (Book) clazz2.newInstance();
			b1.setbName("자바기초");
			System.out.println(b1.getbName());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 응용) javaexp.z01_vo.Food, javaexp.z01_vo.Product 
		//		Class 객체 메타정보를 위한 생성 2가지 방식을 활용해 처리하고
		//		객체 Food를 Class에 의해 생성하고 기능메소드를 활용하세요
		
		// 1번째 방식
		Food fod = new Food("바나나", 1200, "3");
		Class cla1 = fod.getClass();
		System.out.println(cla1.getName());
		System.out.println(cla1.getSimpleName());
		System.out.println(cla1.getPackageName());
		
		// 2번째 방식
		try {
			Class cla2 = Class.forName("javaexp.z01_vo.Product");
			System.out.println(cla2.getName());
			//System.out.println(cla2.getPrice());
			
			Product pro = (Product) cla2.newInstance();
			pro.setName("물건");
			System.out.println(pro.getName());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
