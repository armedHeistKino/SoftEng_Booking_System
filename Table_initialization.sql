create user 'res_master'@'localhost' identified by 'res_manager' ;

CREATE DATABASE BOOKING_SYSTEM character set = utf8;

grant all privileges on BOOKING_SYSTEM.* to 'res_master'@'localhost' ;

USE BOOKING_SYSTEM ;

CREATE TABLE `Table` (
	oid 			INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    number			INT NOT NULL,
    places			INT NOT NULL,
    
    unique key(number)
) ;

CREATE TABLE Customer (
	oid				INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	phoneNumber		CHAR(14) NOT NULL,
    password		VARCHAR(20) NOT NULL,
    name			VARCHAR(30) NOT NULL, 
    
    unique key(phoneNumber)   
) ;

INSERT INTO Customer
VALUES ("0000-0000-0000", "00", "현장손님") ;

CREATE TABLE Placement (
	oid				INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    table_oid		INT NOT NULL,
    customer_oid	INT NOT NULL,
    
	placed_time		DATETIME NOT NULL,
    quit_time		DATETIME NOT NULL
) ;


INSERT INTO `Table` (number, places) VALUES (1, 2) ;
INSERT INTO `Table` (number, places) VALUES (2, 2) ;
INSERT INTO `Table` (number, places) VALUES (3, 2) ;
INSERT INTO `Table` (number, places) VALUES (4, 2) ;
INSERT INTO `Table` (number, places) VALUES (5, 4) ;
INSERT INTO `Table` (number, places) VALUES (6, 4) ;
INSERT INTO `Table` (number, places) VALUES (7, 4) ;
INSERT INTO `Table` (number, places) VALUES (8, 4) ;
INSERT INTO `Table` (number, places) VALUES (9, 4) ;
INSERT INTO `Table` (number, places) VALUES (10, 4) ;
