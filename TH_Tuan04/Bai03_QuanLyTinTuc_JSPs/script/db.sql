CREATE TABLE DANHMUC (
    MADM INT PRIMARY KEY,
    TENDANHMUC NVARCHAR(100),
    NGUOIQUANLY NVARCHAR(100),
    GHICHU NVARCHAR(255)
);


CREATE TABLE TINTUC (
    MATT INT PRIMARY KEY,
    TIEUDE NVARCHAR(100),
    NOIDUNGTT NVARCHAR(255),
    LIENKET NVARCHAR(255),
    MADM INT,
    FOREIGN KEY (MADM) REFERENCES DANHMUC(MADM)
);

INSERT INTO DANHMUC (MADM, TENDANHMUC, NGUOIQUANLY, GHICHU) 
VALUES (1, 'Thể thao', 'Nguyen Van A', 'Chuyên mục thể thao'), 
       (2, 'Công nghệ', 'Tran Van B', 'Chuyên mục công nghệ');

INSERT INTO TINTUC (MATT, TIEUDE, NOIDUNGTT, LIENKET, MADM) 
VALUES (1, 'Tin thể thao 1', 'Nội dung tin thể thao 1', 'http://thethao1.com', 1),
       (2, 'Tin công nghệ 1', 'Nội dung tin công nghệ 1', 'http://congnghe1.com', 2);

