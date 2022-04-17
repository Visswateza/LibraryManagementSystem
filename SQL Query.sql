create database Library;
use Library;

create table Books(ISBN varchar(13), 
	bid int primary key, title varchar(100), edition int, 
    publisher varchar(50), author varchar(50),bstatus varchar(15) default "Available");
create table Users(Uusername varchar(30) primary key,
	Upass varchar(20), UName varchar(30), DOB date, 
    address varchar(50), phone varchar(10));
create table Staff(Susername varchar(30) primary key, 
	Spass varchar(20), SName varchar(30), DOB date, 
    address varchar(50), phone varchar(20));
create table Lending(Luser varchar(30), staff varchar(30), 
	bid int , LendDate date, 
	foreign key(bid) references Books(bid), 
    foreign key(Luser) references Users(Uusername), 
    foreign key(staff) references Staff(Susername));




SELECT Upass FROM Users WHERE Uusername like 'viswa123';

select max(bid) from Books;
select * from Users;
select * from Books;
select * from Staff;
select * from Lending;

desc Books;
desc Users;
desc Staff;
desc Lending;

drop table Lending;
drop table Users;
drop table Staff;
drop table Books;

select * from Books;


insert into Books values("98456789",3,"Java",8,"cengage","someone",default);
select ISBN, title, author, edition, publisher from Books where title like "%c%" group by ISBN;

select B.bid, B.title, L.LendDate from Books B, Lending L where L.bid = B.bid and L.Luser = 'viswa';
set SQL_SAFE_UPDATES = 0;
UPDATE Books set bstatus = "Available";

show tables;