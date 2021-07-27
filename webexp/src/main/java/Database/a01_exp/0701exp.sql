
/*

#정리문제
1. 테이블 구조의 변경을 위해 컬럼을 추가하거나 삭제하는 기본 형식을 기술하기
- 테이블 컬럼 추가
ALTER TABLE emp15
ADD bonus NUMBER DEFAULT 0;

alter table 테이블명
add 컬럼명 데이터유형 디폴트값;

- 테이블 컬럼 삭제 
ALTER TABLE emp15
DROP COLUMN bouns;

alter table 테이블명
drop column 컬럼명;

2. 직책별 최저 급여자 정보테이블 emp16을 만들고 보너스, 
부서 컬럼을 삭제하고 부서명 컬럼을 추가하기

*/

DROP TABLE emp16;

CREATE TABLE emp16 
AS SELECT * FROM emp 
WHERE (job, sal) in (
	SELECT job, min(sal)
	FROM emp 
	GROUP BY job
);


SELECT job, min(sal)
FROM emp 
GROUP BY job;

SELECT * FROM emp16;

ALTER TABLE EMP16 
DROP COLUMN comm;

ALTER TABLE EMP16 
DROP COLUMN deptno;

ALTER TABLE EMP16 
add dname varchar2(100) DEFAULT '없음';
