
/*

#sequence
1. 유일한 식별자 데이터를 만들기 위한 객체
2. 기본 키 값을 자동으로 생성하기 위해 일련번호를 생성한다
	ex) 웹 게시판에 key 글 번호를 순서대로 등록할 때 sequence를 
		활용하면 편리하다

3. 여러 테이블에서 공유 가능함

4. 기본 형식 
	create sequence 시퀀스명
		increment by 증가단위
		start with 시작번호
		maxvalue 최대값 | npmaxvalue
		minvalue 최소값 | nominvalue
		cycle | nocycle -- 반복여부 설정
		cache n | nocache -- 속도 개선을 위해 메모리 캐시 시퀀스수 설정

5. 선언된 sequence 사용 
	1) 시퀀스명.nextval : 현재 시퀀스번호를 출력하면서 다음 시퀀스 넘버링 처리(호출/넘버링)
	2) 시퀀스명.currval : 현재 시퀀스번호 출력
*/

CREATE SEQUENCE seq_01
	INCREMENT BY 1
	START WITH 1
	MINVALUE 1
	MAXVALUE 999999;
	
-- 계속 호출하면 번호가 증가됨
-- currval만 사용하면 증가하지 않지만 nextval은 증가함(넘버링) 
SELECT 
	seq_01.nextval, 
	seq_01.currval
FROM dual;


-- 응용1) 시작번호가 1001이고 마지막번호가 9999인 시퀀스를 만들고 실행하기 
-- 응용2) 시작번호가 8888이고 마지막번호 1000이고 카운트다운되는 시퀀스 생성하기
-- 응용3) 시작번호가 1이고 마지막번호가 50인 시퀀스가 5씩 증가되는 시퀀스 생성하기 (2조)

-- 1. 
CREATE SEQUENCE seq_02
	INCREMENT BY 1
	START WITH 1001
	MINVALUE 1001 
	MAXVALUE 9999;

SELECT seq_02.nextval FROM dual;

-- 2.
CREATE SEQUENCE seq_03 
	INCREMENT BY -1
	START WITH 8888
	MINVALUE 1000
	MAXVALUE 8888;
	
SELECT seq_03.nextval FROM dual; 

-- 3.
CREATE SEQUENCE seq_04
	INCREMENT BY 5
	START WITH 1
	MINVALUE 1
	MAXVALUE 50;
	
SELECT seq_04.nextval FROM dual;