CREATE DATABASE BUSANGIANTS;
USE BUSANGIANTS;

CREATE TABLE ADMIN(
	ADMIN_ID	VARCHAR(255) PRIMARY KEY,
	PASSWD		VARCHAR(255),				# NOT NULL
	JOIN_DT		TIMESTAMP

);

INSERT INTO ADMIN VALUES ('jjw2025' , 'j@ngjiw0n' , NOW());

CREATE TABLE MEMBER(
	MEMBER_ID			VARCHAR(255) PRIMARY KEY,
	MEMBER_NM			VARCHAR(255),		# NOT NULL
	PASSWD				VARCHAR(255),		# NOT NULL UNIQUE
	SEX					VARCHAR(1),		# NOT NULL
	DATE_BIRTH			VARCHAR(10),		# NOT NULL
	PHONE_NO			VARCHAR(255),
	EMAIL				VARCHAR(255),
	JOIN_DT				TIMESTAMP			# NOT NULL
	
);

CREATE TABLE NOTICE(
	NOTICE_NO			VARCHAR(5000),		# NOT NULL
	NOTICE_TITLE		VARCHAR(50),		# NOT NULL
	NOTICE_CONTENTS		VARCHAR(500),		# NOT NULL
	NOTICE_FILE			VARCHAR(5000),		# NOT NULL
	NOTICE_READ_CNT		VARCHAR(5000),		# NOT NULL
	NOTICE_REGISTER_DT	TIMESTAMP			# NOT NULL
	
);

CREATE TABLE BOARD(
	BOARD_NO			VARCHAR(5000),		# NOT NULL
	BOARD_TITLE			VARCHAR(50),		# NOT NULL
	BOARD_CONTENTS		VARCHAR(500),		# NOT NULL
	BOARD_FILE			VARCHAR(500),		# NOT NULL
	BOARD_READ_CNT		VARCHAR(5000),		# NOT NULL
	BOARD_REGISTER_DT	TIMESTAMP			# NOT NULL

);

CREATE TABLE COMMENT(
	COMMENT_NO			VARCHAR(5000),		# NOT NULL
	COMMENT_NICKNAME	VARCHAR(10),		# NOT NULL
	COMMENT_CONTENTS	VARCHAR(500),		# NOT NULL
	COMMENT_READ_CNT	VARCHAR(5000),		# NOT NULL
	COMMENT_REGISTER_DT	TIMESTAMP			# NOT NULL

);

CREATE TABLE SCORE(
	SCORE_NO			VARCHAR(5000),		# NOT NULL
	SCORE_NICKNAME		VARCHAR(20),		# NOT NULL
	SCORE_TITLE			VARCHAR(50),		# NOT NULL
	SCORE_FILE			VARCHAR(500),		# NOT NULL
	SCORE_READ_CNT		VARCHAR(5000),		# NOT NULL
	SCORE_REGISTER_DT	TIMESTAMP			# NOT NULL

);

CREATE TABLE MATCHES(
	MATCHES_NO			VARCHAR(50),		# NOT NULL
	MATCHES_NICKNAME	VARCHAR(20),		# NOT NULL
	MATCHES_FILE		VARCHAR(500),		# NOT NULL
	MATCHES_READ_CNT	VARCHAR(5000),		# NOT NULL
	MATCHES_REGISTER_DT	TIMESTAMP			# NOT NULL

);

CREATE TABLE HIGHLIGHT(
	HIGHLIGHT_NO			VARCHAR(5000),		# NOT NULL
	HIGHLIGHT_NICKNAME		VARCHAR(20),		# NOT NULL
	HIGHLIGHT_TITLE			VARCHAR(50),		# NOT NULL
	HIGHLIGHT_FILE			VARCHAR(500),		# NOT NULL
	HIGHLIGHT_READ_CNT		VARCHAR(5000),		# NOT NULL
	HIGHLIGHT_REGISTER_DT	TIMESTAMP			# NOT NULL

);

CREATE TABLE REGISTRATION(
	REGISTRATION_NO				VARCHAR(5000),		# NOT NULL
	REGISTRATION_NICKNAME		VARCHAR(20),		# NOT NULL
	REGISTRATION_TITLE			VARCHAR(50),		# NOT NULL
	REGISTRATION_CONTENT		VARCHAR(500),		# NOT NULL
	REGISTRATION_FILE			VARCHAR(500),		# NOT NULL
	REGISTRATION_READ_CNT		VARCHAR(5000),		# NOT NULL
	REGISTRATION_REGISTER_DT	TIMESTAMP			# NOT NULL
	

);