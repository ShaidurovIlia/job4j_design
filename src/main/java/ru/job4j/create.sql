create table role(
	id serial primary key,
	nameRole text
);

create table prevelege(
	id serial primary key,
	namePrevelege text
);

create table state(
	id serial primary key,
	status text
);

create table cotegory(
	id serial primary key,
	name text
);

create table users(
	id serial primary key,
	name text,
	lastName text,
	age int,
	role_id int references role(id)
);

create table prevelege_role(
	id serial primary key,
	role_id int references role(id),
	prevelege_id int references prevelege(id)
);

create table item(
	id serial primary key,
	textItem text,
	users_id int references users(id),
	cotegory_id int references cotegory(id),
	state_id int references state(id)
);

create table comments(
	id serial primary key,
	textComments text,
	item_id int references item(id)
);

create table attachs(
	id serial primary key,
	nameFile text,
	size int,
	item_id int references item(id)
);

	
	
	
	

	
	