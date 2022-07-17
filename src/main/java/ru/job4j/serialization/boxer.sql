create table boxer(
	id serial primary key, 
	name varchar(255),
	age int,
	professional bool
);
select * from boxer; 
insert into boxer(name, age, professional) values('Maik Taison', 56, true);
select * from boxer;
update boxer set age = 57;
delete from boxer;
select * from boxer;
