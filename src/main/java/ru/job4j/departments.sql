create table if not exists departments
(
	id serial primary key,
	name varchar(255)
);
create table if not exists employees
(
id serial primary key,
name varchar(255),
department_id int references departments(id)
);

insert into departments (name) values
('Devolopment'),('Prodaction'),('Management'),('Accounting');

insert into employees(name, department_id) values('Ivan', 1), ('Egor', 2);
insert into employees(name, department_id) values('Olga', 3),('Artur', 1); 
insert into employees(name, department_id) values('Sveta', 2), ('Julia', null);

select * from employees e 
left join departments d 
on e.department_id=d.id;

select * from employees e 
right join departments d 
on e.department_id=d.id;

select * from employees e 
full join departments d 
on e.department_id=d.id;

select * from employees e 
cross join departments d;

select * from departments d 
left join employees e 
on e.department_id=d.id
where e.id is null;

select * from employees e
left join departments d
on e.department_id=d.id
where d.id is not null;

select e.name as Сотрудник,
d.name as Отдел
from employees e
left join departments d
on e.department_id=d.id;

select e.name as Сотрудник,
d.name as Отдел
from departments d
right join employees e
on e.department_id=d.id;

create table if not exists teens 
(
id serial primary key,
name varchar(255),
gender varchar(255)
);

insert into teens(name, gender) values('Oleg', 'M'), ('Egor', 'M');
insert into teens(name, gender) values('Katia', 'W'), ('Olga', 'W');
insert into teens(name, gender) values('Petr', 'M'), ('Nika', 'W');

select t1.name as Имя_M, t2.name as Имя_W 
from teens t1 cross join  teens t2
where t1.gender != t2.gender;