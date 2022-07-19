create table car(
id serial primary key,
name_car varchar(255)
);

create table owner(
id serial primary key,
name varchar(255),
position_id int references car(id)
);

insert into car(name_car) values('Mercedes');
insert into car(name_car) values('BMW X5');
insert into car(name_car) values('Audi Q7');

select * from car;

insert into owner(name, position_id) values('Ivan', 1);
insert into owner(name, position_id) values('Maxim', 2);
insert into owner(name, position_id) values('Katya', 3);

select * from owner;
select * from car where id in (select id from owner);