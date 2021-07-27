

/*

어제 진도 복습

1. 함수 처리 nvl
	nvl(컬럼명, null일때 나올 데이터)
		숫자형 : nvl(comm, 0)
		문자형 : nvl(ename, '')
	null은 연산 처리가 되지 않기에 연산처리가 조건문에서 활용될 때 사용된다.
	ex) sal + nvl(comm,0) : 연산처리
		where nvl(comm,0) = 0; : 
			조건문에서 null값/0에 둘다 해당하는 데이터 검색처리

2. subquery

-- 부서별 최고 급여자 정보 표시
select deptno, max(sal)
from emp 
group by deptno;

select *
from emp 
where (deptno, sal) in (
select deptno, max(sal)
from emp 
group by deptno
);


응용할 수 있는 것) 직책별 최근에 입사한 사람들 출력
응용할 수 있는 것) 부서별로 최저 급여자들 정보 출력 


3. like & order by


4. 데이터 유형 
SYSDATE : 현재 오라클 시스템의 날짜를 저장하거나 불러올때 사용된다.
select ename, sysdate, hiredate
from emp; 

데이터 처리가 빠른건 고정형인 char 하지만 공백만큼 null이 들어가서 문제있음


5. student 테이블
select a.*, kor+eng+math "총계", round((kor+eng+math)/3, 1) "평균"
from student a


6. select
select 선택컬럼1, 선택컬럼2
from 테이블
where 조건컬럼1 = 데이터,
and 조건컬럼2 = 데이터;


*/
