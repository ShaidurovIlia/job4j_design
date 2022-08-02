create table if not exists fauna
(
    id   serial primary key,
    name text,
	avg_age int,
	discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values('stork', 7300, date'1845-09-12');
insert into fauna(name, avg_age, discovery_date)
values('anaconda', 1500, date'1835-05-06');
insert into fauna(name, avg_age, discovery_date)
values('hippopotamus', 14500, date'1825-05-11');
insert into fauna(name, avg_age, discovery_date)
values('polar bear', 12000, date'1774-09-12');
insert into fauna(name, avg_age, discovery_date)
values('wolf', 7000, date'1784-03-12');
insert into fauna(name, avg_age, discovery_date)
values('gorilla', 14000, date'1778-07-07');
insert into fauna(name, avg_age, discovery_date)
values('raccoon', 1200, null);
insert into fauna(name, avg_age, discovery_date)
values('hare', 3000, date'1824-05-18');
insert into fauna(name, avg_age, discovery_date)
values('fish', 1000, date'1714-01-01');

select * from fauna where name LIKE '%fish';
select * from fauna where avg_age > 10000 AND avg_age < 21000;
select * from fauna where discovery_date is null;
select * from fauna where discovery_date < '1950.01.01';
