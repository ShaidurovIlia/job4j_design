create table account(
id serial primary key,
name varchar(255)
);

create table parole(
id serial primary key,
pass int
);

create table account_parole(
id serial primary key,
account_id int references account(id) unique,
parole_id int references parole(id) unique
);

insert into parole(pass) values(2345);
insert into account(name) values('Ilia');
insert into account_parole(account_id, parole_id) values(1, 1);
select * from account_parole;

