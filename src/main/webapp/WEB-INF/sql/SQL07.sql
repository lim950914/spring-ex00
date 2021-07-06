USE spr1;

DESC tbl_board;

CREATE TABLE tbl_board_file (
	id INT PRIMARY KEY AUTO_INCREMENT,
    bno INT REFERENCES tbl_board(bno),
    fileName VARCHAR(200) NOT NULL
);

DESC tbl_board_file;

DELETE FROM tbl_board_file;

ALTER TABLE tbl_board_file
ADD FOREIGN KEY (bno) REFERENCES tbl_board(bno);

SELECT * FROM tbl_board_file;
SELECT * FROM tbl_board;