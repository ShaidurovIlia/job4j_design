create table devices(
id serial primary key,
name varchar(255),
price float
);

create table people(
id serial primary key,
name varchar(255)
);

create table devices_people(
id serial primary key,
devices_id int references devices(id),
people_id int references people(id)
);

insert into devices(name, price) values ('Pfone', 5500);
insert into devices(name, price) values ('Headset', 4600);
insert into devices(name, price) values ('Camera', 7300);
insert into devices(name, price) values ('Iron', 2500);
insert into people(name) values ('Alia');
insert into people(name) values ('Anton');
insert into people(name) values ('Maria');
insert into people(name) values ('Artur');
insert into devices_people(devices_id, people_id) values (1, 2);
insert into devices_people(devices_id, people_id) values (3, 1);
insert into devices_people(devices_id, people_id) values (2, 2);
insert into devices_people(devices_id, people_id) values (2, 3);
insert into devices_people(devices_id, people_id) values (3, 2);
insert into devices_people(devices_id, people_id) values (1, 3);

select avg(price) price from devices;

select p.name, avg(d.price)
from devices_people as dp
join people p
on dp.people_id = p.id
join devices d
on dp.devices_id = d.id
group by p.name;

select p.name, avg(d.price)
from devices_people as dp
join people p
on dp.people_id = p.id
join devices d
on dp.devices_id = d.id
group by p.name
having avg(d.price) > 5000;