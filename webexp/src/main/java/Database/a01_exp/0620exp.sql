
/*

# 정리문제
1. 무결성 제약 조건 5가지의 기본개념과 형식을 기술하세요.
	무결성 제약 조건 5가지 기본개념
	(1) 데이터의 정확성과 일관성을 보장

	(2) 데이터 정확성을 유지하여 다양한 종류의 업무규칙을 고려함
		1) student 테이블에서 학년 데이터는 1, 2, 3, 4 중의 하나만 입력
		2) 모든 학번은 유일하게 처리
		3) student 테이블의 지도교수 번호는 progessor 테이블의 교수번호 중의 하나와 반드시 일치

	(3) 데이터 무결성 제약조건의 장점
		1) 테이블 생성시 무결성 제약조건을 정의 가능
			- 생성 후 제약조건 설정도 가능
		2) 테이블에 대해 정의, 데이터 딕셔너리에 저장되므로
			응용 프로그램에서 입력된 모든 데이터에 대해 동일하게 적용
		3) 제약조건을 활성화, 비활성화할 수 있는 융통성이 있다.

	(4) 무결성 제약조건의 종류
		1) not null : 열이 null을 포함할 수 없음
		2) unique key : 테이블의 모든 행에서 고유한 값을 갖는 열 또는 열조합을
			지정해야한다. ex) 학번, 주민번호, 사원번호가 중복되지 않아야한다.
		3) primary key : 해당 컬럼 값은 반드시 존재해야 하며 유일해야한다
			not null과 unique가 결합된 형태
		4) foreign key : 한 열과 참조된 테이블의 열간에 외래 키 관계를 설정하고 시행
			ex) 사원의 테이블의 부서번호는 반드시 부서테이블에 있는 부서번호여야한다. 
		5) check : 해당 컬럼에 저장 가능한 데이터 값의 범위나 조건을 지정처리
			ex) student 테이블의 학년을 1, 2, 3, 4만 데이터로 넣을 수 있다.
	
	(5) 설정 형식
		1) 컬러명 데이터타입 constraint 제약조건명 제약조건
		2) primary key 지정
	 		ex) create table student(
	 			stuno number constraint student_stuno_pk primary key
	 			); 
	 		
	 		제약조건 이름 : 테이블명_컬럼명_제약조건종류
	 		제약조건 종류: pk, uq, nn, fk 
	 		
	 (6) 형식
	 	create table 테이블명 (
	 		컬럼명 데이터유형 constraint 테이블명_컬럼명_제약조건약자 제약조건
	 	);
	 		
2. 학생테이블과 학과정보테이블을 활용해 위 무결성 제약 조건을 설정해보세요.
    학생테이블(학생번호,이름,학년,주민번호,학과정보번호)
    학과정보테이블(학과정보번호,학과명,학과위치)
    
    
3. 시퀀스를 9999~1001 범위로 작성하세요.


*/

-- 2. 
CREATE TABLE classInfo01(
	classno NUMBER PRIMARY KEY,
	classname varchar2(50),
	classloc varchar2(100)
);

INSERT INTO classInfo01 values(10, '사회과', '본관');
INSERT INTO classInfo01 values(20, '체육과', '별관');
INSERT INTO classInfo01 values(30, '컴공과', '신관');

CREATE TABLE student09 (
	sno NUMBER CONSTRAINTS student09_sno_pk PRIMARY key,
	name varchar2(30),
	grade NUMBER CHECK(grade BETWEEN 1 AND 4),
	pno NUMBER,
	sclassno NUMBER CONSTRAINT student09_sclassno_fk REFERENCES classInfo01 
);

INSERT INTO student09 values(1, '홍길동', 2, 1345, 20);


-- 3. 
CREATE SEQUENCE seq_10
	INCREMENT BY -1
	START WITH 9999
	MINVALUE 1
	MAXVALUE 9999;
	
SELECT seq_10.nextval FROM dual;