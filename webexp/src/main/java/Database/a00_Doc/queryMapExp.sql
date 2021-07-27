
-- emp 테이블의 deptno와
SELECT *
FROM emp;

-- dept 테이블의 deptno가 있으니 합치는게 좋을까?
SELECT *
FROM dept; 

-- 부서정보가 사원테이블에 통합된 경우에 
-- 부서명을 변경한다고 가정하면 어떻게 되는지?
SELECT a.*, b.dname, b.loc
FROM emp a, dept B 
WHERE a.deptno = b.deptno;
-- join된 테이블로 dept 테이블의 부서명만 바꾸면 다 바뀜.
-- 현업에 가면 데이터수가 어마무시하기 때문에 효율적인 관리를 위해서 사용 