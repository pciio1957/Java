package Java.a14_generic;

import Java.a06_object.vo.Product;

public class A04_MultiGeneric {
	
	/*
	#generic을 활용하여 여러객체의 속성 설정하여 처리하기
	1. 형식
		class 클래스명<K, V> {
			private K key;
			private V value;
		}
		위와 같이 두가지 이상의 속성을 가변적으로 객체로 사용해서
		활용할 수 있다.
	*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Pair<Integer, String> p01 = new Pair<Integer, String>(1, "사과");
		Pair<Integer, String> p02 = new Pair<Integer, String>(2, "배");
		
		System.out.println(p01.getKey() + " : " + p01.getValue());
		System.out.println(p02.getKey() + " : " + p02.getValue());
		
		Pair<Integer, Product> p03 = new Pair<Integer, Product>
					(3, new Product("오렌지", 4000, 2));
		System.out.println(p03.getKey());
		// value로 객체가 할당되어있기에 객체를 가져올 수 있다.
		Product pro = p03.getValue();
		System.out.println(pro.getName());
		
		
		
		// 응용) OracleInfo<String, String>으로 처리할 수 있게
		// generic 객체를 선언하여 아래 유형 값을 할당하고 출력할 수 있게 하기(5조)
		
		OracleInfo<String, String> or1 = new OracleInfo<String, String>("driver", "oracle.jdbc.OracleDriver");
		OracleInfo<String, String> or2 = new OracleInfo<String, String>("url", "jdbc:oracle:thin:@localhost:1521:orcl");
		OracleInfo<String, String> or3 = new OracleInfo<String, String>("username", "scott");
		OracleInfo<String, String> or4 = new OracleInfo<String, String>("password", "tiger");
		
		System.out.println(or1.getKey() + " : " + or1.getValue());
		System.out.println(or2.getKey() + " : " + or2.getValue());
		System.out.println(or3.getKey() + " : " + or3.getValue());
		System.out.println(or4.getKey() + " : " + or4.getValue());
		
		
		// 응용) BaseBall<T, P, R> : 팀명, 선수, 기록을 할당할 수 있게 처리하기 (6조)
		BaseBall<String, String, Integer> ball1 = new BaseBall<String, String, Integer>("백호야구단", "홍길동", 2);
		BaseBall<String, String, Integer> ball2 = new BaseBall<String, String, Integer>("청룡야구단", "신길동", 1);
		BaseBall<String, String, Integer> ball3 = new BaseBall<String, String, Integer>("주작야구단", "오길동", 3);
		
		System.out.println(ball1.getT() + "팀의 " + ball1.getP() + "의 기록은 " + ball1.getR() + "등 입니다");
		System.out.println(ball2.getT() + "팀의 " + ball2.getP() + "의 기록은 " + ball2.getR() + "등 입니다");
		System.out.println(ball3.getT() + "팀의 " + ball3.getP() + "의 기록은 " + ball3.getR() + "등 입니다");
	}

}

class Pair<K, V> {
	private K key;
	private V value;
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}	
}

class OracleInfo<K, V> {
	private K key;
	private V value;
	
	public OracleInfo(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	
}

class BaseBall<T, P, R> {
	private T t;
	private P p;
	private R r;
	
	public BaseBall(T t, P p, R r) {
		super();
		this.t = t;
		this.p = p;
		this.r = r;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public P getP() {
		return p;
	}

	public void setP(P p) {
		this.p = p;
	}

	public R getR() {
		return r;
	}

	public void setR(R r) {
		this.r = r;
	}
}
