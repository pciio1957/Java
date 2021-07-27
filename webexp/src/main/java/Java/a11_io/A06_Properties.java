package Java.a11_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

public class A06_Properties {
	
	

	/*
	#Properties 
	1. 특정한 파일을 호출하여 해당 파일의 내용이 key = vaule로 되어있는 경우나
		key로 value를 설정하는 경우에 활용한다.
		주로 시스템에 서버정보나 공통정보를 파일로 저장했다가 
		한번에 모든 코드에서 활용할 때 주로 활용된다.
	2. getProperty("key") 메소드로 된 내용을 값으로 문자열로 
		할당하여 가져온다 
	3. 기능메소드
		1) load(new FilReader("파일명/경로명")) 
			해당 파일을 로딩 처리한다
		2) getProperty() : key로 설정한 값을 가져온다.
		
	
	#Properties 객체의 활용
	1. 특정한 파일에 key=value형식으로 데이터를 저장한다.
	2. FileReader 객체를 통해서 해당 파일의 텍스트로 된 정보를 읽어온다.
	3. load()를 통해서 해당 정보를 Properties객체에 할당함으로 
		key/value 구조를 인식할 수 있게 한다.
	4. .getProperty("key")를 통해서 매칭되어있는 value값을
		가져온다
		
	
	#필수 예외 처리
	1. IO가 일어나는 경우 반드시 예외를 처리해야 한다.
		- File관련해서 IO발생
		- 기본 Stream처리 IO : IOException
	2. encoding처리시 지정한 encoding을 설정할 수 없을 때 
		발생하는 예외처리 : Unsupported EncodingException (오류나서 띄어쓰기함)
	
	*/
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		
		// 파일을 절대경로로 작성해준다.
		// 시스템상 절대경로를 가져온다. 
		// 메인클래스명.class.getResource(
		//	"메인클래스와 같이 있는 파일명").getPath()
		// 경로명이나 파일명에 한글이 포함된 경우 decode처리
		String path = A06_Properties.class.getResource("database.properties")
				.getPath();
		System.out.println("절대경로와 파일명 : " + path);
		// 실행하는 객체를 기준으로 같은 패키지에 설정파일이 있을때
		// 
		try {
			path = URLDecoder.decode(path, "utf-8");
			// FileReader : Stream 객체중에 OutputStream 하위 객체로
			// 파일의 내용을 읽을 수 있는 객체
			// Properties의 기능메소드 load()를 통해서 읽어온다
			prop.load(new FileReader(path));
			System.out.println("driver : " + prop.getProperty("driver")); 
			// 아까 작성한 database.properties에 작성했던 내용들을 가져와서 출력
			System.out.println("url : " + prop.getProperty("url")); 
			System.out.println("username : " + prop.getProperty("username")); 
			System.out.println("password : " + prop.getProperty("password")); 
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// 응용) 같은
	}
	

}
