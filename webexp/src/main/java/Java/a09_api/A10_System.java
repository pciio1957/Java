package Java.a09_api;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class A10_System {
	
	/*
	
	#System
	1. 현재 시스템(서버) 운영체제나 디렉토리에 대한 정보를 가져올때 활용된다.
	2. 지원메소드
		.getProperty("속성")
			속성 : os.name, user.name, user.home
		.getProperties() : 시스템의 모든 정보들을 Properties 객체로 가져온다
		.keySet() : 해당 내용을 Set형식의 key로 객체들로 가져올 수 있다.
		

	#Map형 구조
	데이터 처리 구조 가운데 
	key1 = value1, key2 = value2, key3 = value3 형식으로 되어있고
	이런 구조를 Map형 구조라고 한다.
	
	Properties()에는 현재 운영체제에 대한 정보를 key,value 형식으로 저장되어있다.
	System.getProperty("key") : 
		key를 매개변수로 입력하면 해당 기능메소드를 통해서 return값으로 value가 나온다
	System.getProperties() : 
		이 메소드를 통해서 현재 운영체제에 대한 전체 key/value정보를 확인할 수 있는데
		이때 key값.keySet()을 통해서 전체 키를 가져올 수 있다.
		
		
	
	#환경변수 확인 부분
	System.getenv("환경변수의 key")를 통해서 환경변수에 설정된 값을 가져올 수 있다.
	
		
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1. System
		String osName = System.getProperty("os.name");
		String userName = System.getProperty("user.name");
		String userHome = System.getProperty("user.home");
		
		System.out.println("# 현재 시스템(운영체제)에 대한 정보 #");
		System.out.println("운영체제 이름 : " + osName);
		System.out.println("사용자 이름 : " + userName);
		System.out.println("사용자 홈디렉토리 : " + userHome);
		
		// 전체 속성 가져오기 (key, value)형식으로 저장되어 있음
		Properties props = System.getProperties();
		
		
		
		// 2. map형 구조
		// keySet() : 가지고 있는 속성의 key를 Set객체로 가져올 수 있다.
		Set keys = props.keySet(); // import 주의 java.util.Set
		
		// [key1, key2, key3 ...] 이렇게 들어있음
		// 반복문을 통해서 key의 단위 객체를 가져오고 key, value값을 가져옴
		for(Object objKey:keys) {
			// key1 반복을 통해서 배열 형태의 데이터를 하나씩 가져와서
			String key = (String) objKey;
			// System.getProperty(key)를 통해서 value를 가져온다.
			// 위 key1에 연결되어 있는 value1값을 가져오는것! 
			String value = System.getProperty(key);
			System.out.println(key + " : " + value);
		}
		
		
		
		// 3. 환경변수
		Map maps = System.getenv();
		String paths = System.getenv("Path");
		System.out.println("환경변수 [Path] : " + paths); // 엄청 긺..
		
		
	}

}
