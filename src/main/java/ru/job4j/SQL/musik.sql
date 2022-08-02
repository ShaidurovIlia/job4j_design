create table musik
(
    id   serial primary key,
    name text,
	title text
);

create table if meloman
(
    id   serial primary key,
    name text,
	release_date int,
	musik_id int references musik(id)
);

insert into musik(name, title) values('AC/DC', 'back in black');
insert into musik(name, title) values('Linken Park', 'Numb');
insert into musik(name, title) values('Lumen', 'Гореть');

insert into meloman(name, musik_id) values('Ivan', 3);
insert into meloman(name, musik_id) values('Katya', 2);
insert into meloman(name, musik_id) values('Ilia', 1);

insert into meloman(name) values('Artur');

select * from meloman join musik mk on meloman.musik_id = mk.id;

select mm.name, mk.name from meloman as mm 
join musik as mk on mm.musik_id = mk.id;

select mm.name as "Имя", mk.name "Название_группы", mk.title "Название_песни"
from meloman as mm join musik as mk on mm.musik_id = mk.id;
