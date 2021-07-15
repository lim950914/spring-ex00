USE spr1;
-- 전체 게시물
SELECT * FROM tbl_board
ORDER BY bno DESC;

-- 제목 검색  (% 는 아무거나)
SELECT * FROM tbl_board
WHERE title LIKE '%자바%'
ORDER BY bno DESC
LIMIT 0, 10;

-- 제목 본문 검색
SELECT * FROM tbl_board
WHERE 
title LIKE '%제목%'
OR content LIKE '%제목%'
ORDER BY bno DESC;

-- 제목 본문 작성자 검색
SELECT * FROM tbl_board
WHERE 
title LIKE '%제목%'
OR content LIKE '%제목%'
OR writer LIKE '%임찬%'
ORDER BY bno DESC
LIMIT 0, 10;

SELECT * FROM tbl_board
WHERE writer LIKE '%영%'
ORDER BY bno DESC
LIMIT 0, 10;

-- CONCAT 함수 string 이어줌
SELECT concat('a', 'b');
SELECT concat('a', 'qwe' 'b');
SELECT 'a' + 'java'; -- + 연산자 사용x











