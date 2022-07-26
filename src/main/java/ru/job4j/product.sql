create table type
(
	id serial primary key,
	name varchar(255)
);

create table product
(
	id serial primary key,
	name varchar(255),
	type_id int references type(id),
	expired_date timestamp,
	price float
);

insert into type (name) values
('Молоко'), ('Сыр'),('Мороженое'), ('Колбасы'),
('Яйца'), ('Овощи'), ('Фрукты'), ('Натуральный сок');

insert into product (name, type_id, expired_date, price)
values
('Веселый молочник', 1, date '2022-07-21', 99),
('Докторская', 4, date '2021-07-05', 430),
('Сыр Масдам', 2, date '2020-07-14', 600),
('Мороженое Экзо', 3, date '2022-06-22', 99),
('Томаты розовые', 6, date '2022-07-25', 300),
('Добрый', 8, date '2023-03-11', 150),
('Сыр Пармезан',2, '2020-07-14', 700),
('Фруктовый Сад', 8, date '2022-12-22', 150),
('Яблоки', 7, date '2022-08-01', 250);

select t.name as Тип, p.name Название
from product p
join type t
on p.type_id=t.id
where t.name='Сыр';

select * from product
where name like '%Мороженое%';

select p.name as Название,
t.name as Тип,
p.expired_date as Годен_до
from product p
join type t
on p.type_id=t.id
where expired_date < current_date;

select p.name as Название,
p.price as Цена
from product p
where price = (select max(price) from product);

select t.name as Имя_типа,
count(p.type_id) as Количество
from product p
join type t
on p.type_id=t.id
group by t.name;

select t.name as Тип,
p.name as Название
from product p
join type t
on p.type_id=t.id
where t.name ='Сыр'
OR t.name = 'Молоко';

select t.name as Тип,
count(t.name) as Количество
from product p
join type t
on p.type_id=t.id
group by t.name
having count(t.name) < 10;

select * from product
join type t
on product.type_id=t.id;





