
/*

전날 정리문제
1. 함수 종속성의 개념을 js에서 아는 function의 예로 기술하세요.
	
	- 풀이
	함수 종속성 : 데이터가 특정 함수에 종속되어 매개변수로 입력된 데이터가 결과값에 종속여부를 나타낸다

	function plus(num01, num02) {
		return num01+num02;
	}
	
	-> plus(25,5) 메소드 실행 => 30 결과 출력
	25, 5라는 데이터는 30을 만들기 위한 종속적인 데이터이다
	ex) 이름, 나이, 사는 곳, 생년월일로 된 인적사항으로 => 주민번호를 조합할 수 있고 종속적인 데이터이다.
		그러므로 이름, 나이, 사는 곳, 생년월일의 데이터는 주민번호에 종속적인 데이터이다 
	

2. 제1정규화/제2정규화의 개념을 기본예제와 함께 기술하세요.

	1) 기본이 되는 테이블 작성 
	create table normal_student00 (
		stuno number,
		stuname varchar2(50),
		stugrade number,
		clsno varchar2(100),
		clstitle varchar2(50)
	);
	
	insert into normal_student00 values(01, '홍길동', 2, '1001, 1003, 1005', '국어, 수학, 사회');

	2) 1정규화 실행 : 한 컬럼에 한 데이터만 존재하도록 만듦
	- 복사테이블을 생성하는데 구조만 가져옴
	create table normal_student01
	as select * from normal_student00 where 1=0;
	
	- 수업번호 구조변경
	alter table normal_student01 
	modify clsno number; 
	
	- 데이터 변경
	insert into normal_student01 values(01, '홍길동', 2, 1001, '국어');
	insert into normal_student01 values(01, '홍길동', 2, 1003, '수학');
	insert into normal_student01 values(01, '홍길동', 2, 1005, '사회');
	
	3) 2정규화 실행 : 완전 함수 종속성 만족하도록 부분 종속성 부분 분리
	create table normal_student02
	as select stuno, stuname, stugrade 
	from normal_student01;
	
	create table normal_class02
	as select stuno, clsno, clstitle
	from normal_class02; 
	
	
3. 아래 테이블을 제1정규화 과정을 거쳐 테이블을 구성하세요.
고객번호  고객명   구매물건         구매건수                    
1000    홍길동   사과,바나나,딸기   5,4,3
1001    김길동   오렌지,수박,키위   5,3,2
1002    신길동   망고,바나나,수박   3,2,1

	- 테이블 생성
	create table normal_customer00 (
		userno number,
		username varchar2(30),
		buyname varchar2(100),
		buycnt varchar2(50)
	);
	
	- 복사테이블 구조만 가져와서 생성
	create table normal_customer01
	as select * from normal_customer00 where 1=0;

	- 복사테이블 구조 수정
	alter table normal_customer01 
	modify buycnt number; 
	
	- 데이터 입력
	insert into normal_customer01 values(1000, '홍길동', '사과', 5);
	insert into normal_customer01 values(1000, '홍길동', '바나나', 4);
	insert into normal_customer01 values(1000, '홍길동', '딸기', 3);
	insert into normal_customer01 values(1001, '김길동', '오렌지', 5);
	insert into normal_customer01 values(1001, '김길동', '수박', 3);
	insert into normal_customer01 values(1001, '김길동', '키위', 2);
	insert into normal_customer01 values(1002, '신길동', '망고', 3);
	insert into normal_customer01 values(1002, '신길동', '바나나', 2);
	insert into normal_customer01 values(1002, '신길동', '수박', 1);
	
	
	- 풀이
	제 1정규화로 테이블을 나누면서 데이터도 나눠버림 
	제 2정규화로 구매번호를 추가하여
	1) 비식별자 관계처리 
	구매테이블 : 구매번호, 고객번호, 물건번호, 구매갯수
	물건테이블 : 물건번호, 물건명, 가격
	
	2) 식별자 관계처리
	구매테이블 : 고객번호, 물건번호, 구매갯수
	물건테이블 : 물건번호, 물건명, 가격

4. 아래 테이블을 정규화 과정(제1정규화,제2정규화)을 거쳐 테이블을 구성하세요.
물건번호  물건명   가격     계약번호  구매자아이디   구매자명    구매갯수
1000    사과     3000    A100    himan       홍길동    2
1001    바나나    4000   A101    higirl      김영희    5
1001    바나나    4000   A102    gooodman    오영희    6
1002    오렌지    2000   A103    badboy      신영철    5


	1) 기본테이블 
	create table normal_product00 (
		prono number,
		proname varchar2(50),
		proprice number,
		conno char(30),
		buyerid varchar2(50),
		buyername varchar2(50),
		buycnt number
	);
	
	2) 1정규화 : 중복되는 컬럼 데이터가 있으므로 별개의 테이블로 생성
	물건테이블
	create table normal_product01 
	as select distinct prono, proname, proprice 
	from normal_product00;
	
	구매테이블
	create table normal_buyer01
	as select conno, buyerid, buyername, buycnt
	from normal_product00;
	
	3) 2정규화 : 완전 함수 종속성을 만족하기 위해 테이블 분리
	구매자테이블
	create table normal_buyer02 
	as select buyid, buyname
	from normal_buyer01;
	
	
	create table normal_contract02
	as select conno, buyid, buycnt
	from normal_buyer01;
	

~ 09:20 

*/