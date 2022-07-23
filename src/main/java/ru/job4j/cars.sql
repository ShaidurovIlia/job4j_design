create table bodies
(
	id serial primary key,
	name varchar(255)
);

create table engines
(
	id serial primary key,
	name varchar(255)
);

create table transmissions
(
	id serial primary key,
	name varchar(255)
);

create table cars
(
	id serial primary key,
	name varchar(255),
	body_id int references bodies(id),
	engine_id int references engines(id),
	transmission_id int references transmissions(id)
);

insert into bodies(name) values ('Пикап'), ('Седан'), ('Хэтчбек');
insert into engines(name) values ('Бензиновый'), ('Газовый'), ('Дизельный');
insert into transmissions(name) values ('Автоматическая'),('Механическая'), ('Роботизированная');

insert into cars(name, body_id, engine_id, transmission_id) 
values ('Опель','2', '1', '1'),
('Мазда','2', '2', null),
('БМВ','3', null, '1'),
('Ниссан','1', '3', '3');

select c.name Марка, t.name Трансмиссия,
e.name Двигатель, b.name Кузов
from cars c
left join bodies b on (c.body_id=b.id)
left join engines e on (c.engine_id=e.id)
left join transmissions t on (c.transmission_id=t.id);

select b.name 
from bodies b
left join cars c 
on (c.body_id=b.id)
where c.body_id is null;

select e.name
from engines e
left join cars c 
on (c.engine_id = e.id)
where c.engine_id is null;

select t.name
from transmissions t
left join cars c 
on (c.transmission_id = t.id)
where c.transmission_id is null;

