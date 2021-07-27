package Java.a07_inherit;

public class A03_Interface {
	
	/*
	 # 인터페이스 상속
	 1. 인터페이스는 상위에 기능 메소드와 추상 메소드를 통해서 하위의 
	 여러가지 기능을 효과적으로 처리할 때 사용된다.
	 2. 기본형식 
	 interface 인터페이스명 {
	 
	 	void call(); 
	 	// 인터페이스는 기본적으로 public abstract가 포함되어있기 때문에
	 	// 생략이 가능하다.
	 }
	 
	 // 기본
	 하위클래스 implements 인터페이스명1 {
	 	// 상위에 선언된 추상메소드를 반드시 하위에 선언해야한다.
	 	void call() {
	 		// 오버라이딩(재정의) 선언
	 	}
	 }
	 
	 // 인터페이스는 여러개를 상속받을 수 있다.
	 하위클래스 implements 인터페이스명1, 인터페이스2 {
	 	// 상위에 선언된 추상메소드를 반드시 하위에 선언해야한다.
	 	void call() {
	 		// 오버라이딩(재정의) 선언
	 	}
	 }
	 => cf) 일반 상속은 extends는 단일 상위 클래스만 가능하지만,
	 		인터페이스는 여러 개의 상위 인터페이스를 상속 가능하다.
	 
	 3. 기타 인터페이스의 필드와 속성
	 	1) 인터페이스의 필드는 static 상수만 사용한다.
	 	2) default 메소드가 있다.
	 	3) static 메소드를 선언할 수 있다.
	 
	 
	*/
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Flyway f1 = new ContryFlying();
		f1.flying();
		Flyway f2 = new WorldFlying();
		f2.flying();
		
		// 응용1) interface로 SoundWay를 선언하고, 메소드로 sound()로 추상메소드 선언
		// 		하위에 실제클래스로 DuckSound, BabySound, RebotSound를
		//		상속받아 main()에서 호출하여 처리하기
		
		SoundWay s1 = new DuckSound();
		SoundWay s2 = new BabySound();
		SoundWay s3 = new RobotSound();
		
		s1.sound();
		s2.sound();
		s3.sound();
		
		// 마징가제트 예제 실행 - 날개를 장착하지않은 상태(setfly X)라서 장착되지 않았다고 나옴
		MZ m1 = new MZ();
		m1.flying(); 
		
		
		
		// 인터페이스로 매개변수가 있으면 상속받은 여러가지 하위클래스는 
		// 다형성에 의해서 할당할 수 있다.
		// public void setfly(FlyWay fly) 
		// Flyway fly = new ContryFlying();
		m1.setFly(new ContryFlying());
		m1.flying();
		
		m1.setFly(new WorldFlying());
		m1.flying();
		
		m1.setFly(new SpaceFlying());
		m1.flying();
		
		// 응용2) SpaceFlying 우주를 날다
		// 응용3) SoundBox 클래스의 위에 정의한 SoundWay를 필드로 선언하여
		//		setSound()와 showsound() 메소드를 통해서 다양한 소리가 나오도록 하기
		
		// 응용3
		SoundBox sb = new SoundBox();
		sb.sound();
		
		sb.setsound(new DuckSound());
		sb.sound();
		
		sb.setsound(new BabySound());
		sb.sound();
		
		sb.setsound(new RobotSound());
		sb.sound();
		
		
		// 응용4) MZ에 AttackWay 인터페이스를 선언하고 attack() 추상메소드 선언
		//	상속받는 실제 클래스 LaserBeam, RocketMissile 
		// MZ 하위에 AttackWay를 할당하는 부분과 attack()을 통해 여러가지 공격방법에 따른 처리
	
		// 응용4
		m1.attack(); // 하위객체를 설정하지않았을때 
		
		m1.setattack(new LaserBeam()); // 하위객체를 설정했을때
		m1.attack();
		
		m1.setattack(new RocketMissile());
		m1.attack();
	}

}

// 인터페이스 생성
interface Flyway {
	
		void flying();	
}

// 인터페이스를 상속받는 하위클래스 ContryFlying 생성
class ContryFlying implements Flyway {
	
	public void flying() {
		System.out.println("우리 동네를 날아다니다!");
	}
}

// 인터페이스를 상속받는 하위클래스 WorldFlying 생성
class WorldFlying implements Flyway {
	
	public void flying() {
		System.out.println("전세계를 날아다니다");
	}
}

// 응용2) 우주를 나는 SpaceFlying 클래스 생성
class SpaceFlying implements Flyway {
	
	public void flying() {
		System.out.println("우주를 날아다니다!");
	}
}

//마징가제트 예제 
//인터페이스를 사용하면 추가적이거나 변경된 기능을 메인 객체인 Mz에
//코드를 하지 않더라도 처리가 가능하며 보다 효과적인 프로그래밍을 할 수 있다. 
class MZ {
	private Flyway fly; // 인터페이스를 변수로 선언
	private AttackWay aw; // 응용4) 인터페이스를 변수로 선언
	
	// 마징가제트의 날개를 다는 작업
	public void setFly(Flyway fly) {
		this.fly = fly;
	}
	
	
	// 마징가제트의 나는일, if로 날개가 장착되었는지 확인
	public void flying() {
		System.out.println("로봇이!");
		if (fly!=null) {
			fly.flying();
		}else {
			System.out.println("날개가 장착되지 못했습니다! ");
		}
	}
	
	// 응용4 
	public void setattack(AttackWay a) {
		this.aw = a;
	}
	
	public void attack() {
		System.out.println("# 마징가의 공격~!! #");
		if(aw!=null) {
			aw.attack();
		} else {
			System.out.println("무기를 장착하지 않았습니다");
		}
	}
	
	
}


// 응용1) 인터페이스 생성
interface SoundWay {
	void sound();
}

// 응용1) 상속받는 하위클래스 생성
class DuckSound implements SoundWay {
	public void sound() {
		System.out.println("오리가 꽥꽥거리는 소리");
	}
}

class BabySound implements SoundWay {
	public void sound() {
		System.out.println("아기가 우는 소리");
	}
}

class RobotSound implements SoundWay {
	public void sound() {
		System.out.println("로봇이 위잉거리는 소리");
	}
}


//응용3) SoundBox
class SoundBox {
	private SoundWay so;
	
	// 상속받은 하위객체가 매개변수로 들어올 수 있도록 처리
	public void setsound(SoundWay s) {
		this.so = s;
	}
	
	// 하위객체가 들어왔는지 확인 후 소리 출력
	public void sound() {
		System.out.println("소리상자에서 ");
		
		if (so != null) {
			so.sound();
		} else {
			System.out.println("소리가 나지않습니다!");
		}
	}
}


// 응용4) 마징가제트의 공격
// 인터페이스 생성
interface AttackWay {
	
	// 인터페이스는 public abstract 가 생략되어있어서 void 이름(); 만 쓰면 된다.
	void attack();
}

class LaserBeam implements AttackWay {
	
	public void attack() {
		System.out.println("레이저빔을 발사한다!");
	}
}

class RocketMissile implements AttackWay {
	
	public void attack() {
		System.out.println("로켓미사일을 발사한다!");
	}
}
