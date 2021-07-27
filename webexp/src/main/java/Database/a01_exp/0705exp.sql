
/*
#지난주  핵심 정리
1. 프로젝트에 사용할 계정을 생성하려고 한다. 
prj_user01/8888을 기준으로 계정을 생성하고 테이블을 작성하여 
데이터를 입력하려고 한다. 서버에서 설정할 내용을 기술하기

create user prj_user01 IDENTIFIED BY 8888;
GRANT CREATE SESSION TO prj_user01;
GRANT ReSOURCE TO prj_user01; 
alter user prj_user01 default tablespace users; 
alter user prj_user01 quote unlimited on users;

2. DOM객체의 다중 설정과 단일 설정 처리를 데이블 tr, td 기준으로 처리하여 출력하기

3. css의 후손 선태가 선언방식 2가지 기술하기

4. 선택자 중 h4 중에서 class=cls01로 설정하고자 한다. 해당 내용을 처리하기

5. 가상 선택자 3가지 유형을 기술하기 


6. 테이블 제약조건 유형을 기술하기
	1) not null : 열이 null을 포함할 수 없음
	2) unique key : 테이블의 모든 행에서 중복되지 않고 고유한 값을 갖는 열 또는 열조합을
		지정해야한다. 예를 들면 학번, 주민번호 같은 번호는 중복되지 않게 생성해야한다.
	3) primary key : 해당 컬럼 값은 반드시 존재해야 하며 유일해야한다.
		not null과 unique가 결합된 형태이다.
		주로 테이블에서 식별해야할 컬럼 즉, key를 설정할 때 사용된다.
		예를 들면 emp테이블의 empno, dept테이블의 deptno가 있다.
	4) foreign key : 한 열과 참조된 테이블의 열간에 외래 키 관계를 설정하고 시행
		예를 들면 사원의 테이블의 부서번호는 반드시 부서테이블에 있는 부서번호여야한다. 
	5) check : 해당 컬럼에 저장 가능한 데이터 값의 범위나 조건을 지정처리
	ex) student 테이블의 학년을 1, 2, 3, 4만 데이터로 넣을 수 있다.

7. 테이블 구조 변경 코드를 기본 예제(컬럼 추가, 컬럼 변경, 컬럼 삭제)로 기술하기
	(아래)
	
8. 인덱스의 생성 형태 기술하기
	(아래)

*/

-- 1. 
create user prj_user01 IDENTIFIED BY 8888;
GRANT CREATE SESSION TO prj_user01;
GRANT ReSOURCE TO prj_user01; 
alter user prj_user01 default tablespace users; 
alter user prj_user01 quote unlimited on users;

-- 7.
CREATE TABLE emp_0705
AS SELECT * FROM emp;

-- 컬럼 추가 
ALTER TABLE emp_0705 
ADD loc varchar2(20) DEFAULT '입력X';

SELECT * FROM emp_0705;

-- 컬럼 변경
ALTER TABLE emp_0705
MODIFY empno varchar2(20);

-- 컬럼 삭제
ALTER TABLE emp_0705
DROP COLUMN job;


-- 8. 	
create index emp_0705
on emp_0705(empno);

SELECT *
FROM user_ind_columns 
WHERE table_name = 'EMP_0705';