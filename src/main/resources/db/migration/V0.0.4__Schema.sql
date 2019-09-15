-- schema

CREATE TABLE ITEM (
    ID              INT PRIMARY KEY,
    TITLE           VARCHAR(250) NOT NULL,
    ALBUM_ID        VARCHAR(250) NOT NULL,
    ARTIST_ID       CHAR(8) NOT NULL,
    GENRE_ID        CHAR(8),
    PRICE           INT,
    RELEASE_DATE    DATE,
);

CREATE TABLE ALBUM (
    ID          INT PRIMARY KEY,
    TITLE       VARCHAR(250) NOT NULL,
    JACKET_IMG  VARCHAR(256),
);

CREATE TABLE ARTIST (
    ID      INT PRIMARY KEY,
    TITLE   VARCHAR(250) NOT NULL,
);

CREATE TABLE GENRE (
    ID      INT PRIMARY KEY,
    TITLE   VARCHAR(250) NOT NULL,
);

CREATE TABLE ORDER_TICKET (
    ID              INT AUTO_INCREMENT PRIMARY KEY,
    CREATED_AT      TIMESTAMP NOT NULL,
    TOTAL_PRICE     INT NOT NULL,
    DELIVERY_CHARGE INT NOT NULL,
    ZIPCODE         VARCHAR(7) NOT NULL,
    PREFECTURE_ID   INT NOT NULL,
    ADDRESS         VARCHAR(500) NOT NULL,
    TELEPHONE       VARCHAR(12) NOT NULL,
    NAME            VARCHAR(250) NOT NULL,
    CARD_NUMBER     VARCHAR(16) NOT NULL,
    CARD_EXPIRATION CHAR(4) NOT NULL,
    DELETED         BOOLEAN DEFAULT FALSE NOT NULL,
);

CREATE TABLE ORDER_DETAIL (
    ID          INT AUTO_INCREMENT PRIMARY KEY,
    ORDER_ID    INT NOT NULL,
    ITEM_ID     INT NOT NULL,
    AMOUNT      INT NOT NULL,
    DELETED     BOOLEAN DEFAULT FALSE NOT NULL,
);

CREATE TABLE PREFECTURE (
    ID      INT PRIMARY KEY,
    TITLE   VARCHAR(25) NOT NULL,
);

-- data

INSERT INTO ITEM (ID, TITLE, ALBUM_ID, ARTIST_ID, GENRE_ID, PRICE, RELEASE_DATE) VALUES
(1, 'Title 1', 1, 1, 1, 300, TO_DATE('2019/01/01', 'YYYY/MM/DD')),
(2, 'Title 2', 2, 2, 1, 300, TO_DATE('2021/12/31', 'YYYY/MM/DD')),
(3, 'Title 3', 2, 2, 1, 300, TO_DATE('2019/01/01', 'YYYY/MM/DD')),
(4, 'Title 4', 1, 1, 2, 400, TO_DATE('2019/01/01', 'YYYY/MM/DD')),
(5, 'Title 5', 2, 2, 2, 300, TO_DATE('2019/02/01', 'YYYY/MM/DD')),
(6, 'Title 6', 1, 1, 3, 200, TO_DATE('2019/03/01', 'YYYY/MM/DD')),
(7, 'Title 7', 2, 2, 3, 300, TO_DATE('2019/03/01', 'YYYY/MM/DD')),
(8, 'Title 8', 1, 1, 1, 500, TO_DATE('2019/02/01', 'YYYY/MM/DD'));

INSERT INTO ALBUM (ID, TITLE, JACKET_IMG) VALUES
(1, 'Album 1', '/image/album_1.jpg'),
(2, 'Album 2', '/image/album_2.jpg');

INSERT INTO ARTIST (ID, TITLE) VALUES
(1, 'Artist 1'),
(2, 'Artist 2');

INSERT INTO GENRE (ID, TITLE) VALUES
(1, 'POP'),
(2, 'Rock'),
(3, 'R&B');

INSERT INTO PREFECTURE (ID, TITLE) VALUES
(1, '北海道'),
(2, '青森県'),
(3, '岩手県'),
(4, '宮城県'),
(5, '秋田県'),
(6, '山形県'),
(7, '福島県'),
(8, '茨城県'),
(9, '栃木県'),
(10, '群馬県'),
(11, '埼玉県'),
(12, '千葉県'),
(13, '東京都'),
(14, '神奈川県'),
(15, '新潟県'),
(16, '富山県'),
(17, '石川県'),
(18, '福井県'),
(19, '山梨県'),
(20, '長野県'),
(21, '岐阜県'),
(22, '静岡県'),
(23, '愛知県'),
(24, '三重県'),
(25, '滋賀県'),
(26, '京都府'),
(27, '大阪府'),
(28, '兵庫県'),
(29, '奈良県'),
(30, '和歌山県'),
(31, '鳥取県'),
(32, '島根県'),
(33, '岡山県'),
(34, '広島県'),
(35, '山口県'),
(36, '徳島県'),
(37, '香川県'),
(38, '愛媛県'),
(39, '高知県'),
(40, '福岡県'),
(41, '佐賀県'),
(42, '長崎県'),
(43, '熊本県'),
(44, '大分県'),
(45, '宮崎県'),
(46, '鹿児島県'),
(47, '沖縄県');
