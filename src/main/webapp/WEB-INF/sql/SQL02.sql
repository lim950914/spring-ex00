USE spr1;

SELECT * FROM tbl_board
ORDER BY bno DESC
LIMIT 0, 5; -- 0번부터 상위 5개만 (1page) (ASC 하위 5개)

SELECT * FROM tbl_board
ORDER BY bno DESC
LIMIT 5, 5; -- 5번부터 상위 5개만 (2page)

SELECT * FROM tbl_board
ORDER BY bno DESC
LIMIT 10, 5; -- 10번부터 상위 5개만 (3page)

SELECT * FROM tbl_board
ORDER BY bno DESC;
-- LIMIT 5 * (n-1), 5; -- (n page)

SELECT * FROM tbl_board;












