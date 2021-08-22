
-- 복습문제 전 실습문제
SELECT * FROM emp02;

SELECT *
FROM EMP02 
WHERE ename LIKE '%'|| ? ||'%'
AND job LIKE '%'|| ? ||'%'
ORDER BY empno DESC;

-- dept
SELECT *
FROM dept 
WHERE dname LIKE '%'|| ? ||'%'
AND loc LIKE '%'|| ? ||'%'
ORDER BY empno DESC;

SELECT * FROM dept;

-- 복습문제 7번용, 이미 있어서 안만듬
SELECT * FROM MEMBER;

